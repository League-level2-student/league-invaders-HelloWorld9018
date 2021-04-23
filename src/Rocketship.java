import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Rocketship extends GameObject{
	
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;
	
	Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		speed = 10;
		
		if (needImage) {
		    loadImage ("rocket.png");
		}
		
	}
	
	void draw(Graphics g) {

		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		}

	}

	void up() {
		y-=speed;
		//same thing as x = x + speed;
	}
	
	void down() {
		y+=speed;
	}
	
	void left() {
		x-=speed;
	}
	
	void right() {
		x+=speed;
	}
	
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            //e.printStackTrace();
	            System.out.println("There is an error in loading the rocket image");
	        }
	        needImage = false;
	    }
	}

	
}
