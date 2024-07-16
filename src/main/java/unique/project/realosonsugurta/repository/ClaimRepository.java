package unique.project.realosonsugurta.repository;

import unique.project.realosonsugurta.entity.Claim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ClaimRepository extends JpaRepository<Claim, UUID> {
}
