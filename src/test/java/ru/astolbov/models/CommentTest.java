package ru.astolbov.models;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by alex on 12/19/16.
 */
public class CommentTest {

    /**
     * Test set and get comment text.
     */
    @Test
    public void whenSetCommentsTextThenGetItemsText() {
        String commentText = "Do it now";
        Comment comment = new Comment();
        comment.setComment(commentText);
        assertThat(comment.getCommentText() == commentText, is(true));
    }
}
