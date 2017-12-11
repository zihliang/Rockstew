import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HealthBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthBar extends Actor
{
    int health = 4;
    int healthWidth = 80;
    int healthHeight = 15;
    int hpPixels = healthWidth/health;
    
    public HealthBar() 
    {
        update();
    }
    /**
     * Act - do whatever the HealthBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        update();
    }
    
    public void update()
    {
        setImage(new GreenfootImage(healthWidth + 2, healthHeight + 2));
        GreenfootImage healthBars = getImage();
        healthBars.setColor(Color.WHITE);
        healthBars.drawRect(0, 0, healthWidth + 1, healthHeight + 1);
        healthBars.setColor(Color.RED);
        healthBars.fillRect(1, 1, health * hpPixels, healthHeight);
    }
    
    public void loseHealth()
    {
        health--;
    }
}
