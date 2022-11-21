package org.example.data.includeChat

import org.example.data.Chat
import org.example.data.ChatList

public fun main(){
    val chatList: ChatList = ChatList();
    val chat: Chat? = chatList.add(1,2);
    println(chat);
}
