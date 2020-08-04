package com.qa.data;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class DataReader
{
    public static Map<String, String> csvDataReader()
    {
        try
        {
            final String file = (new File("."+"/src/test/java/com/qa/data/sampleData.csv").toString());

            Map<String, String> data = new HashMap<>();

            Files.readAllLines(Paths.get(file)).forEach(line ->  {
                String[] words = line.split(",");
                if(words.length == 2)
                    data.put(words[0], words[1]);
            });

            return data;
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
