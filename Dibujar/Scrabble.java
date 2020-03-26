import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Crear una clase que permita que el usuario dibuje lineas on el raton
 * Devuelve coordenadas en X e Y donde el usuario solto el raton
 */
 
 public class Scrabble extends JFrame implements MouseMotionListener
{
   private JTextField txtField;
   private JPanel panel;
   int posOriginalX = 50;
   int posOriginalY = 50;
   
   public static void main ()
   {
       Scrabble marco = new Scrabble();
       marco.setSize(400,300);
       //^^instanciar la ventana
       
       marco.createInterfaz();
       marco.setVisible(true);
       
    
    }
   public void createInterfaz()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());//an established layout
        panel = new JPanel();
        panel.setPreferredSize(new Dimension (100,100));
        
        panel.setBackground(Color.pink);
        window.add(panel);
        panel.addMouseMotionListener(this);//the panel should be in listener
        txtField = new JTextField(8);
        window.add(txtField);
    }
   public void mouseDragged(MouseEvent event)
    {
        int posNewX = event.getX();
        int posNewY = event.getY();
        Graphics paper = panel.getGraphics();
        paper.drawLine(posOriginalX, posOriginalY,posNewX,posNewY);
        
        posOriginalX = posNewX;
        posOriginalY = posNewY;
        txtField.setText("x = " + Integer.toString(event.getX()) + " y = " + Integer.toString(event.getY()));
        
    }
    public void mouseMoved(MouseEvent event)
    {
        int posNewX = event.getX();
        int posNewY = event.getY();
        
        posOriginalX = posNewX;
        posOriginalY = posNewY;
        
    }
}

