package unique.project.realosonsugurta.controller;

import unique.project.realosonsugurta.dto.request.HousingCreateRequest;
import unique.project.realosonsugurta.dto.response.HousingResponse;
import unique.project.realosonsugurta.service.HousingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("housing")
@RequiredArgsConstructor
public class HousingController {
    private final HousingService housingService;

    @PostMapping("/create")
    public ResponseEntity<HousingResponse> create(@RequestBody HousingCreateRequest housingRequest) {
        return ResponseEntity.status(200).body(housingService.create(housingRequest));
    }

    @GetMapping("get/{id}")
    public ResponseEntity<HousingResponse> getHousing(@PathVariable UUID id){
        return ResponseEntity.status(200).body(housingService.getHousing(id));
    }
}
