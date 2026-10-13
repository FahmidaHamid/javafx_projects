package demo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LoadStudents {
    public static ArrayList<Student> loadStudents(String filename)
        throws IOException {

    ArrayList<Student> students = new ArrayList<>();

    try (Scanner reader = new Scanner(new File(filename))) {
        while (reader.hasNextLine()) {
            String line = reader.nextLine().trim();

            if (line.isEmpty()) {
                continue;
            }

            String[] parts = line.split(",");

            Student student = new Student(
                    parts[0].trim(),
                    parts[1].trim(),
                    Double.parseDouble(parts[2].trim())
            );

            students.add(student);
        }
    }

    return students;
}


}
