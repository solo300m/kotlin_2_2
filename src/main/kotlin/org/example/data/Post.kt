package org.example.data

import org.example.data.includeClasses.*

open class Post(
    val id:Int,
    val owner_id:Int,
    val from_id:Int,
    val created_by:Int,
    val date:Int,
    val text:String,
    val reply_owner_id:Int,
    val reply_post_id:Int,
    val friends_only:Boolean,
    val comments: Array<Comment>,
    val copyright: Copyright,
    val likes:Array<Like>,
    val reposts:Array<Repost>,
    val views:Array<View>,
    val post_type:String,
    val post_source: PostSource,
    val attachments:Array<Media>,
    val geo: Geo,
    val signer_id:Int = 0,
    val copy_history:Array<Post>,
    val can_pin:Boolean,
    val can_delete:Boolean,
    val can_edit:Boolean,
    val is_pinned:Boolean,
    val marked_as_ads:Boolean,
    val is_favorite:Boolean,
    val donut: Donut,
    val posponed_id:Int
) {

}