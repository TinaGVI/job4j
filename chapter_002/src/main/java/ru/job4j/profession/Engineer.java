package ru.job4j.profession;

public class Engineer extends Profession {
    public Engineer(String name, int age, String profession) {
        super(name, age, profession);
    }

    public House bild() {
        return new House();
    }
}
