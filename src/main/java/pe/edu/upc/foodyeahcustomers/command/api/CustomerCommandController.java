package pe.edu.upc.foodyeahcustomers.command.api;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import pe.edu.upc.foodyeahcustomers.command.application.dto.*;
import pe.edu.upc.foodyeahcustomers.command.infra.CustomerDni;
import pe.edu.upc.foodyeahcustomers.command.infra.CustomerDniRepository;
import pe.edu.upc.foodyeahcustomerscontracts.commands.*;

@RestController
@RequestMapping("/customers")
@Api(tags = "Customers")
public class CustomerCommandController {
    private final CommandGateway commandGateway;
    private final CustomerDniRepository customerDniRepository;

    public CustomerCommandController(CommandGateway commandGateway, CustomerDniRepository customerDniRepository) {
        this.commandGateway = commandGateway;
        this.customerDniRepository = customerDniRepository;
    }

    @PostMapping("")
    public ResponseEntity<Object> register(@RequestBody RegisterCustomerRequestDto registerCustomerRequestDto) {
        Optional<CustomerDni> customerDniOptional = customerDniRepository.findById(registerCustomerRequestDto.getDni());
        if (customerDniOptional.isPresent()) {
            return new ResponseEntity(new RegisterCustomerErrorResponseDto(), HttpStatus.BAD_REQUEST);
        }
        String customerId = UUID.randomUUID().toString();
        RegisterCustomer registerCustomer = new RegisterCustomer(
                customerId,
                registerCustomerRequestDto.getCustomerName(),
                registerCustomerRequestDto.getCustomerAge(),
                registerCustomerRequestDto.getDni(),
                registerCustomerRequestDto.getCustomerRoles(),
                registerCustomerRequestDto.getUsername(),
                registerCustomerRequestDto.getPassword()
        );
        CompletableFuture<Object> future = commandGateway.send(registerCustomer);
        CompletableFuture<Object> futureResponse = future.handle((ok, ex) -> {
            if (ex != null) {
                return new RegisterCustomerErrorResponseDto();
            }
            return new RegisterCustomerOkResponseDto(customerId);
        });
        try {
            Object response = (Object)futureResponse.get();
            if (response instanceof RegisterCustomerOkResponseDto) {
                return new ResponseEntity(response, HttpStatus.CREATED);
            }
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        } catch( Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<Object> edit(
            @PathVariable("customerId") String customerId,
            @RequestBody EditCustomerRequestDto editCustomerRequestDto) {
        Optional<CustomerDni> customerDniOptional = customerDniRepository.getByDniForDistinctId(editCustomerRequestDto.getDni(), customerId);
        if (customerDniOptional.isPresent()) {
            return new ResponseEntity(new EditCustomerErrorResponseDto(), HttpStatus.BAD_REQUEST);
        }
        editCustomerRequestDto.setCustomerId(customerId);
        EditCustomer editCustomer = new EditCustomer(
                editCustomerRequestDto.getId(),
                editCustomerRequestDto.getCustomerName(),
                editCustomerRequestDto.getCustomerAge(),
                editCustomerRequestDto.getDni(),
                editCustomerRequestDto.getCustomerRoles(),
                editCustomerRequestDto.getUsername(),
                editCustomerRequestDto.getPassword()
        );
        CompletableFuture<Object> future = commandGateway.send(editCustomer);
        CompletableFuture<Object> futureResponse = future.handle((ok, ex) -> {
            if (ex != null) {
                return new EditCustomerErrorResponseDto();
            }
            return new EditCustomerOkResponseDto(customerId);
        });
        try {
            Object response = (Object)futureResponse.get();
            if (response instanceof EditCustomerOkResponseDto) {
                return new ResponseEntity(response, HttpStatus.OK);
            }
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        } catch( Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
