import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Main {

    public void setPrint(HashSet<Integer>[] array, ArrayList<Integer> accu, int index) {
        if(index == array.length) {
            for(Integer ele: accu) {
                System.out.print(ele+" ");
            }
            System.out.println();
            return;
        }

        HashSet<Integer> set = array[index];
        for(Integer ele: set) {
            accu.add(ele);
            setPrint(array, accu, index+1);
            accu.remove(accu.size()-1);
        }
    }

    public static void main(String[] args) {

        HashSet<Integer>[] array = new HashSet[2];
        array[0] = new HashSet<>(Arrays.asList(0,1,2));
        array[1] = new HashSet<>(Arrays.asList(3,2));
        Main main= new Main();
        main.setPrint(array, new ArrayList<Integer>(), 0);
    }
}
