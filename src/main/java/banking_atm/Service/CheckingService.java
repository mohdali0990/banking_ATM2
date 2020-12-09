package banking_atm.Service;

import banking_atm.Model.CheckingAccount;
import banking_atm.Repo.CheckingAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CheckingService {

    @Autowired
    private CheckingAccountRepo checkingAccountRepo;

    public List<CheckingAccount> allCheckingAccounts() {
        return checkingAccountRepo.findAll();
    }

    public CheckingAccount getAccount(Integer id){
        return checkingAccountRepo.findById(id).get();
    }

    public CheckingAccount withdrawal(Integer minusBalance,Integer id){

        CheckingAccount checkingAccount=checkingAccountRepo.findById(id).get();
        int balance = checkingAccount.getBalance();
        int newBalance = balance - minusBalance;
        checkingAccount.setAddOrMinusBalance(minusBalance);
        checkingAccount.setBalance(balance);
        checkingAccount.setNewBalance(newBalance);
        checkingAccountRepo.save(checkingAccount);

        return checkingAccountRepo.findById(id).get();
    }

    public CheckingAccount deposit(Integer addBalance,Integer id){

        CheckingAccount checkingAccount=checkingAccountRepo.findById(id).get();
        int balance = checkingAccount.getBalance();
        int newBalance = balance + addBalance;
        checkingAccount.setAddOrMinusBalance(addBalance);
        checkingAccount.setBalance(balance);
        checkingAccount.setNewBalance(newBalance);
        checkingAccountRepo.save(checkingAccount);

        return checkingAccountRepo.findById(id).get();
    }

    public String closeAccount(Integer id){
        checkingAccountRepo.deleteById(id);
        return "Account Closed";
    }

}
