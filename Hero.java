import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hero here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hero extends Actor
{
    private int powerUp; 
    private int speed; 
    private boolean speedUp; //If eaten a Extra Speed PowerUp then speed up
    private int hp;
    private int timer;
    

    /**
     * Create a Hero
     */
    public Hero()
    {
        powerUp = 0;  
        speedUp = false;
        hp = 100;
        
    }

    /**
     * Act - do whatever the Hero wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkKeypress();
        lookForPowerUp();
        countDown();
        setSpeed();
        hitByBullet();
        checkHP();
    }    

    /**
     * Check whether a control key on the keyboard has been pressed.
     * If it has, react accordingly.
     */
    public void checkKeypress()
    {
        if (Greenfoot.isKeyDown("left")) 
        {
            setRotation(180);
            move(setSpeed());
        }
        if (Greenfoot.isKeyDown("right")) 
        {
            setRotation(0);
            move(setSpeed());
        }
        if (Greenfoot.isKeyDown("up")) 
        {
            setRotation(270);
            move(setSpeed());
        }
        if (Greenfoot.isKeyDown("down" )) 
        {
            setRotation(90);
            move(setSpeed());
        }
    }

    /**
     * Sets the speed of the Hero
     */
    public int setSpeed()
    {

        if (speedUp == true)
        {
            speed = 15;
        }
        else{
            speed = 5;
        }
        return speed;

    }

    /**
     * Check if we have found a PowerUp.
     * If we have, take it, if not do nothing.
     */
    public void lookForPowerUp()
    {
        if (isTouching(PowerUp.class))
        {
            if(isTouching(ExtraSpeed.class))
            {
                speedUp = true;
                countDown();
                MyWorld w = (MyWorld)getWorld();
                w.putExtraSpeed();
                
            } 
           
            removeTouching(PowerUp.class);
            
            powerUp++;            
        }
    }

    public void countDown()
    {
        if (speedUp == false )
        {
            setTimer();
        }
        if (speedUp == true)
        {
            timer--;
            if (timer == 0)
            {
                speedUp = false;
                
                setTimer();
            }
        }
        
    }
    
    public int setTimer()
    {
        timer = 200;
        return timer;
    }
    
    /**
     * Checks if the Hero has been hit by a bullet.
     */
    public void hitByBullet()
    {
        if (isTouching(Bullet.class))
        {
            hp--;
        }
    }
    
    /**
     * Checks if HP is zero.
     * If HP is zero, game is over.
     */
    public void checkHP()
    {
        if(hp == 0)
        {
            endGame();
        }
    }
    
    /**
     * Ends the Game
     */
    public void endGame()
    {
        Greenfoot.setWorld(new GameOverWorld());
    }
    
    

}
