package com.awfulalien.chatbackend.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatMessage {
    private String content;

    @Override
    public String toString() {
        return "ChatMessage{" +
                "content='" + content + '\'' +
                ", sender='" + sender + '\'' +
                ", type=" + type +
                '}';
    }

    private String sender;
    private MessageType type;


}
