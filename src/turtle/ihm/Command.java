package turtle.ihm;

import java.awt.Color;
import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

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
        this.parameters = new JTextArea(3, 10);
        JScrollPane scrollPane = new JScrollPane(this.parameters);
        this.add(scrollPane);
        this.addApplyButton();
    }
    
  //----------------------Methods----------------------//
    public void addApplyButton(){
    	JButton apply = new JButton("Apply");
        apply.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event) {
				String parameters = Command.this.parameters.getText().toLowerCase();
				String val = (String)Command.this.actions.getSelectedItem();
				//string not null or empty
				if (parameters != null && !parameters.isEmpty()){
					int value;
					switch (val){
						case "GO": try {
										//if the value is a integer
										value = Integer.parseInt(parameters);
										Command.this.turtle.go(value);
									} catch (Exception e) {
										//if the value isn't a integer, we ignore it
										parameters = "";
										Command.this.turtle.go();
									}
									Command.this.grid.repaint();
									break;
						case "TURN": try {
										//if the value is a integer
										value = Integer.parseInt(parameters);
										Command.this.turtle.turn(value); 
									} catch (Exception e) {
										//if the value isn't a integer, we ignore it
										parameters = "";
										Command.this.turtle.turn(); 
									}
								Command.this.pattern_pan.repaint();
								break;
						case "DRAW": Command.this.turtle.draw(); break;
						case "COLOR": Color color;
									try {
									    Field field = Class.forName("java.awt.Color").getField(parameters);
									    color = (Color)field.get(null);
									    Command.this.turtle.color(color); 
										Command.this.colorPanel.setBackground(color);
									} catch (Exception e) {
									    color = null;
									}
									break;
						default: break;
					}
				}else{
					switch (val){
						case "GO": Command.this.turtle.go(); 
								Command.this.grid.repaint();
								break;
						case "TURN": Command.this.turtle.turn(); 
									Command.this.pattern_pan.repaint();
									break;
						case "DRAW": Command.this.turtle.draw(); break;
						case "COLOR": break;
						default: break;
					}
				}
			}
        	
        });
        this.add(apply);
    }
}
