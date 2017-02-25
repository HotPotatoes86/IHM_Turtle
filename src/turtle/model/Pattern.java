package turtle.model;

import java.util.ArrayList;

public class Pattern {

	//----------------------Attributes----------------------//
	private ArrayList<Integer> parts;
	
	public Pattern(ArrayList<Integer> list){
		this.parts = list;
	}
	
	//----------------------Constructors----------------------//
	public Pattern(){
		this.parts = new ArrayList<>();
	}
	
	//----------------------Methods----------------------//
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
	
}