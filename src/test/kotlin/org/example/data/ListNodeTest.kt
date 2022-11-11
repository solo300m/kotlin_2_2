package org.example.data

import org.example.data.noteInclude.NoteComment
import org.junit.Assert.assertEquals
import org.junit.Test

import java.time.LocalDate

class ListNodeTest {

    @Test
    fun add() {
        val nId:Int = 1
        val userId:Int = 2
        val friendId:Int = 1
        val title:String = "any thing more"
        val text:String="Hello World!"
        val privacy:Int = 2
        val commentPrivacy:Int = 0
        val privacyView:String = "more some string"
        val privacyComment:String = "more any comment"
        val noteComment:MutableList<NoteComment>? = null
        val delStatus:Boolean = false
        val date: LocalDate = LocalDate.now()

        val noteTest:Note = Note(nId,userId,friendId, title, text, privacy, commentPrivacy, privacyView, privacyComment, noteComment, delStatus, date);
        var nodes = ListNode();
        val note:Note = nodes.add(noteTest);
        //println(noteTest.equals(note))
        //println(note)
        assertEquals(noteTest,note);
    }

    @Test
    fun createComment() {
        val nId:Int = 1
        val userId:Int = 2
        val friendId:Int = 1
        val title:String = "any thing more"
        val text:String="Hello World!"
        val privacy:Int = 2
        val commentPrivacy:Int = 0
        val privacyView:String = "more some string"
        val privacyComment:String = "more any comment"
        val noteComment:MutableList<NoteComment>? = null
        val delStatus:Boolean = false
        val date: LocalDate = LocalDate.now()

        val noteTest:Note = Note(nId,userId,friendId, title, text, privacy, commentPrivacy, privacyView, privacyComment, noteComment, delStatus, date);
        var nodes = ListNode();
        val note:Note = nodes.add(noteTest);
        val int:Int = nodes.createComment(nId,userId,"Any","Message",1);
        assertEquals(1,int);
    }

    @Test
    fun getById() {
        val nId: Int = 1
        val userId: Int = 2
        val friendId: Int = 1
        val title: String = "any thing more"
        val text: String = "Hello World!"
        val privacy: Int = 2
        val commentPrivacy: Int = 0
        val privacyView: String = "more some string"
        val privacyComment: String = "more any comment"
        val noteComment: MutableList<NoteComment>? = null
        val delStatus: Boolean = false
        val date: LocalDate = LocalDate.now()

        val noteTest: Note = Note(
            nId,
            userId,
            friendId,
            title,
            text,
            privacy,
            commentPrivacy,
            privacyView,
            privacyComment,
            noteComment,
            delStatus,
            date
        );
        var nodes = ListNode();
        val note: Note = nodes.add(noteTest);
        val getNote: Note? = nodes.getById(1, 1);
        assertEquals(note, getNote);
    }
    @Test
    fun delete() {
        val nId: Int = 1
        val userId: Int = 2
        val friendId: Int = 1
        val title: String = "any thing more"
        val text: String = "Hello World!"
        val privacy: Int = 2
        val commentPrivacy: Int = 0
        val privacyView: String = "more some string"
        val privacyComment: String = "more any comment"
        val noteComment: MutableList<NoteComment>? = null
        val delStatus: Boolean = false
        val date: LocalDate = LocalDate.now()

        val noteTest: Note = Note(
            nId,
            userId,
            friendId,
            title,
            text,
            privacy,
            commentPrivacy,
            privacyView,
            privacyComment,
            noteComment,
            delStatus,
            date
        );
        var nodes = ListNode();
        val note: Note = nodes.add(noteTest);
        val int:Int = nodes.delete(1,1);
        assertEquals(1,int);
    }
    @Test
    fun delete180() {
        val nId: Int = 1
        val userId: Int = 2
        val friendId: Int = 1
        val title: String = "any thing more"
        val text: String = "Hello World!"
        val privacy: Int = 2
        val commentPrivacy: Int = 0
        val privacyView: String = "more some string"
        val privacyComment: String = "more any comment"
        val noteComment: MutableList<NoteComment>? = null
        val delStatus: Boolean = false
        val date: LocalDate = LocalDate.now()

        val noteTest: Note = Note(
            nId,
            userId,
            friendId,
            title,
            text,
            privacy,
            commentPrivacy,
            privacyView,
            privacyComment,
            noteComment,
            delStatus,
            date
        );
        var nodes = ListNode();
        val note: Note = nodes.add(noteTest);
        val int:Int = nodes.delete(2,1);
        assertEquals(180,int);
    }
    @Test
    fun deleteComment() {
        val nId:Int = 1
        val userId:Int = 2
        val friendId:Int = 1
        val title:String = "any thing more"
        val text:String="Hello World!"
        val privacy:Int = 2
        val commentPrivacy:Int = 0
        val privacyView:String = "more some string"
        val privacyComment:String = "more any comment"
        val noteComment:MutableList<NoteComment>? = null
        val delStatus:Boolean = false
        val date: LocalDate = LocalDate.now()

        val noteTest:Note = Note(nId,userId,friendId, title, text, privacy, commentPrivacy, privacyView, privacyComment, noteComment, delStatus, date);
        var nodes = ListNode();
        val note:Note = nodes.add(noteTest);
        nodes.createComment(nId,userId,"Any","Message",1);
        val int:Int = nodes.deleteComment(1,2,1);
        assertEquals(1,int);
    }
    @Test
    fun deleteComment183() {
        val nId:Int = 1
        val userId:Int = 2
        val friendId:Int = 1
        val title:String = "any thing more"
        val text:String="Hello World!"
        val privacy:Int = 2
        val commentPrivacy:Int = 0
        val privacyView:String = "more some string"
        val privacyComment:String = "more any comment"
        val noteComment:MutableList<NoteComment>? = null
        val delStatus:Boolean = false
        val date: LocalDate = LocalDate.now()

        val noteTest:Note = Note(nId,userId,friendId, title, text, privacy, commentPrivacy, privacyView, privacyComment, noteComment, delStatus, date);
        var nodes = ListNode();
        val note:Note = nodes.add(noteTest);
        nodes.createComment(nId,userId,"Any","Message",1);
        val int:Int = nodes.deleteComment(1,1,1);
        assertEquals(183,int);
    }

