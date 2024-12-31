int maxProfit(int* p, int n) {
    int c=0;
    for(int i=0;i<n-1;i++)
    {
        if(*(p+i)<*(p+(i+1)))
        {
            c+=((*(p+(i+1))-*(p+i)));
        }
    }
    return c;
}