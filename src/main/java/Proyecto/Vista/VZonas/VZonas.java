package Proyecto.Vista.VZonas;

import Proyecto.Controlador.CAtracciones;
import Proyecto.Controlador.CClientes;
import Proyecto.Controlador.CVisita;
import Proyecto.Controlador.CZonas;
import Proyecto.DAO.DVisita;
import Proyecto.Modelo.Clientes;
import Proyecto.Modelo.Zonas;
import Proyecto.Vista.Inicio;
import Proyecto.Vista.VAtracciones.VAanadir;
import Proyecto.Vista.VAtracciones.VAtracciones;
import Proyecto.Vista.VClientes.VClientes;
import Proyecto.Vista.VEntradas.VEntradas;
import Proyecto.Vista.VVisitas.VVisitas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;


public class VZonas {
    static VZanadir vAanadir = new VZanadir();

    public static void ejecutar(boolean admin, Point posicion) {
        vAanadir.construir();

        // Creo el frame y lo configuro
        JFrame base = new JFrame("Clientes");
        base.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        base.setSize(1000, 700);
        base.setLayout(new BorderLayout(0, 10));

        // Lo situo
        base.setLocation((int) posicion.getX(), (int) posicion.getY());

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
        botonN3.setBackground(new Color(189, 189, 189));

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
        String[] cabecea = {"Numero de zona", "Nombre"};
        Object[][] datos = new Object[CZonas.seleccionarTodo().size()][2];
        int cont = 0;
        // Inicializo la matríz
        for (Zonas i: CZonas.seleccionarTodo()){
            datos[cont][0] = i.getNumeroDeZona();
            datos[cont][1] = i.getNombre();
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
        JButton botonS4 = new JButton("Actualizar tabla");
        abajo.add(botonS1);
        abajo.add(botonS2);
        abajo.add(botonS3);
        abajo.add(botonS4);

        // Finalmente, añado todas las partes y muestro el frame
        arriba.setBorder(new EmptyBorder(10, 10, 10, 10));
        medio.setBorder(new EmptyBorder(0, 10, 0, 10));
        abajo.setBorder(new EmptyBorder(10, 10, 10, 10));
        base.add(arriba, BorderLayout.NORTH);
        base.add(medio, BorderLayout.CENTER);
        base.add(abajo, BorderLayout.SOUTH);

        base.setVisible(true);

        botonN1.addActionListener(a->{
            Inicio.ejecutar();
            base.dispose();
        });

        botonN2.addActionListener(a->{
            VAtracciones.ejecutar(true, base.getLocation());
            base.dispose();
        });

        botonN4.addActionListener(a->{
            VVisitas.ejecutar(true, base.getLocation());
            base.dispose();
        });

        botonN5.addActionListener(a->{
            VClientes.ejecutar(true, base.getLocation());
            base.dispose();
        });

        botonN6.addActionListener(a->{
            VEntradas.ejecutar(true, base.getLocation());
            base.dispose();
        });

        // Este es el botón de "borrar selección"
        botonS2.addActionListener(a->{
            JFrame mensaje = new JFrame("Operación de eliminación");

            // Primero compruebo si ha seleccionado algo, si no se lo muestro mediante un pop up
            if  (tabla.getSelectedRow() != -1) {
                Object[] seleccionada = datos[tabla.getSelectedRow()];
                Boolean eliminar = false;

                // Compruebo que no dependa ningún elemento de este
                if (!CVisita.seleccionarPorNumeroDeZona((int) seleccionada[0]).isEmpty()) {

                    // Sí depende algún elemento le pregunto si quiere eliminarlo
                    int respuesta = JOptionPane.showConfirmDialog(
                            null,
                            "De esta zona dependen " + CVisita.seleccionarPorNumeroDeZona((int) seleccionada[0]).size() + " visitas y \n¿Quieres eliminarlas?",
                            "Confirmación",
                            JOptionPane.YES_NO_OPTION
                    );

                    // Si selecciona si se eliminan los elementos relacionados con este y se elimina el elemento
                    if (respuesta == JOptionPane.YES_OPTION) {
                        JFrame mensajeVisitas = new JFrame("Operación de eliminación (visitas)");
                        JOptionPane.showMessageDialog(
                                mensajeVisitas,
                                CVisita.eliminarPorNumeroDeZona((int) seleccionada[0]),
                                "Información sobre la operación",
                                JOptionPane.INFORMATION_MESSAGE
                        );

                        eliminar = true;
                    } else {
                        // En caso de que haya seleccionado no o haya cerrado la ventana no se elmina nada
                        eliminar = false;
                    }
                } else {
                    eliminar = true;
                }

                if (eliminar) {
                        String resp;
                        JOptionPane.showMessageDialog(
                                mensaje,
                                resp = CZonas.eliminarPorNumeroDeZona((int) seleccionada[0]),
                                "Información sobre la operación",
                                JOptionPane.INFORMATION_MESSAGE
                        );
                        if (resp.equals("Zona eliminada con éxito")) {
                            base.dispose();
                            VZonas.ejecutar(true, base.getLocation());
                        }
                }
            }else {
                JOptionPane.showMessageDialog(
                        mensaje,
                        "No hay nada seleccionado",
                        "Información sobre la operación",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        });

        botonS4.addActionListener(a->{
            base.dispose();
            VZonas.ejecutar(true, base.getLocation());
        });

        botonS1.addActionListener(a->{
            vAanadir.mostrar();
        });
    }
}