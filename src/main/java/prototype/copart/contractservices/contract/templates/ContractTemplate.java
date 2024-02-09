package prototype.copart.contractservices.contract.templates;

import jakarta.persistence.*;
import lombok.Data;
import prototype.copart.contractservices.contract.templates.pricing.PricingTemplate;

import java.time.ZonedDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "contract_templates")
public class ContractTemplate
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "contract_id")
	private Long id;

	private Long version;

	private String name;

	private String description;

	@Convert(converter = ContractStatus.ContractStatusConverter.class)
	private ContractStatus status;

	@Column(name = "effective_date")
	private ZonedDateTime effectiveDate;

	@OneToMany
	@JoinTable(
			name = "contract_config", joinColumns = @JoinColumn(name = "contract_id"),
			inverseJoinColumns = @JoinColumn(name = "pricing_id")
	)
	private List<PricingTemplate> pricingTemplates;

}
