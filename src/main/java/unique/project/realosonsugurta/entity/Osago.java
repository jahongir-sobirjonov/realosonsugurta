package unique.project.realosonsugurta.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "osago")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Osago extends BaseEntity{
    private String carRegNumber;
    private String texPassportSeries;
    private String texPassportNumber;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "osago_company",
            joinColumns = @JoinColumn(name = "osago_id"),
            inverseJoinColumns = @JoinColumn(name = "company_id")
    )
    private List<Company> company;
}
