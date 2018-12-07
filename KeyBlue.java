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
        if (Hero.hasKeyBlue == true) {
            setImage("niks.png" );
        }
        if (Hero.hasKeyBlue == false) {
            setImage("keyBlue.png" );
        }
        remove();
    }  
    public void remove() {
            if(isTouching(Hero.class) && Hero.hasKeyBlue == false) {
                getWorld().removeObject(this);
                Hero.hasKeyBlue = true;
                Hero.key++;}
        }
}
