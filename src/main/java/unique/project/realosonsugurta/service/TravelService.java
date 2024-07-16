package unique.project.realosonsugurta.service;

import unique.project.realosonsugurta.dto.request.TravelCreateRequest;
import unique.project.realosonsugurta.dto.response.TravelResponse;
import unique.project.realosonsugurta.entity.Company;
import unique.project.realosonsugurta.entity.Travel;
import unique.project.realosonsugurta.exception.DataNotFoundException;
import unique.project.realosonsugurta.repository.CompanyRepository;
import unique.project.realosonsugurta.repository.TravelRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TravelService {
    private final TravelRepository travelRepository;
    private final CompanyRepository companyRepository;
    private final ModelMapper modelMapper;

    public TravelResponse create(TravelCreateRequest travelRequest) {
        travelRepository.save(modelMapper.map(travelRequest, Travel.class));
        List<Company> companies = companyRepository.findByServicesContainingIgnoreCase("Travel");
        List<String> companyListByName = new ArrayList<>();
        for (Company company : companies) {
            companyListByName.add(company.getName());
        }
        TravelResponse travelResponse = modelMapper.map(travelRequest, TravelResponse.class);
        travelResponse.setCompaniesName(companyListByName);
        return travelResponse;
    }

    public TravelResponse getTravel(UUID id) {
        Optional<Travel> byId = travelRepository.findById(id);

        if (!byId.isPresent()) {
            throw new DataNotFoundException("Travel entity not found for id: " + id);
        }

        Travel travel = byId.get();
        TravelResponse travelResponse = modelMapper.map(travel, TravelResponse.class);

        List<String> companies = new ArrayList<>();
        for (Company company : travel.getCompany()) {
            companies.add(company.getName());
        }

        travelResponse.setCompaniesName(companies);
        return travelResponse;
    }

}
