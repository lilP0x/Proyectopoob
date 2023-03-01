 

import java.awt.geom.Line2D;
import java.awt.*;
 
/**
 * Write a description of class Line here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Line
{
    private boolean isVisible = false;
    private String color = "red";
    private Line2D line;
    
    public void cambioColor(String newColor){
        erase();
        color = newColor;
        draw();
    }
    public Line(double X1,double Y1,double X2,double Y2){
        line = new Line2D.Double(X1,Y1,X2,Y2);
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
    public void draw() {
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, color, line);
            canvas.wait(10);
        }
    }
    /*
     * Erase the rectangle on screen.
     */
    public void erase(){
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

