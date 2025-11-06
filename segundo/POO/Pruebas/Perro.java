import java.util.Date;

public class Perro extends Animal {

	private final boolean esGuia;

	public Perro(String nombre, Date fechaNacimiento, boolean esGuia) {
		super(nombre, fechaNacimiento);
		this.esGuia = esGuia;
	}

	public String ladrar() { return "guau";}

	@Override
	public String emitirSonido(){return ladrar();}

}
