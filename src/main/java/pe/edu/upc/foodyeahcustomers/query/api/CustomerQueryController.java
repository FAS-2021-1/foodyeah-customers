package pe.edu.upc.foodyeahcustomers.query.api;



import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.foodyeahcustomers.query.projections.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
@Api(tags = "Customers")
public class CustomerQueryController {

    private final CustomerViewRepository customerViewRepository;

    public CustomerQueryController(CustomerViewRepository customerViewRepository) {
        this.customerViewRepository = customerViewRepository;
    }

    @GetMapping("")
    public ResponseEntity<List<CustomerView>> getAll() {
        try {
            return new ResponseEntity<List<CustomerView>>(customerViewRepository.findAll(), HttpStatus.OK);
        } catch( Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerView> getById(@PathVariable("id") String id) {
        try {
            Optional<CustomerView> customerViewOptional = customerViewRepository.findById(id);
            if (customerViewOptional.isPresent()) {
                return new ResponseEntity<CustomerView>(customerViewOptional.get(), HttpStatus.OK);
            }
            return new ResponseEntity("NOT_FOUND", HttpStatus.NOT_FOUND);
        } catch( Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/dni/{dni}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerView> getByDocument(@PathVariable("dni") String dni) {
        try {
            Optional<CustomerView> customerViewOptional = customerViewRepository.getByDni(dni);
            if (customerViewOptional.isPresent()) {
                return new ResponseEntity<CustomerView>(customerViewOptional.get(), HttpStatus.OK);
            }
            return new ResponseEntity("NOT_FOUND", HttpStatus.NOT_FOUND);
        } catch( Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
