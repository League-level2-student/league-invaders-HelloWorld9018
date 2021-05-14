import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{

	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	
	int currentState = MENU;
	
	Font titleFont;
	Font middleFont;
	Font endFont;
	Font scoreFont;
	
	Timer frameDraw;
	Timer alienSpawn;
	
	Rocketship rocket = new Rocketship(250, 700, 50, 50);
	
//	boolean inBounds;
	
	ObjectManager manager = new ObjectManager(rocket);
	
	
	
	GamePanel(){
		titleFont = new Font("Serif", Font.BOLD, 45);
		middleFont = new Font("Serif", Font.PLAIN, 20);
		endFont = new Font("Serif", Font.ROMAN_BASELINE, 20);
		scoreFont = new Font("Calibri", Font.BOLD, 20);
		
		frameDraw = new Timer(1000/60, this);
		frameDraw.start();
		
		if (needImage) {
		    loadImage ("space.png");
		}
		
	}
	
	void updateMenuState(){
		
	}
	
	void updateGameState(){
		manager.update();
		
		
		//JTextPane text = new JTextPane();
		//frame.add(text);
		
		
		if(rocket.isActive == false) {
			currentState = END;
		}
	
		
	}
	
	void updateEndState(){
	
	}	
	
	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("LEAGUE INVADERS", 19+18, 120);
		g.setFont(middleFont);
		g.drawString("Press ENTER to start", 150+18, 350);
		g.setFont(endFont);
		g.drawString("Press SPACE for instructions", 115+18, 450);
		
		
	}

	void drawGameState(Graphics g) {

		if (gotImage) {
			g.drawImage(image, 0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT, null);
		} else {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		}
		manager.draw(g);
		
		int score = manager.getScore();
		g.setColor(Color.WHITE);
		g.setFont(scoreFont);
		g.drawString("Score: " + score , 10, 25);
	
	}
	
	void drawEndState(Graphics g) {
		int score = manager.getScore();
		
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("GAME OVER", 95+18, 120);
		g.setFont(middleFont);
		g.drawString("You killed " + score + " enemies", 160+18, 350);
		g.setFont(endFont);
		g.drawString("Press ENTER to restart", 140+18, 450);
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
		    	//step 5: replace the existing inactive rocketship with a new rocketship object
		    	rocket = new Rocketship(250, 700, 50, 50);
		    	//step 6
		    	manager = new ObjectManager(rocket);
		        currentState = MENU;
		    } 
		    
		    else if(currentState == MENU) {
		    	//reset game with reset method?  /*nvm*/
		    	startGame();
		    	currentState = GAME;
		    	
		    }
		    
		    else {
		        currentState++;
		    }
		} 
		
	
		
		if(currentState == GAME) {
			
			
		if (e.getKeyCode()==KeyEvent.VK_UP) {
		    System.out.println("UP");
		    if (rocket.y>=10) {
			   rocket.up(); 
		}
			}
		else if (e.getKeyCode()==KeyEvent.VK_DOWN) {
			System.out.println("DOWN");
			   if (rocket.y<=740) {
			rocket.down();
			   }
		}
		else if (e.getKeyCode()==KeyEvent.VK_LEFT) {
			System.out.println("LEFT");
			
			  if(rocket.x >= 10) {
			rocket.left();
			  }
		}
		else if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
			System.out.println("RIGHT");
		
			   if (rocket.x <= 440) {
			rocket.right();
			   }
		}
		
		if(e.getKeyCode()==KeyEvent.VK_SPACE) {
			manager.addProjectile(rocket.getProjectile());
		}
			
		}
		
		if (currentState == END) {
			alienSpawn.stop();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	public void startGame() {
		alienSpawn = new Timer(1000, manager);
		alienSpawn.start();
		
		//if(alienSpawn.equals()) {
			
	//	}
		
	}
	
	public void reset() {
		
	}
	
	
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            System.out.println("There is an error in loading the background image");
	        }
	        needImage = false;
	    }
	}
	
	//This is not needed, delete maybe
/*	void checkBounds() {
		if(rocket.x > 0 && rocket.x < 500 && rocket.y > 0 && rocket.y < 800) {
			inBounds = true;
		}
		else {
			inBounds = false;
		}
	}
	*/
}
