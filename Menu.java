import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends World
{

    /**
     * Constructor for objects of class Menu.
     * 
     */
    public Menu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        this.setBackground("menu.png");
        int[][] map = {
           {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
           {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
           {-1,300,-1,-1,-1,301,-1,-1,-1,302,-1},
           {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
           {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
           {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
           {-1,303,-1,-1,304,-1,-1,305,-1,-1,306},
           {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
           

        };

        // Declareren en initialiseren van de TileEngine klasse om de map aan de world toe te voegen
        TileEngine te = new TileEngine(this, 50, 50, map);
    }
    @Override
    public void act() {
        //ce.update();
        
       }
    }

