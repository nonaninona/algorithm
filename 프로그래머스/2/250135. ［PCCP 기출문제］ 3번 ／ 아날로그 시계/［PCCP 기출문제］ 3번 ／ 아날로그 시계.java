class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int cnt1 = getCount(h1, m1, s1);
        int cnt2 = getCount(h2, m2, s2);
        
        int ans = cnt2-cnt1;
        long time1 = h1*3600 + m1*60 + s1;
        if((time1*59)%3600 == 0 || (time1*719)%43200 == 0) {
            ans++;
        }
        
        return ans;
    }
    
    int getCount(int h, int m, int s) {
        int seconds = h*3600 + m*60 + s;
        int cnt = 0;
        cnt += (seconds * 59)/3600;
        cnt += (seconds * 719)/43200;
        cnt -= seconds/43200;
        return cnt;
    }
}