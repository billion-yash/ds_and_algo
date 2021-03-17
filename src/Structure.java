import static java.lang.Math.min;

public class Structure {



    public static void main(String args[]){
        printStructure(7);
    }


    public static void printStructure(int num){
        int row = 0;
        int column =  0;
       for (row = 0  ; row<2*num-1 ; row++){
            for (column = 0  ; column<2*num-1 ;column++){
                if(row < num ){
                    if(column<num){
                        System.out.print(num-min(row , column)+" ");
                    }
                    else{
                        System.out.print(num - min(row , 2*num-column-2)+" ");
                    }
                }
                else {
                    if(column<num){
                        System.out.print(num-min(2*num-row-2 , column)+" ");
                    }
                    else{
                        System.out.print(num - min(2*num-row-2  , 2*num-column-2)+ " ");
                    }
                }
            }
            System.out.println("");
        }
    }
}
