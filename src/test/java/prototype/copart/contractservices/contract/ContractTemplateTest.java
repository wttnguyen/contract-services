package prototype.copart.contractservices.contract;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import prototype.copart.contractservices.contract.templates.ContractStatus;
import prototype.copart.contractservices.contract.templates.ContractTemplate;
import prototype.copart.contractservices.contract.templates.ContractTemplateRepository;
import prototype.copart.contractservices.contract.templates.criteria.CriteriaTemplate;
import prototype.copart.contractservices.contract.templates.criteria.CriteriaTemplateRepository;
import prototype.copart.contractservices.contract.templates.pricing.PricingTemplate;
import prototype.copart.contractservices.contract.templates.pricing.PricingTemplateRepository;
import prototype.copart.contractservices.contract.templates.pricing.pricingmethods.PricingMethods;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.LongStream;

@SpringBootTest
public class ContractTemplateTest
{

	@Autowired
	private ContractTemplateRepository contractRepository;

	@Autowired
	private PricingTemplateRepository pricingRepository;

	@Autowired
	private CriteriaTemplateRepository criteriaRepository;

	@Test
	void testSaveContractTemplates()
	{
		ContractTemplate contractTemplate = contractRepository.findById(1L).orElse(new ContractTemplate());
		contractTemplate.setVersion(1L);
		contractTemplate.setName("Test Contract Template Name");
		contractTemplate.setDescription("Test Contract Template Description");
		contractTemplate.setStatus(ContractStatus.ACTIVE);
		contractTemplate.setEffectiveDate(ZonedDateTime.now());

		List<PricingTemplate> pricingTemplates = LongStream.range(1, 5).mapToObj(number ->
		{
			PricingTemplate pricingTemplate = pricingRepository.findById(number).orElse(new PricingTemplate());
			pricingTemplate.setVersion(1L);
			pricingTemplate.setName(STR. "Test Pricing Template Name \{ number }" );
			pricingTemplate.setDescription(STR. "Test Pricing Description \{ number }" );
			pricingTemplate.setDefaultPricingMethod(PricingMethods.PRICING_METHOD_1);

			CriteriaTemplate criteriaTemplate = criteriaRepository.findById(number).orElse(new CriteriaTemplate());
			criteriaTemplate.setVersion(1L);
			criteriaTemplate.setAvailableOptions(
					List.of("Test Option 1", "Test Option 2", "Test Option 3", "Test Option 4", "Test Option 5"));
			criteriaTemplate.setSelectedOptions(List.of(STR. "Test Option \{ number }" ));
			criteriaRepository.save(criteriaTemplate);

			pricingTemplate.setCriteriaTemplates(List.of(criteriaTemplate));
			pricingRepository.save(pricingTemplate);
			return pricingTemplate;
		}).toList();

		contractTemplate.setPricingTemplates(pricingTemplates);
		contractRepository.save(contractTemplate);
	}

	@Test
	void testFindContractTemplates()
	{
		ContractTemplate contractTemplate = contractRepository.findById(1L).orElse(new ContractTemplate());
		System.out.println(contractTemplate);
	}

}
