

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Question4 {


    public static void main(String[] args) {

        String path="/home/sudheer/Downloads/archive/matches.csv";
        String deliveriesFilePath="/home/sudheer/Downloads/archive/deliveries.csv";
        String line="";

        try {
            BufferedReader br=new BufferedReader(new FileReader(path));
            List<String> matchIds=new ArrayList<>();
            while((line = br.readLine()) !=null) {
                String[] values=line.split(",");
                if(values[1].equals("2015")) {
                    matchIds.add(values[0]);
                }
            }
            System.out.println(matchIds);

            BufferedReader br1=new BufferedReader(new FileReader(deliveriesFilePath));

            HashMap<String,Integer> teamExtraRuns=new HashMap();
            while((line = br1.readLine()) !=null) {

                String[] values=line.split(",");
                if (matchIds.contains(values[0])){
                    if(teamExtraRuns.containsKey(values[3])) {
                        int count=teamExtraRuns.get(values[3]);
                        teamExtraRuns.put(values[3],count+Integer.valueOf(values[16]));

                    }

                    else {
                        teamExtraRuns.put(values[3], Integer.valueOf(values[16]));
                    }

                }



            }
            //System.out.println("For the year 2016 the extra runs conceded per team");
            //System.out.println(teamExtraRuns);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }

    }

}