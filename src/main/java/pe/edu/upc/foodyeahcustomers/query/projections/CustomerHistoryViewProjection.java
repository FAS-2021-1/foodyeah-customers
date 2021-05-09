package pe.edu.upc.foodyeahcustomers.query.projections;

import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventhandling.Timestamp;
import org.springframework.stereotype.Component;
import pe.edu.upc.foodyeahcustomers.command.domain.*;
import pe.edu.upc.foodyeahcustomerscontracts.event.*;
import java.time.Instant;
import java.util.Optional;

@Component
public class CustomerHistoryViewProjection {
    private final CustomerHistoryViewRepository customerHistoryViewRepository;

    public CustomerHistoryViewProjection(CustomerHistoryViewRepository customerHistoryViewRepository) {
        this.customerHistoryViewRepository = customerHistoryViewRepository;
    }

    @EventHandler
    public void on(CustomerRegistered event, @Timestamp Instant timestamp) {
        CustomerHistoryView customerHistoryView = new CustomerHistoryView(event.getId(), event.getCustomerName(), event.getCustomerAge(),CustomerStatus.ACTIVE.toString(),event.getCustomerRoles(),event.getPassword(),event.getUsername(),event.getDni(),event.getOccurredOn() );
        customerHistoryViewRepository.save(customerHistoryView);
    }

    @EventHandler
    public void on(CustomerEdited event, @Timestamp Instant timestamp) {
        Optional<CustomerHistoryView> customerHistoryViewOptional = customerHistoryViewRepository.getLastByCustomerId(event.getId().toString());
        if (customerHistoryViewOptional.isPresent()) {
            CustomerHistoryView customerHistoryView = customerHistoryViewOptional.get();
            customerHistoryView = new CustomerHistoryView(customerHistoryView);
            customerHistoryView.setCustomerName(event.getCustomerName());
            customerHistoryView.setCustomerAge(event.getCustomerAge());
            customerHistoryView.setDni(event.getDni());
            customerHistoryView.setCreatedAt(event.getOccurredOn());
            customerHistoryView.setCustomerRoles(event.getCustomerRoles());
            customerHistoryView.setUsername(event.getUsername());
            customerHistoryView.setPassword(event.getPassword());
            customerHistoryViewRepository.save(customerHistoryView);
        }
    }
}
