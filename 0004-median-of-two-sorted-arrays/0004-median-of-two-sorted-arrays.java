class Solution {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int na = A.length;
        int nb = B.length;
        int n = na + nb;
        if ((na + nb) % 2 == 1) {
            return binary(A, B, n / 2, 0, na - 1, 0, nb - 1);
        } else {
            return (double) (binary(A, B, n / 2, 0, na - 1, 0, nb - 1) + binary(A, B, n / 2 - 1, 0, na - 1, 0, nb - 1)) / 2;
        }
    }

    public int binary(int[] A, int[] B, int k, int aStart, int aEnd, int bStart, int bEnd) {
        if (aEnd < aStart) {
            return B[k - aStart];
        }
        if (bEnd < bStart) {
            return A[k - bStart];
        }

        int aIndex = (aStart + aEnd) / 2;
        int bIndex = (bStart + bEnd) / 2;
        int aValue = A[aIndex];
        int bValue = B[bIndex];
        
        if (aIndex + bIndex < k) {
            if (aValue > bValue) {
                return binary(A, B, k, aStart, aEnd, bIndex + 1, bEnd);
            } else {
                return binary(A, B, k, aIndex + 1, aEnd, bStart, bEnd);
            }
        }
        else {
            if (aValue > bValue) {
                return binary(A, B, k, aStart, aIndex - 1, bStart, bEnd);
            } else {
                return binary(A, B, k, aStart, aEnd, bStart, bIndex - 1);
            }
        }
    }
}