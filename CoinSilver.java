import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CoinSilver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CoinSilver extends Tile
{
    public String coinsilver;
    public CoinSilver(String image,int width,int heigth) {
        super(image,width,heigth);
    }
    public void act() 
    {
        setImage("coinSilver.png" );
    }    
}
