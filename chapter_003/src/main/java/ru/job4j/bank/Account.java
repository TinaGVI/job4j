package ru.job4j.bank;

/**
 * Class Account.
 * Переменные - value, requisites.
 *
 * @author TinaGVI (mailto:eleonor111@list.ru)
 * @Override - equals и hashCode.
 * @since 22.11.2018
 */
public class Account {

    private double value;
    private String requisites;

    public Account(double value, String requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    public double getValue() {
        return this.value;
    }


    public String getRequisites() {
        return this.requisites;
    }

    public void setRequisites(String requisites) {
        this.requisites = requisites;
    }

    public void setValue(double values) {
        this.value = values;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return this.requisites.equals(account.requisites);
    }

    @Override
    public int hashCode() {
        return this.requisites.hashCode();
    }
}
