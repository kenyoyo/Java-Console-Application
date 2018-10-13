
public class EmailGeneratorService {
	
	public static String generateEmail(PersonalData personal) {		
		return personal.getFirstName().toLowerCase() + "." + personal.getLastName().toLowerCase() + "@" + personal.getDepartment() 
		+ ".xyzcompany.com";
	}
	
	public static String generatePassword() {
		String letter = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder password = new StringBuilder();
		
		for(int i=0; i<10; i++) {
			password.append(letter.charAt((int)(Math.random() * (letter.length()-1))));
		}
		
		return password.toString();
	}
}
