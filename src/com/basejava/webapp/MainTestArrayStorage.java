package com.basejava.webapp;

import com.basejava.webapp.exception.NotExistStorageException;
import com.basejava.webapp.model.Resume;
import com.basejava.webapp.storage.MapUuidStorage;
import com.basejava.webapp.storage.Storage;

/**
 * Test for your com.basejava.webapp.storage.ArrayStorage implementation
 */
public class MainTestArrayStorage {
    static final Storage ARRAY_STORAGE = new MapUuidStorage();

    public static void main(String[] args) {
        Resume r1 = new Resume("name1");
        Resume r2 = new Resume("name2");
        Resume r3 = new Resume("name3");

        ARRAY_STORAGE.save(r1);
        ARRAY_STORAGE.save(r2);
        ARRAY_STORAGE.save(r3);

        System.out.println("Get r1: " + ARRAY_STORAGE.get(r1.getUuid()));
        System.out.println("Size: " + ARRAY_STORAGE.size());

        try {
            System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));
        } catch (NotExistStorageException e) {
            System.out.println(e.getMessage());
        }

        printAll();
        ARRAY_STORAGE.update(r2);
        printAll();
        ARRAY_STORAGE.delete(r1.getUuid());
        printAll();
        ARRAY_STORAGE.clear();
        printAll();

        System.out.println("Size: " + ARRAY_STORAGE.size());
    }

    static void printAll() {
        System.out.println("\nGet All");
        for (Resume r : ARRAY_STORAGE.getAllSorted()) {
            System.out.println(r);
        }
    }
}
