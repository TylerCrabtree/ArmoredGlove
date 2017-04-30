
import jig.Entity;
import jig.ResourceManager;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;


public class ArmoredGlove extends StateBasedGame {
	//DEBUG FLAGS: --------------------------------------------------
	
	// States of game -----------------------------------------------
	public static final int STARTUPSTATE = 0;
	public static final int PLAYINGSTATE = 1;
	public static final int GAMEOVERSTATE = 2;
	
	// For loading spite Sheets ---------------------------------------
	public static final String MAP_RSC = "assets/testMap.png";
	public static final String PLAYER_RSC = "assets/testPlayer.png";
	
	//Global entities & Variables -----------------------------------
	public final int ScreenWidth;
	public final int ScreenHeight;
	Map map;
	Hero player;
	
	public ArmoredGlove(String title, int width, int height) {
		super(title);
		ScreenHeight = height;
		ScreenWidth = width;

		Entity.setCoarseGrainedCollisionBoundary(Entity.AABB);				
	}


	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		
		// Adding Game States
		addState(new StartUpState());
		addState(new GameOverState());
		addState(new PlayingState());

		// PREload all the resources to avoid warnings & minimize latency...
		ResourceManager.loadImage(MAP_RSC);
		ResourceManager.loadImage(PLAYER_RSC);
		
		//ResourceManager.loadSound(TITLE);	
		
		// Create the map ----------------------------------------------------
		// First two numbers are center of the map, last two are how many tiles in grid
		map = new Map(ScreenWidth/2, ScreenHeight/2, 25, 25); 
		
		// SET STARTING POINTS FOR ALL ENTITYS -----------------------------
		player = new Hero(Map.grid[4][9].getTileMid().getX(),Map.grid[4][9].getTileMid().getY(), 4, 9);

	}
	
	public static void main(String[] args) {
		AppGameContainer app;
		try {
			app = new AppGameContainer(new ArmoredGlove("ArmoredGlove", 800, 600));
			app.setDisplayMode(800, 600, false);
			app.setVSync(true);
			app.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}

	}

}
