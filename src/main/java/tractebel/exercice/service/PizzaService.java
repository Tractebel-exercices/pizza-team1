package tractebel.exercice.service;

import org.springframework.stereotype.Service;
import tractebel.exercice.dto.CustomerDTO;
import tractebel.exercice.model.Customer;

public interface PizzaService {

    CustomerDTO saveUser(CustomerDTO customer);

    CustomerDTO getUser(Long id);
}
