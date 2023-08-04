
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
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
    private JTextField[][] matriz;//acceder a filas y columnas

    public void GridLayout(JPanel tab) {
        int filas = 9;
        int col = 9;
        GridLayout gridLayout = new GridLayout(filas, col);//inicializar el tamaño del grid
        tab.setLayout(gridLayout);
        matriz = new JTextField[filas][col];//ubicar los text area
        for (int i = 0; i < filas; i++) {//i es fila
            for (int j = 0; j < col; j++) {//j es columna
                JTextField area = new JTextField();
                area.setPreferredSize(new Dimension(50, 50));
                matriz[i][j] = area;
                tab.add(area);
                
            }
        }
    }

    public void cuadro1(){//columna 0,1 y 2 y fila 0, 1 y 2
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matriz[i][j].setBackground(Color.WHITE);
            }
        }
    }
    public void cuadro2(){//columna 3,4 y 5 y fila 0, 1 y 2
        for (int i = 0; i < 3; i++) {
            for (int j = 3; j < 6; j++) {
                matriz[i][j].setBackground(Color.lightGray);
            }
        }
    }
    public void cuadro3(){//columna 6,7 y 8 y fila 0, 1 y 2
        for (int i = 0; i < 3; i++) {
            for (int j = 6; j < 9; j++) {
                matriz[i][j].setBackground(Color.WHITE);
            }
        }
    }
    public void cuadro4(){//columna 0,1 y 2 y fila 3,4 y 5
        for (int i = 3; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                matriz[i][j].setBackground(Color.lightGray);
            }
        }
    }
    public void cuadro5(){//columna 3,4 y 5 y fila 3,4 y 5
         for (int i = 3; i < 6; i++) {
            for (int j = 3; j < 6; j++) {
                matriz[i][j].setBackground(Color.WHITE);
            }
        }
    }
    public void cuadro6(){//columna 6,7 y 8  y fila 3,4 y 5
        for (int i = 3; i < 6; i++) {
            for (int j = 6; j < 9; j++) {
                matriz[i][j].setBackground(Color.lightGray);
            }
        }
    }
    public void cuadro7(){//columna 0,1 y 2 y fila 6, 7 y 8
        for (int i = 6; i < 9; i++) {
            for (int j = 0; j < 3; j++) {
                matriz[i][j].setBackground(Color.WHITE);
            }
        }
    }
    public void cuadro8(){//columna 3,4 y 5 y fila 6, 7 y 8
        for (int i = 6; i < 9; i++) {
            for (int j = 3; j < 6; j++) {
                matriz[i][j].setBackground(Color.lightGray);
            }
        }
    }
    public void cuadro9(){//columna 6,7 y 8 y fila 6, 7 y 8
        for (int i = 6; i < 9; i++) {
            for (int j = 6; j < 9; j++) {
                matriz[i][j].setBackground(Color.WHITE);
            }
        }
    }  
}
