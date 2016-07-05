package cybage.spring.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import cybage.spring.model.Beer;

@Component
public class BeerValidator implements Validator{

	public boolean supports(Class<?> clazz) {
		 return Beer.class.isAssignableFrom(clazz);
	}

	public void validate(Object arg0, Errors errors) {
	    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "brand", "brand.error");
	    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "price.error");
		
	}

}
