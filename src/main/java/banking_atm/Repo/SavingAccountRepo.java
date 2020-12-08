package banking_atm.Repo;

import banking_atm.Model.SavingAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavingAccountRepo extends JpaRepository<SavingAccount,Integer> {
}
