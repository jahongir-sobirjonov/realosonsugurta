package unique.project.realosonsugurta.controller;
import unique.project.realosonsugurta.entity.InsurancePolicy;
import unique.project.realosonsugurta.entity.User;
import unique.project.realosonsugurta.service.InsurancePolicyService;
import unique.project.realosonsugurta.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("insurancePolicy")
@RequiredArgsConstructor
public class InsurancePolicyController {
    private final InsurancePolicyService insurancePolicyService;
    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<InsurancePolicy> createPolicy(@RequestBody InsurancePolicy policy) {
        return ResponseEntity.status(200).body(insurancePolicyService.createPolicy(policy));
    }

    @GetMapping("/user/{email}")
    public ResponseEntity<List<InsurancePolicy>> getPoliciesByUser(@PathVariable String email) {
        User user = userService.findByEmail(email).orElse(null);
        return ResponseEntity.status(200).body(insurancePolicyService.findPoliciesByUser(user));
    }
}
