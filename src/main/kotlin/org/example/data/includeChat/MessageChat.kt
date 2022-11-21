package org.example.data.includeChat

import java.time.LocalDate

class MessageChat(
    var messId:Int,
    val userId:Int,
    var readStatus:Boolean,
    var text:String,
    val date:LocalDate
):Comparable<MessageChat> {
    override fun compareTo(other: MessageChat): Int {
        if(this.date > other.date)
            return 1;
        else if(this.date < other.date)
            return -1;
        else
            return 0;
    }

    override fun toString(): String {
        return "MessageChat(messId=$messId, userId=$userId, readStatus=$readStatus, text='$text', date=$date)"
    }


}