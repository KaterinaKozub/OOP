package ua.opnu.view;

import ua.opnu.model.DrawShape;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class DrawFrame extends JFrame
{

    // Painting space
    private PaintSurface surface;

    // GUI constructor
    public DrawFrame(String title)
    {

        // Call base class
        super(title);

        // Kill process when window is closed
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Set layout manager, it manages the layout of figures on frame
        this.setLayout(new BorderLayout());

        // Add upper panel with buttons
        this.add(setButtonPanel(), BorderLayout.NORTH);

        // Object of painting space
        surface = new PaintSurface();

        // Add painting space to frame
        this.add(surface, BorderLayout.CENTER);

        // Auto aligning the frame to see all elements on it
        this.pack();

        // Frame is visible when TRUE
        this.setVisible(true);

    }

    // Tune upper panel with buttons
    private JPanel setButtonPanel()
    {

        // Create panel with buttons
        JPanel buttonPanel = new JPanel(true);

        // Set layout left to right
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Set background color of panel
        buttonPanel.setBackground(Color.CYAN);

        // Set border color of panel
        buttonPanel.setBorder(new LineBorder(Color.BLACK, 2));


        /* Add buttons to panel */

        // **Rectangle button
        BigTextButton rect = new BigTextButton("Rectangle");

        // Notify surface that it draws rectangles now
        rect.addActionListener(e -> { surface.setShapeType(DrawShape.SHAPE_RECTANGLE); });

        // Add button to the panel
        buttonPanel.add(rect);


        // **Rounded rectangle button
        BigTextButton rounded_rect = new BigTextButton("Rounded rect.");

        // Notify surface that it draws rounded rectangles now
        rounded_rect.addActionListener(e -> { surface.setShapeType(DrawShape.SHAPE_ROUNDED_RECT); });

        // Add button to the panel
        buttonPanel.add(rounded_rect);


        // **Ellipse button
        BigTextButton ellipse = new BigTextButton("Ellipse");

        // Notify surface that it draws ellipses now
        ellipse.addActionListener(e -> { surface.setShapeType(DrawShape.SHAPE_ELLIPSE); });

        // Add button to the panel
        buttonPanel.add(ellipse);


        // **Clear button
        BigTextButton clear = new BigTextButton("Clear");

        // Notify surface that it must be cleared
        clear.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) { surface.clear();}
        });

        // Add button to the panel
        buttonPanel.add(clear);


        // Return full panel
        return buttonPanel;

    }

}

