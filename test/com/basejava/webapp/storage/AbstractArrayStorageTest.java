package com.basejava.webapp.storage;

import com.basejava.webapp.exception.ExistStorageException;
import com.basejava.webapp.exception.NotExistStorageException;
import com.basejava.webapp.exception.StorageException;
import com.basejava.webapp.model.Resume;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class AbstractArrayStorageTest {

    protected final Storage storage;

    private static final String UUID_NOT_EXIST = "000";
    private static final Resume RESUME_NOT_EXIST = new Resume(UUID_NOT_EXIST);
    private static final String UUID_1 = "uuid1";
    private static final Resume RESUME_1 = new Resume(UUID_1);
    private static final String UUID_2 = "uuid2";
    private static final Resume RESUME_2 = new Resume(UUID_2);
    private static final String UUID_3 = "uuid3";
    private static final Resume RESUME_3 = new Resume(UUID_3);
    private static final String UUID_4 = "uuid4";
    private static final Resume RESUME_4 = new Resume(UUID_4);

    protected AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @BeforeEach
    public void setUp() throws Exception {
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
    void saveOverflow() throws Exception {
        storage.clear();
        for (int i = 0; i < AbstractArrayStorage.STORAGE_LIMIT; i++) {
            storage.save(new Resume());
        }
        Assertions.assertThrows(StorageException.class, () -> storage.save(new Resume()));
    }

    @Test
    void saveExist() throws Exception {
        Assertions.assertThrows(ExistStorageException.class, () -> storage.save(RESUME_3));
    }

    @Test
    void delete() {
        storage.delete(UUID_3);
        assertSize(2);
        Assertions.assertThrows(NotExistStorageException.class, () -> storage.get(UUID_3));
    }

    @Test
    void deleteNotExist() throws Exception {
        Assertions.assertThrows(NotExistStorageException.class, () -> storage.delete(UUID_NOT_EXIST));
    }

    @Test
    void update() {
        Resume newResume = new Resume(UUID_3);
        storage.update(newResume);
        Assertions.assertSame(newResume, storage.get(UUID_3));
    }
    @Test
    void updateNotExist() throws Exception {
        Assertions.assertThrows(NotExistStorageException.class, () -> storage.update(RESUME_NOT_EXIST));
    }

    @Test
    void clear() {
        storage.clear();
        assertSize(0);
        Resume[] resume = new Resume[0];
        Assertions.assertArrayEquals(storage.getAll(), resume);
    }

    @Test
    void getAll() {
        storage.getAll();
        Resume[] resume = storage.getAll();
        Assertions.assertArrayEquals(resume,storage.getAll());
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
    public void getNotExist() throws Exception {
        Assertions.assertThrows(NotExistStorageException.class, () -> storage.get(UUID_NOT_EXIST));
    }

    private void assertSize(int numberComparison) {
        assertEquals(numberComparison, storage.size());
    }

    private void assertGet(Resume r) {
        assertEquals(r, storage.get(r.getUuid()));
    }
}