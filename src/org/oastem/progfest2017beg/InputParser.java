/**
 * 
 */
package org.oastem.progfest2017beg;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author bnguyen
 *
 */
public class InputParser {
	public static ArrayList<String> getFromFile(String file, boolean hasTopLine){
		ArrayList<String> input = new ArrayList<String>();
		try{
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String currLine;
			int lines = 0;
			
			while((currLine = reader.readLine()) != null){
				lines++;
				input.add(currLine);
			}
			
			if(hasTopLine){
				String topLine = input.remove(0);
				if(Integer.parseInt(topLine) != (lines - 1)) System.out.println("Warning: Number of lines do not match.");
			}
			
			reader.close();
		}catch(Exception e){
			System.out.println("Could not open file.");
			e.printStackTrace();
			System.exit(-1);
		}
		
		return input;
	}
	
	public static ArrayList<String> getFromFile(String file){
		return getFromFile(file,true);
	}
	
	public static ArrayList<String> getFromEntry(){
		ArrayList<String> input = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
				
		Object end = getLines(sc);
		
		System.out.println("Please enter your inputs:");
		
		if(end instanceof String){
			String currLine = sc.nextLine();
			while(!currLine.equals(end)){
				input.add(currLine);
				currLine = sc.nextLine();
			}
		}else if(end instanceof Integer){
			for(int i = 0; i < (int) end; i++){
				input.add(i,sc.nextLine());
			}
		}
		
		sc.close();
		return input;
	}
	
	public static Object getLines(Scanner sc){
		System.out.print("Please enter number of lines, or any other string as stop sequence: ");
		String first = sc.nextLine();
		Object output;
		
		if(first.trim().equals("")){
			System.out.println("Empty input. Please try again");
			return getLines(sc);
		}
		
		try{
			output = (int) Integer.parseInt(first);
		}catch(NumberFormatException e){
			output = (String) first;
		}
		
		return output;
	}
}
