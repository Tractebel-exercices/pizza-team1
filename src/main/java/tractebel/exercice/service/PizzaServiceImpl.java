package tractebel.exercice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.stereotype.Service;
import tractebel.exercice.dto.AddressDTO;
import tractebel.exercice.dto.CustomerDTO;
import tractebel.exercice.dto.FavoritePizzaDTO;
import tractebel.exercice.dto.PaymentDTO;
import tractebel.exercice.model.Address;
import tractebel.exercice.model.Customer;
import tractebel.exercice.model.Order;
import tractebel.exercice.model.Payment;
import tractebel.exercice.repo.CustomerRepo;
import tractebel.exercice.repo.OrderRepo;
import tractebel.exercice.repo.PaymentRepo;

import javax.transaction.Transactional;

@Service
@Transactional
public class PizzaServiceImpl implements PizzaService {

    private CustomerRepo customerRepo;

    private PaymentRepo paymentRepo;

    private OrderRepo orderRepo;

    @Autowired
    public PizzaServiceImpl(CustomerRepo customerRepo,
                            PaymentRepo paymentRepo,
                            OrderRepo orderRepo) {
        this.customerRepo = customerRepo;
        this.paymentRepo = paymentRepo;
        this.orderRepo = orderRepo;
    }

    @Override
    public CustomerDTO saveUser(CustomerDTO customer) {
        Customer customerModel;
        Address address;
        Order order;
        Payment payment;

        if(customer.getId() == null) {
            customerModel = new Customer();
            address = new Address();
            order = new Order();
             payment=new Payment();
        }else{
            customerModel = customerRepo.findOne(customer.getId());
            address = customerModel.getAddress();
            order = customerModel.getFavorite();
            payment =customerModel.getPayment();
        }
        customerModel.setFirstName(customer.getFirstName());
        customerModel.setLastName(customer.getLastName());
        customerModel.setMiddleName(customer.getMiddleName());


        PaymentDTO paymentDetails = customer.getPaymentDetails();
        payment.setExpiration(paymentDetails.getExpiration());
        payment.setNumber(paymentDetails.getNumber());
        payment.setProvider(paymentDetails.getProvider());

        customerModel.setPayment(payment);

        AddressDTO addressDTO = customer.getAddress();

        address.setCustomer(customerModel);
        address.setCity(addressDTO.getCity());
        address.setComplement(addressDTO.getComplement());
        address.setCountry(addressDTO.getCountry());
        address.setPostalCode(addressDTO.getPostalCode());
        address.setStreet(addressDTO.getStreet());

        FavoritePizzaDTO favoritePizzaDTO = customer.getFavoritePizza();

        customerModel.setSerial_number(customer.getSerialNumber());
        order.setFavorite(favoritePizzaDTO.getFavoritePizza());
        order.setStore(favoritePizzaDTO.getStore());
        customerModel.setAddress(address);
        customerModel.setFavorite(order);

        Customer res= customerRepo.save(customerModel);

        customer.setId(res.getId());
        customer.getAddress().setId(res.getAddress().getId());
        customer.getFavoritePizza().setId(res.getFavorite().getId());
        customer.getPaymentDetails().setId(res.getPayment().getId());
        return customer;
    }

    @Override
    public CustomerDTO getUser(Long id) {
        Customer customer = customerRepo.findOne(id);
        CustomerDTO customerDTO = new CustomerDTO();
        customer.setFirstName(customer.getFirstName());
        customer.setLastName(customer.getLastName());
        customer.setMiddleName(customer.getMiddleName());

        Address address = customer.getAddress();
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setId(address.getId());
        addressDTO.setPostalCode(address.getPostalCode());
        addressDTO.setCity(address.getCity());
        addressDTO.setCountry(address.getCountry());
        addressDTO.setStreet(address.getStreet());

        Payment payment = customer.getPayment();
        PaymentDTO paymentDTO = new PaymentDTO();
        paymentDTO.setId(payment.getId());
        paymentDTO.setNumber(payment.getNumber());
        paymentDTO.setProvider(payment.getProvider());

        Order order = customer.getFavorite();
        FavoritePizzaDTO favoritePizzaDTO = new FavoritePizzaDTO();
        favoritePizzaDTO.setFavoritePizza(order.getFavorite());
        favoritePizzaDTO.setStore(order.getStore());

        customerDTO.setFavoritePizza(favoritePizzaDTO);
        customerDTO.setPaymentDetails(paymentDTO);
        customerDTO.setAddress(addressDTO);
        return customerDTO;
    }
}
