package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.ArrayList;

public class ListStorage extends AbstractStorage {

    protected ArrayList<Resume> storage = new ArrayList<>();
    private Resume newResume;

    @Override
    protected final void resumeSave(Resume resume) {
        storage.add(resume);
    }

    @Override
    protected final void resumeDelete(String uuid) {
        newResume = new Resume(uuid);
        storage.remove(newResume);
    }

    @Override
    protected final void resumeUpdate(Resume resume) {
        storage.set(storage.indexOf(resume), resume);
    }

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
    protected final Resume resumeGet(String uuid) {
        newResume = new Resume(uuid);
        return storage.get(storage.indexOf(newResume));
    }

    @Override
    protected boolean resumeExist(Resume resume) {
        return storage.contains(resume);
    }

    @Override
    protected boolean resumeNotExist(String uuid) {
        Resume newResume = new Resume(uuid);
        return !storage.contains(newResume);
    }
}
