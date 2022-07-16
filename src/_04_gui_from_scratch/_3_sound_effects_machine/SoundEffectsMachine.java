package _04_gui_from_scratch._3_sound_effects_machine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SoundEffectsMachine implements ActionListener {

	JButton button1 = new JButton();
    JButton button2 = new JButton();
    JButton button3 = new JButton();
    JButton button4 = new JButton();
	
	public void showButton() {
		
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        frame.pack();
        button1.setText("Sawing Wood");
        button2.setText("Sheep");
        button3.setText("Car");
        button4.setText("Bell");
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton buttonPressed = (JButton) e.getSource();
		if (buttonPressed == button1) {
			playSound("sawing-wood-daniel_simon.wav");
		}
		if (buttonPressed == button2) {
			playSound("Sheep.wav");
		}
		if (buttonPressed == button3) {
			playSound("Car.wav");
		}
		if (buttonPressed == button4) {
			playSound("Bell.wav");
		}
		
	}
	
	private void playSound(String soundFile) {
		String path = "src/_04_gui_from_scratch/_3_sound_effects_machine/";
			File sound = new File(path+soundFile);
			if (sound.exists()) {
				new Thread(() -> {
				try {
					Clip clip = AudioSystem.getClip();
					clip.open(AudioSystem.getAudioInputStream(sound));
					clip.start();
					Thread.sleep(clip.getMicrosecondLength()/1000);
				}
				catch (Exception e) {
					System.out.println("Could not play this sound");
				}}).start();
	 		}
			else {
				System.out.println("File does not exist");
			}
		
	}
	
}
