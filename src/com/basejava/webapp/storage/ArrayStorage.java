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
        boolean q = false;
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(r.getUuid())) {
                q = true;
                break;
            }
        }
        if (q) {
            System.out.println("uuid: " + r.getUuid() + " уже существует!");
        } else if (size == storage.length) {
            System.out.println("Нет места.");
        } else {
            storage[size] = r;
            size++;
        }

    }

    public Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return storage[i];
            }
        }
        System.out.println("uuid: " + uuid + " не существует!");
        return null;
    }

    public void delete(String uuid) {
        int indexForDelete = -1;
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                indexForDelete = i;
                size--;
                System.arraycopy(storage, indexForDelete + 1, storage, indexForDelete, size - indexForDelete);
                storage[size] = null;
            }
        }
        if (indexForDelete == -1) {
            System.out.println("uuid: " + uuid + " не найден.");
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
}


