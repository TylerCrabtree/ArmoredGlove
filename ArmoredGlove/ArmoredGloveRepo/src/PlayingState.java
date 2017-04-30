

import java.util.Iterator;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


class PlayingState extends BasicGameState {
	private int direction = 0;
	private int countdown;
	private boolean canMove; 
	private int LOCKOUT_TIME = 80; // <-------- Change speed of Player (smaller = faster)
	private int LOCKOUT_TIME_D =(int) (LOCKOUT_TIME * 1.4);
	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
	}

	@Override
	public void enter(GameContainer container, StateBasedGame game) {
		canMove = true;	// can move at start
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		ArmoredGlove ag = (ArmoredGlove)game;
		ag.map.render(g);
		ag.player.render(g);

		g.drawString("Armored Glove", 10, 30);

	}

	@Override
	public void update(GameContainer container, StateBasedGame game,
			int delta) throws SlickException {

		Input input = container.getInput();
		ArmoredGlove ag = (ArmoredGlove)game;

		// +===========+
		// | KEY INPUT |===========================================================================================
		// +===========+
		
		 //0 = north, northeast = 1, east = 2... so on

		
		if ((input.isKeyDown(Input.KEY_W)) && (input.isKeyDown(Input.KEY_D)) && !Map.grid[ag.player.grid_x][ag.player.grid_y - 1].isWall()  && !Map.grid[ag.player.grid_x + 1][ag.player.grid_y ].isWall()&& !Map.grid[ag.player.grid_x + 1][ag.player.grid_y - 1 ].isWall() )  {
			// Update players grid position
			if (canMove){
				
				direction = 1;
		
				ag.player.grid_y--;
				ag.player.grid_x++;
				// Update players animation position
				ag.player.setPosition(Map.grid[ag.player.grid_x][ag.player.grid_y].getTileMid().getX(), 
						Map.grid[ag.player.grid_x][ag.player.grid_y].getTileMid().getY());
				countdown = LOCKOUT_TIME_D;
				canMove = false;
			} else {
				System.out.println("countdown: "+ countdown);
				if (countdown > 0)
					countdown -= delta;
				if (countdown <= 0) {
					canMove = true;
					System.out.println("canMove unlock: "+ canMove);
				}
			}
		}
		else
			if ((input.isKeyDown(Input.KEY_W)) && !Map.grid[ag.player.grid_x][ag.player.grid_y - 1].isWall() && (input.isKeyDown(Input.KEY_A)) && !Map.grid[ag.player.grid_x - 1][ag.player.grid_y ].isWall() && !Map.grid[ag.player.grid_x - 1][ag.player.grid_y -1 ].isWall() ) {
				// Update players grid position
				if (canMove){
					ag.player.grid_y--;
					ag.player.grid_x--;
					direction = 7;

					// Update players animation position
					ag.player.setPosition(Map.grid[ag.player.grid_x][ag.player.grid_y].getTileMid().getX(), 
							Map.grid[ag.player.grid_x][ag.player.grid_y].getTileMid().getY());
					countdown = LOCKOUT_TIME_D;
					canMove = false;
				} else {
					System.out.println("countdown: "+ countdown);
					if (countdown > 0)
						countdown -= delta;
					if (countdown <= 0) {
						canMove = true;
						System.out.println("canMove unlock: "+ canMove);
					}
				}
			}
			else	
				if ((input.isKeyDown(Input.KEY_S)) && !Map.grid[ag.player.grid_x][ag.player.grid_y + 1].isWall()&& (input.isKeyDown(Input.KEY_A)) && !Map.grid[ag.player.grid_x - 1][ag.player.grid_y ].isWall() && !Map.grid[ag.player.grid_x - 1][ag.player.grid_y + 1].isWall()  ) {
					// Update players grid position
					if (canMove){
						ag.player.grid_y++;
						ag.player.grid_x--;

						direction = 5;
						// Update players animation position
						ag.player.setPosition(Map.grid[ag.player.grid_x][ag.player.grid_y].getTileMid().getX(), 
								Map.grid[ag.player.grid_x][ag.player.grid_y].getTileMid().getY());
						countdown = LOCKOUT_TIME_D;
						canMove = false;
					} else {
						System.out.println("countdown: "+ countdown);
						if (countdown > 0)
							countdown -= delta;
						if (countdown <= 0) {
							canMove = true;
							System.out.println("canMove unlock: "+ canMove);
						}
					}
				}
				else		
					if ((input.isKeyDown(Input.KEY_S)) && !Map.grid[ag.player.grid_x][ag.player.grid_y + 1].isWall()&& (input.isKeyDown(Input.KEY_D)) && !Map.grid[ag.player.grid_x + 1][ag.player.grid_y ].isWall() && !Map.grid[ag.player.grid_x + 1][ag.player.grid_y +1 ].isWall() ) {
						// Update players grid position
						if (canMove){
							ag.player.grid_y++;
							ag.player.grid_x++;

							direction =3;
							// Update players animation position
							ag.player.setPosition(Map.grid[ag.player.grid_x][ag.player.grid_y].getTileMid().getX(), 
									Map.grid[ag.player.grid_x][ag.player.grid_y].getTileMid().getY());
							countdown = LOCKOUT_TIME_D;
							canMove = false;
						} else {
							System.out.println("countdown: "+ countdown);
							if (countdown > 0)
								countdown -= delta;
							if (countdown <= 0) {
								canMove = true;
								System.out.println("canMove unlock: "+ canMove);
							}
						}
					}
					else			
					if ((input.isKeyDown(Input.KEY_W)) && !Map.grid[ag.player.grid_x][ag.player.grid_y - 1].isWall()) {
						// Update players grid position
						if (canMove){
							ag.player.grid_y--;
							direction = 0;
							// Update players animation position
							ag.player.setPosition(Map.grid[ag.player.grid_x][ag.player.grid_y].getTileMid().getX(), 
									Map.grid[ag.player.grid_x][ag.player.grid_y].getTileMid().getY());
							countdown = LOCKOUT_TIME;
							canMove = false;
						} else {
							System.out.println("countdown: "+ countdown);
							if (countdown > 0)
								countdown -= delta;
							if (countdown <= 0) {
								canMove = true;
								System.out.println("canMove unlock: "+ canMove);
							}
						}
					}
					else
						if ((input.isKeyDown(Input.KEY_S)) && !Map.grid[ag.player.grid_x][ag.player.grid_y + 1].isWall()) {
							// Update players grid position
							if (canMove){
								ag.player.grid_y++;
								direction =4;
								// Update players animation position
								ag.player.setPosition(Map.grid[ag.player.grid_x][ag.player.grid_y].getTileMid().getX(), 
										Map.grid[ag.player.grid_x][ag.player.grid_y].getTileMid().getY());
								countdown = LOCKOUT_TIME;
								canMove = false;
							} else {
								System.out.println("countdown: "+ countdown);
								if (countdown > 0)
									countdown -= delta;
								if (countdown <= 0) {
									canMove = true;
									System.out.println("canMove unlock: "+ canMove);
								}
							}
						}
						else
							if ((input.isKeyDown(Input.KEY_A)) && !Map.grid[ag.player.grid_x - 1][ag.player.grid_y ].isWall()) {
								// Update players grid position
								if (canMove){
									ag.player.grid_x--;
									direction =6;
									// Update players animation position
									ag.player.setPosition(Map.grid[ag.player.grid_x][ag.player.grid_y].getTileMid().getX(), 
											Map.grid[ag.player.grid_x][ag.player.grid_y].getTileMid().getY());
									countdown = LOCKOUT_TIME;
									canMove = false;
								} else {
									System.out.println("countdown: "+ countdown);
									if (countdown > 0)
										countdown -= delta;
									if (countdown <= 0) {
										canMove = true;
										System.out.println("canMove unlock: "+ canMove);
									}
								}
							}
							else
								if ((input.isKeyDown(Input.KEY_D)) && !Map.grid[ag.player.grid_x + 1][ag.player.grid_y ].isWall()) {
									// Update players grid position
									if (canMove){
										ag.player.grid_x++;
										direction =2;
										// Update players animation position
										ag.player.setPosition(Map.grid[ag.player.grid_x][ag.player.grid_y].getTileMid().getX(), 
												Map.grid[ag.player.grid_x][ag.player.grid_y].getTileMid().getY());
										countdown = LOCKOUT_TIME;
										canMove = false;
									} else {
										System.out.println("countdown: "+ countdown);
										if (countdown > 0)
											countdown -= delta;
										if (countdown <= 0) {
											canMove = true;
											System.out.println("canMove unlock: "+ canMove);
										}
									}
								}
		if ((input.isKeyPressed(Input.KEY_ENTER)) ) {
			// Update players grid position
			
				ag.player.attack(ag.player.getPosition(), direction);
			// Update players animation position
				countdown = LOCKOUT_TIME;
				if (countdown > 0)
					countdown -= delta;
				if (countdown <= 0) {
				}
			
		}



	}

	@Override
	public int getID() {
		return ArmoredGlove.PLAYINGSTATE;
	}

}