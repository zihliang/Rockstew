import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ExitButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ExitButton extends Actor
{

    public ExitButton()
    {
        //sets button image
        GreenfootImage exitButton = new GreenfootImage("exit.png");
        this.setImage(exitButton);
        exitButton.scale(100,65);
    }

    /**
     * Act - do whatever the ExitButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //when button is clicked, everything resets from beginning 
        if(Greenfoot.mouseClicked(this))
        {
            System.exit(0);
        }
    }    
}
