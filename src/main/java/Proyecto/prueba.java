package Proyecto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class prueba {

    public static void main(String[] args) {

        JFrame ventana = new JFrame("Tabla con Scroll");
        ventana.setSize(400, 300);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Datos
        String[] columnas = {"Nombre", "Edad"};
        Object[][] datos = {
                {"Ana", 25},
                {"Luis", 30},
                {"Carlos", 28},
                {"Marta", 22}
        };

        // Modelo NO editable
        DefaultTableModel modelo = new DefaultTableModel(datos, columnas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JTable tabla = new JTable(modelo);

        // Scroll
        JScrollPane scroll = new JScrollPane(tabla);

        ventana.add(scroll, BorderLayout.CENTER);

        ventana.setVisible(true);
    }
}
