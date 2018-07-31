package ru.job4j.profession;

public class Teacher extends Profession {
    public Teacher(String name, int age, String profession) {
        super(name, age, profession);
    }

    public void teach(Student student) {

    }

    class Student {
        String name;
    }
}
