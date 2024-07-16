package unique.project.realosonsugurta.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "insurance_policies")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class InsurancePolicy extends BaseEntity{
    @Column(nullable = false)
    private String policyNumber;

    @Column(nullable = false)
    private String insuranceType;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @Column(nullable = false)
    private Double premiumAmount;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "insurancePolicy")
    private List<Claim> claims;
}
