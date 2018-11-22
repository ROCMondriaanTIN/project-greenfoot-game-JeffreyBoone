import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class KeyBlue here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class KeyBlue extends Tile
{
    public String keyblue;
    public KeyBlue(String image,int width,int heigth) {
        super(image,width,heigth);
    }
    public void act() 
    {
        setImage("keyBlue.png" );
        remove();
    }  
    public void remove() {
            if(isTouching(Hero.class)) {
                getWorld().removeObject(this);
                Hero.key++;}
        }
}
