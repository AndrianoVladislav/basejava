import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[3];
    int size;

    void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    void save(Resume r) {
        if (size == 3) {
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
        Resume a = new Resume();
        a.uuid = "Не найден.";
        return a;
    }

    void delete(String uuid) {
        int numberDeleteItem = -1;
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                numberDeleteItem = i;
                System.arraycopy(storage, numberDeleteItem + 1, storage, numberDeleteItem, size - numberDeleteItem - 1);
                size--;
                storage[size] = null;
            }
        }
        if (numberDeleteItem == -1) {
            System.out.println("uuid не найден.");
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size());
    }

    int size() {
        return size;
    }
}
