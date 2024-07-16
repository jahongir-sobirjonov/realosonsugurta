package unique.project.realosonsugurta.controller;
import unique.project.realosonsugurta.dto.request.CompanyCreateRequest;
import unique.project.realosonsugurta.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("company")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService companyService;

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody CompanyCreateRequest createRequest){
        return ResponseEntity.status(200).body(companyService.create(createRequest));
    }


    @PostMapping("/add-service/{companyName}")
    public ResponseEntity<String> addService(@PathVariable String companyName, @RequestParam String serviceName){
        return ResponseEntity.status(200).body(companyService.addServiceToCompany(companyName, serviceName));
    }

    @GetMapping("/get-companies-by-service-name")
    public ResponseEntity<List<String>> getCompaniesByService(@RequestParam String service) {
        return ResponseEntity.status(200).body(companyService.getCompaniesByService(service));
    }
    @GetMapping("/get-all-services-of-company")
    public ResponseEntity<List<String>> getAllServicesOfCompany(@RequestParam String companyName){
        return ResponseEntity.status(200).body(companyService.getAllServicesOfCompany(companyName));
    }
}
