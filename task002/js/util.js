/**
 * Created by Administrator on 2016/9/12.
 */
// �ж�arr�Ƿ�Ϊһ�����飬����һ��boolֵ
function isArray(arr) {
    // your implement
    return Array.isArray(arr);
}
console.log(isArray([1,2]));
// �ж�fn�Ƿ�Ϊһ������������һ��boolֵ
function isFunction(fn) {
    // your implementc
    return Object.prototype.toString.call(fn)=== '[object Function]';
}

console.log(isFunction(isArray));
// ʹ�õݹ���ʵ��һ����ȿ�¡�����Ը���һ��Ŀ����󣬷���һ����������
// �����ƵĶ������ͻᱻ����Ϊ���֡��ַ��������������ڡ����顢Object���󡣲��������������������
function cloneObject(src) {
    // your implement
    var Result;
    switch(Object.prototype.toString.call(src)){
        case "[object Number]":
            Result = (typeof src === "object"?new Number(src):parseInt(src.toString()));
            break;
        case "[object String]":
            // �����ַ��� =.= ����ûɶ����
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
            // ��ʹ��for(var i=0,a;a = src[i++];) i����a����ֵ����Զ����Ӷ�����
            // �ȵ�һ��ѭ�����������
            for(var i=0,a;a = src[i];i++)
            {
                // temp.push(cloneObject(a));
                // ʹ��push����������������Ԫ�ص����ͱ��undfined
                temp[i] = cloneObject(a);
            }
            Result = temp;
            delete temp;
            break;
        case "[object Object]":
            var temp = {};
            var keys = Object.keys(src);
            // keys Ϊ����src�ļ���������
            // �������飡����
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


// ����������
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
// ���������ȥ�ز�����ֻ����������Ԫ��Ϊ���ֻ��ַ���������һ��ȥ�غ������
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

console.log(getArray(arr)); // ���[1�� 2�� 3�� 4�� 5�� 6]

// ʹ��ʾ��
var a = [1, 3, 5, 7, 5, 3];
var b = getArray(a);
console.log(b); // [1, 3, 5, 7]

// �м���ͬѧ��������
// ʵ��һ���򵥵�trim����������ȥ��һ���ַ�����ͷ����β���Ŀհ��ַ�
// �ٶ��հ��ַ�ֻ�а�ǿո�Tab
// ��ϰͨ��ѭ�����Լ��ַ�����һЩ�����������ֱ�ɨ���ַ���strͷ����β���Ƿ��������Ŀհ��ַ�������ɾ�����ǣ���󷵻�һ�����ȥ�����ַ���
//1.�ַ�������
//���������������ѭ�����ҵ�ͷβ��һ�����ǿո��Ҳ���tab����Ԫ�ء���¼���ǵ�������֮���ȡ�ַ���
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
// �ܶ�ͬѧ�϶���������Ĵ��뿴����ȥ������������������ʵ��һ��trim
// ���ַ���ͷβ���пո��ַ���ȥ��������ȫ�ǰ�ǿո�Tab�ȣ�����һ���ַ���
// ����ʹ��һ�м���������ʽ��ɸ���Ŀ
function trim(str) {
    var re=/\s|\t/g;
 var s=  str.trim(re);
    return s;
}

// ʹ��ʾ��
var str = '   hi!  ';
str = trim(str);
console.log(str); // 'hi!'

// ʵ��һ����������ķ��������������ÿһ��Ԫ��ִ��fn��������������������Ԫ����Ϊ��������
function each(arr, fn) {
    // your implement
    arr.forEach(fn);
}

// ����fn�������Խ�������������item��index

// ʹ��ʾ��
var arr = ['java', 'c', 'php', 'html'];
function output(item) {
    console.log(item)
}
each(arr, output);  // java, c, php, html

// ʹ��ʾ��
var arr = ['java', 'c', 'php', 'html'];
function output(item, index) {
    console.log(index + ': ' + item)
}
each(arr, output);  // 0:java, 1:c, 2:php, 3:html

// ��ȡһ�����������һ��Ԫ�ص�����������һ������
function getObjectLength(obj) {
    return Object.keys(obj).length;
}

// ʹ��ʾ��
var obj = {
    a: 1,
    b: 2,
    c: {
        c1: 3,
        c2: 4
    }
};
console.log(getObjectLength(obj)); // 3
// �ж��Ƿ�Ϊ�����ַ
function isEmail(emailStr) {
    // your implement
    var re=/^(\w+\.)*\w+@\w+(\.\w+)+$/;
    return re.test(emailStr);
}

// �ж��Ƿ�Ϊ�ֻ���
function isMobilePhone(phone) {
    // your implement
    var pattern = /^(\+\d{1,4})?\d{7,11}$/;
    return pattern.test(phone);
}

// Ϊelement����һ����ʽ��ΪnewClassName������ʽ
function addClass(element, newClassName) {
    // your implement
    var oldClassName = element.className; //��ȡ�ɵ���ʽ��
    element.className = oldClassName === "" ? newClassName : oldClassName + " " + newClassName;
}

// �Ƴ�element�е���ʽoldClassName
function removeClass(element, oldClassName) {
    // your implement
    var originClassName = element.className; //��ȡԭ�ȵ���ʽ��
    var pattern = new RegExp("\\b" + oldClassName + "\\b"); //ʹ�ù��캯�����춯̬��������ʽ
    element.className = originClassName.replace(pattern, '');
  //  element.classList.remove(oldClassName);
}

// �ж�siblingNode��element�Ƿ�Ϊͬһ����Ԫ���µ�ͬһ����Ԫ�أ�����boolֵ
function isSiblingNode(element, siblingNode) {
    // your implement
    return element.parentNode==siblingNode.parentNode;
}

// ��ȡelement�������������ڵ�λ�ã�����һ������{x, y}
//FF��Opera �� IE �������Ϊ�ڿͻ��������չʾ��ҳ������ݶ�Ӧ������ HTML������ʹ�� document.documentElement��������Ӧ�Ĺ���������ͨ�� document.documentElement.scrollLeft �� document.documentElement.scrollTop ����ȡ���� Safari �� Chrome ���������Ϊҳ�濪ʼ�� body ���֣��Ӷ���Ӧ�Ĺ��������� document.body.scrollLeft �� document.body.scrollTop ����ȡ��������Ҫע����ǣ�FF �� IE �� quirks mode������ģʽ�������� document.body ����ȡ�ġ�

//documentElement ��Ӧ���� html ��ǩ���� body ��Ӧ���� body ��ǩ
function getPosition(element) {
    // your implement
    var pos={};
    pos.x = element.getBoundingClientRect().left + Math.max(document.documentElement.scrollLeft, document.body.scrollLeft);
    pos.y = element.getBoundingClientRect().top + Math.max(document.documentElement.scrollTop, document.body.scrollTop);
    return pos;
}
// your implement
//���ѡ�����е��ѵ����ˣ�����һЩ���Ͼ���˼·Ӧ�����£�
//1.�������#��ֱ�Ӵ�#��ʼ����
//2.�������tagֱ���ҵ����е�tagȻ������
//3.��ʽ�࣬���ԣ��Ӻ���ǰ�飬�õ������еĸ��ڵ����ƣ�ȥɸѡƥ��
//���ϵ������е�̫���ӣ��һ�����һ���򵥵�����ƥ��ɡ�
function $(selector) {

    if (!selector) {
        return null;
    }

    if (selector == document) {
        return document;
    }

    selector = selector.trim();
    if (selector.indexOf(" ") !== -1) { //�����ڿո�
        var selectorArr = selector.split(/\s+/); //�������

        var rootScope = myQuery(selectorArr[0]); //��һ�εĲ��ҷ�Χ
        var i = null;
        var j = null;
        var result = [];
        //ѭ��ѡ�����е�ÿһ��Ԫ��
        for (i = 1; i < selectorArr.length; i++) {
            for (j = 0; j < rootScope.length; j++) {
                result.push(myQuery(selectorArr[i], rootScope[j]));
            }
            // rootScope = result;
            // Ŀǰ�����������bug
        }
        return result[0][0];
    } else { //ֻ��һ����ֱ�Ӳ�ѯ
        return myQuery(selector, document)[0];
    }
}

/**
 * ���һ�����ݲ��ҽ�� success
 * @param  {String} selector ѡ��������
 * @param  {Element} root    ���ڵ�Ԫ��
 * @return {NodeList����}    �ڵ��б������Ƕ���ڵ�Ҳ������һ��
 */
/*function myQuery(selector, root) {
    var signal = selector[0]; //
    var allChildren = null;
    var content = selector.substr(1);
    var currAttr = null;
    var result = [];
    root = root || document; //��û�и�root����ֵdocument
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
        case "[": //����ѡ��
            if (content.search("=") == -1) { //ֻ�����ԣ�û��ֵ
                allChildren = root.getElementsByTagName("*");
                for (i = 0; i < allChildren.length; i++) {
                    if (allChildren[i].getAttribute(selector.slice(1, -1)) !== null) {
                        result.push(allChildren[i]);
                    }
                }
            } else { //�������ԣ�����ֵ
                allChildren = root.getElementsByTagName("*");
                var pattern = /\[(\w+)\s*\=\s*(\w+)\]/; //Ϊ�˷���Ⱥ�ǰ�������
                var cut = selector.match(pattern); //�����Ľ����Ϊ����
                var key = cut[1]; //��
                var value = cut[2]; //ֵ
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
// ʵ��һ���򵥵�Query
function $(selector) {
    if(selectot==document){
        return document;
    }
    selector=selector.trim();//ȥ��ͷ�ո�
    if(selector.indexOf(" ")!==-1) {
        var selectorArr = selector.split("/\s+/ ");
    }
}
function search(selector,index){


}


// ����ͨ��id��ȡDOM����ͨ��#��ʾ������
$("#adom"); // ����idΪadom��DOM����

// ����ͨ��tagName��ȡDOM��������
$("a"); // ���ص�һ��<a>����

// ����ͨ����ʽ���ƻ�ȡDOM��������
$(".classa"); // ���ص�һ����ʽ�������classa�Ķ���

// ����ͨ��attributeƥ���ȡDOM��������
$("[data-log]"); // ���ص�һ����������data-log�Ķ���

$("[data-time=2015]"); // ���ص�һ����������data-time��ֵΪ2015�Ķ���

// ����ͨ���򵥵������߲�ѯ�����ԣ�����
$("#adom .classa"); // ����idΪadom��DOM�������������ӽڵ��У���һ����ʽ�������classa�Ķ���

// ��һ��element��һ�����event�¼�����Ӧ����Ӧ����Ϊlistener
function addEvent(element, event, listener) {
    // your implement
    if (element.addEventListener) {
        element.addEventListener(event,listener);
    } else if(element.attachEvent){
        element.attachEvent("on"+event,listener);
    }
}

// ���磺
 var a=function clicklistener(event) {
          console.log("dianji");
}
addEvent($("#doma"), "click", a);

// �Ƴ�element�������event�¼�����ʱִ��listener����Ӧ
function removeEvent(element, event, listener) {
    // your implement
    if (element.removeEventListenr) {
        element.removeEventListenr(event,listener);
    } else if(element.detachEvent){
        element.detachEvent("on"+event,listener);
    }
}
// ʵ�ֶ�click�¼��İ�
function addClickEvent(element, listener) {
    // your implement
   addEvent(element,'click',listener);
}

// ʵ�ֶ��ڰ�Enter��ʱ���¼���
function addEnterEvent(element, listener) {
    // your implement
          addEvent(element,"keydown",function(event){
              if(event.keyCode==13){
                  listener();
              }

          });
}
// �ж��Ƿ�ΪIE�����������-1���߰汾�ſ���ͨ�� userAgent �ж������
//ie11�İ汾���в�û��msie:��ֻ��ͨ��rv:��á����������һЩ�������Ǹ�����ͬ�����Է��ػ��������İ汾�š����Ի���Ҫ���һ���жϡ������Ƿ����Trident\/7.0
function isIE() {
    // your implement
    var uUserAgent = navigator.userAgent; //�����������userAgent
    var ieAgent = uUserAgent.match(/msie (\d+.\d+)/i);
    if (ieAgent) {
        return ieAgent[1];
    } else {
        if (uUserAgent.match(/Trident\/7.0;/i)) { //����ie11.
            ieAgent = uUserAgent.match(/rv:(\d+.\d+)/i);
            return ieAgent[1];
        }
        return -1; //����ie�������
    }
}

/**
 * ����cookie
 * @param {String} cookieName  ����cookie��
 * @param {String} cookieValue �Զ�Ӧ��cookie��
 * @param {Number} expiredays  ���ڵ�ʱ��(�������)
 */
function setCookie(cookieName, cookieValue, expiredays) {
    // your implement
    var odate=new Date();
    odate.setDate(odate.getDate()+expiredays);
    document.cookie=cookieName+"="+cookieValue+";"+"exporedays="+odate;
}

/**
 * ��ȡcookie
 * @param   {String} cookieName ��Ѱ�ҵ�cookie��
 * @returns {String} ����Ѱ�ҵ���cookieֵ,��ʱΪ��
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
 * ɾ��cookie
 * @param {String} cookieName ��ɾ����cookie��
 */
function removeCookie(cookieName) {
    setCookie(cookieName, "1", -1)
}

/**
 * AJAX������װ
 * @param {string} url   �����ַ�����룩
 * @param {object} options ���������ѡ�����
 *   @config {string} [options.type] �����͵����͡�Ĭ��ΪGET��
 *   @config {Object} [options.data] ��Ҫ���͵����ݡ�
 *   @config {Function} [options.onsuccess] ����ɹ�ʱ������function(oAjax.responseText, oAjax)�������룩
 *   @config {Function} [options.onfail] ����ʧ��ʱ������function(oAjax)��(oAJaxΪXMLHttpRequest����)
 *
 *@returns {XMLHttpRequest} ���������XMLHttpRequest����
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

// ʹ��ʾ����
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