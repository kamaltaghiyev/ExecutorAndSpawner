package Reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class Executor {
    public void fileProcessing(){
        int nRows = 20;
        int nThread = 5;
        List<String> rows = new ArrayList<>();
        String dirLocation = "C:\\Users\\kamal\\Desktop\\Creator";
        try {
            List<File> files = Files.list(Paths.get(dirLocation))
                    .map(Path::toFile)
                    .collect(Collectors.toList());
            String path = files.get(0).getName();
            Path source = Paths.get("C:\\Users\\kamal\\Desktop\\Creator\\"+path);
            Path target = Paths.get("C:\\Users\\kamal\\Desktop\\Processing\\"+path);
            Files.move(source,target);
            File file = new File(String.valueOf(target));

            try (BufferedReader br = new BufferedReader(new FileReader(file)))
            {
                ExecutorService executorService = Executors.newFixedThreadPool(nThread);
                String line;
                while ((line = br.readLine()) != null) {
                    String finalLine = line;
                    executorService.submit(new Thread(() -> {

                        fileExecutor(finalLine,rows,nRows);
                    }));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            System.out.println(e);
        }

    }
    public void fileExecutor(String line,List<String> rows,int nRows){

        for (int i=0;i<nRows;i++){
            rows.add(line);
        }
        
    }

}
