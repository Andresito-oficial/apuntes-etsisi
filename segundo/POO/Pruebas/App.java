/*import java.util.ArrayList;
import java.util.List;
public class App {

    public static void main(String[] args) {
       /* Library library = new Library();
        //Book book = new Book( "Effective Java", 2022, "Joshua Bloch");
        library.addBook("DON QUIjote de La MANCHA", 1605, "Miguel de Cervantes");
        library.addBook("Don Quijote de La Mancha", 1605, "Miguel De Cervantes");
        library.addBook("Clean Code", 2008, "Robert C. Martin");
        library.showBooks();
        library.searchByTitle("Don");

        List<Animal> animals = new ArrayList<>();
        animals.add(new Perro());
        animals.add(new Gato());

    }

}*/

import controller.StockController;
import model.StockRepository;
import view.StockConsoleView;

public class App {
    publicstatic void main(String[] args) {

        StockRepository repo = new StockRepository();
        StockConsoleView view = new StockConsoleView();

        StockController controller = new StockController(repo, view);
        controller.start();
    }
}
