package org.kb4md.rest.mycat;


import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;

public class MyWebSocketHandler extends TextWebSocketHandler {

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        try{
            while(true){
                if(session.isOpen()){
                    session.sendMessage(message);
                }
                Thread.sleep(500);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
