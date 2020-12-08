package banking_atm.Controller;

import banking_atm.Model.CheckingAccount;
import banking_atm.Model.Customer;
import banking_atm.Model.SavingAccount;
import banking_atm.Repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerRepo customerRepo;

    @GetMapping("/all")
    public List<Customer> getAll() {
        return customerRepo.findAll();
    }

    @GetMapping("/id/{id}")
    public Customer getId(@PathVariable("customer_Id") final Integer findById) {
        return customerRepo.findById(findById).get();
    }

    @PostMapping("/newsavingaccount")
    public String newSavingAccount(@RequestParam("firstName")String firstName,@RequestParam("lastName")String lastname,@RequestParam("addBalance")Integer addingBalance){

        //@RequestParam ("balance")Integer balance,@RequestParam("addBalance")Integer addingBalance,@RequestParam("new_balance") Integer newBalnce
        SavingAccount savingAccount = new SavingAccount();
        savingAccount.setBalance(addingBalance);
        savingAccount.setAddorMinusBalance(addingBalance);
        savingAccount.setNewBalance(addingBalance);

        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastname);

        //checkingAccount.setCustomer(customer);
        customer.setSavingAccount(Arrays.asList(savingAccount));

       customerRepo.save(customer);

        return "Account Created";
    }

    @PostMapping("/newcheckingaccount")
    public String newCheckingAccount(@RequestParam("firstName")String firstName,@RequestParam("lastName")String lastname,@RequestParam("addBalance")Integer addingBalance){

        //@RequestParam ("balance")Integer balance,@RequestParam("addBalance")Integer addingBalance,@RequestParam("new_balance") Integer newBalnce
        CheckingAccount checkingAccount = new CheckingAccount();
        checkingAccount.setBalance(addingBalance);
        checkingAccount.setAddOrMinusBalance(addingBalance);
        checkingAccount.setNewBalance(addingBalance);

        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastname);

        //checkingAccount.setCustomer(customer);
        customer.setCheckingAccount(Arrays.asList(checkingAccount));

        customerRepo.save(customer);

        return "Account Created";
    }

    @PostMapping("/newcheckingnsavingaccount")
    public String newCheckingNSavingAccount(@RequestParam("firstName")String firstName,@RequestParam("lastName")String lastname,@RequestParam("addBalancechecking")Integer addingBalanceChecking,@RequestParam("addBalancesaving")Integer addingBalanceSaving){

        //@RequestParam ("balance")Integer balance,@RequestParam("addBalance")Integer addingBalance,@RequestParam("new_balance") Integer newBalnce
        CheckingAccount checkingAccount = new CheckingAccount();
        checkingAccount.setBalance(addingBalanceChecking);
        checkingAccount.setAddOrMinusBalance(addingBalanceChecking);
        checkingAccount.setNewBalance(addingBalanceChecking);

        SavingAccount savingAccount = new SavingAccount();
        savingAccount.setBalance(addingBalanceSaving);
        savingAccount.setAddorMinusBalance(addingBalanceSaving);
        savingAccount.setNewBalance(addingBalanceSaving);


        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastname);

        //checkingAccount.setCustomer(customer);
        customer.setCheckingAccount(Arrays.asList(checkingAccount));
        customer.setSavingAccount(Arrays.asList(savingAccount));


        customerRepo.save(customer);

        return "Accounts Created";
    }

}
