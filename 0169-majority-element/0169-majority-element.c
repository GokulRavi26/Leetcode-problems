int majorityElement(int* nums, int numsSize) {
    int m = nums[0],
        c = 1;
    for (int i = 1; i < numsSize; i++) {
        if (c == 0) {
            m = nums[i];
            c++;
        } else if (m == nums[i]) {
            c++;
        } else {
            c--;
        }
    }
    return m;
}