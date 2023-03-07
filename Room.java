import java.util.HashMap;
import java.util.Map;
import java.awt.Polygon;

/**
 * Write a description of class Room here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Room
{
    private boolean isVisible = false;
    private String color = "red";
    private Polygon room;
    
    public Room(String color, int matriz[][]){
        int xpoints[] = new int[matriz.length];
        int ypoints[] = new int[matriz.length];
        for (int i = 0; i < matriz.length; i++) {
            xpoints[i] = matriz[i][0];
            ypoints[i] = matriz[i][1];  
        }
        room = new Polygon(xpoints,ypoints, matriz.length);
     }
    public void cambioColor(String newColor){
        erase();
        color = newColor;
        draw();
    }
    public void makeVisible(){
        isVisible = true;
        draw();
    }
    /**
     * Make this rectangle invisible. If it was already invisible, do nothing.
     */
    public void makeInvisible(){
        erase();
        isVisible = false;
    }
    private void draw() {
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, color, room);
            canvas.wait(10);
        }

    }
    public boolean contains(int x, int y) {
        boolean error;
        error = room.contains(x,y);
        return error;
    }
    /*
     * Erase the rectangle on screen.
     */
    private void erase(){
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
    }
    public void setColor( String newColor){
        erase();
        color = newColor;
        draw();
    }
    public String getColor(){
        return color;
    }
}
