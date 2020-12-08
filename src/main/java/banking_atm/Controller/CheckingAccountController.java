package banking_atm.Controller;

import banking_atm.Model.CheckingAccount;
import banking_atm.Model.Customer;
import banking_atm.Repo.CheckingAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/checking")
public class CheckingAccountController {

    @Autowired
    private CheckingAccountRepo checkingAccountRepo;

    @PutMapping(value="/deposit")
    public CheckingAccount deposit(@RequestParam("addBalance")Integer addBalance,@RequestParam("id") Integer id){

        CheckingAccount checkingAccount=checkingAccountRepo.findById(id).get();
         int balance = checkingAccount.getBalance();
         int newBalance = balance + addBalance;
         checkingAccount.setAddOrMinusBalance(addBalance);
         checkingAccount.setBalance(balance);
         checkingAccount.setNewBalance(newBalance);
         checkingAccountRepo.save(checkingAccount);

         return checkingAccountRepo.findById(id).get();

    }

    @PutMapping(value="/withdrawal")
    public CheckingAccount withdrawal(@RequestParam("minusBalance")Integer minusBalance,@RequestParam("id") Integer id){

        CheckingAccount checkingAccount=checkingAccountRepo.findById(id).get();
        int balance = checkingAccount.getBalance();
        int newBalance = balance - minusBalance;
        checkingAccount.setAddOrMinusBalance(minusBalance);
        checkingAccount.setBalance(balance);
        checkingAccount.setNewBalance(newBalance);
        checkingAccountRepo.save(checkingAccount);

        return checkingAccountRepo.findById(id).get();

    }

    @GetMapping(value="/getAccount/{id}")
    public CheckingAccount getAccount(@PathVariable("id")Integer id){
        return checkingAccountRepo.findById(id).get();
    }

    @GetMapping(value = "/all")
    public List<CheckingAccount> allCheckingAccounts() {

        return checkingAccountRepo.findAll();
    }
    @PostMapping("/newcheckingaccount")
    public String newAccount(@RequestParam("firstName")String firstName,@RequestParam("lastName")String lastname,@RequestParam("addBalance")Integer addingBalance){

        //@RequestParam ("balance")Integer balance,@RequestParam("addBalance")Integer addingBalance,@RequestParam("new_balance") Integer newBalnce
        CheckingAccount checkingAccount = new CheckingAccount();
        checkingAccount.setBalance(addingBalance);
        checkingAccount.setAddOrMinusBalance(addingBalance);
        checkingAccount.setNewBalance(addingBalance);

        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastname);

        checkingAccount.setCustomer(customer);

        checkingAccountRepo.save(checkingAccount);

        return "Account Created";
    }



}
