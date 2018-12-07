import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CoinGold here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CoinGold extends Tile
{
    Hero h;
    public CoinGold(String image,int width,int heigth, TileType type) {
        super(image,width,heigth,type);
    }
    public void act() 
    {
        setImage("coinGold.png" );
        if(isTouching(Hero.class)) {
            getWorld().removeObject(this);
            h.money += 2;
        }
    }  
}
