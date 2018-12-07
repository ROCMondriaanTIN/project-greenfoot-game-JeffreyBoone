import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Diamond here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Diamond extends Tile
{
    Hero h;
    public Diamond(String image,int width,int heigth, TileType type) {
        super(image,width,heigth,type);
    }
    public void act() 
    {
        setImage("gemBlue.png" );
        if(isTouching(Hero.class)) {
            getWorld().removeObject(this);
            h.diamonds++;
        }
    }  
}
