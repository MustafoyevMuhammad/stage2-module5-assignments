package assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
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
    private List<String> stringArrayList = new LinkedList<>();

    // Constructors...

    @ListIteratorAnnotation
    public void listIterator(List<String> stringList) {
        stringArrayList = new LinkedList<>(stringList);
        for (String str : stringArrayList) {
            System.out.println(str.hashCode());
        }
    }

    @FullNameProcessorGeneratorAnnotation
    public String fullNameProcessorGenerator(LinkedList<String> stringList) {
        StringBuilder sb = new StringBuilder();
        for (String str : stringList) {
             sb.append(str);
             sb.append(" ");
        }
        processorName = String.valueOf(sb.toString());
        return processorName.trim();
    }

    @ReadFullProcessorNameAnnotation
    public void readFullProcessorName(File file) throws FileNotFoundException {
        informationScanner = new Scanner(file);
        StringBuilder sb = new StringBuilder();
        while (informationScanner.hasNextLine()) {
            sb.append(informationScanner.nextLine());
        }
        processorVersion = String.valueOf(sb.toString());
        informationScanner.close(); // Ensure scanner is closed
    }
}