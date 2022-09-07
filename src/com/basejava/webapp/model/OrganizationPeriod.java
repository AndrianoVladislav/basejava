package com.basejava.webapp.model;

import java.util.Objects;

public class OrganizationPeriod {

    private final String startDate;
    private final String endDate;
    private final String secondTitle;
    private final String text;

    public OrganizationPeriod(String startDate, String endDate, String secondTitle, String text) {
        Objects.requireNonNull(startDate, "startDate mustn't be null");
        Objects.requireNonNull(endDate, "endDate mustn't be null");
        Objects.requireNonNull(secondTitle, "secondTitle mustn't be null");
        this.startDate = startDate;
        this.endDate = endDate;
        this.secondTitle = secondTitle;
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrganizationPeriod that = (OrganizationPeriod) o;

        if (!startDate.equals(that.startDate)) return false;
        if (!endDate.equals(that.endDate)) return false;
        if (!secondTitle.equals(that.secondTitle)) return false;
        return Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        int result = startDate.hashCode();
        result = 31 * result + endDate.hashCode();
        result = 31 * result + secondTitle.hashCode();
        result = 31 * result + (text != null ? text.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        if (text == null) {
            return "OrganizationPeriod{" +
                    "startDate='" + startDate + '\'' +
                    ", endDate='" + endDate + '\'' +
                    ", secondTitle='" + secondTitle + '\'' +
                    '}';
        }
        return "OrganizationPeriod{" +
                "startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", secondTitle='" + secondTitle + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
