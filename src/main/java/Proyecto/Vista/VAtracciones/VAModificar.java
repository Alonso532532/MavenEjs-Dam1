package Proyecto.Vista.VAtracciones;

import Proyecto.Controlador.CAtracciones;
import Proyecto.Modelo.Atracciones;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VAModificar {
    private static JFrame fAnadir = new JFrame();
    // Este modelo sirve para actualizar la tabla de la vista
    private static DefaultTableModel modelo;

    // Estas variables me sirven para saber si hay cambios
    private static String nombreAnterior = "";
    private static String numeroDeZonaAnterior = "";

    private static TextField tFC1 = new TextField();
    private static TextField tFC2 = new TextField();
    private static TextField tFC3 = new TextField();

    // Este método inicializa todo de la ventana
    public void construir() {
        // Hago que no se pueda cambiar el tamaño a la ventana
        fAnadir.setResizable(false);

        fAnadir.setTitle("Modificar atracciones");
        fAnadir.setSize(500, 170);
        fAnadir.setLayout(new BorderLayout());

        JPanel panelC = new JPanel(new GridLayout(2, 3, 10, 5));

        JLabel labelC1 = new JLabel();
        JLabel labelC2 = new JLabel();
        JLabel labelC3 = new JLabel();

        labelC1.setText("Numero de atraccion");
        labelC2.setText("Nombre");
        labelC3.setText("Numero de zona");

        panelC.add(labelC1);
        panelC.add(labelC2);
        panelC.add(labelC3);

        tFC1.setFocusable(false);
        tFC1.setBackground(new Color(229, 229, 229));

        panelC.add(tFC1);
        panelC.add(tFC2);
        panelC.add(tFC3);

        JPanel panelS = new JPanel(new FlowLayout());

        JButton botonModificar = new JButton("Modificar");

        panelS.add(botonModificar);

        panelC.setBorder(new EmptyBorder(15, 15, 0, 15));
        panelS.setBorder(new EmptyBorder(15, 15, 15, 15));
        fAnadir.add(panelC, BorderLayout.CENTER);
        fAnadir.add(panelS, BorderLayout.SOUTH);

        botonModificar.addActionListener(a -> {
            // En cuanto se active al botón se comprueba que no hayan campos vacíos y que se haya modificado almenos un campo
            if ((!tFC2.getText().equals(nombreAnterior) || !tFC3.getText().equals(String.valueOf(numeroDeZonaAnterior))) && (!tFC2.getText().isEmpty() && !tFC3.getText().isEmpty())){
                // Se mostrará el mensaje que responda la modificación, después asigno los nuevos valores "antiguos" y actualizo la tabla
                JFrame mensaje = new JFrame("Ejecución completada");
                String resp;
                JOptionPane.showMessageDialog(
                        mensaje,
                        resp = CAtracciones.modificar(tFC1.getText(), nombreAnterior, numeroDeZonaAnterior, tFC2.getText(), tFC3.getText()),
                        "Información sobre la operación",
                        JOptionPane.INFORMATION_MESSAGE
                );
                if (resp.equals("Nombre y numero de zona modificados con éxito")) {
                    nombreAnterior = tFC2.getText();
                    numeroDeZonaAnterior = tFC3.getText();
                    VAtracciones.actualizarTabla(modelo);
                }
            } else {
                // Si no hay cambios en los campos o hay campos vacíos
                JFrame mensaje = new JFrame("Sin cambios");
                JOptionPane.showMessageDialog(
                        mensaje,
                        "No han habido cambios en los valores o hay campos vacíos",
                        "Información sobre la operación",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        });
    }

    public void mostrar(Point posicion, DefaultTableModel modeloNuevo, String numeroDeAtraccion, String nombre, String numeroDeZona){
        // Guardo los valores antiguos
        nombreAnterior = nombre;
        numeroDeZonaAnterior = numeroDeZona;

        // Asigno el valor de la fila seleccionada a los campos de texto
        tFC1.setText(numeroDeAtraccion);
        tFC2.setText(nombre);
        tFC3.setText(numeroDeZona);

        // Sitúo la ventana
        fAnadir.setLocation((int) posicion.getX()+250, (int) posicion.getY()+265);
        fAnadir.setVisible(true);

        modelo = modeloNuevo;
    }

    public void ocultar(){
        fAnadir.dispose();
    }
}
