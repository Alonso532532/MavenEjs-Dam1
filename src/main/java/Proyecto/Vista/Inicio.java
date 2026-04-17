package Proyecto.Vista;

import Proyecto.Controlador.CClientes;
import Proyecto.Modelo.Clientes;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicBorders;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.Arrays;

public class Inicio {
    public static void main(String[] args) {
        // Creo el frame y lo configuro
        JFrame base = new JFrame("Tablas");
        base.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        base.setSize(1000, 700);
        base.setLayout(new BorderLayout());

        // Creo el menú de arriba y los botones
        JPanel arriba = new JPanel();
        arriba.setLayout(new GridLayout(1, 10));
        JButton botonN1 = new JButton("Hola");
        JButton botonN2 = new JButton("Hola");
        JButton botonN3 = new JButton("Hola");
        botonN1.setBorder(new LineBorder(new Color(138, 138, 138), 3));
        botonN2.setBorder(new LineBorder(new Color(138, 138, 138), 3));
        botonN3.setBorder(new LineBorder(new Color(138, 138, 138), 3));
        arriba.add(botonN1);
        arriba.add(botonN2);
        arriba.add(botonN3);


        // Creo la zona del medio
        JPanel medio = new JPanel();
        medio.setBorder(new LineBorder(new Color(138, 138, 138), 3));
        medio.setLayout(new BorderLayout());

        // Para crear la tabla que voy a mostrar tengo que crear un array para la cabecera de la tabla y una matríz con las filas de la tabla
        String[] cabecea = {"DNI", "Edad", "Nombre"};
        Object[][] datos = new Object[CClientes.seleccionarTodo().size()][3];
        int cont = 0;
        // Inicializo la matríz
        for (Clientes i: CClientes.seleccionarTodo()){
            datos[cont][0] = i.getDni();
            datos[cont][1] = i.getEdad();
            datos[cont][2] = i.getNombre();
            cont++;
        }

        // Para evitar que se puedan modificar datos en la tabla, creo un objeto "DefaultTableModel" y sobreescribo uno de sus métodos para hacer que sea imposible editar los campos
        DefaultTableModel modelo = new DefaultTableModel(datos, cabecea) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JTable tabla = new JTable(modelo);

        // Hago que la tabla tenga una barra "scroll" cuando haga falta
        JScrollPane scroll = new JScrollPane(tabla);

        medio.add(scroll);

        // Creo la parte de abajo y sus botónes
        JPanel abajo = new JPanel();
        abajo.setLayout(new GridLayout(1, 10));
        JButton botonS1 = new JButton("Hola");
        JButton botonS2 = new JButton("Hola");
        JButton botonS3 = new JButton("Hola");
        botonS1.setBorder(new LineBorder(new Color(138, 138, 138), 3));
        botonS2.setBorder(new LineBorder(new Color(138, 138, 138), 3));
        botonS3.setBorder(new LineBorder(new Color(138, 138, 138), 3));
        abajo.add(botonS1);
        abajo.add(botonS2);
        abajo.add(botonS3);

        // Finalmente, añado todas las partes y muestro el frame
        base.add(arriba, BorderLayout.NORTH);
        base.add(medio, BorderLayout.CENTER);
        base.add(abajo, BorderLayout.SOUTH);

        base.setVisible(true);
    }
}