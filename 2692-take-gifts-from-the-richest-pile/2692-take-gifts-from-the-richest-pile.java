class Solution {
    public long pickGifts(int[] gifts, int k) {
        // return solution1(gifts, k);
        return solution2(gifts, k);
    }

    private long solution1(int[] gifts, int k) {
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        long numGifts = 0;
        for (int gift : gifts) {
            maxHeap.add(gift);
            numGifts += gift;
        }
        for (int i = 0; i < k; i++) {
            int num = maxHeap.poll();
            int rem = (int) Math.sqrt(num);
            numGifts -= num - rem;
            maxHeap.add(rem);
        }
        return numGifts;
    }

    private long solution2(int[] gifts, int k) {
        int[] maxHeap = new int[gifts.length];
        long numGifts = 0;
        for (int i = 0; i < gifts.length; i++) {
            int gift = gifts[i];
            addToHeap(gift, maxHeap, i);
            numGifts += gift;
        }
        for (int i = 0; i < k; i++) {
            int num = removeFromHeap(maxHeap);
            int rem = (int) Math.sqrt(num);
            numGifts -= num - rem;
            addToHeap(rem, maxHeap);
        }
        return numGifts;
    }

    private void addToHeap(int num, int[] maxHeap, int pos) {
        maxHeap[pos] = num;
        while (pos > 0) {
            int parent = (pos - 1) / 2;
            if (maxHeap[parent] < maxHeap[pos]) {
                swap(maxHeap, parent, pos);
                pos = parent;
            } else {
                break;
            }
        }
    }

    private void addToHeap(int num, int[] maxHeap) {
        addToHeap(num, maxHeap, maxHeap.length - 1);
    }

    private void swap(int[] maxHeap, int a, int b) {
        int temp = maxHeap[a];
        maxHeap[a] = maxHeap[b];
        maxHeap[b] = temp;
    }

    private int removeFromHeap(int[] maxHeap) {
        int ret = maxHeap[0];
        maxHeap[0] = maxHeap[maxHeap.length - 1];
        heapify(maxHeap, maxHeap.length - 1);
        return ret;
    }

    private void heapify(int[] maxHeap, int heapSize) {
        int pos = 0;
        while (pos < heapSize) {
            int left = pos * 2 + 1;
            int right = pos * 2 + 2;
            if (left >= heapSize) {
                break;
            }
            if (right < heapSize && maxHeap[left] < maxHeap[right]) {
                if (maxHeap[right] > maxHeap[pos]) {
                    swap(maxHeap, pos, right);
                    pos = right;
                } else {
                    break;
                }
            } else {
                if (maxHeap[left] > maxHeap[pos]) {
                    swap(maxHeap, pos, left);
                    pos = left;
                } else {
                    break;
                }
            }
        }
    }
}