

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Question5 {


    public static void main(String[] args) {

        String path="/home/sudheer/Downloads/archive/matches.csv";
        String line="";

        try {
            BufferedReader br=new BufferedReader(new FileReader(path));
            HashMap tossWinner=new HashMap();
            while((line = br.readLine()) !=null) {

                String[] values=line.split(",");

                if(tossWinner.containsKey(values[6])) {
                    int count=(int) tossWinner.get(values[6]);
                    tossWinner.put(values[6],count+=1);

                }

                else {
                    tossWinner.put(values[6], 1);
                }

            }
            System.out.println("no of tosses won by each team");
            System.out.println(tossWinner);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }

    }

}