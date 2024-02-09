package prototype.copart.contractservices.util;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.lang.reflect.ParameterizedType;

@Converter
public class EnumConverter<E extends Enum<E>> implements AttributeConverter<Enum<E>, String>
{

	@Override
	public String convertToDatabaseColumn(Enum<E> e)
	{
		return e.name();
	}

	@Override
	public Enum<E> convertToEntityAttribute(String s)
	{
		@SuppressWarnings("unchecked")
		Class<E> type = (Class<E>) ((ParameterizedType) this.getClass()
															.getGenericSuperclass()).getActualTypeArguments()[0];
		return E.valueOf(type, s);
	}

}
