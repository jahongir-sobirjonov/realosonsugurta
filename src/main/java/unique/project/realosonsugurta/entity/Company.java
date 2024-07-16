package unique.project.realosonsugurta.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "companies")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Company extends BaseEntity {
    private String name;
    private LocalDate warrantyPeriod; // kafolat muddati
    private String policyNumber;
    private String insuranceType;
    private Double warrantyAmount; // companyaning kafolat(sug'urta) summasi

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "company_services", joinColumns = @JoinColumn(name = "company_id"))
    @Column(name = "service")
    private List<String> services = new ArrayList<>();

    public void addService(String service) {
        if (services == null) {
            services = new ArrayList<>();
        }
        if (!services.contains(service)) {
            services.add(service);
        }
    }
}
