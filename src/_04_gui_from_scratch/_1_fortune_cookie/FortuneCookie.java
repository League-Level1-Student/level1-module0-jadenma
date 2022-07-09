package _04_gui_from_scratch._1_fortune_cookie;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FortuneCookie implements ActionListener {
	
	public void showButton() {
		
		int ran = new Random().nextInt(5);
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton button = new JButton();
        frame.add(button);
        frame.pack();
        button.addActionListener(this);
        if (ran == 0) {
        	JOptionPane.showMessageDialog(null, "The end is near, and it's all your fault.");
        }
        if (ran == 1) {
        	JOptionPane.showMessageDialog(null, "You will be hungry again in one hour.");
        }
        if (ran == 2) {
        	JOptionPane.showMessageDialog(null, "You will live a long, happy life.");
        }
        if (ran == 3) {
        	JOptionPane.showMessageDialog(null, "The best is yet to come.");
        }
        if (ran == 4) {
        	JOptionPane.showMessageDialog(null, "I cannot help you, as I am just a cookie.");
        }
        
   }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "Woohoo!");
		
	}
	
}
