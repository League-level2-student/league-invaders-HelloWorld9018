import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{

	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	
	int currentState = MENU;
	
	Font titleFont;
	Font middleFont;
	Font endFont;
	
	Timer frameDraw;
	
	GamePanel(){
		titleFont = new Font("Serif", Font.BOLD, 45);
		middleFont = new Font("Serif", Font.PLAIN, 20);
		endFont = new Font("Serif", Font.ROMAN_BASELINE, 20);
		
		frameDraw = new Timer(1000/60, this);
		frameDraw.start();
	}
	
	void updateMenuState(){
		
	}
	
	void updateGameState(){
		
	}
	
	void updateEndState(){
	
	}	
	
	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("LEAGUE INVADERS", 20, 120);
		g.setFont(middleFont);
		g.drawString("Press ENTER to start", 150, 350);
		g.setFont(endFont);
		g.drawString("Press SPACE for instructions", 115, 450);
		
		
	}

	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
	}
	
	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("GAME OVER", 95, 120);
		g.setFont(middleFont);
		g.drawString("You killed enemies", 160, 350);
		g.setFont(endFont);
		g.drawString("Press ENTER to restart", 140, 450);
	}

	@Override
	public void paintComponent(Graphics g){
		
		if(currentState == MENU){
		    drawMenuState(g);
		}
		else if(currentState == GAME){
		    drawGameState(g);
		}
		else if(currentState == END){
		    drawEndState(g);
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(currentState == MENU){
		    updateMenuState();
		}
		else if(currentState == GAME){
		    updateGameState();
		}
		else if(currentState == END){
		    updateEndState();
		}
		
		System.out.println("action");
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
		    if (currentState == END) {
		        currentState = MENU;
		    } 
		    else {
		        currentState++;
		    }
		} 
		if(currentState == GAME) {
		if (e.getKeyCode()==KeyEvent.VK_UP) {
		    System.out.println("UP");
		}
		else if (e.getKeyCode()==KeyEvent.VK_DOWN) {
			System.out.println("DOWN");
		}
		else if (e.getKeyCode()==KeyEvent.VK_LEFT) {
			System.out.println("LEFT");
		}
		else if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
			System.out.println("RIGHT");
		}
		
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
