import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CoinGold here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CoinGold extends Tile
{
    public String coinGold;
    public CoinGold(String image,int width,int heigth) {
        super(image,width,heigth);
    }
    public void act() 
    {
        setImage("coinGold.png" );
    }  
}
