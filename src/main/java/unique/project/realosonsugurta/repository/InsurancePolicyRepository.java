package unique.project.realosonsugurta.repository;

import unique.project.realosonsugurta.entity.InsurancePolicy;
import unique.project.realosonsugurta.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface InsurancePolicyRepository extends JpaRepository<InsurancePolicy, UUID> {
    List<InsurancePolicy> findByUser(User user);

}
