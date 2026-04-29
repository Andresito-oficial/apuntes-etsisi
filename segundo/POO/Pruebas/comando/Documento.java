package comando;

public class Documento {
    private String texto = "";
    
    public void escribir(String nuevoTexto) {
        texto += nuevoTexto;
    }

    public void borrar(int length) {
        texto = texto.substring(0,texto.length() - length);
    }

    public String getTexto() {
        return texto;
    }
}