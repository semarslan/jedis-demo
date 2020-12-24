package io.redis.jedis.jedisdemo.model;

import java.io.Serializable;

public class Programmer implements Serializable {

    private int id;
    private String company;
    private String name;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Programmer)) return false;

        Programmer that = (Programmer) o;

        if (getId() != that.getId()) return false;
        if (!getCompany().equals(that.getCompany())) return false;
        return getName().equals(that.getName());
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getName() {
        return name;
    }
    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getCompany().hashCode();
        result = 31 * result + getName().hashCode();
        return result;
    }

}
