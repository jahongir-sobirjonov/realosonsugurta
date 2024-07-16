package unique.project.realosonsugurta.dto.request;

import lombok.*;

import java.time.LocalDate;


@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
public class TravelCreateRequest {
    private String country;
    private String policyType;
    private LocalDate startDate;
    private LocalDate endDate;
    private int days;
    private String tripPurpose;

}
