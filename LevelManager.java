import greenfoot.*;
import java.util.*;
/**
 * Write a description of class LevelManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelManager  
{
    static ArrayList<World> worlds = new ArrayList<World>();
        
    /**
     * Constructor for objects of class LevelManager
     */
    public LevelManager()
    {
        worlds.add(new MyWorld());
        worlds.add(new TestWorld());
    }
    public static void setLevel(int Level) {
        Greenfoot.setWorld(worlds.get(Level));
    }
}
