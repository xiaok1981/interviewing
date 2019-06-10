import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class Main {

    public int smallerBiggest(int i) {
        if(i<= 0) {
            return 0;
        }

        ArrayList<Integer> array = new ArrayList<>();
        int num = i;
        while( num > 0) {
            array.add(num %10);
            num/=10;
        }
        int len = array.size();
        if(len == 1) return 0;
        char [] result = new char[len];
        int j=0; boolean flag = false;
        for(; j<len-1; j++) {
            int pre = array.get(j);
            int cur = array.get(j+1);
            if(pre < cur) {
                array.set(j, cur);
                array.set(j+1, pre);
                flag = true;
                break;
            } else {
                continue;
            }
        }
        if(flag==false) return i;

        List<Integer> list = array.subList(0, j);
        Collections.sort(array.subList(0, j));
        int index =len-1;
        for (Integer ele: list) {
            //System.out.print(ele);
            result[index--] = Integer.toString(ele).charAt(0);
        }

        for (int k=j; k< len; k++) {
            result[index--] = Integer.toString(array.get(k)).charAt(0);
        }
        return Integer.valueOf(new String(result));

    }

    public static void main(String[] args) {
        Main mi = new Main();
        System.out.println(mi.smallerBiggest(2134));
    }
}
