//Name: Sunyoung An
//Due Date: July 27
//Title: NBAPlayoff
//Description: A class that extends JFrame to showing an NBA Team on a Basketball court using Swing(Graphical User Interface (GUI)
//==============================================================================
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NBAPlayoff extends JFrame {

	// NBATeam field
	private NBATeam spurs;
	// NBAcourtPanel to draw things
	private NBAcourtPanel court;

	// JTextField to get a player name
	private JTextField txtName;
	// JTextField to get a player age
	private JTextField txtAge;
	// JLabels to display the static text info
	private JLabel lMax, lMin, lAvg, lNum;

	public NBAPlayoff() {
		
		// instantiate a NBATeam 
		spurs = new NBATeam("Spurs");
		// instantiate a NBAcourtPanel
		court = new NBAcourtPanel(spurs);
		add(court, BorderLayout.CENTER);

		// static text labels for the right panel
		JLabel lMax0 = new JLabel("Max Age:");
		lMax = new JLabel("");
		JLabel lMin0 = new JLabel("Min Age:");
		lMin = new JLabel("");
		JLabel lAvg0 = new JLabel("Average Age:");
		lAvg = new JLabel("");
		JLabel lNum0 = new JLabel("Number of Players:");
		lNum = new JLabel("");
		JPanel rp = new JPanel(new GridLayout(8, 1)); // right panel
		rp.add(lNum0);
		rp.add(lNum);
		rp.add(lMax0);
		rp.add(lMax);
		rp.add(lMin0);
		rp.add(lMin);
		rp.add(lAvg0);
		rp.add(lAvg);
		add(rp, BorderLayout.EAST);
		
		// text label to get user input for the player name 
		JLabel l1 = new JLabel("Player Name:");
		// actual text field where user can type the name
		txtName = new JTextField();
		// set the size for the text field for the player name
		txtName.setPreferredSize(new Dimension(120, 24));
		// text label to get user input for the player age
		JLabel l2 = new JLabel("Player Age:");
		// actual text field where user can type the age
		txtAge = new JTextField();
		// set the size for the text field for the player age
		txtAge.setPreferredSize(new Dimension(120, 24));
		
		// a clickable button to add a player
		JButton jbtAdd = new JButton("Add A Player");
		// wait for a user action
		jbtAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// age should be parsed as an integer value
				int age = Integer.parseInt(txtAge.getText());
				// add a player using the name and age that user wrote in the text fields
				spurs.addAPlayer(txtName.getText(), age);
				// get the updated statistics from the NBATeam instance
				lMax.setText(spurs.getMaxAge() + "");
				lMin.setText(spurs.getMinAge() + "");
				lAvg.setText(spurs.getAvgAge() + "");
				lNum.setText(spurs.getNumOfPlayer() + "");
				// render the updated info
				court.repaint();
			}
		});
		
		// a button to clear the typed text in the text fields (Player Name and Player Age)  
		JButton jbtClear = new JButton("Clear");
		jbtClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtName.setText("");
				txtAge.setText("");
			}
		});
		
		// add labels, input fields, and buttons to the bottom panel 
		JPanel pBot = new JPanel();
		pBot.add(l1);
		pBot.add(txtName);
		pBot.add(l2);
		pBot.add(txtAge);
		pBot.add(jbtAdd);
		pBot.add(jbtClear);
		add(pBot, BorderLayout.SOUTH);

	}

	public static void main(String[] args) {
		
		// instantiate the frame
		NBAPlayoff frame = new NBAPlayoff();
		// if user close the window, exit the program
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// set the default location as the center of the screen
		frame.setLocationRelativeTo(null);
		// set the default size
		frame.setSize(800, 400);
		// shows the window
		frame.setVisible(true);
	}
}
