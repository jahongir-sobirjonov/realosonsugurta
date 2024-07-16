package unique.project.realosonsugurta.service;

import unique.project.realosonsugurta.dto.request.CascoCreateRequest;
import unique.project.realosonsugurta.dto.response.CascoResponse;
import unique.project.realosonsugurta.entity.Casco;
import unique.project.realosonsugurta.entity.Company;
import unique.project.realosonsugurta.exception.DataNotFoundException;
import unique.project.realosonsugurta.repository.CascoRepository;
import unique.project.realosonsugurta.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CascoService {
    private final CascoRepository cascoRepository;
    private final CompanyRepository companyRepository;
    private final ModelMapper modelMapper;

    public CascoResponse create(CascoCreateRequest cascoRequest) {
        Casco casco = modelMapper.map(cascoRequest, Casco.class);
        List<Company> companies = companyRepository.findByServicesContainingIgnoreCase("Casco");

        for (Company company : companies) {
            System.out.println("company.getName() = " + company.getName());
        }
        casco.setCompany(companies);
        Casco savedCasco = cascoRepository.save(casco);

        List<String> companyListByName = new ArrayList<>();
        for (Company company : companies) {
            companyListByName.add(company.getName());
        }
        CascoResponse cascoResponse = modelMapper.map(savedCasco, CascoResponse.class);
        cascoResponse.setCompaniesName(companyListByName);
        return cascoResponse;
    }

    public CascoResponse getCasco(UUID id) {
        Optional<Casco> byId = cascoRepository.findById(id);

        if (!byId.isPresent()) {
            throw new DataNotFoundException("Casco entity not found for id: " + id);
        }

        Casco casco = byId.get();
        CascoResponse cascoResponse = modelMapper.map(casco, CascoResponse.class);

        List<String> companies = new ArrayList<>();
        for (Company company : casco.getCompany()) {
            companies.add(company.getName());
        }

        cascoResponse.setCompaniesName(companies);
        return cascoResponse;
    }

}
