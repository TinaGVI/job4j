package ru.job4j.profession;

/**
 * @author TinaGVI
 * @since 01.08.2018
 */
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

    public int getAge() {
        return this.age;
    }

    public String getProfession() {
        return this.profession;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
}
