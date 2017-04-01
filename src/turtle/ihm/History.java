package turtle.ihm;

import java.awt.TextArea;

import javax.swing.JPanel;

import turtle.model.Turtle;

public final class History extends JPanel{
	
	//----------------------Attributes----------------------//
	private static final long serialVersionUID = 5413144947849401964L;
	
	private static final TextArea TEXT = new TextArea(Turtle.BOARD_SIZE,20);
	
	//----------------------Constructors----------------------//
    public History(boolean isExpert){
        super();
        if (!isExpert) History.TEXT.setEditable(false);
        this.add(History.TEXT);
    }
    
  //----------------------Methods----------------------//
    public static void deleteAll() {
    	History.TEXT.setText("");
    }
    
    public static void addText(String txt) {
    	History.TEXT.setText(History.TEXT.getText() + txt + "\n");
    }
    
   public static void deleteLastLine(Turtle t) {
	  if (!t.getCommands().isEmpty()) {
		   int textLength = History.TEXT.getText().length();
		   int commandLength = t.getCommands().peek().length();
		   try {
			   if (History.TEXT.getText().charAt(textLength-commandLength-1)=='\n') {
				   History.TEXT.setText(History.TEXT.getText().substring(0, textLength-commandLength-1));
			   }else {
				   History.TEXT.setText(History.TEXT.getText().substring(0, textLength-commandLength));
			   }
		   }catch (Exception e) {
			   History.TEXT.setText("");
		   }
	  }
    }
   
   public static String getText() {
	   return History.TEXT.getText();
   }
   
}
