import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.*;

public class ProductManagerTest {
    Book book1 = new Book(11, "Анна Каренина", 500, "Толстой");
    Book book2 = new Book(12, "Мастер и Маргарита", 600, "Булгаков");
    Book book3 = new Book(13, "Ревизор", 450, "Гоголь");
    Book book4 = new Book(14, "Братья Карамазовы", 550, "Достоевский");
    Smartphone phone1 = new Smartphone(1001, "iPhone", 50000, "Apple");
    Smartphone phone2 = new Smartphone(1002, "Galaxy", 30000, "Samsung");
    Smartphone phone3 = new Smartphone(1003, "Honor", 40000, "Huawei");
    Smartphone phone4 = new Smartphone(1004, "Mi", 20000, "Xiaomi");

    @Test
    public void firstTest() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(phone1);
        manager.add(phone2);
        manager.add(phone3);
        manager.add(phone4);
        manager.removeById(14);
        manager.removeById(1004);


        Product[] actual = manager.searchBy("в");
        Product[] expected = { book2, book3 };

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void secondTest() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(phone1);
        manager.add(phone2);
        manager.add(phone3);
        manager.add(phone4);
        manager.removeById(11);
        manager.removeById(1001);


        Product[] actual = manager.searchBy("a");
        Product[] expected = { phone2, phone3, phone4 };

        Assertions.assertArrayEquals(expected, actual);
    }
}
