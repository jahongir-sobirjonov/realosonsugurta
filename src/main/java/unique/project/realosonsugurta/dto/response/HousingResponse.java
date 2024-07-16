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
public class HousingResponse {
    private String passportSeries;
    private String passportNumber;
    private LocalDate dateOfBirth;
    private String familyName;
    private String givenName;
    private String fathersName;
    private String phoneNumber;
    private String residentialRegion;
    private String civilRegistryNumber;
    private List<String> companiesName;
}
