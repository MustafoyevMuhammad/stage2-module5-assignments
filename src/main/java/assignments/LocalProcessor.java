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
    private Integer valueOfCheap = 0;
    private String processorName = "";
    private Long period = 10000000000000L;
    protected String processorVersion = "";
    private Scanner informationScanner;
    private List<StringBuilder> stringArrayList = new LinkedList<>();

    // Constructors...
    public LocalProcessor(String processorName, Long period, String processorVersion, Integer valueOfCheap,
                          Scanner informationScanner, List<StringBuilder> stringArrayList) {
        this.processorName = processorName;
        this.period = period;
        this.valueOfCheap = valueOfCheap;
        this.informationScanner = informationScanner;
        this.stringArrayList = stringArrayList;
    }

    public LocalProcessor() {
    }
    @ListIteratorAnnotation
    public void listIterator(List<StringBuilder> stringList) {
        stringList = new LinkedList<>(stringList);
        if(stringArrayList == null)
            return;
        for (StringBuilder str : stringArrayList) {
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