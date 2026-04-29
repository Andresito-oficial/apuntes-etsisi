public class SmartTV extends DispositivoInteligente {

	@Override
	public void conectar() {
		System.out.println("SmartTV conectada a la red de control");
	}

	@Override
	public void desconectar() {
		System.out.println("SmartTV desconectada de la red de control");
	}

}
