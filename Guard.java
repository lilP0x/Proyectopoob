
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
    
    private Guard(){
        guard = new Rectangle();
    
    }
    
    /**
     * This method displays the guard in a position given
     * @Parameters x , y coordinates 
     * @Return
     */
    private void arriveGuard(int x, int y){
        String colorGuard = "black";
        a = new Alarm();
        
        if (a.status()){
    //        for(Line b:factory){
           //     colorGuard = b.getColor();
            }
            guard.changeColor(colorGuard);
            guard.moveHorizontal(x); //70
            guard.moveVertical(y); //10
            guard.makeVisible();
        }
    }
    
    
