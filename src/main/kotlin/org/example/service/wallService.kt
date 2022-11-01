package org.example.service

import org.example.data.Post
import org.example.data.includeClasses.Comment
import org.example.data.includeClasses.Repost

object WallService {
    private var posts = emptyArray<Post>()

    fun add(post: Post): Post {
        posts += post;
        return posts.last();
    }

    fun update(post: Post): Boolean {
        for (i in 0..posts.size - 1) {
            if (posts[i].id == post.id) {
                posts[i].attachments = post.attachments;
                posts[i].canDelete = post.canDelete;
                posts[i].canEdit = post.canEdit;
                posts[i].canPin = post.canPin;
                posts[i].comments = post.comments;
                posts[i].copyHistory = post.copyHistory;
                posts[i].copyright = post.copyright;
                posts[i].createdBy = post.createdBy;
                posts[i].donut = post.donut;
                posts[i].friendsOnly = post.friendsOnly;
                posts[i].fromId = post.fromId;
                posts[i].geo = post.geo;
                posts[i].isFavorite = post.isFavorite;
                posts[i].isPinned = post.isPinned;
                posts[i].likes = post.likes;
                posts[i].markedAsAds = post.markedAsAds;
                posts[i].posponedId = post.posponedId;
                posts[i].postSource = post.postSource;
                posts[i].postType = post.postType;
                posts[i].replyOwnerId = post.replyOwnerId;
                posts[i].replyPostId = post.replyPostId;
                posts[i].reposts = post.reposts;
                posts[i].signerId = post.signerId;
                posts[i].text = post.text;
                posts[i].views = post.views;
                return true
            }
        }
        return false
    }

    //Служебная функция для внутреннего тестирования
    fun getLast(): Post {
        return posts.last();
    }

    fun clearPosts() {
        posts = emptyArray();
    }
}