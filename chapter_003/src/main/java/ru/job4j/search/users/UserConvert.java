package ru.job4j.search.users;

/**
 * Класс преобразования List в Map..
 *
 * @author TinaGVI
 * @since 23.10.2018
 */

        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;

public class UserConvert {
    public HashMap<Integer, User> process(List<User> list) {
        Map<Integer, User> users = new HashMap<>();
        for (User user : list) {
            users.put(user.getId(), user);
        }
        return (HashMap<Integer, User>) users;
    }
}
