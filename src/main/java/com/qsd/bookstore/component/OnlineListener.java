package com.qsd.bookstore.component;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qsd.bookstore.pojo.Global;

/**
 * @Description 
 * @Author Esion
 * @Data 2020年6月7日
 */
@Component
@WebListener
public class OnlineListener implements HttpSessionListener {
	
	@Autowired
	private Global global;

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		global.addOnline();
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		global.reduceOnline();
	}

}
