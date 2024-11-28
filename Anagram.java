/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		String str1Processed = preProcessNoWhiteSpace(str1);
		String str2Processed = preProcessNoWhiteSpace(str2);

		
		for (int i = 0; i < str1Processed.length(); i++){
			char inspectedChar1 = str1Processed.charAt(i);
				if ((str2Processed.indexOf(inspectedChar1) >= 0)){
					str2Processed = str2Processed.substring(0, str2Processed.indexOf(inspectedChar1)) + str2Processed.substring(str2Processed.indexOf(inspectedChar1) + 1);
			}
			
		}
		if (str2Processed.length() == 0){
			return true;
		}else{
			return false;
		}
		
			
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String lowerCaseString = str.toLowerCase();

		String cleanedString = "";

		for (int i = 0 ;i < lowerCaseString.length(); i++ ){
			char charInpected = lowerCaseString.charAt(i);
			if (((charInpected >= 'a') && (charInpected <= 'z')) || (charInpected == 32)){
				cleanedString = cleanedString + charInpected;
			}
		}
		return cleanedString;
	} 
	
	public static String preProcessNoWhiteSpace(String str) {
		String lowerCaseString = str.toLowerCase();

		String cleanedString = "";

		for (int i = 0 ;i < lowerCaseString.length(); i++ ){
			char charInpected = lowerCaseString.charAt(i);
			if ((charInpected >= 'a') && (charInpected <= 'z')){
				cleanedString = cleanedString + charInpected;
			}
		}
		return cleanedString;
	} 

	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String processedStr = preProcessNoWhiteSpace(str);
		String random = "";
		while (processedStr.length() > 0){
			int randomImdex = (int) (Math.random() * processedStr.length());
			random = random + processedStr.charAt(randomImdex);
			processedStr = processedStr.substring(0, randomImdex) + processedStr.substring(randomImdex + 1);


		}
		return random;
	}
}
