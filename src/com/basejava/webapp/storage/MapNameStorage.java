package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapNameStorage extends AbstractStorage {

    private final Map<String, Resume> storage = new HashMap<>();

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public List<Resume> doGetAllSorted() {
        return storage.values().stream().toList();
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    protected void doSave(Object searchKey, Resume resume) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected void doDelete(Object searchKey) {
        storage.remove(((Resume) searchKey).getUuid());
    }

    @Override
    protected void doUpdate(Object searchKey, Resume resume) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return (Resume) searchKey;
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return searchKey != null;
    }

    @Override
    protected Resume getSearchKey(String uuid) {
        return storage.get(uuid);
    }
}
