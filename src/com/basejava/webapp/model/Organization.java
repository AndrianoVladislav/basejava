package com.basejava.webapp.model;

import java.util.List;
import java.util.Objects;

public class Organization {
    private final String name;
    private final List<Period> periods;

    public Organization(String name, List<Period> periods) {
        Objects.requireNonNull(name, "name mustn't be null");
        Objects.requireNonNull(periods, "periods mustn't be null");
        this.name = name;
        this.periods = periods;
    }

    public String getName() {
        return name;
    }

    public List<Period> getPeriods() {
        return periods;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organization that = (Organization) o;

        if (!name.equals(that.name)) return false;
        return periods.equals(that.periods);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + periods.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "name='" + name + '\'' +
                ", periods=" + periods +
                '}';
    }
}
