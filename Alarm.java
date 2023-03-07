
/**
 * Write a description of class Alarm here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Alarm
{
    private Rectangle alarm;
    private boolean bandera;
    private boolean confirm;
    
    public Alarm (){
        alarm = new Rectangle();
        confirm = true;
    }
    
    public void display(String color, boolean bandera){
        if (bandera){
            alarm.changeColor("red");
            alarm.makeVisible();
        }
    }
    public boolean status(){
        confirm = true; 
        return confirm;
    }
}