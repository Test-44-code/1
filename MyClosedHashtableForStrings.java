package hash.p3;

class MyClosedHashtableForStrings {
    protected int[] tagArray;
    private String[] bucketArray;
    protected int size;
    protected int capacity;
    static final int EMPTY = 0;
    static final int OCCUPIED = 1;
    static final int DELETED = 2;

    public int size() { return size; }
    public int getCapacity() { return capacity; }
    public boolean isEmpty() { return size == 0; }

    MyClosedHashtableForStrings(int aCapacity) {
        this.capacity = aCapacity;
        tagArray = new int[capacity];
        bucketArray = new String[capacity];
        for (int i = 0; i < capacity; i++) {
            tagArray[i] = EMPTY;
            bucketArray[i] = null;
        }
        size = 0;
    }

    public int getInitialHashIndex(String key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    public int searchForKey(String key) {
        int hashIndex = getInitialHashIndex(key);
        int startIndex = hashIndex;
        while (tagArray[hashIndex] != EMPTY) {
            if (tagArray[hashIndex] == OCCUPIED && bucketArray[hashIndex].equals(key)) {
                return hashIndex;
            }
            hashIndex = (hashIndex + 1) % capacity;
            if (hashIndex == startIndex) {
                break;
            }
        }
        return -1;
    }

    public void add(String key) {
        if (size == capacity) {
            System.out.println("Tabelle ist voll");
            return;
        }
        int hashIndex = getInitialHashIndex(key);
        while (tagArray[hashIndex] == OCCUPIED) {
            if (bucketArray[hashIndex].equals(key)) {
                System.out.println("Schlüssel ist bereits existiert");
                return;
            }
            hashIndex = (hashIndex + 1) % capacity;
        }
        bucketArray[hashIndex] = key;
        tagArray[hashIndex] = OCCUPIED;
        size++;
    }

    public boolean remove(String key) {
        int hashIndex = searchForKey(key);
        if (hashIndex != -1) {
            tagArray[hashIndex] = DELETED;
            bucketArray[hashIndex] = null;
            size--;
            return true;
        }
        return false;
    }

    public boolean find(String key) {
        return searchForKey(key) != -1;
    }

    public void printTable() {
        for (int i = 0; i < getCapacity(); i++) {
            switch (tagArray[i]) {
                case EMPTY:
                    System.out.print("[ ]");
                    break;
                case OCCUPIED:
                    System.out.print("(");
                    System.out.print(bucketArray[i]);
                    System.out.print(")");
                    break;
                case DELETED:
                    System.out.print("{");
                    System.out.print("}");
                    break;
            }
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void testRoutines() {
        MyClosedHashtableForStrings ht = new MyClosedHashtableForStrings(11);
        ht.add("one");
        ht.add("two");
        ht.add("three");
        ht.add("four");
        ht.add("five");
        ht.add("six");
        ht.add("seven");
        ht.add("eight");
        ht.add("twelve");
        ht.add("fifteen");
        ht.printTable();
        ht.add("sixteen");
        ht.printTable();
        System.out.println(ht.find("nine"));
        System.out.println(ht.find("three"));
        ht.remove("three");
        ht.remove("six");
        ht.remove("eight");
        ht.printTable();
    }

    public static void main(String[] args) {
        testRoutines();
    }
}
