package org.example.data.includeChat

import org.example.data.Chat
import org.example.data.ChatList

public fun main(){
    /*val chatList: ChatList = ChatList();
    val chat: Chat? = chatList.add(1,2);*/
    /*val t:String = chat?.messages!![0].text;*/
    //println(chat);
    val pair:Pair<Int,Int> = Pair(1,2);
    val i:Int = pair!!.first;
    print(pair.first)
    print(pair.second)
}
class Pair<A,B>(val first:A,val second:B)
