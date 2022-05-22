

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Question3 {


    public static void main(String[] args) {

        String path="/home/sudheer/Downloads/archive/matches.csv";
        String line="";

        try {
            BufferedReader br=new BufferedReader(new FileReader(path));
            List<String> matchIds=new ArrayList<>();
            while((line = br.readLine()) !=null) {

                String[] values=line.split(",");

                if(values[1]=="2016") {

                    matchIds.add(values[0]);

                }



            }

            System.out.println(matchIds);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }

    }

}