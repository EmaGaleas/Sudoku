
import java.awt.Color;
import java.awt.Dimension;
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
    private JLabel[][] matrizLabel;

    public void GridLayout(JPanel tab) {
        int filas = 9;
        int col = 9;
        GridLayout gridLayout = new GridLayout(filas, col);
        tab.setLayout(gridLayout);
        matrizLabel = new JLabel[filas][col];
         for (int i = 0; i < filas; i++) {
            for (int j = 0; j < col; j++) {
                JLabel label = new JLabel();
                label.setPreferredSize(new Dimension(50, 100));
                matrizLabel[i][j] = label;
                tab.add(label);
                label.setBackground(Color.red);
            }
         }
    }
}
