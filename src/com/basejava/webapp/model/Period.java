package com.basejava.webapp.model;

import java.util.Objects;

public class Period {

    private final String startDate;
    private final String endDate;
    private final String title;
    private final String description;

    public Period(String startDate, String endDate, String title, String description) {
        Objects.requireNonNull(startDate, "startDate mustn't be null");
        Objects.requireNonNull(endDate, "endDate mustn't be null");
        Objects.requireNonNull(title, "title mustn't be null");
        this.startDate = startDate;
        this.endDate = endDate;
        this.title = title;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Period that = (Period) o;

        if (!startDate.equals(that.startDate)) return false;
        if (!endDate.equals(that.endDate)) return false;
        if (!title.equals(that.title)) return false;
        return Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        int result = startDate.hashCode();
        result = 31 * result + endDate.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        if (description == null) {
            return "OrganizationPeriod{" +
                    "startDate='" + startDate + '\'' +
                    ", endDate='" + endDate + '\'' +
                    ", secondTitle='" + title + '\'' +
                    '}';
        }
        return "OrganizationPeriod{" +
                "startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", secondTitle='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
