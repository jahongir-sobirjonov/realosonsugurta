package unique.project.realosonsugurta.dto.response;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
public class TravelResponse {
    private String country;
    private String policyType;
    private LocalDate startDate;
    private LocalDate endDate;
    private int days;
    private String tripPurpose;
    private List<String> companiesName;
}
