package Section2;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by FI on 16-Apr-16.
 */
public class UtopianTree {
    public static void main(String[] args) {
        InputStream stdin = null;
        try {
            stdin = System.in;
            if (args.length > 0) {
                FileInputStream stream = new FileInputStream(args[0]);
                System.setIn(stream);
            }
            BufferedReader br =
                    new BufferedReader(new InputStreamReader(System.in));

            String input;
            int testCases = Integer.valueOf(br.readLine().trim());
            UtopianTree mySolution = new UtopianTree();
            for(int line= 0 ; line<testCases; line++){
                input = br.readLine().trim();
                System.out.println(mySolution.calculate(Integer.valueOf(input)));
            }

        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            System.setIn(stdin);
        }
    }

    private GrowTree tree = new GrowTree();
    private String[] quickSortArray;

    public UtopianTree() {
    }

    public String calculate(int season) {
        return String.valueOf(tree.getSeason(season));
    }

}

class GrowTree{
    private List<Integer> treeList = new ArrayList<>();

    public GrowTree() {
        treeList.add(1);
    }

    int getSeason(int season){
        if(season>=treeList.size()){
            runSeasons(season);
        }
        return treeList.get(season);
    }

    private void runSeasons(int targetSeason){
        int lastSeason = treeList.size()-1;
        for(int season=lastSeason+1;season<=targetSeason;season++){
            treeList.add(nextSeason(season,treeList.get(season-1)));
        }
    }

    private int nextSeason(int season, int treeSize){
        if(season%2==1){
            return treeSize*2;
        }
        else{
            return treeSize+1;
        }
    }
}