import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MonsterSpawner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MonsterSpawner extends Actor
{
    /**int enemyCount,
		mapWidth,
		mapLength,
		spawnSpotX,
		spawnSpotY;
	
	final int ENEMY_LIMIT = 20;
	
	public MonsterSpawner(int enemies, int mapW, int mapL){
		enemyCount = enemies;
		mapWidth = mapW;
		mapLength = mapL;
	}
	
	public MonsterSpawner(){
		enemyCount = getEnemyArrayLength();
		mapWidth = getMapWidth();
		mapLength = getMapLength();
	}
	
	private int getEnemyArrayLength(){
		return (((World1) getWorld()).getEnemyCount());
	}
	
	private int getMapWidth(){
		return map.getMapWidth();
	}
	
	private int getMapLength(){
		return map.getMapLength();
	}
	
	private void spawnLocation(){
		spawnSpotX = (int)((double)mapWidth * Math.random());
		spawnSpotY = (int)((double)mapLength * Math.random());
	}
	
	private boolean checkBounds(){
		if(spawnSpotX >= 0 && spawnSpotY >= 0)
			return map.mapInbounds.contains(spawnSpotX, spawnSpotY);	
	}
	
	private boolean initialCheck(){
		if(Math.random()>.5)
			return true;
		return false;
	}
	
    public void spawne()
    {
        for(int i=0;i<(((World1).getWorld()).spawnrate);i++)
        {
            int a=Greenfoot.getRandomNumber(0);
            if(a==0)
            {
                addObject(new Enemy(90), 1, 1);
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
    /**
     * Act - do whatever the MonsterSpawner wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
