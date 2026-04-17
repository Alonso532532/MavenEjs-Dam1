package Proyecto.Vista;

import Proyecto.DAO.DUsuarios;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Inicio {
    public static void ejecutar() {
        // Creo el frame y lo configuro
        JFrame base = new JFrame("Inicio");
        base.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        base.setSize(1000, 700);
        base.setLayout(new GridLayout(3, 1));

        // La parte de arriba
        JPanel arriba = new JPanel();

        JLabel texto = new JLabel("Inicio de sesión");
        texto.setFont(new Font("Times new roman", 3, 50));
        arriba.add(texto);
        SpringLayout layoutN = new SpringLayout();
        layoutN.putConstraint(SpringLayout.SOUTH, texto, 0, SpringLayout.SOUTH, arriba);
        layoutN.putConstraint(SpringLayout.HORIZONTAL_CENTER, texto, 0, SpringLayout.HORIZONTAL_CENTER, arriba);
        arriba.setLayout(layoutN);

        // La parte del centro
        JPanel medio = new JPanel(new GridLayout(1, 2));

        // Parte izquierda (usuario)
        JPanel usuario = new JPanel(new GridLayout(2, 1));
        usuario.setBorder(new EmptyBorder(15, 15, 15, 15));

        JLabel labelU = new JLabel("Usuario");
        labelU.setFont(new Font("", 0, 25));
        JTextField campoU = new JTextField();
        campoU.setFont(new Font("", 0, 20));

        JPanel labelPU = new JPanel(new BorderLayout());
        labelPU.add(labelU, BorderLayout.SOUTH);

        JPanel campoPU = new JPanel(new BorderLayout());
        campoPU.add(campoU, BorderLayout.NORTH);

        usuario.add(labelPU);
        usuario.add(campoPU);

        // Parte derecha (contraseña)
        JPanel contrasena = new JPanel(new GridLayout(2, 1));
        contrasena.setBorder(new EmptyBorder(15, 15, 15, 15));

        JTextField campoC = new JTextField();
        campoC.setFont(new Font("", 0, 20));
        JLabel labelC = new JLabel("Contraseña");
        labelC.setFont(new Font("", 0, 25));

        JPanel labelPC = new JPanel(new BorderLayout());
        labelPC.add(labelC, BorderLayout.SOUTH);

        JPanel campoPC = new JPanel(new BorderLayout());
        campoPC.add(campoC, BorderLayout.NORTH);

        contrasena.add(labelPC);
        contrasena.add(campoPC);

        medio.add(usuario, BorderLayout.NORTH);
        medio.add(contrasena, BorderLayout.CENTER);

        // La parte de abajo
        JPanel abajo = new JPanel();

        JButton boton = new JButton("Entrar");
        boton.setMargin(new Insets(10,25,10,25));
        abajo.add(boton);

        SpringLayout layoutS = new SpringLayout();
        layoutS.putConstraint(SpringLayout.NORTH, boton, 0, SpringLayout.NORTH, abajo);
        layoutS.putConstraint(SpringLayout.HORIZONTAL_CENTER, boton, 0, SpringLayout.HORIZONTAL_CENTER, abajo);
        abajo.setLayout(layoutS);


        base.add(arriba);
        base.add(medio);
        base.add(abajo);

        campoU.setText("Admin");
        campoC.setText("Sor2425$");

        AtomicInteger cont = new AtomicInteger();

        boton.addActionListener(a->{
            if (DUsuarios.buscarPorNombreYContrasena(campoU.getText(),campoC.getText())){
                VClientes.ejecutar(true);
                base.dispose();
            }
        });

        base.setVisible(true);
    }
}
