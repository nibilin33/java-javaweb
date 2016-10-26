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
--3.	���֤����Ψһ��15��18λ 
alter table Custom add constraint cu_cardid check(length(cardid)=15 or length(cardid)=18)
--��ѯ��ռ�
select * from v$tablespace;
--//������ʱ��ռ�
create temporary tablespace ts2013
tempfile 'G:\oracle\product\10.2.0\oradata\orcl\ts2013.dbf'
size 50m
autoextend on
next 50m maxsize 20480m
extent management local
--//�������ݱ�ռ� 
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
save_type varchar2(16) constraint c_type check ( save_type='����' or save_type='����' or save_type='��������'),
is_lose char(2) constraint c_islose check( is_lose in ('��','��')),
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
 --���ӱ�ռ�
alter table BankCard add partition t_test_2017 VALUES LESS THAN (TO_DATE('2017-01-01 00:00:00','yyyy-mm-ddhh24:mi:ss')) TABLESPACE test_data
--����Ĭ�ϡ�RMB��  	����Ĭ��888888  �Ƿ��ʧĬ�ϣ���
alter table BankCard modify moneytype varchar2(10) default 'RMB'
alter table BankCard modify passwords varchar2(20) default '888888'
alter table BankCard modify is_lose varchar2(2) default '��'

--���ԣ��ֱ���������û������п���Ϣ��
insert into Custom values(se_custom.nextval,'wro','111011111122231','235678','�з�������')
insert into Custom values(se_custom.nextval,'weo','123456788678934','2345678','�з���dd����')
insert into BankCard (add_date_time,bankid,save_type,countmoney,userid) values(sysdate,'101035769','����',3,21)
insert into BankCard (add_date_time,bankid,save_type,countmoney,userid) values(sysdate,'101035769344','����',3,7)
select * from custom;
select * from bankcard;

--1.	���ݽ���ʱ�䴴�������2.	����Ϊ������������п���Ϣ������3.	��������ֻ������������֮һ�����룬֧ȡ4.	���׽��������0 5.	����ʱ��Ĭ��Ϊ��ǰʱ��
create table transition(
trTime date,
bankid varchar2(24),
trType char(4)constraint c_trtype check(trType in('����','֧ȡ')),
trMoney number(10,2) constraint c_trmoney check (trMoney>0),
constraint t_forein foreign key(bankid)references BankCard(bankid) on delete cascade
)partition by range(trTime)(
partition t_transition values less than(TO_DATE('2016-01-01 00:00:00','yyyy-mm-ddhh24:mi:ss')) TABLESPACE test_data
)
drop table transition;
alter table transition add partition t_trainsin_9 VALUES LESS THAN (TO_DATE('2017-01-01 00:00:00','yyyy-mm-ddhh24:mi:ss')) TABLESPACE test_data
--1.���� �û������ͼ
create or replace view UserView 
as
select * from Custom
--2.�������п���Ϣ����ͼ
create or replace view BankView
as
select * from BankCard
--3.����������Ϣ����ͼ
create or replace view TrView
as 
select * from transition
--4.������ѯ��ʧ�Ŀͻ���Ϣ��ͼ
create or replace view LoseView
as
select * from Custom where cardid = (select cardid from BankCard where  is_lose='��')
--5.���� ��ѯ���ܿ����Ŀ��� ��ʾ�����Ϣ��ͼ
create or replace view TweekOpen
as
select * from BankCard,Custom where to_char(add_date_time,'yyyy-mm-w')=to_char(sysdate,'yyyy-mm-w') and BankCard.userid=Custom.usrid

select * from TweekOpen;
--6.���� ��ѯ���½��׽����ߵĿ��� ����ͼ
create or replace view TopTr
as
select bankid from transition where trMoney=(select max(trMoney) from transition where to_char(trTime,'MM')=to_char(sysdate,'MM'))

--������
--1.�������޸Ŀ��ţ������µ������п���Ϣ��Ŀ���ʱ��ʾ�����в������޸ġ�
--2.��������Ϣ���в�������޸ļ�¼�����п���Ϣ�����ı䣺
--�罻����Ϣ������һ��֧ȡ����ô��Ӧ��������Ϣ�����Ӧ�ü��ٶ�Ӧ֧ȡ�Ľ�
--ͬ���罻����Ϣ������һ�����룬��ô��Ӧ��������Ϣ�����Ӧ�����Ӷ�Ӧ����Ľ�
--ע�⣺���֧ȡ���ж�����������ʾ���罻�׳ɹ���ӡ��ϲ��Ϣ��
create or replace trigger no_change_cardnumber
before 
update of bankid
on system.bankcard for each row
begin
  dbms_output.put_line('���в������޸�');
  RAISE_APPLICATION_ERROR(-20001, '���в������޸�');
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
   when '֧ȡ'then
    select bankcard.countmoney into temp from bankcard where bankcard.bankid=:new.bankid;
     if temp<:new.trMoney then
     dbms_output.put_line('����');
     else
       update bankcard set countmoney=countmoney-:new.trMoney where bankid=:new.bankid;
       dbms_output.put_line('��ϲ');
     end if;
     when '����' then
       update bankcard set countmoney=countmoney+:new.trMoney where bankid=:new.bankid;
        dbms_output.put_line('��ϲ');
       else
         null;
         end case;
 end;
 
