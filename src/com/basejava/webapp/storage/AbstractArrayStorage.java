package com.basejava.webapp.storage;

import com.basejava.webapp.exception.StorageException;
import com.basejava.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    @Override
    protected final void resumeSave(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (size == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", resume.getUuid());
        } else {
            saveResume(index, resume);
            size++;
        }
    }

    @Override
    protected final void resumeDelete(String uuid) {
        int index = getIndex(uuid);
        size--;
        deleteResume(index);
        storage[size] = null;
    }

    @Override
    protected final void resumeUpdate(Resume resume) {
        int index = getIndex(resume.getUuid());
        storage[index] = resume;
    }

    @Override
    public final void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public final Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    @Override
    public final int size() {
        return size;
    }

    @Override
    protected final Resume resumeGet(String uuid) {
        int index = getIndex(uuid);
        return storage[index];
    }

    @Override
    protected boolean resumeExist(Resume resume) {
        return getIndex(resume.getUuid()) >= 0;
    }

    @Override
    protected boolean resumeNotExist(String uuid) {
        return getIndex(uuid) <= -1;
    }

    protected abstract int getIndex(String uuid);

    protected abstract void saveResume(int index, Resume resume);

    protected abstract void deleteResume(int index);
}