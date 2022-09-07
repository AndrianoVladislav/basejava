package com.basejava.webapp.model;

import java.util.List;
import java.util.Objects;

public class Organization {
    private final String mainTitle;
    private final List<OrganizationPeriod> periods;

    public Organization(String mainTitle, List<OrganizationPeriod> periods) {
        Objects.requireNonNull(mainTitle, "mainTitle mustn't be null");
        Objects.requireNonNull(periods, "periods mustn't be null");
        this.mainTitle = mainTitle;
        this.periods = periods;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organization that = (Organization) o;

        if (!mainTitle.equals(that.mainTitle)) return false;
        return periods.equals(that.periods);
    }

    @Override
    public int hashCode() {
        int result = mainTitle.hashCode();
        result = 31 * result + periods.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "mainTitle='" + mainTitle + '\'' +
                ", periods=" + periods +
                '}';
    }
}
