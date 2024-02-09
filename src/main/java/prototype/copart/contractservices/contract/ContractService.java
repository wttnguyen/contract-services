package prototype.copart.contractservices.contract;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
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

	public void saveNewContractTemplate(ContractTemplate contractTemplate)
	{
		if (contractTemplateRepository.existsById(contractTemplate.getId()))
		{
			throw new DuplicateKeyException(
					STR. "Contract template ID: \{ contractTemplate.getId() } already exists in the database." );
		}
		contractTemplate.getPricingTemplates().forEach(this::saveNewPricingTemplate);
		contractTemplateRepository.save(contractTemplate);
	}

	public void saveNewPricingTemplate(PricingTemplate pricingTemplate)
	{
		if (pricingTemplateRepository.existsById(pricingTemplate.getId()))
		{
			throw new DuplicateKeyException(
					STR. "Pricing template ID: \{ pricingTemplate.getId() } already exists in the database." );
		}
		pricingTemplate.getCriteriaTemplates().forEach(this::saveNewCriteriaTemplate);
		pricingTemplateRepository.save(pricingTemplate);
	}

	public void saveNewCriteriaTemplate(CriteriaTemplate criteriaTemplate)
	{
		if (criteriaTemplateRepository.existsById(criteriaTemplate.getId()))
		{
			throw new DuplicateKeyException(
					STR. "Criteria template ID: \{ criteriaTemplate.getId() } already exists in the database." );
		}
		criteriaTemplateRepository.save(criteriaTemplate);
	}

	public List<ContractTemplate> getAllContractTemplates()
	{
		return contractTemplateRepository.findAll();
	}

	public List<PricingTemplate> getAllPricingTemplates()
	{
		return pricingTemplateRepository.findAll();
	}

	public List<CriteriaTemplate> getAllCriteriaTemplates()
	{
		return criteriaTemplateRepository.findAll();
	}

}
