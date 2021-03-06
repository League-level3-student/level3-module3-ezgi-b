package _00_Intro_To_String_Methods;

import java.util.Arrays;
import java.util.Base64;

/*
 * Visit the JavaDocs for the String class to view everything you can do with a String.
 * https://docs.oracle.com/javase/7/docs/api/java/lang/String.html
 * https://docs.oracle.com/javase/7/docs/api/java/lang/Character.html
 *
 * HINT:  Here are some String methods you might find useful 
 * contains
 * replace
 * trim
 * length
 * getBytes
 * endsWith
 * split 
 * indexOf
 * lastIndexOf
 * compareTo(IgnoreCase)
 * substring
 * toUpperCase/toLowerCase
 * valueOf
 *
 * Here are some Character methods you might find useful:
 * Character.toLowerCase(char c);
 * Character.toUpperCase(char c);
 * Character.isLetter(char c);
 * Character.isDigit(char c);
 * Character.getNumericValue(char c);
 */

public class _01_StringMethods {

    // Given Strings s1 and s2, return the longer String
    public static String longerString(String s1, String s2) {
    	if(s1.length()>s2.length()) {
    		return s1;
    	}else if(s1.length()<s2.length()) {
    		return s2;
    	}
        return "equal";
    }

    // If String s contains the word "underscores", change all of the spaces
    // to underscores
    public static String formatSpaces(String s) {
    	String temp = s;
    	if(s.contains("underscores")) temp = s.replace(" ", "_");
        return temp;
    }

    // Return the name of the person whose LAST name would appear first if they
    // were in alphabetical order.
    // You cannot assume there are no extra spaces around the name, but you can
    // assume there is only one space between the first and last name
    public static String lineLeader(String s1, String s2, String s3) {
    	s1 = s1.trim();
    	s2 = s2.trim();
    	s3 = s3.trim();
    	String[] t = {s1, s2, s3};
    	String[] s = t.clone();
    	for(int i = 0; i<s.length; i++) {
    		s[i] = s[i].substring(s[i].indexOf(" ")+1);
    	}
    	int index = 0;
    	for(int i = 0; i<s.length; i++) {
    		if(s[i].compareTo(s[index])<0) {
    			index = i;
    		}
    	}
        return t[index];
    }

    // Return the sum of all numerical digits in the String
    public static int numeralSum(String s) {
    	int sum = 0;
    	for(int i = 0; i<s.length(); i++) {
    		if(Character.isDigit(s.charAt(i))) {
    			sum += Integer.parseInt(s.substring(i, i + 1));
    		}
    	}
        return sum;
    }

    // Return the number of times String substring appears in String s
    public static int substringCount(String s, String substring) {
    	int num = 0;
    	while(s.contains(substring)) {
    		s = s.substring(s.indexOf(substring) + substring.length());
    		num++;
    	}
        return num;
    }

    // Call Utilities.encrypt at the bottom of this file to encrypt String s
    public static String encrypt(String s, char key) {
    	byte[] arr = s.getBytes();
    	return Utilities.encrypt(arr, (byte) key);
    }

    // Call Utilities.decrypt at the bottom of this file to decrypt the
    // cyphertext (encrypted text)
    public static String decrypt(String s, char key) {
    	return Utilities.decrypt(s, (byte) key);
    }

    // Return the number of words in String s that end with String substring
    // You can assume there are no punctuation marks between words
    public static int wordsEndsWithSubstring(String s, String substring) {
    	int num = 0;
    	String[] arr = s.split(" ");
    	for(int i = 0; i < arr.length; i++) {
    		if(arr[i].length() >= substring.length()) {
    			String temp = arr[i].substring(arr[i].length() - substring.length());
    			if(temp.equals(substring)) num++;
    		}
    	}
        return num;
    }

    // Given String s, return the number of characters between the first
    // occurrence of String substring and the final occurrence
    // You can assume that substring will appear at least twice
    public static int distance(String s, String substring) {
    	int first = s.indexOf(substring);
    	int last = first;
    	while(s.indexOf(substring, last + substring.length()) > 0) {
    		last = s.indexOf(substring, last + substring.length());
    	}
        return last - first - substring.length();
    }

    // Return true if String s is a palindrome
    // palindromes are words or phrases are read the same forward as backward.
    // HINT: ignore/remove all punctuation and spaces in the String
    public static boolean palindrome(String s) {
    	String x = "";
    	for(int i = 0; i<s.length(); i++) {
    		if(Character.isLetter(s.charAt(i))) {
    			x += s.substring(i, i + 1);
    		}
    	}
    	String other = "";
    	for(int i = x.length() - 1; i>=0; i--) {
    		other += x.substring(i, i + 1);
    	}
        return other.compareToIgnoreCase(x) == 0;
    }
}

class Utilities {
    // This basic encryption scheme is called single-byte xor. It takes a
    // single byte and uses exclusive-or on every character in the String.
    public static String encrypt(byte[] plaintext, byte key) {
        for (int i = 0; i < plaintext.length; i++) {
            plaintext[i] = (byte) (plaintext[i] ^ key);
        }
        return Base64.getEncoder().encodeToString(plaintext);
    }

    public static String decrypt(String cyphertext, byte key) {
        byte[] b = Base64.getDecoder().decode(cyphertext);
        for (int i = 0; i < b.length; i++) {
            b[i] = (byte) (b[i] ^ key);
        }
        return new String(b);
    }
}
