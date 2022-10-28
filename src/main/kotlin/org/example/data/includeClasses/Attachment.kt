package org.example.data.includeClasses

interface Attachment {
    val type:String
    val idAll:Int
}

class Audio(override val type: String,
            override val idAll: Int,
            val id:Int,
            val ownerId:Int,
            val artist:String,
            val title:String,
            val duration:Int,
            val url:String,
            val liricsId:Int,
            val albumId:Int,
            val genreId:Int,
            val date:Int,
            val noSearch:Boolean,
            val isHq:Boolean
            ):Attachment{}

class Document(override val type: String,
               override val idAll: Int,
               val id:Int,
               val owner_id:Int,
               val title:String,
               val size:Int,
               val ext:String,
               val url:String,
               val date:Int,
               val documentType:Int,
               val preview:Preview?
               ):Attachment{}
class Preview(){

}

class Link(
    override val type: String,
    override val idAll: Int,
    val url:String,
    val title:String,
    val caption:String,
    val description:String,
    val photo:Photo?,
    val product:Product?,
    val button:Button?,
    val previewPage:String,
    val previewUrl:String,
    ):Attachment{}
class Photo(
    override val type: String,
    override val idAll: Int,
    val id:Int,
    val albumId:Int,
    val ownerId:Int,
    val userId:Int,
    val text:String,
    val date:Int,
    val sizes:Array<CopyPhoto>?,
    val width:Int,
    val height:Int
):Attachment{}
class Product(){}
class Button(){}
class CopyPhoto(
    val type:String,
    val url:String,
    val width:Int,
    val height:Int
){}

