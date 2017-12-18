import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOVer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends World
{
    /**
     * Constructor for objects of class GameOver.
     * 
     */
    public GameOver()
    {    
        super(600, 400, 1);
        //instantiates buttons and adds it to world
        GameOverButton contButton = new GameOverButton();
        //GameOverText gameOver = new GameOverText();
        ExitButton exitButton = new ExitButton();
        addObject(contButton, 135, 340);
        Greenfoot.setWorld(this);
        addObject(exitButton, 458, 340);
        //addObject(gameOver, 30, 30);
    }
}
