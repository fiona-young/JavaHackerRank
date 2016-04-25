package Section3;

import java.util.Scanner;
public class ContiguousCells {

        public static void main(String[] args) {
            Scanner scanIn = new Scanner(System.in);
            ContiguousCells myObject = new ContiguousCells(scanIn.nextLine().trim());
            System.out.println(myObject.calculate());
        }

    private final int SIZE = 10;
    private boolean[][] grid = new boolean[SIZE][SIZE];
    private int[][] connections = new int[SIZE][SIZE];
    int runningMax = 0;
    public ContiguousCells(String inputString){
        int x,y;
        String inputArray[] =inputString.split(",");
        for(String input: inputArray){
            x = Integer.valueOf(input.substring(0,1));
            y = Integer.valueOf(input.substring(1));
            grid[x][y]=true;
        }
    }

    public int calculate(){

        Integer start = null;
        for(int iRow = 0; iRow < SIZE; iRow++) {
            for (int iCol = 0; iCol < SIZE; iCol++) {
                if(grid[iCol][iRow]){
                    if(start == null){
                        start = iCol;
                    }
                    if(iCol == SIZE -1){
                        populateCells(iRow,start,iCol+1,iCol+1-start);
                        start = null;
                    }
                }
                else if (start != null){
                    populateCells(iRow,start,iCol,iCol-start);
                    start = null;
                }
            }
        }
        return runningMax;
    }

    private void populateCells(int iRow,int iStart,int iEnd,int number){
        int addBelow = 0;
        if(iRow == 2){
            int a = 1;
        }
        for(int i = iStart; i< iEnd ;i++){
            if(iRow > 0){
                addBelow = Math.max(addBelow,connections[iRow-1][iStart]);
            }
            connections[iRow][iStart]=number+ addBelow;
            runningMax = Math.max(runningMax,number+addBelow);
        }
    }
}
