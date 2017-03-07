package turtle.ihm;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import turtle.model.Turtle;

public class Info extends Box {
	
        private JPanel my_motives;
        private JPanel my_current_motive;
        private JPanel my_current_color;
        
        private JButton init;
        private JButton undo;
        private JButton replay;
        private JButton quit;
        
    public Info(Turtle t) {
        super(BoxLayout.PAGE_AXIS);
        
        my_motives = new JPanel();
        my_current_motive = new JPanel();
        my_current_color = new JPanel();
        
        Box current_info_content = Box.createHorizontalBox();
        current_info_content.add(my_current_motive);
        current_info_content.add(my_current_color);
        
        init = new JButton("Init");
        undo = new JButton("Undo");
        replay = new JButton("Replay");
        quit = new JButton("Quit");
        quit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
        });
        
        JPanel panel_button = new JPanel();
        panel_button.setLayout(new GridLayout(2,2));
        
        panel_button.add(init);
        panel_button.add(undo);
        panel_button.add(replay);
        panel_button.add(quit);
        
        this.add(my_motives);
        this.add(current_info_content);
        this.add(panel_button);
    }
    
}
