package com.PamFields;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Pam on 3/26/2017.
 */
public class CCValidator extends JFrame {
    private JTextField CreditCardTextField;
    private JPanel rootPanel;
    private JButton quitButton;
    private JLabel ValidatorResultsLabel;

    CCValidator(){
        setContentPane(rootPanel);
        pack();
        setSize(new Dimension(350,200));
        setTitle("Credit Card Verifier");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisable(true);


        CreditCardTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ccNumber= CreditCardTextField.getText();
                boolean valid = isVisaCreditCardNumberValid(ccNumber);
                if(valid){
                    ValidatorResultsLabel.setText("Credit Card is Valid");
                }else{
                    ValidatorResultsLabel.setText("Credit Card is not Valid");
                }
            }
        });
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public static boolean isVisaCreditCardNumberValid(String ccNumber) {
        char characters = ccNumber.charAt(0);
        int[] numbersFromccNumbers = new int[ccNumber.length()];
        boolean isValid = false;
        int length = ccNumber.length();
        int sum = 0;

        for(int x = 0; x < ccNumber.length(); ++x) {
            numbersFromccNumbers[x] = ccNumber.charAt(x) - 48;
            boolean number = false;

            for(int i = 0; i <= numbersFromccNumbers.length - 1; ++i) {
                if(i % 2 != 0 && i != 15) {
                    sum += numbersFromccNumbers[i];
                    } else {
                        sum += i*2;
                    int var9 = numbersFromccNumbers[i];
                        if(var9 > 9) {
                            sum += var9 % 10 + var9 / 10;
                    }
                }
            }
        }

        if(sum % 10 == 0 && (length == 13 || length == 16) && numbersFromccNumbers[0] == 4) {
            isValid = true;
        } else {
            isValid = false;
        }

        return isValid;
    }

}
