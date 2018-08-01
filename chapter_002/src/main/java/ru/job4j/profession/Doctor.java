package ru.job4j.profession;

/**
 * @author TinaGVI
 * @since 01.08.18
 */
public class Doctor extends Profession {
    /**
     * Доктор лечит пациентов и ставит диагнозы.
     *
     * @param name       имя.
     * @param age        возраст.
     * @param profession профессия.
     */
    public Doctor(String name, int age, String profession) {
        super(name, age, profession);
    }

    public Diagnose heal(Pacient pacient) {
        return new Diagnose();

    }
}
