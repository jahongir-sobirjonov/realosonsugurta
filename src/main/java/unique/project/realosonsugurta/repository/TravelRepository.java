package unique.project.realosonsugurta.repository;

import unique.project.realosonsugurta.entity.Travel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TravelRepository extends JpaRepository<Travel, UUID> {
}
