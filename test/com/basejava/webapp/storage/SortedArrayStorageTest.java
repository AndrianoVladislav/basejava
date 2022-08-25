package com.basejava.webapp.storage;

import com.basejava.webapp.exception.StorageException;
import com.basejava.webapp.model.Resume;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SortedArrayStorageTest extends AbstractStorageTest {

    protected SortedArrayStorageTest() {
        super(new SortedArrayStorage());
    }

    @Test
    void saveOverflow() {
        storage.clear();
        for (int i = 0; i < AbstractArrayStorage.STORAGE_LIMIT; i++) {
            storage.save(new Resume());
        }
        Assertions.assertThrows(StorageException.class, () -> storage.save(new Resume()));
    }
}