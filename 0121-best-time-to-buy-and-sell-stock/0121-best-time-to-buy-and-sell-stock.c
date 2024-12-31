int maxProfit(int* p, int n) {
    int c=0,m=0;
    for(int i=n-1;i>=1;i--)
    {
        if(m<*(p+i))
        m=*(p+i);
        if(m>*(p+(i-1)))
        {
            if(c<(m-*(p+(i-1))))
            c=m-*(p+(i-1));
        }
        /*for(int j=i-1;j>=0;j--)
        {
            if(*(p+i)>*(p+j))
            {
                if(c<(*(p+i)-*(p+j)))
                c=*(p+i)-*(p+j);
            }
        } */
    }
    return c;
}