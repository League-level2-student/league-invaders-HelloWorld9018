import javax.swing.JFrame;

public class LeagueInvaders {
	
	JFrame frame = new JFrame();

	GamePanel drawing;
	
	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;
			
	
	public static void main(String[] args) {
		LeagueInvaders screen = new LeagueInvaders();
		screen.Setup();
	}
	
	LeagueInvaders(){
		frame = new JFrame();
		
		drawing = new GamePanel();
	}

	void Setup(){
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(drawing);
	}
	
}
