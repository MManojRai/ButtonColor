package FrameExample;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class ButtonTest {
	public static void main(String[] args) {
		ButtonFrame frame=new ButtonFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.show();
	}
}
class ButtonFrame extends JFrame{
	public ButtonFrame() {
		setTitle("ButtonTest");
		setSize(WIDTH, HEIGHT);
		
		//add panel to frame
		
		ButtonPanel panel=new ButtonPanel();
		Container contentPane=getContentPane();
		contentPane.add(panel);
		
	}
	public static final int WIDTH=300;
	public static final int HEIGHT=200;
}
//a panel with three buttons
class ButtonPanel extends JPanel{
	public ButtonPanel() {
		//create buttons
		JButton yellowButton =new JButton("Yellow");
		JButton blueButton =new JButton("Blue");
		JButton redButton =new JButton("Red");
		
		//add button to panel
		add(yellowButton);
		add(blueButton);
		add(redButton);
		
		//create button action
		ColorAction yellowAction=new ColorAction(Color.yellow);
		ColorAction blueAction=new ColorAction(Color.blue);
		ColorAction redAction=new ColorAction(Color.red);
		//associate action with buttons
		
		yellowButton.addActionListener(yellowAction);
		blueButton.addActionListener(blueAction);
		redButton.addActionListener(redAction);
	}
	//an action listener that sets the panel's background color
	private class ColorAction implements ActionListener{
		public ColorAction(Color c) {
			backgroundColor=c;
		}
		public void actionPerformed(ActionEvent event) {
			setBackground(backgroundColor);
			repaint();
		}
		private Color backgroundColor;
	}
}
