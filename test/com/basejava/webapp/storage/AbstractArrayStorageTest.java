package com.basejava.webapp.storage;

import com.basejava.webapp.exception.ExistStorageException;
import com.basejava.webapp.exception.NotExistStorageException;
import com.basejava.webapp.exception.StorageException;
import com.basejava.webapp.model.Resume;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public abstract class AbstractArrayStorageTest {

    protected final Storage storage;

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final Resume r_3 = new Resume(UUID_3);
    private static final String UUID_4 = "uuid4";
    private static final Resume r_4 = new Resume(UUID_4);

    protected AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @BeforeEach
    public void setUp() throws Exception {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }


    @Test
    void save() {
        storage.save(new Resume(UUID_4));
        Assertions.assertEquals(4, storage.size());
        storage.get(UUID_4);
    }

    @Test
    void saveOverFlow() throws Exception {
        Assertions.assertThrows(StorageException.class, () -> {
            for (int i = 4; i <= AbstractArrayStorage.STORAGE_LIMIT; i++) {
                storage.save(new Resume());
            }
            storage.save(new Resume());
        });
    }

    @Test
    void saveExist() throws Exception {
        Assertions.assertThrows(ExistStorageException.class, () -> storage.save(r_3));
    }

    @Test
    void delete() {
        storage.delete(UUID_3);
        Assertions.assertEquals(2, storage.size());
    }

    @Test
    void deleteNotExist() throws Exception {
        Assertions.assertThrows(NotExistStorageException.class, () -> storage.delete(UUID_4));
    }

    @Test
    void update() {
        storage.update(r_3);
        Assertions.assertEquals(3, storage.size());
        storage.get(UUID_3);
    }
    @Test
    void updateNotExist() throws Exception {
        Assertions.assertThrows(NotExistStorageException.class, () -> storage.update(r_4));
    }

    @Test
    void clear() {
        storage.clear();
        Assertions.assertEquals(0, storage.size());
    }

    @Test
    void getAll() {
        storage.getAll();
        Resume[] resume = storage.getAll();
        Assertions.assertArrayEquals(storage.getAll(), resume);
    }

    @Test
    void size() {
        Assertions.assertEquals(3, storage.size());
    }

    @Test
    void get() {
        storage.get(UUID_1);
        storage.get(UUID_2);
        storage.get(UUID_3);
    }

    @Test
    public void getNotExist() throws Exception {
        Assertions.assertThrows(NotExistStorageException.class, () -> storage.get("dummy"));
    }
}