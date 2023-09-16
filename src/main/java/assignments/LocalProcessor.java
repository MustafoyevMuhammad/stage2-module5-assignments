package assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalProcessor {
    private String processorName = "";
    private Long period = 10000000000000L;
    protected String processorVersion = "";
    private Scanner informationScanner;
    private LinkedList<String> stringArrayList = new LinkedList<>();

    // Constructors...

    @ListIteratorAnnotation
    public void listIterator(LinkedList<String> stringList) {
        stringArrayList = new LinkedList<>(stringList);
        for (String str : stringArrayList) {
            System.out.println(str.hashCode());
        }
    }

    @FullNameProcessorGeneratorAnnotation
    public String fullNameProcessorGenerator(LinkedList<String> stringList) {
        for (String str : stringList) {
            processorName += str + ' ';
        }
        return processorName.trim();
    }

    @ReadFullProcessorNameAnnotation
    public void readFullProcessorName(File file) throws FileNotFoundException {
        informationScanner = new Scanner(file);
        while (informationScanner.hasNextLine()) {
            processorVersion += informationScanner.nextLine();
        }
        informationScanner.close(); // Ensure scanner is closed
    }
}