package org.example.data

import org.example.data.noteInclude.NoteComment
import java.time.LocalDate
import java.util.*


class Note(
    val nId:Int,
    val userId:Int,
    val friendId: Int,
    var title:String,
    var text: String,
    var privacy:Int,
    var commentPrivacy: Int,
    var privacyView:String,
    var privacyComment: String,
    var noteComment: MutableList<NoteComment>?,
    var delStatus: Boolean,
    var date:LocalDate = LocalDate.now()
    ) : Comparable<Note> {
    override fun toString(): String {
        return "Note(nId=$nId, " +
                "title='$title', \n" +
                "userId= ${userId} \n"+
                "friendId=${friendId}"+
                "text='$text'\n"+
                "privacy=$privacy, " +
                "commentPrivacy=$commentPrivacy, \n" +
                "privacyView='$privacyView', " +
                "privacyComment='$privacyComment', \n"+
                "delStatus=${delStatus}, "+
                "date=${date}, comments= ${noteComment})"
    }

    override fun compareTo(other: Note): Int {
        if(this.date > other.date)
            return 1;
        else if(this.date < other.date)
            return -1;
        else
            return 0;
    }
}
class ListNode{
    var list = mutableListOf<Note>();

    public fun add(note:Note):Note{
        list.add(note);
        return list.last();
    }
    public fun add(
        userId:Int,
        friendId:Int,
        title:String,
        text:String,
        privacy:Int,
        commentPrivacy:Int,
        privacyView:String,
        privacyComment:String,
        noteComment:MutableList<NoteComment>?,
        delStatus:Boolean = false,
        date: LocalDate = LocalDate.now()):Note{

        var idx = 0;
        if(list.isEmpty())
            idx = 1;
        else
            idx = list.last().nId + 1;
        var commentList: MutableList<NoteComment>?;
        if(commentPrivacy != 0) {
            var tempList: MutableList<NoteComment> = mutableListOf();
            commentList = tempList;
        }
        else{
            commentList = null;
        }
        list.add(Note(idx,userId,friendId,title,text,privacy,commentPrivacy,privacyView,privacyComment,commentList,delStatus,date));
        return list.last();
    }

    public fun createComment(noteComment: NoteComment):Int{
        if( getById(noteComment.nodeId,noteComment.ownerId)!= null){
            val listIndex = list.indexOf(getById(noteComment.nodeId, noteComment.ownerId));
            if(list.get(listIndex).noteComment != null){
                noteComment.cId = list[listIndex].noteComment!!.size + 1;
                list[listIndex].noteComment?.add(noteComment);
            }
            else{
                list[listIndex].noteComment = mutableListOf();
                noteComment.cId = list[listIndex].noteComment!!.size + 1;
                list[listIndex].noteComment?.add(noteComment);
            }
            return list[listIndex].noteComment?.last()!!.cId;
        }
        else
            return 0;
    }
    public fun createComment(nodeId:Int, ownerId:Int, replyTo:String, message:String, duId:Int,
                             delStatus:Boolean = false, date:LocalDate = LocalDate.now()):Int{
        if( getById(nodeId, ownerId)!= null){
            val listIndex = list.indexOf(getById(nodeId, ownerId));
            if(list.get(listIndex).noteComment != null){
                var cId = list[listIndex].noteComment!!.size + 1;
                list[listIndex].noteComment?.add(NoteComment(cId,nodeId,ownerId,replyTo,message,duId,delStatus,date));
            }
            else{
                list[listIndex].noteComment = mutableListOf();
                var cId = list[listIndex].noteComment!!.size + 1;
                list[listIndex].noteComment?.add(NoteComment(cId,nodeId,ownerId,replyTo,message,duId,delStatus,date));
            }
            return list[listIndex].noteComment?.last()!!.cId;
        }
        else
            return 0;
    }
    public fun getById(nodeID:Int, ownerID: Int, needWiki:String="No"):Note?{
        for(note:Note in list){
            if(note.nId == nodeID)
                return note
        }
        return null
    }

    public fun delete(noteId: Int, userId: Int):Int{
        if(getById(noteId, userId)!=null){
            val listIndex = list.indexOf(getById(noteId, userId));
            list[listIndex].delStatus = true;
            return 1;
        }
        else
            return 180;
    }

