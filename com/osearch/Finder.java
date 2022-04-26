package com.osearch;

import java.util.*;
import java.io.*;

public class Finder
{
    final static int buffLength = 100;// each cycle's buffer length
    final static int wordMaxLen = 400;//matching word's max length
    final static int scopeMaxLen = 4000;//one snippet's max length
    public static List<String> getSnippets(BufferedReader bf, String key) throws Exception
    {
        char[] scope = new char[scopeMaxLen], 
                word = new char[wordMaxLen], 
                keyWord = key.toCharArray();
        int scopeIndex = 0, scopeEnd = 0, start=0, wordLen = 0, keyLen = key.length();
        List<String> resultSnippets = new ArrayList<String>();
        int rlen = 0;
        boolean letterMatched = true, selected = false;
        do
        {
            rlen = bf.read(scope, scopeIndex, buffLength);
            scopeEnd = rlen + scopeIndex;
            for(int i=scopeIndex; i<scopeEnd; i++)
            {
                char c = scope[i];
                // System.out.println(c);
                switch(c)
                {
                    case '\n':
                    case ',' :
                    case '.' :
                    case '?' :
                    case '!' :
                    case ';' :
                        if(wordLen==keyLen)
                        {
                            selected = true;
                        }
                        if(selected)
                        {
                            String aSnippet = new String (scope, start, i-start+1);
                            resultSnippets.add(aSnippet.trim());
                            selected=false;
                        }
                        scopeIndex = 0;
                        
                        start = i+1;
                        letterMatched = true;
                    break;

                    case ' ' :
                        if(wordLen==keyLen)
                        {
                            selected = true;
                        }
                        wordLen = 0;
                        letterMatched = true;
                    break;

                    default:
                        if(letterMatched && wordLen<keyLen && keyWord[wordLen]==c)
                        {
                                        
                            //System.out.println(wordLen);
                            word[wordLen++]=c;
                        }
                        else
                        {
                            letterMatched = false;
                            wordLen = 0;
                        }
                    break;
                }

            }
            scopeIndex = scopeEnd;
        }
        while(rlen==buffLength);
        //end case:
        if(wordLen==keyLen)
        {
            selected = true;
        }
        if(selected)
        {
            String aSnippet = new String (scope, start, scopeEnd-start+1);
            resultSnippets.add(aSnippet.trim());
        }

        return resultSnippets;
    }    
}