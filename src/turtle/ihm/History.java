package turtle.ihm;

import java.awt.TextArea;
import javax.swing.*;

public final class History extends JPanel{
	
	private static final long serialVersionUID = 5413144947849401964L;
	
	private static final TextArea text = new TextArea(20,20);
	private static JScrollPane my_scroll = new JScrollPane(text);
	
    public History(){
        super();
        History.text.setEditable(false);
        this.add(text);
    }
    
    public static void addText(String txt) {
    	History.text.setText(History.text.getText() + txt + "\n");
    }
}
