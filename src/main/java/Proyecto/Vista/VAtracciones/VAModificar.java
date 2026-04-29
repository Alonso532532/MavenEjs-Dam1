package Proyecto.Vista.VAtracciones;

import Proyecto.Controlador.CAtracciones;
import Proyecto.Modelo.Atracciones;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VAModificar {
    private static JFrame fAnadir = new JFrame();
    private static DefaultTableModel modelo;

    private static String nombreAnterior = "";
    private static int numeroDeZonaAnterior = 0;

    private static TextField tFC1 = new TextField();
    private static TextField tFC2 = new TextField();
    private static TextField tFC3 = new TextField();

    public void construir() {
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
            if (!tFC2.getText().equals(nombreAnterior) || !tFC3.getText().equals(String.valueOf(numeroDeZonaAnterior))){
                try {
                    Atracciones atraccion = new Atracciones(tFC2.getText(), tFC3.getText());
                } catch (IllegalArgumentException e){
                    System.out.println("Ha ocurrido un error con los valores introducidos:\n"+e.getMessage());
                }
            } else {
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

    public void mostrar(Point posicion, DefaultTableModel modeloNuevo, Atracciones atraccion){
        // Guardo los valores antiguos
        nombreAnterior = atraccion.getNombre();
        numeroDeZonaAnterior = atraccion.getNumeroDeZona();

        // Asigno el valor de la fila seleccionada a los campos de texto
        tFC1.setText(String.valueOf(atraccion.getNumeroDeAtraccion()));
        tFC2.setText(atraccion.getNombre());
        tFC3.setText(String.valueOf(atraccion.getNumeroDeZona()));

        // Lo sitúo
        fAnadir.setLocation((int) posicion.getX()+250, (int) posicion.getY()+265);
        fAnadir.setVisible(true);

        modelo = modeloNuevo;
    }

    public void ocultar(){
        fAnadir.dispose();
    }
}
