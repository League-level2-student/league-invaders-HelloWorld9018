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
	//left on step 5
}
