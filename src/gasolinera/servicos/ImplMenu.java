package gasolinera.servicos;

public class ImplMenu implements InterfazMenu {

	public void MostarMenu() {

		System.out.println("0. Salir");
		System.out.println("1. Repostaje normal.");
		System.out.println("2. Repostaje factura.");
		System.out.println("3. Ver repostaje normal.");
		System.out.println("4. Ver repostaje con factura.");
		System.out.println("5. Eliminar repostaje.");
		System.out.println("6. Modificar repostaje.");
		System.out.print("Elige una de las siguientes opciones: ");

	}
}

