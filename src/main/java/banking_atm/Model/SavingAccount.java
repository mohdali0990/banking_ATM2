package banking_atm.Model;

import javax.persistence.*;

@Entity
@Table(name="saving_account")
public class SavingAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="saving_id")
    private Integer savingId;
    @Column(name="balance")
    private Integer balance;
    @Column(name="add_subtract_balance")
    private Integer addOrMinusBalance;
    @Column(name="new_balance")
    private Integer newBalance;
    @Column(name="customer_id")
    private Integer customerId;

    public SavingAccount() {
    }

    public SavingAccount(Integer savingId, Integer balance, Integer addorMinusBalance, Integer newBalance, Integer customerId) {
        this.savingId = savingId;
        this.balance = balance;
        this.addOrMinusBalance = addorMinusBalance;
        this.newBalance = newBalance;
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "SavingAccount{" +
                "savingId=" + savingId +
                ", balance=" + balance +
                ", addorMinusBalance=" + addOrMinusBalance +
                ", newBalance=" + newBalance +
                ", customerId=" + customerId +
                '}';
    }

    public Integer getSavingId() {
        return savingId;
    }

    public void setSavingId(Integer savingId) {
        this.savingId = savingId;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Integer getAddorMinusBalance() {
        return addOrMinusBalance;
    }

    public void setAddorMinusBalance(Integer addorMinusBalance) {
        this.addOrMinusBalance = addorMinusBalance;
    }

    public Integer getNewBalance() {
        return newBalance;
    }

    public void setNewBalance(Integer newBalance) {
        this.newBalance = newBalance;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
}
