import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Stairs here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Stairs extends Tile
{
    public Stairs(int xPos, int yPos, boolean isWalkable) {
		super(xPos, yPos, isWalkable);
		this.setImage("stairs_down.png");
		
	}
    /**
     * Act - do whatever the Stairs wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
