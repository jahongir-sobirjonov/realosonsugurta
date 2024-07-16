package unique.project.realosonsugurta.controller;
import unique.project.realosonsugurta.service.ClaimService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("insurancePolicy")
@RequiredArgsConstructor
public class ClaimController {
    private final ClaimService claimService;
}
