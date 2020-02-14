
public class Hotel {
private int id;
private String Cif;
private String Nombre;
private String Gerente;
private int Estrellas;
private String Compañia;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getCif() {
	return Cif;
}
public void setCif(String cif) {
	Cif = cif;
}
public String getNombre() {
	return Nombre;
}
public void setNombre(String nombre) {
	Nombre = nombre;
}
public String getGerente() {
	return Gerente;
}
public void setGerente(String gerente) {
	Gerente = gerente;
}
public int getEstrellas() {
	return Estrellas;
}
public void setEstrellas(int estrellas) {
	Estrellas = estrellas;
}
public String getCompañia() {
	return Compañia;
}
public void setCompañia(String compañia) {
	Compañia = compañia;
}
@Override
public String toString() {
	return "Hoteles [id=" + id + ", Cif=" + Cif + ", Nombre=" + Nombre + ", Gerente=" + Gerente + ", Estrellas="
			+ Estrellas + ", Compañia=" + Compañia + "]";
}

}
