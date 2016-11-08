import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;


/**
 * Write a description of class TowerRadius here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TowerRadius extends Actor
{
    public TowerRadius(Tower tower)
    {
        GreenfootImage im = new GreenfootImage((int) (tower.getRadius()*1.8), (int) (tower.getRadius()*1.8));
        setImage(im);
        
        // Fill the circle
        im.setColor(new Color (46, 46, 46, 180));
        im.fillOval(0, 0, (int) (tower.getRadius()*1.8), (int) (tower.getRadius()*1.8));
        
        setImage(im);
    }  
}
