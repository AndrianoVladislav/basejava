package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {

    protected List<Resume> storage = new ArrayList<>();

    @Override
    public final void clear() {
        storage.clear();
    }

    @Override
    public final Resume[] getAll() {
        return storage.toArray(new Resume[storage.size()]);
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    protected final void doSave(Object searchKey, Resume resume) {
        storage.add(resume);
    }

    @Override
    protected final void doDelete(Object searchKey) {
        storage.remove((Integer) searchKey);
    }

    @Override
    protected final void doUpdate(Object searchKey, Resume resume) {
        storage.set((Integer) searchKey, resume);
    }

    @Override
    protected final Resume doGet(Object searchKey) {
        return storage.get((Integer) searchKey);
    }

    @Override
    protected boolean isExist(Object getSearchKey) {
        return getSearchKey != null;
    }

    @Override
    protected Object getSearchKey(String uuid) {
        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return null;
    }
}