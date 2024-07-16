package unique.project.realosonsugurta.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "casco")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Casco extends BaseEntity {
    private String carRegNumber;
    private String texPassportSeries;
    private String texPassportNumber;
    private String carBrand;
    private String carModel;
    private Integer carReleaseYear;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "casco_company",
            joinColumns = @JoinColumn(name = "casco_id"),
            inverseJoinColumns = @JoinColumn(name = "company_id")
    )
    private List<Company> company;
}

