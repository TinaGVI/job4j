package ru.job4j.search.sort;

import java.util.*;

/**
 * @author TinaGVI
 * @since 24.10.18
 */
public class SortUser {

    public Set<User> sort(List<User> users) {
        return new TreeSet<>(users);
    }
}
