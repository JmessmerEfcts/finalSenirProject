package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameForm {
    private JPanel mainPanel;
    private JPanel topPanel;
    private JTextField userInput;
    private JButton submitButton;
    private JButton clearButton;
    private JTextArea gameActivity;

    public GameForm(){
        System.out.println("GuI loaded");
        createAndShow();
    }

    private void createAndShow(){
        JFrame mainFrame = new JFrame("Bad Game");

        addComponents(mainFrame.getContentPane());

        mainFrame.setSize(500, 400);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setResizable(false);
        mainFrame.setVisible(true);

    }


    private void addComponents(Container pane){
        pane.setLayout(null);

        gameActivity = new JTextArea(1, JLabel.CENTER);
        submitButton = new JButton("submit");
        clearButton = new JButton("clear");

        submitButton.setBounds(185, 225, 130, 35);
        clearButton.setBounds(115, 280, 130, 35);

        gameActivity.setEditable(false);
        gameActivity.setBounds(115, 30, 270, 145);
        gameActivity.setFont(new Font("Consolas", Font.BOLD, 12));

        addActionListeners();

        pane.add(gameActivity);
        pane.add(submitButton);
        pane.add(clearButton);
    }

    private void addActionListeners(){
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                userInput.setText("Hello there");
            }
        });

        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                userInput.setText("goodBye");
            }
        });
    }



}
