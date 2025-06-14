package recurion;

import java.util.ArrayList;
import java.util.Arrays;

public class GenrateAllSubSets {

    public static void main(String[] args) {
        genrateAllSubSets(0, new ArrayList<Integer>() , new int[] {1,2,3});
    }

    private static void genrateAllSubSets(int idx, ArrayList<Integer> ls, int[] arr) {

        if(idx == arr.length){
            System.out.println(ls.toString());
            return;
        }
        genrateAllSubSets(idx + 1, ls, arr);
        ls.add(arr[idx]);
        genrateAllSubSets(idx +1, ls, arr);
        ls.remove(ls.size() - 1);

    }


}
