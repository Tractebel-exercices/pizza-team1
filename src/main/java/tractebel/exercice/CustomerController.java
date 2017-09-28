package tractebel.exercice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tractebel.exercice.dto.CustomerDTO;
import tractebel.exercice.service.PizzaService;


@RestController
public class CustomerController {

    @Autowired
    private PizzaService pizzaService;


    @PostMapping("pizza/team1/register")
    public CustomerDTO createUser(@RequestBody CustomerDTO customerDTO) {
        pizzaService.saveUser(customerDTO);
        return customerDTO;
    }

    @GetMapping("pizza/team1/user/{id}")
    public CustomerDTO retrieveUser(@PathVariable("id") long id) {
        return pizzaService.getUser(id);
    }


    @PutMapping("pizza/team1/user/{id}")
    public CustomerDTO retrieveUser(@RequestBody CustomerDTO customerDTO) {
        return pizzaService.saveUser(customerDTO);
    }
}
