
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author pcast
 */
public class juego {
    private JTextArea[][] matriz;//acceder a filas y columnas

    public void GridLayout(JPanel tab) {
        int filas = 9;
        int col = 9;
        GridLayout gridLayout = new GridLayout(filas, col);//inicializar el tamaño del grid
        tab.setLayout(gridLayout);
        matriz = new JTextArea[filas][col];//ubicar los text area
        for (int i = 0; i < filas; i++) {//i es fila
            for (int j = 0; j < col; j++) {//j es columna
                JTextArea area = new JTextArea();
                area.setPreferredSize(new Dimension(50, 50));
                matriz[i][j] = area;
                tab.add(area);
               // area.setOpaque(true);
              //  area.setBackground(Color.RED);
                //area.setBorder((Border) Color.BLUE);
            }
        }
    }
}
