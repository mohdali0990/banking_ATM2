package banking_atm.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name="customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="customer_id")
    private Integer customerId;
    @Column(name="first_name")
    @NotNull(message = "please enter first name.")
    @Size(min = 5,max = 30)
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="status")
    private String status;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="customer_id", referencedColumnName = "customer_id")
    private List<SavingAccount> savingAccount;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="customer_id", referencedColumnName = "customer_id")
    private List<CheckingAccount>checkingAccount;

    public Customer() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<CheckingAccount> getCheckingAccount() {
        return checkingAccount;
    }

    public void setCheckingAccount(List<CheckingAccount> checkingAccount) {
        this.checkingAccount = checkingAccount;
    }

    public List<SavingAccount> getSavingAccount() {
        return savingAccount;
    }

    public void setSavingAccount(List<SavingAccount> savingAccount) {
        this.savingAccount = savingAccount;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}
