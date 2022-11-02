package org.example.data.includeClasses

class Comment(
    var count: Int,
    var can_post: Boolean,
    var groups_can_post: Boolean,
    var can_close: Boolean,
    var can_open: Boolean
) {
    override fun toString(): String {
        return "Comment(count: ${count}, can_post: ${can_post},\n" +
                "    groups_can_post: ${groups_can_post},\n" +
                "    var can_close: ${can_close},\n" +
                "    var can_open: ${can_open}"
    }
}
