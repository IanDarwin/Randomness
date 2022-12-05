package com.darwinsys.random;

import java.util.Objects;

import org.w3c.dom.NameList;

public class Datum {
    long id;
    String name;
    int yearJoined;

    public Datum(int id, String name, int yearJoined) {
        this.id = id;
        this.name = name;
        this.yearJoined = yearJoined;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Datum datum = (Datum) o;

        if (id != datum.id) return false;
        if (yearJoined != datum.yearJoined) return false;
        return Objects.equals(name, datum.name);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + yearJoined;
        return result;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYearJoined(int yearJoined) {
        this.yearJoined = yearJoined;
    }

    public void setId(long id) {
        this.id = id;
    }
}
