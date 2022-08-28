package com.basejava.webapp.storage;

import com.basejava.webapp.exception.ExistStorageException;
import com.basejava.webapp.exception.NotExistStorageException;
import com.basejava.webapp.model.Resume;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class AbstractStorage implements Storage {

    protected abstract boolean isExist(Object searchKey);

    protected abstract void doSave(Object searchKey, Resume resume);

    protected abstract void doDelete(Object searchKey);

    protected abstract void doUpdate(Object searchKey, Resume resume);

    protected abstract Resume doGet(Object searchKey);

    protected abstract Object getSearchKey(String uuid);

    protected abstract List<Resume> doGetAllSorted();

    public final List<Resume> getAllSorted() {
        Comparator<Resume> sorted = Comparator.comparing(Resume::getFullName).thenComparing(Resume::getUuid);
        List<Resume> resumes = new ArrayList<>(doGetAllSorted());
        resumes.sort(sorted);
        return resumes;
    }

    public final void save(Resume resume) {
        doSave(getExistingSearchKey(resume.getUuid()), resume);
    }

    public final void delete(String uuid) {
        doDelete(getNotExistingSearchKey(uuid));
    }

    public final void update(Resume resume) {
        doUpdate(getNotExistingSearchKey(resume.getUuid()), resume);
    }

    public final Resume get(String uuid) {
        return doGet(getNotExistingSearchKey(uuid));
    }

    private Object getExistingSearchKey(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (isExist(searchKey)) {
            throw new ExistStorageException(uuid);
        }
        return searchKey;
    }

    private Object getNotExistingSearchKey(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)) {
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }
}
