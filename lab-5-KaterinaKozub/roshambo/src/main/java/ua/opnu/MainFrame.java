package ua.opnu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MainFrame extends JFrame implements ActionListener
{

    // Constructor
    public MainFrame(String title) throws HeadlessException
    {

        super(title);

        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));

        ((JComponent) getContentPane()).
                setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.WHITE));

        JButton rockButton = new JButton("Камень");
        rockButton.addActionListener(this);
        rockButton.setActionCommand("rock");

        JButton paperButton = new JButton("Бумага");
        paperButton.addActionListener(this);
        paperButton.setActionCommand("paper");

        JButton scissorsButton = new JButton("Ножницы");
        scissorsButton.addActionListener(this);
        scissorsButton.setActionCommand("scissors");

        this.add(rockButton);
        this.add(paperButton);
        this.add(scissorsButton);

        this.pack();
        this.setVisible(true);

    }

    // Returns randomly generated object
    private GameShape generateShape()
    {
        int random = new Random().nextInt(3);

        return randomShape(new GameShape(), random);
    }

    // Returns shape depending on generated index
    private GameShape randomShape(GameShape shape, int random)
    {

        switch (random)
        {

            case 0:
                shape = new Rock();
                return shape;

            case 1:
                shape = new Paper();
                return shape;

            case 2:
                shape = new Scissors();
                return shape;

        }

        return shape;

    }

    // Returns win value indexes
    private int checkWinner(GameShape player, GameShape computer)
    {

        if (player instanceof Rock && computer instanceof Scissors) {return 1;}

        else if (player instanceof Scissors && computer instanceof Paper) { return 1;}

        else if (player instanceof Paper && computer instanceof Rock) {  return 1;}

        else if (player instanceof Scissors && computer instanceof Rock) { return -1;}

        else if (player instanceof Paper && computer instanceof Scissors) { return -1;}

        else if (player instanceof Rock && computer instanceof Paper) { return -1;}

        return 0;

    }

    // Run game action
    @Override
    public void actionPerformed(ActionEvent e)
    {

        // Generate computer/player step
        GameShape computerShape = generateShape();
        GameShape playerShape = new GameShape();


        // Read the button is pressed and define figure
        switch (e.getActionCommand())
        {

            case "rock":
                playerShape = new Rock();
                break;

            case "paper":
                playerShape = new Paper();
                break;

            case "scissors":
                playerShape = new Scissors();
                break;

        }

        // Check if we have winner
        int gameResult = checkWinner(playerShape, computerShape);

        // Getting message for player
        String message = "Player shape: " + playerShape + ". Computer shape: " + computerShape + ". ";
        switch (gameResult)
        {

            case -1:
                message += "Computer has won!";
                break;

            case 0:
                message += "It's a tie!";
                break;

            case 1:
                message += "Player has won!";

        }

        // Print message
        JOptionPane.showMessageDialog(null, message);

    }

}