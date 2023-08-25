import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import static java.sql.DriverManager.getConnection;


public class Registro extends JFrame  {

    private JTextField cod;
    private JTextField ced;
    private JTextField nom;
    private JTextField date;
    private JComboBox signo;
    private JPanel personaR;
    private JButton bcod;
    private JButton borrar;
    private JButton limpiar;
    private JButton bsigno;
    private JButton bnom;
    private JButton actualizar;
    private JButton ingreso;

    public Registro() {


        bcod.addActionListener(new ActionListener() {
           String conexion = "jdbc:sqlserver://localhost:1433;"+"database = CORRECION2B;"+"user=admin;"+
                   "password=admin;"+"TrustSreverCertificate=true;";
            @Override
            public void actionPerformed(ActionEvent e) {

                try(Connection conn = DriverManager.getConnection(conexion)){
                    String sql = "SELECT CEDULA,NOMBRE,FECHA,SIGNO_ZODIACAL FROM REGISTRO WHERE COD = ? ";
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    ResultSet resultSet = pstmt.executeQuery();

                    if(resultSet.next()){

                        int  cedul = resultSet.getInt("CEDULA");
                        String nombre= resultSet.getString("NOMBRE");
                        String fecha = resultSet.getString("NACIMIENTO");
                        String signoS= resultSet.getString("SIGNO_ZODIACAL");

                        ced.setText(String.valueOf(cedul));
                        nom.setText(nombre);
                        date.setText(fecha);
                        signo.setSelectedItem(signoS);
                    }
                    pstmt.close();

                } catch (SQLException e1){
                    e1.printStackTrace();

                };

            }
        });
        bnom.addActionListener(new ActionListener() {
            String conexion = "jdbc:sqlserver://localhost:1433;"+"database = CORRECION2B;"+"user=admin;"+
                    "password=admin;"+"TrustSreverCertificate=true;";
            @Override
            public void actionPerformed(ActionEvent e) {
                try(Connection conn = DriverManager.getConnection(conexion)){
                    String sql = "SELECT COD,CEDULA,FECHA,SIGNO_ZODIACAL FROM REGISTRO WHERE NOMBRE = ? ";
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    ResultSet resultSet = pstmt.executeQuery();

                    if(resultSet.next()){

                        int  cedul = resultSet.getInt("CEDULA");
                        String nombre= resultSet.getString("NOMBRE");
                        String fecha = resultSet.getString("NACIMIENTO");
                        String signoS= resultSet.getString("SIGNO_ZODIACAL");

                        ced.setText(String.valueOf(cedul));
                        nom.setText(nombre);
                        date.setText(fecha);
                        signo.setSelectedItem(signoS);
                    }
                    pstmt.close();

                } catch (SQLException e1){
                    e1.printStackTrace();

                };
            }
        });
        bsigno.addActionListener(new ActionListener() {
            String conexion = "jdbc:sqlserver://localhost:1433;"+"database = CORRECION2B;"+"user=admin;"+
                    "password=admin;"+"TrustSreverCertificate=true;";
            @Override
            public void actionPerformed(ActionEvent e) {
                try(Connection conn = DriverManager.getConnection(conexion)){
                    String sql = "SELECT COD,CEDULA,NOMBRE,FECHA FROM REGISTRO WHERE GNO_ZODISIACAL = ? ";
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    ResultSet resultSet = pstmt.executeQuery();

                    if(resultSet.next()){

                        int  cedul = resultSet.getInt("CEDULA");
                        String nombre= resultSet.getString("NOMBRE");
                        String fecha = resultSet.getString("NACIMIENTO");
                        String signoS= resultSet.getString("SIGNO_ZODIACAL");

                        ced.setText(String.valueOf(cedul));
                        nom.setText(nombre);
                        date.setText(fecha);
                        signo.setSelectedItem(signoS);
                    }
                    pstmt.close();

                } catch (SQLException e1){
                    e1.printStackTrace();

                };

            }
        });
        borrar.addActionListener(new ActionListener() {
            String conexion = "jdbc:sqlserver://localhost:1433;"+"database = CORRECION2B;"+"user=admin;"+
                    "password=admin;"+"TrustSreverCertificate=true;";
            @Override
            public void actionPerformed(ActionEvent e) {

                String borrartodo = cod.getText();


                try(Connection conn = DriverManager.getConnection(conexion)){
                String sql = "DELETE FROM CORRECION2B WHERE COD ="+borrartodo;
                Statement pstmt = null;
                try{
                    pstmt = conn.createStatement();
                    int filasmal = pstmt.executeUpdate(sql);
                    if(filasmal > 0){
                        System.out.println("Registro eliminado con exito. ");
                    }else{
                        System.out.println("Regitro no encontrado ");
                    }
                }
                finally {
                    if(pstmt != null){
                        pstmt.close();
                    }

                }


                } catch (SQLException e1){
                    e1.printStackTrace();

                };


            }
        });
        actualizar.addActionListener(new ActionListener() {
            String conexion = "jdbc:sqlserver://localhost:SQLEXPRESS04;"+"database = CORRECION2B;"+"user=admin;"+
                    "password=admin;"+"TrustSreverCertificate=true;";
            @Override
            public void actionPerformed(ActionEvent e) {
                int  codig = Integer.parseInt(cod.getText());
                int  cedul = Integer.parseInt(ced.getText());
                String nombre= nom.getText();
                String fecha = date.getText();
                String signoS= (String) signo.getSelectedItem();

                try(Connection conn = DriverManager.getConnection(conexion)){
                    String sql = "UPDATE REGISTRO SET COD=?,CEDULA=?,NOMBRE=?,FECHA=?,SIGNO_ZODIACAL=?";
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    pstmt.setInt(1, codig); // Obtener valor desde JTextField
                    pstmt.setInt(2, cedul); // Obtener valor desde JTextField
                    pstmt.setString(3, nombre); // Obtener valor desde JTextField
                    pstmt.setString(4, fecha); // Obtener valor desde JTextField
                    pstmt.setString(5, signoS); // Obtener valor desde JTextField

                    int filasAfectadas = pstmt.executeUpdate();


                    if (filasAfectadas > 0) {
                        System.out.println("Registro actualizado con éxito.");
                    } else {
                        System.out.println("Error al encontrar el registro.");
                    }
                    pstmt.close();

                } catch (SQLException e1){
                    e1.printStackTrace();

                };

            }
        });
        ingreso.addActionListener(new ActionListener() {
            String conexion = "jdbc:sqlserver://localhost:SQLEXPRESS04;"+"database = CORRECION2B;"+"user=admin;"+
                    "password=admin;"+"TrustSreverCertificate=true;";
            @Override
            public void actionPerformed(ActionEvent e) {
                int  codig = Integer.parseInt(cod.getText());
                int  cedul = Integer.parseInt(ced.getText());
                String nombre= nom.getText();
                String fecha = date.getText();
                String signoS= (String) signo.getSelectedItem();

                try(Connection conn = DriverManager.getConnection(conexion)){
                    String sql = "INSERT INTO REGISTRO (COD,CEDULA,NOMBRE,FECHA,SIGNO_ZODIACAL) VALUES (?, ?, ?, ?, ?, ?)";
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    pstmt.setInt(1, codig); // Obtener valor desde JTextField
                    pstmt.setInt(2, cedul); // Obtener valor desde JTextField
                    pstmt.setString(3, nombre); // Obtener valor desde JTextField
                    pstmt.setString(4, fecha); // Obtener valor desde JTextField
                    pstmt.setString(5, signoS); // Obtener valor desde JTextField

                    int filasAfectadas = pstmt.executeUpdate();


                    if (filasAfectadas > 0) {
                        System.out.println("Registro insertado con éxito.");
                    } else {
                        System.out.println("Error al insertar el registro.");
                    }
                    pstmt.close();

                } catch (SQLException e1){
                    e1.printStackTrace();

                };

            }
        });
        limpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cod.setText("");
                ced.setText("");
                nom.setText("");
                date.setText("");
                signo.setSelectedItem("");


            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("registro");
        frame.setContentPane(new Registro().personaR);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(600,400);
        frame.setLocationRelativeTo(null);
    }
}
