package turtle.ihm;

import java.awt.FlowLayout;
import javax.swing.*;

public class Command extends JPanel {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -2228297003945477936L;
	private JComboBox<Object> actions;
    private JTextArea parameters;
    
    /**
     * read and launch the commands
     */
    public Command(){
        super(new FlowLayout());
        //this.setLayout(new FlowLayout());
        Object[] commands = new Object[]{"GO","TURN","DRAW","COLOR"};
        
        this.actions = new JComboBox<>(commands);
        this.add(actions);
        this.parameters = new JTextArea("Paramètre de l'action");
        this.add(parameters);
        JButton apply = new JButton("Apply");
        this.add(apply);
    }
}
