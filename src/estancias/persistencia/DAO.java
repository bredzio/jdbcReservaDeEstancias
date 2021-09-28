
package estancias.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {
    
    protected Connection conexion = null;
    protected Statement sentencia = null;
    protected ResultSet resultado = null;
    
    private final String USUARIO = "root";
    private final String CLAVE = "root";
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/estancias_exterior?useSSL=false";
    
    public void conectarBase() throws Exception {
        try{    
            Class.forName(DRIVER);
            conexion=DriverManager.getConnection(URL, USUARIO, CLAVE);
            
            //Tuve que cambiar este valor para que no genere error el ROLLBACK
            //if(conexion.getAutoCommit())
                //conexion.setAutoCommit(false);
            
            
        }catch (ClassNotFoundException | SQLException e){
            throw new Exception ("Error al conectarse");
        }
    }
    
    public void desconectarBase() throws Exception{
        try{
        if(conexion != null){
            conexion.close();
        }
        if(resultado != null){
            resultado.close();
        }
        if(sentencia !=null){
            sentencia.close();
        }
    }catch (SQLException e){
        throw new Exception ("Error al desconectarse");
    }
    }
    
    public void insertarModificarEliminar(String sql) throws Exception{
        try{
            conectarBase();
            sentencia=conexion.createStatement();
            sentencia.executeUpdate(sql);
        }catch (SQLException e){
            try{
                conexion.rollback();
            }catch (SQLException ex){
                throw new Exception ("Error al ejecutar Rollback");
            }
            throw new Exception ("Error al ejecutar sentencia"); 
        }
        finally{
            desconectarBase();
        }
    }
    
    public void consultarBase(String sql) throws Exception{
        try{
            conectarBase();
            sentencia=conexion.createStatement();
            resultado=sentencia.executeQuery(sql);
        }catch (SQLException e){
            throw new Exception ("Error al consultar");
        }
    }
    
    
}