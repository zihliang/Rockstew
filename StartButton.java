import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartButton extends Actor
{
    /**
     * Act - do whatever the StartButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
     public StartButton() 
    {
        //sets button image
        GreenfootImage StartButton = new GreenfootImage("startButton.png");
        this.setImage(StartButton);
    }  
  public void act()
    {
        //when button is clicked, everything resets from beginning 
        if(Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new World1());
            
        }
        
    }   
}
