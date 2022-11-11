package org.example

import org.example.data.ListNode
import org.example.data.Note
import org.example.data.noteInclude.NoteComment
import java.time.LocalDate

fun main(){
    val note:Note = Note(1,1,1,"any thing","text more text",1,
        1,"some string","any comment",null,false,
        LocalDate.of(2022,11,10));

    var nodes = ListNode();
    nodes.add(note);
    nodes.add(2,1,"any thing more","Hello World!",2,0,
        "more some string","more any comment",null);


    nodes.add(2,1,"cool text","text cool text",1,1,
        "grey","d",null,false, LocalDate.of(2022,10,2));
    nodes.createComment(2,1,"any","Text message",1,false, LocalDate.of(2022,9,1));
    nodes.createComment(2,1,"two any","What any thing",1);
    //println(nodes.list);
    nodes.deleteComment(2,1,2);
    //println(nodes.list);
    nodes.restoreComment(2,1,2);
    //println(nodes.list);
    nodes.delete(1,1);
    //println(nodes.list);
    var l: MutableList<Note>? = nodes.get(2,0,0,1,3,2);
    //println("Список объектов Note ${l}");
    nodes.edit(3,2,1,"simple title","litle simple text",1,1,"blow",
        "b");
    //println(nodes.list);
    nodes.editComment(2,1,"deep, deep black midnight",2);
    //println(nodes.list);
    var l2: MutableList<NoteComment>? = nodes.getComments(2,1,0);
    //println(l2);
    var l3: MutableList<Note>? = nodes.getFriendsNotes(1,1);
    println(l3);
}