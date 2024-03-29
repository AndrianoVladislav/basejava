package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

public class ArrayStorage extends AbstractArrayStorage {

    @Override
    public void saveResume(int index, Resume resume) {
        storage[size] = resume;
    }

    @Override
    public void deleteResume(int index) {
        storage[index] = storage[size];
    }

    @Override
    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}


