package Proyecto.Vista.VZonas;

import Proyecto.Controlador.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class VZanadir {
    private static JFrame fAnadir = new JFrame();
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
                if (resp.equals("Atracción introducida con éxito")) {
                    tFC1.setText("");
                }
            }
        });
    }

    public void mostrar(){
        fAnadir.setVisible(true);
    }

    public void ocultar(){
        fAnadir.dispose();
    }
}
