package gasolinera.servicos;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.InputMismatchException;
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
	@Override
	public List<Gasolinera> Repostaje(List<Gasolinera> baseDatos, boolean verdad /*, File archivo*/ ) {

		/*
		try {
			
		}catch(InputMismatchException e){
			 
			 AbrirFichero(archivo,mensajes.getFormatoERR());
		 }catch(Exception e) {
				System.out.println("Se produjo un error"+e.getMessage());
			}
		baseDatos.add(objetoGasolinera);
		if(baseDatos.size()>taman)
			AbrirFichero(archivo,mensajes.getAgregarRepos());
		else
			AbrirFichero(archivo,mensajes.getAgregarReposERR());
		*/
		
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

	@Override
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

	@Override
	public void ElimininarRepostaje(List<Gasolinera> baseDatos, int n) {

		for (int i = 0; i < baseDatos.size(); i++) {

			if (n == baseDatos.get(i).getId()) {

				baseDatos.remove(i);
				System.out.println("Repostaje eliminado con exito.");
			}

		}

	}

	@Override
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

	//
	// FICHEROS
	//

	@Override
	public void AbrirFichero(File archivo, String mensaje) {

		// Creamos el fr para luego en el try controlar si se abre bien o no
		FileWriter fichero = null;

		try {
			fichero = new FileWriter(archivo, true);

		} catch (Exception e) {
			e.printStackTrace();
		}
		EscribirFichero(fichero, mensaje);
	}

	@Override
	public void EscribirFichero(FileWriter fichero, String mensaje) {

		LocalDateTime fechaHoraActual = LocalDateTime.now();
		try {
			PrintWriter pw = new PrintWriter(fichero, true);

			// pw.println("================================================================================================");
			pw.println("[" + fechaHoraActual + "] " + mensaje);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CerrarFichero(fichero);
		}

	}

	@Override
	public void CerrarFichero(FileWriter fichero) {

		try {
			// Nuevamente aprovechamos el finally para
			// asegurarnos que se cierra el fichero.
			if (null != fichero)
				fichero.close();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}

}
