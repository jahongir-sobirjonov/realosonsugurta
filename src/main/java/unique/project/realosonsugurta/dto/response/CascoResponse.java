package unique.project.realosonsugurta.dto.response;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
public class CascoResponse {
    private String carRegNumber;
    private String texPassportSeries;
    private String texPassportNumber;
    private String carBrand;
    private String carModel;
    private Integer carReleaseYear;
    private List<String> companiesName;
}
