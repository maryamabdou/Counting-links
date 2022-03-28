/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package html;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author windows10
 */
public class Implementation implements Runnable{
  protected Document url1 = null;
    protected Elements link1 = null ;
    public static ArrayList<String> linksThreads= new ArrayList<>();
    protected static int count,count1,check;
    int index,depth;
    @Override
     public void run(){
         run(index,depth);
     }
    public void run(int k,int i){
        try {
            
          if(k==0){
               url1 = Jsoup.connect(LinksFrame.url).get();
            count1++;
               linksThreads.add(LinksFrame.url);
               if(i<LinksFrame.depth){
            link1 = url1.select("a[href]");
           for (Element link : link1) {
         linksThreads.add(link.attr("abs:href"));
         System.out.println(link.attr("abs:href"));
          }
            check++;
               }
          }
          else{
            url1 = Jsoup.connect(linksThreads.get(k)).get();
            count1++;
            if(i<LinksFrame.depth){
            link1 = url1.select("a[href]");
           for (Element link : link1) {
         linksThreads.add(link.attr("abs:href"));
         System.out.println(link.attr("abs:href"));
           }
            check++;
            
          }
          }
       
}catch (HttpStatusException e) {
    if(i==0)
    {
    if(doc(LinksFrame.url)){
        count1++;
    }else count++;
    }
    else{
         if(doc(linksThreads.get(k))){
        count1++;
    }else count++;
    }
        
    check++;
} catch (IllegalArgumentException | IOException e) {
      if(i==0)
    {
    if(doc(LinksFrame.url)){
        count1++;
    }else count++;
    }
    else{
         if(doc(linksThreads.get(k))){
        count1++;
    }else count++;
    }
    check++;
    
}    
    }
    public boolean doc(String url) {
 
    URL u;
        try {
            u = new URL(url);
             URLConnection x=u.openConnection();
            String s= x.getContentType();
            String[] result = s.split("/");
        return result[0].compareTo("application")==0;
        } catch (MalformedURLException ex) {
            return false;
        }
         catch (IOException ex) {
            return false;
        }
    }
}
