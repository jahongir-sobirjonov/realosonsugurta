package unique.project.realosonsugurta.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "housing")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Housing extends BaseEntity{
    private String passportSeries;
    private String passportNumber;
    private LocalDate dateOfBirth;
    private String familyName;
    private String givenName;
    private String fathersName;
    private String phoneNumber;
    private String residentialRegion;
    private String civilRegistryNumber;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "housing_company",
            joinColumns = @JoinColumn(name = "housing_id"),
            inverseJoinColumns = @JoinColumn(name = "company_id")
    )
    private List<Company> companies;
}
