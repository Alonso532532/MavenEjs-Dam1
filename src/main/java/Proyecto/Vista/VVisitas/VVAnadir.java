package Proyecto.Vista.VVisitas;

import Proyecto.Controlador.*;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

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

        JPanel panelC = new JPanel(new GridLayout(2, 4, 10, 5));

        TextField tFC1 = new TextField();
        TextField tFC2 = new TextField();
        // Creo un desplegable para la fecha
        JDateChooser tFC3 = new JDateChooser();
        // Le asigno un formato y la fecha actual
        tFC3.setDateFormatString("dd/MM/yyyy");
        tFC3.setDate(new Date());
        TextField tFC4 = new TextField(String.valueOf(LocalDateTime.now()).substring(11, 19));


        JLabel labelC1 = new JLabel();
        JLabel labelC2 = new JLabel();
        JLabel labelC3 = new JLabel();
        JLabel labelC4 = new JLabel();

        labelC1.setText("DNI");
        labelC2.setText("Numero de zona");
        labelC3.setText("Fecha");
        labelC4.setText("Hora");

        panelC.add(labelC1);
        panelC.add(labelC2);
        panelC.add(labelC3);
        panelC.add(labelC4);

        panelC.add(tFC1);
        panelC.add(tFC2);
        panelC.add(tFC3);
        panelC.add(tFC4);

        JPanel panelS = new JPanel(new GridLayout(2,1,0,5));

        JButton botonAnadir = new JButton("Añadir");
        JLabel pista = new JLabel("La hora sigue el siguiente formato: hh:mm:ss");

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
            if (tFC1.getText().isEmpty() || tFC2.getText().isEmpty() || tFC3.getDate()==null || tFC4.getText().isEmpty()) {
                JFrame mensaje = new JFrame("Error de formato");
                JOptionPane.showMessageDialog(
                        mensaje,
                        "Error, uno o varios campos están vacíos o la fecha no se a introducido correctamente",
                        "Información sobre la operación",
                        JOptionPane.ERROR_MESSAGE
                );
            } else {
                // Instancio una clase que me permite parsear el resultado que me da el desplegable de la fecha al formato que necesito
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

                JFrame mensaje = new JFrame("Operación para añadir visitas");
                String resp;
                JOptionPane.showMessageDialog(
                        mensaje,
                        resp = CVisita.anadir(tFC1.getText(), tFC2.getText(), formato.format(tFC3.getDate())+"T"+tFC4.getText()),
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
