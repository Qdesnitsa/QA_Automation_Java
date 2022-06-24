package by.it_academy.l3_sql_jdbc.entity;

import java.math.BigDecimal;
import java.util.Objects;

public class Transaction {
    private int id;
    private BigDecimal amount;
    private int account_id;
    private TypeTransaction typeTransaction;

    public enum TypeTransaction {
        REPLENISHMENT, DRAWING
    }

    private Transaction() {
    }

    public Transaction(BigDecimal amount, int account_id, TypeTransaction typeTransaction) {
        this.amount = amount;
        this.account_id = account_id;
        this.typeTransaction = typeTransaction;
    }

    public int getId() {
        return id;
    }

    public int getAccount_id() {
        return account_id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public TypeTransaction getTypeTransaction() {
        return typeTransaction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return id == that.id && account_id == that.account_id && Objects.equals(amount, that.amount) &&
                typeTransaction == that.typeTransaction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, account_id, typeTransaction);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                "id=" + id +
                ", amount=" + amount +
                ", account_id=" + account_id +
                ", typeTransaction=" + typeTransaction +
                "; ";
    }

    public static class Builder {
        private final Transaction newTransaction;

        public Builder() {
            newTransaction = new Transaction();
        }

        public Builder setId(int id) {
            newTransaction.id = id;
            return this;
        }

        public Builder setAccount_id(int account_id) {
            newTransaction.account_id = account_id;
            return this;
        }

        public Builder setAmount(BigDecimal amount) {
            newTransaction.amount = amount;
            return this;
        }

        public Builder setTypeTransaction(TypeTransaction typeTransaction) {
            newTransaction.typeTransaction = typeTransaction;
            return this;
        }

        public Transaction build() {
            return newTransaction;
        }
    }
}
