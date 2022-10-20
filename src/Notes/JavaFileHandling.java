package Notes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JavaFileHandling {
    public static void main(String[] args) {
        File file = new File("/d/GitRepos/learngit/readme.txt");
        BufferedReader reader = null;
        try{
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;

            while ((tempString = reader.readLine()) != null){
                System.out.println("line " + line + ": " + tempString);
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null){
                try {
                    reader.close();
                } catch (IOException e1){
                }
            }
        }
    }
}
