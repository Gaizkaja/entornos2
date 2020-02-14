import java.sql.SQLException;
import java.util.Scanner;

public class Main {
	public static Scanner sc = new Scanner(System.in);
	private static final String HOST = "localhost";
	private static final String BBDD = "hotel";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	private static final int SALIR = 0;
	
	private static ModeloHotel hotel = new ModeloHotel(BBDD, HOST, USERNAME, PASSWORD);
	private static ModeloCliente cliente = new ModeloCliente(BBDD, HOST, USERNAME, PASSWORD);
	
	public static void main(String[] args) throws SQLException {
		
		int aukera;
		do {
		System.out.println("...............................................");
		System.out.println("¿Que quieres hacer?" + "\n1- Añadir un nuevo hotel"
				+ "\n2- Eliminar un hotel" + "\n3- Editar un hotel"
				+ "\n4- Listar todos los hoteles"  + "\n0- Salir");
		
		 aukera = Integer.parseInt(sc.nextLine());
		
		switch (aukera) {
		case 1:
			
			añadirhotel();
			
			break;
		case 2:
			
			eliminarhotel();
			
			
			break;
		case 3:
			editarhotel();
			
			break;
		case 4:
			listarhoteles();
			
			break;
		case 5:
			listarclientes();
			
		case 6:
			buscarsocio();
			break;
		case SALIR:
			System.out.println("El programa se ha cerrado....");
			break;
		default:
			System.out.println("Opcion incorrecta");
			break;
					
		}
		}while (aukera != SALIR);
		{
	}
		
			

}

	private static void añadirhotel() throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("Introduce los siguientes campos:");
		// TODO Auto-generated method stub
		System.out.println("Introduce el id:");
		int id	 = Integer.parseInt(sc.nextLine());
		System.out.println("Introduce cif:");
		String cif  = sc.nextLine() ;
		System.out.println("Introduce el nombre:");
		String nombre  = sc.nextLine() ;
		System.out.println("Introduce el gerente:");
		String gerente = sc.nextLine() ;
		System.out.println("Introduce las estrellas:");
		int estrellas  = Integer.parseInt(sc.nextLine());
		System.out.println("Introduce la compañia:");
		String compañia  = sc.nextLine() ;
		hotel.añadir_hotel( id,  cif, nombre, gerente,  estrellas,  compañia);
	}

	private static void eliminarhotel() throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("Introduce el id:");
		int id1	 = Integer.parseInt(sc.nextLine());
		System.out.println("Introduce la compañia:");
		String compañia1  = sc.nextLine() ;
		System.out.println("Introduce el nombre:");
		String nombre1  = sc.nextLine() ;
		hotel.eliminar_hotel(id1, compañia1, nombre1);

	}

	private static void editarhotel() throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("Introduce el id:");
		int id2	 = Integer.parseInt(sc.nextLine());
		System.out.println("Introduce las estrellas:");
		int estrellas1  = Integer.parseInt(sc.nextLine());
		System.out.println("Introduce el gerente:");
		String gerente1 = sc.nextLine() ;
		hotel.editar_hotel(gerente1, estrellas1, id2);
	}

	private static void listarclientes() {
		// TODO Auto-generated method stub
		cliente.selectAll();
		System.out.println("Lista de los clientes:");
		System.out.println("**********************************************************************************");
		for (int i = 0; i < cliente.selectAll().size(); i++) {

			System.out.println(cliente.selectAll().get(i));
		}
	}

	private static void listarhoteles() {
		// TODO Auto-generated method stub
		hotel.SelectALL();
		System.out.println("Lista de los hoteles:");
		System.out.println("**********************************************************************************");
		for (int i = 0; i < hotel.SelectALL().size(); i++) {

			System.out.println(hotel.SelectALL().get(i));
		}
	}

	private static void buscarsocio() {
		// TODO Auto-generated method stub
		System.out.println("Introduzca la parte del nombre del usuario que quieres buscar:");
		System.out.println("**********************************************************************************");
			String parte = sc.nextLine();
		cliente.selectLike(parte);
		for (int i = 0; i < cliente.selectLike(parte).size(); i++) {
			System.out.println(cliente.selectLike(parte).get(i));
		}
	}
}	
		