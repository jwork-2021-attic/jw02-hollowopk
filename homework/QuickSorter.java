package homework;

public class QuickSorter implements Sorter {

    private int[] a;

    @Override
    public void load(int[] a) {
        this.a = a;
    }

    private void swap(int i, int j) {
        int temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        plan += "" + i + "<->" + j + "\n";
    }

    private String plan = "";

    @Override
    public void sort() {
        quicksort(0, a.length-1);
    }

    private void quicksort(int left, int right) {
        if (left >= right) {
            return;
        }

        int p = a[left];
        int i = left, j = right;

        while (i < j) {
            while (i < j && a[j] >= p) {
                j--;
            }
            if (i < j) {
                swap(i, j);
            }
            while (i < j && a[i] <= p) {
                i++;
            }
            if (i < j) {
                swap(i, j);
            }
        }
        a[i] = p;

        quicksort(left, i-1);
        quicksort(i+1, right);
    }

    @Override
    public String getPlan() {
        return this.plan;
    }

}
