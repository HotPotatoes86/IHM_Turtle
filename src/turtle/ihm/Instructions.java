package turtle.ihm;

import java.awt.TextArea;
import javax.swing.*;

public class Instructions extends JPanel{
	
	private static final long serialVersionUID = 5413144947849401964L;
	
	private final TextArea text;
    
    public Instructions(){
        super();
        this.text = new TextArea(20,20);
        this.text.setEditable(false);
        JScrollPane my_scroll = new JScrollPane(text);
        this.add(my_scroll);
    }
}
