import java.util.Map;
import java.util.HashMap;

public class GestorAnimales {

	private Map<String,Animal> animales;

	public GestorAnimales () {
		this.animales = new HashMap<String,Animal>();
	}

	public void incorporar(Animal animal){
		animales.put(animal.getNombre(),animal);
	}

	public Animal buscar(String nombre) {
		if (animales.containsKey(nombre)) {
			return animales.get(nombre);
		}
		return null;
	}

	public void listar() {
		
		for (String nombre : this.animales.keySet()) {
			System.out.println(animales.get(nombre));
		}
	}
	
	abstract String llamar(String nombre) {}
	
}

