

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Question4 {

    public static void main(String[] args) {

        String path = "/home/sudheer/Downloads/archive/matches.csv";
        String deliveriesFilePath = "/home/sudheer/Downloads/archive/deliveries.csv";
        String line = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            List<String> matchIds = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values[1].equals("2015")) {
                    matchIds.add(values[0]);
                }
            }
            //System.out.println(matchIds);

            BufferedReader br1 = new BufferedReader(new FileReader(deliveriesFilePath));

            HashMap<String, Integer> bowlerRuns = new HashMap();
            HashMap<String, Integer> bowlerBalls = new HashMap();
            while ((line = br1.readLine()) != null) {

                String[] values = line.split(",");
                if (matchIds.contains(values[0]) && values[9].equals("0")) {
                    //adding balls to bowler if the ball is not a wide and no  ball
                    if (Integer.valueOf(values[10]) == 0 && Integer.valueOf(values[13]) == 0) {
                        if (bowlerBalls.containsKey(values[8])) {
                            bowlerBalls.put(values[8], bowlerBalls.get(values[8]) + 1);
                        } else {
                            bowlerBalls.put(values[8], 1);
                        }
                    }
                    //adding bowler runs by removing bye_runs and leg_bye_runs"
                    int runs = Integer.valueOf(values[17]) - Integer.valueOf(values[11]) - Integer.valueOf(values[12]);
                    if (bowlerRuns.containsKey(values[8])) {
                        bowlerRuns.put(values[8], bowlerRuns.get(values[8]) + runs);
                    } else {
                        bowlerRuns.put(values[8], runs);
                    }
                }
            }
            //adding bowler name and economy as key value pair in bowlerEconomies Hashmap
            HashMap<String, Float> bowlerEconomies = new HashMap();

            List<String> bowlers = new ArrayList<>(bowlerBalls.keySet());

            for (int i = 0; i < bowlers.size(); i++) {
                String bowler = bowlers.get(i);
                float overs = bowlerBalls.get(bowler) / 6;
                float economy = bowlerRuns.get(bowler) / overs;
                bowlerEconomies.put(bowler, economy);
            }

            /*System.out.println(bowlerBalls);
            System.out.println(bowlerRuns);*/
            System.out.println(bowlerEconomies);

            HashMap<String, Float> sortedBowlerEconomies = sortByValue(bowlerEconomies);
            System.out.println(sortedBowlerEconomies);

            Map.Entry<String, Float> entry = sortedBowlerEconomies.entrySet().iterator().next();
            String key = entry.getKey();
            Float value = entry.getValue();

            System.out.println("For the year 2015 the top economical bowler ---- Name : " + key + "  -- Economy : " + value);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static HashMap<String, Float> sortByValue(HashMap<String, Float> hm) {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Float>> list = new LinkedList<Map.Entry<String, Float>>(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Float>>() {
            public int compare(Map.Entry<String, Float> o1,
                               Map.Entry<String, Float> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<String, Float> temp = new LinkedHashMap<String, Float>();
        for (Map.Entry<String, Float> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

}