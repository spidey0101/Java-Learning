public class MergeSort {

    public static void conquer(int arr[], int startIndx, int mid, int endIndex) {
        int merged[] = new int[endIndex - startIndx + 1];
        int idx1 = startIndx;
        int idx2 = mid + 1;
        int x = 0;

        while (idx1 <= mid && idx2 <= endIndex) {
            if (arr[idx1] <= arr[idx2]) {
                merged[x++] = arr[idx1++];
            } else {
                merged[x++] = arr[idx2++];
            }
        }

        while (idx1 <= mid) {
            merged[x++] = arr[idx1++];
        }
        while (idx2 <= endIndex) {
            merged[x++] = arr[idx2++];
        }

        for (int i = 0, j = startIndx; i < merged.length; i++, j++) {
            arr[j] = merged[i];
        }
    }

    public static void divide(int arr[], int startIndx, int endIndex) {
        if (startIndx >= endIndex) {
            return;
        }
        int mid = startIndx + (endIndex - startIndx) / 2;
        divide(arr, startIndx, mid);
        divide(arr, mid + 1, endIndex);

        conquer(arr, startIndx, mid, endIndex);

    }

    public static void main(String[] args) {
        int arr[] = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
        int n = arr.length;
        divide(arr, 0, n - 1);
        for (int element : arr) {
            System.out.print(element + " ");
        }

    }
}