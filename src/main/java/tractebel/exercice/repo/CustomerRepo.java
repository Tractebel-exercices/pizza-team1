package tractebel.exercice.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import tractebel.exercice.model.Customer;

@Repository
public interface CustomerRepo extends PagingAndSortingRepository<Customer,Long> {
}
