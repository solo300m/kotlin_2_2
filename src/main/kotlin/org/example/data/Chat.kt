package org.example.data

import org.example.data.includeChat.MessageChat
import java.time.LocalDate

class Chat(
    val chatId: Int,
    val ownerId: Int,
    val questId: Int,
    var messages: MutableList<MessageChat>?
){
    override fun toString(): String {
        return "Chat(chatId=$chatId, ownerId=$ownerId, questId=$questId, messages=$messages)"
    }
}

class ChatList {
    var listChat: MutableList<Chat> = mutableListOf();

    public fun add(ownerId: Int, questId: Int): Chat? {
        if (listChat.isEmpty()) {
            val id: Int = 1;
            val chat: Chat = Chat(id, ownerId, questId, null);
            listChat.add(chat);
            return listChat.last();
        }
        else{
            val id: Int = listChat.last().chatId + 1;
            val chat: Chat = Chat(id, ownerId, questId, null);
            listChat.add(chat);
            return listChat.last();
        }
        return null;
    }

    public fun delete(chatId: Int): Int {
        val listTmp = listChat.filter { chat: Chat -> chat.chatId == chatId };
        if (!listTmp.isEmpty()) {
            listChat.remove(listTmp[0]);
            return 1;
        } else
            return 0;

    }

    public fun getChatsAll(): List<Chat> {
        val list: List<Chat> = listChat;
        return list;
    }

    public fun getChatOne(chatId: Int): Chat? {
        val tmpIdx = listChat.getIndexChat(chatId);
        if (tmpIdx >= 0)
            return listChat.get(tmpIdx);
        else
            return null;
    }

    public fun creatMessage(chatId: Int, userId: Int, questId: Int, text: String, date: LocalDate = LocalDate.now()): MessageChat? {
        val index = listChat.getIndexChat(chatId);
        if(index >= 0) {
            if (listChat.get(index).messages != null) {
                val idxMes:Int = listChat.get(index).messages?.size?:0;
                listChat.get(index).messages?.add(MessageChat(idxMes, userId, false, text, LocalDate.now()));
                return listChat.get(index).messages?.last();
            } else {
                val idxMes:Int = 0;
                listChat.get(index).messages = mutableListOf();
                listChat.get(index).messages?.add(MessageChat(idxMes, userId, false, text, LocalDate.now()));
                return listChat.get(index).messages?.last();
            }
        }
        else{
            add(userId,questId);
            val idxMes:Int = 0;
            listChat.get(index).messages = mutableListOf();
            listChat.get(index).messages?.add(MessageChat(idxMes, userId, false, text, LocalDate.now()));
            return listChat.get(index).messages?.last();
        }
        //return null;
    }

    public fun editMessage(chatId: Int, messId: Int, text: String):Int{
        val chatIndex = listChat.getIndexChat(chatId);
        if(chatIndex >= 0){
            val messIndex = listChat.getIndexMessage(chatId,messId);
            if(messIndex >= 0){
                listChat.get(chatIndex).messages?.get(messIndex)?.text = text;
                return 1;
            }
            return 183;
        }
        return 180;
    }

    public fun delMessage(chatId: Int, messId: Int):Int{
        val chatIndex = listChat.getIndexChat(chatId);
        if(chatIndex >= 0){
            val messIndex = listChat.getIndexMessage(chatId,messId);
            if(messIndex >= 0){
                listChat.get(chatIndex).messages?.removeAt(messIndex);
                if(listChat.get(chatIndex).messages?.isEmpty() == true){
                    listChat.removeAt(chatIndex);
                }
                return 1;
            }
            return 183;
        }
        return 180;
    }

    public fun delMessageAll(chatId: Int):Int{
        val chatIndex = listChat.getIndexChat(chatId);
        if(chatIndex >= 0){
            listChat[chatIndex].messages = null;
            return 1;
        }
        return 180;
    }

    public fun getChats(userId: Int):List<Chat>{
        val list:List<Chat> = listChat.filter { chat : Chat -> chat.messages?.last()?.readStatus == false && chat.ownerId == userId};
        if(!list.isEmpty())
            return list;
        else{
            println("нет сообщений");
            return list;
        }
    }

    public fun getMessageOfChat(chatId: Int): MutableList<MessageChat>? {
        val index:Int = listChat.getIndexChat(chatId);
        if(index >= 0){
            val list: MutableList<MessageChat>? = listChat[index].messages;
            return list;
        }
        return null;
    }

    public fun setMessageReadAll(chatId: Int):Int{
        val index:Int = listChat.getIndexChat(chatId);
        val function = fun(list:MutableList<MessageChat>):Boolean{
            if(!list.isNullOrEmpty()){
                for(l in list){
                    if(!l.readStatus)
                        l.readStatus = true;
                }
                return true;
            }
            return false;
        }
        val tmp = listChat[index].messages;
        if (!tmp.isNullOrEmpty()) {
            function(tmp);
            return 1;
        }
        return 183;
    }



    /*extension function*/

    public fun <Chat> MutableList<Chat>.getUnreadChatsCount():Int{
        if(listChat!=null || !isEmpty()){
            var count:Int = 0;
            for(i:Int in 0 until listChat.size){
                count += listChat.getUnreadCount(i+1);
            }
            return count;
        }
        return 0;
    }

    public fun <Chat> MutableList<Chat>.getUnreadCount(chatId: Int):Int{
        val chatIndex = listChat.getIndexChat(chatId);
        if(chatIndex >= 0){
            val list: List<MessageChat>? = listChat.get(chatIndex).messages?.filter { chat:MessageChat -> !chat.readStatus };
            if(list == null || list.isEmpty())
                return 0;
            else{
                return list.size;
            }
        }
        else
            return 0;
    }

    public fun <MessageChat> MutableList<MessageChat>.setReadStatusMessage(chatId: Int, messId: Int, readStatus:Boolean = true):Int{
        val chatIndex = listChat.getIndexChat(chatId);
        if(chatIndex >= 0){
            val messIndex = listChat.getIndexMessage(chatId,messId);
            if(messIndex >= 0){
                listChat.get(chatIndex).messages?.get(messIndex)?.readStatus = readStatus;
                return 1;
            }
            return 183;
        }
        return 180;
    }

    public fun <Chat> MutableList<Chat>.getIndexChat(chatId: Int): Int {
        var indexChat: Int = -1;
        for ((index, chat) in listChat.withIndex()) {
            if (chat.chatId == chatId) {
                indexChat = index;
                return indexChat;
            }
        }
        return indexChat;
    }

    public fun <MessageChat> MutableList<MessageChat>.getIndexMessage(chatId: Int, messId: Int):Int{
        val indexAll:Int = -1;
        val chatIndex:Int = listChat.getIndexChat(chatId);
        if(chatIndex >= 0){
            if(listChat[chatIndex].messages != null && listChat[chatIndex].messages?.size != 0){
                val arr = listChat[chatIndex].messages;
                for((index,mes) in arr!!.withIndex()){
                    if(mes.messId == messId)
                        return index;
                }
            }
        }
        return indexAll
    }
}