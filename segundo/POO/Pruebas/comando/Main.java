package comando;

public class Main {
    public static void main(String[] args) {
        Documento documento = new Documento();
        Editor editor = new Editor();
        
        editor.ejecutar(new EscribirCommand(documento, "Hola "));
        editor.ejecutar(new EscribirCommand(documento, "Mundo!"));
        System.out.println(documento.getTexto());

        System.out.println("Texto después de escribir: " + documento.getTexto());

        editor.undo();
        System.out.println("Texto después de deshacer último comando: " + documento.getTexto());

        editor.undo();
        System.out.println("Texto después de deshacer otro comando: " + documento.getTexto());
    }
    
}
