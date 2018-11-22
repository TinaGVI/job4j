package ru.job4j.bank;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Test.
 *
 * @author TinaGVI (mailto:eleonor111@list.ru)
 * @since 22.11.2018
 */
public class BankTest {

    @Test
    public void addUser() {
        Bank bank = new Bank();
        User user = new User("Alex", "AAA111");
        bank.addUser(user);
        Set<User> actual = bank.getUsers();
        Set<User> expected = new TreeSet<>();
        expected.add(new User("Alex", "AAA111"));
        assertThat(actual, is(expected));
    }

    @Test
    public void deleteUser() {
        Bank bank = new Bank();
        User user1 = new User("Alex", "AAA111");
        User user2 = new User("Toha", "AAA222");
        User user3 = new User("Katy", "AAA333");
        bank.addUser(user1);
        bank.addUser(user2);
        bank.addUser(user3);
        bank.deleteUser(user1);
        Set<User> actual = bank.getUsers();
        Set<User> expected = new TreeSet<>();
        expected.add(new User("Toha", "AAA222"));
        expected.add(new User("Katy", "AAA333"));
        assertThat(actual, is(expected));
    }

    @Test
    public void addAccountToUser() {
        Bank bank = new Bank();
        Account account1 = new Account(22.333, "Регистр1");
        Account account2 = new Account(42.333, "Регистр2");
        User user = new User("Alex", "AAA111");
        bank.addUser(user);
        bank.addAccountToUser("AAA111", account1);
        bank.addAccountToUser("AAA111", account2);
        List<Account> actual = bank.getUserAccounts("AAA111");
        List<Account> expected = new ArrayList<>();
        expected.add(new Account(22.333, "Регистр1"));
        expected.add(new Account(42.333, "Регистр2"));
        assertThat(actual, is(expected));
    }

    @Test
    public void deleteAccountFromUser() {
        Bank bank = new Bank();
        Account account1 = new Account(22.333, "Регистр1");
        Account account2 = new Account(42.333, "Регистр2");
        User user = new User("Alex", "AAA111");
        bank.addUser(user);
        bank.addAccountToUser("AAA111", account1);
        bank.addAccountToUser("AAA111", account2);
        bank.deleteAccountFromUser("AAA111", account1);
        List<Account> actual = bank.getUserAccounts("AAA111");
        List<Account> expected = new ArrayList<>();
        expected.add(new Account(42.333, "Регистр2"));
        assertThat(actual, is(expected));
    }

    @Test
    public void getUserAccounts() {
        Bank bank = new Bank();
        Account account1 = new Account(22.333, "Регистр1");
        Account account2 = new Account(42.333, "Регистр2");
        User user = new User("Alex", "AAA111");
        bank.addUser(user);
        bank.addAccountToUser("AAA111", account1);
        bank.addAccountToUser("AAA111", account2);
        bank.getUserAccounts("AAA111");
        List<Account> actual = bank.getUserAccounts("AAA111");
        List<Account> expected = new ArrayList<>();
        expected.add(new Account(22.333, "Регистр1"));
        expected.add(new Account(42.333, "Регистр2"));
        assertThat(actual, is(expected));
    }

    @Test
    public void deleteAccount() {
        Bank bank = new Bank();
        Account account1 = new Account(22.333, "Регистр1");
        Account account2 = new Account(42.333, "Регистр2");
        User user = new User("Alex", "AAA111");
        bank.addUser(user);
        bank.addAccountToUser("AAA111", account1);
        bank.addAccountToUser("AAA111", account2);
        bank.deleteAccount(user, account1);
        List<Account> actual = bank.getUserAccounts("AAA111");
        List<Account> expected = new ArrayList<>();
        expected.add(new Account(42.333, "Регистр2"));
        assertThat(actual, is(expected));
    }

    @Test
    public void getAccount() {
        Bank bank = new Bank();
        Account account1 = new Account(22.333, "Регистр1");
        Account account2 = new Account(42.333, "Регистр2");
        User user = new User("Alex", "AAA111");
        bank.addUser(user);
        bank.addAccountToUser("AAA111", account1);
        bank.addAccountToUser("AAA111", account2);
        Account actual = bank.getAccount("AAA111", "Регистр1");
        Account expected = new Account(22.333, "Регистр1");
        assertThat(actual, is(expected));
    }

    @Test
    public void transferMoney() {
        Bank bank = new Bank();
        Account account1 = new Account(22.333, "Регистр1");
        Account account2 = new Account(42.333, "Регистр2");
        User user = new User("Alex", "AAA111");
        bank.addUser(user);
        bank.addAccountToUser("AAA111", account1);
        bank.addAccountToUser("AAA111", account2);
        boolean actual = bank.transferMoney("AAA111", "Регистр1",
                "AAA111", "Регистр2", 10.000);
        assertThat(true, is(actual));
    }
}