package com.fase.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/**
 * 
 * @author Administrator
 *
 */
public class LoginIntercepter implements HandlerInterceptor {
	//进入 Handler方法之前执行
		//用于身份认证、身份授权
		//比如身份认证，如果认证通过表示当前用户没有登陆，需要此方法拦截不再向下执行
	

	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO 自动生成的方法存根

	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO 自动生成的方法存根

	}

	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {
		// TODO 自动生成的方法存根
		return false;
	}

}
