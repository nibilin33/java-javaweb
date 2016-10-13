/**
 * Created by Administrator on 2016/9/12.
 */
// 判断arr是否为一个数组，返回一个bool值
function isArray(arr) {
    // your implement
    return Array.isArray(arr);
}
console.log(isArray([1,2]));
// 判断fn是否为一个函数，返回一个bool值
function isFunction(fn) {
    // your implementc
    return Object.prototype.toString.call(fn)=== '[object Function]';
}

console.log(isFunction(isArray));
// 使用递归来实现一个深度克隆，可以复制一个目标对象，返回一个完整拷贝
// 被复制的对象类型会被限制为数字、字符串、布尔、日期、数组、Object对象。不会包含函数、正则对象等
function cloneObject(src) {
    // your implement
    var Result;
    switch(Object.prototype.toString.call(src)){
        case "[object Number]":
            Result = (typeof src === "object"?new Number(src):parseInt(src.toString()));
            break;
        case "[object String]":
            // 遍历字符串 =.= 好像没啥意义
            // {
            //  var temp = src.split("");
            //  var cloneString="";
            //  for(var i=0;i<temp.length;i++)
            //  {
            //      cloneString+=temp[i];
            //  }
            // }
            Result = (typeof src === "object"?new String(src):src.toString());
            break;
        case "[object Boolean]":
            Result = (typeof src === "Boolean"?new Boolean(src):src);
            break;
        case "[object Date]":
            Result = new Date(src);
            break;
        case "[object Array]":
            var temp = new Array();
            // Array.prototype.push.apply(temp,src);
            // 当使用for(var i=0,a;a = src[i++];) i会在a被赋值后就自动增加而不是
            // 等到一个循环完成再增加
            for(var i=0,a;a = src[i];i++)
            {
                // temp.push(cloneObject(a));
                // 使用push方法会让数组所有元素的类型变成undfined
                temp[i] = cloneObject(a);
            }
            Result = temp;
            delete temp;
            break;
        case "[object Object]":
            var temp = {};
            var keys = Object.keys(src);
            // keys 为对象src的键名字数组
            // 它是数组！！！
            for(var i=0,a;a=keys[i];i++)
            {
                temp[a] = cloneObject(src[a]);
            }
            Result = temp;
            delete temp;
            delete keys;
            break;
        default:
            break;
    }
    return Result;
   /* var result;
    switch(Object.prototype.toString.call(src)) {
        case "[Object Number]":
           result=new Number(src);break;
        case "[Object String]":
            result= new String(src);
            break;
        case "[Object Date]":
            result= new Date(src);
            break;
        case "[Object Boolean]":
            result=new Boolean(src);
            break;
        case "[Object Object]":
            var temp={};
              var keys=Object.keys(src);
            for(var i= 0,a;a=keys[i];i++){
                temp[a]=cloneObject(src[a]);
            }
            result=temp;
            delete temp;
            delete keys;
            break;
        case "[Object Array]":
            var temp=new Array();
            for(var i= 0,a;a=src[i];i++){
                temp[i]=cloneObject(a);
            }
            result=temp;
            delete temp;
            break;
        default:
            break;
    }
    return result;*/
}


// 测试用例：
var srcObj = {
    a: 1,
    b: {
        b1: ["hello", "hi"],
        b2: "JavaScript"
    }
};
var abObj = srcObj;
var tarObj = cloneObject(srcObj);

srcObj.a = 2;
srcObj.b.b1[0] = "Hello";

console.log(abObj.a);
console.log(abObj.b.b1[0]);

console.log(tarObj.a);      // 1
console.log(tarObj.b.b1[0]);    // "hello"
// 对数组进行去重操作，只考虑数组中元素为数字或字符串，返回一个去重后的数组
function uniqArray(arr) {
    // your implement
    var hash={},result=[],len=arr.length;
    for(var i=0;i<len;i++){
        if(!hash[arr[i]]) {
            hash[arr[i]] =true;
            result.push(arr[i]);
        }
    }
    return result;
}
var arr = [1, 2, 2, 3, 4, 5, 6, 6];

function getArray(a) {
    var hash = {},
        len = a.length,
        result = [];

    for (var i = 0; i < len; i++){
        if (!hash[a[i]]){
            hash[a[i]] = true;
            result.push(a[i]);
        }
    }
    return result;
}

console.log(getArray(arr)); // 输出[1， 2， 3， 4， 5， 6]

