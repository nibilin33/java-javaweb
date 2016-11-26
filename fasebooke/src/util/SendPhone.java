package util;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

public class SendPhone {
	public static void sellphone(String phone,String pass)throws Exception
	{

	HttpClient client = new HttpClient();
	PostMethod post = new PostMethod("http://utf8.sms.webchinese.cn"); 
	post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=utf-8");//在头文件中设置转码
	NameValuePair[] data ={ new NameValuePair("Uid", "nibilin33"),new NameValuePair("Key", "375725"),new NameValuePair("smsMob",phone),new NameValuePair("smsText",pass)};
	post.setRequestBody(data);

	client.executeMethod(post);
	Header[] headers = post.getResponseHeaders();
	int statusCode = post.getStatusCode();
	System.out.println("statusCode:"+statusCode);
	for(Header h : headers)
	{
	System.out.println(h.toString());
	}
	String result = new String(post.getResponseBodyAsString().getBytes("utf-8")); 
	System.out.println(result);
	post.releaseConnection();

	}
  
}
