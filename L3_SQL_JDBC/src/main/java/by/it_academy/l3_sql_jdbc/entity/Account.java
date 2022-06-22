package by.it_academy.l3_sql_jdbc.entity;

import java.math.BigDecimal;
import java.util.Objects;

public class Account {
    private int account_id;
    private int user_id;
    private BigDecimal balance;
    private Currency currency;

    public enum Currency {
        BYN, RUB, PLN, USD, EUR, GBP, CAD, CNY, NZD, CHF
    }

    private Account() {}

    public Account(int account_id, int user_id, BigDecimal balance, Currency currency) {
        this.account_id = account_id;
        this.user_id = user_id;
        this.balance = balance;
        this.currency = currency;
    }

    public int getAccount_id() {
        return account_id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public Currency getCurrency() {
        return currency;
    }

    public int getUser_id() {
        return user_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return account_id == account.account_id && user_id == account.user_id &&
                Objects.equals(balance, account.balance) && currency == account.currency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(account_id, user_id, balance, currency);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                "account_id=" + account_id +
                ", user_id=" + user_id +
                ", balance=" + balance +
                ", currency=" + currency;
    }

    public static class Builder {
        private final Account newAccount;

        public Builder() {
            newAccount = new Account();
        }

        public Builder setAccountId(int account_id) {
            newAccount.account_id = account_id;
            return this;
        }

        public Builder setUser_id(int user_id) {
            newAccount.user_id = user_id;
            return this;
        }

        public Builder setBalance(BigDecimal balance) {
            newAccount.balance = balance;
            return this;
        }

        public Builder setCurrency(Currency currency) {
            newAccount.currency = currency;
            return this;
        }

        public Account build() {
            return newAccount;
        }
    }
}
