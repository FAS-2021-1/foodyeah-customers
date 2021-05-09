package pe.edu.upc.foodyeahcustomers.command.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
public interface CustomerDniRepository extends JpaRepository<CustomerDni,String>{
    Optional<CustomerDni> getDniById(String id);

    @Query(value = "SELECT * FROM customer_dni WHERE customer_id <> :customerId AND dni = :dni LIMIT 1", nativeQuery = true)
    Optional<CustomerDni> getByDniForDistinctId(String dni, String id);
}
