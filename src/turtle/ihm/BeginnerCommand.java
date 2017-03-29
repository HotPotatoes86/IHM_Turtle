package turtle.ihm;

import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import turtle.model.CommandColor;
import turtle.model.CommandDraw;
import turtle.model.CommandGo;
import turtle.model.CommandTurn;
import turtle.model.Turtle;

public class BeginnerCommand extends JPanel {
	
	//----------------------Attributes----------------------//
	private static final long serialVersionUID = -2228297003945477936L;
	private JComboBox<String> actions;
    private JTextArea parameters;
    private Turtle turtle;
    private PatternPanel pattern_pan;
    private ColorPanel colorPanel;
    private Grid grid;
    
  //----------------------Constructors----------------------//
    /**
     * read and launch the commands
     */
    public BeginnerCommand(Turtle turtle, Grid g, PatternPanel pan, ColorPanel pan2){
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
				String parameters = BeginnerCommand.this.parameters.getText().toLowerCase();
				String val = (String)BeginnerCommand.this.actions.getSelectedItem();
				Turtle t = BeginnerCommand.this.turtle;
				//string not null or empty
				if (parameters == null) parameters = "";
					switch (val){
						case "GO": CommandGo.use(t, parameters, BeginnerCommand.this.grid); break;
						case "TURN": CommandTurn.use(t, parameters, BeginnerCommand.this.pattern_pan); break;
						case "DRAW": CommandDraw.use(t); break;
						case "COLOR": CommandColor.use(t, parameters, BeginnerCommand.this.colorPanel); break;
						default: break;
					}
			}
        	
        });
        this.add(apply);
    }
}
