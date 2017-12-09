package ru.astolbov.models;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by alex on 12/19/16.
 */
public class ItemTest {

    /**
     * Test set and get items id.
     */
    @Test
    public void whenSetItemsIdThenGetItemsId() {
        String id = "3475";
        Item item = new Item();
        item.setId(id);
        assertThat(item.getId().equals(id), is(true));
    }

    /**
     * Test set and get items name.
     */
    @Test
    public void whenSetItemsNameThenGetItemsName() {
        String name = "Test Item class";
        Item item = new Item();
        item.setName(name);
        assertThat(item.getName().equals(name), is(true));
    }

    /**
     * Test set and get items name.
     */
    @Test
    public void whenAddCommentThenGetComment() {
        Item item = new Item();
        String commentText = "one comment";
        item.addComment(commentText);
        item.addComment("two comment");
        item.addComment("three comment");
        item.addComment("four comment");
        item.addComment("five comment");
        item.addComment("six comment");
        ArrayList<Comment> comments = item.getComments();
        boolean findCommentText = false;
        for (Comment currentComment: comments) {
            if (currentComment.getCommentText().equals(commentText)) {
                findCommentText = true;
                break;
            }
        }
        assertThat(findCommentText, is(true));
    }

    /**
     * The General part tests convert item to string.
     * @param item - test item
     * @param itemData - data for item
     * @return the string representation of the menu
     */
    private String itemToString(Item item, String[] itemData) {
        String lineseparator = System.getProperty("line.separator");

        item.setId(itemData[0]);
        item.setName(itemData[1]);
        item.addComment(itemData[3]);

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Id: ".concat(itemData[0]).concat(". "));
        stringBuffer.append("Name: ".concat(itemData[1]).concat(". "));
        stringBuffer.append("Create date: ");
        stringBuffer.append(item.createDateAsString().concat(". "));
        if (itemData[2] != null) {
            item.setDescription(itemData[2]);
            stringBuffer.append("Description: ".concat(itemData[2]).concat(". "));
        }
        stringBuffer.append(lineseparator.concat(" comments: ").concat(itemData[3]));

        return stringBuffer.toString();
    }

    /**
     * Test convert item to string.
     */
    @Test
    public void whenToStringThenReturnMainFields() {

        Item item = new Item();

        String[] itemData = new String[4];
        itemData[0] = "1";
        itemData[1] = "one task";
        itemData[2] = null;
        itemData[3] = "one comment";

        String well = itemToString(item, itemData);
        String toString = item.toString();

        assertThat(toString, is(well));
    }

    /**
     * Test convert item to string with description.
     */
    @Test
    public void whenToStringThenReturnMainFieldsWithDescr() {

        Item item = new Item();

        String[] itemData = new String[4];
        itemData[0] = "1";
        itemData[1] = "one task";
        itemData[2] = "test task";
        itemData[3] = "one comment";

        String well = itemToString(item, itemData);
        String toString = item.toString();

        assertThat(toString, is(well));
    }

    @Test
    public void whenCreateNewItenThenItHaveCreateDate() {
        Item item = new Item();
        long createItemsDate = item.getCreateDate();

        assertThat(createItemsDate > 0, is(true));
    }

    @Test
    public void testEquals() {
        String testID = "1";
        String testID2 = "2";
        Item item1 = new Item();
        item1.setId(testID);

        Item item2 = new Item();
        item2.setId(testID);

        Item item3 = new Item();
        item3.setId(testID2);

        assertThat(item1.equals(null), is(false));

        assertThat(item1.equals(new String()), is(false));

        assertThat(item1.equals(item1), is(true));

        assertThat(item1.equals(item2), is(true));

        assertThat(item1.equals(item3), is(false));

    }
}
