class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1, right = 1000000000;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(numOfOperations(mid, nums) > maxOperations){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left;
    }
    public int numOfOperations(int penalty, int[] balls){
        int operations = 0;
        for(int ball: balls){
            operations += (ball - 1) / penalty;
        }
        return operations;
    }
}