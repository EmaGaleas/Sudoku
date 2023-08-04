
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author pcast
 */
public class juego {
         private JButton[][] matrizLabel;

    public void GridLayout(JPanel tab) {
        int filas = 9;
        int col = 9;
        GridLayout gridLayout = new GridLayout(filas, col);
        tab.setLayout(gridLayout);
        matrizLabel = new JButton[filas][col];
    }
}
