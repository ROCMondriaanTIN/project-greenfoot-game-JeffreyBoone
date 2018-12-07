import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class CoinSilver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CoinSilver extends Tile
{
    Hero h;
    public CoinSilver(String image,int width,int heigth, TileType type) {
        super(image,width,heigth);
    }
    public void act() 
    {
        setImage("coinSilver.png" );
        if(isTouching(Hero.class)) {
            getWorld().removeObject(this);
            h.money += 1;
        }
         }    
}
