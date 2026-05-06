package Proyecto.Vista.VVisitas;

import Proyecto.Controlador.CAtracciones;
import Proyecto.Controlador.CVisita;
import Proyecto.Vista.VAtracciones.VAtracciones;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VVModificar {
    private static JFrame fModificar = new JFrame();
    // Este modelo sirve para actualizar la tabla de la vista
    private static DefaultTableModel modelo;

    // Estas variables me sirven para saber si hay cambios
    private static String dniAnterior = "";
    private static String numeroDeZonaAnterior = "";
    private static String fechaAnterior = "";

    private static TextField tFC1 = new TextField();
    private static TextField tFC2 = new TextField();
    private static TextField tFC3 = new TextField();

    // Este método inicializa todo de la ventana
    public static void construir() {
        // Hago que no se pueda cambiar el tamaño a la ventana
        fModificar.setResizable(false);

        fModificar.setTitle("Modificar visitas");
        fModificar.setSize(500, 170);
        fModificar.setLayout(new BorderLayout());

        JPanel panelC = new JPanel(new GridLayout(2, 3, 10, 5));

        JLabel labelC1 = new JLabel();
        JLabel labelC2 = new JLabel();
        JLabel labelC3 = new JLabel();

        labelC1.setText("DNI");
        labelC2.setText("Numero de zona");
        labelC3.setText("Fecha");

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
            if (!tFC1.getText().equals(dniAnterior) || !tFC2.getText().equals(numeroDeZonaAnterior) || !tFC3.getText().equals(fechaAnterior)){
                // Se mostrará el mensaje que responda la modificación, después asigno los nuevos valores "antiguos" y actualizo la tabla
                JFrame mensaje = new JFrame("Proceso de modificación");
                String resp;
                JOptionPane.showMessageDialog(
                        mensaje,
                        resp = CVisita.modificar(dniAnterior, numeroDeZonaAnterior, fechaAnterior, tFC1.getText(), tFC2.getText(), tFC3.getText()),
                        "Información sobre la operación",
                        JOptionPane.INFORMATION_MESSAGE
                );
                if (resp.equals("Visita modificada con éxito")) {
                    dniAnterior = tFC1.getText();
                    numeroDeZonaAnterior = tFC2.getText();
                    fechaAnterior = tFC3.getText();
                    VVisitas.actualizarTabla(modelo);
                }
            } else {
                // Si no hay cambios en los campos
                JFrame mensaje = new JFrame("Sin cambios");
                JOptionPane.showMessageDialog(
                        mensaje,
                        "No han habido cambios en los valores",
                        "Información sobre la operación",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        });
    }

    public static void mostrar(Point posicion, DefaultTableModel modeloNuevo, String dni, String numeroDeZona, String fecha){
        // Guardo los valores antiguos
        dniAnterior = dni;
        numeroDeZonaAnterior = numeroDeZona;
        fechaAnterior = fecha;

        // Asigno el valor de la fila seleccionada a los campos de texto
        tFC1.setText(dni);
        tFC2.setText(numeroDeZona);
        tFC3.setText(fecha);

        // Sitúo la ventana
        fModificar.setLocation((int) posicion.getX()+250, (int) posicion.getY()+265);
        fModificar.setVisible(true);

        modelo = modeloNuevo;
    }

    public static void ocultar(){
        fModificar.dispose();
    }
}
