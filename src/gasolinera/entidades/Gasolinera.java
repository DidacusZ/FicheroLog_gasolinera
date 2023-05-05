package gasolinera.entidades;

public class Gasolinera {

	// id, fechaHora, litros, importe, DNI, matricula

	private int id;

	private String dni = "aaaaaaaaaaaaaa";

	private String fecha = "aaaaaaaaaaaaaa";

	private String matricula = "aaaaaaaaaaaaaa";

	private double litros = 0.0;

	private double importe = 0.0;
	
	private boolean repoVerdad; // true-->normal;  false-->factura;

	// getters y setters

	public boolean getRepoVerdad() {
		return repoVerdad;
	}

	public void setRepoVerdad(boolean repoVerdad) {
		this.repoVerdad = repoVerdad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public double getLitros() {
		return litros;
	}

	public void setLitros(double litros) {
		this.litros = litros;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	// constructor con parametros
	/*
	public Gasolinera(int id, String dni, String fecha, String matricula, double litros, double importe) {
		super();
		this.id = id;
		this.dni = dni;
		this.fecha = fecha;
		this.matricula = matricula;
		this.litros = litros;
		this.importe = importe;
	}
	*/

	// constructor vacio
	public Gasolinera() {
		super();
		// TODO Auto-generated constructor stub
	}

	// toString
	@Override
	public String toString() {
		return "Repostaje con Factura [id=" + id + ", dni=" + dni + ", fecha=" + fecha + ", matricula=" + matricula + ", litros="
				+ litros + ", importe=" + importe + "]";
	}
	
	public String toStringNormal() {
		return "Repostaje Normal [id=" + id + ", fecha=" + fecha + ", litros=" + litros + ", importe=" + importe + "]";
	}

}
