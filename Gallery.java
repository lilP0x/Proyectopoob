import java.util.HashMap;
import java.util.Map;
import java.awt.geom.Line2D;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.Polygon;

/**
 * This class makes a gallery made out of rooms. Also display in those gallerys
 * a sculture and a guard. 
 *
 * @author Andres Felipe Montes , Juan Pablo Fernandez
 * @version 1.8
 */

public class Gallery
{
    private boolean isVisible;
    private String color = "black";
    private boolean ok = true;
    private Guard guard;
    private Circle sculture;
    private Rectangle alarm;
    public ArrayList<Line> guardTracker;
    private Room room;
    public Point punto;
    public static HashMap <String, Room> Habitaciones = new HashMap <String, Room> ();
    
    /**
     * The contructor of this class initialize all the objects that the class
     * needs
     * @Parameters color , matrix 
     * @Return
     */
    public Gallery(String color, int matriz[][]){
        guardTracker = new ArrayList();
        isVisible = false;
        createRoom(color, matriz);
        guard = new Guard();
        sculture = new Circle();
        alarm = new Rectangle();
    }

    /**
     * This method create the rooms out of the vertix provided in the parameters
     * @Parameters color , matrix 
     * @Return
     */
    private void createRoom(String color, int matriz[][]){
        room = new Room(color,matriz);
        Habitaciones.put(color,room);
    }
    /**
     * This method determines the position of the sculture 
     * @Parameters
     * @Return position of the sculture
     */
    public int[] getPositionSculture(){
        int position[] = new int[2];
        position[0] = sculture.getPositionX(); 
        position[1] = sculture.getPositionY();
        
        return position;
    }
    /**
     * This method determines the position of the guard 
     * @Parameters
     * @Return Position of the Guard  
     */
        public int[] getPositionGuard(){
        int position[] = new int[2];
        position[0] = guard.getPositionX(); 
        position[1] = guard.getPositionY();
        
        return position;
    }
    /**
     * This method display one sculture in a specific location
     * @Parameters x , y coordinates 
     * @Return
     */
    public void displaySculture(int x, int y, String color){
        Room habitacion;
        habitacion = Habitaciones.get(color);
        String colorSculture = habitacion.getColor();
        sculture.changeColor(colorSculture);
        sculture.moveHorizontal(x); //70
        sculture.moveVertical(y); //10
        sculture.makeVisible();
    }
    /**
     * This method moves the guard and at the same time leaves the track of
     * the guard
     * @Parameters x , y coordinates 
     * @Return
     */
    public void moveGuard(String color, int x, int y){
        guard.moveGuard(x,y);
    }
    /**
     * This method displays the guard in a position given
     * @Parameters x , y coordinates 
     * @Return
     */
    public void arriveGuard(String color, int x, int y){
        Room habitacion;
        boolean a;
        a = alarm.getVisible();

        habitacion = Habitaciones.get(color);
        String colorGuard = habitacion.getColor();
        guard.arriveGuard(x,y);
        
    }
    /**
     * This method make visible the objects in the array factory
     * @Parameters
     * @Return
     */
    public void makeVisible(String color){
        isVisible = true;
        Room habitacion;
        habitacion = Habitaciones.get(color);
        habitacion.makeVisible();
    }
    /**
     * Make objects invisible. If it was already invisible, do nothing.
     * @Parameters
     * @Return
     */
    public void makeInvisible(String color){
        Room habitacion;
        habitacion = Habitaciones.get(color);
        habitacion.makeInvisible();
        isVisible = false;
        guard.makeInvisible();
        sculture.makeInvisible();
    }
    public void alarm(String color, boolean bandera){
        if (bandera == true){
            alarm.changeColor("red");
            alarm.makeVisible();  
        }
    }
    /**
     * Finish the simulation
     * @Parameters
     * @Return
     */

    public void finish(){
        System.exit(0);
    }
    public void ok(){
        
    }
}
