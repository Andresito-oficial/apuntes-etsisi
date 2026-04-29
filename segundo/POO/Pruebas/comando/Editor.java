package comando;
import java.util.Stack;

public class Editor {
    private Stack<Command> historial = new Stack<>();

    public void ejecutar(Command c) {
        c.ejecutar();
        historial.push(c);
    }

    public void undo() {
        if (!historial.isEmpty()) {
            historial.pop().deshacer();
        }
    }
    
}
