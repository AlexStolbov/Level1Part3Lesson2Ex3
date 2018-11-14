package ru.astolbov.models;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Item
 * Задача
 * Created by alex on 12/13/16.
 */
public class Item {

    /**
     * Unique identifier.
     */
    private String id;

    /**
     * The name of the item.
     */
    private String name;

    /**
     * The description of the item.
     */
    private String description;

    /**
     * Array of comment of the items.
     */
    //private Comment[] comments = new Comment[5];
    private ArrayList<Comment> comments;

    /**
     * Date create.
     */
    private long createDate;

    /**
     * Constructor.
     */
    public Item() {
        this.createDate = System.currentTimeMillis();
        comments = new ArrayList<>();
    }

    /**
     * Setter id.
     * @param setid - id for set
     */
    public void setId(String setid) {
        this.id = setid;
    }

    /**
     * Getter id.
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * Setter name.
     * @param setname - name for set
     */
    public void setName(String setname) {
        this.name = setname;
    }

    /**
     * Getter name.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter description.
     * @param setdescription - description
     */
    public void setDescription(String setdescription) {
        this.description = setdescription;
    }

    /**
     * Getter description.
     * @return - description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Getter createDate.
     * @return - createDate
     */
    public long getCreateDate() {
        return createDate;
    }

    /**
     * Return createDate as string.
     * @return date in human format
     */
    public String createDateAsString() {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTimeInMillis(this.getCreateDate());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");

        return sdf.format(gregorianCalendar.getTime());
    }

    /**
     * Add new comment into comments.
     * @param commentText - text of comment
     */
    public void addComment(String commentText) {
        Comment newComment = new Comment();
        newComment.setComment(commentText);
        comments.add(newComment);
    }

    /**
     * Getter comments.
     * @return - array of comments
     */
    public ArrayList<Comment> getComments() {
        return comments;
    }

    /**
     * The string representation of the Item.
     * @return the string representation of the menu
     */
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Id: ".concat(this.id).concat(". "));
        stringBuffer.append("Name: ".concat(this.name).concat(". "));
        stringBuffer.append("Create date: ".concat(createDateAsString()).concat(". "));
        if (this.description != null) {
            stringBuffer.append("Description: ".concat(this.description).concat(". "));
        }
        List<Comment> comments = getComments();
        stringBuffer.append(System.lineSeparator());
        if (comments.size() == 0) {
            stringBuffer.append(" No comments.");
        } else {
            for (Comment comment:comments) {
                if (comment != null) {
                    stringBuffer.append(" comments: ");
                    stringBuffer.append(comment.getCommentText());
                }
            }
        }
        return stringBuffer.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return id.equals(item.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
