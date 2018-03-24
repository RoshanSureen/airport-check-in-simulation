package utility;

import java.util.Random;

public class UtilsFlight {

	
	/**
	 * this function checks and returns the correct format of the flight code
	 * @param code the original flight_code
	 * @param dest the destination of the flight
	 * @return the correct formatted flight_code
	 */
	public String checkFlightCode(String code, String dest) {
		
		String lenCode = this.checkAndFixFlightLength(code);
		String initials = this.getDestinationInitials(dest);
		String initialCode = this.checkAndFixFlightInitials(lenCode, initials);
		
		String Numcode = this.checkAndFixNum(initialCode);
		
		return Numcode;
	
	}
	
	/**
	 * This function checks the length of the flight_code
	 * @param code the original flight_code
	 * @return returns the correct length of the flight_code
	 */
	public String checkAndFixFlightLength(String code) {
		if (code.length() != 5) {
			if (code.length() > 5) {
				return code.substring(0, 5);
			} else {
				return "GE007";
			}
		} else {
			return code;
		}
	}
	
	/**
	 * This function checks if the first 2 letters of the flight_code match the Initials of the destination
	 * @param code flight_code with corrected length
	 * @param dest destination of the flight
	 * @return returns the flight_code with the correct initials
	 */
	public String checkAndFixFlightInitials(String code, String dest) {
		String initials = this.getDestinationInitials(dest);
		String checkInitials = code.substring(0, 2);
		String rest = code.substring(2, 5);
		if (!checkInitials.equals(initials)) {
			String newCode = initials+rest;
			return newCode;
		} else {
			return code;
		}
	}
	
	
	/**
	 * this function checks that the last 3 charecters is an numeric string
	 * @param code the flight_code with the corrected length and initials
	 * @return returns the flight_code with appropriate numeric string
	 */
	public String checkAndFixNum(String code) {
		String Num = code.substring(2, 5);
		if (this.isNumeric(Num) != true) {			
			String newCode = code.substring(0, 2)+this.generateNewNum();
			return newCode;
		} else {
			return code;
		}
	}
	
	/**
	 * this function returns the initials of the stirng
	 * @param dest the destination string whose initials are needed
	 * @return returns the first 2 charecters in Uppercase from the destination string 
	 */
	public String getDestinationInitials(String dest) {
		  StringBuilder sb = new StringBuilder();
		  char first = dest.charAt(0);
		  char second = dest.charAt(1);
		  String initials = sb.append(first).append(second).toString();
		  return initials.toUpperCase();
	}
	
	
	/**
	 * this function checks weather the given string is numeric
	 * @param str the string value to be checked
	 * @return returns true or false
	 */
	public boolean isNumeric(String str) {
        for (int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            if (!Character.isDigit(c))
                return false;
        }

        return true;
    }

	/**
	 * this function returns a new numeric string
	 * @return returns a numeric string of length 3 charecters
	 */
	public String generateNewNum() {
		Random random = new Random();
		int salt = random.nextInt(900) + 100;
		
		String newNum = Integer.toString(salt);
		return newNum;
	}
	
}
