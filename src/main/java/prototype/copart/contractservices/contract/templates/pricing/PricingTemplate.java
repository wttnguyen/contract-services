package prototype.copart.contractservices.contract.templates.pricing;

import jakarta.persistence.*;
import lombok.Data;
import prototype.copart.contractservices.contract.templates.criteria.CriteriaTemplate;
import prototype.copart.contractservices.contract.templates.pricing.pricingmethods.PricingMethods;

import java.util.List;

@Data
@Entity
@Table(name = "pricing_templates")
public class PricingTemplate
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pricing_id")
	private Long id;

	private Long version;

	private String name;

	private String description;

	@Column(name = "default_pricing_method")
	@Convert(converter = PricingMethods.PricingMethodsConverter.class)
	private PricingMethods defaultPricingMethod;

	@OneToMany
	@JoinTable(
			name = "pricing_config", joinColumns = @JoinColumn(name = "pricing_id"),
			inverseJoinColumns = @JoinColumn(name = "criteria_id")
	)
	private List<CriteriaTemplate> criteriaTemplates;

}
