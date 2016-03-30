package utility;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FieldValidator {

	// this method validates first and second name fields
	public static boolean checkNameField(JTextField firstNameField) {

		boolean valid = false;

		if (firstNameField.getText() != null && !firstNameField.getText().trim().isEmpty()) {

			if (firstNameField.getText().length() <= 20) {

				valid = true;
			}

			for (int x = 0; x < firstNameField.getText().length(); x++) {

				if (!Character.isLetter(firstNameField.getText().charAt(x))) {

					valid = false;
				}
			}
		}

		return valid;
	}
	
	public static boolean checkTemplateNameField(JTextField templateNameField) {

		boolean valid = false;

		if (templateNameField.getText() != null && !templateNameField.getText().trim().isEmpty()) {

			if (templateNameField.getText().length() <= 20) {

				valid = true;
			}
		}

		return valid;
	}

	// this method validates phone number fields
	public static boolean checkPhoneNo(JTextField phoneField) {

		boolean valid = false;

		if (phoneField.getText() != null && !phoneField.getText().trim().isEmpty()) {

			if (phoneField.getText().length() > 7 && phoneField.getText().length() <= 15) {

				valid = true;
			}

			for (int x = 0; x < phoneField.getText().length(); x++) {

				if (!Character.isDigit(phoneField.getText().charAt(x))) {

					valid = false;
				}
			}
		}
		return valid;
	}

	// this method validates email fields
	public static boolean checkEmail(JTextField emailField) {

		boolean valid = false;

		if (emailField.getText() != null && !emailField.getText().trim().isEmpty()) {

			if (emailField.getText().length() < 5 && emailField.getText().length() > 30) {

				valid = false;
			}

			if ((emailField.getText().contains("@") && emailField.getText().contains("."))) {

				valid = true;
			}
		}
		return valid;
	}

	// this method validates address fields
	public static boolean checkAddress(JTextField addressField) {

		boolean valid = true;

		if (addressField.getText() != null && !addressField.getText().trim().isEmpty()) {

			if (addressField.getText().length() > 60) {

				valid = false;
			}
		}

		return valid;
	}

	// this method validates information and history fields
	public static boolean checkInfoHistory(JTextField infoField) {

		boolean valid = true;

		if (infoField.getText() != null && !infoField.getText().trim().isEmpty()) {

			if (infoField.getText().length() > 500) {

				valid = false;
			}
		}

		return valid;
	}
	
	public static boolean checkText(JTextArea messageText) {

		boolean valid = false;

		if (messageText.getText() != null && !messageText.getText().trim().isEmpty()) {

			if (messageText.getText().length() <= 500) {

				valid = true;
			}
		}

		return valid;
	}


	// this method validates pps number field
	public static boolean checkPpsNo(JTextField ppsNoField) {

		boolean valid = true;

		if (ppsNoField.getText() != null && !ppsNoField.getText().trim().isEmpty()) {

			if (ppsNoField.getText().length() == 8 && Character.isLetter(ppsNoField.getText().charAt(7))) {

				for (int x = 0; x < 7; x++) {

					if (!(Character.isDigit(ppsNoField.getText().charAt(x)))) {

						valid = false;
					}
				}

			} else if (ppsNoField.getText().length() == 9 && Character.isLetter(ppsNoField.getText().charAt(8))) {

				for (int x = 0; x < 8; x++) {

					if (!(Character.isDigit(ppsNoField.getText().charAt(x)))) {

						valid = false;
					}
				}
			} else
				valid = false;
		} else
			valid = false;

		return valid;
	}

	// this method validates service name field
	public static boolean checkServiceName(JTextField serviceField) {

		boolean valid = false;

		if (serviceField.getText() != null && !serviceField.getText().trim().isEmpty()){
		
			if (serviceField.getText().length() <= 30) {

				valid = true;
			}
		}
		return valid;
	}

	// this method validates service price field
	public static boolean checkForDouble(JTextField priceField) {

		if (priceField.getText() != null && !priceField.getText().trim().isEmpty()){
			
			try {
				Double.parseDouble(priceField.getText());
				return true;

			} catch (NumberFormatException e) {

			return false;
			}
		}
		return false;
	}

	// this method validates service duration field
	public static boolean checkForInteger(JTextField durationField) {

		if (durationField.getText() != null && !durationField.getText().trim().isEmpty()){
			
			try {
				Integer.parseInt(durationField.getText());
				return true;

			} catch (NumberFormatException e) {

			return false;
			}
		}
		return false;
	}

	public static boolean checkPermissionField(String text) {

		boolean valid = false;

		if (text.length() >= 4 && text.length() <= 20 && !text.isEmpty()) {

			valid = true;
		}

		return valid;
	}
}
