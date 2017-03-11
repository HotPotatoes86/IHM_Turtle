package turtle.ihm;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

import turtle.model.Turtle;

public class MainWindow extends JFrame{
	
	private static final long serialVersionUID = -1798652854312032173L;

	public MainWindow(){
    	super("Choisir la version de fenêtrage");
    	
    	Turtle turtle = new Turtle();
    	
    	JRadioButton beginnerButton = new JRadioButton("Beginner");
        JRadioButton expertButton = new JRadioButton("Expert");

        ButtonGroup group = new ButtonGroup();
        group.add(beginnerButton);
        group.add(expertButton);
        
        JPanel radioPanel = new JPanel(new GridLayout(1, 0));
        radioPanel.add(beginnerButton);
        radioPanel.add(expertButton);

        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event) {
				if(beginnerButton.isSelected()){
					MainWindow.this.dispose();
					BeginnerWindow bw = new BeginnerWindow(turtle);
					bw.pack();
					bw.setVisible(true);
				}else if(expertButton.isSelected()){
					MainWindow.this.dispose();
					ExpertWindow ew = new ExpertWindow(turtle);
					ew.pack();
					ew.setVisible(true);
				}
			}
        });
        this.add(radioPanel);
        this.add(okButton,BorderLayout.SOUTH);
        
    }
    
    public static void makeIt(){
    	MainWindow window = new MainWindow();
    	window.pack();
    	window.setLocationRelativeTo(null);
    	/*window.setMinimumSize(new Dimension(500,400));
    	window.setPreferredSize(new Dimension(500,400));*/
    	window.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run() {
				makeIt();
			}
		});
	}
}
