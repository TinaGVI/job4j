package ru.job4j.bank;

import java.util.*;

/**
 * Class Bank.
 * Добавление, удаление - пользователя, аккаунтов.
 * Трансфер денег с одного аккаунта на другой.
 *
 * @author TinaGVI (mailto:eleonor111@list.ru)
 * @since 22.11.2018
 */
public class Bank {

    private Map<User, List<Account>> userAccounts = new TreeMap<>();

    public void addUser(User user) {
        this.userAccounts.putIfAbsent(user, new ArrayList<>());
    }

    public Set<User> getUsers() {
        return userAccounts.keySet();
    }

    public void deleteUser(User user) {
        this.userAccounts.remove(user);
    }

    public void addAccountToUser(String passport, Account account) {
        if (passport != null && account != null) {
            for (User user : userAccounts.keySet()) {
                if (user.getPassport().equals(passport)) {
                    this.userAccounts.get(user).add(account);
                    break;
                }
            }
        }
    }

    public void deleteAccountFromUser(String passport, Account account) {
        for (Map.Entry<User, List<Account>> i : userAccounts.entrySet()) {
            if (passport.equals(i.getKey().getPassport())) {
                i.getValue().remove(account);
                break;
            }
        }
    }

    public List<Account> getUserAccounts(String passport) {
        List<Account> result = new ArrayList<>();
        for (User user : userAccounts.keySet()) {
            if (passport.equals(user.getPassport())) {
                result = userAccounts.get(user);
                break;
            }
        }
        return result;
    }

    public void deleteAccount(User user, Account account) {
        this.userAccounts.get(user).remove(account);
    }

    public List<Account> getAccounts(User user) {
        return this.userAccounts.get(user);
    }

    public Account getAccount(String passport, String requisites) {
        Account result = null;
        for (Account acc : getUserAccounts(passport)) {
            if (acc.getRequisites().equals(requisites)) {
                result = acc;
                break;
            }
        }
        return result;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String dstRequisite, double amount) {
        if (srcPassport == null && srcRequisite == null
                && destPassport == null && dstRequisite == null) {
            return false;
        }
        Account source = getAccount(srcPassport, srcRequisite);
        Account destination = getAccount(destPassport, dstRequisite);
        boolean success = false;
        if (source != null && amount <= source.getValue() && destination != null) {
            destination.setValue(destination.getValue() + amount);
            source.setValue(source.getValue() - amount);
            success = true;
        }
        return success;
    }
}

