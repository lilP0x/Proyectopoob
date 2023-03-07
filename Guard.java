
import java.awt.geom.Line2D;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.Polygon;

/**
 * Write a description of class Guard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Guard
{

    private Rectangle guard;
    private boolean isVisible;
    private Alarm a;
    private boolean bandera = false;
    private Room room;
    public Point punto;
    public ArrayList<Line> guardTracker;
    private int xPosition;
    private int yPosition;
    
    public Guard(){
        guard = new Rectangle();
        a = new Alarm();
    }
    
    /**
     * This method displays the guard in a position given
     * @Parameters x , y coordinates 
     * @Return
     */
    public void arriveGuard(int x, int y){
        String colorGuard = "black";
        bandera = a.status();
        if (bandera){
            guard.changeColor("white");
            guard.moveHorizontal(x); //70
            guard.moveVertical(y); //10
            guard.makeVisible();
        }
    }
    public int[] getPosition() {
        int position[] = new int[2];
        position[0] = guard.getPositionX(); 
        position[1] = guard.getPositionY();
        
        return position;
    }
    public void moveGuard(int x, int y) {
        int position[] = new int[2];
        position = getPosition();
        punto = new Point(x,y);
        boolean error;
        error = room.contains(x, y);   
        if (position[0] != x && error){
            guard.moveHorizontal(x);
        }
        if (position[1] != y && error){
            guard.moveVertical(y);
        }
        if (error){
            guardTracker.add(new Line(position[0],position[1],x,y));
        }
        if(error){
            for(Line a:guardTracker){
                a.makeVisible();
            }
        }
    }
    public int getPositionX(){
        return xPosition;
    }
    public int getPositionY(){
        return yPosition;
    }
    public void makeInvisible() {
        guard.makeInvisible();
    }
}
 