import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Snow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Snow extends MenuOptions
{
    public Snow(String image,int width,int heigth) {
        super(image,width,heigth);
    }
    public void act() 
    {
        if(Greenfoot.mouseClicked(this) && Hero.w2c == true) {
            Greenfoot.setWorld(new World3());
          }
    }     
}
