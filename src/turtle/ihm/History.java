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
	   System.out.println((History.text.getText().length()-1) + " - " + (t.getCommands().peek().length()-1));
    	History.text.setText(History.text.getText().substring(0, History.text.getText().length()-t.getCommands().peek().length()-1));
    }
}
