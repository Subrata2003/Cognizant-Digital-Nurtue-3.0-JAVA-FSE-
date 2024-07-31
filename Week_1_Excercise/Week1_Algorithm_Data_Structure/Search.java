import java.util.Arrays;

class Product {
    String productId;
    String productName;
    String category;

    public Product(String productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }
}

class Search {

    public static Product linearSearch(Product[] products, String target) {
        for (Product product : products) {
            if (product.productName.equals(target)) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, String target) {
        int low = 0, high = products.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (products[mid].productName.equals(target)) {
                return products[mid];
            } else if (products[mid].productName.compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product("1", "Laptop", "Electronics"),
            new Product("2", "Smartphone", "Electronics"),
            new Product("3", "Tablet", "Electronics")
        };

        Arrays.sort(products, (a, b) -> a.productName.compareTo(b.productName));

        System.out.println("Linear Search Result: " + linearSearch(products, "Smartphone").productName);
        System.out.println("Binary Search Result: " + binarySearch(products, "Smartphone").productName);
    }
}
