package ru.job4j.tracker.actions;

/**
 * @author TinaGVI
 * @since 11.09.18
 */
public abstract class BaseAction implements UserAction {
    private final int key;
    private final String name;

    protected BaseAction(final int key, final String name) {
        this.key = key;
        this.name = name;
    }

    @Override
    public int key() {
        return this.key;
    }

    @Override
    public String info() {
        return String.format("%d.%s", this.key, this.name);
    }
}