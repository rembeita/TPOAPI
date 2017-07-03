package persistencia;

import java.util.ArrayList;

public interface AdministradorPersistencia {

	public  void insert(Object o);
	public  void update(Object o);
	public  void delete(Object o);
	
	public Object select(String codigo);
	

}
