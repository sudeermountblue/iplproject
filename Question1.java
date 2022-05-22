

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Question1 {


    public static void main(String[] args) {

        String path="/home/sudheer/Downloads/archive/matches.csv";
        String line="";

        try {
            BufferedReader br=new BufferedReader(new FileReader(path));
            HashMap year=new HashMap();
            while((line = br.readLine()) !=null) {

                String[] values=line.split(",");

                if(year.containsKey(values[1])) {
                    int count=(int) year.get(values[1]);
                    year.put(values[1],count+=1);

                }

                else {
                    year.put(values[1], 1);
                }

            }
            System.out.println("no of matches played in each year");
            System.out.println(year);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }

    }

}