package org.oastem.progfest2017beg;

import java.util.ArrayList;

public class Problem2 {

	public static void main(String[] args) {
		ArrayList<String> inputs = InputParser.getFromFile("2.in",true);
		
		for(int i = 0; i < inputs.size(); i++){
			System.out.println(processPO(inputs.get(i)));
		}

	}
	
	public static String processPO(String input){
		String[] data = input.split(",");
		String programmer = data[0].trim();
		String lang = data[1].trim();
		String[] items = data[2].trim().split(" ");
		
		boolean isProgrammer = programmer.equals("yes");
		boolean isCOBOL = lang.equals("COBOL");
		double original = 0D;
		int itemCount = 0;
		
		double total = 0D;
		
		for(int i = 0; i < items.length; i++){
			double currItem = Double.parseDouble(items[i]);
			original += currItem;
			itemCount++;
		}
		
		if(!isProgrammer || isCOBOL){
			total = original;
		}else{
			double currPrice = original;
			if(itemCount >=2) currPrice *= 0.85;
			if(itemCount >=5) currPrice *= 0.9;
			total = currPrice * 0.9;
		}
		
		String output = String.format("%.2f",original);
		output += " " + String.format("%.2f",total);
		return output;
	}

}
