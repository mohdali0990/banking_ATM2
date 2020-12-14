package banking_atm.Repo;

import banking_atm.Model.CheckingAccount;
import banking_atm.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer> {

  List<Customer> findByfirstName(@Param("firstName") String firstName);
  List<Customer> findBylastName(@Param("firstName") String lastName);



}
