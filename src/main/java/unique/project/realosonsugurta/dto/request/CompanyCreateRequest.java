package unique.project.realosonsugurta.dto.request;

import lombok.*;

import java.time.LocalDate;
import java.util.List;


@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
public class CompanyCreateRequest {
    private String name;
    private LocalDate warrantyPeriod; // kafolat muddati
    private String policyNumber;
    private String insuranceType;
    private Double warrantyAmount; // companyaning kafolat(sug'urta) summasi
    private List<String> services;
}
