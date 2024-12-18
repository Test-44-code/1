package hash.p3;

class HashIntNode {
    public HashIntNode(int aKey) {
        key = aKey;
        }
        int key;
        HashIntNode next;
    }

    public class MyHashTableWithChainingForÍnts {
        // stores array of chains
        private HashIntNode bucketArray[];
        private int numOfBuckets = 0;
        private int size;

        // Constructor (Initializes capacity, size and empty chains).
        public MyHashTableWithChainingForÍnts(int aNumOfBuckets) {
            numOfBuckets = aNumOfBuckets;
            bucketArray = new HashIntNode[numOfBuckets];
            size = 0;
        }

        public int size() { return size; }
        
        public boolean isEmpty() { return size() == 0; }
        // This implements hash function to find index for a key
        private int getHashIndex(int key) {
            int hashCode = key; //.hashCode();
            int index = hashCode % numOfBuckets;
            return index;
            // ==> return Math.abs(key) % numOfBuckets;

        }
        
        // bitte diese Funktion löschen !!!!!
        
        // Method to remove a given key
//       public boolean remove(int key) {
            // Apply hash function to find index for given key
//        	 int index = getHashIndex(key);
//             HashIntNode head = bucketArray[index];
//             HashIntNode prev = null;
//
//             while (head != null) {
//                 if (head.key == key) {
//                     if (prev != null) {
//                         prev.next = head.next;
//                     } else {
//                         bucketArray[index] = head.next;
//                     }
//                     size--;
//                     return true;
//                 }
//                 prev = head;
//                 head = head.next;
//             }
//             return false;
//        }

        // Returns value for a key
        public int get(int key) {
            // Find head of chain for given key
        	// ==> hier die Änderung
        	int index = getHashIndex(key);
            HashIntNode head = bucketArray[index];

            while (head != null) {
                if (head.key == key) {
                    return key;
                }
                head = head.next;
            }
            return -1;
        }

        // Adds a key value pair to hash
        public void add(int key) {
          // Find head of chain for given key
        	// ==> hier die Änderung
        	int index = getHashIndex(key);
            HashIntNode head = bucketArray[index];

            while (head != null) {
                if (head.key == key) {
                    return;
                }
                head = head.next;
            }

            HashIntNode newNode = new HashIntNode(key);
            newNode.next = bucketArray[index];
            bucketArray[index] = newNode;
            size++;
          }

    public void printAllChains() {
        for (int i = 0; i < numOfBuckets; i++) {
            System.out.print("Bucket " + i + ": ");
            HashIntNode head = bucketArray[i];
            while (head!= null) {
                System.out.print(head.key + " -> ");
                head = head.next;
            }
            System.out.println("null");
        }
    }

    public static void testRoutines() {

        MyHashTableWithChainingForÍnts map = new MyHashTableWithChainingForÍnts(5);
        map.add(1 );
        map.add(2 );
        map.add(4 );
        map.add(5 );
        map.add(14);
        map.add(9);
        System.out.println(map.size());
        System.out.println(map.isEmpty());
        map.printAllChains();
    }

    // Driver method to test Map class
    public static void main(String[] args) {
        testRoutines();
    }
}