package fichero;

public class FicheroLog {

	public String getAbrirMenu() {
		return AbrirMenu;
	}

	public String getAbrirMenuError() {
		return AbrirMenuError;
	}

	public String getAgregarRepos() {
		return AñadirrRepostaje;
	}

	public String getAgregarReposError() {
		return AñadirRepostajeError;
	}

	public String getMostrarRepostaje() {
		return MostrarRepostaje;
	}

	public String getModidificarRepostajeError() {
		return ModidificarRepostajeError;
	}

	public String getFormatoError() {
		return FormatoError;
	}

	public String getEliminarRepostaje() {
		return EliminarRepostaje;
	}

	public String getEliminarRepostajeError() {
		return EliminarRepostajeError;
	}

	public String getModidificarRepostaje() {
		return ModidificarRepostaje;
	}

	public String getMostrarRepostajeError() {
		return MostrarRepostajeError;
	}

	public String getSalirMenu() {
		return SalirMenu;
	}

	public String getSalirMenuErroror() {
		return SalirMenuErroror;
	}

	final String AbrirMenu = "El menu se abrio correctamente.";
	final String AbrirMenuError = "***ERROR AL ABRIR EL MENU***";

	final String AñadirrRepostaje = "Se agrego correctamente el repostaje.";
	final String AñadirRepostajeError = "***ERROR AL AÑADIR REPOSTAJE***";

	final String MostrarRepostaje = "Los cambios del repostaje se han mostrado correctamente.";
	final String MostrarRepostajeError = "***ERROR AL MOSTRAR REPOSTAJE***";

	final String FormatoError = "***ERROR DE FORMATO***";

	final String EliminarRepostaje = "Sea eliminado correctamente el repostaje.";
	final String EliminarRepostajeError = "***ERROR AL ELIMINAR EL REPOSTAJE***";

	final String ModidificarRepostaje = "Se a modificado el repostaje correctamente.";
	final String ModidificarRepostajeError = "***ERROR AL GUARDAR LOS CAMBIOS***";

	final String SalirMenu = "Se salio Correctamente.";
	final String SalirMenuErroror = "***ERROR AL SALIR***";
}
