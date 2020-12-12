package banking_atm.Controller;

import banking_atm.Model.Customer;
import banking_atm.Model.SavingAccount;
import banking_atm.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/all")
    public List<Customer> getAll() {
        return customerService.getAll();
    }

    @GetMapping("/id/{id}")
    public Customer getId(@PathVariable("id")Integer findById) {
        return customerService.getId(findById);
    }

    @PostMapping("/newsavingaccount")
    public String newSavingAccount(@RequestParam("firstName")String firstName,@RequestParam("lastName")String lastname,@RequestParam("addBalance")Integer addingBalance){

        return customerService.newSavingAccount(firstName, lastname, addingBalance);
    }

    @PostMapping("/newcheckingaccount")
    public String newCheckingAccount(@RequestParam("firstName")String firstName,@RequestParam("lastName")String lastname,@RequestParam("addBalance")Integer addingBalance){

        return customerService.newCheckingAccount(firstName, lastname, addingBalance);
    }

    @PostMapping("/newcheckingnsavingaccount")
    public String newCheckingNSavingAccount(@RequestParam("firstName")String firstName,@RequestParam("lastName")String lastname,@RequestParam("addBalancechecking")Integer addingBalanceChecking,@RequestParam("addBalancesaving")Integer addingBalanceSaving){

        return customerService.newCheckingNSavingAccount(firstName, lastname, addingBalanceChecking, addingBalanceSaving);
    }

    @DeleteMapping(value = "/closeaccount")
    public String closeAccounts(@RequestParam("id") Integer id){
        return customerService.closeAccount(id);
    }

}
