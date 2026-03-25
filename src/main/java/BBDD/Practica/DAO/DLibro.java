package BBDD.Practica.DAO;

import BBDD.Practica.Modelo.Libro;
import BBDD.Practica.Util.Conexion;

import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;

public class DLibro {
    public static boolean anadirLibro(Libro libro){
        try {
            Connection conexion = Conexion.conectar();
            PreparedStatement preparedStatement = conexion.prepareStatement("insert into libros (titulo, precio, id_autor) values (?, ?, ?)");
            preparedStatement.setString(1, libro.getTitulo());
            preparedStatement.setDouble(2, libro.getPrecio());
            preparedStatement.setInt(3, libro.getId_autor());

            return preparedStatement.executeUpdate()>0;
        }catch (SQLException e){
            throw  new RuntimeException(e);
        }
    }

    public static ArrayList<String> selectLibrosConAutor(){
        try {
            Connection conexion = Conexion.conectar();

            Statement statement = conexion.createStatement();
            ResultSet rs = statement.executeQuery("select l.*, a.* from libros l join autores a on l.id_autor = a.id");
            ArrayList<String> resultado = new ArrayList<>();
            while (rs.next()){
                resultado.add("Libro{ID:"+ rs.getInt("l.id")+", Titulo:"+rs.getString("l.titulo")+", Precio:"+rs.getDouble("l.precio")+", IDAutor:"+rs.getInt("l.id_autor")+"} || Autor{"+"ID:"+rs.getInt("a.id")+", Nombre:"+rs.getString("a.nombre")+", Pais:"+rs.getString("a.pais")+"}");
            }
            return resultado;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public static boolean subirPrecios(){
        try {
            Connection conexion = Conexion.conectar();
            Statement statement = conexion.createStatement();
            return statement.executeUpdate("update libros l set l.precio = l.precio*1.10")>0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean eliminarLibrosDeAutor(String id){
        try {
            Connection conexion = Conexion.conectar();
            Statement statement = conexion.createStatement();
            return statement.executeUpdate("delete from libros where id_autor= "+id)>0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Libro> selectLibros(){
        try {
            Connection conexion = Conexion.conectar();

            Statement statement = conexion.createStatement();
            ResultSet rs = statement.executeQuery("select * from libros");
            ArrayList<Libro> resultado = new ArrayList<>();
            while (rs.next()){
                resultado.add(new Libro(rs.getInt("id"), rs.getString("titulo"), rs.getDouble("precio"), rs.getInt("id_autor")));
            }
            return resultado;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Libro> selectLibrosDeAutor(String id){
        try {
            Connection conexion = Conexion.conectar();
            Statement statement = conexion.createStatement();
            ResultSet rs = statement.executeQuery("select * from libros where id_autor = "+id);
            ArrayList<Libro> resultado = new ArrayList<>();
            while (rs.next()){
                resultado.add(new Libro(rs.getInt("id"), rs.getString("titulo"), rs.getDouble("precio"), rs.getInt("id_autor")));
            }
            return resultado;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public static boolean eliminarLibro(int id){
        try {
            Connection conexion = Conexion.conectar();
            PreparedStatement preparedStatement = conexion.prepareStatement("delete from libros where id = ?");
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate()>0;
        }catch (SQLException e){
            throw  new RuntimeException(e);
        }
    }

    public static boolean cambiarPrecio(int id, double precio){
        try {
            Connection conexion = Conexion.conectar();
            PreparedStatement preparedStatement = conexion.prepareStatement("update libros set precio= ? where id = ?");
            preparedStatement.setDouble(1, precio);
            preparedStatement.setInt(2, id);
            return preparedStatement.executeUpdate()>0;
        }catch (SQLException e){
            throw  new RuntimeException(e);
        }
    }

}
