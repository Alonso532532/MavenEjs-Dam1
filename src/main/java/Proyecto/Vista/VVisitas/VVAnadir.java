package Proyecto.Vista.VVisitas;

import Proyecto.Controlador.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDateTime;

public class VVAnadir {
    private static JFrame fAnadir = new JFrame();
    // Este modelo sirve para actualizar la tabla de la vista
    private static DefaultTableModel modelo;

    // Este método inicializa todo de la ventana
    public void construir() {
        // Hago que no se pueda cambiar el tamaño a la ventana
        fAnadir.setResizable(false);

        fAnadir.setTitle("Añadir visita");
        fAnadir.setSize(500, 210);
        fAnadir.setLayout(new BorderLayout());

        JPanel panelC = new JPanel(new GridLayout(2, 3, 10, 5));

        TextField tFC1 = new TextField();
        TextField tFC2 = new TextField();
        TextField tFC3 = new TextField(String.valueOf(LocalDateTime.now()).replace("T", " ").substring(0, 19));

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

        JPanel panelS = new JPanel(new GridLayout(2,1,0,5));

        JButton botonAnadir = new JButton("Añadir");
        JLabel pista = new JLabel("La fecha sigue el siguiente formato: YYYY-MM-DD hh:mm:ss");

        JPanel SCentrado1 = new JPanel(new FlowLayout());
        JPanel SCentrado2 = new JPanel(new FlowLayout());

        SCentrado1.add(botonAnadir);
        SCentrado2.add(pista);

        panelS.add(SCentrado1);
        panelS.add(SCentrado2);

        panelC.setBorder(new EmptyBorder(15, 15, 0, 15));
        panelS.setBorder(new EmptyBorder(15, 15, 15, 15));
        fAnadir.add(panelC, BorderLayout.CENTER);
        fAnadir.add(panelS, BorderLayout.SOUTH);



        botonAnadir.addActionListener(a -> {
            // En cuanto se active al botón se comprueba que no hayan campos vacíos
            if (tFC1.getText().isEmpty() || tFC2.getText().isEmpty() || tFC3.getText().isEmpty()) {
                JFrame mensaje = new JFrame("Error de formato");
                JOptionPane.showMessageDialog(
                        mensaje,
                        "Error, uno o varios campos están vacíos",
                        "Información sobre la operación",
                        JOptionPane.ERROR_MESSAGE
                );
            } else {
                JFrame mensaje = new JFrame("Operación para añadir visitas");
                String resp;
                JOptionPane.showMessageDialog(
                        mensaje,
                        resp = CVisita.anadir(tFC1.getText(), tFC2.getText(), tFC3.getText()),
                        "Información sobre la operación",
                        JOptionPane.INFORMATION_MESSAGE
                );
                if (resp.equals("Visita introducida con éxito")) {
                    VVisitas.actualizarTabla(modelo);
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