    @Test
    fun edit() {
        val nId:Int = 1
        val userId:Int = 2
        val friendId:Int = 1
        val title:String = "any thing more"
        val text:String="Hello World!"
        val privacy:Int = 2
        val commentPrivacy:Int = 0
        val privacyView:String = "more some string"
        val privacyComment:String = "more any comment"
        val noteComment:MutableList<NoteComment>? = null
        val delStatus:Boolean = false
        val date: LocalDate = LocalDate.now()

        val noteTest:Note = Note(nId,userId,friendId, title, text, privacy, commentPrivacy, privacyView, privacyComment, noteComment, delStatus, date);
        var nodes = ListNode();
        val note:Note = nodes.add(noteTest);
        val int:Int = nodes.edit(nId,userId,friendId,"Edit string","Edit text",
            privacy,commentPrivacy,privacyView,privacyComment);
        assertEquals(1,int);
    }
    @Test
    fun edit180() {
        val nId:Int = 1
        val userId:Int = 2
        val friendId:Int = 1
        val title:String = "any thing more"
        val text:String="Hello World!"
        val privacy:Int = 2
        val commentPrivacy:Int = 0
        val privacyView:String = "more some string"
        val privacyComment:String = "more any comment"
        val noteComment:MutableList<NoteComment>? = null
        val delStatus:Boolean = false
        val date: LocalDate = LocalDate.now()

        val noteTest:Note = Note(nId,userId,friendId, title, text, privacy, commentPrivacy, privacyView, privacyComment, noteComment, delStatus, date);
        var nodes = ListNode();
        val note:Note = nodes.add(noteTest);
        val int:Int = nodes.edit(3,userId,friendId,"Edit string","Edit text",
            privacy,commentPrivacy,privacyView,privacyComment);
        assertEquals(180,int);
    }

