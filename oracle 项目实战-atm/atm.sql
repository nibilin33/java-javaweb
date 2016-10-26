create table Custom(
     usrId number primary key,
     usrname varchar2(20),
     cardid varchar2(18) unique,
     tel varchar2(20),
     adress varchar(80)
)
create sequence se_custom
increment by 1
start with 1
alter table Custom
drop constraint cu_cardid
--3.	身份证号码唯一，15或18位 
alter table Custom add constraint cu_cardid check(length(cardid)=15 or length(cardid)=18)
--查询表空间
select * from v$tablespace;
--//创建临时表空间
create temporary tablespace ts2013
tempfile 'G:\oracle\product\10.2.0\oradata\orcl\ts2013.dbf'
size 50m
autoextend on
next 50m maxsize 20480m
extent management local
--//创建数据表空间 
create tablespace test_data 
logging 
datafile 'G:\oracle\product\10.2.0\oradata\orcl\test_data01.dbf' 
size 32m 
autoextend on 
next 32m maxsize 2048m 
extent management local; 
alter user system default tablespace test_data;
create table BankCard(
add_date_time date,
bankid varchar2(24) primary key constraint c_bankid check( instr(bankid,'10103576',0)=0),
save_type varchar2(16) constraint c_type check ( save_type='活期' or save_type='定期' or save_type='定活两便'),
is_lose char(2) constraint c_islose check( is_lose in ('是','否')),
countmoney number(10,2) constraint c_money check (countmoney>1),
userid number,
moneytype varchar2(10),
passwords varchar2(20),
constraint u_foreign  foreign key(userid) references Custom(usrId) on delete cascade
)PARTITION BY RANGE (add_date_time)
(
  PARTITION t_test_2013 VALUES LESS THAN (TO_DATE('2016-01-01 00:00:00','yyyy-mm-ddhh24:mi:ss')) TABLESPACE test_data
 
 )
 alter table  BankCard drop constraint c_bankid
 alter table BankCard add constraint c_bankid check(instr(to_char(bankid),'10103576',0)=0)
 --增加表空间
alter table BankCard add partition t_test_2017 VALUES LESS THAN (TO_DATE('2017-01-01 00:00:00','yyyy-mm-ddhh24:mi:ss')) TABLESPACE test_data
--币种默认”RMB”  	密码默认888888  是否挂失默认：否
alter table BankCard modify moneytype varchar2(10) default 'RMB'
alter table BankCard modify passwords varchar2(20) default '888888'
alter table BankCard modify is_lose varchar2(2) default '否'

--测试：分别添加两条用户表，银行卡信息表
insert into Custom values(se_custom.nextval,'wro','111011111122231','235678','敌法呃呃呃')
insert into Custom values(se_custom.nextval,'weo','123456788678934','2345678','敌法呃dd呃呃')
insert into BankCard (add_date_time,bankid,save_type,countmoney,userid) values(sysdate,'101035769','活期',3,21)
insert into BankCard (add_date_time,bankid,save_type,countmoney,userid) values(sysdate,'101035769344','活期',3,7)
select * from custom;
select * from bankcard;

--1.	根据交易时间创建表分区2.	卡号为外键，关联银行卡信息表主键3.	交易类型只能是下面两种之一：存入，支取4.	交易金额必须大于0 5.	交易时间默认为当前时间
create table transition(
trTime date,
bankid varchar2(24),
trType char(4)constraint c_trtype check(trType in('存入','支取')),
trMoney number(10,2) constraint c_trmoney check (trMoney>0),
constraint t_forein foreign key(bankid)references BankCard(bankid) on delete cascade
)partition by range(trTime)(
partition t_transition values less than(TO_DATE('2016-01-01 00:00:00','yyyy-mm-ddhh24:mi:ss')) TABLESPACE test_data
)
drop table transition;
alter table transition add partition t_trainsin_9 VALUES LESS THAN (TO_DATE('2017-01-01 00:00:00','yyyy-mm-ddhh24:mi:ss')) TABLESPACE test_data
--1.创建 用户表表视图
create or replace view UserView 
as
select * from Custom
--2.创建银行卡信息表视图
create or replace view BankView
as
select * from BankCard
--3.创建交易信息表视图
create or replace view TrView
as 
select * from transition
--4.创建查询挂失的客户信息视图
create or replace view LoseView
as
select * from Custom where cardid = (select cardid from BankCard where  is_lose='是')
--5.创建 查询本周开户的卡号 显示相关信息视图
create or replace view TweekOpen
as
select * from BankCard,Custom where to_char(add_date_time,'yyyy-mm-w')=to_char(sysdate,'yyyy-mm-w') and BankCard.userid=Custom.usrid

