package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public final void save(Resume r) {
        int index = getIndex(r.getUuid());
        if (size == STORAGE_LIMIT) {
            System.out.println("Нет места.");
        } else if (index >= 0) {
            System.out.println("uuid: " + r.getUuid() + " уже существует!");
        } else {
            saveResume(index, r);
            size++;
        }
    }

    public final void delete(String uuid) {
        int index = getIndex(uuid);
        if (index <= -1) {
            System.out.println("uuid: " + uuid + " не найден.");
        } else {
            size--;
            deleteResume(index);
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

    protected abstract void saveResume(int index, Resume resume);

    protected abstract void deleteResume(int index);
}