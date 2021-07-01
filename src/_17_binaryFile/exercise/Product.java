package _17_binaryFile.exercise;

import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private String name;
    private String madeBy;
    private int price;
    private String describeProduct;

    public Product() {
    }

    public Product(int id, String name, String maker, int price, String describeProduct) {
        this.id = id;
        this.name = name;
        this.madeBy = maker;
        this.price = price;
        this.describeProduct = describeProduct;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMadeBy() {
        return madeBy;
    }

    public void setMadeBy(String madeBy) {
        this.madeBy = madeBy;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescribeProduct() {
        return describeProduct;
    }

    public void setDescribeProduct(String describeProduct) {
        this.describeProduct = describeProduct;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", madeBy='" + madeBy + '\'' +
                ", price=" + price +
                ", describeProduct='" + describeProduct + '\'' +
                '}';
    }
}
