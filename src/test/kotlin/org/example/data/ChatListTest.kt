package org.example.data

import org.example.data.includeChat.MessageChat
import org.junit.Test

import org.junit.Assert.*

class ChatListTest {

    @Test
    fun getListChat() {
    }

    @Test
    fun add() {
        var cList: ChatList = ChatList();
        val ownerID:Int = 1;
        val questId:Int = 2;
        val ch: Chat? = cList.add(ownerID,questId);
        if(ch !=null) {
            assertEquals(ch.ownerId, cList.listChat[0].ownerId);
            assertEquals(ch.questId, cList.listChat[0].questId);
            assertEquals(ch.messages, cList.listChat[0].messages);
        }
    }

    @Test
    fun delete() {
        var cList: ChatList = ChatList();
        val ownerID:Int = 1;
        val questId:Int = 2;
        cList.add(ownerID,questId);
        val test:Int = cList.delete(1);
        val test2:Int = cList.delete(2);
        assertEquals(1,test);
        assertEquals(0,test2);
    }

    @Test
    fun getChatsAll() {
        var cList: ChatList = ChatList();
        val ownerID:Int = 1;
        val questId:Int = 2;
        cList.add(ownerID,questId);
        val ownerID2:Int = 3;
        val questId2:Int = 4;
        cList.add(ownerID2,questId2);
        val list:List<Chat> = cList.getChatsAll();
        assertEquals(1,list[0].ownerId);
        assertEquals(2,list[0].questId);
        assertEquals(3,list[1].ownerId);
        assertEquals(4,list[1].questId);
    }

    @Test
    fun getChatOne(){
        var cList: ChatList = ChatList();
        val ownerID:Int = 1;
        val questId:Int = 2;
        cList.add(ownerID,questId);
        val ownerID2:Int = 3;
        val questId2:Int = 4;
        cList.add(ownerID2,questId2);
        val chat:Chat? = cList.getChatOne(3);
        if (chat != null) {
            assertEquals(chat.chatId, cList.listChat[0].chatId);
            assertEquals(chat.ownerId, cList.listChat[0].ownerId);
            assertEquals(chat.questId, cList.listChat[0].questId);
        }
        else{
            assertEquals(null,chat);
        }
    }

    @Test
    fun creatMessage() {
        var cList: ChatList = ChatList();
        val ownerID:Int = 1;
        val questId:Int = 2;
        cList.add(ownerID,questId);
        val ownerID2:Int = 3;
        val questId2:Int = 4;
        cList.add(ownerID2,questId2);
        val chatId:Int = 1;
        val mess: MessageChat? = cList.creatMessage(chatId,ownerID,questId,"It is first test's text");
        val mess2:MessageChat? = cList.creatMessage(chatId,ownerID,questId,"It is two test's text")
        /*println(mess);
        println(mess2);*/
        if (mess != null) {
            assertEquals("It is first test's text",mess.text)
        };
        if(mess2 != null){
            assertEquals("It is two test's text",mess2.text);
        }
    }

    @Test
    fun editMessage() {
        var cList: ChatList = ChatList();
        val ownerID:Int = 1;
        val questId:Int = 2;
        cList.add(ownerID,questId);
        val ownerID2:Int = 3;
        val questId2:Int = 4;
        cList.add(ownerID2,questId2);
        val chatId:Int = 1;
        val messId:Int = 1;
        val mess: MessageChat? = cList.creatMessage(chatId,ownerID,questId,"It is first test's text");
        val mess2:MessageChat? = cList.creatMessage(chatId,ownerID,questId,"It is two test's text");
        val int:Int = cList.editMessage(chatId,messId,"It is edited two test's text");
        //println(cList.listChat[0].messages?.get(1))
        assertEquals(1,int);
    }

    @Test
    fun delMessage() {
        var cList: ChatList = ChatList();
        val ownerID:Int = 1;
        val questId:Int = 2;
        cList.add(ownerID,questId);
        val ownerID2:Int = 3;
        val questId2:Int = 4;
        cList.add(ownerID2,questId2);
        val chatId:Int = 1;
        val messId:Int = 0;
        val mess: MessageChat? = cList.creatMessage(chatId,ownerID,questId,"It is first test's text");
        val mess2:MessageChat? = cList.creatMessage(chatId,ownerID,questId,"It is two test's text");
        val del:Int = cList.delMessage(chatId,messId);
        assertEquals(1,del);
    }

    @Test
    fun delMessageAll() {
        var cList: ChatList = ChatList();
        val ownerID:Int = 1;
        val questId:Int = 2;
        cList.add(ownerID,questId);
        val ownerID2:Int = 3;
        val questId2:Int = 4;
        cList.add(ownerID2,questId2);
        val chatId:Int = 1;
        val messId:Int = 0;
        val mess: MessageChat? = cList.creatMessage(chatId,ownerID,questId,"It is first test's text");
        val mess2:MessageChat? = cList.creatMessage(chatId,ownerID,questId,"It is two test's text");
        val del:Int = cList.delMessageAll(chatId);
        assertEquals(1,del);
    }

    @Test
    fun getChats() {
        var cList: ChatList = ChatList();
        val ownerID:Int = 1;
        val questId:Int = 2;
        cList.add(ownerID,questId);
        val ownerID2:Int = 3;
        val questId2:Int = 4;
        cList.add(ownerID2,questId2);
        val chatId:Int = 1;
        val messId:Int = 0;
        val mess: MessageChat? = cList.creatMessage(chatId,ownerID,questId,"It is first test's text");
        val mess2:MessageChat? = cList.creatMessage(chatId,ownerID,questId,"It is two test's text");
        val list:List<Chat> = cList.getChats(ownerID);
        val listNull:List<Chat> = cList.getChats(13);
        if(list != null){
            assertEquals(ownerID,list[0].ownerId);
        }
        else
            assertEquals(null,list);
    }

    @Test
    fun getMessageOfChat() {
        var cList: ChatList = ChatList();
        val ownerID:Int = 1;
        val questId:Int = 2;
        cList.add(ownerID,questId);
        val ownerID2:Int = 3;
        val questId2:Int = 4;
        cList.add(ownerID2,questId2);
        val chatId:Int = 1;
        val messId:Int = 0;
        val mess: MessageChat? = cList.creatMessage(chatId,ownerID,questId,"It is first test's text");
        val mess2:MessageChat? = cList.creatMessage(chatId,ownerID,questId,"It is two test's text");
        val list:MutableList<MessageChat>? = cList.getMessageOfChat(chatId);
        val list13:MutableList<MessageChat>? = cList.getMessageOfChat(13);
        if(list != null)
            assertEquals("It is two test's text",list[1].text);
    }

    @Test
    fun setMessageReadAll() {
        var cList: ChatList = ChatList();
        val ownerID:Int = 1;
        val questId:Int = 2;
        cList.add(ownerID,questId);
        val ownerID2:Int = 3;
        val questId2:Int = 4;
        cList.add(ownerID2,questId2);
        val chatId:Int = 1;
        val messId:Int = 0;
        val mess: MessageChat? = cList.creatMessage(chatId,ownerID,questId,"It is first test's text");
        val mess2:MessageChat? = cList.creatMessage(chatId,ownerID,questId,"It is two test's text");

        val int:Int = cList.setMessageReadAll(1);
        assertEquals(1,int);
        assertEquals(true,cList.listChat[0].messages?.get(0)?.readStatus);
    }
}