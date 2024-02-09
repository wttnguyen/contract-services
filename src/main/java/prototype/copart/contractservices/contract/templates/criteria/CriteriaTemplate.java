package prototype.copart.contractservices.contract.templates.criteria;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "criteria_templates")
public class CriteriaTemplate
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "criteria_id")
	private Long id;

	private Long version;

	@ElementCollection
	@CollectionTable(name = "criteria_available_options", joinColumns = @JoinColumn(name = "criteria_id"))
	@Column(name = "available_option")
	private List<String> availableOptions;

	@ElementCollection
	@CollectionTable(name = "criteria_selected_options", joinColumns = @JoinColumn(name = "criteria_id"))
	@Column(name = "selected_option")
	private List<String> selectedOptions;

}