// 使用示例
var a = [1, 3, 5, 7, 5, 3];
var b = getArray(a);
console.log(b); // [1, 3, 5, 7]

// 中级班同学跳过此题
// 实现一个简单的trim函数，用于去除一个字符串，头部和尾部的空白字符
// 假定空白字符只有半角空格、Tab
// 练习通过循环，以及字符串的一些基本方法，分别扫描字符串str头部和尾部是否有连续的空白字符，并且删掉他们，最后返回一个完成去除的字符串
//1.字符串查找
//这里就是利用两个循环，找到头尾第一个不是空格且不是tab符的元素。记录它们的索引，之后截取字符串
function simpleTrim(str) {
    // your implement
    var len=str.length;
    var result="";
for(var i=0;i<len;i++){
     if(str[i]!=" "&&str[i]!="\t"){
       break;
     }
}
    for(var j=len-1;j>0;j--){
        if(str[j]!=" "&&str[j]!="\t"){
            break;
        }
    }
    result=str.slice(i,j+1);
    return result;
}
var str = '   hi!  ';
str = simpleTrim(str);
console.log(str); // 'hi!'
// 很多同学肯定对于上面的代码看不下去，接下来，我们真正实现一个trim
// 对字符串头尾进行空格字符的去除、包括全角半角空格、Tab等，返回一个字符串
// 尝试使用一行简洁的正则表达式完成该题目
function trim(str) {
    var re=/\s|\t/g;
 var s=  str.trim(re);
    return s;
}

// 使用示例
var str = '   hi!  ';
str = trim(str);
console.log(str); // 'hi!'

// 实现一个遍历数组的方法，针对数组中每一个元素执行fn函数，并将数组索引和元素作为参数传递
function each(arr, fn) {
    // your implement
    arr.forEach(fn);
}

// 其中fn函数可以接受两个参数：item和index

// 使用示例
var arr = ['java', 'c', 'php', 'html'];
function output(item) {
    console.log(item)
}
each(arr, output);  // java, c, php, html

// 使用示例
var arr = ['java', 'c', 'php', 'html'];
function output(item, index) {
    console.log(index + ': ' + item)
}
each(arr, output);  // 0:java, 1:c, 2:php, 3:html

// 获取一个对象里面第一层元素的数量，返回一个整数
function getObjectLength(obj) {
    return Object.keys(obj).length;
}

// 使用示例
var obj = {
    a: 1,
    b: 2,
    c: {
        c1: 3,
        c2: 4
    }
};
console.log(getObjectLength(obj)); // 3
// 判断是否为邮箱地址
function isEmail(emailStr) {
    // your implement
    var re=/^(\w+\.)*\w+@\w+(\.\w+)+$/;
    return re.test(emailStr);
}

// 判断是否为手机号
function isMobilePhone(phone) {
    // your implement
    var pattern = /^(\+\d{1,4})?\d{7,11}$/;
    return pattern.test(phone);
}

// 为element增加一个样式名为newClassName的新样式
function addClass(element, newClassName) {
    // your implement
    var oldClassName = element.className; //获取旧的样式类
    element.className = oldClassName === "" ? newClassName : oldClassName + " " + newClassName;
}

// 移除element中的样式oldClassName
function removeClass(element, oldClassName) {
    // your implement
    var originClassName = element.className; //获取原先的样式类
    var pattern = new RegExp("\\b" + oldClassName + "\\b"); //使用构造函数构造动态的正则表达式
    element.className = originClassName.replace(pattern, '');
  //  element.classList.remove(oldClassName);
}

// 判断siblingNode和element是否为同一个父元素下的同一级的元素，返回bool值
function isSiblingNode(element, siblingNode) {
    // your implement
    return element.parentNode==siblingNode.parentNode;
}

// 获取element相对于浏览器窗口的位置，返回一个对象{x, y}
//FF、Opera 和 IE 浏览器认为在客户端浏览器展示的页面的内容对应于整个 HTML，所以使用 document.documentElement来代表，相应的滚动距离则通过 document.documentElement.scrollLeft 和 document.documentElement.scrollTop 来获取，而 Safari 和 Chrome 浏览器则认为页面开始于 body 部分，从而相应的滚动距离用 document.body.scrollLeft 和 document.body.scrollTop 来获取。另外需要注意的是，FF 和 IE 的 quirks mode（兼容模式）下是用 document.body 来获取的。

