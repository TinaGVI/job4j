package ru.job4j.profession;

public class Profession {
    public String name;
    public int age;
    public String profession;

    public Profession() {

    }

    public Profession(String name, int age, String profession) {
        this.name = name;
        this.age = age;
        this.profession = profession;

    }

    public String getName() {
        return this.name;
    }
}
