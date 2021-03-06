import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener{
	Rocketship rocket;
	ArrayList<Projectile> missiles = new ArrayList<Projectile>();
	ArrayList<Alien> alienTroops = new ArrayList<Alien>();
	Random ran = new Random();
	int score = 0;
	
	ObjectManager(Rocketship rocket){
		this.rocket = rocket;
	}
	
	void addProjectile(Projectile missile) {
		missiles.add(missile);
	}
	
	void addAlien(){
		alienTroops.add(new Alien(ran.nextInt(LeagueInvaders.WIDTH), 0, 50, 50));
		
	}

	void update() {
		
		rocket.update();
		
		
		for(int i = 0; i<alienTroops.size(); i++) {
			alienTroops.get(i).update();
			if(alienTroops.get(i).height > LeagueInvaders.HEIGHT) {
				alienTroops.get(i).isActive = false;
				//
			}
		
		}
		
		for(int i = 0; i<missiles.size(); i++) {
			missiles.get(i).update();
			if(missiles.get(i).height<0) {
				missiles.get(i).isActive = false;
			}
		}
		checkCollision();
		System.out.println("updating objects");
		purgeObjects();
		//STEP 6, GO TO GAME PANEL
		
	}
	
	void draw(Graphics g) {
		rocket.draw(g);
		for(int i = 0; i < alienTroops.size(); i++) {
			alienTroops.get(i).draw(g);
		}
		for(int i = 0; i < missiles.size(); i++) {
			missiles.get(i).draw(g);
		}
		
	}
	
	void purgeObjects() {
		for(int i = 0; i < alienTroops.size(); i++) {
			if(!alienTroops.get(i).isActive) {
				alienTroops.remove(i);
				score++;
			}
		}
		
		for(int i = 0; i < missiles.size(); i++) {
			System.out.println("this part is working");
			if(!missiles.get(i).isActive) {
			missiles.remove(i);
			System.out.println("missile at i removed from array");
			//missiles.get(i).needImage = false;
			}
		}
		//if(rocket.isActive = false) {
			//make rocketship dissapear.
		//}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 addAlien();
	}
	
	public void checkCollision(){
		for(int i = 0; alienTroops.size()>i; i++) {
			if (alienTroops.get(i).collisionBox.intersects(rocket.collisionBox)) {
				//alienTroops.get(i).isActive=false;
				rocket.isActive=false;
				
			}
			for(int j = 0; missiles.size()>j; j++) {
				if(alienTroops.get(i).collisionBox.intersects(missiles.get(j).collisionBox)) {
				alienTroops.get(i).isActive=false;
				missiles.get(j).isActive=false;
				
				}
			}
			
		}
	}
	
	int getScore() {
		return score;
	}
	
	
}
