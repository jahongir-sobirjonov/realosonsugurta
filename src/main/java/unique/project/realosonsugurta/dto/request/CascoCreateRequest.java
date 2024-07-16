package unique.project.realosonsugurta.dto.request;

import jakarta.validation.constraints.Pattern;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
public class CascoCreateRequest {
    @Pattern(regexp = "\\d{2}[A-Z]\\d{3}[A-Z]{2}", message = "Car registration number must be in the format 01A329GA")
    private String carRegNumber;
    @Pattern(regexp = "^[A-Z]{3}$", message = "texPassportSeries must contain only 3 uppercase letters")
    private String texPassportSeries;
    @Pattern(regexp = "^\\d{7}$", message = "texPassportNumber must contain only 7 digits")
    private String texPassportNumber;
    private String carBrand;
    private String carModel;
    private Integer carReleaseYear;
}

