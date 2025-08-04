package org.example.DAO;

import java.util.Objects;

public class GenericDomain <T>{

    private T id;

    public GenericDomain(T id) {
        this.id = id;
    }

    public GenericDomain() {
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        GenericDomain<?> that = (GenericDomain<?>) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "GenericDomain{" +
                "id=" + id +
                '}';
    }
}