-- ���ԣ��ֱ���Խ�����Ϣ����֧ȡ�ʹ���Ĳ�����
 insert into transition(trTime,bankid,trtype,trmoney) values(sysdate,'101035769','����',30);
 insert into transition(trTime,bankid,trtype,trmoney) values(sysdate,'101035769','֧ȡ',40);
 select * from bankcard;
 

--to_char(dbms_random.value(1000,9999),��0000��)


--�����ģ���������û���Ϣ�ĳ�������������������
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
--1.	��������������������ɣ�ע�⿨�ŵĸ�ʽ1010 3576 XXXX XXXX
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
--2.	���������Ĵ洢���̣�ע�⿨�ŵ������溯�����������̰���������Ϣ���û������п���Ϣ��
procedure opcount(names varchar2,card varchar2,tels varchar2,ad varchar2,stype varchar2,smon number)
as
begin
  bcard:=cardnumber();
insert into custom(usrid,usrname,cardid,tel,adress) values(se_custom.nextval,names,card,tels,ad);
insert into bankcard(add_date_time,bankid,save_type,countmoney,userid) values (sysdate,bcard,stype,smon,se_custom.currval);
exception
when others then
dbms_output.put_line('����ʧ��');
end;
--3.	�����޸�����Ĵ洢����
procedure chpass(uids number,ps varchar2)
as
begin
update bankcard set passwords=ps where bankid=uids;
IF SQL%NOTFOUND THEN
dbms_output.put_line('���Ų�����');
END IF;
end;
--4.	������ʧ�˺ŵĴ洢����
procedure islose(uids varchar2,ps varchar2)
as
begin
select passwords into checkpass from bankcard where bankid=uids;
if (checkpass is not null and checkpass=ps)then
    update bankcard set bankcard.is_lose='��'where bankcard.bankid=uids;
end if;
exception
when no_data_found then
dbms_output.put_line('�������');
when others then
dbms_output.put_line('�˺Ų�����');
end;
end;

--���ԣ�ִ�п����Ĵ洢���̣�ִ���޸�����Ĵ洢���̣�ִ�й�ʧ�Ĵ洢����
begin
  system.bankcardp.opcount('wanerr46','350181199604092043','13960845173','hahahahaa','����',8);
  system.bankcardp.islose('101035769','888888');
 system.bankcardp.chpass('101035769','882228');
  end;
select * from bankcard;


--�����壺����������п���Ϣ��ĳ�������������������
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
  select transition.trmoney from transition where transition.trtype='����';
  cursor trmoney_cor
  is
   select transition.trmoney from transition where transition.trtype='֧ȡ';
--1.	����֧ȡ�ʹ���Ĵ洢���̣�ע��ֻ��Ҫ�������ױ������п���Ϣ�����������沽�����еĴ�����ά��
 procedure inorout(bankid varchar2,mm number,mes char)
  as
  begin
    insert into transition(trTime,bankid,trtype,trmoney) values(sysdate,bankid,mes,mm);
    end;

--2.	������ѯ���洢����
 procedure searchmoney(bankids varchar2)
  as
  begin
   select countmoney into remoney from bankcard where bankcard.bankid=bankids;
  dbms_output.put_line('���Ϊ��'||remoney);
   exception
     when no_data_found then
       dbms_output.put_line('�˺Ŵ���');
   end;

--3.	����ת�˴洢���̣�ע�⣺�ж�Ҫת�˼�Ҫת����˻��Ƿ񶼴��ڣ�ת�˽���Ƿ���㣬�����쳣����ʧ��Ҫ�ع�

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
       dbms_output.put_line('�˻�������');
       end;

--4.	�������ܴ洢���̣�����������˵��ͨ���=���д���-����ȡ����������������˵ӯ������=���д���*0.003-����֧ȡ*0.008��,
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

--5.	���������洢���̣�ע������Ҫɾ���û���Ϣ�����п���Ϣ��������Ϣ������֮��ص����м�¼
      procedure deuser(uu number)
        as
        begin
          delete from custom where custom.usrid=uu;
          end;
end;


--���ԣ�ִ��ȡǮ�ʹ�Ǯ�Ĵ洢���̣�ִ�в�ѯ���Ĵ洢���̣�ִ��ת�˵Ĵ洢���̣�ִ�л��ܵĴ洢���̣�ִ�������Ĵ洢����

declare
cu number;
cm number;
begin
 -- system.yinhang.inorout('101035769',3,'֧ȡ');
 -- system.yinhang.inorout('101035769',3,'����');
 -- system.yinhang.searchmoney('101035769');
     --system.yinhang.trmoney(4,'101035769','101035769344');
    -- system.yinhang.countmoney(cu,cm);
    -- dbms_output.put_line(cu||'---'||cm);
    -- system.yinhang.deuser(1);
  end;
 





