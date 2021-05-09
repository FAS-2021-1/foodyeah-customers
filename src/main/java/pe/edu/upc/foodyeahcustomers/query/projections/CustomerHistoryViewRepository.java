package pe.edu.upc.foodyeahcustomers.query.projections;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CustomerHistoryViewRepository extends JpaRepository<CustomerHistoryView, String> {
    @Query(value = "SELECT * FROM customer_history_view WHERE customer_history_id = (SELECT MAX(customer_history_id) FROM customer_history_view WHERE customer_id = :customerId)", nativeQuery = true)
    Optional<CustomerHistoryView> getLastByCustomerId(String customerId);
}
