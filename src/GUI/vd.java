package GUI;
import javax.swing.*;

import java.awt.Font;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class vd {
}

 class JTextFieldExample {

    public static void main(String[] agrs) {
        JFrame mainFrame = new JFrame("JtextField Exampke");

        mainFrame.setSize(400, 150);
        JPanel panel = new JPanel();
        JTextField jTextField = new JTextField(10);
        jTextField.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent event) {
                System.out.println(jTextField.getText()+"1");
            }

            @Override
            public void keyReleased(KeyEvent event) {
                System.out.println(jTextField.getText()+"2");
            }

            @Override
            public void keyPressed(KeyEvent event) {
                System.out.println(jTextField.getText() + "3");
            }
        });
        panel.add(jTextField);
        jTextField.requestFocusInWindow();
        mainFrame.add(panel);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);


    }
}
