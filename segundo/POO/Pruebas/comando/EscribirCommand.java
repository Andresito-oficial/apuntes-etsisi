package comando;

public class EscribirCommand implements Command {

    private Documento documento;
    private String texto;

    public EscribirCommand(Documento documento, String texto) {
        this.documento = documento;
        this.texto = texto;
    }

    public void ejecutar() {
        documento.escribir(texto);
    }

    public void deshacer() {
        documento.borrar(texto.length());
    }
    
}
