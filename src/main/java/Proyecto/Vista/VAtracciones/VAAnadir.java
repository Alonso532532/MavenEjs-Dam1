package Proyecto.Vista.VAtracciones;

import Proyecto.Controlador.*;
import Proyecto.Modelo.Atracciones;
import Proyecto.Vista.VClientes.VClientes;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VAAnadir {
    private static JFrame fAnadir = new JFrame();
    // Este modelo sirve para actualizar la tabla de la vista
    private static DefaultTableModel modelo;

    // Este método inicializa todo de la ventana
    public void construir() {
        // Hago que no se pueda cambiar el tamaño a la ventana
        fAnadir.setResizable(false);

        fAnadir.setTitle("Añadir atracciones");
        fAnadir.setSize(500, 170);
        fAnadir.setLayout(new BorderLayout());

        JPanel panelC = new JPanel(new GridLayout(2, 2, 10, 5));

        TextField tFC1 = new TextField();
        TextField tFC2 = new TextField();

        JLabel labelC1 = new JLabel();
        JLabel labelC2 = new JLabel();

        labelC1.setText("Nombre");
        labelC2.setText("Numero de zona");

        panelC.add(labelC1);
        panelC.add(labelC2);

        panelC.add(tFC1);
        panelC.add(tFC2);

        JPanel panelS = new JPanel(new FlowLayout());

        JButton botonAnadir = new JButton("Añadir");

        panelS.add(botonAnadir);

        panelC.setBorder(new EmptyBorder(15, 15, 0, 15));
        panelS.setBorder(new EmptyBorder(15, 15, 15, 15));
        fAnadir.add(panelC, BorderLayout.CENTER);
        fAnadir.add(panelS, BorderLayout.SOUTH);

        botonAnadir.addActionListener(a -> {
            // En cuanto se active al botón se comprueba que no hayan campos vacíos
            if (tFC1.getText().isEmpty() || tFC2.getText().isEmpty()) {
                JFrame mensaje = new JFrame("Error de formato");
                JOptionPane.showMessageDialog(
                        mensaje,
                        "Error, uno o varios campos están vacíos",
                        "Información sobre la operación",
                        JOptionPane.INFORMATION_MESSAGE
                );
            } else {
                try {
                    JFrame mensaje = new JFrame("Operación para añadir atracciones");
                    JOptionPane.showMessageDialog(
                            mensaje,
                            CAtracciones.anadir(new Atracciones(tFC1.getText(), tFC2.getText())),
                            "Información sobre la operación",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                    VAtracciones.actualizarTabla(modelo);
                } catch (IllegalArgumentException e){
                    // Error al validar los campos
                    JFrame mensaje = new JFrame("Error en los valores introducidos");
                    JOptionPane.showMessageDialog(
                            mensaje,
                            "Ha ocurrido un error con los valores introducidos:\n"+e.getMessage(),
                            "Información sobre la operación",
                            JOptionPane.ERROR_MESSAGE
                    );
                } catch (RuntimeException e){
                    // Error en la consulta SQL
                    JFrame mensaje = new JFrame("Error en la modificación");
                    JOptionPane.showMessageDialog(
                            mensaje,
                            "Ha ocurrido un error al intentar modificar los datos",
                            "Información sobre la operación",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });
    }

    public void mostrar(Point posicion, DefaultTableModel modeloNuevo){
        // Lo sitúo
        fAnadir.setLocation((int) posicion.getX()+250, (int) posicion.getY()+265);
        fAnadir.setVisible(true);

        modelo = modeloNuevo;
    }

    public void ocultar(){
        fAnadir.dispose();
    }
}
