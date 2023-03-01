
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
    public Line lineR;
    private ArrayList<Line> factory;
    private boolean ok = true;
    private Rectangle guard;
    private Circle sculture;
    private Rectangle alarm;
    private ArrayList<Line> guardTracker;
    private Polygon room;
    private Point punto;
    
    /**
     * The contructor of this class initialize all the objects that the class
     * needs
     * @Parameters color , matrix 
     * @Return
     */
    public Gallery(String color, int matriz[][]){
        factory = new ArrayList();
        guardTracker = new ArrayList();
        isVisible = false;
        createRoom(color, matriz);
        guard = new Rectangle();
        sculture = new Circle();
        alarm = new Rectangle();
    }

    /**
     * This method create the rooms out of the vertix provided in the parameters
     * @Parameters color , matrix 
     * @Return
     */
    private void createRoom(String color, int matriz[][]){
        int x1 = 0,x2 = 0, y1 = 0,y2 = 0, i;
        int xpoints[] = new int[matriz.length-1];
        int ypoints[] = new int[matriz.length-1];
        for (i = 0; i < matriz.length-1; i++) {
            x1 = matriz[i][0];
            y1 = matriz[i][1];
            xpoints[i] = x1;
            ypoints[i] = y1;
            x2 = matriz[i+1][0];
            y2 = matriz[i+1][1];
            factory.add(new Line(x1,y1,x2,y2));
        } 
        room = new Polygon(xpoints,ypoints, matriz.length-1);
        for(Line a:factory){
            a.cambioColor(color);
        }
    }
    /**
     * This method make visible the objects in the array factory
     * @Parameters
     * @Return
     */
    public void makeVisible(){
        isVisible = true;
        for(Line a:factory){
            a.makeVisible();
        }
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
    public void displaySculture(int x, int y){
        String colorSculture = "black";
        for(Line a:factory){
            colorSculture = a.getColor();
        }
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
    public void moveGuard(int x, int y){
        int position[] = new int[2];
        position = getPositionGuard();
        punto = new Point(x,y);
        boolean error;
        error = room.contains(punto);   
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
    /**
     * This method displays the guard in a position given
     * @Parameters x , y coordinates 
     * @Return
     */
    public void arriveGuard(int x, int y){
        String colorGuard = "black";
        boolean a;
        a = alarm.getVisible();
        if (a == true){
            for(Line b:factory){
                colorGuard = b.getColor();
            }
            guard.changeColor(colorGuard);
            guard.moveHorizontal(x); //70
            guard.moveVertical(y); //10
            guard.makeVisible();
        }
    }
    /**
     * Make objects invisible. If it was already invisible, do nothing.
     * @Parameters
     * @Return
     */
    public void makeInvisible(){
        for(Line a:factory){
            a.makeInvisible();
        }
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
