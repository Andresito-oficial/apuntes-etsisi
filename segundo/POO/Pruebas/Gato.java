import java.util.Date;

public class Gato extends Animal {

	public enum NivelVagancia {
		BAJO,
		MEDIO,
		ALTO;
	}

	private final NivelVagancia nivelVagancia;

	public Gato(String nombre, Date fechaNacimiento, NivelVagancia nivelVagancia) {
		super(nombre, fechaNacimiento);
		this.nivelVagancia = nivelVagancia;
	}

	public String maullar() { return "miau"; }

	@Override
	public String emitirSonido() { return maullar(); }
	
}
