import greenfoot.*;
public class Enemy extends Actor
{
    int timer=1;
    int playerX;
    int playerY;
   //GameOver gameOver = new GameOver();
     
    public Enemy(int r)
    {
        this.setRotation(r);
    }

    public void act() 
    {
        checkGameOver();
        updatePlayerCor();
        if(this.timer%62==0)
        {
            doRoat();
            //doMove();
            doMovement();
        }
        this.timer++;
        checkDeath();
    }

    public void checkGameOver()
    {
        Player p=(Player)getOneObjectAtOffset(0, 0, Player.class);
        if(p!=null)
        {
            //((World1) getWorld()).gameOver();
            Greenfoot.setWorld(new GameOver());
            
        }
    }

    public void checkDeath()
    {
        Sword s=(Sword)getOneObjectAtOffset(0, 0, Sword.class);
        if(s!=null)
        {
            ((World1) getWorld()).kills++;
            ((World1) getWorld()).removeObject(this);
        }
    }

    public void updatePlayerCor()
    {
        this.playerX=((World1) getWorld()).player.getX();
        this.playerY=((World1) getWorld()).player.getY();
    }

    public void doRoat()
    {
        if(this.getX()!=this.playerX && this.getY()!=this.playerY)
        {
            int a=Greenfoot.getRandomNumber(2);
            if(a==0)
            {
                if(this.getX()<this.playerX)
                {
                    this.setRotation(0);
                }
                if(this.getX()>this.playerX)
                {
                    this.setRotation(180);
                }
            }
            if(a==1)
            {
                if(this.getY()<this.playerY)
                {
                    this.setRotation(90);
                }
                if(this.getY()>this.playerY)
                {
                    this.setRotation(270);
                }
            }
        }
        if(this.getX()!=this.playerX && this.getY()==this.playerY)
        {
            if(this.getX()<this.playerX)
            {
                this.setRotation(0);
            }
            if(this.getX()>this.playerX)
            {
                this.setRotation(180);
            }
        }
        if(this.getX()==this.playerX && this.getY()!=this.playerY)
        {
            if(this.getY()<this.playerY)
            {
                this.setRotation(90);
            }
            if(this.getY()>this.playerY)
            {
                this.setRotation(270);
            }
        }
    }

    public void doMove()
    {
        if(this.getRotation()==270)
        {
            this.setLocation(this.getX(), this.getY()-1);
        }
        if(this.getRotation()==90)
        {
            this.setLocation(this.getX(), this.getY()+1);
        }
        if(this.getRotation()==0)
        {
            this.setLocation(this.getX()+1, this.getY());
        }
        if(this.getRotation()==180)
        {
            this.setLocation(this.getX()-1, this.getY());
        }
    }

    // Added by Joe 12/10 - Use this and enemys cant float through walls

    public void doMovement(){      

        // check for wall on each step of move in both vertical and horizontal directions
        if(this.getRotation()==270)
        {
            if (getOneIntersectingObject(Wall.class) == null){

                this.setLocation(this.getX(), this.getY()-1);
            }
            else{
                this.setLocation(this.getX(), this.getY()+1);
            }

        }

        if(this.
getRotation()==90)       
        {
            if (getOneIntersectingObject(Wall.class) == null){

                this.setLocation(this.getX(), this.getY()+1);
            }
            else{
                this.setLocation(this.getX(), this.getY()-1);
            }
        }
        if(this.getRotation()==0)
        {
            if (getOneIntersectingObject(Wall.class) == null){

                this.setLocation(this.getX()+1, this.getY());
            }
            else{
                this.setLocation(this.getX()-1, this.getY());
            }
        }
        if(this.getRotation()==180)

            if (getOneIntersectingObject(Wall.class) == null){

                this.setLocation(this.getX()-1, this.getY());
            }
            else{
                this.setLocation(this.getX()+1, this.getY());
            }

    }
}
