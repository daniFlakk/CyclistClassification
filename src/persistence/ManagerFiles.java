package persistence;
import java.io.*;
/**
 * @author Santiago Ortega
 *@Date 10/03/2021
 */
public class ManagerFiles {

    private File file;
    private File filewrite;
    private FileReader fileReader;
    private FileWriter fileWriter;
    private BufferedWriter bufferedWriter = null;
    private BufferedReader bufferedReader = null;

    public static final char WRITER = 'w';
    public static final char READER = 'r';

    /**
     * Constructor de la clase
     * @param fileN
     */
    public ManagerFiles(String fileN) {
        file = new File(fileN);
    }

    public void newFile(char mode){
        try {
            if (mode == WRITER){
                fileWriter = new FileWriter(file);
                bufferedWriter = new BufferedWriter(fileWriter);
            }else {
                fileReader = new FileReader(file);
                bufferedReader = new BufferedReader(fileReader);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String reader(){
        String text = "";
        try {
            text = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }

    public void close(){
        try {
            if(bufferedReader != null)
                bufferedReader.close();
            if (bufferedWriter != null)
                bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeNewfile(String pathToSave, String cyclistBad){
        file = new File(pathToSave);
        try(FileWriter fw=new FileWriter(pathToSave)){

            fw.write(cyclistBad);

        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

}
