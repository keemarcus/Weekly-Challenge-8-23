
public class Main {
	public static void main(String[] args) {
		System.out.println(validateCard("12345678912345"));
		System.out.println(validateCard("1234-5678-9123-4567"));
		System.out.println(validateCard("378282246310005"));
		System.out.println(validateCard(" 1234 5678 9123  "));
		System.out.println(validateCard(" 1234 5678 9123 4567 8912 "));
		System.out.println(validateCard(" 1234-5678-9123-4567 "));
	}
	
	public static boolean validateCard(String number) {
		// strip the input of any hyphens or spaces
		number = number.strip();
		number = number.replaceAll("[- ]", "");
		
		// verify that the number is the correct length
		int length = number.length();
		if(length < 14 || length > 19) {
			return false;
		}
		
		// verify that the number passes the Luhn test
		int checkDigit = Integer.parseInt(number.substring(length-1));
		String[] step1 = number.substring(0, length-1).split("");
		String[] step2 = new String[step1.length];
		for(int i = 0; i < step1.length; i ++) {
			step2[i] = step1[(step1.length - 1) - i];
		}
		String[] step3 = new String[step2.length];
		for(int i = 0; i < step2.length; i ++) {
			if(i%2 == 0) {
				step3[i] = String.valueOf(Integer.parseInt(step2[i]) * 2);
				if(step3[i].length() > 1) {
					String[] chars = step3[i].split("");
					int charSum = 0;
					for(int j = 0; j < chars.length; j++) {
						charSum += Integer.parseInt(chars[j]);
					}
					step3[i] = String.valueOf(charSum);
				}
			}
			else {
				step3[i] = step2[i];
			}
			
		}
		int step4 = 0;
		for(int i = 0; i < step3.length; i ++) {
			step4 += Integer.parseInt(step3[i]);
		}
		
		String step4String = String.valueOf(step4);
		int step5 = Integer.parseInt(step4String.substring(step4String.length() - 1));
		if(10 - step5 == checkDigit) {
			return true;
		}
		else {
			return false;
		}
		
	}
}
