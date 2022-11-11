package org.example.data.noteInclude

import java.time.LocalDate

class NoteComment (
    var cId:Int = 0,
    val nodeId:Int,
    val ownerId:Int,
    val replyTo:String,
    var message:String,
    val duId:Int,
    var delStatus:Boolean = false,
    val date:LocalDate = LocalDate.now()
) : Comparable<NoteComment> {

    override fun compareTo(other: NoteComment): Int {
        if(this.date > other.date)
            return 1;
        else if(this.date < other.date)
            return -1;
        else
            return 0;
    }


    override fun toString(): String {
        return "NoteComment(cId=$cId, nodeId=$nodeId, \n" +
                "ownerId=$ownerId, replyTo='$replyTo', \n" +
                "message='$message', duId=$duId, \n" +
                "delStatus=$delStatus, date=$date)\n"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as NoteComment

        if (cId != other.cId) return false
        if (nodeId != other.nodeId) return false
        if (ownerId != other.ownerId) return false
        if (replyTo != other.replyTo) return false
        if (message != other.message) return false
        if (duId != other.duId) return false
        if (delStatus != other.delStatus) return false
        if (date != other.date) return false

        return true
    }

    override fun hashCode(): Int {
        var result = cId
        result = 31 * result + nodeId
        result = 31 * result + ownerId
        result = 31 * result + replyTo.hashCode()
        result = 31 * result + message.hashCode()
        result = 31 * result + duId
        result = 31 * result + delStatus.hashCode()
        result = 31 * result + date.hashCode()
        return result
    }


}
