package org.oastem.progfest2017beg;

import java.util.ArrayList;

public class Problem1 {
	public static void main(String[] args){
		ArrayList<String> inputs = InputParser.getFromFile("1.in");
		//ArrayList<String> inputs = InputParser.getFromEntry();
		
		ArrayList<String> output = new ArrayList<String>();
		
		for(int i = 0; i < inputs.size(); i++){
			String curr = inputs.get(i);
			if(curr.substring(0, 1).equals("@")) output.add(encode(curr));
			else if(curr.substring(0, 1).equals("$")) output.add(decode(curr));
		}
		
		for(int i = 0; i < output.size(); i++){
			System.out.println(output.get(i));
		}
	}
	
	public static String encode(String in){
		String[] words = in.substring(1).split(" ");
		String[] newWords = new String[words.length];
		for(int i = 0; i < words.length; i++){
			char[] letters = words[i].toCharArray();
			char[] newLetters = new char[letters.length];
			
			for(int j = 0; j < letters.length; j++){
				char l = letters[j];
				if((l >= 65 && l <= 89) || (l >= 97 && l <= 121)){
					l++;
				}else if(l == 122) l = 'a';
				else if(l == 90) l = 'A';
				
				newLetters[letters.length - j - 1] = l;
			}
		
		newWords[i] = new String(newLetters);
		}
		
		String result = "";
		for(String i : newWords){
			result += i;
			result += " ";
		}
		return result.trim();
	}
	
	public static String decode(String in){
		String[] words = in.substring(1).split(" ");
		String[] newWords = new String[words.length];
		for(int i = 0; i < words.length; i++){
			char[] letters = words[i].toCharArray();
			char[] newLetters = new char[letters.length];
			
			for(int j = 0; j < letters.length; j++){
				char l = letters[j];
				if((l >= 66 && l <= 90) || (l >= 98 && l <= 122)){
					l--;
				}else if(l == 97) l = 'z';
				else if(l == 65) l = 'Z';
				
				newLetters[letters.length - j - 1] = l;
			}
		
		newWords[i] = new String(newLetters);
		}
		
		String result = "";
		for(String i : newWords){
			result += i;
			result += " ";
		}
		return result.trim();
	}
}
