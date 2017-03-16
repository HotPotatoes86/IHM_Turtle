package turtle.ihm;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import turtle.model.Turtle;

public class EastBox extends Box {
	
	//----------------------Attributes----------------------//
	private static final long serialVersionUID = -124758012473642027L;
	
	private PatternPanel my_patterns;
    private PatternPanel my_current_pattern;
    private JPanel my_current_color;
        
    private JButton init;
    private JButton undo;
    private JButton replay;
    private JButton quit;
    
    private Turtle turtle;
    private Grid grid;
        
  //----------------------Constructors----------------------//
    public EastBox(Turtle t, Grid g) {
        super(BoxLayout.PAGE_AXIS);
        
        this.turtle = t;
        this.grid = g;
        this.my_patterns = new PatternPanel(t);
        this.my_current_pattern = new PatternPanel(t,true);
        this.my_current_color = new JPanel();
        this.my_current_color.setBackground(t.getColor());
        this.my_current_color.setOpaque(true);
        
        Box current_info_content = Box.createHorizontalBox();
        current_info_content.add(this.my_current_pattern);
        current_info_content.add(this.my_current_color);
        
        this.add(my_patterns);
        this.add(current_info_content);
        this.initButtons();
   }
    
  //----------------------Methods----------------------//
    public JPanel getActualColor(){
    	return this.my_current_color;
    }
   
    public PatternPanel getActualPanel(){
    	return this.my_current_pattern;
    }
    
    /**
     * initialize the buttons of the box
     */
    public void initButtons(){
    	 this.init = new JButton("Init");
    	 this.init.addActionListener(new ActionListener() {
        	 @Override
        	 public void actionPerformed(ActionEvent event) {
        		 EastBox.this.turtle.init();
        	 }
         });
         this.undo = new JButton("Undo");
         this.undo.addActionListener(new ActionListener() {
        	 @Override
        	 public void actionPerformed(ActionEvent event) {
        		 EastBox.this.turtle.undo(grid, EastBox.this.my_current_pattern);
 				 History.deleteLastLine();
        	 }
         });
         this.replay = new JButton("Replay");
         this.quit = new JButton("Quit");
         this.quit.addActionListener(new ActionListener(){
 			@Override
 			public void actionPerformed(ActionEvent event) {
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
