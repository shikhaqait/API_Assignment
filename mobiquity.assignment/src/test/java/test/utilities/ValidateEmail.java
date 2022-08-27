package test.utilities;

import org.apache.commons.validator.routines.EmailValidator;

public class ValidateEmail {

	public static boolean emailValidator(String emailid) {
		EmailValidator validator = EmailValidator.getInstance();
		return validator.isValid(emailid);
	}

}
