/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package passwordgeneratorapp;

/**
 *
 * @author HP
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class PasswordGeneratorApp {
    private JTextField lengthTextField;
    private JCheckBox uppercaseCheckBox;
    private JCheckBox lowercaseCheckBox;
    private JCheckBox digitsCheckBox;
    private JCheckBox symbolsCheckBox;
    private JButton generateButton;
    private JLabel passwordLabel;

    public PasswordGeneratorApp() {
        JFrame frame = new JFrame("Password Generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLayout(new FlowLayout());

        // Create UI elements
        JLabel lengthLabel = new JLabel("Password Length:");
        lengthTextField = new JTextField(10);

        uppercaseCheckBox = new JCheckBox("Include Uppercase");
        lowercaseCheckBox = new JCheckBox("Include Lowercase");
        digitsCheckBox = new JCheckBox("Include Digits");
        symbolsCheckBox = new JCheckBox("Include Symbols");

        generateButton = new JButton("Generate Password");
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generatePassword();
            }
        });

        passwordLabel = new JLabel();

        // Add UI elements to the frame
        frame.add(lengthLabel);
        frame.add(lengthTextField);
        frame.add(uppercaseCheckBox);
        frame.add(lowercaseCheckBox);
        frame.add(digitsCheckBox);
        frame.add(symbolsCheckBox);
        frame.add(generateButton);
        frame.add(passwordLabel);

        frame.setVisible(true);
    }

    private void generatePassword() {
        int length = Integer.parseInt(lengthTextField.getText());
        boolean includeUppercase = uppercaseCheckBox.isSelected();
        boolean includeLowercase = lowercaseCheckBox.isSelected();
        boolean includeDigits = digitsCheckBox.isSelected();
        boolean includeSymbols = symbolsCheckBox.isSelected();

        String password = generateRandomPassword(length, includeUppercase, includeLowercase, includeDigits, includeSymbols);
        passwordLabel.setText("Generated Password: " + password);
    }

    private String generateRandomPassword(int length, boolean includeUppercase, boolean includeLowercase,
                                          boolean includeDigits, boolean includeSymbols) {
        StringBuilder password = new StringBuilder(length);
        Random random = new Random();

        String uppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String symbols = "!@#$%^&*()_+-=[]{}|;:,.<>?";

        String characters = "";
        if (includeUppercase)
            characters += uppercaseLetters;
        if (includeLowercase)
            characters += lowercaseLetters;
        if (includeDigits)
            characters += digits;
        if (includeSymbols)
            characters += symbols;

        if (characters.isEmpty()) {
            return "";
        }

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            password.append(characters.charAt(randomIndex));
        }

        return password.toString();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PasswordGeneratorApp();
            }
        });
    }
}
