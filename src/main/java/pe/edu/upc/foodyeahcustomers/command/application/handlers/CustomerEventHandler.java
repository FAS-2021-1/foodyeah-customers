package pe.edu.upc.foodyeahcustomers.command.application.handlers;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;
import pe.edu.upc.foodyeahcustomers.command.infra.*;
import pe.edu.upc.foodyeahcustomerscontracts.event.*;
import java.util.Optional;


@Component
@ProcessingGroup("customerDni")
public class CustomerEventHandler {
    private final CustomerDniRepository customerDniRepository;

    public CustomerEventHandler(CustomerDniRepository customerDniRepository) {
        this.customerDniRepository = customerDniRepository;
    }

    @EventHandler
    public void on(CustomerRegistered event) {
        customerDniRepository.save(new CustomerDni(event.getDni(), event.getId()));
    }

    @EventHandler
    public void on(CustomerEdited event) {
        Optional<CustomerDni> CustomerDniOptional = customerDniRepository.getDniById(event.getId());
        CustomerDniOptional.ifPresent(customerDniRepository::delete);
        customerDniRepository.save(new CustomerDni(event.getDni(), event.getId()));
    }
}
