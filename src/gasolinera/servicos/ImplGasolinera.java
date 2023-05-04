package gasolinera.servicos;

import java.util.List;
import java.util.Scanner;

import gasolinera.entidades.Gasolinera;

public class ImplGasolinera implements InterfazGasolinera {

	// metodos:

	// NUEVO RESPOSTAJE
	// NORMAL: se guarda la fecha, los litros y el importe.
	// FACTURA: se guarda la fecha, los litros, el importe, el DNI del cliente y la
	// matrícula del vehículo.

	// Generador de id

	public List<Gasolinera> Repostaje(List<Gasolinera> baseDatos, boolean verdad) {

		// declaraciones
		Gasolinera objetoGasolinera = new Gasolinera();

		Scanner sc = new Scanner(System.in);
		String fecha = "aaaaaaaaaaaaaa";
		double litros = 0.0;
		double importe = 0.0;

		// pedir datos
		System.out.print("Introduce la fecha: ");
		fecha = sc.next();
		System.out.print("Introduce los litros a repostar: ");
		litros = sc.nextDouble();
		System.out.print("Introduce el importe: ");
		importe = sc.nextDouble();

		// guardar datos
		objetoGasolinera.setId(calculoIdGaso(baseDatos));
		objetoGasolinera.setFecha(fecha);
		objetoGasolinera.setLitros(litros);
		objetoGasolinera.setImporte(importe);

		objetoGasolinera.setRepoVerdad(verdad);

		// con factura
		if (!verdad) {

			// declaraciones

			String dni = "aaaaaaaaaaaaaa";
			String matricula = "aaaaaaaaaaaaaa";

			// pedir datos RepoFactura
			System.out.print("Introduce tu DNI: ");
			dni = sc.next();
			System.out.print("Introduce la matricula de tu coche: ");
			matricula = sc.next();

			// guardar datos RepoFactura 
			objetoGasolinera.setDni(dni);
			objetoGasolinera.setMatricula(matricula);

		}

		// guardar objeto en BBDD
		baseDatos.add(objetoGasolinera);

		return baseDatos;

	}

	public void MostrarRepostaje(List<Gasolinera> baseDatos, boolean verdad) {

		if (verdad) {// normal

			System.out.println("        Repostajes Normales");

			for (int i = 0; i < baseDatos.size(); i++) {

				if (baseDatos.get(i).getRepoVerdad() == true)
					System.out.println(baseDatos.get(i).toStringNormal());

			}

		} else {

			System.out.println("        Repostajes con Factura");

			for (int i = 0; i < baseDatos.size(); i++) {

				if (baseDatos.get(i).getRepoVerdad() == false)
					System.out.println(baseDatos.get(i).toString());
			}

		}

	}

	public void ElimininarRepostaje(List<Gasolinera> baseDatos, int n) {

		for (int i = 0; i < baseDatos.size(); i++) {

			if (n == baseDatos.get(i).getId()) {

				baseDatos.remove(i);
				System.out.println("Repostaje eliminado con exito.");
			}

		}

	}

	public void ModificarRepostaje(List<Gasolinera> baseDatos, int n) {

		Gasolinera objetoGasolinera = new Gasolinera();

		for (int i = 0; i < baseDatos.size(); i++) {

			if (n == baseDatos.get(i).getId()) {

				Scanner sc = new Scanner(System.in);
				String fecha = "aaaaaaaaaaaaaa";
				double litros = 0.0;
				double importe = 0.0;

				objetoGasolinera.setId(n);

				// pedir datos
				System.out.print("Introduce la fecha: ");
				fecha = sc.next();
				System.out.print("Introduce los litros a repostar: ");
				litros = sc.nextDouble();
				System.out.print("Introduce el importe: ");
				importe = sc.nextDouble();

				// guardar datos
				objetoGasolinera.setFecha(fecha);
				objetoGasolinera.setLitros(litros);
				objetoGasolinera.setImporte(importe);

				if (baseDatos.get(i).getRepoVerdad() == false) {

					String dni = "aaaaaaaaaaaaaa";
					String matricula = "aaaaaaaaaaaaaa";

					// pedir datos RepoFactura
					System.out.print("Introduce tu DNI: ");
					dni = sc.next();
					System.out.print("Introduce la matricula de tu coche: ");
					matricula = sc.next();

					// guardar datos RepoFactura
					objetoGasolinera.setDni(dni);
					objetoGasolinera.setMatricula(matricula);
					objetoGasolinera.setRepoVerdad(false);
				}
				
				if (baseDatos.get(i).getRepoVerdad() == true)
					objetoGasolinera.setRepoVerdad(true);

				baseDatos.set(i, objetoGasolinera);

				System.out.println("Repostaje modificado con exito.");
			}

		}

	}

	/**
	 * genera un id dependiendo del anterior (cada id es unico)
	 * 
	 * @param baseDatos
	 * @return
	 */
	private int calculoIdGaso(List<Gasolinera> baseDatos) {// private cuando solo se us en esa clase
		int auxiliar = 0;

		for (int i = 0; i < baseDatos.size(); i++) {
			int j = baseDatos.get(i).getId();
			if (auxiliar < j) {
				auxiliar = j;
			}
		}
		return auxiliar + 1;
	}

}
