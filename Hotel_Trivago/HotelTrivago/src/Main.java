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

	public static void main(String[] args) throws SQLException {
		int aukera = Integer.parseInt(sc.nextLine());
		
		switch (aukera) {
		case 1:
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
			break;
		case 2:
			System.out.println("Introduce el id:");
			int id1	 = Integer.parseInt(sc.nextLine());
			
			System.out.println("Introduce la compañia:");
			String compañia1  = sc.nextLine() ;
			System.out.println("Introduce el nombre:");
			String nombre1  = sc.nextLine() ;
			hotel.eliminar_hotel(id1, compañia1, nombre1);

			
			break;
		case 3:
			System.out.println("Introduce el id:");
			int id2	 = Integer.parseInt(sc.nextLine());
			System.out.println("Introduce las estrellas:");
			int estrellas1  = Integer.parseInt(sc.nextLine());
			System.out.println("Introduce el gerente:");
			String gerente1 = sc.nextLine() ;
			hotel.editar_hotel(gerente1, estrellas1, id2);
			break;
		case 4:
			hotel.SelectALL();
			System.out.println("Lista de los usuarios:");
			System.out.println("**********************************************************************************");
			for (int i = 0; i < hotel.SelectALL().size(); i++) {

				System.out.println(hotel.SelectALL().get(i));
			}
			break;
			
		
		}while (aukera != SALIR){
			
	}
			

}
}	
		
		


