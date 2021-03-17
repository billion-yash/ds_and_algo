import java.util.Arrays;
import java.util.List;

public class DPFibonacci {
    public static int arr[] ;
    public static  void main(String... args){
        long prev = System.currentTimeMillis() ;
        arr =  new int[100];
        Arrays.fill(arr , -1);

        prev = System.currentTimeMillis();
        System.out.println(fib(4) + "   time =>" + (System.currentTimeMillis() - prev) );
//        prev = System.currentTimeMillis();
//        System.out.println(unoptimizedFib(35) + "   time =>" + (System.currentTimeMillis() - prev) );

    }

    private static int unoptimizedFib(int i) {
        if(i<=2)
            return 1;
        return unoptimizedFib(i-1) + unoptimizedFib(i-2);
    }

    private static int fib(int i){
       if(i<=2)
           return 1;

       if (arr[i-1]!=-1 && arr[i-2] != -1)
            return arr[i] = arr[i-1] + arr[i-2];
        if (arr[i-1]!=-1)
            return arr[i] = arr[i-1] + fib(i-2);
        if (arr[i-2]!= -1)
            return arr[i] = fib(i-1) + arr[i-2] ;

        return arr[i] = fib(i-1) + fib(i-2);
    }
}
