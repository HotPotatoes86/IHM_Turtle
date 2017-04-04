package turtle.ihm;

import java.awt.TextArea;

import javax.swing.JPanel;

import turtle.model.Turtle;

public final class History extends JPanel{
	
	/**
	 * In this class, all the methods are static to enable to use its methods easily in the others classes
	 * This is possible because history is a unique element of the interface
	 */
	
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
    /**
     * set the text of the textarea with an empty text
     */
    public static void deleteAll() {
    	History.TEXT.setText("");
    }
    
    /**
     * add a text to the textarea
     * @param txt text you want to add
     */
    public static void addText(String txt) {
    	History.TEXT.setText(History.TEXT.getText() + txt + "\n");
    }
    
    /**
     * delete the last command of the history
     * @param t the turtle
     */
   public static void deleteLastLine(Turtle t) {
	  if (!t.getCommands().isEmpty()) {
		   int textLength = History.TEXT.getText().length();
		   int commandLength = t.getCommands().peek().length(); //the top of the stack is the last command
		   try {
			   //if there are the char '\n' before the command, we also remove it
			   if (History.TEXT.getText().charAt(textLength-commandLength-2)=='\n') {
				   History.TEXT.setText(History.TEXT.getText().substring(0, textLength-commandLength-1));
			   }else {
				   History.TEXT.setText(History.TEXT.getText().substring(0, textLength-commandLength));
			   }
		   }catch (Exception e) {
			   //if it's the last command in the history we catch the exception and 
			   //set the text of the textarea with an empty text
			   History.TEXT.setText("");
		   }
	  }
    }
   
   /**
    * 
    * @return the text of the textarea
    */
   public static String getText() {
	   return History.TEXT.getText();
   }
   
}
