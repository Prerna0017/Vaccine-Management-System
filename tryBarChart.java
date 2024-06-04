package Final;

import java.awt.Graphics;
import java.awt.Dimension;

import javax.swing.JFrame;

public class tryBarChart extends JFrame {
    public int[] indices;
    public int[] values;

    public int minIndex;
    public int maxIndex;
    public int minValue;
    public int maxValue;

    public int x_labels_gap;
    public int y_labels_gap;

    public tryBarChart(int[] indices, int[] values, int minIndex, int maxIndex, int minValue, int maxValue, int x_labels_gap, int y_labels_gap) {
        super();
        this.indices = indices;
        this.values = values;
        this.minIndex = minIndex;
        this.maxIndex = maxIndex;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.x_labels_gap = x_labels_gap;
        this.y_labels_gap = y_labels_gap;

        this.setTitle("Bar Chart");
        this.setSize(new Dimension(512, 512));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        Dimension size = this.getSize();
        int buff =(int) (0.1 * size.getHeight());

        // Y Axis
        g.drawLine(0 + buff, 0, 0 + buff, (int)size.getHeight());

        // X Axis
        g.drawLine(0, (int) size.getHeight() - buff, (int)size.getWidth(), (int) size.getHeight() - buff);

        // X Labels
        double x_step = 1.0 / (this.maxIndex - this.minIndex);
        for(int i = this.minIndex; i < this.maxIndex; i+=this.x_labels_gap) {
            g.drawString(String.valueOf(i), buff + (int) ((size.getWidth() - buff) * i * x_step), (int) size.getHeight() - (buff / 2));
        }
        
        // Y Labels
        double y_step = 1.0 / (this.maxValue - this.minValue);
        for(int i = this.minValue; i < this.maxValue; i+=this.y_labels_gap) {
            g.drawString(String.valueOf(i), buff / 2, (int)(size.getHeight() - buff - (i * y_step * (size.getHeight() - buff))));
        }

        // Bar
        for(int i=0; i < indices.length; i++) {
            int index = indices[i];
            int val = values[i];
            
            double x_step_factor = (double) index / (this.maxIndex - this.minIndex);
            int x_val = buff + (int) (x_step_factor * (size.getWidth() - buff));
            
            double y_step_factor = (double) val / (this.maxValue - this.minValue);
            int bar_height =(int) (y_step_factor * (size.getHeight() - buff));
            
            int bar_width = (int) (0.85 * 1.0 / (this.maxIndex - this.minIndex) * (this.getWidth() - buff)) ;

            g.fillRect(x_val,(int) size.getHeight() - buff - bar_height  , bar_width, bar_height);
        }

    }
}
