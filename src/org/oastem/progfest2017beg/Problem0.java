package org.oastem.progfest2017beg;

import java.util.ArrayList;

public class Problem0 {

	public static void main(String[] args) {
		ArrayList<String> inputs = InputParser.getFromFile("0.in",false);
		//ArrayList<String> inputs = InputParser.getFromEntry();
		
		int[] output = process(inputs);
		for(int i : output){
			System.out.println(i);
		}
	}
	
	public static int[] process(ArrayList<String> inputs){
		int[] output = new int[inputs.size()];
		
		for(int i = 0; i < inputs.size(); i++){
			int currInput;
			try{
				currInput = Integer.parseInt(inputs.get(i));
				output[i] = (int) Math.pow(currInput, 2);
			}catch(NumberFormatException e){
				System.out.println("Input " + i + " is invalid!");
			}
		}
		
		return output;
	}

}
