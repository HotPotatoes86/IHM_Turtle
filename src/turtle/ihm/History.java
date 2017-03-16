package turtle.ihm;

import java.awt.TextArea;
import javax.swing.*;

import turtle.model.CommandUndo;

public final class History extends JPanel{
	
	//----------------------Attributes----------------------//
	private static final long serialVersionUID = 5413144947849401964L;
	
	private static final TextArea text = new TextArea(20,20);
	//private static JScrollPane my_scroll = new JScrollPane(text);
	
	//----------------------Constructors----------------------//
    public History(){
        super();
        History.text.setEditable(false);
        this.add(History.text);
    }
    
  //----------------------Methods----------------------//
    public static void addText(String txt) {
    	History.text.setText(History.text.getText() + txt + "\n");
    }
    
   public static void deleteLastLine() {
    	History.text.setText(History.text.getText().substring(0, History.text.getText().length()-CommandUndo.lastLine().length()-1));
    }
}
