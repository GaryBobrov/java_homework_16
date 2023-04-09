import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ShopRepositoryTest {

    @Test
    public void testWhenRemovedProductExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Ручка", 50);
        Product product2 = new Product(2, "Футболка", 1_000);
        Product product3 = new Product(3, "Рюкзак", 5_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(2);
        Product[] actual = repo.findAll();
        Product[] expected = {product1, product3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testWhenRemovedProductNotExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Ручка", 50);
        Product product2 = new Product(2, "Футболка", 1_000);
        Product product3 = new Product(3, "Рюкзак", 5_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class,
                () -> repo.remove(4)
        );
    }
}