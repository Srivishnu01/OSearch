package com.osearch;

import java.util.*;
import java.io.*;

public class Finder
{
    final static int buffLength = 100;// each cycle's buffer length
    final static int wordMaxLen = 400;//matching word's max length
    final static int scopeMaxLen = 4000;//one snippet's max length
    public static List<String> getSnippets(Scanner sc, String key) throws Exception
    {
        sc.useDelimiter("[;.\n?!]");
        List<String> resultSnippets = new ArrayList<String>();
        while(sc.hasNext())
        {
            String buff = sc.next();
            String[] words = buff.split("\\b");
            for(String word : words)
            {
                if(key.equals(word))
                {
                    resultSnippets.add(buff);
                    break;
                }
            }
        }
        return resultSnippets;
    }
}