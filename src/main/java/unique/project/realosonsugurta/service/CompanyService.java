package unique.project.realosonsugurta.service;
import unique.project.realosonsugurta.dto.request.CompanyCreateRequest;
import unique.project.realosonsugurta.entity.Company;
import unique.project.realosonsugurta.exception.DataAlreadyExistsException;
import unique.project.realosonsugurta.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;
    private final ModelMapper modelMapper;
    public String addServiceToCompany(String companyName, String service) {
        Company company = companyRepository.findByName(companyName)
                .orElseThrow(() -> new IllegalArgumentException("Company not found"));

        company.addService(service);
        companyRepository.save(company);
        return "Successfully added service to " + company.getName();
    }



    public String create(CompanyCreateRequest createRequest) {
        if (companyRepository.existsByName(createRequest.getName())){
            throw new DataAlreadyExistsException("Company already exists with name : " + createRequest.getName());
        }
        Company company = modelMapper.map(createRequest, Company.class);
        companyRepository.save(company);
        return "Successfully created " + createRequest.getName();
    }



//    public List<String> getCompaniesByService(String service) {
//        List<Company> companies = companyRepository.findByServicesIgnoreCaseContaining(service);
//        List<String> companyNames = new ArrayList<>();
//        for (Company company : companies) {
//            companyNames.add(company.getName());
//        }
//        System.out.println("Companies matching service: " + companyNames);
//        return companyNames;
//    }
//public List<String> getCompaniesByService(String service) {
//    List<Company> companies = companyRepository.findByServicesContainingIgnoreCase(service);
//    List<String> companyNames = companies.stream()
//            .map(Company::getName)
//            .collect(Collectors.toList());
//    System.out.println("Companies matching service: " + companyNames);
//    return companyNames;
//}


    public List<String> getCompaniesByService(String serviceName) {
        List<Company> companies = companyRepository.findAllByServiceNameContainingIgnoreCase(serviceName.toLowerCase());
        return companies.stream()
                .map(Company::getName)
                .collect(Collectors.toList());
    }



    public List<String> getAllServicesOfCompany(String companyName) {
        Company company = companyRepository.findByName(companyName)
                .orElseThrow(() -> new IllegalArgumentException("Company not found"));

        return company.getServices();
    }
}
