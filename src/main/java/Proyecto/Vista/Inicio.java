package Proyecto.Vista;

import javax.swing.*;
import java.awt.*;

public class Inicio {
    public static void main(String[] args) {
        // Creo el frame y lo configuro
        JFrame base = new JFrame("Inicio");
        base.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        base.setSize(1000, 700);
        base.setLayout(new GridLayout(3, 1));

        JPanel arriba = new JPanel();
        JLabel texto = new JLabel("Inicio de sesión");
        arriba.add(texto);
        SpringLayout layout = new SpringLayout();
        layout.putConstraint(SpringLayout.SOUTH, texto, 0, SpringLayout.SOUTH, arriba);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, texto, 0, SpringLayout.HORIZONTAL_CENTER, arriba);
        arriba.setLayout(layout);




        JPanel medio = new JPanel(new GridLayout(1, 2));

        JPanel usuario = new JPanel(new GridLayout(2, 1));
        JLabel labelU = new JLabel("Usuario");
        JTextField campoU = new JTextField();
        usuario.add(labelU);
        usuario.add(campoU);

        JPanel contrasena = new JPanel(new GridLayout(2, 1));
        JTextField campoC = new JTextField();
        JLabel labelC = new JLabel("Contraseña");
        contrasena.add(labelC);
        contrasena.add(campoC);
        medio.add(usuario, BorderLayout.NORTH);
        medio.add(contrasena, BorderLayout.CENTER);

        JButton boton = new JButton("Entrar");

        base.add(arriba);
        base.add(medio);
        base.add(boton);

        base.setVisible(true);
    }
}
