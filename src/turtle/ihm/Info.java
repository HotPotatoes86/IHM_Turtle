package turtle.ihm;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import turtle.model.Turtle;

public class Info extends Box {
	
	private static final long serialVersionUID = -124758012473642027L;
	
	private JPanel my_motives;
    private JPanel my_current_motive;
    private JPanel my_current_color;
        
    private JButton init;
    private JButton undo;
    private JButton replay;
    private JButton quit;
        
    //TODO séparer panel pour dessiner dedans ?
    public Info(Turtle t) {
        super(BoxLayout.PAGE_AXIS);
        
        this.my_motives = new JPanel();
        this.my_current_motive = new JPanel();
        this.my_current_color = new JPanel();
        
        Box current_info_content = Box.createHorizontalBox();
        current_info_content.add(this.my_current_motive);
        current_info_content.add(this.my_current_color);
        
        this.add(my_motives);
        this.add(current_info_content);
        this.initButtons();
   }
   
    /**
     * initialize the buttons of the box
     */
    public void initButtons(){
    	 this.init = new JButton("Init");
         this.undo = new JButton("Undo");
         this.replay = new JButton("Replay");
         this.quit = new JButton("Quit");
         this.quit.addActionListener(new ActionListener(){
 			@Override
 			public void actionPerformed(ActionEvent arg0) {
 				System.exit(0);
 			}
         });
         JPanel panel_button = new JPanel();
         panel_button.setLayout(new GridLayout(2,2));
         panel_button.add(this.init);
         panel_button.add(this.undo);
         panel_button.add(this.replay);
         panel_button.add(this.quit);
         this.add(panel_button);
    }
    
    
    
}
