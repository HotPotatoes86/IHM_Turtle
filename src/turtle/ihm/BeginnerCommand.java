package turtle.ihm;

import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
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
    /**
     * display an error message
     */
    public void errorMessage() {
    	JOptionPane.showMessageDialog(this,
			    "Incorrect parameters.",
			    "Error",
			    JOptionPane.ERROR_MESSAGE);
    }
    
    /**
     * the apply button needs to recognize the command and launch the command
     * we did the repaint here to not make the module 'model' dependent on the graphic interface
     */
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
				//the commands with parameters return a boolean (false if the parameter isn't correct)
					switch (val){
						case "GO": if (CommandGo.use(t, parameters)) {
										History.addText("go(" + parameters + ")");
										BeginnerCommand.this.grid.repaint();
									}else {
										//the parameter is incorrect -> error message
										BeginnerCommand.this.errorMessage();
									}
									break;
						case "TURN": if (CommandTurn.use(t, parameters)) {
										History.addText("turn(" + parameters + ")");
										BeginnerCommand.this.pattern_pan.repaint();
									}else {
										//the parameter is incorrect -> error message
										BeginnerCommand.this.errorMessage();
									}
									break;
						case "DRAW": CommandDraw.use(t); 
									History.addText("draw()");	
									break;
						case "COLOR": if (CommandColor.use(t, parameters)) {
										History.addText("color(" + parameters + ")");
										BeginnerCommand.this.colorPanel.setBackground(t.getColor());
									}else {
										//the parameter is incorrect -> error message
										BeginnerCommand.this.errorMessage();
									}
									break;
						default: break;
					}
			}
        	
        });
        this.add(apply);
    }
}