    @Test
    fun editComment(){
        val nId:Int = 1
        val userId:Int = 2
        val friendId:Int = 1
        val title:String = "any thing more"
        val text:String="Hello World!"
        val privacy:Int = 2
        val commentPrivacy:Int = 0
        val privacyView:String = "more some string"
        val privacyComment:String = "more any comment"
        val noteComment:MutableList<NoteComment>? = null
        val delStatus:Boolean = false
        val date: LocalDate = LocalDate.now()

        val noteTest:Note = Note(nId,userId,friendId, title, text, privacy, commentPrivacy, privacyView, privacyComment, noteComment, delStatus, date);
        var nodes = ListNode();
        val note:Note = nodes.add(noteTest);
        nodes.createComment(nId,userId,"Any","Message",1);
        val int:Int = nodes.editComment(1,2,"Message 2",nId);
        assertEquals(1,int);
    }
    @Test
    fun editComment183(){
        val nId:Int = 1
        val userId:Int = 2
        val friendId:Int = 1
        val title:String = "any thing more"
        val text:String="Hello World!"
        val privacy:Int = 2
        val commentPrivacy:Int = 0
        val privacyView:String = "more some string"
        val privacyComment:String = "more any comment"
        val noteComment:MutableList<NoteComment>? = null
        val delStatus:Boolean = false
        val date: LocalDate = LocalDate.now()

        val noteTest:Note = Note(nId,userId,friendId, title, text, privacy, commentPrivacy, privacyView, privacyComment, noteComment, delStatus, date);
        var nodes = ListNode();
        val note:Note = nodes.add(noteTest);
        nodes.createComment(nId,userId,"Any","Message",1);
        val int:Int = nodes.editComment(0,2,"Message 2",nId);
        assertEquals(183,int);
    }
    @Test
    fun editComment181(){
        val nId:Int = 1
        val userId:Int = 2
        val friendId:Int = 1
        val title:String = "any thing more"
        val text:String="Hello World!"
        val privacy:Int = 2
        val commentPrivacy:Int = 0
        val privacyView:String = "more some string"
        val privacyComment:String = "more any comment"
        val noteComment:MutableList<NoteComment>? = null
        val delStatus:Boolean = false
        val date: LocalDate = LocalDate.now()

        val noteTest:Note = Note(nId,userId,friendId, title, text, privacy, commentPrivacy, privacyView, privacyComment, noteComment, delStatus, date);
        var nodes = ListNode();
        val note:Note = nodes.add(noteTest);
        nodes.createComment(nId,userId,"Any","Message",1);
        val int:Int = nodes.editComment(1,1,"Message 2",3);
        assertEquals(181,int);
    }

    @Test
    fun get() {
        val nId:Int = 1
        val userId:Int = 2
        val friendId:Int = 1
        val title:String = "any thing more"
        val text:String="Hello World!"
        val privacy:Int = 2
        val commentPrivacy:Int = 0
        val privacyView:String = "more some string"
        val privacyComment:String = "more any comment"
        val noteComment:MutableList<NoteComment>? = null
        val delStatus:Boolean = false
        val date: LocalDate = LocalDate.now()

        val noteTest:Note = Note(nId,userId,friendId, title, text, privacy, commentPrivacy, privacyView, privacyComment, noteComment, delStatus, date);
        val noteTest2:Note = Note(2,2,friendId, "Second message", text, privacy, commentPrivacy, privacyView, privacyComment, noteComment, delStatus, LocalDate.of(2022,9,5));
        var nodes = ListNode();
        nodes.add(noteTest);
        nodes.add(noteTest2);
        var listTest:MutableList<Note>? = nodes.get(2,0,0,1,1,2);
        var listEtalon:MutableList<Note>? = mutableListOf();
        if (listEtalon != null) {
            listEtalon.add(noteTest)
        };
        if (listEtalon != null) {
            listEtalon.add(noteTest2)
        };
        listEtalon?.sort();
        assertEquals(listEtalon,listTest);
        //println(listTest);
    }
    @Test
    fun getSortDesc() {
        val nId:Int = 1
        val userId:Int = 2
        val friendId:Int = 1
        val title:String = "any thing more"
        val text:String="Hello World!"
        val privacy:Int = 2
        val commentPrivacy:Int = 0
        val privacyView:String = "more some string"
        val privacyComment:String = "more any comment"
        val noteComment:MutableList<NoteComment>? = null
        val delStatus:Boolean = false
        val date: LocalDate = LocalDate.now()

        val noteTest:Note = Note(nId,userId,friendId, title, text, privacy, commentPrivacy, privacyView, privacyComment, noteComment, delStatus, date);
        val noteTest2:Note = Note(2,2,friendId, "Second message", text, privacy, commentPrivacy, privacyView, privacyComment, noteComment, delStatus, LocalDate.of(2022,9,5));
        var nodes = ListNode();
        nodes.add(noteTest);
        nodes.add(noteTest2);
        var listTest:MutableList<Note>? = nodes.get(2,0,0,0,1,2);
        var listEtalon:MutableList<Note>? = mutableListOf();
        if (listEtalon != null) {
            listEtalon.add(noteTest)
        };
        if (listEtalon != null) {
            listEtalon.add(noteTest2)
        };
        listEtalon?.sortDescending();
        assertEquals(listEtalon,listTest);
        //println(listTest);
    }
    @Test
    fun getNull() {
        val nId:Int = 1
        val userId:Int = 2
        val friendId:Int = 1
        val title:String = "any thing more"
        val text:String="Hello World!"
        val privacy:Int = 2
        val commentPrivacy:Int = 0
        val privacyView:String = "more some string"
        val privacyComment:String = "more any comment"
        val noteComment:MutableList<NoteComment>? = null
        val delStatus:Boolean = false
        val date: LocalDate = LocalDate.now()

        val noteTest:Note = Note(nId,userId,friendId, title, text, privacy, commentPrivacy, privacyView, privacyComment, noteComment, delStatus, date);
        val noteTest2:Note = Note(2,2,friendId, "Second message", text, privacy, commentPrivacy, privacyView, privacyComment, noteComment, delStatus, LocalDate.of(2022,9,5));
        var nodes = ListNode();
        nodes.add(noteTest);
        nodes.add(noteTest2);
        var listTest:MutableList<Note>? = nodes.get(3,0,0,0,1,2);
        var listEtalon:MutableList<Note>? = mutableListOf();
        if (listEtalon != null) {
            listEtalon.add(noteTest)
        };
        if (listEtalon != null) {
            listEtalon.add(noteTest2)
        };
        listEtalon?.sortDescending();
        assertEquals(null,listTest);
        //println(listTest);
    }

