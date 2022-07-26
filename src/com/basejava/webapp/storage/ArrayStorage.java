package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private final Resume[] storage = new Resume[10000];
    private int size;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume resume, Resume resume2) {
        boolean q = false;
        for (int i = 0; i < size; i++) {
            if (storage[i].equals(resume)) {
                storage[i] = resume2;
                q = true;
            }
        }
        if (!q) {
            System.out.println("uuid: " + resume.getUuid() + " не существует!");
        }
    }

    public void save(Resume r) {
        if (check(r.getUuid()) == -1) {
            if (size == storage.length) {
                System.out.println("Нет места.");
            } else {
                storage[size] = r;
                size++;
            }
        } else {
            System.out.println("uuid: " + r.getUuid() + " уже существует!");
        }
    }

    public Resume get(String uuid) {
        if (check(uuid) == -1) {
            System.out.println("uuid: " + uuid + " не существует!");
            return null;
        } else {
            return storage[check(uuid)];
        }
    }

    public void delete(String uuid) {
        int index = check(uuid);
        if (index == -1) {
            System.out.println("uuid: " + uuid + " не найден.");
        } else {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    private int check(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}