//documentElement 对应的是 html 标签，而 body 对应的是 body 标签
function getPosition(element) {
    // your implement
    var pos={};
    pos.x = element.getBoundingClientRect().left + Math.max(document.documentElement.scrollLeft, document.body.scrollLeft);
    pos.y = element.getBoundingClientRect().top + Math.max(document.documentElement.scrollTop, document.body.scrollTop);
    return pos;
}
// your implement
//多个选择器有点难到我了，看了一些资料觉得思路应该如下：
//1.如果存在#，直接从#开始向后查
//2.如果存在tag直接找到所有的tag然后向后查
//3.样式类，属性，从后向前查，得到它所有的父节点名称，去筛选匹配
//以上的做法有点太复杂，我还是做一个简单的正向匹配吧。
function $(selector) {

    if (!selector) {
        return null;
    }

    if (selector == document) {
        return document;
    }

    selector = selector.trim();
    if (selector.indexOf(" ") !== -1) { //若存在空格
        var selectorArr = selector.split(/\s+/); //拆成数组

        var rootScope = myQuery(selectorArr[0]); //第一次的查找范围
        var i = null;
        var j = null;
        var result = [];
        //循环选择器中的每一个元素
        for (i = 1; i < selectorArr.length; i++) {
            for (j = 0; j < rootScope.length; j++) {
                result.push(myQuery(selectorArr[i], rootScope[j]));
            }
            // rootScope = result;
            // 目前这个方法还有bug
        }
        return result[0][0];
    } else { //只有一个，直接查询
        return myQuery(selector, document)[0];
    }
}

/**
 * 针对一个内容查找结果 success
 * @param  {String} selector 选择器内容
 * @param  {Element} root    根节点元素
 * @return {NodeList数组}    节点列表，可能是多个节点也可能是一个
 */
/*function myQuery(selector, root) {
    var signal = selector[0]; //
    var allChildren = null;
    var content = selector.substr(1);
    var currAttr = null;
    var result = [];
    root = root || document; //若没有给root，赋值document
    switch (signal) {
        case "#":
            result.push(document.getElementById(content));
            break;
        case ".":
            allChildren = root.getElementsByTagName("*");
            // var pattern0 = new RegExp("\\b" + content + "\\b");
            for (i = 0; i < allChildren.length; i++) {
                currAttr = allChildren[i].getAttribute("class");
                if (currAttr !== null) {
                    var currAttrsArr = currAttr.split(/\s+/);
                    console.log(currAttr);
                    for (j = 0; j < currAttrsArr.length; j++) {
                        if (content === currAttrsArr[j]) {
                            result.push(allChildren[i]);
                            console.log(result);
                        }
                    }
                }
            }
            break;
        case "[": //属性选择
            if (content.search("=") == -1) { //只有属性，没有值
                allChildren = root.getElementsByTagName("*");
                for (i = 0; i < allChildren.length; i++) {
                    if (allChildren[i].getAttribute(selector.slice(1, -1)) !== null) {
                        result.push(allChildren[i]);
                    }
                }
            } else { //既有属性，又有值
                allChildren = root.getElementsByTagName("*");
                var pattern = /\[(\w+)\s*\=\s*(\w+)\]/; //为了分离等号前后的内容
                var cut = selector.match(pattern); //分离后的结果，为数组
                var key = cut[1]; //键
                var value = cut[2]; //值
                for (i = 0; i < allChildren.length; i++) {
                    if (allChildren[i].getAttribute(key) == value) {
                        result.push(allChildren[i]);
                    }
                }
            }
            break;
        default: //tag
            result = root.getElementsByTagName(selector);
            break;
    }
    return result;
}*/
// 实现一个简单的Query
function $(selector) {
    if(selectot==document){
        return document;
    }
    selector=selector.trim();//去掉头空格
    if(selector.indexOf(" ")!==-1) {
        var selectorArr = selector.split("/\s+/ ");
    }
}
function search(selector,index){


}


// 可以通过id获取DOM对象，通过#标示，例如
$("#adom"); // 返回id为adom的DOM对象

// 可以通过tagName获取DOM对象，例如
$("a"); // 返回第一个<a>对象

// 可以通过样式名称获取DOM对象，例如
$(".classa"); // 返回第一个样式定义包含classa的对象

// 可以通过attribute匹配获取DOM对象，例如
$("[data-log]"); // 返回第一个包含属性data-log的对象

