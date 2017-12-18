import greenfoot.*;
public class Player extends Actor
{
    boolean goReady=true;
    boolean swordReady=true;
    int swwait=0;
    GameOver gameOver;
    final int LEVEL_1 = 1;
    final int LEVEL_2 = 2;
    final int LEVEL_3 = 3;
    
    HealthBar healthbar = new HealthBar();
    
    int hitCooldown = 0;
    Utilities util;
    

    public void act() 
    {
        doMovement(1);
        doAttack();
        changeImage();
        util = new Utilities();
        
        getWorld().addObject(healthbar, 2, 0);
        
        hitEnemy();
        if(this != null) 
        {
            hitEnemy();
        }
    }  
    

    public void doMovement(int move){      
        World aWorld = getWorld();

        int x = 0, y = 0;
        if (Greenfoot.isKeyDown("d") && this.goReady==true){
            setRotation(0);
            x += 1;
            this.goReady=false;

        }
        if (Greenfoot.isKeyDown("a") && this.goReady==true) {
            setRotation(180);
            x -= 1;
            this.goReady=false;
        }
        if (Greenfoot.isKeyDown("s")&& this.goReady==true) {
            setRotation(90);
            y += 1;
            this.goReady=false;

        }
        if (Greenfoot.isKeyDown("w")&& this.goReady==true) {
            setRotation(270);
            y -= 1;
            this.goReady=false;

        }
        if (Greenfoot.isKeyDown("e")) {
            //setRotation(270);
            //y -= 1;
            //this.goReady=false;
            if(getOneIntersectingObject(Stairs.class) != null){
                // ODO need to get the next world, or the last one to render 
                if (Utilities.getLevel()== LEVEL_1){
                    Greenfoot.setWorld(new World2(this));
                }else if(Utilities.getLevel() == LEVEL_2){
                    Greenfoot.setWorld(new World3(this));
                }

                else{
                    Greenfoot.setWorld(new World1(this));
                }

            }

            if(getOneIntersectingObject(Stairs_up.class) != null){
                // ODO need to get the next world, or the last one to render 
                if (Utilities.getLevel()== LEVEL_2){
                    Greenfoot.setWorld(new World1(this));
                }else if(Utilities.getLevel() == LEVEL_3){
                    Greenfoot.setWorld(new World2(this));
                }

                else{
                    Greenfoot.setWorld(new World1(this));
                }

            }
        }

        if(!Greenfoot.isKeyDown("w") && !Greenfoot.isKeyDown("s") && !Greenfoot.isKeyDown("a") && !Greenfoot.isKeyDown("d"))
        {
            this.goReady=true;
        }
        // check for wall on each step of move in both vertical and horizontal directions
        for (int i = 0; i < move; i++)
        {
            setLocation(getX() + x, getY());
            if (getOneIntersectingObject(Wall.class) != null) setLocation(getX() - x, getY());
            setLocation(getX(), getY() + y);
            if (getOneIntersectingObject(Wall.class) != null) setLocation(getX(), getY() - y);
        }

    }

    public void doAttack()
    {

        if(Greenfoot.isKeyDown("space") && this.swordReady==true)
        {
            if(this.getRotation()==0 && this.getX()<24)
            {
                this.getWorld().addObject(new Sword(90), this.getX()+1, this.getY());
                this.swordReady=false;
            }
            if(this.getRotation()==90 && this.getY()<24)
            {
                this.getWorld().addObject(new Sword(180), this.getX(), this.getY()+1);
                //((World1) getWorld()).swordAt(this.getX(), this.getY()+1, 180);
                this.swordReady=false;
            }
            if(this.getRotation()==180 && this.getX()>0)
            {
                this.getWorld().addObject(new Sword(270), this.getX()-1, this.getY());
                this.swordReady=false;
            }
            if(this.getRotation()==270 && this.getY()>0)
            {
                this.getWorld().addObject(new Sword(0), this.getX(), this.getY()-1);
                //((World1) getWorld()).swordAt(this.getX(), this.getY()-1, 0);
                this.swordReady=false;
            }
            this.swwait=8;
        }
        if(!Greenfoot.isKeyDown("space"))
        {
            this.swordReady=true;
        }
        if(this.swwait>0)
        {
            this.swwait--;
        }
    }

    public void changeImage()
    {
        if(swwait==0)
        {
            this.setImage("PlayerNormal.png");
        }
        else
        {
            this.setImage("PlayerSwording.png");
        }
    }

    private Actor getOneObjectInFront(int x, int y, Class c){
        GreenfootImage myImage = getImage();
        int distanceToFront = myImage.getWidth();
        int xOffset = (int) Math.ceil(distanceToFront*Math.cos(Math.toRadians(getRotation())));
        int yOffset = (int) Math.ceil(distanceToFront*Math.sin(Math.toRadians(getRotation())));
        return(getOneObjectAtOffset(xOffset, yOffset, c));

    }
    
     public void hitEnemy()
    {
        World myWorld = getWorld();
        System.out.println(this);
        if(this.getOneIntersectingObject(Enemy.class) !=  null)
        {
            if(hitCooldown == 0) 
            {
                healthbar.loseHealth();
            }
            hitCooldown++;
            if(hitCooldown >= 200)
            {
                hitCooldown = 0;
            }
            if(healthbar.health <= 0)
            {
                Greenfoot.setWorld(new GameOver());
            }
        }
    }
 
}

