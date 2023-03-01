
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
    
    Alarm (){
    alarm = new Rectangle();
    }
    
    public void alarm(String color, boolean bandera){
        if (bandera){
            alarm.changeColor("red");
            alarm.makeVisible();  
        }
    }
    public boolean status(){
    return bandera;
    }
}