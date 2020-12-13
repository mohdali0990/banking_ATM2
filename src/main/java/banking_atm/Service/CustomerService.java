package banking_atm.Service;

import banking_atm.Model.CheckingAccount;
import banking_atm.Model.Customer;
import banking_atm.Model.SavingAccount;
import banking_atm.Repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    public List<Customer> getAll() {
        return customerRepo.findAll();
    }

    public Customer getId(Integer findById) {
        return customerRepo.findById(findById).get();
    }

    public String newSavingAccount(String firstName, String lastname, Integer addingBalance) {

        SavingAccount savingAccount = new SavingAccount();
        savingAccount.setBalance(addingBalance);
        savingAccount.setAddorMinusBalance(addingBalance);
        savingAccount.setNewBalance(addingBalance);
        savingAccount.setStatus("active");

        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastname);
        customer.setStatus("active");

        customer.setSavingAccount(Arrays.asList(savingAccount));

        customerRepo.save(customer);

        return "Account Created";
    }

    public String newCheckingAccount(String firstName, String lastname, Integer addingBalance) {

        CheckingAccount checkingAccount = new CheckingAccount();
        checkingAccount.setBalance(addingBalance);
        checkingAccount.setAddOrMinusBalance(addingBalance);
        checkingAccount.setNewBalance(addingBalance);
        checkingAccount.setStatus("active");

        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastname);
        customer.setStatus("active");

        customer.setCheckingAccount(Arrays.asList(checkingAccount));

        customerRepo.save(customer);

        return "Account Created";
    }

    public String newCheckingNSavingAccount(String firstName, String lastname, Integer addingBalanceChecking, Integer addingBalanceSaving) {

        CheckingAccount checkingAccount = new CheckingAccount();
        checkingAccount.setBalance(addingBalanceChecking);
        checkingAccount.setAddOrMinusBalance(addingBalanceChecking);
        checkingAccount.setNewBalance(addingBalanceChecking);
        checkingAccount.setStatus("active");

        SavingAccount savingAccount = new SavingAccount();
        savingAccount.setBalance(addingBalanceSaving);
        savingAccount.setAddorMinusBalance(addingBalanceSaving);
        savingAccount.setNewBalance(addingBalanceSaving);
        savingAccount.setStatus("active");


        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastname);
        customer.setStatus("active");

        customer.setCheckingAccount(Arrays.asList(checkingAccount));
        customer.setSavingAccount(Arrays.asList(savingAccount));


        customerRepo.save(customer);

        return "Accounts Created";
    }

    public String closeAccount(Integer id) {
        Customer customer = customerRepo.findById(id).get();
        customer.setStatus("inactive");

        List<CheckingAccount>list = customer.getCheckingAccount();
        CheckingAccount checkingAccount = new CheckingAccount();
        checkingAccount.setBalance(null);
        checkingAccount.setAddOrMinusBalance(null);
        checkingAccount.setNewBalance(null);
        checkingAccount.setStatus("inactive");
        list.add(checkingAccount);


        List<SavingAccount>list1 = customer.getSavingAccount();
        SavingAccount savingAccount = new SavingAccount();
        savingAccount.setBalance(null);
        savingAccount.setAddorMinusBalance(null);
        savingAccount.setNewBalance(null);
        savingAccount.setStatus("inactive");
        list1.add(savingAccount);

        customer.setCheckingAccount(list);
        customer.setSavingAccount(list1);


        customerRepo.save(customer);

        return "Accounts Closed";
    }


}