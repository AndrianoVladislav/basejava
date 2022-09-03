package com.basejava.webapp.storage;

import com.basejava.webapp.exception.ExistStorageException;
import com.basejava.webapp.exception.NotExistStorageException;
import com.basejava.webapp.model.Resume;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

public abstract class AbstractStorage<SK> implements Storage {

    private static final Logger LOG = Logger.getLogger(AbstractStorage.class.getName());

    protected abstract boolean isExist(SK searchKey);

    protected abstract void doSave(SK searchKey, Resume resume);

    protected abstract void doDelete(SK searchKey);

    protected abstract void doUpdate(SK searchKey, Resume resume);

    protected abstract Resume doGet(SK searchKey);

    protected abstract SK getSearchKey(String uuid);

    protected abstract List<Resume> doGetAllSorted();

    private final static Comparator<Resume> RESUME_COMPARATOR = Comparator.comparing(Resume::getFullName).thenComparing(Resume::getUuid);

    public final List<Resume> getAllSorted() {
        LOG.info("getAllSorted");
        List<Resume> resumes = new ArrayList<>(doGetAllSorted());
        resumes.sort(RESUME_COMPARATOR);
        return resumes;
    }

    public final void save(Resume resume) {
        LOG.info("Save " + resume);
        doSave(getExistingSearchKey(resume.getUuid()), resume);
    }

    public final void delete(String uuid) {
        LOG.info("Delete " + uuid);
        doDelete(getNotExistingSearchKey(uuid));
    }

    public final void update(Resume resume) {
        LOG.info("Update " + resume);
        doUpdate(getNotExistingSearchKey(resume.getUuid()), resume);
    }

    public final Resume get(String uuid) {
        LOG.info("Get " + uuid);
        return doGet(getNotExistingSearchKey(uuid));
    }

    private SK getExistingSearchKey(String uuid) {
        SK searchKey = getSearchKey(uuid);
        if (isExist(searchKey)) {
            LOG.warning("Resume " + uuid + " not exist");
            throw new ExistStorageException(uuid);
        }
        return searchKey;
    }

    private SK getNotExistingSearchKey(String uuid) {
        SK searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)) {
            LOG.warning("Resume " + uuid + " already exist");
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }
}
