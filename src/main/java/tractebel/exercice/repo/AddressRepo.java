package tractebel.exercice.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import tractebel.exercice.model.Address;

@Repository
public interface AddressRepo extends PagingAndSortingRepository<Address,Long>{
}
