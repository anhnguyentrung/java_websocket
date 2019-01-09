package com.java.web;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnError;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/endpoint")
public class MyWebSocket {
	@OnOpen
	public void onOpen(Session session) {
		System.out.println("onOpen: " + session.getId());
	}
	
	@OnClose
	public void onClose(Session session) {
		System.out.println("onClose: " + session.getId());
	}
	
	@OnMessage
	public void onMessage(String message, Session session) {
		System.out.println("onMessage from " + session.getId() + "message" + message);
		try {
			session.getBasicRemote().sendText("Hello client " + session.getId() + "!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@OnError
	public void onError(Throwable t) {
		System.out.println("onError " + t.getMessage());
	}
}
