package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    private final Resume searchKey = new Resume();

    @Override
    public void save(Resume r) {
        int index = getIndex(r.getUuid());
        if (size == STORAGE_LIMIT) {
            System.out.println("Нет места.");
        } else if (index >= 0) {
            System.out.println("uuid: " + r.getUuid() + " уже существует!");
        } else {
            index = -index - 1;
            if (index != size) {
                System.arraycopy(storage, index, storage, index + 1, size - index);
            }
            storage[index] = r;
            size++;
        }
    }

    @Override
    protected int getIndex(String uuid) {
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

}
