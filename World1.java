import greenfoot.*;
public class World1 extends World
{
    int time=0;
    int kills=0;
    int spawnrate=1;
    Player player = new Player();
    
    World nextLevel = null;
    
    Tile tiles[][];
    
    public World1()
    {    
        super(24, 24, 32); 
        
        makeLV1();
        
        prepare();
    }

    
    public void act()
    {
        this.time=this.time+16;
        if(this.time%(4*4992)==0)
        {
            this.spawnrate++;
        }
        if(this.time%992==0)
        {
            this.spawne();
        }
        if(this.kills ==2)
        {
            //Greenfoot.setWorld(new World2());
        }
    }
    
    public void spawne()
    {
        for(int i=0;i<spawnrate;i++)
        {
            int a=(Greenfoot.getRandomNumber(1));
            if(a==0)
            {
                addObject(new Enemy(90), 5, 5);
            }
            if(a==1)
            {
                //addObject(new Enemy(270), Greenfoot.getRandomNumber(18), 13);
            }
            if(a==2)
            {
                //addObject(new Enemy(0), 0, Greenfoot.getRandomNumber(14));
            }
            if(a==3)
            {
                //addObject(new Enemy(180), 17, Greenfoot.getRandomNumber(14));
            }
        }
    }
    
        private Tile[][] makeLV1(){
        Tile[][] tiles = new Tile[24][24]; //indicates maximum size of map. can be repurposed

        for(int i = 0; i < 24; i++){
            for(int j = 0; j < 24; j++){
                if(i == 0 || i == 24 || j == 0 || j == 24){ //if it is drawing the edges of the map, it makes them walls no matter what
                    tiles[i][j] = new Wall(i, j);
                }
                else if(i == 23 || j == 23) tiles[i][j] = new Wall(i, j);
                else tiles[i][j] = new Floor(i, j);                                            
                
                if(i == 7) tiles[i][j] = new Wall(i, j);
                
                if(i==15 && j==15) tiles[i][j] = new Stairs(i, j, false);
                
                if(i == 7 && j == 6) tiles [i][j] = new Door(i, j, false);
                /*if(i == 6 && j == 31) tiles[i][j] = new Door(i, j, false);
                if(i == 17 && j == 17) tiles[i][j] = new Stairs(i, j, true, 2);*/
                addObject(tiles[i][j], i, j);
            }
        }
        
        return tiles;
}


   private void prepare()
    {
        
        addObject(player, 9, 5);
        
        //Import and draw tiles here
    }

    public void swordAt(int x, int y, int r)
    {
        addObject(new Sword(r), x, y);
    }



    public void gameOver()
    {
        addObject(new Score(this.kills, this.time/1000), 8, 6);
        Greenfoot.stop();
    }
    
    public void setNextWorld(){
        //getWorld().removeObject(this);
        Greenfoot.setWorld(new World2());
}
}
