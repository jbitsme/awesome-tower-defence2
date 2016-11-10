import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    private static final int WORLD_WIDTH = 600;
    private static final int WORLD_HEIGHT = 400;
<<<<<<< HEAD

    ExtraSpeed extraSpeed;

=======
    
    ExtraSpeed extraSpeed;
    
>>>>>>> origin/master
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        populateWorld();
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
       ExtraSpeed extraSpeed = new ExtraSpeed();
       addObject(extraSpeed, Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(400));
    }
    
    public void populateWorld()
    {
        addObject(new DonaldTrump(), 500, 50);
        addObject(new DonaldTrump(), 100, 350);
        addObject(new DonaldTrump(), 100, 50);
        addObject(new DonaldTrump(), 500, 350);
<<<<<<< HEAD

=======
        addObject(new Tower(), 100, 300);
>>>>>>> origin/master
        addObject(new Hero(), 300, 200);
    }
    
    public MyWorld(boolean gameStarted)
    {
        super(WORLD_WIDTH, WORLD_HEIGHT, 1);
        if(gameStarted)
        {
            addObject(new DonaldTrump(), 500, 50);
            addObject(new DonaldTrump(), 100, 350);
            addObject(new DonaldTrump(), 100, 50);
            addObject(new DonaldTrump(), 500, 350);
            
        }
        else
        {
            Greenfoot.setWorld(new IntroWorld());
        }

    }

    /**
     * Checks if there is an ExtraSpeed in the world
     */
    private void checkForExtraSpeed()
    {
        if(extraSpeed == null){
            putExtraSpeed();
            }
    }      
    
}


