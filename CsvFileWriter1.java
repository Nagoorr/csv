import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.*;
import java.util.List;

public class CsvFileWriter1 {

    public static void main(String[] args) throws Exception {
        read();
    }

    public static void write() throws Exception {
        final String NEW_LINE = "\n";
        final char COMMA_CHAR = ',';
        final String HEADER = "ID,NAME,GENDER";
        List<StudentDetails> studentDetails = Arrays.asList(new StudentDetails(1, "Nagoor", "Male"), new StudentDetails(2, "Sai", "male"));

        FileWriter fileWriter = new FileWriter(new File("D:\\nagoor\\commoncsv.csv"));
        fileWriter.append(HEADER);
        fileWriter.append(NEW_LINE);
        for (StudentDetails studentDetails1 : studentDetails) {
            fileWriter.append(String.valueOf(studentDetails1.getId()));
            fileWriter.append(COMMA_CHAR);
            fileWriter.append(studentDetails1.getName());
            fileWriter.append(COMMA_CHAR);
            fileWriter.append(studentDetails1.getGender());
            fileWriter.append(NEW_LINE);
        }
        fileWriter.flush();
        fileWriter.close();
        System.out.println("Saved Successfully");
    }

    public static void read() throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\nagoor\\data.csv"));
        String line;

        List<String> ids = new ArrayList<>();
        List<String> names = new ArrayList<>();
        List<String> genders = new ArrayList<>();
        List<String> headersList = new ArrayList<>();

        String header = bufferedReader.readLine();
        String[] headerArray = header.split(",");
        for (int i = 0; i < headerArray.length; i++) {
            if (headerArray[i].equalsIgnoreCase("id"))
                ids.add(headerArray[i]);
            else if (headerArray[i].equalsIgnoreCase("name"))
                names.add(headerArray[i]);
            else
                genders.add(headerArray[i]);
            headersList.add(headerArray[i]);
        }
       int row=0,column=0;

        List<String> arr = new ArrayList<>();
        while ((line = bufferedReader.readLine()) != null) {
            String[] data = line.split(",");
            for (int i = 0; i < data.length; i++) {
                arr.add(data[i]);

            }
            row++;
            column=data.length;
            ids.add(arr.get(headersList.indexOf("ID")));
            names.add(arr.get(headersList.indexOf("NAME")));
            genders.add(arr.get(headersList.indexOf("GENDER")));
        }
         ids.forEach(System.out::println);
    }
}
