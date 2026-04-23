package Proyecto.Vista.VAtracciones;

import Proyecto.Controlador.*;
import Proyecto.Vista.VClientes.VClientes;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VAAnadir {
    private static JFrame fAnadir = new JFrame();
    private static DefaultTableModel modelo;

    public void construir() {
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
                    String resp = "";
                    JOptionPane.showMessageDialog(
                            mensaje,
                            resp = CAtracciones.anadir(tFC1.getText(), Integer.parseInt(tFC2.getText())),
                            "Información sobre la operación",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                    if (resp.equals("Atracción introducida con éxito")) {
                        VAtracciones.actualizarTabla(modelo);
                    }
                } catch (NumberFormatException e) {
                    JFrame mensaje = new JFrame("Error de formato");
                    JOptionPane.showMessageDialog(
                            mensaje,
                            "Error, el formato del numero de Zona es inválido",
                            "Información sobre la operación",
                            JOptionPane.INFORMATION_MESSAGE
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
