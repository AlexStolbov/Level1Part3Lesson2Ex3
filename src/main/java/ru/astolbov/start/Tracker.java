package ru.astolbov.start;

import ru.astolbov.models.Item;

import java.util.ArrayList;
import java.util.Random;

/**
 * Tracker.
 * Выполняет роль базы для задач
 * Created by alex on 12/13/16.
 */
public class Tracker {
    /**
     * Array of items.
     */
    //private Item[] items = new Item[this.maxItems];
    private ArrayList<Item> items = new ArrayList<>();

    /**
     * Create random items id.
     */
    private final Random rN = new Random();

    /**
     * Generate new items id.
     * @return new id
     */
    private String generateId() {
        return Integer.toString(rN.nextInt(1000));
    }

    /**
     * Find item by id.
     * @param findId - id
     * @return position of item
     */
    public Item findById(String findId) {
        Item findItem = null;

        for (Item currentItem : items) {
            if (currentItem != null && currentItem.getId().equals(findId)) {
                findItem = currentItem;
                break;
            }
        }

        return findItem;
    }

    /**
     * Add new item.
     * @param item - new item.
     */
    public void addItem(Item item) {
        if (item != null && item.getId() == null && findById(item.getId()) == null) {
            item.setId(generateId());
            items.add(item);
        }
    }

    /**
     * Edit item.
     * set new name and description
     * @param editId - id of item to edit
     * @param name - name
     * @param descr - description
     */
    public void editItem(String editId, String name, String descr) {
        Item item = findById(editId);
        if (item != null) {
            item.setName(name);
            item.setDescription(descr);
        }
    }

    /**
     * Delete item from array this.items.
     * @param deleteId - the id of item to be deleted
     */
    public void deleteItem(String deleteId) {
        Item item = findById(deleteId);
        if (item != null) {
            this.items.remove(item);
        }
    }

    /**
     * Getter for items.
     * @return - this.items
     */
    public ArrayList<Item> getItems() {
        return this.items;
    }

}
