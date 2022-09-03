package com.basejava.webapp.model;

import java.util.List;
import java.util.Objects;

public class SectionClassified extends Section {
    private final List<Classified> classifieds;

    public SectionClassified(List<Classified> classifieds) {
        Objects.requireNonNull(classifieds, "classifieds mustn't be null");
        this.classifieds = classifieds;
    }

    public List<Classified> getClassifieds() {
        return classifieds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SectionClassified that = (SectionClassified) o;

        return classifieds.equals(that.classifieds);
    }

    @Override
    public int hashCode() {
        return classifieds.hashCode();
    }

    @Override
    public String toString() {
        return "SectionClassified{" +
                "classifieds=" + classifieds +
                '}';
    }
}
