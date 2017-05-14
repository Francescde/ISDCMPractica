/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package video;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author francescdepuigguixe
 */
public class Video {
    private static String dbURL = "jdbc:derby://localhost:1527/ISDCM;";
    private static String tableName = "VIDEOS";
    private static String reproduccionesROW ="REPRODUCCIONES";
    // jdbc Connection
    private static Connection conn = null;
    private static Statement stmt = null;
    
    private int lastID=8;
    
    public Video(){
    }
    
    private void createConnection()
    {
        try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            //Get a connection
            conn = DriverManager.getConnection(dbURL);
            
            stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery("select * from " + tableName);
            while (results.next()){
                   ++lastID;
             }
            stmt.close();
        }
        catch (Exception except)
        {
            except.printStackTrace();
        }
    }
    
    public void insertVideo(String titulo, String autor, Date fechaCreacion, Time duracion, int reproducciones,String descripcion,String formato,String url)
    {
        try
        {
            createConnection();
            ++lastID;
            stmt = conn.createStatement();
            System.out.println("insert into " + tableName + " values (" +
                    lastID + ",'" + titulo+ "','" + autor + "','" + fechaCreacion + "','" + duracion + "'," +reproducciones + ",'"  + descripcion+ "','" + formato+ "','" + url +"')");
            stmt.executeUpdate("insert into " + tableName + " values (" +
                    lastID + ",'" + titulo+ "','" + autor + "','" + fechaCreacion + "','" + duracion + "'," +reproducciones + ",'"  + descripcion+ "','" + formato+ "','" + url +"')");
            stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
    }
    
    private void shutdown()
    {
        try
        {
            if (stmt != null)
            {
                stmt.close();
            }
            if (conn != null)
            {
                DriverManager.getConnection(dbURL + ";shutdown=true");
                conn.close();
            }           
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
            
        }

    }
/*
    public Boolean exists(String username, String password) {
        boolean exists = false;
        try
        {
            createConnection();
            stmt = conn.createStatement();
            System.out.println("SELECT * FROM "+ tableName + " u where u.USERNAME = '"+username+"' and u.PASSWORD = '"+password+"'");
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM "+ tableName + " u where u.USERNAME = '"+username+"' and u.PASSWORD = '"+password+"'" );
            int count2 = 0;

            while (rs.next()) {
                ++count2;
                // Get data from the current row and use it
            }

            if (count2 == 0) {
                System.out.println("No records found");
            }
            
            
            stmt.close();
            
            return count2>0;
             
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
        return exists;
    }*/
    
    public VideoModel getById(String id) {
        VideoModel video = new VideoModel();
        try
        {
            createConnection();
            stmt = conn.createStatement();
            System.out.println("SELECT * FROM "+ tableName+" WHERE ID= "+id);
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM "+ tableName+" WHERE ID= "+id);

            while (rs.next()) {
                //String titulo, String autor, Date fechaCreacion, Time duracion,
                // int reproducciones,String descripcion,String formato,String url
                video.setId(rs.getInt("ID"));
                video.setTitulo(rs.getString("TITULO"));
                video.setAutor(rs.getString("AUTOR"));
                video.setFechaCreacion(rs.getDate("FECHA_CREACION"));
                video.setDuracion(rs.getTime("DURACION"));
                video.setReproducciones(rs.getInt("REPRODUCCIONES"));
                video.setDescripcion(rs.getString("DESCRIPCION"));
                video.setFormato(rs.getString("FORMATO"));
                video.setUrl(rs.getString("URL"));
            }

            
            
            stmt.close();
            
            return video;
             
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
        return video;
    }
    public void addReproducciones(String id) {
        VideoModel video = getById(id);
        try
        {
            
            createConnection();
            stmt = conn.createStatement();
            System.out.println("UPDATE "+ tableName+" SET "+reproduccionesROW+"="+reproduccionesROW+"+1"+" WHERE ID= "+id);
            
            stmt.executeUpdate("UPDATE "+ tableName+" SET "+reproduccionesROW+"="+reproduccionesROW+"+1"+" WHERE ID= "+id);
            

            
            
            stmt.close();
            
             
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
    }
}
