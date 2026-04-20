package Proyecto.Vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Arrays;

public class VAnadir {
    public static boolean ejecutar(String[] campos, int tabla){
        boolean modificacion = false;
        String nombre = "";
        switch (tabla){
            case 1:
                nombre = "atracciones";
                break;
            case 2:
                nombre = "clientes";
                break;
            case 3:
                nombre = "entradas";
                break;
            case 4:
                nombre = "visitas";
                break;
            case 5:
                nombre = "zonas";
                break;
        }
        if (tabla==1||tabla==3||tabla==5){
            campos = Arrays.copyOfRange(campos, 1, campos.length);
        }

        JFrame fAnadir = new JFrame("Anadir "+nombre);
        fAnadir.setSize(500, 170);
        fAnadir.setLayout(new BorderLayout());

        JPanel panelC = new JPanel(new GridLayout(2, campos.length, 10, 5));

        TextField tFC1 = new TextField();
        TextField tFC2 = new TextField();
        TextField tFC3 = new TextField();

        JLabel labelC1 = new JLabel();
        JLabel labelC2 = new JLabel();
        JLabel labelC3 = new JLabel();

        if (campos.length==2){
            labelC1.setText(campos[0]);
            labelC2.setText(campos[1]);

            panelC.add(labelC1);
            panelC.add(labelC2);
            panelC.add(tFC1);
            panelC.add(tFC2);
        }else {

            labelC1.setText(campos[0]);
            labelC2.setText(campos[1]);
            labelC3.setText(campos[2]);

            panelC.add(labelC1);
            panelC.add(labelC2);
            panelC.add(labelC3);

            panelC.add(tFC1);
            panelC.add(tFC2);
            panelC.add(tFC3);
        }



        JPanel panelS = new JPanel(new FlowLayout());

        JButton botonAnadir = new JButton("Anadir");

        panelS.add(botonAnadir);

        panelC.setBorder(new EmptyBorder(15, 15, 0, 15));
        panelS.setBorder(new EmptyBorder(15, 15, 15, 15));
        fAnadir.add(panelC, BorderLayout.CENTER);
        fAnadir.add(panelS, BorderLayout.SOUTH);

        fAnadir.setVisible(true);
        return modificacion;
    }
}
