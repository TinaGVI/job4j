package ru.job4j.bank;

import java.util.Objects;

/**
 * @author TinaGVI
 * @since 24.10.18
 */
public class User implements Comparable<User> {
    private String name;
    private String passport;

    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(int age) {
        this.passport = passport;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport)
                && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, passport);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        sb.append(this.name).append("; passport=").append(this.passport).append("}");
        return sb.toString();
    }

    @Override
    public int compareTo(User o) {
        return this.passport.compareTo(o.passport);
    }
}
