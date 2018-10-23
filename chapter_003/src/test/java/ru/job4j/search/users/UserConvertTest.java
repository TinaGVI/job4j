package ru.job4j.search.users;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;


public class UserConvertTest {
    /**
     * Test преобразования List в Map.
     */
    @Test
    public void testConversionListToMap() {
        User user1 = new User(1, "Трям", "Вологда");
        User user2 = new User(2, "Толя", "Москва");
        User user3 = new User(3, "Дурак", "Киев");
        User user4 = new User(4, "Странный", "Самара");

        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);

        UserConvert convert = new UserConvert();
        Map<Integer, User> userMap = convert.process(userList);

        Map<Integer, User> expectedMap = new HashMap<>();
        expectedMap.put(1, user1);
        expectedMap.put(2, user2);
        expectedMap.put(3, user3);
        expectedMap.put(4, user4);

        assertThat(userMap, is(expectedMap));
    }
}
