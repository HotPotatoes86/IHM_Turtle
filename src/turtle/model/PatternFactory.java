package turtle.model;

import java.util.ArrayList;

/*
 * Pattern is modelized with integer (0=forward, 1=forward-right, 2=right, 3=right-backward, ..., 7=left-forward)
 */
public final class PatternFactory {

	/**
	 * 
	 * @param size size of the pattern
	 * @return list of patterns
	 */
	public final static ArrayList<Pattern> createSimplePattern(int size){
		ArrayList<Pattern> res = new ArrayList<>();
		Pattern p = new Pattern();
		for (int j=0; j<8; j++){
			for (int i=0; i<size; i++){
				p.add(j);
			}
			res.add(p);
			p = new Pattern();
		}
		return res;
	}
	
	public final static ArrayList<Pattern> createReductedPattern(int size){
		ArrayList<Pattern> res = new ArrayList<>();
		Pattern p = new Pattern();
		for (int j=0; j<8; j+=2){
			for (int i=0; i<size; i++){
				p.add(j);
			}
			res.add(p);
			p = new Pattern();
		}
		return res;
	}
	
	public final static ArrayList<Pattern> createTurningPattern(){
		ArrayList<Pattern> res = new ArrayList<>();
		Pattern p = new Pattern();
		for (int j=0; j<8; j++){
			p.add(j);
			p.add(j);
			if (j==1){
				p.add(7);
			}else if (j==0){
				p.add(6);
			}else{
				p.add(j-2);
			}
			res.add(p);
			p = new Pattern();
		}
		return res;
	}
}