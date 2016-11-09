import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
     ExtraSpeed extraSpeed;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
<<<<<<< HEAD
        putHero();
        checkForExtraSpeed();
    }
    public void act(){
        checkForExtraSpeed();
    }
    /**
     * Puts the Hero into the world
     */
    private void putHero()
    {
        Hero hero = new Hero();
        addObject(hero, 250, 100);
    }

    /**
     * Puts a Power up at a random place
     */
    public void putExtraSpeed()
    {
       extraSpeed = new ExtraSpeed();
       addObject(extraSpeed, Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(400));

=======
        populateWorld();
    }
    
    public void populateWorld()
    {
        addObject(new DonaldTrump(), 500, 50);
        addObject(new DonaldTrump(), 100, 350);
        addObject(new DonaldTrump(), 100, 50);
        addObject(new DonaldTrump(), 500, 350);
>>>>>>> origin/master
    }

    /**
     * Checks if there is an ExtraSpeed in the world
     */
    private void checkForExtraSpeed()
    {
        if(extraSpeed==null){
            putExtraSpeed();
        
        }
    }      
    
}


