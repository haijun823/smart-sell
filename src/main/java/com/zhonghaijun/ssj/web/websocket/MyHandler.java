package com.zhonghaijun.ssj.web.websocket;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class MyHandler extends TextWebSocketHandler {

    //在线的用户列表
    private static final ConcurrentHashMap<String,WebSocketSession> users;
    static {
        users = new ConcurrentHashMap<>();
    }
    //用户的表示
    private static final String CLIENT_ID = "user_id";



    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        users.put(session.getId(),session);
        System.out.println("=====================连接成功=======================");
        System.out.println("用户编号："+session.getId());
        System.out.println("用户信息："+session.getPrincipal());
        System.out.println("用户地址："+session.getLocalAddress());
    }

    /**
     * 用来处理前端发送的信息
     * @param session
     * @param message
     */
    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        //将接收的数据转换
        String s = new String(message.asBytes(), "UTF-8");
        sendMessageToAllUsers(session, message);
    }

    /**
     * 发送消息给指定用户
     * @param clientId
     * @param message
     * @return
     */
    public boolean sendMessageToUser(String clientId, TextMessage message) {
        if (users.get(clientId) == null){
            return false;
        }
        WebSocketSession session = users.get(clientId);
        System.out.println("sendMessage:" + session);
        if (!session.isOpen()) return false;
        try {
            session.sendMessage(message);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 群发消息
     * @param message
     * @return
     */
    public void sendMessageToAllUsers(WebSocketSession session,TextMessage message) throws Exception {
        //数据缓冲区
        WebSocketSession usersession;
        for (Map.Entry<String, WebSocketSession> entry : users.entrySet()) {
            //遍历其中的所有用户
             entry.getValue().sendMessage(message);
        }
    }

    /**
     * 连接出错后
     * @param session
     * @param exception
     * @throws Exception
     */
    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        if (session.isOpen()) {
            session.close();
        }
        users.remove(session.getId());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("连接已关闭：" + status);
        users.remove(session.getId());
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

}
