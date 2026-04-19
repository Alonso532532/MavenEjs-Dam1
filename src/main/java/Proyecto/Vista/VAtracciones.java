package Proyecto.Vista;

import Proyecto.Controlador.CAtracciones;
import Proyecto.Controlador.CClientes;
import Proyecto.Modelo.Atracciones;
import Proyecto.Modelo.Clientes;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;


public class VAtracciones {
    public static void ejecutar(boolean admin) {
        // Creo el frame y lo configuro
        JFrame base = new JFrame("Clientes");
        base.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        base.setSize(1000, 700);
        base.setLayout(new BorderLayout(0, 10));

        // Creo el menú de arriba y los botones
        JPanel arriba = new JPanel();
        arriba.setLayout(new GridLayout(1, 10, 10, 10));
        JButton botonN1 = new JButton("Cerrar sesión");
        JButton botonN2 = new JButton("Atracciónes");
        JButton botonN3 = new JButton("Zonas");
        JButton botonN4 = new JButton("Visitas");
        JButton botonN5 = new JButton("Clientes");
        JButton botonN6 = new JButton("Entradas");

        botonN1.setBackground(new Color(255, 91, 91));
        botonN2.setBackground(new Color(189, 189, 189));

        arriba.add(botonN1);
        arriba.add(botonN2);
        arriba.add(botonN3);
        arriba.add(botonN4);
        arriba.add(botonN5);
        arriba.add(botonN6);

        // Creo la zona del medio
        JPanel medio = new JPanel();
//        medio.setBorder(new LineBorder(new Color(138, 138, 138), 3));
        medio.setLayout(new BorderLayout());

        // Para crear la tabla que voy a mostrar tengo que crear un array para la cabecera de la tabla y una matríz con las filas de la tabla
        String[] cabecea = {"Numero de atraccion", "Nombre", "Numero de zona"};
        Object[][] datos = new Object[CAtracciones.seleccionarTodo().size()][3];
        int cont = 0;
        // Inicializo la matríz
        for (Atracciones i: CAtracciones.seleccionarTodo()){
            datos[cont][0] = i.getNumeroDeAtraccion();
            datos[cont][1] = i.getNombre();
            datos[cont][2] = i.getNumeroDeZona();
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
        abajo.setLayout(new GridLayout(1, 10, 10, 10));
        JButton botonS1 = new JButton("Añadir");
        JButton botonS2 = new JButton("Borrar selección");
        JButton botonS3 = new JButton("Modificar");
        abajo.add(botonS1);
        abajo.add(botonS2);
        abajo.add(botonS3);

        // Finalmente, añado todas las partes y muestro el frame
        base.add(arriba, BorderLayout.NORTH);
        base.add(medio, BorderLayout.CENTER);
        base.add(abajo, BorderLayout.SOUTH);

        base.setVisible(true);

        botonN1.addActionListener(a->{
            Inicio.ejecutar();
            base.dispose();
        });

        botonN3.addActionListener(a->{
            VZonas.ejecutar(true);
            base.dispose();
        });

        botonN4.addActionListener(a->{
            VVisitas.ejecutar(true);
            base.dispose();
        });

        botonN5.addActionListener(a->{
            VClientes.ejecutar(true);
            base.dispose();
        });

        botonN6.addActionListener(a->{
            VEntradas.ejecutar(true);
            base.dispose();
        });

        botonS2.addActionListener(a->{
            Object[] seleccionada = datos[tabla.getSelectedRow()];
            JFrame mensaje = new JFrame("Operación de eliminación");
            String resp;
            JOptionPane.showMessageDialog(
                    mensaje,
                    resp = CAtracciones.eliminarPorNumeroDeAtraccion((Integer) seleccionada[0]),
                    "Información sobre la operación",
                    JOptionPane.INFORMATION_MESSAGE
            );
            if (resp.equals("Atracción eliminada con éxito")){
                base.dispose();
                VAtracciones.ejecutar(true);
            }
        });
    }
}