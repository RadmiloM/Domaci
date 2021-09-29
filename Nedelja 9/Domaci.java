import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;



// Prvi zadatak:

public class Domaci {


    public static int multiplyOddNumbers(int number){
        if(number % 2 ==1){
            number = number * number;
        }
        return number;
    }
    public static int multiplyNumbersDivisibleByThree(int number){
        if(number % 3 == 0){
            number = number * number;
        }
        return number;
    }

    public static int isDivisible(int number){
        if(number % 3 ==0){
            number+=2;
        }
        return number;
    }
    public static List<Integer> incrementDivisbleByThree(List<Integer> list) {
        return list.stream().map(Domaci::isDivisible).collect(Collectors.toList());
    }


// Drugi zadatak:


    public static List<Integer> deleteNumbersDivisibleByThree(List<Integer> list){
        return list.stream().map(Domaci::multiplyNumbersDivisibleByThree).filter(x-> x % 3 !=0).collect(Collectors.toList());

    }

// Treci zadatak:

    public static List<Integer> multiplyAndDelete(List<Integer> list){
        return  list.stream().map(Domaci::multiplyOddNumbers).distinct().collect(Collectors.toList());
    }



    }




