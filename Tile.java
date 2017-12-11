import greenfoot.*;
public class Tile extends Actor {
    //protected Item theItem;
    public int x, y;
    public boolean walkable;
    protected boolean hasitem = false;
    public boolean hasPlayer = false;
    
    
    
    /**
     * Constructor sets local X and Y values, and also holds a boolean that tells
     * the Map whether or not the tile is walkable.
     * @param x
     * @param y
     * @param walkable
     */
    public Tile(int xPos, int yPos, boolean isWalkable){
        walkable = isWalkable;
        x = xPos;
        y = yPos;
        
        if(walkable){                    //Try to enable graphics functionality. Learn how to superimpose images on tiles.
            //this.setImage("floor.png");       
            
        }
        else{
           // this.setImage("wall.png");
        }
}
 
    
public boolean isWalkable(){
        return walkable;
}

public void act(){
    //Actor a = this.getOneIntersectingObject();
}
    
    
    /**Allows for the boolean that tells the tile whether or not it contains
     * an item to be toggled. Helpful in dropping items/spawning items.
     */
    /*public void toggleHasItem(){
        hasitem = !hasitem;
    }
    
    public boolean hasItem(){
        return hasitem;
    }

    public int useStairs() {
        // TODO Auto-generated method stub
        return 0;
    }
    
    public void openClose(){
        
    }
    
    /*public Item getItem(){
        return theItem;
        
    }*/
}