import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws Exception {
        List<String> filePaths = List.of("C:\\Users\\noody\\Documents\\Education\\Edafa\\Day4-Multithreading\\ParallelFileProcessing\\sample1.txt", "C:\\Users\\noody\\Documents\\Education\\Edafa\\Day4-Multithreading\\ParallelFileProcessing\\sample2.txt", "C:\\Users\\noody\\Documents\\Education\\Edafa\\Day4-Multithreading\\ParallelFileProcessing\\sample3.txt");
        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Future<Integer>> futures = new ArrayList<>();
        for(String file : filePaths){
            futures.add(executor.submit(() -> {
                System.out.println("Processing file: " + file + "on thread" + Thread.currentThread().getName());
                Thread.sleep(1000);
                String content = Files.readString(Path.of(file));
                Integer letterCount =content.length();
                System.out.println("File: " + file + ", Length: " +letterCount);
                return letterCount;
            }));
        }
        int  letterCount=0;
        try{
            for(Future<Integer> future : futures){
                letterCount += future.get();
            }
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Error processing files: " + e.getMessage());
        }finally {
            System.out.println("Total letter count: " + letterCount);
            executor.shutdown();;
        }

    }

}

