package Rockstew;

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MonsterSpawner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MonsterSpawner extends Actor
{  
    //needs the map width and length to determine spawning location
    /**int enemyCount,
		mapWidth,
		mapLength,
		spawnSpotX,
		spawnSpotY;
		
	//final for controlling the emenies on screen 
	final int ENEMY_LIMIT = 20;
	
	//testing construstor for manuel input of enemies
	public MonsterSpawner(int enemies, int mapW, int mapL){
		enemyCount = enemies;
		mapWidth = mapW;
		mapLength = mapL;
	}
	
	//basic constructor to automatically spawn
	public MonsterSpawner(){
		enemyCount = getEnemyArrayLength();
		mapWidth = getMapWidth();
		mapLength = getMapLength();
	}
	
	//to manipulate the enemy array by adding enemies
	private int getEnemyArrayLength(){
		return (((World1) getWorld()).getEnemyCount());
	}
	
	//needs to be modified to be useful
	private int getMapWidth(){
		return map.getMapWidth();
	}
	
	//same as method above
	private int getMapLength(){
		return map.getMapLength();
	}
	
	//random location within the map bounds
	private void spawnLocation(){
		spawnSpotX = (int)((double)mapWidth * Math.random());
		spawnSpotY = (int)((double)mapLength * Math.random());
	}
	
	//checks if monster spawns within a wall, needs to be modified for functionality change
	private boolean checkBounds(){ //not important? tries to figure out if enemies spawn in bounds. change it
		if(spawnSpotX >= 0 && spawnSpotY >= 0)
			return map.mapInbounds.contains(spawnSpotX, spawnSpotY);	//replace with getter from world1
	}
	
	//modifier for changing the percent chance for a monster to spawn
	private boolean initialCheck(){ //50% chance that enemies spawn
		if(Math.random()>.5)
			return true;
		return false;
	}
	
	//try to implement checkbounds() and initialCheck() as modifiers to the spawn rate
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
