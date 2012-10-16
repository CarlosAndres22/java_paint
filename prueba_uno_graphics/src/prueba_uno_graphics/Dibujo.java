/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba_uno_graphics;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.Timer;

/**
 *
 * @author Uriel
 */
public class Dibujo extends Canvas implements MouseListener, MouseMotionListener{
    ArrayList <Integer> positions = new ArrayList<>();
    ArrayList matriz = new ArrayList();
    int uX, uY;
    boolean is_pressed = false ;
    Timer tim = new Timer (100, new ActionListener () 
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            //System.out.println(is_pressed);
        }
    });
    Dibujo()
    {
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        tim.start();
    }
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D draw = (Graphics2D) g;
        draw.setColor(Color.white);
        draw.fillRect(0, 0, this.getWidth(), this.getHeight());
        /*int size = matriz.size();
        if(size>2)
        {
            System.out.println(size);
            for(int i = 1;i<size;i++)
            {
                
                int back_x = (int) ((ArrayList)matriz.get(i - 1)).get(0);
                int back_y = (int) ((ArrayList)matriz.get(i - 1)).get(1);
                int current_x =  (int) ((ArrayList)matriz.get(i)).get(0);
                int current_y =  (int) ((ArrayList)matriz.get(i)).get(1);
                System.out.println(back_x+","+back_y+"."+current_x+"."+current_y);
                g.drawLine(back_x, back_y, current_x, current_y);

            }
        }*/
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
        is_pressed= true;
        int x = e.getX();
        int y = e.getY();
        uX=x;   uY=y;
    }

    @Override
    public void mouseReleased(MouseEvent e) { 
        is_pressed= false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) { }

    @Override
    public void mouseDragged(MouseEvent e) {

            Graphics g=getGraphics();
            Graphics2D draw = (Graphics2D) g;
            int x = e.getX();
            int y = e.getY();
            draw.setStroke(new BasicStroke(10F));
            draw.drawLine(uX, uY, x, y);
            uX = x; uY = y;
            g.dispose();
    }

    @Override
    public void mouseMoved(MouseEvent e) {  
    }

    @Override
    public void mouseClicked(MouseEvent e) {  }
}
