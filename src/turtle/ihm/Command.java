package turtle.ihm;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import turtle.model.Turtle;

public class Command extends JPanel {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -2228297003945477936L;
	private JComboBox<String> actions;
    private JTextArea parameters;
    private Turtle turtle;
    
    /**
     * read and launch the commands
     */
    public Command(Turtle turtle){
        super(new FlowLayout());
        this.turtle = turtle;
        String[] commands = new String[]{"GO","TURN","DRAW","COLOR"};
        
        this.actions = new JComboBox<>(commands);
        this.add(actions);
        this.parameters = new JTextArea(1, 5);
        JScrollPane scrollPane = new JScrollPane(this.parameters);
        this.add(scrollPane);
        this.addApplyButton();
    }
    
    public void addApplyButton(){
    	JButton apply = new JButton("Apply");
        apply.addActionListener(new ActionListener(){

        	//TODO test si parameters null
        	//TODO test pour type parameters
        	//TODO envoie fonctions dans Instructions
			@Override
			public void actionPerformed(ActionEvent event) {
				String parameters = Command.this.parameters.getText().toLowerCase();
				String val = (String)Command.this.actions.getSelectedItem();
				switch (val){
					case "GO": Command.this.turtle.go(Integer.parseInt(parameters)); break;
					case "TURN": Command.this.turtle.turn(Integer.parseInt(parameters)); break;
					case "DRAW": Command.this.turtle.draw(); break;
					case "COLOR": Command.this.turtle.color(Color.getColor(parameters)); break;
					default: break;
				}
				
			}
        	
        });
        this.add(apply);
    }
}
