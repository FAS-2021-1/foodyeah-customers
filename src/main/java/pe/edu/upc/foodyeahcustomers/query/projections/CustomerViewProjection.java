package pe.edu.upc.foodyeahcustomers.query.projections;

import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventhandling.Timestamp;
import org.springframework.stereotype.Component;
import pe.edu.upc.foodyeahcustomers.command.domain.*;
import pe.edu.upc.foodyeahcustomerscontracts.event.*;
import java.time.Instant;
import java.util.Optional;

@Component
public class CustomerViewProjection {
    private final CustomerViewRepository customerViewRepository;

    public CustomerViewProjection(CustomerViewRepository customerViewRepository) {
        this.customerViewRepository = customerViewRepository;
    }

    @EventHandler
    public void on(CustomerRegistered event, @Timestamp Instant timestamp) {
        CustomerView customerView = new CustomerView(event.getId(), event.getCustomerName(), event.getCustomerAge(),CustomerStatus.ACTIVE.toString(),event.getCustomerRoles(),event.getUsername(),event.getPassword(),event.getDni(),event.getOccurredOn());
        customerViewRepository.save(customerView);
    }

    @EventHandler
    public void on(CustomerEdited event, @Timestamp Instant timestamp) {
        Optional<CustomerView> customerViewOptional = customerViewRepository.findById(event.getId().toString());
        if (customerViewOptional.isPresent()) {
            CustomerView customerView = customerViewOptional.get();
            customerView.setCustomerName(event.getCustomerName());
            customerView.setCustomerAge(event.getCustomerAge());
            customerView.setDni(event.getDni());
            customerView.setCreatedAt(event.getOccurredOn());
            customerView.setCustomerRoles(event.getCustomerRoles());
            customerView.setUsername(event.getUsername());
            customerView.setPassword(event.getPassword());
            customerViewRepository.save(customerView);
        }
    }
}
