import java.lang.reflect.Field;
import java.util.HashMap;

class HashMapTreeMonitor {

    static class Key {
        final int id;

        public Key(int id) {
            this.id = id;
        }

        @Override
        public int hashCode() {
            System.out.println("Обратились за ключом");
            return 1;
        }

        @Override
        public boolean equals(Object o) {
            return false;
        }
    }

    public static void main(String[] args) throws Exception {
        HashMap<Key, Integer> map = new HashMap<>();

        Field tableField = HashMap.class.getDeclaredField("table");
        tableField.setAccessible(true);

        for (int i = 0; i < 20; i++) {
            Key key = new Key(i);
            map.put(key, i);

            Object[] table = (Object[]) tableField.get(map);
            if (table == null) continue;
            int targetBucket = (table.length - 1) & key.hashCode();
            Object node = table[targetBucket];

            if (node != null) {
                String nodeType = node.getClass().getSimpleName();
                if (nodeType.equals("Node")) {
                    System.out.println("Тут NODE итерация номер: " + i);
                }

                if (nodeType.equals("TreeNode")) {
                    System.out.println("А тут TreeNode итерация номер: " + i);
                }
            }
        }
    }
}