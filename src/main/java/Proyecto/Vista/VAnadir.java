package Proyecto.Vista;

import Proyecto.Controlador.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Arrays;

public class VAnadir {
    private static JFrame fAnadir = new JFrame();

    public void construir(String[] campos, int tabla){
        fAnadir.setResizable(false);
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

        fAnadir.setTitle("Anadir "+nombre);
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

        if(tabla==4){
            JLabel pista = new JLabel("La fecha sigue el siguiente formato YYYY-MM-DD hh:mm:ss");
            panelS.add(pista);
        }
        panelS.add(botonAnadir);

        panelC.setBorder(new EmptyBorder(15, 15, 0, 15));
        panelS.setBorder(new EmptyBorder(15, 15, 15, 15));
        fAnadir.add(panelC, BorderLayout.CENTER);
        fAnadir.add(panelS, BorderLayout.SOUTH);


        String[] finalCampos = campos;
        botonAnadir.addActionListener(a->{

            if (finalCampos.length==2&&(tFC1.getText().isEmpty()||tFC2.getText().isEmpty())||finalCampos.length==3&&(tFC1.getText().isEmpty()||tFC2.getText().isEmpty()||tFC3.getText().isEmpty())){
                JFrame mensaje = new JFrame("Error de formato");
                JOptionPane.showMessageDialog(
                        mensaje,
                        "Error, uno o varios vampos están vacíos",
                        "Información sobre la operación",
                        JOptionPane.INFORMATION_MESSAGE
                );
            } else {
                switch (tabla) {
                    case 1:
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
                                tFC1.setText("");
                                tFC2.setText("");
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
                        break;
                    case 2:
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
                        break;
                    case 3:
                        try {
                            JFrame mensaje = new JFrame("Operación para añadir entradas");
                            String resp = "";
                            JOptionPane.showMessageDialog(
                                    mensaje,
                                    resp = CEntrada.anadir(tFC1.getText(), Integer.parseInt(tFC2.getText()), tFC3.getText()),
                                    "Información sobre la operación",
                                    JOptionPane.INFORMATION_MESSAGE
                            );
                            if (resp.equals("Entrada introducida con éxito")) {
                                tFC1.setText("");
                                tFC2.setText("");
                                tFC3.setText("");
                            }
                        } catch (NumberFormatException e) {
                            JFrame mensaje = new JFrame("Error de formato");
                            JOptionPane.showMessageDialog(
                                    mensaje,
                                    "Error, el formato del precio es inválido",
                                    "Información sobre la operación",
                                    JOptionPane.INFORMATION_MESSAGE
                            );
                        }
                        break;
                    case 4:
                        try {
                            JFrame mensaje = new JFrame("Operación para añadir visitas");
                            String resp = "";
                            JOptionPane.showMessageDialog(
                                    mensaje,
                                    resp = CVisita.anadir(tFC1.getText(), Integer.parseInt(tFC2.getText()), tFC3.getText()),
                                    "Información sobre la operación",
                                    JOptionPane.INFORMATION_MESSAGE
                            );
                            if (resp.equals("Visita introducida con éxito")) {
                                tFC1.setText("");
                                tFC2.setText("");
                                tFC3.setText("");
                            }
                        } catch (NumberFormatException e) {
                            JFrame mensaje = new JFrame("Error de formato");
                            JOptionPane.showMessageDialog(
                                    mensaje,
                                    "Error, el formato del número de zona es inválido",
                                    "Información sobre la operación",
                                    JOptionPane.INFORMATION_MESSAGE
                            );
                        }
                        break;
                    case 5:
                        JFrame mensaje = new JFrame("Operación para añadir zonas");
                        String resp = "";
                        JOptionPane.showMessageDialog(
                                mensaje,
                                resp = CZonas.anadir(tFC1.getText()),
                                "Información sobre la operación",
                                JOptionPane.INFORMATION_MESSAGE
                        );
                        if (resp.equals("Zona introducida con éxito")) tFC1.setText("");

                        break;
                }
            }
        });
        fAnadir.setVisible(true);
    }

    public void mostrar(){
        fAnadir.setVisible(true);
    }

    public void ocultar(){
        fAnadir.dispose();
    }
}
