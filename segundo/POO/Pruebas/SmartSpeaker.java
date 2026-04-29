public class SmartSpeaker extends DispositivoInteligente {

	@Override
	public void conectar() {
		System.out.println("Altavoz conectado a la red de control");
	}

	@Override
	public void desconectar() {
		System.out.println("Altavoz desconectado de la red de control");
	}

}
