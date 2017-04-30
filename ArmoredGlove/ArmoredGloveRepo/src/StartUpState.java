
import java.awt.*;



import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


class StartUpState extends BasicGameState {	
	
	private int timer;

	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
	}
	
	@Override
	public void enter(GameContainer container, StateBasedGame game) {
		container.setSoundOn(false);
		timer = 400;
	}


	@Override
	public void render(GameContainer container, StateBasedGame game,
			Graphics g) throws SlickException {
		ArmoredGlove ag = (ArmoredGlove)game;
		


		TrueTypeFont font;
	    Font awtFont = new Font("Times New Roman", Font.BOLD, 48);
	    font = new TrueTypeFont(awtFont, false);
		
		g.setFont(font);
		timer--;
		if (timer > 300){
			System.out.println(timer);
			g.drawString("Armored Glove", 225, 270);
		}else{
			ag.enterState(ArmoredGlove.PLAYINGSTATE);
		}
			
	}

	@Override
	public void update(GameContainer container, StateBasedGame game,
			int delta) throws SlickException {

		Input input = container.getInput();
		ArmoredGlove ag = (ArmoredGlove)game;


		if (input.isKeyDown(Input.KEY_SPACE))
			ag.enterState(ArmoredGlove.PLAYINGSTATE);	
		

	}

	@Override
	public int getID() {
		return ArmoredGlove.STARTUPSTATE;
	}
	
}