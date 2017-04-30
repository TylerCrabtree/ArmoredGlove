

import jig.Entity;
import jig.ResourceManager;


/* Map class works by loading a single background sprite. This sprite will have to be created in 
 * photoshop with the walls included. It also will have to match the dimensions of our game. When 
 * creating the grid, grid will partition the map into how many elements you need in the grid based 
 * off the size you specify each tile of the grid should be. On render the single background will 
 * be drawn on screen and the moving characters and NPC's will be rendered over top of it. When moving in
 * the world, before every move is executed, the tile being moved into should be checked with isWall()
 * and the sprite can only move into next tile if it is NOT a wall. No need for collisions!!
 */

class Map extends Entity {
	// For grid based map
	public int TILESIZE = 16;           // how many pixels we want individual tile to be
	public static Tile[][] grid;		// Grid is how we access individual parts of map
	
	/*  KEY:
	 *  @ : Wall
	 *  - : Ground
	 */
	// Holds gameboard. Prob should move to a different file when I get a chance.
	// For testing gauntlet this is a simple 25x25 with only walls for testing. 
	// Will have to come back and change this.
	private final char[] MAP_MASK = {                       
			'@','@','@','@','@','@','@','@','@','@','@','@','@','@','@','@','@','@','@','@','@','@','@','@','@',
			'@','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','@',
			'@','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','@',
			'@','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','@',
			'@','-','-','-','@','@','@','@','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','@',
			'@','-','-','-','@','-','-','@','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','@',
			'@','-','-','-','@','-','-','@','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','@',
			'@','-','-','-','@','@','@','@','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','@',
			'@','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','@',
			'@','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','@',
			'@','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','@',
			'@','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','@',
			'@','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','@',
			'@','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','@',
			'@','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','@',
			'@','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','@',
			'@','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','@',
			'@','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','@',
			'@','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','@',
			'@','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','@',
			'@','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','@',
			'@','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','@',
			'@','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','@',
			'@','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','@',
			'@','@','@','@','@','@','@','@','@','@','@','@','@','@','@','@','@','@','@','@','@','@','@','@','@'};
			
	

	public Map(final float x, final float y, int map_x_size, int map_y_size) {
		super(x, y);
		// MAP SPRITE
		addImageWithBoundingBox(ResourceManager.getImage(ArmoredGlove.MAP_RSC));	
		
		// Makes grid relative to where map is placed
		float X_OFFSET = x/2;
		float Y_OFFSET = 100;
		
		// create map
		grid = new Tile[map_x_size][map_y_size]; 
		
		// Loop through array of MAP_MASK and build tiles based on what they are
		int k = 0; // start of array
		for(int i = 0; i < map_y_size; i++){
            for(int j = 0; j < map_x_size; j++){
            	
            	// FLAGS FOR BUILDING TILE
            	// Tile(x, y, isWALL, isGround)
            	
            	// WALL TILE
            	if (MAP_MASK[k] == '@' ){
            		grid[j][i] = new Tile(j*this.TILESIZE + X_OFFSET, i*this.TILESIZE + Y_OFFSET, true, false);
            	} 
            	else 	
                // GROUND TILE
                if (MAP_MASK[k] == '-'){
                	grid[j][i] = new Tile(j*this.TILESIZE + X_OFFSET, i*this.TILESIZE + Y_OFFSET , false, true);
                }
            	else
            		// CATCH ALL INCASE TILE IS NOT RECONIZED 
            		grid[j][i] = new Tile(j*this.TILESIZE, i*this.TILESIZE, false, false);
            	
            	//To check if array is reading in the correct order
            	//System.out.println(MAP_MASK[k]);
            	k++;
            }       
		
		}
		
	}
	
}
