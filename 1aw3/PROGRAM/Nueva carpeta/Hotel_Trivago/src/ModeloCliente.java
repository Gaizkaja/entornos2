
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModeloCliente extends Conexion {

	public ModeloCliente(String bbdd, String maquina, String Cliente, String contrasenia) {
		super(bbdd, maquina, Cliente, contrasenia);
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Cliente> selectAll() {
		ArrayList<Cliente> l1 = new ArrayList<Cliente>();
		try {
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from Clientes");

			int aux = 0;

			while (rs.next()) {

				l1.add(new Cliente());

				l1.get(aux).setDNI(rs.getString("dni"));
				l1.get(aux).setNombre(rs.getString("nombre"));
				l1.get(aux).setApellidos(rs.getString("apellido"));
				l1.get(aux).setDireccion(rs.getString("direccion"));
				l1.get(aux).setLocalidad(rs.getString("localidad"));

				aux++;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return l1;

	}

	public ArrayList<Cliente> selectLike(String parte) {
		ArrayList<Cliente> l1 = new ArrayList<Cliente>();
		int aux = 0;
		try {
			Statement st = conexion.createStatement();
			ResultSet rs = st
					.executeQuery("select * from Clientes where upper(nombre) like '%" + parte.toUpperCase() + "%'");
			while (rs.next()) {
				l1.add(new Cliente());

				l1.get(aux).setDNI(rs.getString("dni"));
				l1.get(aux).setNombre(rs.getString("nombre"));
				l1.get(aux).setApellidos(rs.getString("apellido"));
				l1.get(aux).setDireccion(rs.getString("direccion"));
				l1.get(aux).setLocalidad(rs.getString("localidad"));

				aux++;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return l1;

	}

	public Cliente select(String dni) {

		Cliente s1 = new Cliente();

		try {
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from Clientes where upper(dni) = '" + dni.toUpperCase() + "'");

			while (rs.next()) {
				s1.setDNI(rs.getString("dni"));
				s1.setNombre(rs.getString("nombre"));
				s1.setApellidos(rs.getString("apellido"));
				s1.setDireccion(rs.getString("direccion"));
				s1.setLocalidad(rs.getString("localidad"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return s1;

	}

	public void delete(String dni) {

		try {
			PreparedStatement pstDelete = conexion.prepareStatement("DELETE FROM Clientes WHERE dni=?");

			pstDelete.setString(1, dni);
			pstDelete.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void update(String dni, String localidad, String direccion) {

			try {
				PreparedStatement pstUpdate = conexion.prepareStatement("update Clientes set localidad=?,direccion=? where dni=?");
				pstUpdate.setString(1, localidad);
				pstUpdate.setString(2, direccion);
				pstUpdate.setString(3, dni);
				pstUpdate.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}