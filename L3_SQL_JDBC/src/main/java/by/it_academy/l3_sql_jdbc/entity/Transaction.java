package by.it_academy.l3_sql_jdbc.entity;

import java.math.BigDecimal;
import java.util.Objects;

public class Transaction {
    private int id;
    private BigDecimal amount;
    private TypeTransaction typeTransaction;

    public enum TypeTransaction {
        REPLENISHMENT, DRAWING
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public TypeTransaction getTypeTransaction() {
        return typeTransaction;
    }

    public void setTypeTransaction(TypeTransaction typeTransaction) {
        this.typeTransaction = typeTransaction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return id == that.id && Objects.equals(amount, that.amount) && typeTransaction == that.typeTransaction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, typeTransaction);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                "id=" + id +
                ", amount=" + amount +
                ", typeTransaction=" + typeTransaction;
    }
}
