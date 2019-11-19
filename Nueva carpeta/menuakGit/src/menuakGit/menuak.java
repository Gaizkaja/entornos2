package menuakGit;
import java.util.Scanner;

public class menuak {
	private static Scanner teclado=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("¿Que quieres visualizar? "
				+"\n 1 sumar"
				+"\n 2 restar"
				+"\n 3 multiplicar"
				+"\n 4 dividir"
				+"\n 5 factorial");
		int i =teclado.nextInt();
		int a=0;
		int b = 0;
		
		 switch(i) {
		 case 1:
			 System.out.println("suma");
			 suma(a,b);
			
			  break;
		 case 2:
			 System.out.println("resta");
			 resta(a,b);

			 break;
		 case 3:
			 System.out.println("multip");
			 multi(a,b);

			 break;
		 case 4:
			 System.out.println("divison");
			 divi(a,b);

			 break;
		 case 5:
			 System.out.println("factorial");

			 fact(a);
		 }
	}
	private static void suma(int a, int b) {
		// TODO Auto-generated method stub

		 a=teclado.nextInt();
		 b=teclado.nextInt();
		 System.out.println(a+b);

	}
	private static void resta(int a, int b) {
		// TODO Auto-generated method stub

		 a=teclado.nextInt();
		 b=teclado.nextInt();
		 System.out.println(a-b);

	}
	private static void multi(int a, int b) {
		// TODO Auto-generated method stub

		 a=teclado.nextInt();
		 b=teclado.nextInt();
		 System.out.println(a*b);

	}
	private static void divi(int a, int b) {
		// TODO Auto-generated method stub

		 a=teclado.nextInt();
		 b=teclado.nextInt();
		 System.out.println(a/b);

	}
	private static void fact(int a) {
		// TODO Auto-generated method stub
		a=teclado.nextInt();
		 int holder=1;
		for(int factMult =1; factMult < a+1;factMult++) {
			 holder=holder * factMult;
		 }
		 System.out.println(holder);
	}
	
}
