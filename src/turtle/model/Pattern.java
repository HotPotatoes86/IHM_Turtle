package turtle.model;

import java.util.ArrayList;

public class Pattern {

	//----------------------Attributes----------------------//
	//A pattern is decomposed into integers that represent the 8 possible directions
	private ArrayList<Integer> parts;
	
	//----------------------Constructors----------------------//
	public Pattern(){
		this.parts = new ArrayList<>();
	}
	
	public Pattern(ArrayList<Integer> list){
		this.parts = list;
	}
	
	//----------------------Methods----------------------//
	/**
	 * add an integer to the pattern
	 * @param x
	 */
	public void add(int x){
		this.parts.add(x);
	}
	
	/**
	 * remove the last integer of the list
	 */
	public void remove(){
		if (this.parts.size()>0){
			this.parts.remove(this.parts.size()-1);
		}
	}
	
	public ArrayList<Integer> getParts(){
		return this.parts;
	}
	
}