package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public void save(Resume r) {
        if (size == STORAGE_LIMIT) {
            System.out.println("Нет места.");
        } else if (getIndex(r.getUuid()) >= 0) {
            System.out.println("uuid: " + r.getUuid() + " уже существует!");
        } else {
            storage[size] = r;
            size++;
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index <= -1) {
            System.out.println("uuid: " + uuid + " не найден.");
        } else {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        }
    }

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index <= -1) {
            System.out.println("uuid: " + resume.getUuid() + " не существует!");
        } else {
            storage[index] = resume;
        }
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index <= -1) {
            System.out.println("uuid: " + uuid + " не существует!");
            return null;
        }
        return storage[index];
    }

    protected abstract int getIndex(String uuid);
}