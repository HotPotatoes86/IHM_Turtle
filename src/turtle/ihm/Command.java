package turtle.ihm;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import turtle.model.Turtle;

public class Command extends JPanel {
	
	//----------------------Attributes----------------------//
	private static final long serialVersionUID = -2228297003945477936L;
	private JComboBox<String> actions;
    private JTextArea parameters;
    private Turtle turtle;
    private PatternPanel pattern_pan;
    private JPanel colorPanel;
    private Grid grid;
    
  //----------------------Constructors----------------------//
    /**
     * read and launch the commands
     */
    public Command(Turtle turtle, Grid g, PatternPanel pan, JPanel pan2){
        super(new FlowLayout());
        this.grid = g;
        this.colorPanel = pan2;
        this.pattern_pan = pan;
        this.turtle = turtle;
        String[] commands = new String[]{"GO","TURN","DRAW","COLOR"};
        
        this.actions = new JComboBox<>(commands);
        this.add(actions);
        this.parameters = new JTextArea(1, 5);
        JScrollPane scrollPane = new JScrollPane(this.parameters);
        this.add(scrollPane);
        this.addApplyButton();
    }
    
  //----------------------Methods----------------------//
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
				//string not null or empty
				if (parameters != null && !parameters.isEmpty()){
					switch (val){
						case "GO": Command.this.turtle.go(Integer.parseInt(parameters)); break;
						case "TURN": Command.this.turtle.turn(Integer.parseInt(parameters)); 
									Command.this.pattern_pan.repaint();
									break;
						case "DRAW": Command.this.turtle.draw(); break;
						case "COLOR": Command.this.turtle.color(Color.getColor(parameters)); 
									Command.this.colorPanel.setBackground(Color.getColor(parameters));
									Command.this.colorPanel.setOpaque(true);
									break;
						default: break;
					}
				}else{
					switch (val){
						case "GO": Command.this.turtle.go(); break;
						case "TURN": Command.this.turtle.turn(); 
									Command.this.pattern_pan.repaint();
									break;
						case "DRAW": Command.this.turtle.draw(); break;
						case "COLOR": break;
						default: break;
					}
				}
				Command.this.grid.repaint();
				History.addText(val + "(" + parameters +")");
			}
        	
        });
        this.add(apply);
    }
}
