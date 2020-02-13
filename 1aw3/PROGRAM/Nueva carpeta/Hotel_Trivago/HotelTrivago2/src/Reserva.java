import java.sql.Date;

public class Reserva {
private int id;
private Hotel id_habitacion;
private String DNI;
private Date Desde;
private Date Hasta;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Hotel getId_habitacion() {
	return id_habitacion;
}
public void setId_habitacion(Hotel id_habitacion) {
	this.id_habitacion = id_habitacion;
}
public String getDNI() {
	return DNI;
}
public void setDNI(String dNI) {
	DNI = dNI;
}
public Date getDesde() {
	return Desde;
}
public void setDesde(Date desde) {
	Desde = desde;
}
public Date getHasta() {
	return Hasta;
}
public void setHasta(Date hasta) {
	Hasta = hasta;
}
@Override
public String toString() {
	return "Reserva [id=" + id + ", id_habitacion=" + id_habitacion + ", DNI=" + DNI + ", Desde=" + Desde + ", Hasta="
			+ Hasta + "]";
}

}
