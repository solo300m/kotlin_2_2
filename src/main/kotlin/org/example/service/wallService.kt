package org.example.service

import org.example.data.Post
import org.example.data.includeClasses.Comment
import org.example.data.includeClasses.Repost

object wallService {
    private var posts = emptyArray<Post>()
    
    public fun checkCopyrightLink(idPost:Int,link:String):Boolean{
        return TODO()
    }
    public fun closeComments(idPost:Int, idComment:Int){
        TODO()
    }
    public fun createComment(idPost:Int, comment:String){
        TODO()
    }
    public fun delete(idPost:Int):Boolean{
        TODO()
    }
    public fun deleteComment(idPost:Int, idComment:Int){
        TODO()
    }
    public fun edit(idPost:Int):Boolean{
        TODO()
    }
    public fun editAdsStealth(idPost:Int):Boolean{
        TODO()
    }
    public fun editComment(idPost:Int, idComment:Int){
        TODO()
    }
    public fun get():List<Post>{
        TODO()
    }
    public fun getById(idPost:Int):List<Post>{
        TODO()
    }
    public fun getComment(idPost:Int, idComment:Int):Post{
        TODO()
    }
    public fun getComments(idPost:Int):List<Comment>{
        TODO()
    }
    public fun getRepost(idPost:Int):List<Repost>{
        TODO()
    }
    public fun openComment(idPost:Int, idComment:Int){
        TODO()
    }
    public fun pin(idPost:Int){
        TODO()
    }
    public fun post(idPost:Int){
        TODO()
    }
    public fun postAdsStelth(idPost:Int){
        TODO()
    }
    public fun reportComment(idPost:Int, idComment:Int):Boolean{
        TODO()
    }
    public fun reportPost(idPost:Int):Boolean{
        TODO()
    }
    public fun repost(idPost:Int):Boolean{
        TODO()
    }
    public fun restore(idPost:Int){
        TODO()
    }
    public fun restoreComment(idPost:Int, idComment:Int):Boolean{
        TODO()
    }
    public fun search(idPost:Int):Post{
        TODO()
    }
    public fun unpin(idPost:Int):Boolean{
        TODO()
    }
}