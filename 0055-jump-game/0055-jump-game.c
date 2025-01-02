bool canJump(int* p, int n) {
    int p1=*(p+0);
    for(int i=1;i<n;i++)
    {
        if(p1==0) return false;
        p1--;
        if(p1<*(p+i)) p1=*(p+i);
    }
    return true;
}