$("[data-time=2015]"); // 返回第一个包含属性data-time且值为2015的对象

// 可以通过简单的组合提高查询便利性，例如
$("#adom .classa"); // 返回id为adom的DOM所包含的所有子节点中，第一个样式定义包含classa的对象

// 给一个element绑定一个针对event事件的响应，响应函数为listener
function addEvent(element, event, listener) {
    // your implement
    if (element.addEventListener) {
        element.addEventListener(event,listener);
    } else if(element.attachEvent){
        element.attachEvent("on"+event,listener);
    }
}

// 例如：
 var a=function clicklistener(event) {
          console.log("dianji");
}
addEvent($("#doma"), "click", a);

// 移除element对象对于event事件发生时执行listener的响应
function removeEvent(element, event, listener) {
    // your implement
    if (element.removeEventListenr) {
        element.removeEventListenr(event,listener);
    } else if(element.detachEvent){
        element.detachEvent("on"+event,listener);
    }
}
// 实现对click事件的绑定
function addClickEvent(element, listener) {
    // your implement
   addEvent(element,'click',listener);
}

// 实现对于按Enter键时的事件绑定
function addEnterEvent(element, listener) {
    // your implement
          addEvent(element,"keydown",function(event){
              if(event.keyCode==13){
                  listener();
              }

          });
}
// 判断是否为IE浏览器，返回-1或者版本号可以通过 userAgent 判断浏览器
//ie11的版本号中并没有msie:。只能通过rv:获得。所以需进行一些处理。但是该属性同样可以返回火狐浏览器的版本号。所以还需要多加一层判断。查找是否存在Trident\/7.0
function isIE() {
    // your implement
    var uUserAgent = navigator.userAgent; //保存浏览器的userAgent
    var ieAgent = uUserAgent.match(/msie (\d+.\d+)/i);
    if (ieAgent) {
        return ieAgent[1];
    } else {
        if (uUserAgent.match(/Trident\/7.0;/i)) { //处理到ie11.
            ieAgent = uUserAgent.match(/rv:(\d+.\d+)/i);
            return ieAgent[1];
        }
        return -1; //不是ie浏览器。
    }
}

/**
 * 设置cookie
 * @param {String} cookieName  设置cookie名
 * @param {String} cookieValue 对对应的cookie名
 * @param {Number} expiredays  过期的时间(多少天后)
 */
function setCookie(cookieName, cookieValue, expiredays) {
    // your implement
    var odate=new Date();
    odate.setDate(odate.getDate()+expiredays);
    document.cookie=cookieName+"="+cookieValue+";"+"exporedays="+odate;
}

/**
 * 获取cookie
 * @param   {String} cookieName 待寻找的cookie名
 * @returns {String} 返回寻找到的cookie值,无时为空
 */
function getCookie(cookieName) {
    // your implement
    var arr=document.cookie.split(";");
    for(var i=0;i<arr.length;i++){
        var arr2=arr[i].split("=");
        if(arr2[0]==cookieName){
            return arr2[1];
        }
    }
    return "";
}
/**
 * 删除cookie
 * @param {String} cookieName 待删除的cookie名
 */
function removeCookie(cookieName) {
    setCookie(cookieName, "1", -1)
}

/**
 * AJAX函数封装
 * @param {string} url   请求地址（必须）
 * @param {object} options 发送请求的选项参数
 *   @config {string} [options.type] 请求发送的类型。默认为GET。
 *   @config {Object} [options.data] 需要发送的数据。
 *   @config {Function} [options.onsuccess] 请求成功时触发，function(oAjax.responseText, oAjax)。（必须）
 *   @config {Function} [options.onfail] 请求失败时触发，function(oAjax)。(oAJax为XMLHttpRequest对象)
 *
 *@returns {XMLHttpRequest} 发送请求的XMLHttpRequest对象
 */
function ajax(url, options) {
    // your implement
    var xmlh=new XMLHttpRequest();
    xmlh.open("GET",url,options);
    xmlh.send();
    xmlh.onreadystatechange=function(){
        if(xmlh.readyState==4){
            if(xmlh.status==200){
                console.log(xmlh.responseText);
            }else{}


        }
    };

}

// 使用示例：
ajax(
    'http://localhost:8080/server/ajaxtest',
    {
        data: {
            name: 'simon',
            password: '123456'
        },
        onsuccess: function (responseText, xhr) {
            console.log(responseText);
        }
    }
);