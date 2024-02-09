package prototype.copart.contractservices.contract;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import prototype.copart.contractservices.contract.templates.ContractTemplateRepository;
import prototype.copart.contractservices.contract.templates.criteria.CriteriaTemplateRepository;
import prototype.copart.contractservices.contract.templates.pricing.PricingTemplateRepository;

@SpringBootTest
public class ContractTemplateTest
{

	@Autowired
	private ContractTemplateRepository contractRepository;

	@Autowired
	private PricingTemplateRepository pricingRepository;

	@Autowired
	private CriteriaTemplateRepository criteriaRepository;

}
