package au.com.telstra.simcardactivator.Repository;

import au.com.telstra.simcardactivator.Entity.SIMEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SimRepository extends JpaRepository<SIMEntity, Long> {
}
