package _01_StringBuilder;


public class _03_StringBuilder {
    
    public static String append(String str, char[] characters) {
    	String output = str;
    	for(char c: characters) {
    		output += c;
    	}
        return output;
    }
    
    public static String reverse(String str) {
    	String output = "";
    	for(int i = str.length() - 1; i>=0; i--) {
    		output += str.charAt(i);
    	}
        return output;
    }
    
    public static String insert(String str, int index, char newChar) {
    	return str.substring(0, index) + newChar + str.substring(index);
    }
    
    public static String delete(String str, int startIndex, int endIndex) {
        return str.substring(0, startIndex) + str.substring(endIndex);
    }
}