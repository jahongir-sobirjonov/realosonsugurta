package unique.project.realosonsugurta.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "travel")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Travel extends BaseEntity {
    private String country;
    private String policyType;
    private LocalDate startDate;
    private LocalDate endDate;
    private int days;
    private String tripPurpose;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "travel_company",
            joinColumns = @JoinColumn(name = "travel_id"),
            inverseJoinColumns = @JoinColumn(name = "company_id")
    )
    private List<Company> company;
}

