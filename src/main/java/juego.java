
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import java.util.Random;

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
    Random random= new Random();

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
    private void mostrarInformacionPieza() {
        if (matriz==null) {
            JOptionPane.showMessageDialog(null, "TE HAS RENDIDO", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }
 
    public boolean repetidoEnCuadro(int numero, int fila, int columna) {
        for (int i = fila; i < fila + 3; i++) {
            for (int j = columna; j < columna + 3; j++) {
                String numeroFIND = matriz[i][j].getText().trim();

                if (numeroFIND.equals(Integer.toString(numero))) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean repetidoEnFilaColumna(int numero, int fila, int columna) {
        for (int i = 0; i < 9; i++) {
            if (matriz[fila][i].getText().equals(Integer.toString(numero)) || 
                matriz[i][columna].getText().equals(Integer.toString(numero))) { 
                return true;
            }
        }
        return false;
    }

    public void cuadro1() {
        Random random = new Random();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int randomNumber;
                boolean isRepeated;

                do {
                    randomNumber = random.nextInt(9) + 1;
                    isRepeated = repetidoEnCuadro(randomNumber, i, j) || repetidoEnFilaColumna(randomNumber, i, j);
                } while (isRepeated);

                matriz[i][j].setText(Integer.toString(randomNumber));
                matriz[i][j].setBackground(Color.WHITE);
            }
        }
    }
    /*
    
    */

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
    
    public void crearTablero(JPanel tab) {
        GridLayout gridLayout = new GridLayout(9, 9);
        tab.setLayout(gridLayout);

        matriz = new JTextField[9][9];
        random = new Random();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                JTextField area = new JTextField();
                area.setPreferredSize(new Dimension(50, 50));
                matriz[i][j] = area;
                tab.add(area);
            }
        }

        generarNumerosAleatorios();
        solveSudoku();
        
    }

    private void generarNumerosAleatorios() {
    int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    shuffleArray(nums); // Mezclar el array de números válidos

    // Llenar algunos cuadros con números aleatorios sin violar las reglas del Sudoku
    int cuadrosALlenar = 40; // Cantidad de cuadros a llenar con números aleatorios
    while (cuadrosALlenar > 0) {
        int row = random.nextInt(9);
        int col = random.nextInt(9);
        if (matriz[row][col].getText().isEmpty()) {
            int num = nums[random.nextInt(nums.length)];
            if (isSafe(row, col, num)) {
                matriz[row][col].setText(String.valueOf(num));
                cuadrosALlenar--;
            }
        }
    }
}

    private void fillSudoku() {
        solveSudoku();
    }

    private void solveSudoku() {
        int[] emptyCell = encontrarCeldasVacias();
        if (emptyCell == null) {
            return; // No hay más celdas vacías, el Sudoku está resuelto
        }

        int row = emptyCell[0];
        int col = emptyCell[1];

        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        shuffleArray(nums); // Mezclar el array de números válidos

        for (int num : nums) {
            if (isSafe(row, col, num)) {
                matriz[row][col].setText(String.valueOf(num));
                
                matriz[row][col].setText(""); // Deshacer el cambio si no se encuentra una solución
            }
        }
    }

    private boolean isSafe(int row, int col, int num) {
        // Verificar si es seguro colocar el número 'num' en la celda [row][col]
        return isSafeRow(row, num) && isSafeColumn(col, num) && isSafeBox(row - row % 3, col - col % 3, num);
    }

    private boolean isSafeRow(int row, int num) {
        // Verificar si el número 'num' no está repetido en la fila 'row'
        for (int col = 0; col < 9; col++) {
            if (!matriz[row][col].getText().isEmpty() && Integer.parseInt(matriz[row][col].getText()) == num) {
                return false;
            }
        }
        return true;
    }

    private boolean isSafeColumn(int col, int num) {
        // Verificar si el número 'num' no está repetido en la columna 'col'
        for (int row = 0; row < 9; row++) {
            if (!matriz[row][col].getText().isEmpty() && Integer.parseInt(matriz[row][col].getText()) == num) {
                return false;
            }
        }
        return true;
    }

    private boolean isSafeBox(int boxStartRow, int boxStartCol, int num) {
        // Verificar si el número 'num' no está repetido en el bloque 3x3 que contiene la celda [boxStartRow][boxStartCol]
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (!matriz[row + boxStartRow][col + boxStartCol].getText().isEmpty() &&
                    Integer.parseInt(matriz[row + boxStartRow][col + boxStartCol].getText()) == num) {
                    return false;
                }
            }
        }
        return true;
    }

    private int[] encontrarCeldasVacias() {
        // Buscar una celda vacía en el tablero
        for (int fila = 0; fila < 9; fila++) {
            for (int col = 0; col < 9; col++) {
                if (matriz[fila][col].getText().isEmpty()) {
                    return new int[]{fila, col};
                }
            }
        }
        return null; // No hay celdas vacías
    }

    private void shuffleArray(int[] nums) {
        // Implementar algoritmo de mezcla de Fisher-Yates para mezclar los elementos del array
        for (int i = nums.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
