package com.basejava.webapp.model;

import java.util.List;
import java.util.Objects;

public class SectionList extends Section {

    private final List<String> list;

    public SectionList(List<String> list) {
        Objects.requireNonNull(list, "list mustn't be null");
        this.list = list;
    }

    public List<String> getList() {
        return list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SectionList that = (SectionList) o;

        return list.equals(that.list);
    }

    @Override
    public int hashCode() {
        return list.hashCode();
    }

    @Override
    public String toString() {
        return "SectionList{" +
                "list=" + list +
                '}';
    }
}
