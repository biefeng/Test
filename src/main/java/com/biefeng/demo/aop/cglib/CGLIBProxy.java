package com.biefeng.demo.aop.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CGLIBProxy implements MethodInterceptor{

	@Override
	public Object intercept(Object object, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

		System.out.println("++++++before " + methodProxy.getSuperName() + "++++++");
		System.out.println(method.getName());
		Object o1 = methodProxy.invokeSuper(object, objects);
		System.out.println("++++++before " + methodProxy.getSuperName() + "++++++");
		return o1;
	}
}
