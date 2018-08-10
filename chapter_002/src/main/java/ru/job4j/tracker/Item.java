package ru.job4j.tracker;

import java.util.Objects;


/**
 * @author TinaGVI
 * @since 10.08.2018
 */
public class Item {
    private String id;
    private String name;
    private String description;
    private long value;

    Item(String name, String description, long value) {
        this.name = name;
        this.description = description;
        this.value = value;

    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
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
        return Objects.equals(id, item.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
