package Proyecto.Vista.VZonas;

import Proyecto.Controlador.*;
import Proyecto.Vista.VAtracciones.VAtracciones;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VZAnadir {
    private static JFrame fAnadir = new JFrame();
    private static DefaultTableModel modelo;

    public void construir() {
        fAnadir.setResizable(false);

        fAnadir.setTitle("Añadir atracciones");
        fAnadir.setSize(500, 170);
        fAnadir.setLayout(new BorderLayout());

        JPanel panelC = new JPanel(new GridLayout(2, 1, 10, 5));

        TextField tFC1 = new TextField();
        JLabel labelC1 = new JLabel();
        labelC1.setText("Nombre");

        panelC.add(labelC1);
        panelC.add(tFC1);

        JPanel panelS = new JPanel(new FlowLayout());

        JButton botonAnadir = new JButton("Añadir");

        panelS.add(botonAnadir);

        panelC.setBorder(new EmptyBorder(15, 15, 0, 15));
        panelS.setBorder(new EmptyBorder(15, 15, 15, 15));
        fAnadir.add(panelC, BorderLayout.CENTER);
        fAnadir.add(panelS, BorderLayout.SOUTH);

        botonAnadir.addActionListener(a -> {
            if (tFC1.getText().isEmpty()) {
                JFrame mensaje = new JFrame("Error de formato");
                JOptionPane.showMessageDialog(
                        mensaje,
                        "Error, el campo está vacío",
                        "Información sobre la operación",
                        JOptionPane.INFORMATION_MESSAGE
                );
            } else {
                JFrame mensaje = new JFrame("Operación para añadir atracciones");
                String resp = "";
                JOptionPane.showMessageDialog(
                        mensaje,
                        resp = CZonas.anadir(tFC1.getText()),
                        "Información sobre la operación",
                        JOptionPane.INFORMATION_MESSAGE
                );
                if (resp.equals("Zona introducida con éxito")) {
                    VZonas.actualizarTabla(modelo);
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
