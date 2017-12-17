package Rockstew;

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wall extends Tile
{
    public Wall(int xPos, int yPos) {
		super(xPos, yPos, false);
		this.setImage("wall.png");
		
	}
    /**
     * Act - do whatever the Wall wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       Actor a = this.getOneIntersectingObject(Player.class);
       if(a !=null)
       {
           //this.getWorld().removeObject(a);
        }
    }    
}
