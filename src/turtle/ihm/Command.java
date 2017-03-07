package turtle.ihm;

import java.awt.FlowLayout;
import javax.swing.*;

public class Command extends JPanel {
	
    private JComboBox actions;
    private JTextArea parameters;
    
    public Command(){
        super(new FlowLayout());
        //this.setLayout(new FlowLayout());
        Object[] commands = new Object[]{"GO","TURN","DRAW","COLOR"};
        
        actions = new JComboBox(commands);
        this.add(actions);
        parameters = new JTextArea("Paramètre de l'action");
        this.add(parameters);
        JButton apply = new JButton("Apply");
        this.add(apply);
    }
}
