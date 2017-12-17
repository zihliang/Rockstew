import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import greenfoot.Color;
import java.util.ArrayList;
 
/**
 * Write a description of class robot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Inventory extends Actor
{
    public List<Actor> collectedObjects = new ArrayList(0); //the items which could be collected 
    public boolean inventoryOpen = false; //start with inventory closed
    public List<Actor> inventoryObjects = new ArrayList(0); //all actors which are added when x is pressed so they can be removed when x is pressed again
    /**
     * Act - do whatever the robot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.isKeyDown("x"))
        {
            toggleInventory();
        }
    } 

    public void toggleInventory()
    {
    if (!inventoryOpen)
    { //create inventory
        Actor background = new Actor() {}; //an actor for the background of the inventory
        GreenfootImage img = new GreenfootImage(360, 45); //size of the inventory
        img.setColor(new Color(100, 0, 0)); //color of the inventory background
        img.fill();
        background.setImage(img);
        getWorld().addObject(background, getWorld().getWidth()/2, getWorld().getHeight()); //add it to the world
        inventoryObjects.add(background);
         
        img = new GreenfootImage(25, 25); //image with the size of each inventory slot
        img.setColor(Color.GRAY); //color of inventory slot
        img.fill();
        int i = 0, numItems = collectedObjects.size();
        for (int row = 0; row < 1; row++) //2 rows of inventory slots
        {
            for (int column = 0; column < 11; column++) //each row has 5 columns
            {
                Actor slot = new Actor() {}; //draw the inventory slots on the image of the 'background' object
                slot.setImage(img);
                getWorld().addObject(slot, (getWorld().getWidth()/2 - 5) + column, getWorld().getHeight());
                //getWorld().addObject(slot, slot.getImage().getWidth()/2-100+10+column*30, slot.getImage().getHeight()/2-100+10+row*30);
                inventoryObjects.add(slot);
                if (i < numItems)
                {
                    Actor item = collectedObjects.get(i);
                    GreenfootImage itm_img = new GreenfootImage(item.getImage());
                    itm_img.scale(20,20);
                    item.setImage(itm_img);
                    getWorld().addObject(item, item.getImage().getWidth()/2-100+10+column*30, item.getImage().getHeight()/2-100+10+row*30);
                    inventoryObjects.add(item);
                }
                i++;
            }
        }
        inventoryOpen = true;
    }
    else
    { //remove inventory
        getWorld().removeObjects(inventoryObjects); //remove all objects relating to the inventory
        inventoryOpen = false; //closes inventory
        inventoryObjects = new ArrayList(0);
    }
  }
}