    @Test
    fun getComments() {
        val nId:Int = 1
        val userId:Int = 2
        val friendId:Int = 1
        val title:String = "any thing more"
        val text:String="Hello World!"
        val privacy:Int = 2
        val commentPrivacy:Int = 0
        val privacyView:String = "more some string"
        val privacyComment:String = "more any comment"
        val noteComment:MutableList<NoteComment>? = null
        val delStatus:Boolean = false
        val date: LocalDate = LocalDate.now()

        val noteTest:Note = Note(nId,userId,friendId, title, text, privacy, commentPrivacy, privacyView, privacyComment, noteComment, delStatus, date);
        var nodes = ListNode();
        val note:Note = nodes.add(noteTest);
        nodes.createComment(nId,userId,"Any","Bed Message",1);
        nodes.createComment(nId,userId,"First","Message Cool",1);
        nodes.createComment(nId,userId,"Second","Message Not Cool",1);
        var listT: MutableList<NoteComment>? = nodes.getComments(1,2);
        //println(listT);
        var listEtalon:MutableList<NoteComment> = mutableListOf();
        listEtalon.add(NoteComment(1,nId,userId,"Any","Bed Message",1));
        listEtalon.add(NoteComment(2,nId,userId,"First","Message Cool",1));
        listEtalon.add(NoteComment(3,nId,userId,"Second","Message Not Cool",1));
        //println(listEtalon);
        assertEquals(true,listEtalon.equals(listT));
    }

    @Test
    fun getFriendsNotes() {
        val nId:Int = 1
        val userId:Int = 2
        val friendId:Int = 1
        val title:String = "any thing more"
        val text:String="Hello World!"
        val privacy:Int = 2
        val commentPrivacy:Int = 0
        val privacyView:String = "more some string"
        val privacyComment:String = "more any comment"
        val noteComment:MutableList<NoteComment>? = null
        val delStatus:Boolean = false
        val date: LocalDate = LocalDate.now()

        val noteTest:Note = Note(nId,userId,friendId, title, text, privacy, commentPrivacy, privacyView, privacyComment, noteComment, delStatus, date);
        val noteTest2:Note = Note(nId,userId,2, "No Title", "No Text", privacy, commentPrivacy, privacyView, privacyComment, noteComment, delStatus, date);
        var listEtalon:MutableList<Note> = mutableListOf();
        listEtalon.add(noteTest);
        var nodes = ListNode();
        nodes.add(noteTest);
        nodes.add(noteTest2);
        var listT:MutableList<Note>?=nodes.getFriendsNotes(userId,1);
        assertEquals(true,listEtalon.equals(listT));
    }

    @Test
    fun restoreComment() {
        val nId:Int = 1
        val userId:Int = 2
        val friendId:Int = 1
        val title:String = "any thing more"
        val text:String="Hello World!"
        val privacy:Int = 2
        val commentPrivacy:Int = 0
        val privacyView:String = "more some string"
        val privacyComment:String = "more any comment"
        val noteComment:MutableList<NoteComment>? = null
        val delStatus:Boolean = false
        val date: LocalDate = LocalDate.now()

        val noteTest:Note = Note(nId,userId,friendId, title, text, privacy, commentPrivacy, privacyView, privacyComment, noteComment, delStatus, date);
        var nodes = ListNode();
        val note:Note = nodes.add(noteTest);
        nodes.createComment(nId,userId,"Any","Message",1);
        var etalonStatus:Boolean? = nodes.getComments(nId,userId, count = 1)?.get(0)?.delStatus;
        //println(etalonStatus);
        nodes.deleteComment(1,userId,nId);
        var testStatus:Boolean? = nodes.getComments(nId,userId, count = 1)?.get(0)?.delStatus;
        //println(testStatus);
        nodes.restoreComment(1,userId,nId);
        var restartStatus:Boolean? = nodes.getComments(nId,userId, count = 1)?.get(0)?.delStatus;
        //println(restartStatus);
        assertEquals(etalonStatus,restartStatus);
    }
}