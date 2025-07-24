import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static final int MAX = 4_000_000;
    static boolean[] isNotPrime;
    static List<Integer> primes;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        isNotPrime = new boolean[MAX+1];
        for(int i=2;i*i<MAX+1;i++) {
            if(isNotPrime[i])
                continue;
            for(int j=i*i;j<MAX+1;j+=i) {
                isNotPrime[j] = true;
            }
        }

        primes = new ArrayList<>();
        for(int i=2;i<MAX+1;i++) {
            if(!isNotPrime[i])
                primes.add(i);
        }

        M = primes.size();
        int end = 0;
        int sum = 0;
        int count = 0;
        for(int start=0;start<M;start++) {
            while(end < M && sum < N) {
                sum += primes.get(end);
                end++;
            }

            if(sum == N)
                count++;

            sum -= primes.get(start);
        }

        System.out.println(count);
    }

}