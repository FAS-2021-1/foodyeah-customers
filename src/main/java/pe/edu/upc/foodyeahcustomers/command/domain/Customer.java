package pe.edu.upc.foodyeahcustomers.command.domain;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import pe.edu.upc.foodyeahcustomerscontracts.Role;
import pe.edu.upc.foodyeahcustomerscontracts.commands.*;
import pe.edu.upc.foodyeahcustomerscontracts.event.*;
import java.time.Instant;
import java.util.List;

@Aggregate
public class Customer {
    @AggregateIdentifier
    private String id;
    private String customerName;
    private String customerAge;

    private String dni;
    private CustomerStatus status;

    private String customerRoles;
    private String username;
    private String password;

    public Customer() {
    }

    @CommandHandler
    public Customer(RegisterCustomer command) {
        Instant now = Instant.now();
        apply(
                new CustomerRegistered(
                        command.getId(),
                        command.getCustomerName(),
                        command.getCustomerAge(),
                        command.getUsername(),
                        command.getCustomerRoles(),
                        command.getPassword(),
                        command.getDni(),
                        now
                )
        );
    }

    @CommandHandler
    public void handle(EditCustomer command) {
        Instant now = Instant.now();
        apply(
                new CustomerEdited(
                        command.getId(),
                        command.getCustomerName(),
                        command.getCustomerAge(),
                        command.getDni(),
                        command.getUsername(),
                        command.getCustomerRoles(),
                        command.getPassword(),
                        now
                )
        );
    }

    @EventSourcingHandler
    protected void on(CustomerRegistered event) {
        id = event.getId();
        customerName = event.getCustomerName();
        customerAge = event.getCustomerAge();
        dni = event.getDni();
        status = CustomerStatus.ACTIVE;
        username=event.getUsername();
        password=event.getPassword();
        customerRoles=event.getCustomerRoles();
    }

    @EventSourcingHandler
    protected void on(CustomerEdited event) {
        customerName = event.getCustomerName();
        customerAge = event.getCustomerAge();
        dni = event.getDni();
        username=event.getUsername();
        password=event.getPassword();
        customerRoles=event.getCustomerRoles();
    }
}