package unique.project.realosonsugurta.repository;

import unique.project.realosonsugurta.entity.Osago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OsagoRepository extends JpaRepository<Osago, UUID> {
}
