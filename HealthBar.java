import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HealthBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthBar extends Actor
{
    //setting health
    int health = 100;
    //setting width and hight of health bar
    int healthWidth = 100;
    int healthHeight = 15;
    int hpPixels = (int)healthWidth/health;
    GreenfootImage healthBars = getImage();
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
        //creating the health bar
        if (health <= 65 && health > 40)
        {
            setImage(new GreenfootImage(healthWidth + 2, healthHeight + 2));
            GreenfootImage healthBars = getImage();
            healthBars.setColor(Color.WHITE);
            healthBars.drawRect(0, 0, healthWidth + 1, healthHeight + 1); //drawing bar itself
            healthBars.setColor(Color.YELLOW);
            healthBars.fillRect(1, 1, health * hpPixels, healthHeight);
        }
        else if (health <= 40)
        {
            setImage(new GreenfootImage(healthWidth + 2, healthHeight + 2));
            GreenfootImage healthBars = getImage();
            healthBars.setColor(Color.WHITE);
            healthBars.drawRect(0, 0, healthWidth + 1, healthHeight + 1); //redrawing bar 
            healthBars.fillRect(1, 1, health * hpPixels, healthHeight);
        }
        else
        {
            setImage(new GreenfootImage(healthWidth + 2, healthHeight + 2));
            GreenfootImage healthBars = getImage();
            healthBars.setColor(Color.WHITE);
            healthBars.drawRect(0, 0, healthWidth + 1, healthHeight + 1); //redrawing bar 
            healthBars.setColor(Color.GREEN);
            healthBars.fillRect(1, 1, health * hpPixels, healthHeight);
        }
    }
    public void loseHealth()
    {
        health -= 10;
    }
}
