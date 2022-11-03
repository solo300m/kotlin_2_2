package org.example.service

import org.example.data.Post
import org.example.data.includeClasses.Comment
import org.example.data.includeClasses.Repost
import java.lang.NullPointerException
import java.lang.RuntimeException

object WallService {
    private var posts = emptyArray<Post>();
    private var comments = emptyArray<Comment>();

    fun createComment(postId: Int, comment: Comment): Comment? {
        for ((index, post) in posts.withIndex()) {
            if (post.id == postId) {
                if (posts[index].comments == null) {
                    posts[index].comments = comments;
                }
                //println(posts[index].comments?.size);
                var list: MutableList<Comment> = posts[index].comments!!.toMutableList();
                list.add(comment);
                posts[index].comments = list.toTypedArray();
                //println(posts[index].comments?.size)
                var newComment = posts[index].comments?.last();
                return newComment;
            }
        }
        throw PostNotFoundException("Нет Поста с id ${postId}");
        return null;
    }

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

class PostNotFoundException(message: String) : RuntimeException(message);