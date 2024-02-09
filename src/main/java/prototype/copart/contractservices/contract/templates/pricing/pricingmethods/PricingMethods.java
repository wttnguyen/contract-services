package prototype.copart.contractservices.contract.templates.pricing.pricingmethods;

import jakarta.persistence.Converter;
import prototype.copart.contractservices.util.EnumConverter;

public enum PricingMethods
{

	PRICING_METHOD_0,
	PRICING_METHOD_1;

	@Converter(autoApply = true)
	public static class PricingMethodsConverter extends EnumConverter<PricingMethods>
	{

	}

}
