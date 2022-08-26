package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {

    private final List<Resume> storage = new ArrayList<>();

    @Override
    public final void clear() {
        storage.clear();
    }

    @Override
    public List<Resume> doGetAllSorted() {
        return storage.stream().toList();
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
        storage.remove((int) searchKey);
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
    protected boolean isExist(Object searchKey) {
        return searchKey != null;
    }

    @Override
    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return null;
    }
}
