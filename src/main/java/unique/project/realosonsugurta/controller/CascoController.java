package unique.project.realosonsugurta.controller;

import unique.project.realosonsugurta.dto.request.CascoCreateRequest;
import unique.project.realosonsugurta.dto.response.CascoResponse;
import unique.project.realosonsugurta.service.CascoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("casco")
@RequiredArgsConstructor
public class CascoController {
    private final CascoService cascoService;

    @PostMapping("/create")
    public ResponseEntity<CascoResponse> create(@RequestBody CascoCreateRequest createRequest) {
        return ResponseEntity.status(200).body(cascoService.create(createRequest));
    }

    @GetMapping("get/{id}")
    public ResponseEntity<CascoResponse> getCasco(@PathVariable UUID id){
        return ResponseEntity.status(200).body(cascoService.getCasco(id));
    }
}