select * from TweekOpen;
--6.创建 查询本月交易金额最高的卡号 的视图
create or replace view TopTr
as
select bankid from transition where trMoney=(select max(trMoney) from transition where to_char(trTime,'MM')=to_char(sysdate,'MM'))

--触发器
--1.不允许修改卡号：当更新的是银行卡信息表的卡号时提示“此列不允许修改”
--2.当交易信息表有插入或者修改记录，银行卡信息表跟随改变：
--如交易信息表新增一条支取，那么对应的银行信息卡余额应该减少对应支取的金额。
--同理如交易信息表新增一条存入，那么对应的银行信息卡余额应该增加对应存入的金额。
--注意：如果支取先判断余额，不足则提示。如交易成功打印恭喜信息。
create or replace trigger no_change_cardnumber
before 
update of bankid
on system.bankcard for each row
begin
  dbms_output.put_line('此列不允许修改');
  RAISE_APPLICATION_ERROR(-20001, '此列不允许修改');
end;

update bankcard set bankid='22' where userid=1;
create or replace trigger cast_triantion_triger
after
insert or update
on system.transition for each row
declare
temp bankcard.countmoney%type;
tr transition.trtype%type;
begin
  dbms_output.put_line('old value:' || :new.trMoney);
  dbms_output.put_line('old value:' || :new.bankid);
  tr:=:new.trtype;
 case tr
   when '支取'then
    select bankcard.countmoney into temp from bankcard where bankcard.bankid=:new.bankid;
     if temp<:new.trMoney then
     dbms_output.put_line('余额不足');
     else
       update bankcard set countmoney=countmoney-:new.trMoney where bankid=:new.bankid;
       dbms_output.put_line('恭喜');
     end if;
     when '存入' then
       update bankcard set countmoney=countmoney+:new.trMoney where bankid=:new.bankid;
        dbms_output.put_line('恭喜');
       else
         null;
         end case;
 end;
 
-- 测试：分别针对交易信息表做支取和存入的操作。
 insert into transition(trTime,bankid,trtype,trmoney) values(sysdate,'101035769','存入',30);
 insert into transition(trTime,bankid,trtype,trmoney) values(sysdate,'101035769','支取',40);
 select * from bankcard;
 

--to_char(dbms_random.value(1000,9999),’0000’)


--步骤四：创建针对用户信息的程序包及程序包主体内容
create or replace package bankcardp
is
function cardnumber
  return varchar2;
  procedure opcount(names varchar2,card varchar2,tels varchar2,ad varchar2,stype varchar2,smon number);
  procedure chpass(uids number,ps varchar2);
  procedure islose(uids varchar2,ps varchar2);
end;
create or replace package body bankcardp
is     
uot varchar2(24):='10103576';
v_number number:=1;
bcard varchar2(24);
checkpass bankcard.passwords%type;
--1.	创建函数：卡号随机生成，注意卡号的格式1010 3576 XXXX XXXX
function cardnumber
return varchar2
as
begin
while v_number<=2 loop
uot:=uot||replace(to_char(dbms_random.value(1000,9999),'0000'),' ','');
dbms_output.put_line(uot);
v_number:=v_number+1;
dbms_output.put_line(v_number);
end loop;
return uot;
end;
--2.	创建开户的存储过程：注意卡号调用上面函数，开户过程包含插入信息到用户表及银行卡信息表
procedure opcount(names varchar2,card varchar2,tels varchar2,ad varchar2,stype varchar2,smon number)
as
begin
  bcard:=cardnumber();
insert into custom(usrid,usrname,cardid,tel,adress) values(se_custom.nextval,names,card,tels,ad);
insert into bankcard(add_date_time,bankid,save_type,countmoney,userid) values (sysdate,bcard,stype,smon,se_custom.currval);
exception
when others then
dbms_output.put_line('创建失败');
end;
--3.	创建修改密码的存储过程
procedure chpass(uids number,ps varchar2)
as
begin
update bankcard set passwords=ps where bankid=uids;
IF SQL%NOTFOUND THEN
dbms_output.put_line('卡号不存在');
END IF;
end;
--4.	创建挂失账号的存储过程
procedure islose(uids varchar2,ps varchar2)
as
begin
select passwords into checkpass from bankcard where bankid=uids;
if (checkpass is not null and checkpass=ps)then
    update bankcard set bankcard.is_lose='是'where bankcard.bankid=uids;
