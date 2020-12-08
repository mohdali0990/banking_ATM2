package banking_atm.Repo;

import banking_atm.Model.CheckingAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckingAccountRepo extends JpaRepository<CheckingAccount,Integer> {
}
