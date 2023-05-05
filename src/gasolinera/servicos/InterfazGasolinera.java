package gasolinera.servicos;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.List;

import gasolinera.entidades.Gasolinera;

public interface InterfazGasolinera {

	
	/**
	 * crea un repostaje normal o con factura y lo guarda  el la lista
	 * @param baseDatos
	 * @param v
	 * @return
	 */
	public List<Gasolinera> Repostaje(List<Gasolinera> baseDatos, boolean v);
	
	
	/**
	 * muestra repostajes normal o con factura
	 * @param baseDatos
	 * @param verdad
	 */
	public void MostrarRepostaje(List<Gasolinera> baseDatos, boolean verdad);

	
	/**
	 * elmina el repostaje n
	 * @param baseDatos
	 * @param n
	 */
	public void ElimininarRepostaje(List<Gasolinera> baseDatos,int n);
	
	
	/**
	 * modifica el repostaje n
	 * @param baseDatos
	 * @param n
	 */
	public void ModificarRepostaje(List<Gasolinera> baseDatos,int n);
	
	/**
	 * abre el fichero
	 * @param archivo
	 * @param mensaje
	 */
	public void AbrirFichero(File archivo,String mensaje);
	
	/**
	 * escribe en el fichero que recibe
	 * @param fichero
	 * @param mensaje
	 */
	public void EscribirFichero(FileWriter fichero, String mensaje);
	
	/**
	 * cierra el fichero
	 * @param fichero
	 */
	public void CerrarFichero(FileWriter fichero);
}
