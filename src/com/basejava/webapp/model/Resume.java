package com.basejava.webapp.model;

import java.util.Comparator;
import java.util.UUID;

public class Resume {

    private final String uuid;
    private final String fullName;

    public Resume(String fullName) {
        this(UUID.randomUUID().toString(), fullName);
    }

    public Resume(String uuid, String fullName) {
        this.uuid = uuid;
        this.fullName = fullName;
    }

    public String getUuid() {
        return uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resume resume = (Resume) o;

        return uuid.equals(resume.uuid);
    }

    @Override
    public int hashCode() {
        return uuid.hashCode();
    }

    @Override
    public String toString() {
        return uuid;
    }

    public String getFullName() {
        return fullName;
    }

    public static class ResumeFullNameComparator implements Comparator<Resume> {

        public int compare(Resume a, Resume b) {
            if (a == null) {
                return 0;
            }
            return a.getFullName().compareTo(b.getFullName());
        }
    }

    public static class ResumeUuidComparator implements Comparator<Resume> {

        public int compare(Resume a, Resume b) {
            if (a == null) {
                return 0;
            }
            return a.getUuid().compareTo(b.getUuid());
        }
    }
}


