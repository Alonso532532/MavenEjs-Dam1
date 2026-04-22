package Proyecto.Vista.VClientes;

import Proyecto.Controlador.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class VCAnadir {
    private static JFrame fAnadir = new JFrame();
    public void construir() {
        fAnadir.setResizable(false);

        fAnadir.setTitle("Añadir clientes");
        fAnadir.setSize(500, 170);
        fAnadir.setLayout(new BorderLayout());

        JPanel panelC = new JPanel(new GridLayout(2, 3, 10, 5));

        TextField tFC1 = new TextField();
        TextField tFC2 = new TextField();
        TextField tFC3 = new TextField();

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

        JButton botonAnadir = new JButton("Añadir");

        panelS.add(botonAnadir);

        panelC.setBorder(new EmptyBorder(15, 15, 0, 15));
        panelS.setBorder(new EmptyBorder(15, 15, 15, 15));
        fAnadir.add(panelC, BorderLayout.CENTER);
        fAnadir.add(panelS, BorderLayout.SOUTH);

        botonAnadir.addActionListener(a -> {
            if (tFC1.getText().isEmpty() || tFC2.getText().isEmpty() || tFC3.getText().isEmpty()) {
                JFrame mensaje = new JFrame("Error de formato");
                JOptionPane.showMessageDialog(
                        mensaje,
                        "Error, uno o varios campos están vacíos",
                        "Información sobre la operación",
                        JOptionPane.INFORMATION_MESSAGE
                );
            } else {
                try {
                    JFrame mensaje = new JFrame("Operación para añadir clientes");
                    String resp = "";
                    JOptionPane.showMessageDialog(
                            mensaje,
                            resp = CClientes.anadir(tFC1.getText(), Integer.parseInt(tFC2.getText()), tFC3.getText()),
                            "Información sobre la operación",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                    if (resp.equals("Cliente introducido con éxito")) {
                        tFC1.setText("");
                        tFC2.setText("");
                        tFC3.setText("");
                    }
                } catch (NumberFormatException e) {
                    JFrame mensaje = new JFrame("Error de formato");
                    JOptionPane.showMessageDialog(
                            mensaje,
                            "Error, el formato de la edad es inválido",
                            "Información sobre la operación",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                }
            }
        });
    }

    public void mostrar(Point posicion){
        fAnadir.setLocation((int) posicion.getX()+250, (int) posicion.getY()+265);
        fAnadir.setVisible(true);
    }

    public void ocultar(){
        fAnadir.dispose();
    }
}
