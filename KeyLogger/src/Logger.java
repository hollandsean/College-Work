import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileWriter;

public class Logger implements KeyListener 
{
 
    // Handle the key typed event from the text field.
    public void keyTyped(KeyEvent e) 
    {
	    display(e, "KEY TYPED: ");
    }
    // Handle the key-pressed event from the text field.
    public void keyPressed(KeyEvent e) 
    {
	    display(e, "KEY PRESSED: ");
    }
    //Handle the key-released event from the text field.
    public void keyReleased(KeyEvent e)
    {
	    display(e, "KEY RELEASED: ");
    }
   
    private void display(KeyEvent e, String keyStatus)
    {
	    int id = e.getID();
	    String keyString;
	    if (id == KeyEvent.KEY_TYPED) 
	    {
		    char c = e.getKeyChar();
		    keyString = "key character = '" + c + "'";
	    } 
	    else 
	    {
		    int keyCode = e.getKeyCode();
		    keyString = "key code = " + keyCode+ " ("+ KeyEvent.getKeyText(keyCode)+ ")";
	    }
	    
		    try
		    {
		    	File file = new File("KeyLogFile1.txt");
		    	
		    	FileWriter writer = new FileWriter(file);
		    	writer.write(keyString);
		    	writer.close();
		    } 
		    catch(Exception e1) 
		    {
		        e1.printStackTrace();
		    }
	    	
	}
    public static void main(String [] args)
    {
        Logger newLog = new Logger();
    }
}