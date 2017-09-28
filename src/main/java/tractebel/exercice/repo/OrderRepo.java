package tractebel.exercice.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import tractebel.exercice.model.Order;


@Repository
public interface OrderRepo extends PagingAndSortingRepository<Order,Long> {
}
