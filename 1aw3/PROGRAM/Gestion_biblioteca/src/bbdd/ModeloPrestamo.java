package bbdd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.Date;
 


public class ModeloPrestamo extends Conexion {

	public ModeloPrestamo(String bbdd, String host, String username, String password) {
		super(bbdd, host, username, password);
		// TODO Auto-generated constructor stub
	}
	public ArrayList<Prestamo> selectAll() {
		ArrayList<Prestamo> prestamo= new ArrayList<Prestamo>();
		
		
		try {
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM prestamos INNER JOIN libros on prestamos.id_libro=libros.id INNER JOIN socios on prestamos.id_socio=socios.id");
		while (rs.next()) {
	
			Prestamo p1= new Prestamo();
			
			p1.setFecha(rs.getDate("fecha"));
			p1.setDevuelto(rs.getBoolean("devuelto"));
			
			
			Libros libro = new Libros();
			
			libro.setId(rs.getInt("id"));
			libro.setTitulo(rs.getString("titulo"));
			libro.setAutor(rs.getString("autor"));
			libro.setNumPags(rs.getInt("num_pag"));
			
			p1.setLibro(libro);
			
			Socio socio = new Socio() ;
			
			socio.setId(rs.getInt("id"));
			socio.setNombre(rs.getString("nombre"));
			socio.setApellido(rs.getString("apellido"));
			socio.setDireccion(rs.getString("direccion"));
			socio.setPoblacion(rs.getString("poblacion"));
			socio.setProvincia(rs.getString("provincia"));
			socio.setDni(rs.getString("dni"));
			
			p1.setSocio(socio);
			prestamo.add(p1);
			
		}
		
		

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prestamo;
	}
	public ArrayList<Prestamo> selectAll_no_devueltos() {
		ArrayList<Prestamo> prestamo= new ArrayList<Prestamo>();
		
		
		try {
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM prestamos INNER JOIN libros on prestamos.id_libro=libros.id  INNER JOIN socios on prestamos.id_socio=socios.id where devuelto=0");
		while (rs.next()) {
	
			Prestamo p1= new Prestamo();
			
			p1.setFecha(rs.getDate("fecha"));
			p1.setDevuelto(rs.getBoolean("devuelto"));
			
			
			Libros libro = new Libros();
			
			libro.setId(rs.getInt("id"));
			libro.setTitulo(rs.getString("titulo"));
			libro.setAutor(rs.getString("autor"));
			libro.setNumPags(rs.getInt("num_pag"));
			
			p1.setLibro(libro);
			
			Socio socio = new Socio() ;
			
			socio.setId(rs.getInt("id"));
			socio.setNombre(rs.getString("nombre"));
			socio.setApellido(rs.getString("apellido"));
			socio.setDireccion(rs.getString("direccion"));
			socio.setPoblacion(rs.getString("poblacion"));
			socio.setProvincia(rs.getString("provincia"));
			socio.setDni(rs.getString("dni"));
			
			p1.setSocio(socio);
			prestamo.add(p1);
			
		}
		
		

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prestamo;
	}
	public ArrayList<Prestamo> select_all_mes() {
		ArrayList<Prestamo> prestamo= new ArrayList<Prestamo>();
		
		
		try {
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery("SELECT *, COUNT(*) AS MES, YEAR(fecha) AS anno, MONTH(fecha) AS mes FROM prestamos GROUP BY YEAR(fecha), MONTH(fecha) ORDER BY YEAR(fecha), MONTH(fecha) ASC");
		while (rs.next()) {
	
			Prestamo p1= new Prestamo();
			
			p1.setFecha(rs.getDate("fecha"));
			p1.setDevuelto(rs.getBoolean("devuelto"));
			
			
			Libros libro = new Libros();
			
			libro.setId(rs.getInt("id"));
			libro.setTitulo(rs.getString("titulo"));
			libro.setAutor(rs.getString("autor"));
			libro.setNumPags(rs.getInt("num_pag"));
			
			p1.setLibro(libro);
			
			Socio socio = new Socio() ;
			
			socio.setId(rs.getInt("id"));
			socio.setNombre(rs.getString("nombre"));
			socio.setApellido(rs.getString("apellido"));
			socio.setDireccion(rs.getString("direccion"));
			socio.setPoblacion(rs.getString("poblacion"));
			socio.setProvincia(rs.getString("provincia"));
			socio.setDni(rs.getString("dni"));
			
			p1.setSocio(socio);
			prestamo.add(p1);
			
		}
		
		

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prestamo;
	}
	
	public void Insertar_prestamo(int id_libro,int id_socio) throws SQLException{
		
		PreparedStatement pstInsert = conexion.prepareStatement("INSERT INTO prestamos(id_libro, id_socio, fecha, devuelto) VALUES (?, ? ,?, ?)");
		pstInsert.setInt(1, id_libro);
		pstInsert.setInt(2, id_socio);
		pstInsert.setDate(3,Date.now());
		pstInsert.setBoolean(4, false);
		pstInsert.execute();
	}
	public void eliminar_prestamo(int id_libro, int id_socio,Date fecha) throws SQLException {
		
		PreparedStatement pstUpdate = conexion.prepareStatement("DELETE from prestamos WHERE id_libro=?,id_socio=?,fecha=?");
		pstUpdate.setInt(1, id_libro);
		pstUpdate.setInt(2, id_socio);
		pstUpdate.setDate(3, (java.sql.Date) fecha);
		pstUpdate.execute();
	}
	public void modificar_prestamo(int id_libro, int id_socio,Date fechaLeida) throws SQLException {

		PreparedStatement pstUpdate = conexion.prepareStatement("UPDATE prestamos set devuelto=? WHERE id_libro=?,id_socio=?,fecha=?");
		pstUpdate.setBoolean(1, true);
		pstUpdate.setInt(2, id_libro);
		pstUpdate.setInt(3,id_socio);
		pstUpdate.setDate(4,fechaLeida);
		pstUpdate.execute();
	}
	}
