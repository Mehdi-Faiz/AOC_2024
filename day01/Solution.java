import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;  // Import the File class
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;
import java.util.Collections;


public class Solution{

    public static void main(String[] args){

        String filePath = "input.txt";

        ArrayList<Integer> column1 = new ArrayList<>();
        ArrayList<Integer> column2 = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){

            String line;
            while((line = reader.readLine()) != null){
                String [] parts = line.split("   ");
                column1.add(Integer.parseInt(parts[0]));
                column2.add(Integer.parseInt(parts[1]));
            }

        }catch (IOException e){
            e.printStackTrace();
        }

        Collections.sort(column1);
        Collections.sort(column2);

        int total = 0;

        //PART 1
        // for (int i = 0; i < column1.size(); i++){
        //     total += Math.abs(column1.get(i) - column2.get(i));
        // }

        // System.out.println(total);

        //PART 2

        for (int i = 0; i < column1.size(); i++){

            int reps = 0;
            for(int j = 0; j < column2.size(); j++){
                if(column1.get(i).equals(column2.get(j))){
                    reps+=1;
                }
            }
            total += column1.get(i) * reps;
        }
        System.out.println(total);
    }
}
