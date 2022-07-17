import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size;

    void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    void save(Resume r) {
        if (size == 10000) {
            System.out.println("Нет места.");
        } else {
            storage[size] = r;
            size++;
        }
    }

    Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        int indexForDelete = -1;
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                indexForDelete = i;
                size--;
                System.arraycopy(storage, indexForDelete + 1, storage, indexForDelete, size - indexForDelete);
                storage[size] = null;
            }
        }
        if (indexForDelete == -1) {
            System.out.println("uuid не найден.");
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    int size() {
        return size;
    }
}
