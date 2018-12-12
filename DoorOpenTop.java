import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DoorOpenTop here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DoorOpenTop extends Tile
{
    public String door;
    public DoorOpenTop(String image,int width,int heigth) {
        super(image,width,heigth);
    }
    public void act() 
    {
        if (Hero.hasKeyBlue == false) {
        setImage("door_closedTop.png" );}
        if (Hero.hasKeyBlue == true) {
        setImage("door_openTop.png" );
        for (Actor hero : getIntersectingObjects(Hero.class)) {
                if ((hero != null && getWorld() instanceof World1) && (Greenfoot.isKeyDown("s"))) {
                    Greenfoot.setWorld(new World2());
                    Hero.hasKeyBlue = false;
                    break;
                }
                if ((hero != null && getWorld() instanceof World2) && (Greenfoot.isKeyDown("s"))) {
                    Greenfoot.setWorld(new World3());
                    Hero.hasKeyBlue = false;
                    break;
                }
                if ((hero != null && getWorld() instanceof World3) && (Greenfoot.isKeyDown("s"))) {
                    Greenfoot.setWorld(new World4());
                    Hero.hasKeyBlue = false;
                    break;
                }
                if ((hero != null && getWorld() instanceof World4) && (Greenfoot.isKeyDown("s"))) {
                    Greenfoot.setWorld(new Menu());
                    Hero.hasKeyBlue = false;
                    break;
                }
        }
      }
    }  
}