    public fun deleteComment(commentId:Int, ownerID:Int, nodeId:Int):Int{
        if(getById(nodeId,ownerID)!=null){
            val listIndex = list.indexOf(getById(nodeId, ownerID));
            if(getCommentById(commentId,ownerID,listIndex) != null){
                getCommentById(commentId,ownerID,listIndex)?.delStatus = true;
                return 1;
            }
            else
                return 183;
        }
        return 181;
    }
    public fun getCommentById(commentId:Int, ownerID:Int, listIndex:Int): NoteComment?{
        if(list[listIndex].noteComment != null && list[listIndex].noteComment?.size != 0){
            for(comment: NoteComment in list[listIndex].noteComment!!){
                if(comment.cId == commentId && comment.ownerId == ownerID){
                    return comment;
                }
            }
            return null;
        }
        return null;
    }
    public fun edit(noteId:Int, userId: Int, friendId:Int, title:String, text:String, privacy:Int,
                    commentPrivacy:Int, privacyView:String, privacyComment:String):Int{

        if(getById(noteId,userId) != null){
            val listIndex = list.indexOf(getById(noteId,userId));
            list[listIndex].title = title;
            list[listIndex].text = text;
            list[listIndex].privacy = privacy;
            list[listIndex].commentPrivacy = commentPrivacy;
            list[listIndex].privacyView = privacyView;
            list[listIndex].privacyComment = privacyComment;
            return 1;
        }
        return 180;
    }
    public fun editComment(commentId:Int, ownerID:Int, message:String, nodeId:Int):Int{
        if(getById(nodeId,ownerID)!=null){
            val listIndex = list.indexOf(getById(nodeId, ownerID));
            if(getCommentById(commentId,ownerID,listIndex) != null){
                getCommentById(commentId,ownerID,listIndex)?.message = message;
                return 1;
            }
            else
                return 183;
        }
        return 181;
    }

    public fun get(userId:Int, offset:Int=0, count:Int=0, sort:Int=1,vararg noteId:Int):MutableList<Note>? {
        val arrNote: IntArray = noteId;
        var list:MutableList<Note> = mutableListOf<Note>();
        var listRez:MutableList<Note> = mutableListOf();
        if (!arrNote.isEmpty()){
            list = getNoteByUserId(userId,sort);
            for(i:Int in arrNote) {
                for (note: Note in list) {
                    if (note.nId == i)
                        listRez.add(note)
                }
            }
            if(sort == 1) {
                Collections.sort(listRez);
            }
            else if(sort == 0) {
                listRez.sortDescending();
            }

            if(listRez.size != 0) {
                if (count == 0)
                    return listRez;
                else if (count > 0)
                    return listRez.subList(0, count);
            }
            else
                return null;
        }
        return null;
    }

    public fun getNoteByUserId(userId:Int, sort:Int):MutableList<Note>{
        var listRez: MutableList<Note> = mutableListOf();
        for(note: Note in list){
            if(note.userId == userId)
                listRez.add(note);
        }
        Collections.sort(listRez);
        return listRez;
    }

    public fun getComments(noteId:Int,ownerId:Int,sort:Int=0,offset:Int=0,count:Int=0):MutableList<NoteComment>?{
        var noteIndex:Int=0;
        var listComment:MutableList<NoteComment> = mutableListOf();
        for((index, note) in list.withIndex()){
            if(list[index].nId == noteId){
                noteIndex = index;
                break;
            }
        }

        if (!list[noteIndex].noteComment?.isEmpty()!!){
            for(comment: NoteComment in list[noteIndex].noteComment!!){
                if(comment.ownerId == ownerId)
                   listComment.add(comment)
            }
        }
        else
            return null;
        if(sort == 0)
            Collections.sort(listComment);
        else
            listComment.sortDescending();

        if(count > 0){
            return listComment.subList(0,count);
        }
        else
            return listComment;

    }

    public fun getFriendsNotes(ownerID: Int,friendId: Int,offset: Int=0,count: Int=0):MutableList<Note>{
        var listFriend:MutableList<Note> = mutableListOf();
        for(note:Note in list){
            if(note.userId == ownerID && note.friendId == friendId)
                listFriend.add(note);
        }
        if(count > 0)
            return listFriend.subList(0,count);
        else
            return listFriend;
    }

    public fun restoreComment(commentId: Int, ownerID: Int, noteId: Int):Int{
        if(getById(noteId,ownerID)!=null){
            var index = list.indexOf(getById(noteId,ownerID));

            if(list[index].noteComment != null && !list[index].noteComment?.isEmpty()!!){
                for(noteComment: NoteComment in list[index].noteComment!!){
                    if((noteComment.ownerId == ownerID && noteComment.cId == commentId) && noteComment.delStatus == true) {
                        noteComment.delStatus = false;
                        return 1;
                    }
                }
                return 183;
            }
        }
        return 183;
    }
}