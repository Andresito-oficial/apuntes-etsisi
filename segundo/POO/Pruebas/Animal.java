import java.util.Date;

public class Animal {
	private String nombre;
	private Date fechaNacimiento;
	public Animal (String nombre, Date fechaNacimiento) {
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
	}
	public String emitirSonido(){return "rggrgrgrgr";}
	public String getNombre() { return nombre; }
}
