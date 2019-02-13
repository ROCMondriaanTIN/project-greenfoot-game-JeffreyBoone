import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Stone here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Stone extends MenuOptions
{
    public Stone(String image,int width,int heigth) {
        super(image,width,heigth);
    }
    public void act() 
    {
        if(Greenfoot.mouseClicked(this) && Hero.w3c == true) {
            Greenfoot.setWorld(new World4());
          }
    }     
}
