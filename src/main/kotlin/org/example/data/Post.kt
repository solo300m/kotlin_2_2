package org.example.data

import org.example.data.includeClasses.*

open class Post(
    var id: Int,
    val ownerId: Int,
    var fromId: Int,
    var createdBy: Int,
    val date: Int,
    var text: String,
    var replyOwnerId: Int,
    var replyPostId: Int,
    var friendsOnly: Boolean,
    var comments: Array<Comment>?,
    var copyright: Copyright?,
    var likes: Array<Like>?,
    var reposts: Array<Repost>?,
    var views: Array<View>?,
    var postType: String,
    var postSource: PostSource?,
    var attachments: Array<Attachment>?,
    var geo: Geo?,
    var signerId: Int = 0,
    var copyHistory: Array<Post>?,
    var canPin: Boolean,
    var canDelete: Boolean,
    var canEdit: Boolean,
    var isPinned: Boolean,
    var markedAsAds: Boolean,
    var isFavorite: Boolean,
    var donut: Donut?,
    var posponedId: Int
)

