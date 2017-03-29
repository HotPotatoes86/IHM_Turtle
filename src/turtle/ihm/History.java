package turtle.ihm;

import java.awt.TextArea;

import javax.swing.JPanel;

import turtle.model.Turtle;

public final class History extends JPanel{
	
	//----------------------Attributes----------------------//
	private static final long serialVersionUID = 5413144947849401964L;
	
	private static final TextArea text = new TextArea(Turtle.BOARD_SIZE,20);
	
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
    
   public static void deleteLastLine(Turtle t) {
	  if (!t.getCommands().isEmpty()) {
		   int textLength = History.text.getText().length();
		   int commandLength = t.getCommands().peek().length();
		   History.text.setText(History.text.getText().substring(0, textLength-commandLength-1));
	  }
    }
   
}
