
import greenfoot.*;
/**
 *
 * @author R. Springer
 */
public class Hero extends Mover {

    private final double gravity;
    private final double acc;
    private final double drag;
    public static int money;
    public String teller;
    public int y = 1;
    public int x;
    public String dir;
    public static int lives = 2;
    public static int key = 0;
    public static boolean hasKeyBlue;
    private Health health1;

    public Hero(Health health1) {
        super();
        this.health1 = health1;
        gravity = 9.8;
        acc = 0.6;
        drag = 0.8;
        setImage("p1.png");

    }

    @Override
    public void act() {
        handleInput();

        velocityX *= drag;
        velocityY += acc;
        getWorld().showText(" X = " + Integer.toString(getX()),950,50);
        getWorld().showText(" Y = " + Integer.toString(getY()),950,75);
        getWorld().showText(" Points = " + Integer.toString(money),950,100);
        getWorld().showText(" Lives = " + Integer.toString(lives),950,125);
        getWorld().showText(" Key = " + Integer.toString(key),950,150);
        getWorld().showText(" World = " + getWorld(),850,175);
        hudHealth();
        if (velocityY > gravity) {
            velocityY = gravity;
        }
        applyVelocity();
        remove();
    }

    public void hudHealth() {
        if (Hero.lives == 1) {
            health1.addKey(new GreenfootImage("hud_heartHalf.png"),200,200);
        }
        if (Hero.lives == 2 || Hero.lives == 3) {
            health1.addKey(new GreenfootImage("hud_heartFull.png"),200,200);
        }   
    }

    public void remove() {
        if(isTouching(CoinGold.class)) {
            removeTouching(CoinGold.class);
            money += 2;}
        if(isTouching(CoinSilver.class)) {
            removeTouching(CoinSilver.class);
            money += 1;
        }

    }

    /*public void kill() {
        if (Hero.lives == 1) {
            if (isTouching (Hero.class)) {
                removeTouching(Hero.class);
                Hero.lives--;

            }
        }
        if (Hero.lives == 2 || Hero.lives == 3) {
            if (isTouching (Hero.class)) {
                setLocation(300,200);
                Hero.lives--;

            }
        }
    }*/

    public boolean ground() {
        Actor ground = getOneObjectAtOffset (0,getImage().getHeight() / 2, Tile.class);
        return ground != null;
    }

    public void handleInput() {
        if (Greenfoot.isKeyDown("space")){
            velocityY = -15;
        }
        if (Greenfoot.isKeyDown("w") && ground() == true) {
            velocityY = -15;
            if (velocityY != 0) {
                setImage("p1_jump.png");
            }
        }
        if (Greenfoot.isKeyDown("a")) {
            velocityX = -5;
            if (velocityY != 0) {
                setImage("p1_jump.png");
                getImage().mirrorHorizontally();
            }
            else if (velocityX < 0) {
                animation();
                getImage().mirrorHorizontally();
            }
        }
        if (Greenfoot.isKeyDown("d")) {
            velocityX = 5;
            if (velocityY != 0) {
                setImage("p1_jump.png");
            }
            else if (velocityX > 0) {
                animation(); 
            }
        }
        if (velocityX == 0 && velocityY == 0) {
            setImage("p1_front.png");
        }
        if (Greenfoot.isKeyDown("s") && velocityX == 0) {
            setImage("p1_duck.png");
        } 
    }

    public int getWidth() {
        return getImage().getWidth();
    }

    public int getHeight() {
        return getImage().getHeight();
    }

    public void animation() {
        String dir = "images/p1_walk/PNG/p1_walk";
        if (y != 12){
            teller = Integer.toString(y);
            y++; 
        } else if (y == 12){
            y = 1;}

        setImage(dir+teller+".png");
    }

}
