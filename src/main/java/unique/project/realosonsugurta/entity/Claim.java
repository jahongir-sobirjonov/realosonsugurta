package unique.project.realosonsugurta.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDate;
@Entity(name = "claim")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Claim extends BaseEntity {
    @Column(nullable = false)
    private String claimNumber;

    @Column(nullable = false)
    private LocalDate dateOfClaim;

    @Column(nullable = false)
    private Double claimAmount;

    @ManyToOne
    @JoinColumn(name = "policy_id", nullable = false)
    private InsurancePolicy insurancePolicy;
}
