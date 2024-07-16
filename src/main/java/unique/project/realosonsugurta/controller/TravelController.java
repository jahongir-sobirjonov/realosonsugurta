package unique.project.realosonsugurta.controller;

import unique.project.realosonsugurta.dto.request.TravelCreateRequest;
import unique.project.realosonsugurta.dto.response.TravelResponse;
import unique.project.realosonsugurta.service.TravelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("travel")
@RequiredArgsConstructor
public class TravelController {
    private final TravelService travelService;

    @PostMapping("/create")
    public ResponseEntity<TravelResponse> create(@RequestBody TravelCreateRequest travelRequest) {
        return ResponseEntity.status(200).body(travelService.create(travelRequest));
    }

    @GetMapping("get/{id}")
    public ResponseEntity<TravelResponse> getTravel(@PathVariable UUID id){
        return ResponseEntity.status(200).body(travelService.getTravel(id));
    }
}
