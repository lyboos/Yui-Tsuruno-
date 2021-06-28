import javax.swing.*;
import java.awt.*;

public class simpleAnimation {
    int x=75,y=75;

    public static void main(String[] args) {
        simpleAnimation don=new simpleAnimation();
        don.go();
    }

    public void go(){
        JFrame frame=new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        simplepanel panel=new simplepanel();
        frame.getContentPane().add(panel);
        frame.setSize(400,400);
        frame.setVisible(true);
        for (int i = 0; i < 130; i++) {
            x++;
            y++;
            panel.repaint();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class simplepanel extends JPanel{
        public void paintComponent(Graphics g) {
            g.setColor(Color.gray);
            g.fillOval(0,0,this.getWidth(),this.getHeight());
            g.setColor(Color.green);
            g.fillOval(x,y,40,40);
//            Graphics2D g2d=(Graphics2D)g;
//            int red=(int)(Math.random()*255);
//            int green=(int)(Math.random()*255);
//            int blue=(int)(Math.random()*255);
//            Color initcolor=new Color(red,green,blue);
//            red=(int)(Math.random()*255);
//            green=(int)(Math.random()*255);
//            blue=(int)(Math.random()*255);
//            Color endcolor=new Color(red,green,blue);
//            GradientPaint gp=new GradientPaint(70,70,initcolor,150,150,initcolor);
//            g2d.setPaint(gp);
//            g.fillOval(x,y,100,100);
        }
    }
}
