package clock;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Clock extends JPanel implements ActionListener {

    public static JFrame jframe;
    public Timer timer = new Timer(100, this);
    public Dimension dim;
    public static int theWidth, theHeight;
    public Calendar calendar;
    public Container c;
    public Color secColor;
    public Color minColor;
    public Color hourColor;
    public Random r;

    public Clock() {
        dim = Toolkit.getDefaultToolkit().getScreenSize();
        theWidth = (int) (dim.width / 2.4);
        theHeight = (int) (dim.height / 1.5);
        jframe = new JFrame("Particle Clock");
        c = jframe.getContentPane();
        jframe.add(this);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.getContentPane().setPreferredSize(new Dimension(800, 700));
        jframe.pack();
        jframe.setVisible(true);
        secColor = new Color(255, 0, 0);
        minColor = new Color(0, 255, 0);
        hourColor = new Color(0, 0, 255);
        r = new Random();
        timer.start();
    }

    public static void main(String[] args) {
        Clock clock = new Clock();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        super.paintComponent(g2d);
        g2d.rotate(-Math.PI / 2, theWidth / 2, theHeight / 2);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.BLACK);
        g2d.fillRect(jframe.getLocation().x - theHeight, jframe.getLocation().y - theWidth, jframe.getWidth() * 3,
                jframe.getHeight() * 3);
        calendar = GregorianCalendar.getInstance();
        g2d.setStroke(new BasicStroke(5));
        g2d.setColor(secColor);
        g2d.drawArc(theWidth / 4, theHeight / 4, theWidth / 2, theHeight / 2, 0,
                (int) -Math.toDegrees(Math.PI / 30 * calendar.get(Calendar.SECOND)));
        g2d.setColor(minColor);
        g2d.drawArc((theWidth / 4) - 10, (theHeight / 4) - 10, (theWidth / 2) + 20, (theHeight / 2) + 20, 0,
                (int) -Math.toDegrees(Math.PI / 30 * calendar.get(Calendar.MINUTE)));
        g2d.setColor(hourColor);
        g2d.drawArc((theWidth / 4) - 20, (theHeight / 4) - 20, (theWidth / 2) + 40, (theHeight / 2) + 40, 0,
                (int) -Math.toDegrees(Math.PI / 6 * calendar.get(Calendar.HOUR)));
    }

    public void actionPerformed(ActionEvent e) {
        // addColor(secColor);
        // addColor(minColor);
        // addColor(hourColor);
        secColor = new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));
        minColor = new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));
        hourColor = new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));
        this.repaint();
    }

    public void addColor(Color c) {

        // if (c.getRed() == 255) {
        // if (c.getGreen() == 254) {
        // secColor = new Color(255, 0, 0);
        // } else {
        // secColor = new Color(255, c.getGreen() + 50, 0);
        // }
        // } else if (c.getGreen() == 255) {
        // if (c.getBlue() == 254) {
        // minColor = new Color(0, 255, 0);
        // } else {
        // minColor = new Color(0, 255, c.getBlue() + 50);
        // }
        // } else {
        // if (c.getRed() == 254) {
        // hourColor = new Color(0, 0, 255);
        // } else {
        // hourColor = new Color(c.getRed() + 50, 0, 255);
        // }
        // }
    }

}