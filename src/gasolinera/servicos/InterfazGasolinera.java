package gasolinera.servicos;

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
}
