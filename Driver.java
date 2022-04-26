import java.util.*;
import java.io.*;
import com.osearch.Finder;
public class Driver
{  
public static void main(String args[]) throws Exception
    {
        String fileName = args[0], keyWord = args[1];
        Scanner sc = new Scanner(new File(fileName));
        List<String> resultSnippets = Finder.getSnippets(sc, keyWord);
        int i=1;
        System.out.println(resultSnippets.size());
        for(String snippet : resultSnippets)
        {
            System.out.println(String.format("(%d) %s\n", i++, snippet));
        }
    }
}  