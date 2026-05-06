package Proyecto.Vista.VEntradas;

import Proyecto.Controlador.*;
import Proyecto.Vista.VAtracciones.VAtracciones;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Arrays;

public class VEAnadir {
    private static JFrame fAnadir = new JFrame();
    // Este modelo sirve para actualizar la tabla de la vista
    private static DefaultTableModel modelo;

    // Este método inicializa todo de la ventana
    public void construir() {
        // Hago que no se pueda cambiar el tamaño a la ventana
        fAnadir.setResizable(false);

        fAnadir.setTitle("Añadir entrada");
        fAnadir.setSize(500, 170);
        fAnadir.setLayout(new BorderLayout());

        JPanel panelC = new JPanel(new GridLayout(2, 3, 10, 5));

        //Creo el combobox
        String[] opciones = {"Normal", "Oferta", "Familia numerosa"};
        JComboBox<String> cBF1 = new JComboBox<>(opciones);

        TextField tFC2 = new TextField();
        TextField tFC3 = new TextField();

        JLabel labelC1 = new JLabel();
        JLabel labelC2 = new JLabel();
        JLabel labelC3 = new JLabel();

        labelC1.setText("Tipo");
        labelC2.setText("Precio");
        labelC3.setText("DNI");

        panelC.add(labelC1);
        panelC.add(labelC2);
        panelC.add(labelC3);

        panelC.add(cBF1);
        panelC.add(tFC2);
        panelC.add(tFC3);

        JPanel panelS = new JPanel(new FlowLayout());

        JButton botonAnadir = new JButton("Añadir");

        panelS.add(botonAnadir);

        panelC.setBorder(new EmptyBorder(15, 15, 0, 15));
        panelS.setBorder(new EmptyBorder(15, 15, 15, 15));
        fAnadir.add(panelC, BorderLayout.CENTER);
        fAnadir.add(panelS, BorderLayout.SOUTH);

        botonAnadir.addActionListener(a -> {
            // En cuanto se active al botón se comprueba que no hayan campos vacíos
            if (tFC2.getText().isEmpty() || tFC3.getText().isEmpty()) {
                JFrame mensaje = new JFrame("Error de formato");
                JOptionPane.showMessageDialog(
                        mensaje,
                        "Error, uno o varios campos están vacíos",
                        "Información sobre la operación",
                        JOptionPane.INFORMATION_MESSAGE
                );
            } else {
                JFrame mensaje = new JFrame("Operación para añadir entradas");
                String resp = "";
                JOptionPane.showMessageDialog(
                        mensaje,
                        resp = CEntrada.anadir((String) cBF1.getSelectedItem(), tFC2.getText(), tFC3.getText()),
                        "Información sobre la operación",
                        JOptionPane.INFORMATION_MESSAGE
                );
                if (resp.equals("Entrada introducida con éxito")) {
                    VEntradas.actualizarTabla(modelo);
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
