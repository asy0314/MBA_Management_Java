//Name: Sunyoung An
//Due Date: July 27, 2021
//Title: NBAcourtPanel
//Description: A class that extends Jpanel. It is a class file, and the main method is in the file 'NBAPlayoff.java'.
//==============================================================================
import java.awt.*;
import javax.swing.*;

public class NBAcourtPanel extends JPanel {
	
	// NBATeam instance to be displayed
	private NBATeam team;
	
	// constructor with an input of NBATeam instance
	public NBAcourtPanel(NBATeam team) {
		this.team = team;
	}
	
	// overriding paintComponent to to tell the panel how to draw things
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		// Basketball Court
		// fill the entire panel using gold color to represent the floor
		g.setColor(new Color(255, 215, 0));
		g.fillRect(0, 0, getWidth(), getHeight());
		
		// Center Circle
		// set the radius of the center circle as about 1/8 of the panel width
		int centerCircleR = getWidth() / 8;
		// oval starting point should be the exact center point of the panel minus the radius of the circle for both x and y
		// and the width and height are 2 times of the radius
		int centerCircleX = getWidth() / 2 - centerCircleR;
		int centerCircleY = getHeight() / 2 - centerCircleR;
		// fill oval using red color to represent the center circle
		g.setColor(Color.RED);
		// g.fillOval(x, y, width, height)
		g.fillOval(centerCircleX, centerCircleY, 2*centerCircleR, 2*centerCircleR);

		// We will use white color for drawing lines of the court
		g.setColor(Color.WHITE);
		
		// 3-point boundary lines
		// set the long radius and short radius for the three-point boundary
		int longR = getWidth() / 4;  // long radius (X axis)
		int shortR = getHeight() / 3;  // short radius (Y axis)
		// draw oval for the three-point boundary on the left-side court
		// g.drawOval(x, y, width, height)
		g.drawOval(-longR, getHeight() / 2 - shortR, 2*longR, 2*shortR);
		// draw oval for the three-point boundary on the left-side court
		g.drawOval(getWidth() - longR, getHeight() / 2 - shortR, 2*longR, 2*shortR);
		
		// Half-line
		// g.drawLine(x1, y1, x2, y2)
		g.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight());

		// Player Names
		// use bold font and black color for the player names
		g.setFont(new Font("default", Font.BOLD, 20));
		g.setColor(Color.black);
		
		// x and y coordinate for the player names
		int playerNameX = getWidth() * 3 / 4;
		int playerNameY = getHeight() / 4;

		// For-each loop for all players name
		for (String name : team.getNames()) {
			// draw String of the name
			g.drawString(name, playerNameX, playerNameY);
			// increase y coordinate for the next player name
			playerNameY += 30;
		}
	}
}
