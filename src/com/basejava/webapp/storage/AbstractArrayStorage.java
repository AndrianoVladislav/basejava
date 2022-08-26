package com.basejava.webapp.storage;

import com.basejava.webapp.exception.StorageException;
import com.basejava.webapp.model.Resume;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    protected abstract Integer getSearchKey(String uuid);

    protected abstract void saveResume(int index, Resume resume);

    protected abstract void deleteResume(int index);

    @Override
    public final void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public List<Resume> doGetAllSorted() {
        return Arrays.stream(storage).toList();
    }

    @Override
    public final int size() {
        return size;
    }

    @Override
    protected final void doSave(Object searchKey, Resume resume) {
        if (size == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", resume.getUuid());
        } else {
            saveResume((Integer) searchKey, resume);
            size++;
        }
    }

    @Override
    protected final void doDelete(Object searchKey) {
        size--;
        deleteResume((Integer) searchKey);
        storage[size] = null;
    }

    @Override
    protected final void doUpdate(Object searchKey, Resume resume) {
        storage[(Integer) searchKey] = resume;
    }

    @Override
    protected final Resume doGet(Object searchKey) {
        return storage[(Integer) searchKey];
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return (Integer) searchKey >= 0;
    }

}