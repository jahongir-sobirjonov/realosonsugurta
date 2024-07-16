package unique.project.realosonsugurta.service;

import unique.project.realosonsugurta.entity.InsurancePolicy;
import unique.project.realosonsugurta.entity.User;
import unique.project.realosonsugurta.repository.InsurancePolicyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InsurancePolicyService {
    private final InsurancePolicyRepository insurancePolicyRepository;
    public InsurancePolicy createPolicy(InsurancePolicy policy) {
        return insurancePolicyRepository.save(policy);
    }

    public List<InsurancePolicy> findPoliciesByUser(User user) {
        return insurancePolicyRepository.findByUser(user);
    }
}
