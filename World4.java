import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class World4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class World4 extends World
{
    private CollisionEngine ce;
    /**
     * Constructor for objects of class World4.
     * 
     */
    public World4()
    {    
        super(1000, 800, 1,false); 
        this.setBackground("bg.png");
        int[][] map = {
            {125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125},
{125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125},
  {125,125,-1,-1,-1,-1,-1,-1,41,-1,-1,-1,41,-1,-1,41,-1,-1,-1,41,-1,-1,-1,41,-1,-1,-1,41,-1,-1,-1,41,-1,-1,-1,41,-1,-1,-1,41,-1,-1,-1,41,-1,-1,-1,-1,125,125},
  {125,125,-1,-1,-1,-1,-1,-1,41,-1,-1,-1,41,-1,-1,41,-1,-1,-1,41,-1,-1,-1,41,-1,-1,-1,41,-1,-1,-1,41,-1,-1,-1,41,-1,-1,-1,41,-1,-1,-1,41,-1,-1,-1,-1,125,125},
  {125,125,-1,-1,-1,-1,-1,-1,41,-1,-1,-1,41,-1,-1,41,-1,142,-1,41,-1,-1,-1,41,-1,142,-1,41,-1,-1,-1,41,-1,-1,-1,41,-1,-1,-1,41,-1,-1,-1,41,-1,-1,-1,-1,125,125},
  {125,125,-1,-1,-1,-1,-1,-1,41,-1,142,-1,41,-1,-1,41,-1,-1,-1,25,-1,141,-1,41,-1,-1,-1,41,-1,-1,-1,41,-1,-1,-1,41,-1,-1,-1,41,-1,-1,-1,41,-1,-1,-1,-1,125,125},
  {125,125,-1,-1,-1,-1,-1,-1,41,-1,-1,-1,25,-1,-1,25,-1,-1,-1,-1,-1,-1,-1,41,-1,-1,-1,41,-1,-1,-1,25,-1,142,-1,41,-1,-1,-1,41,-1,-1,-1,41,-1,-1,-1,-1,125,125},
  {125,125,-1,-1,-1,-1,-1,-1,25,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,25,-1,-1,-1,25,-1,-1,-1,-1,-1,-1,-1,41,-1,-1,-1,25,-1,145,-1,41,-1,-1,-1,-1,125,125},
  {125,125,-1,-1,144,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,147,-1,-1,-1,-1,-1,-1,-1,-1,-1,146,145,-1,-1,-1,-1,25,-1,-1,-1,-1,-1,-1,-1,25,-1,-1,-1,-1,125,125},
  {125,125,-1,-1,143,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,25,-1,-1,-1,-1,-1,-1,-1,-1,-1,25,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,125,125},
  {125,125,138,138,138,138,138,138,138,311,311,311,311,311,311,311,311,311,311,125,311,311,311,311,311,311,311,311,311,125,311,311,311,311,311,311,311,311,311,311,311,311,311,311,311,138,138,138,125,125},
  {125,125,125,125,125,125,125,125,125,312,312,312,312,312,312,312,312,312,312,125,312,312,312,312,312,312,312,312,312,125,312,312,312,312,312,312,312,312,312,312,312,312,312,312,312,125,125,125,125,125},
  };

        // Declareren en initialiseren van de TileEngine klasse om de map aan de world toe te voegen
        TileEngine te = new TileEngine(this, 70, 70, map);
        // Declarenre en initialiseren van de camera klasse met de TileEngine klasse 
        // zodat de camera weet welke tiles allemaal moeten meebewegen met de camera
        Camera camera = new Camera(te);
        
        // Declareren en initialiseren van een main karakter van het spel mijne heet Hero. Deze klasse 
        // moet de klasse Mover extenden voor de camera om te werken
        Hero hero = new Hero();
        
        // Laat de camera een object volgen. Die moet een Mover instatie zijn of een extentie hiervan.
        camera.follow(hero);

        // Alle objecten toevoegen aan de wereld: camera, main karakter en mogelijke enemies
        addObject(camera, 0, 0);
        addObject(hero, 3300, 650);
        //addObject(new Enemy(), 1170, 410);
        addObject(new Health(), 100, 100);
        
        addObject(new Hud(), 100, 150);
        
        // Force act zodat de camera op de juist plek staat.
        camera.act();
        hero.act();

        // Initialiseren van de CollisionEngine zodat de speler niet door de tile heen kan lopen.
        // De collision engine kijkt alleen naar de tiles die de variabele solid op true hebben staan.
        ce = new CollisionEngine(te, camera);
        // Toevoegen van de mover instantie of een extentie hiervan
        ce.addCollidingMover(hero);
        
    }
    @Override
    public void act() {
        ce.update();
       
    }
}
 
    

