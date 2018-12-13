import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Liquid here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Liquid extends Tile
{
    public Liquid(String image,int width,int heigth) {
        super(image,width,heigth);
    }
    public void act() 
    {
        if (Hero.lives == 1 && isTouching(Hero.class)) {
            for (Actor hero : getIntersectingObjects(Hero.class)) {
                if (Hero.lives == 1 && isTouching(Hero.class)) {
                    getWorld().removeObject(hero);
                    Greenfoot.setWorld(new Menu());
                    Hero.lives = 2;
                    Hero.hasKeyBlue = false;
                    Hero.key = 0;
                    Hero.money = 0;
                    break;
                }
              }
            }
      }    
  }
