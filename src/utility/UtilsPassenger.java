package utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import flight.*;

public class UtilsPassenger {
	private HashMap<String, Flight> flight;
	
	public String checkBookingCode(String code, String initials) {
		
		String lenCode = this.checkAndFixLength(code);
		
		String initialCode =this.checkAndFixInitials(lenCode, initials);
		
		String Xcode = this.checkAndFixX(initialCode);
		
		String Alphacode = this.checkAndFixAlphaNum(Xcode);
		return Alphacode;
	}
	
	public String checkAndFixLength(String code) {
		if (code.length() != 11) {
			if (code.length() > 11) {
				return code.substring(0, 11);
			} else {
				return "RSX12S4L67W";
			}
		} else {
			return code;
		}
	}
	
	public String checkAndFixInitials(String code, String initials) {
		String checkInitials = code.substring(0, 2);
		String rest = code.substring(2, 11);
		if (!checkInitials.equals(initials)) {
			String newCode = initials+rest;
			return newCode;
		} else {
			return code;
		}
	}
	
	public String checkAndFixX(String code) {
		char checkX = code.charAt(2);
		if (checkX != 'X') {
			String myCode = code.substring(0,2)+'X'+code.substring(3);
			return myCode;
		} else {
			return code;
		}
	}
	
	
	public String checkAndFixAlphaNum(String code) {
		String AlphaNum = code.substring(3, 11);
		if (this.isAlphanumeric(AlphaNum) != true) {
			String newAlphaNum = this.getSaltString();
			
			String newCode = code.substring(0, 3)+newAlphaNum;
			return newCode;
		} else {
			return code;
		}
	}
	
	public String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 8) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
	
	public boolean isAlphanumeric(String str) {
        for (int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            if (!Character.isDigit(c) && !Character.isLetter(c))
                return false;
        }

        return true;
    }
	
	
	public String getFCode(HashMap<String, Flight> fd, String dest) {
		this.flight = fd;
		String fCode = "";
		for (Map.Entry<String, Flight> kv: flight.entrySet()) {
			Flight value = kv.getValue();
			String checkdest = value.getDestination();
			if (dest.equals(checkdest)) {
				fCode = value.getFlightCode();
			}
		}
		return fCode;
	}
}
