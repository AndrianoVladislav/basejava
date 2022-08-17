package com.basejava.webapp.storage;

import com.basejava.webapp.exception.ExistStorageException;
import com.basejava.webapp.exception.NotExistStorageException;
import com.basejava.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    public final void save(Resume resume) {
        if (resumeExist(resume)) {
            throw new ExistStorageException(resume.getUuid());
        } else {
            resumeSave(resume);
        }
    }

    public final void delete(String uuid) {
        if (resumeNotExist(uuid)) {
            throw new NotExistStorageException(uuid);
        } else {
            resumeDelete(uuid);
        }
    }

    public final void update(Resume resume) {
        if (resumeNotExist(resume.getUuid())) {
            throw new NotExistStorageException(resume.getUuid());
        } else {
            resumeUpdate(resume);
        }
    }

    public final Resume get(String uuid) throws NotExistStorageException {
        if (resumeNotExist(uuid)) {
            throw new NotExistStorageException(uuid);
        }
        return resumeGet(uuid);
    }

    protected abstract boolean resumeExist(Resume resume);

    protected abstract boolean resumeNotExist(String uuid);

    protected abstract void resumeSave(Resume resume);

    protected abstract void resumeDelete(String uuid);

    protected abstract void resumeUpdate(Resume resume);

    protected abstract Resume resumeGet(String uuid);
}
