package org.example

import org.example.data.Post

import org.example.data.includeClasses.Comment
import org.example.service.WallService

public fun main(){
    val post:Post = Post(1,1,1,1,1,"any text",
        1,1,false, null,null,
        null,null,null,"Any post",null,
        null,null,2,null,false,
        false,false,false,false,
        false,null,1);
    val postSecond:Post = Post(2,2,1,1,1,"any text 2",
        1,1,false, null,null,
        null,null,null,"Any post",null,
        null,null,2,null,false,
        false,false,false,false,
        false,null,1);
    val postThree:Post = Post(3,3,1,1,1,"any text 3",
        1,1,false, null,null,
        null,null,null,"Any post",null,
        null,null,2,null,false,
        false,false,false,false,
        false,null,1);
    val post2:Post = Post(4,2,2,1,1,"any text 3 next",
        1,1,false, null,null,
        null,null,null,"Any post next",null,
        null,null,2,null,false,
        false,false,false,false,
        false,null,1);
    val postAdd = WallService.add(post);
    val postAdd2 = WallService.add(postSecond);
    val postAdd3 = WallService.add(postThree);
    println("Post ${postAdd.id} OwnerID ${postAdd.ownerId} Text ${postAdd.text}");
    println("Post ${postAdd2.id} OwnerID ${postAdd2.ownerId} Text ${postAdd2.text}");
    println("Post ${postAdd3.id} OwnerID ${postAdd3.ownerId} Text ${postAdd3.text}");
    val update = WallService.update(post2);
    val upPost = WallService.getLast();
    println("Пост ${upPost.id} OwnerID ${upPost.ownerId} Text ${upPost.text} Признак обновления ${update}");
}