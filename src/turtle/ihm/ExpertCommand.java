package turtle.ihm;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import turtle.model.CommandColor;
import turtle.model.CommandDraw;
import turtle.model.CommandGo;
import turtle.model.CommandInit;
import turtle.model.CommandTurn;

import turtle.model.Turtle;

public class ExpertCommand extends JPanel{

	//----------------------Attributes----------------------//
	private static final long serialVersionUID = -2697483271813355451L;

	private History text;
	private JButton applyButton;
	private Turtle turtle;
    private PatternPanel pattern_pan;
    private ColorPanel colorPanel;
    private Grid grid;
	
  //----------------------Constructors----------------------//
	public ExpertCommand(Turtle t, Grid g, PatternPanel pan, ColorPanel pan2) {
		super(new BorderLayout());
		this.text = new History(true);
		this.turtle = t;
        this.grid = g;
        this.pattern_pan = pan;
        this.colorPanel = pan2;
        this.add(this.text);
		this.initButton();
	}
        
	//----------------------Methods----------------------//
        public ArrayList<String []> createCommandList(String big_string){
            //the list contains a table which contains the command name and the parameter
            ArrayList<String []> cmd_list = new ArrayList<>();
            String tmp_word = "";
            String[] res = new String[2];
            boolean parameters = false;
            for(int i=0;i<big_string.length();i++){
            	if (big_string.charAt(i)=='\n') {
            		//ignore it
            	}else if (parameters && big_string.charAt(i)== ')') {
            		res[1]=tmp_word;
            		cmd_list.add(res);
            		parameters=false;
            		tmp_word="";
            		res = new String[2];
            	}else if (big_string.charAt(i)== '(') {
            		res[0]=tmp_word;
            		tmp_word="";
            		parameters=true;
            	}else {
            		tmp_word += big_string.charAt(i);
            	}
            }
            return cmd_list;
        }
	
        public void executeCommandList(ArrayList<String []> cmd_list){
        	boolean error = false;
            for(String[] a_command : cmd_list){
                    switch (a_command[0].toUpperCase()){
						case "GO": if (CommandGo.use(turtle, a_command[1])) {
										ExpertCommand.this.grid.repaint();
									}else {
										//the parameter is incorrect -> error message
										ExpertCommand.this.errorMessage();
									}
									break;
						case "TURN": if (CommandTurn.use(turtle, a_command[1])) {
										ExpertCommand.this.pattern_pan.repaint();
									}else {
										//the parameter is incorrect -> error message
										ExpertCommand.this.errorMessage();
									}
									break;
						case "DRAW": CommandDraw.use(turtle); 
									break;
						case "COLOR": if (CommandColor.use(turtle, a_command[1])) {
										ExpertCommand.this.colorPanel.setBackground(turtle.getColor());
									}else {
										//the parameter is incorrect -> error message
										ExpertCommand.this.errorMessage();
									}
									break;
						default: error = true;
								this.init();
								this.errorMessage(); //if the parameter isn't correct, we decide to display an error message
								break;
					}
                    if (error) break;
                }
         }
        
        
        /**
         * use the command init and actualize the elements of the application
         */
        public void init() {
        	CommandInit.use(this.turtle);
        	//actualize the application
        	this.grid.repaint();
        	this.pattern_pan.repaint();
        	this.colorPanel.setBackground(turtle.getColor());
        }
                
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
	 * initialize the apply button
	 */
	public void initButton(){
		this.applyButton = new JButton("Apply");
		this.applyButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
							ExpertCommand.this.init();
                            String text_to_do = History.getText();
                            ArrayList<String []> command_list = ExpertCommand.this.createCommandList(text_to_do);
                            ExpertCommand.this.executeCommandList(command_list);
			}
		});
		this.add(this.text);
		this.add(this.applyButton, BorderLayout.SOUTH);
	}
}
