package gasolinera.controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import gasolinera.entidades.Gasolinera;
import gasolinera.servicos.ImplGasolinera;
import gasolinera.servicos.ImplMenu;
import gasolinera.servicos.InterfazGasolinera;
import gasolinera.servicos.InterfazMenu;

public class Menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Objetos para llamar a los metodos de sus clases
		InterfazMenu menu = new ImplMenu();
		InterfazGasolinera gasolinera = new ImplGasolinera();

		// base de datos
		List<Gasolinera> BD = new ArrayList();

		// escaner
		Scanner sc = new Scanner(System.in);

		// declaracion variables
		int num;
		boolean verdad = true;

		do {
			
			menu.MostarMenu();
			num = sc.nextInt();
			
			switch (num) {

			case 1:
				BD = gasolinera.Repostaje(BD,true);

				break;

			case 2:
				BD = gasolinera.Repostaje(BD,false);

				break;

			case 3:

				gasolinera.MostrarRepostaje(BD,true);

				System.out.print("Escribe para volver al menu: ");
				sc.next();
				break;
				
			case 4:

				gasolinera.MostrarRepostaje(BD,false);

				System.out.print("Escribe para volver al menu: ");
				sc.next();
				break;
								
			case 5:
				
				System.out.print("Introduce el ID del repostaje a eliminar: ");
				num = sc.nextInt();
				
				gasolinera.ElimininarRepostaje(BD, num);// no hay error cuando no existe repostaje			
				
				break;
				
			case 6:
				
				System.out.print("Introduce el ID del repostaje a modificar: ");
				num = sc.nextInt();
				
				gasolinera.ModificarRepostaje(BD, num);// no hay error cuando no existe repostaje				
				
				break;

			case 0:
				verdad = false;
				break;

			}

		} while (verdad);

		System.out.println("Adios, gracias por usar mi aplicación");

		sc.close();
	}

}
