package org.example.service

import org.example.data.Post
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class WallServiceTest {

    @Test
    fun add() {
        val post: Post = Post(
            1, 1, 1, 1, 1, "any text",
            1, 1, false, null, null,
            null, null, null, "Any post", null,
            null, null, 2, null, false,
            false, false, false, false,
            false, null, 1
        );
        val post2: Post = Post(
            2, 2, 1, 1, 1, "any text 2",
            1, 1, false, null, null,
            null, null, null, "Any post", null,
            null, null, 2, null, false,
            false, false, false, false,
            false, null, 1
        );
        val postTest = WallService.add(post);
        assertEquals(post, postTest);
        //assertEquals(post2,postTest);
    }

    @Test
    fun update() {
        val post: Post = Post(
            1, 1, 1, 1, 1, "any text",
            1, 1, false, null, null,
            null, null, null, "Any post", null,
            null, null, 2, null, false,
            false, false, false, false,
            false, null, 1
        );
        val postSecond: Post = Post(
            2, 2, 1, 1, 1, "any text 2",
            1, 1, false, null, null,
            null, null, null, "Any post", null,
            null, null, 2, null, false,
            false, false, false, false,
            false, null, 1
        );
        val postThree: Post = Post(
            3, 3, 1, 1, 1, "any text 3",
            1, 1, false, null, null,
            null, null, null, "Any post", null,
            null, null, 2, null, false,
            false, false, false, false,
            false, null, 1
        );

        val post2: Post = Post(
            3, 2, 2, 1, 1, "any text 3 next",
            1, 1, false, null, null,
            null, null, null, "Any post next", null,
            null, null, 2, null, false,
            false, false, false, false,
            false, null, 1
        );

        WallService.clearPosts();
        val postAdd = WallService.add(post);
        val postAdd2 = WallService.add(postSecond);
        val postAdd3 = WallService.add(postThree);

        val upTest = WallService.update(post2);
        println("Результат выдан ${upTest}");
        assertEquals(true, upTest);
    }
}