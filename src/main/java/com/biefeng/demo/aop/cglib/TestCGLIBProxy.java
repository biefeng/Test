package com.biefeng.demo.aop.cglib;

import net.sf.cglib.proxy.Enhancer;

public class TestCGLIBProxy {

	public static void main(String[] args) {

		CGLIBProxy cglibProxy = new CGLIBProxy();

		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(UserServiceImpl.class);
		enhancer.setCallback(cglibProxy);

		UserService o = (UserService) enhancer.create();
		o.getName(1);
		o.getAge(1);
	}

}
