package Rockstew;

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Door here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Door extends Tile{
	public Door(int xPos, int yPos, boolean isWalkable) {
		super(xPos, yPos, isWalkable);
		toggleSprite();
		
	}
	
	/**This method receives no parameters and allows the door
	 * to be opened and closed. (Toggles "walkable" status.)
	 */
	public void openClose(){
		walkable = !walkable;
		toggleSprite();
				
	}
	
	private void toggleSprite(){
	   if (this.walkable == true){
	       this.setImage("open_door.png");
	   }
	   else if (this.walkable == false){
	       this.setImage("closed_door.png");
}
}
}
