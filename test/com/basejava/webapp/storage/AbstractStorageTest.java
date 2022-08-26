package com.basejava.webapp.storage;

import com.basejava.webapp.exception.ExistStorageException;
import com.basejava.webapp.exception.NotExistStorageException;
import com.basejava.webapp.model.Resume;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class AbstractStorageTest {

    protected final Storage storage;

    private static final String UUID_NOT_EXIST = "000";
    private static final Resume RESUME_NOT_EXIST = new Resume(UUID_NOT_EXIST);
    private static final String UUID_1 = "uuid1";
    private static final String NAME_1 = "name1";
    private static final Resume RESUME_1 = new Resume(UUID_1, NAME_1);
    private static final String UUID_2 = "uuid2";
    private static final String NAME_2 = "name2";
    private static final Resume RESUME_2 = new Resume(UUID_2, NAME_2);
    private static final String UUID_3 = "uuid3";
    private static final String NAME_3 = "name3";
    private static final Resume RESUME_3 = new Resume(UUID_3, NAME_3);
    private static final String UUID_4 = "uuid4";
    private static final String NAME_4 = "name4";
    private static final Resume RESUME_4 = new Resume(UUID_4, NAME_4);

    protected AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @BeforeEach
    public void setUp() {
        storage.clear();
        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);
    }


    @Test
    void save() {
        storage.save(RESUME_4);
        assertGet(RESUME_4);
        assertSize(4);
    }

    @Test
    void saveExist() {
        Assertions.assertThrows(ExistStorageException.class, () -> storage.save(RESUME_3));
    }

    @Test
    void delete() {
        storage.delete(UUID_3);
        assertSize(2);
        Assertions.assertThrows(NotExistStorageException.class, () -> storage.get(UUID_3));
    }

    @Test
    void deleteNotExist() {
        Assertions.assertThrows(NotExistStorageException.class, () -> storage.delete(UUID_NOT_EXIST));
    }

    @Test
    void update() {
        Resume newResume = new Resume(UUID_3, NAME_3);
        storage.update(newResume);
        Assertions.assertSame(newResume, storage.get(UUID_3));
    }

    @Test
    void updateNotExist() {
        Assertions.assertThrows(NotExistStorageException.class, () -> storage.update(RESUME_NOT_EXIST));
    }

    @Test
    public void clear() {
        storage.clear();
        assertSize(0);
    }

    @Test
    void getAllSorted() {
        List<Resume> resumes = storage.getAllSorted();
        assertEquals(RESUME_1, resumes.get(0));
        assertEquals(RESUME_2, resumes.get(1));
        assertEquals(RESUME_3, resumes.get(2));
    }

    @Test
    void size() {
        assertSize(3);
    }

    @Test
    void get() {
        assertGet(RESUME_1);
        assertGet(RESUME_2);
        assertGet(RESUME_3);
        assertSize(3);
    }

    @Test
    public void getNotExist() {
        Assertions.assertThrows(NotExistStorageException.class, () -> storage.get(UUID_NOT_EXIST));
    }


    private void assertSize(int numberComparison) {
        assertEquals(numberComparison, storage.size());
    }

    private void assertGet(Resume r) {
        assertEquals(r, storage.get(r.getUuid()));
    }
}