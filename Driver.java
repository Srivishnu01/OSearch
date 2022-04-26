import java.util.*;
import java.io.*;
import com.osearch.Finder;
public class Driver
{  
public static void main(String args[]) throws Exception
    {
        String fileName = args[0];
        String keyWord = args[1];
        BufferedReader text = new BufferedReader(new FileReader(fileName));
        List<String> resultSnippets = Finder.getSnippets(text, keyWord);
        int i=1;
        System.out.println(resultSnippets.size());
        for(String snippet : resultSnippets)
        {
            System.out.println(String.format("(%d) %s\n", i++, snippet));
        }
    }
}  