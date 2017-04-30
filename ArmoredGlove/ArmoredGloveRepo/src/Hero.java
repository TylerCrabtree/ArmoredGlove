import jig.Entity;
import jig.ResourceManager;
import jig.Vector;

class Hero extends Entity {
	// Hold the X and Y grid that Hero lives in
	public int grid_x;
	public int grid_y;
	
	// X and Y coordinate in pixels
	public float X;             
	public float Y;
	
	public Hero(final float x, final float y, int cell_x, int cell_y) {
		super(x, y);
		addImageWithBoundingBox(ResourceManager.getImage(ArmoredGlove.PLAYER_RSC));
		
		X = x;
		Y = y;
		grid_x = cell_x;
		grid_y = cell_y;
	}
	

	public void attack(Vector attackPosition, int direction){
		System.out.printf("attack! %s" ,attackPosition);
		System.out.printf("Direction! %d\n" ,direction);
		//addImageWithBoundingBox(ResourceManager.getImage(ArmoredGlove.PLAYER_RSC));
		double hero_X = attackPosition.getX();
		double hero_Y = attackPosition.getY();
		
		if (direction == 0){
			
		}
		if (direction == 1){
			
		}
		if (direction == 2){
			
		}	
		if (direction == 3){
			
		}
		if (direction == 4){
			
		}	
		if (direction == 5){
			
		}	
		if (direction == 6){
			
		}
		if (direction == 7){
			
		}
		
		 
	}
	
	
	
	
	
	
	
}
