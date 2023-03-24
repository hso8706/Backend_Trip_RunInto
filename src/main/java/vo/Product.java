package vo;

public class Product {
    String code;
    String model;
    String price;
    public Product() {}

    public Product(String code, String model, String price) {
        this.code = code;
        this.model = model;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
