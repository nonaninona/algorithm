import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.StringTokenizer;

class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        System.out.println((1 << 20) * 32);
//        int[] isShow = new int[(1 << 20)];
        BitSet bits  = new BitSet((1 << 25) + 1);
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            Integer num = Integer.parseInt(st.nextToken());
            if(!bits.get(num)){
                System.out.print(num + " ");
                bits.set(num);
            }
//            if((isShow[num/32] & (1 << (num%32))) == 0) {
//                System.out.print(num + " ");
//                isShow[num/32] = isShow[num/32] | (1 << (num%32));;
//            }
        }


    }

}
