{

    /** @list存储全排列的所有可能性

     */

    public static List list;

    public static void permutation(int[] array, int index) {

        if (index > array.length) {

            return;

        }

        if (index == array.length) {

            StringBuilder b = new StringBuilder();

            for (int i = 0; i < array.length; i++) {

                b.append("" + array[i]);

            }

            list.add(b.toString());

        }

        for (int i = index; i < array.length; i++) {

            swap(array, index, i);

            permutation(array, index + 1);

            swap(array, index, i); // 再次交换，保持原状

        }

    }

    private static void swap(int[] array, int index, int target) {

        int tmp = array[index];

        array[index] = array[target];

        array[target] = tmp;

    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        while (scan.hasNext()) {

            int n = scan.nextInt();

            int array[] = new int[n];

            for (int i = 0; i < array.length; i++) {

                array[i] = scan.nextInt();

            }

            list = new ArrayList();

            permutation(array, 0);

            Collections.sort(list);

            for (Object str : list) {
                System.out.println(str.toString());

            }

        }

    }

}
