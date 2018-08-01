package ru.job4j.profession;

/**
 * @author TinaGVI
 * @since 01.08.2018
 */
public class Engineer extends Profession {
    /**
     * Инженер, строит дом.
     *
     * @param name       имя.
     * @param age        возраст.
     * @param profession профессия.
     */
    public Engineer(String name, int age, String profession) {
        super(name, age, profession);
    }

    public House bild() {
        return new House();
    }
}
