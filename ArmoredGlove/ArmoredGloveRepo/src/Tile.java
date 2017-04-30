import jig.Vector;

public class Tile {
	public Vector LeftCorner; 
	public Vector tileCenter;
	
	// Want these half of whatever TILESIZE in map is
	public int TILEOFFSET_X = 8;  
	public int TILEOFFSET_Y = 8;
	
	// What 'lives' in tiles
	private boolean Wall= false;
	private boolean Ground = false;
	
	
	public Tile(float a, float b, boolean isWall, boolean isGround){
		LeftCorner = new Vector(a,b);
		tileCenter = new Vector(a + TILEOFFSET_X,b + TILEOFFSET_Y);
		
		// Flags for building tiles
		Wall = isWall;
		Ground = isGround;
		
	}
	
	public Vector getTileMid(){
		return tileCenter;
	}
	
	public Vector getLeftCorner(){
		return LeftCorner;
	}
	
	public boolean isWall(){
		return Wall;
	}
	
}
