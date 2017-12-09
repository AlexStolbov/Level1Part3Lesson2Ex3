package ru.astolbov.models;

/**
 * Комментарии к задачам
 * Created by alex on 12/13/16.
 */
public class Comment {
    /**
     * Text of comment.
     */
    private String commentText;

    /**
     * Setter commentTest.
     * @param setCommentText - text of comment
     */
    public void setComment(String setCommentText) {
        this.commentText = setCommentText;
    }

    /**
     * Getter commentText.
     * @return text of comment
     */
    public String getCommentText() {
        return this.commentText;
    }
}
