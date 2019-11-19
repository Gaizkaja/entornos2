package menuakGit;
import java.util.Scanner;

public class menuak {
	private static Scanner teclado=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int i =teclado.nextInt();
		int a;
		int b;
		int holder=1;
		 switch(i) {
		 case 1:
			 System.out.println("suma");
			 
			 a=teclado.nextInt();
			 b=teclado.nextInt();
			 System.out.println(a+b);
			  break;
		 case 2:
			 System.out.println("resta");
			 a=teclado.nextInt();
			 b=teclado.nextInt();
			 System.out.println(a-b);
			 break;
		 case 3:
			 System.out.println("multip");
			 a=teclado.nextInt();
			 b=teclado.nextInt();
			 System.out.println(a*b);
			 break;
		 case 4:
			 System.out.println("divison");
			 a=teclado.nextInt();
			 b=teclado.nextInt();
			 System.out.println(a/b);
			 break;
		 case 5:
			 a=teclado.nextInt();
			 for(int factMult =1; factMult < a+1;factMult++) {
				 holder=holder * factMult;
			 }
			 System.out.println(holder);
		 }
	}

}
