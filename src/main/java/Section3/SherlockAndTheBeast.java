package Section3;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by FI on 17-Apr-16.
 */
public class SherlockAndTheBeast {
    public static void main(String[] args) {
        InputStream stdin = null;
        try {
            stdin = System.in;
            if (args.length > 0) {
                FileInputStream stream = new FileInputStream(args[0]);
                System.setIn(stream);
            }
            Scanner scan = new Scanner(new InputStreamReader(System.in));
            int cases = scan.nextInt();
            scan.nextLine();
            for (int i = 0; i < cases; i++) {
                SherlockAndTheBeast mySolution = new SherlockAndTheBeast(scan);
                mySolution.calculate();
            }


        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            System.setIn(stdin);
        }
    }

    private String inputString;
    private int minStudents;
    private int dataArray[];

    public SherlockAndTheBeast(Scanner scanInput) {
        int arrayLen = scanInput.nextInt();
        minStudents = scanInput.nextInt();
        scanInput.nextLine();
        dataArray= new int[arrayLen];
        for(int i=0; i<arrayLen;i++){
            dataArray[i]=scanInput.nextInt();
        }
        if(scanInput.hasNextLine()){
            scanInput.nextLine();
        }
    }


    public void calculate() {
        Character lastChar=null;
        int studentCount=0;
        for(int student: dataArray){
            if(student<=0){
                studentCount++;
            }
        }
        if(studentCount>=minStudents) {
            System.out.println("NO");
        }else{
            System.out.println("YES");
        }
    }


}

