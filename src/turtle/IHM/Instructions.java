package turtle.IHM;

import java.awt.TextArea;
import javax.swing.*;

public class Instructions extends JPanel{
    private final TextArea text;
    
    public Instructions(){
        super();
        this.text = new TextArea(20,20);
        JScrollPane my_scroll = new JScrollPane(text);
        this.add(my_scroll);
    }
}