end if;
exception
when no_data_found then
dbms_output.put_line('密码错误');
when others then
dbms_output.put_line('账号不存在');
end;
end;

--测试：执行开户的存储过程，执行修改密码的存储过程，执行挂失的存储过程
begin
  system.bankcardp.opcount('wanerr46','350181199604092043','13960845173','hahahahaa','活期',8);
  system.bankcardp.islose('101035769','888888');
 system.bankcardp.chpass('101035769','882228');
  end;
select * from bankcard;


--步骤五：创建针对银行卡信息表的程序包及程序包主体内容
create or replace package yinhang
is
  procedure inorout(bankid varchar2,mm number,mes char);
  procedure searchmoney(bankids varchar2);
  procedure trmoney(tmoney number,bankidfrom varchar2,bankidto varchar2);
  procedure countmoney(cycmoney out number,cycrest out number);
  procedure deuser(uu number);
end;
create or replace package body yinhang
is
 remoney system.bankcard.countmoney%type;
 bfrom system.bankcard.bankid%type;
 bto system.bankcard.bankid%type;
 trmo system.bankcard.countmoney%type;
 cin system.transition.trmoney%type;
 cou system.transition.trmoney%type;
 csum system.transition.trmoney%type:=0;
 cosum system.transition.trmoney%type:=0;
  cursor trmoney_cur
  is
  select transition.trmoney from transition where transition.trtype='存入';
  cursor trmoney_cor
  is
   select transition.trmoney from transition where transition.trtype='支取';
--1.	创建支取和存入的存储过程，注意只需要操作交易表，而银行卡信息表的余额由上面步骤三中的触发器维护
 procedure inorout(bankid varchar2,mm number,mes char)
  as
  begin
    insert into transition(trTime,bankid,trtype,trmoney) values(sysdate,bankid,mes,mm);
    end;

--2.	创建查询余额存储过程
 procedure searchmoney(bankids varchar2)
  as
  begin
   select countmoney into remoney from bankcard where bankcard.bankid=bankids;
  dbms_output.put_line('余额为：'||remoney);
   exception
     when no_data_found then
       dbms_output.put_line('账号错误');
   end;

--3.	创建转账存储过程，注意：判断要转账及要转入的账户是否都存在，转账金额是否充足，发生异常交易失败要回滚

procedure trmoney(tmoney number,bankidfrom varchar2,bankidto varchar2)
  as
begin
  select bankid into bfrom from bankcard where bankid=bankidfrom;
  select bankid into bto from bankcard where bankid=bankidto;
  select countmoney into trmo from bankcard where bankid=bankidfrom;
  update bankcard set countmoney=countmoney-tmoney where bankid=bankidfrom;
  update bankcard set countmoney=countmoney+tmoney where bankid=bankidto;
  if trmo<tmoney then
    rollback;
    end if;
   exception
     when no_data_found then
       dbms_output.put_line('账户不存在');
       end;

--4.	创建汇总存储过程（对于银行来说流通余额=所有存入-所有取出）（对于银行来说盈利结算=所有存入*0.003-所有支取*0.008）,
  procedure countmoney(cycmoney out number,cycrest out number )
    as
    begin
      open trmoney_cur;
     LOOP
      fetch trmoney_cur into cin;
       csum:=csum+cin;
      exit when trmoney_cur%notfound;
     END LOOP;
    close trmoney_cur;
    open trmoney_cor;
     LOOP
       fetch trmoney_cor into cou;
       cosum:=cosum+cou;
       exit when trmoney_cor%notfound;
      END LOOP;
   close trmoney_cor;
    cycmoney:=csum-cosum;
    cycrest:=csum*0.003-cosum*0.006;
   end;

--5.	创建销户存储过程，注意销户要删除用户信息表，银行卡信息表，交易信息表中于之相关的所有记录
      procedure deuser(uu number)
        as
        begin
          delete from custom where custom.usrid=uu;
          end;
end;


--测试：执行取钱和存钱的存储过程，执行查询余额的存储过程，执行转账的存储过程，执行汇总的存储过程，执行销户的存储过程

declare
cu number;
cm number;
begin
 -- system.yinhang.inorout('101035769',3,'支取');
 -- system.yinhang.inorout('101035769',3,'存入');
 -- system.yinhang.searchmoney('101035769');
     --system.yinhang.trmoney(4,'101035769','101035769344');
    -- system.yinhang.countmoney(cu,cm);
    -- dbms_output.put_line(cu||'---'||cm);
    -- system.yinhang.deuser(1);
  end;
 





