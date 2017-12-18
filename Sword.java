import greenfoot.*;
public class Sword extends Actor
{
    int c=0;
    public Sword(int r)
    {
        this.setRotation(r);
    }
    public void act() 
    {
        c++;
        if(c==8)
        {
            this.getWorld().removeObject(this);
        }
    }    
}
