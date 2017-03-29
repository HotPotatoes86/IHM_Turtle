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
        
        public boolean doCommand(String str){
            String[] commands = {"GO","DRAW","TURN","COLOR"};
            String my_command = "";
            Character my_letter;
            int memory_pos = 0;
            boolean cmd_ok = false;
            
            for(int i = 0;i<str.length();i++){
                my_letter = str.charAt(i);
                my_command = my_command + my_letter;
                System.out.println(my_command);
                if(my_letter == '('){

                    memory_pos = i+1;
                    cmd_ok = true;
                    break;
                }
            }
            if(cmd_ok == true){
                switch(my_command.toUpperCase()){
                    case "GO(" :                                    
                            CommandGo.use(turtle, str.substring(memory_pos, str.length()-1));
                            ExpertCommand.this.grid.repaint();
                            System.out.println("J'avance");
                            break;
                            
                    case "TURN(" :
                            CommandTurn.use(turtle, str.substring(memory_pos, str.length()-1));
                            ExpertCommand.this.pattern_pan.repaint();
                            System.out.println("Je tourne");
                            break;
                             
                    case "DRAW(" : 
                            CommandDraw.use(turtle);
                            System.out.println("Je dessine");
                    break;
                    
                    case "COLOR(" : CommandColor.use(turtle, str.substring(memory_pos, str.length()-1));
                            ExpertCommand.this.colorPanel.setBackground(turtle.getColor());
                            System.out.println("Je change de couleur");
                    break;
                    default : ;
                    break;
                }    
                return true;
            }else{
                return false;
            }
        }
        
        public ArrayList createListCommand(String big_string){
            
        }
	
	/**
	 * initialize the apply button
	 */
	public void initButton() {
		this.applyButton = new JButton("Apply");
		this.applyButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
                            String text_to_do = ExpertCommand.this.text.getText();
                            ExpertCommand.this.doCommand(text_to_do);
			}
		});
		this.add(this.text);
		this.add(this.applyButton, BorderLayout.SOUTH);
	}
}
