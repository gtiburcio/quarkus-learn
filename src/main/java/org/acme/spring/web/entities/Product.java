package org.acme.spring.web.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Table(name = "product")
public class Product extends PanacheEntity  {

    private String name;

    private double value;

    public Product(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.value, value) == 0 &&
                Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, value);
    }
}
