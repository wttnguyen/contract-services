package prototype.copart.contractservices.contract;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import prototype.copart.contractservices.contract.templates.ContractTemplate;
import prototype.copart.contractservices.contract.templates.criteria.CriteriaTemplate;
import prototype.copart.contractservices.contract.templates.pricing.PricingTemplate;

import java.util.List;

@RestController
@RequestMapping("api/v1/contract/")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ContractController
{

	private final ContractService contractService;

	@PutMapping("/new-contract-template")
	public void createNewContractTemplate(@RequestBody ContractTemplate contractTemplate)
	{
		contractService.saveNewContractTemplate(contractTemplate);
	}

	@PutMapping("/new-pricing-template")
	public void createNewPricingTemplate(@RequestBody PricingTemplate pricingTemplate)
	{
		contractService.saveNewPricingTemplate(pricingTemplate);
	}

	@PutMapping("/new-criteria-template")
	public void createNewCriteriaTemplate(@RequestBody CriteriaTemplate criteriaTemplate)
	{
		contractService.saveNewCriteriaTemplate(criteriaTemplate);
	}

	@GetMapping("/contract-templates/all")
	public List<ContractTemplate> getAllContractTemplates()
	{
		return contractService.getAllContractTemplates();
	}

	@GetMapping("/pricing-templates/all")
	public List<PricingTemplate> getAllPricingTemplates()
	{
		return contractService.getAllPricingTemplates();
	}

	@GetMapping("/criteria-templates/all")
	public List<CriteriaTemplate> getAllCriteriaTemplates()
	{
		return contractService.getAllCriteriaTemplates();
	}

}
