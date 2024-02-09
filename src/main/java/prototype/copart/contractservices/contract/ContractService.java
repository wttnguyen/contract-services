package prototype.copart.contractservices.contract;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prototype.copart.contractservices.contract.templates.ContractTemplate;
import prototype.copart.contractservices.contract.templates.ContractTemplateRepository;
import prototype.copart.contractservices.contract.templates.criteria.CriteriaTemplate;
import prototype.copart.contractservices.contract.templates.criteria.CriteriaTemplateRepository;
import prototype.copart.contractservices.contract.templates.pricing.PricingTemplate;
import prototype.copart.contractservices.contract.templates.pricing.PricingTemplateRepository;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ContractService
{

	private final ContractTemplateRepository contractTemplateRepository;

	private final PricingTemplateRepository pricingTemplateRepository;

	private final CriteriaTemplateRepository criteriaTemplateRepository;

	public void saveContractTemplate(ContractTemplate contractTemplate)
	{
		contractTemplate.getPricingTemplates().forEach(pricingTemplate ->
		{
			if (!pricingTemplateRepository.existsById(pricingTemplate.getId()))
			{
				savePricingTemplate(pricingTemplate);
			}
		});
		contractTemplateRepository.save(contractTemplate);
	}

	public void savePricingTemplate(PricingTemplate pricingTemplate)
	{
		pricingTemplate.getCriteriaTemplates().forEach(this::saveCriteriaTemplate);
		pricingTemplateRepository.save(pricingTemplate);
	}

	private void saveCriteriaTemplate(CriteriaTemplate criteriaTemplate)
	{
		criteriaTemplateRepository.save(criteriaTemplate);
	}

	public List<ContractTemplate> getAllContractTemplates() {
		return contractTemplateRepository.findAll();
	}

}
