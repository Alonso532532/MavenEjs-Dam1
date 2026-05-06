package Proyecto.Vista.VZonas;

import Proyecto.Controlador.CAtracciones;
import Proyecto.Controlador.CClientes;
import Proyecto.Controlador.CVisita;
import Proyecto.Vista.VClientes.VClientes;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VZModificar {
    private static JFrame fModificar = new JFrame();
    // Este modelo sirve para actualizar la tabla de la vista
    private static DefaultTableModel modelo;

    // Estas variables me sirven para saber si hay cambios
    private static String numeroDeZona = "";
    private static String nombreAnterior = "";

    private static TextField tFC1 = new TextField();
    private static TextField tFC2 = new TextField();

    // Este método inicializa todo de la ventana
    public static void construir() {
        // Hago que no se pueda cambiar el tamaño a la ventana
        fModificar.setResizable(false);

        fModificar.setTitle("Modificar zonas");
        fModificar.setSize(500, 170);
        fModificar.setLayout(new BorderLayout());

        JPanel panelC = new JPanel(new GridLayout(2, 2, 10, 5));

        JLabel labelC1 = new JLabel();
        JLabel labelC2 = new JLabel();
        JLabel labelC3 = new JLabel();

        labelC1.setText("Numero de zona");
        labelC2.setText("Nombre");

        tFC1.setFocusable(false);
        tFC1.setBackground(new Color(229, 229, 229));

        panelC.add(labelC1);
        panelC.add(labelC2);

        panelC.add(tFC1);
        panelC.add(tFC2);

        JPanel panelS = new JPanel(new FlowLayout());

        JButton botonModificar = new JButton("Modificar");

        panelS.add(botonModificar);

        panelC.setBorder(new EmptyBorder(15, 15, 0, 15));
        panelS.setBorder(new EmptyBorder(15, 15, 15, 15));
        fModificar.add(panelC, BorderLayout.CENTER);
        fModificar.add(panelS, BorderLayout.SOUTH);

        botonModificar.addActionListener(a -> {
            // En cuanto se active al botón se comprueba que se haya modificado almenos un campo
            if (!tFC2.getText().equals(nombreAnterior)){
                boolean modificar;
                // Compruebo que no dependa ningún elemento de este en caso de que se modifique su clave primaria
                if ((!CAtracciones.seleccionarPorNumeroDeZona(Integer.parseInt(tFC1.getText())).isEmpty() || !CVisita.seleccionarPorNumeroDeZona(Integer.parseInt(tFC1.getText())).isEmpty()) && !tFC1.getText().equals(numeroDeZona)) {

                    // Sí depende algún elemento le pregunto si quiere eliminarlo
                    int respuesta = JOptionPane.showConfirmDialog(
                            null,
                            "De este cliente dependen " + CAtracciones.seleccionarPorNumeroDeZona(Integer.parseInt(numeroDeZona)).size() + " atracciones y "+CVisita.seleccionarPorNumeroDeZona(Integer.parseInt(numeroDeZona)).size()+" visitas\n¿Quieres modificarlas también?",
                            "Confirmación",
                            JOptionPane.YES_NO_OPTION
                    );

                    // Si selecciona si al modificarse se modifican los elementos que dependan de este
                    if (respuesta == JOptionPane.YES_OPTION) {
                        // Activo el borrado del elemento
                        modificar = true;
                    } else {
                        // En caso de que haya seleccionado no o haya cerrado la ventana no se elmina nada
                        modificar = false;
                    }

                } else {
                    modificar = true;
                }
                if (modificar) {
                    // Se mostrará el mensaje que responda la modificación, después asigno los nuevos valores "antiguos" y actualizo la tabla
                    JFrame mensaje = new JFrame("Proceso de modificación");
                    String resp;
                    JOptionPane.showMessageDialog(
                            mensaje,
                            resp = CClientes.modificar(numeroDeZona, nombreAnterior, nombreAnterior, tFC1.getText(), tFC2.getText(), "tFC3.getText()"),
                            "Información sobre la operación",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                    if (resp.equals("Cliente modificado con éxito")) {
                        numeroDeZona = tFC1.getText();
                        nombreAnterior = tFC2.getText();
                        VClientes.actualizarTabla(modelo);
                    }
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

    public static void mostrar(Point posicion, DefaultTableModel modeloNuevo, String dni, String edad, String nombre){
        // Guardo los valores antiguos
        numeroDeZona = dni;
        nombreAnterior = nombre;

        // Asigno el valor de la fila seleccionada a los campos de texto
        tFC1.setText(dni);
        tFC2.setText(edad);

        // Sitúo la ventana
        fModificar.setLocation((int) posicion.getX()+250, (int) posicion.getY()+265);
        fModificar.setVisible(true);

        modelo = modeloNuevo;
    }

    public static void ocultar(){
        fModificar.dispose();
    }
}
