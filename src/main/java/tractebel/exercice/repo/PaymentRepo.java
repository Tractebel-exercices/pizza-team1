package tractebel.exercice.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import tractebel.exercice.model.Payment;



@Repository
public interface PaymentRepo extends PagingAndSortingRepository<Payment,Long> {
}
