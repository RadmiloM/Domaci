import java.util.ArrayList;
import java.util.Arrays;

public class Zero {
    public static int[] moveZeroToEnd(int[] array){
        if(array.length == 0){
            return new int[]{};
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i =0 ; i < array.length;i++){
            if(array[i] != 0){
                list.add(array[i]);

            }
        }
        for(int i = 0; i <array.length;i++){
            if(array[i] == 0){
                list.add(array[i]);
            }
        }
        int[] result = new int[list.size()];
        for(int i = 0; i < list.size();i++){
            result[i] = list.get(i);
        }
        return  result;

    }

    public static void main(String[] args) {
        int[] array = new int[]{1,0,2,0,3,0,4,0};
        moveZeroToEnd(array);
    }
}
