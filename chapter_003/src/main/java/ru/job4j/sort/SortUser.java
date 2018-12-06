package ru.job4j.sort;

import java.util.*;

/**
 * Sort сортировка по имени и возрасту.
 *
 * @author TinaGVI
 * @since 24.10.18
 */
public class SortUser {

    public Set<User> sort(List<User> users) {
        return new TreeSet<>(users);
    }

    public List<User> sortNameLength(List<User> users) {
        Comparator<User> comp = new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        Collections.sort(users, comp);
        return users;
    }

    public List<User> sortByAllFields(List<User> users) {
        Comparator<User> comp = new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                int res = o1.compareTo(o2);
                return res != 0 ? res : Integer.compare(o1.getAge(), o2.getAge());
            }
        };
        Collections.sort(users, comp);
        return users;
    }
}