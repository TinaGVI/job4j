package ru.job4j.profession;

public class Doctor extends Profession {
    public Doctor(String name, int age, String profession) {
        super(name, age, profession);
    }

    public Diagnose heal(Pacient pacient) {
        return new Diagnose();

    }
}
