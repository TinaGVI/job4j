package ru.job4j.sort;


import java.util.*;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author TinaGVI
 * @since 24.10.18
 */
public class SortUserTest {
    @Test
    public void testSortUsingComparable() {
        List<User> userList = new ArrayList<>();
        userList.add(new User("Саша ", 56));
        userList.add(new User("CАня ", 16));
        userList.add(new User("Саша ", 52));
        userList.add(new User("Костя ", 26));
        userList.add(new User("Паша ", 36));
        SortUser su = new SortUser();
        Set<User> actual = su.sort(userList);
        Set<User> expected = new TreeSet<>();
        expected.add(new User("CАня ", 16));
        expected.add(new User("Костя ", 26));
        expected.add(new User("Паша ", 36));
        expected.add(new User("Саша ", 52));
        expected.add(new User("Саша ", 56));
        assertThat(actual, is(expected));
    }
}
