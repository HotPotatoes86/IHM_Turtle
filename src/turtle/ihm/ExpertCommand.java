package turtle.ihm;

import java.awt.BorderLayout;
import static java.awt.SystemColor.info;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import turtle.model.CommandColor;
import turtle.model.CommandDraw;
import turtle.model.CommandGo;
import turtle.model.CommandTurn;

import turtle.model.Turtle;

public class ExpertCommand extends JPanel{

	private static final long serialVersionUID = -2697483271813355451L;

	private TextArea text;
	private JButton applyButton;
	private Turtle turtle;
        private String parameters;
        private JComboBox<String> actions;
        private PatternPanel pattern_pan;
        private ColorPanel colorPanel;
        private Grid grid;
	
	public ExpertCommand(Turtle t, Grid g, PatternPanel pan, ColorPanel pan2) {
		super(new BorderLayout());
		this.text = new TextArea(20,20);
		this.turtle = t;
                this.grid = g;
                this.pattern_pan = pan;
                this.colorPanel = pan2;
                this.add(this.text);
		this.initButton();
	}
        
        public ArrayList createCommandList(String big_string){
            String tmp_word = "";
            ArrayList<String> cmd_list = new ArrayList<String>();
            
            for(int i=0;i<big_string.length();i++){
                if(big_string.charAt(i) != '\n'){
                    tmp_word = tmp_word + big_string.charAt(i);
                    if(big_string.charAt(i)== ')'){
                        //System.out.println(tmp_word);
                        cmd_list.add(tmp_word);
                        tmp_word = "";
                    }
                }
            }
            return cmd_list;
        }
	
        public void executeCommandList(ArrayList<String> cmd_list){
            for(String a_command : cmd_list){
                    switch(a_command.toUpperCase()){
                        case "GO()" :                                  
                                CommandGo.use(turtle, a_command.substring(3, a_command.length()-1));
                                ExpertCommand.this.grid.repaint();
                                break;

                        case "TURN()" :
                                CommandTurn.use(turtle, a_command.substring(5, a_command.length()-1));
                                ExpertCommand.this.pattern_pan.repaint();
                                break;

                        case "DRAW()" : 
                                CommandDraw.use(turtle);
                                break;

                        case "COLOR()" : CommandColor.use(turtle, a_command.substring(6, a_command.length()-1));
                                ExpertCommand.this.colorPanel.setBackground(turtle.getColor());
                                break;
                        
                        default : System.out.println("La commande saisie est incorrecte");
                                break;
                    }        
                }
            }
                
        
	/**
	 * initialize the apply button
	 */
	public void initButton(){
		this.applyButton = new JButton("Apply");
		this.applyButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
                            String text_to_do = ExpertCommand.this.text.getText();
                            ArrayList<String> command_list = ExpertCommand.this.createCommandList(text_to_do);
                            ExpertCommand.this.executeCommandList(command_list);
			}
		});
		this.add(this.text);
		this.add(this.applyButton, BorderLayout.SOUTH);
	}
}
