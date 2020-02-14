import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ModeloHotel extends Conexion {

	public ModeloHotel(String bbdd, String host, String username, String password) {
		super(bbdd, host, username, password);
		// TODO Auto-generated constructor stub

	}

	public ArrayList<Hotel> SelectALL() {
		int id;
		String cif;
		String nombre;
		String gerente;
		int estrellas;
		String compañia;

		ArrayList<Hotel> lista = new ArrayList<Hotel>();

		try {

			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from hoteles");

			while (rs.next()) {
				id = rs.getInt("id");
				cif = rs.getString("cif");
				nombre = rs.getString("nombre");
				gerente = rs.getString("gerente");
				estrellas = rs.getInt("estrellas");
				compañia = rs.getString("compania");

				Hotel s1 = new Hotel();
				s1.setId(id);
				s1.setCif(cif);
				s1.setNombre(nombre);
				s1.setGerente(gerente);
				s1.setEstrellas(estrellas);
				s1.setCompañia(compañia);
				lista.add(s1);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;

	}
	public void añadir_hotel(int id, String cif,String nombre,String gerente, int estrellas, String compañia) throws SQLException {

	PreparedStatement pstInsert = conexion.prepareStatement("INSERT INTO hoteles(id, cif, nombre, gerente, estrellas,compania) VALUES (?, ? ,?, ?, ?,? )");
	pstInsert.setInt(1, id);
	pstInsert.setString(2, cif);
	pstInsert.setString(3, nombre);
	pstInsert.setString(4, gerente);
	pstInsert.setInt(5, estrellas);
	pstInsert.setString(6, compañia);
	pstInsert.execute();
	}
	public void editar_hotel(String gerente, int estrellas, int id) throws SQLException {

		PreparedStatement pstUpdate = conexion.prepareStatement("UPDATE hoteles set gerente=?, estrellas=? WHERE id=?");
		pstUpdate.setString(1, gerente);
		pstUpdate.setInt(2, estrellas);
		pstUpdate.setInt(3, id);
		pstUpdate.execute();

	}
	public void eliminar_hotel(int id, String compañia,String nombre) throws SQLException  {
		
		PreparedStatement pstDelete = conexion.prepareStatement("DELETE FROM hoteles WHERE id=? and compania=? and nombre=?");
		
		pstDelete.setInt(1, id);
		pstDelete.setString(2, compañia);
		pstDelete.setString(3, nombre);
		pstDelete.execute();

}
}
