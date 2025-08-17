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
        ArrayList<Integer> safe = new ArrayList<>();

        int total = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){

            String line;
            while((line = reader.readLine()) != null){
                String [] parts = line.split(" ");
                for(int i = 0; i < parts.length; i++){
                    safe.add(Integer.parseInt(parts[i]));
                }
                total = total + isLineSafe(safe);
                safe.clear();
            }

        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println(total);
    }


    static boolean ascending(ArrayList<Integer> safe){

        for (int i = 0; i < safe.size() - 1; i++){

            int diff = Math.abs(safe.get(i) - safe.get(i + 1));

            if((safe.get(i) > safe.get(i + 1)) || (diff < 1 || diff > 3)){
                return false;
            }
        }
        return true;
    }

    static boolean descending(ArrayList<Integer> safe){
        for (int i = 0; i < safe.size() - 1; i++){

            int diff = safe.get(i) - safe.get(i + 1);

            if((safe.get(i) < safe.get(i + 1)) || (diff < 1 || diff > 3)){
                return false;
            }
        }
        return true;
    }

    static int isLineSafe(ArrayList<Integer> safe){
        if(descending(safe) == true || ascending(safe) == true){
            return 1;
        }
        return 0;
    }
}
