package ru.job4j.input;

import ru.job4j.exception.MenuOutException;

public class ValidateInput implements Input {

    private final Input input;

    public ValidateInput(final Input input) {
        this.input = input;
    }

    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = this.input.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Пожалуйста введите число из меню");
            } catch (NumberFormatException nfe) {
                System.out.println("Пожалуйста введите число из номеров меню от 1 до 6");
            }
        } while (invalid);
        return value;
    }
}
