import java.io.*;
import java.util.*;

public class Main {

    // LIS 어케하더라?
    // 1. 나를 끝으로 하는 LIS의 최대 길이
    // 이전 dp 값들을 보면서, 내가 더 크면, dp 값 확인
    // 제일 큰 dp 값을 찾은 뒤 + 1
    // 2. tail 배열 구성(이분탐색)
    // 길이가 i인 LIS의 가장 작은 마지막 원소를 기억하는 tail 배열
    // 이 배열은 정의상 단조증가
    // 이번 숫자가... k면 v[i-1] < k <= v[i]인 위치를 찾아야 함.


    static int N;
    static int[] arr;
    //    static int[] dp;
    static int[] tail;
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        StringTokenizer st;
        while ((input = br.readLine()) != null) {
            int N = Integer.parseInt(input.trim());
            arr = new int[N];
            tail = new int[N];
//            dp = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            ans = -1;
//            dp[0] = 1;
//            for(int i=1;i<N;i++) {
//                int max = 0;
//                for(int j=0;j<i;j++)
//                    if(arr[j] < arr[i])
//                        max = Math.max(max, dp[j]);
//
//                dp[i] = max+1;
//                ans = Math.max(ans, dp[i]);
//            }
//
//            System.out.println(ans);

            int ans = 0;
            for (int i = 0; i < N; i++) {
                int lo = -1;
                int hi = ans;
                while (lo + 1 < hi) {
                    int mid = (lo + hi) / 2;
                    if (arr[i] <= tail[mid])
                        hi = mid;
                    else
                        lo = mid;
                }

                tail[hi] = arr[i];
                ans = Math.max(ans, hi+1);

            }

            System.out.println(ans);

        }

    }
}