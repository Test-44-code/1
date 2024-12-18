package hash.p3;

class HashStringNode {
    public HashStringNode(String aKey) {
        key = aKey;
    }
    String key;
    HashStringNode next;
}

public class MyHashTableWithChainingForStrings {
    private HashStringNode[] bucketArray;
    private int numOfBuckets = 0;
    private int size;

    public MyHashTableWithChainingForStrings(int aNumOfBuckets) {
        numOfBuckets = aNumOfBuckets;
        bucketArray = new HashStringNode[numOfBuckets];
        size = 0;
    }

    public int size() { return size; }

    public boolean isEmpty() { return size == 0; }

    private int getHashIndex(String key) {
    	int hashCode = key.hashCode(); //.hashCode();
        int index = hashCode % numOfBuckets;
        return index;
    }

    public boolean remove(String key) {
    	return false;
    }
    
    public String get(String key) {
        int index = getHashIndex(key);
        HashStringNode head = bucketArray[index];

        while (head != null) {
            if (head.key.equals(key)) {
                return key;
            }
            head = head.next;
        }
        return null;
    }

    public void add(String key) {
        int index = getHashIndex(key);
        HashStringNode head = bucketArray[index];

        while (head != null) {
            if (head.key.equals(key)) {
                return;
            }
            head = head.next;
        }

        HashStringNode newNode = new HashStringNode(key);
        newNode.next = bucketArray[index];
        bucketArray[index] = newNode;
        size++;
    }

    public void printAllChains() {
        for (int i = 0; i < numOfBuckets; i++) {
            System.out.print("Bucket " + i + ": ");
            HashStringNode head = bucketArray[i];
            while (head != null) {
                System.out.print(head.key + " -> ");
                head = head.next;
            }
            System.out.println("null");
        }
    }

    public static void testRoutines() {
        MyHashTableWithChainingForStrings map = new MyHashTableWithChainingForStrings(5);
        map.add("one");
        map.add("two");
        map.add("four");
        map.add("five");
        map.add("fourteen");
        map.add("nine");
        System.out.println(map.size());
        System.out.println(map.isEmpty());
        map.printAllChains();
    }

    public static void main(String[] args) {
        testRoutines();
    }
}
