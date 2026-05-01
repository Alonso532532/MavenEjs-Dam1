package Proyecto.Vista.VClientes;

import Proyecto.Controlador.CAtracciones;
import Proyecto.Controlador.CClientes;
import Proyecto.Controlador.CEntrada;
import Proyecto.Controlador.CVisita;
import Proyecto.Vista.VAtracciones.VAtracciones;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VCModificar {
    private static JFrame fModificar = new JFrame();
    // Este modelo sirve para actualizar la tabla de la vista
    private static DefaultTableModel modelo;

    // Estas variables me sirven para saber si hay cambios
    private static String dniAnterior = "";
    private static String edadAnterior = "";
    private static String nombreAnterior = "";

    private static TextField tFC1 = new TextField();
    private static TextField tFC2 = new TextField();
    private static TextField tFC3 = new TextField();

    // Este método inicializa todo de la ventana
    public void construir() {
        // Hago que no se pueda cambiar el tamaño a la ventana
        fModificar.setResizable(false);

        fModificar.setTitle("Modificar clientes");
        fModificar.setSize(500, 170);
        fModificar.setLayout(new BorderLayout());

        JPanel panelC = new JPanel(new GridLayout(2, 3, 10, 5));

        JLabel labelC1 = new JLabel();
        JLabel labelC2 = new JLabel();
        JLabel labelC3 = new JLabel();

        labelC1.setText("DNI");
        labelC2.setText("Edad");
        labelC3.setText("Nombre");

        panelC.add(labelC1);
        panelC.add(labelC2);
        panelC.add(labelC3);

        panelC.add(tFC1);
        panelC.add(tFC2);
        panelC.add(tFC3);

        JPanel panelS = new JPanel(new FlowLayout());

        JButton botonModificar = new JButton("Modificar");

        panelS.add(botonModificar);

        panelC.setBorder(new EmptyBorder(15, 15, 0, 15));
        panelS.setBorder(new EmptyBorder(15, 15, 15, 15));
        fModificar.add(panelC, BorderLayout.CENTER);
        fModificar.add(panelS, BorderLayout.SOUTH);

        botonModificar.addActionListener(a -> {
            // En cuanto se active al botón se comprueba que se haya modificado almenos un campo
            if (!tFC1.getText().equals(dniAnterior) || !tFC2.getText().equals(edadAnterior) || !tFC3.getText().equals(nombreAnterior)){
                boolean modificar;
                // Compruebo que no dependa ningún elemento de este
                if (!CEntrada.seleccionarPorDni(dniAnterior).isEmpty() || !CVisita.seleccionarPorDni(dniAnterior).isEmpty()) {

                    // Sí depende algún elemento le pregunto si quiere eliminarlo
                    int respuesta = JOptionPane.showConfirmDialog(
                            null,
                            "De este cliente dependen " + CEntrada.seleccionarPorDni(dniAnterior).size() + " entradas y "+CVisita.seleccionarPorDni(dniAnterior).size()+" visitas\n¿Quieres modificarlas también?",
                            "Confirmación",
                            JOptionPane.YES_NO_OPTION
                    );

                    // Si selecciona si se eliminan los elementos relacionados con este y se elimina el elemento
                    if (respuesta == JOptionPane.YES_OPTION) {
                        if (!CEntrada.seleccionarPorDni(dniAnterior).isEmpty()) {
                            JFrame mensajeVisitas = new JFrame("Operación de modificación (entradas)");
                            JOptionPane.showMessageDialog(
                                    mensajeVisitas,
                                    CEntrada.eliminarPorDni(dniAnterior),
                                    "Información sobre la operación",
                                    JOptionPane.INFORMATION_MESSAGE
                            );
                        }

                        if (!CVisita.seleccionarPorDni(dniAnterior).isEmpty()) {
                            JFrame mensajeAtracciones = new JFrame("Operación de modificación (visitas)");
                            JOptionPane.showMessageDialog(
                                    mensajeAtracciones,
                                    CVisita.eliminarPorDni(dniAnterior),
                                    "Información sobre la operación",
                                    JOptionPane.INFORMATION_MESSAGE
                            );
                        }

                        // Activo el borrado del elemento
                        modificar = true;
                    } else {
                        // En caso de que haya seleccionado no o haya cerrado la ventana no se elmina nada
                        modificar = false;
                    }


                } else {
                    modificar = true;
                }

                // Se mostrará el mensaje que responda la modificación, después asigno los nuevos valores "antiguos" y actualizo la tabla
                JFrame mensaje = new JFrame("Ejecución completada");
                String resp;
                JOptionPane.showMessageDialog(
                        mensaje,
                        resp = CClientes.modificar(dniAnterior, edadAnterior, nombreAnterior, tFC1.getText(), tFC2.getText(), tFC3.getText()),
                        "Información sobre la operación",
                        JOptionPane.INFORMATION_MESSAGE
                );
                if (resp.equals("Cliente modificado con éxito")) {
                    dniAnterior = tFC1.getText();
                    edadAnterior = tFC2.getText();
                    nombreAnterior = tFC3.getText();
                    VClientes.actualizarTabla(modelo);
                }
            } else {
                // Si no hay cambios en los campos
                JFrame mensaje = new JFrame("Sin cambios");
                JOptionPane.showMessageDialog(
                        mensaje,
                        "No han habido cambios en los valores",
                        "Información sobre la operación",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        });
    }

    public void mostrar(Point posicion, DefaultTableModel modeloNuevo, String dni, String edad, String nombre){
        // Guardo los valores antiguos
        dniAnterior = dni;
        edadAnterior = edad;
        nombreAnterior = nombre;

        // Asigno el valor de la fila seleccionada a los campos de texto
        tFC1.setText(dni);
        tFC2.setText(edad);
        tFC3.setText(nombre);

        // Sitúo la ventana
        fModificar.setLocation((int) posicion.getX()+250, (int) posicion.getY()+265);
        fModificar.setVisible(true);

        modelo = modeloNuevo;
    }

    public void ocultar(){
        fModificar.dispose();
    }
}
