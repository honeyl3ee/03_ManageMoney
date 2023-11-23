package beforespring.managemoney.app.expenditure.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ExpenditureRepository extends JpaRepository<Expenditure, Long> {


}
