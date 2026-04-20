package Proyecto.Vista;

import javax.swing.*;
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

        JFrame Fanadir = new JFrame("Anadir "+nombre);
        Fanadir.setLayout(new BorderLayout());

        JPanel panelC = new JPanel(new GridLayout(2, campos.length));

        JPanel panelS = new JPanel();

        JButton botonVolver = new JButton("Volver");
        JButton botonAnadir = new JButton("Anadir");

        SpringLayout sLayoutS = new SpringLayout();
        sLayoutS.putConstraint(SpringLayout.SOUTH, botonVolver, 0, SpringLayout.SOUTH, panelS);
        sLayoutS.putConstraint(SpringLayout.WEST, botonVolver, 0, SpringLayout.WEST, panelS);
        sLayoutS.putConstraint(SpringLayout.SOUTH, botonAnadir, 0, SpringLayout.SOUTH, panelS);
        sLayoutS.putConstraint(SpringLayout.HORIZONTAL_CENTER, botonAnadir, 0, SpringLayout.HORIZONTAL_CENTER, panelS);

        panelS.add(botonVolver);
        panelS.add(botonAnadir);

        return modificacion;
    }
}
