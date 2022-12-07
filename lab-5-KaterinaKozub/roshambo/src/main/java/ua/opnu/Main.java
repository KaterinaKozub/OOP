package ua.opnu;

import ua.opnu.MainFrame;

import javax.swing.*;

public class Main
{
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame("Игра"));
    }
}