package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ColorModel;
import java.io.IOException;

public class Window extends JFrame {



    public void paintWall(Graphics g) throws IOException {



        String path = "U://java_roguelike/java_roguelike/java_roguelike/src/wall.jpeg";
        Image image = ImageIO.read(new java.io.File(path));
        Graphics2D graphics2D = (Graphics2D) g;
        for (int i = 0; i <this.getWidth() ; i+=50) {
            graphics2D.drawImage(image, i,10,null);
            graphics2D.drawImage(image, i,getHeight()-50,null);
        }

        for (int i = 0; i <getHeight() ; i+=50) {
            graphics2D.drawImage(image, 0,i, null);
            graphics2D.drawImage(image, getWidth()-50,i, null);
        }


    }




    public void paint(Graphics g)
    {
        super.paint(g);
        for (int i = 0; i <this.getWidth(); i+=50) {

            g.drawLine(i,10,i,this.getHeight());
            g.drawLine(0,i,this.getWidth(),i);
        }

        try {
            paintWall(getGraphics());
        } catch (IOException e1) {
            e1.printStackTrace();
        }


    }

    private void fillRect(Graphics g, MouseEvent event){

        Point point = event.getPoint();


        int x=0, y=0;
        x=(point.x+5)/50;
        y=(point.y+29)/50;

        x*=50;
        y*=50;

        Rectangle rectangle = new Rectangle();
        rectangle.setBounds(x,y,50,50);




        Graphics2D graphics2D = (Graphics2D) g;


      if (event.getClickCount()==2){
         graphics2D.clearRect(x,y,50,50);
         paint(getGraphics());
      } else graphics2D.fill(rectangle);









    }


    Window(){
        super("My Window");
        setVisible(true);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);

        JPanel panel = new MyPanel();
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        panel.addMouseListener(new myMouseListener());





        setContentPane(panel);



    }


    private class MyPanel extends JPanel {
        public MyPanel() {
            setLayout(null);

        }
    }


    private class myMouseListener implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            fillRect(getGraphics(), e);

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}
