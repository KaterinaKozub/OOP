package ua.opnu.view;


import ua.opnu.model.DrawShape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PaintSurface extends JComponent
{

    // Array of shapes on surface
    private List<DrawShape> shapes = new ArrayList<>();

    // Current figure shape
    private int shapeType;

    // Coordinates of mouse in start/end of the dragging
    private Point startDrag, endDrag;

    // Colors
    private List<Color> colors = Arrays.asList(Color.YELLOW, Color.MAGENTA, Color.CYAN, Color.RED, Color.BLUE, Color.PINK);


    public PaintSurface()
    {

        // Default figure type
        shapeType = 0;

        // Set Surface size
        super.setPreferredSize(new Dimension(400, 400));

        // Set action on mouse click/release
        this.addMouseListener(new MouseAdapter()
        {

            // Mouse button clicked
            public void mousePressed(MouseEvent e)
            {

                // Save coordinates of cursor relatively to surface
                // This moment end and start is the same point
                startDrag = new Point(e.getX(), e.getY());
                endDrag = startDrag;

                // Repaint with changes
                repaint();

            }

            // Mouse button released
            public void mouseReleased(MouseEvent e)
            {

                DrawShape shape = DrawShape.newInstance(shapeType);

                // Set start/end point to shape
                shape.setStartPoint(startDrag);
                shape.setEndPoint(endDrag);

                // Add new figure into array
                shapes.add(shape);

                // Clear start/end
                startDrag = null;
                endDrag = null;

                // Repaint window
                repaint();

            }

        });

        // Mouse dragged
        this.addMouseMotionListener(new MouseMotionAdapter()
        {

            @Override
            public void mouseDragged(MouseEvent e)
            {

                // Save new end point and repaint window
                endDrag = new Point(e.getX(), e.getY());
                repaint();

            }

        });
    }

    // Define the type of figure
    public void setShapeType(int type)
    {
        this.shapeType = type;
    }


    public void paint(Graphics g)
    {

        Graphics2D g2 = (Graphics2D) g;

        // 1. Set smoothing
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // 2. Paint background grid
        paintBackgroundGrid(g2);

        // 3. Set size of frame border
        g2.setStroke(new BasicStroke(2));

        // 4. Make background translucent
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.50f));

        // Draw every figure on the surface
        shapes.forEach(s ->
        {

            // Set color of figure border
            g2.setPaint(Color.BLACK);

            // Draw figure
            g2.draw(s.getShape());

            // Set random color
            g2.setPaint(colors.get(shapes.indexOf(s) % 6));

            // Paint this color
            g2.fill(s.getShape());

        });


        // If repaint happens the moment we are drawing figure
        // draw grey border of chosen figure
        if (startDrag != null && endDrag != null)
        {

            g2.setPaint(Color.LIGHT_GRAY);

            DrawShape shape = DrawShape.newInstance(shapeType);

            g2.draw(shape.getShape(startDrag, endDrag));

        }

    }


    // Draw grid
    private void paintBackgroundGrid(Graphics2D g2)
    {

        // Set grid color
        g2.setPaint(Color.LIGHT_GRAY);


        // Draw horizontal lines
        for (int i = 0; i < getSize().width; i += 10)
        {
            Shape line = new Line2D.Float(i, 0, i, getSize().height);
            g2.draw(line);
        }

        // Draw vertical lines
        for (int i = 0; i < getSize().height; i += 10)
        {
            Shape line = new Line2D.Float(0, i, getSize().width, i);
            g2.draw(line);
        }

    }


    // Clear surface
    public void clear()
    {
        shapes.clear();
        repaint();
    }

}