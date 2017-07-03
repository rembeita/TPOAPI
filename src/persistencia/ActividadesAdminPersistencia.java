package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.sql.Statement;

import SistemaGimnasio.Actividad;
import SistemaGimnasio.ActividadLibre;
import SistemaGimnasio.ActividadProfesor;
import SistemaGimnasio.Deporte;

public class ActividadesAdminPersistencia implements AdministradorPersistencia {
	private static ActividadesAdminPersistencia admin = null;
	
	public ActividadesAdminPersistencia(){
		
	}
	
	//Singleton
	public static ActividadesAdminPersistencia getInstance(){
		if(admin == null)
			admin = new ActividadesAdminPersistencia();
		return admin;
	}
	
	public  void insert(String fecha, String nombre, String horarioActividad, String libre, String estado){
		Connection conn = null;
	
		PreparedStatement ps = null;
		try{
			String sql;
			//Sentencia SQL
			sql = "INSERT INTO tpoapi.dbo.ACTIVIDADES(fecha, nombre, horarioActividad, tipo, estado) VALUES(?, ?, ?, ?, ?)";  
			//Obtengo conexi�n a la base
			conn = ConnectionManager.getConnection();
			//Obtengo un preparedstatement
			ps = conn.prepareStatement(sql);
			//Le pongo los par�metros que reemplazan al ?
			ps.setString(1, fecha);
			ps.setString(2, nombre);
			ps.setString(3, horarioActividad);
			ps.setString(4, libre);
			ps.setString(5, estado);
			
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
			//Obtengo conexi�n a la base
			conn = ConnectionManager.getConnection();
			//Obtengo un preparedstatement
			ps = conn.prepareStatement(sql);
			//Le pongo los par�metros que reemplazan al ?
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
			//Obtengo conexi�n a la base
			conn = ConnectionManager.getConnection();
			//Obtengo un preparedstatement
			ps = conn.prepareStatement(sql);
			//Le pongo los par�metros que reemplazan al ?
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
	
	public Vector<Actividad> selectAll()
	{
		Connection conn = null;
		Statement ps = null;
		Vector <Actividad>rta = new Vector<Actividad>();
			try
			{
				String sql;
				//Sentencia SQL
				sql = "select * from tpoapi.dbo.ACTIVIDADES";  
				//Obtengo conexi�n a la base
				conn = ConnectionManager.getConnection();
				//Obtengo un preparedstatement
				ps = conn.createStatement();
				ResultSet result = ps.executeQuery(sql);
				while (result.next())
				{
					String nombre = result.getString(2);
					String fecha = result.getString(3);
					String hora = result.getString(4);
					String libre = result.getString(5);
					String estado = result.getString(6);
					
					System.out.println("nombre: " + nombre);
					System.out.println("fecha: " + fecha);
					System.out.println("hora: " + hora);
					System.out.println("libre: " + libre);
					System.out.println("estado: " + result.getString(6));

					
					Actividad actividad_ins = null;
					if ( estado.equals("true"))
					{
					
						if (libre == "libre")
						{
							actividad_ins = new ActividadLibre(nombre, fecha, hora);
						}
						else
						{
							//para cambiar mas adelante por ActividadProfesor
							actividad_ins = new ActividadLibre(nombre, fecha, hora);
						}
						rta.add(actividad_ins);
					}
				}
				ps.close();
			}
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				return rta;
	}

	@Override
	public void insert(Object o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object select(String codigo) {
		// TODO Auto-generated method stub
		return null;
	}
			
	

}
