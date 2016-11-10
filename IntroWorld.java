import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class IntroWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IntroWorld extends World
{
    private static final int WORLD_WIDTH = 600;
    private static final int WORLD_HEIGHT = 400;
    
    /**
     * Constructor for objects of class IntroWorld.
     * 
     */
    public IntroWorld()
    {    
        super(WORLD_WIDTH, WORLD_HEIGHT, 1); 
        GreenfootImage background = getBackground();
        setBackground(new GreenfootImage("bg.jpg"));
        GreenfootImage bg = getBackground();
        bg.setColor(Color.RED);
        bg.drawString("WELCOME TO THE AWSOME TOWER DEFENCE GAME!", (WORLD_WIDTH / 2) - 100, (WORLD_HEIGHT / 2) - 150);
        bg.drawString("PRESS THE ENTER BUTTON TO PLAY", (WORLD_WIDTH / 2) - 90, (WORLD_HEIGHT / 2) - 120);
        bg.drawString("Use the arrows to control the Hero", (WORLD_WIDTH / 2) - 90, (WORLD_HEIGHT / 2) - 70);
    }
    
    public void act()
    {
        String key = Greenfoot.getKey();
        if (key != null && key.equals("enter"))
        {
            Greenfoot.setWorld(new MyWorld(true));
        }
    }
}
