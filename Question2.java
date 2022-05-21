

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Question2 {


    public static void main(String[] args) {

        String path="/home/sudheer/Downloads/archive/matches.csv";
        String line="";

        try {
            BufferedReader br=new BufferedReader(new FileReader(path));
            HashMap result=new HashMap();
            while((line = br.readLine()) !=null) {

                String[] values=line.split(",");
                System.out.println(values[10]);


            }
            System.out.println("no of matches won by  each team");
            System.out.println(result);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }

    }

}