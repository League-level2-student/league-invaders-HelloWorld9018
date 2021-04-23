import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Rocketship rocket;
	ArrayList<Projectile> missiles = new ArrayList<Projectile>();
	ArrayList<Alien> alienTroops = new ArrayList<Alien>();
	Random ran = new Random();
	
	ObjectManager(Rocketship rocket){
		this.rocket = rocket;
	}
	
	void addProjectile(Projectile missile) {
		missiles.add(missile);
	}
	
	void addAleins(){
		alienTroops.add(new Alien(ran.nextInt(LeagueInvaders.WIDTH), 0, 50, 50));
		
	}

	void update() {
		for(int i = 0; i<alienTroops.size(); i++) {
			alienTroops.get(i).update();
			if(alienTroops.get(i).height > LeagueInvaders.HEIGHT) {
				alienTroops.get(i).isActive = false;
			}
		
		}
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
			if(alienTroops.get(i).isActive = false) {
				alienTroops.remove(i);
			}
		}
		for(int i = 0; i < missiles.size(); i++) {
			if(missiles.get(i).isActive = false) {
			missiles.remove(i);
			}
		}
	}
	
	
}
