package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import SistemaGimnasio.Deporte;

public class DeporteAdminPersistencia implements AdministradorPersistencia {
	private static DeporteAdminPersistencia admin = null;
	
	private DeporteAdminPersistencia(){
		
	}
	
	//Singleton
	public static DeporteAdminPersistencia getInstance(){
		if(admin == null)
			admin = new DeporteAdminPersistencia();
		return admin;
	}
	
	public  void insert(Object o){
		Connection conn = null;
		Deporte deporte = (Deporte) o;
		PreparedStatement ps = null;
		try{
			String sql;
			//Sentencia SQL
			sql = "INSERT INTO DEPORTE(NOMBRE, DESCRIPCION, ESTADO, CODDEPORTE) VALUES(?, ?, ?, ?";  
			//Obtengo conexión a la base
			conn = ConnectionManager.getConnection();
			//Obtengo un preparedstatement
			ps = conn.prepareStatement(sql);
			//Le pongo los parámetros que reemplazan al ?
			ps.setString(1, deporte.getNombre());
			ps.setString(2, deporte.getDescripcion());
			ps.setBoolean(3, deporte.getEstado());
			ps.setInt(4, deporte.getCodDeporte());
			//Ejecuto la sentencia con un preparedstatement
		    ps.executeUpdate();
		   
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return;
	}
	public  void update(Object o){
		Connection conn = null;
		Deporte deporte = (Deporte) o;
		PreparedStatement ps = null;
		try{
			String sql;
			//Sentencia SQL
			sql = "UPDATE DEPORTE SET NOMBRE = ?, DESCRIPCION = ?, ESTADO = ? WHERE CODDEPORTE = ?";  
			//Obtengo conexión a la base
			conn = ConnectionManager.getConnection();
			//Obtengo un preparedstatement
			ps = conn.prepareStatement(sql);
			//Le pongo los parámetros que reemplazan al ?
			ps.setString(1, deporte.getNombre());
			ps.setString(2, deporte.getDescripcion());
			ps.setBoolean(3, deporte.getEstado());
			ps.setInt(4, deporte.getCodDeporte());
			//Ejecuto la sentencia con un preparedstatement
		    ps.executeUpdate();
		   
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return;
	}
	public  void delete(Object o){
		Connection conn = null;
		Deporte deporte = (Deporte) o;
		PreparedStatement ps = null;
		try{
			String sql;
			//Sentencia SQL
			sql = "DELETE FROM DEPORTE WHERE CODDEPORTE = ?";  
			//Obtengo conexión a la base
			conn = ConnectionManager.getConnection();
			//Obtengo un preparedstatement
			ps = conn.prepareStatement(sql);
			//Le pongo los parámetros que reemplazan al ?
			ps.setInt(1, deporte.getCodDeporte());
			//Ejecuto la sentencia con un preparedstatement
		    ps.executeUpdate();
		   
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return;
	}
	
	public  Object select(String codigo){
		Connection conn = null;
		Deporte deporte = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			String sql;
			//Sentencia SQL
			sql = "SELECT nombre, descripcion, estado FROM DEPORTE where codDeporte = ?";  
			//Obtengo conexión a la base
			conn = ConnectionManager.getConnection();
			//Obtengo un preparedstatement
			ps = conn.prepareStatement(sql);
			//Le pongo los parámetros que reemplazan al ?
			ps.setString(1, codigo);
			//Ejecuto la sentencia con un preparedstatement
		    rs = ps.executeQuery();
		    
		    //Recorro el resultset y lleno mi objeto, no uso un while porque trae uno solo
		    if(rs.next()){
		    	String nombre = rs.getString("nombre");
		    	String descripcion = rs.getString("descripcion");
		    	int codDeporte = Integer.valueOf(codigo);
		    	Boolean estado = rs.getBoolean("estado"); 
		    	deporte = new Deporte(nombre, descripcion, codDeporte, estado);

		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				rs.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return deporte;
	}	

	public  ArrayList<Deporte> selectAll(){
		Connection conn = null;
		Deporte deporte = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Deporte> deportes = new ArrayList<Deporte>();
		try{
			String sql;
			//Sentencia SQL
			sql = "SELECT nombre, codDeporte, descripcion, estado FROM DEPORTE";  
			//Obtengo conexión a la base
			conn = ConnectionManager.getConnection();
			//Obtengo un preparedstatement
			ps = conn.prepareStatement(sql);
	
			//Ejecuto la sentencia con un preparedstatement
		    rs = ps.executeQuery();
		    
		    //Recorro el resultset y lleno mi objeto y lo agrego a la coleccion
		    while(rs.next()){
		    	String nombre = rs.getString("nombre");
		    	String descripcion = rs.getString("descripcion");
		    	int codDeporte = rs.getInt("codDeporte");
		    	Boolean estado = rs.getBoolean("estado"); 
		    	deporte = new Deporte(nombre, descripcion, codDeporte, estado);
		    	deportes.add(deporte);
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				rs.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return deportes;
	}
}
