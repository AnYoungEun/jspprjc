package com.sistcommu.jspprjc;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SistRequestListener implements HttpSessionListener, ServletRequestListener{
	
	@Override
	public void sessionCreated(HttpSessionEvent event){
		System.out.println("���� ����:");
	}
	
	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		System.out.println("���� ����");
	}

	@Override
	public void requestDestroyed(ServletRequestEvent event) {
		// TODO Auto-generated method stub
		System.out.println("��û ���� Remote IP="+event.getServletRequest().getRemoteAddr());
	}

	@Override
	public void requestInitialized(ServletRequestEvent event) {
		// TODO Auto-generated method stub
		System.out.println("��û �ʱ�ȭ Remote IP="+event.getServletRequest().getRemoteAddr());
	}
}
