import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class P3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class P3 extends MenuOptions
{
    
    public P3(String image,int width,int heigth) {
        super(image,width,heigth);
    }
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)) {
            Hero.n = 3;
          }
    }   
}
