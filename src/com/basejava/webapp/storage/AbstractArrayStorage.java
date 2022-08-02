package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public abstract void save(Resume r);

    public final void delete(String uuid) {
        int index = getIndex(uuid);
        if (index <= -1) {
            System.out.println("uuid: " + uuid + " не найден.");
        } else {
            size--;
            System.arraycopy(storage, index + 1, storage, index, size - index);
            storage[size] = null;
        }
    }

    public final void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index <= -1) {
            System.out.println("uuid: " + resume.getUuid() + " не существует!");
        } else {
            storage[index] = resume;
        }
    }

    public final void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public final Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public final int size() {
        return size;
    }

    public final Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index <= -1) {
            System.out.println("uuid: " + uuid + " не существует!");
            return null;
        }
        return storage[index];
    }

    protected abstract int getIndex(String uuid);
}