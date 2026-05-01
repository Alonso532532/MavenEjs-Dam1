package Proyecto.Vista.VZonas;

import Proyecto.Controlador.CAtracciones;
import Proyecto.Controlador.CVisita;
import Proyecto.Controlador.CZonas;
import Proyecto.Modelo.Atracciones;
import Proyecto.Modelo.Zonas;
import Proyecto.Vista.Inicio;
import Proyecto.Vista.VAtracciones.VAtracciones;
import Proyecto.Vista.VClientes.VClientes;
import Proyecto.Vista.VEntradas.VEntradas;
import Proyecto.Vista.VVisitas.VVisitas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.sql.SQLException;
import java.util.concurrent.TimeoutException;


public class VZonas {
    static VZAnadir vAanadir = new VZAnadir();

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
        // Añado el modelo a la tabla
        JTable tabla = new JTable(modelo);

        // Hago que la tabla tenga una barra "scroll" cuando haga falta
        JScrollPane scroll = new JScrollPane(tabla);
        medio.add(scroll);

        // Hago que la tabla tenga un campo para buscar
        JPanel medioArriba = new JPanel(new BorderLayout());
        medioArriba.setBorder(new EmptyBorder(0, 0, 10, 0));

        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modelo);
        tabla.setRowSorter(sorter);
        JTextField filtro = new JTextField();

        filtro.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            public void changedUpdate(javax.swing.event.DocumentEvent e) { filtrar(); }
            public void removeUpdate(javax.swing.event.DocumentEvent e) { filtrar(); }
            public void insertUpdate(javax.swing.event.DocumentEvent e) { filtrar(); }

            private void filtrar() {
                String texto = filtro.getText();
                if (texto.trim().length() == 0) {
                    sorter.setRowFilter(null);
                } else {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + texto));
                }
            }
        });

        JLabel filtroL = new JLabel("Filtrar:");
        filtroL.setBorder(new EmptyBorder(0, 0, 0, 5));

        medioArriba.add(filtroL, BorderLayout.WEST);
        medioArriba.add(filtro, BorderLayout.CENTER);
        medio.add(medioArriba, BorderLayout.NORTH);

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

        // Añado funcionalidad a los botónes de arriba, de las tablas
        botonN1.addActionListener(a->{
            Inicio.ejecutar();
            base.dispose();
            vAanadir.ocultar();
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

        // Añado funcionalidad a los botónes de abajo
        botonS1.addActionListener(a->{
            // Cada vez que lo muestro, le paso el modelo de la tabla para que pueda actualizarla
            vAanadir.mostrar(base.getLocation(), modelo);
        });

        // Este es el botón de "borrar selección"
        botonS2.addActionListener(a->{
            JFrame mensaje = new JFrame("Operación de eliminación");

            // Primero compruebo si ha seleccionado algo, si no se lo muestro mediante un pop up
            if  (tabla.getSelectedRow() != -1) {
                int filaVista = tabla.getSelectedRow();
                int filaModelo = tabla.convertRowIndexToModel(filaVista);
                Integer numeroZona = (Integer) modelo.getValueAt(filaModelo, 0);
                Boolean eliminar = false;

                // Compruebo que no dependa ningún elemento de este
                if (!CVisita.seleccionarPorNumeroDeZona(numeroZona).isEmpty() || !CAtracciones.seleccionarPorNumeroDeZona(numeroZona).isEmpty()) {

                    // Sí depende algún elemento le pregunto si quiere eliminarlo
                    int respuesta = JOptionPane.showConfirmDialog(
                            null,
                            "De esta zona dependen " + CVisita.seleccionarPorNumeroDeZona(numeroZona).size() + " visitas y "+CAtracciones.seleccionarPorNumeroDeZona(numeroZona).size()+" atracciones\n¿Quieres eliminarlas?",
                            "Confirmación",
                            JOptionPane.YES_NO_OPTION
                    );

                    // Si selecciona si se eliminan los elementos relacionados con este y se elimina el elemento

                    if (respuesta == JOptionPane.YES_OPTION) {
                        if (!CVisita.seleccionarPorNumeroDeZona(numeroZona).isEmpty()) {
                            JFrame mensajeVisitas = new JFrame("Operación de eliminación (visitas)");
                            JOptionPane.showMessageDialog(
                                    mensajeVisitas,
                                    CVisita.eliminarPorNumeroDeZona(numeroZona),
                                    "Información sobre la operación",
                                    JOptionPane.INFORMATION_MESSAGE
                            );
                        }

                        if (!CAtracciones.seleccionarPorNumeroDeZona(numeroZona).isEmpty()) {
                            JFrame mensajeAtracciones = new JFrame("Operación de eliminación (atracciones)");
                            JOptionPane.showMessageDialog(
                                    mensajeAtracciones,
                                    CAtracciones.eliminarPorNumeroDeZona(numeroZona),
                                    "Información sobre la operación",
                                    JOptionPane.INFORMATION_MESSAGE
                            );
                        }

                        // Activo el borrado del elemento
                        eliminar = true;
                    } else {
                        // En caso de que haya seleccionado no o haya cerrado la ventana no se elmina nada
                        eliminar = false;
                    }


                } else {
                    eliminar = true;
                }

                // Elimino el elemento si hay que eliminarlo
                if (eliminar) {
                        String resp;
                        JOptionPane.showMessageDialog(
                                mensaje,
                                resp = CZonas.eliminarPorNumeroDeZona(numeroZona),
                                "Información sobre la operación",
                                JOptionPane.INFORMATION_MESSAGE
                        );
                    // Si se elmina bien actualizo
                        if (resp.equals("Zona eliminada con éxito")) {
                            actualizarTabla(modelo);
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
            actualizarTabla(modelo);
        });
    }

    // Botón de actualizar la tabla
    public static void actualizarTabla(DefaultTableModel modelo) {
        // Borro las filas antes de añadir las nuevas
        modelo.setRowCount(0);

        for (Zonas c : CZonas.seleccionarTodo()) {
            modelo.addRow(new Object[]{
                    c.getNumeroDeZona(),
                    c.getNombre()
            });
        }
    }
}