package turtle.ihm;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class MainWindow extends JFrame{
	
	private static final long serialVersionUID = -1798652854312032173L;

	//----------------------Constructors----------------------//
	public MainWindow(){
    	super("Choose the Window Version");
    	
    	//initialization of all the variables we need
    	JRadioButton beginnerButton = new JRadioButton("Beginner");
        JRadioButton expertButton = new JRadioButton("Expert");

        ButtonGroup group = new ButtonGroup();
        group.add(beginnerButton);
        group.add(expertButton);
        beginnerButton.setSelected(true);
        
        //select the interface
        JPanel radioPanel = new JPanel(new GridLayout(1, 0));
        radioPanel.add(beginnerButton);
        radioPanel.add(expertButton);
        
        //select the size
        Box box = Box.createVerticalBox();
        JLabel label = new JLabel("Size :");
        JTextArea size = new JTextArea(3,12);
        size.setText("20");
        JScrollPane my_scroll = new JScrollPane(size);
        box.add(label);
        box.add(my_scroll);
        
        //OK button
        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event) {
				try {
					int val = Integer.parseInt(size.getText());
					//10 <= size <= 40
					if (val>=10 && val<=40) {
						//beginner version
						if(beginnerButton.isSelected()){
							MainWindow.this.dispose();
							BeginnerWindow bw = new BeginnerWindow(val);
							bw.pack();
							bw.setVisible(true);
							bw.setMinimumSize(bw.getSize()); //we set a minimum size to the window
						//expert version
						}else if(expertButton.isSelected()){
							MainWindow.this.dispose();
							ExpertWindow ew = new ExpertWindow(val);
							ew.pack();
							ew.setVisible(true);
							ew.setMinimumSize(ew.getSize()); //we set a minimum size to the window
						}
					}else {
						//error with the size
						JOptionPane.showMessageDialog(MainWindow.this,
							    "Write a size between 10 and 40.",
							    "Error",
							    JOptionPane.ERROR_MESSAGE);
					}
				}catch (Exception e) {
					//error with the size
					JOptionPane.showMessageDialog(MainWindow.this,
						    "Write a size between 10 and 40.",
						    "Error",
						    JOptionPane.ERROR_MESSAGE);
				}
			}
        });
        
        //add the elements to the frame
        this.add(radioPanel,BorderLayout.WEST);
        this.add(box);
        this.add(okButton,BorderLayout.SOUTH);
        
    }
    
	//----------------------Methods----------------------//
	/**
	 * create the frame
	 */
    public static void makeIt(){
    	MainWindow window = new MainWindow();
    	window.pack();
    	window.setLocationRelativeTo(null);
    	window.setVisible(true);
	}

    /**
     * launch the method makeIt
     * @param args here there are no arguments
     */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run() {
				makeIt();
			}
		});
	}
}
