package prototype.copart.contractservices.contract.templates;

import jakarta.persistence.Converter;
import prototype.copart.contractservices.util.EnumConverter;

public enum ContractStatus
{

	ACTIVE,
	INACTIVE;

	@Converter(autoApply = true)
	public static class ContractStatusConverter extends EnumConverter<ContractStatus>
	{

	}

}
