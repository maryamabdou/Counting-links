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
public class Html {
    protected Document url1 = null;
    protected Elements link1 = null ;
    public static ArrayList<String> links= new ArrayList<>();
    protected int size,k,i,j;
    protected static int count2,count3;
   
    public  void check() {
       try {
        for( i=0;i<=LinksFrame.depth;i++){
            if(i==0)
              url1 = Jsoup.connect(LinksFrame.url).get();
              if(i==1){
             link1 = url1.select("a[href]");
           for (Element link : link1)
          {
            links.add(link.attr("abs:href"));
          }
           size=links.size();
             }
    if(i>1){
        
        while(k<size){
            if(catch2(links,k)){
            url1 = Jsoup.connect(links.get(k)).get();
            link1 = url1.select("a[href]");
           for (Element link : link1) {
         links.add(link.attr("abs:href"));
          }
                
        }
            k++;
        }
        size=links.size();
    } 
            }
      for( j=0;j<links.size();j++){
          System.out.println(links.get(j));
          catch1(links,j);
      }
}
        catch (HttpStatusException e) {
        if(this.i==0){
    if(!doc(LinksFrame.url))
        count2++;
    
    }else {if(!doc(links.get(j)))
        count2++;
    }
} 
        catch (IllegalArgumentException | IOException e) {
   
      if(this.i==0){
    if(!doc(LinksFrame.url))
        count2++;
    
    }else {if(!doc(links.get(j)))
        count2++;
    }
}
       System.out.println(count2);
       count3=(links.size()+1)-count2;
       System.out.println(count3);
    }
    
  public void catch1(ArrayList<String> s, int i){
          try {
    Document url1 = Jsoup.connect(s.get(i)).get();
    
}
    catch (HttpStatusException e) {
    if(this.i==0){
    if(!doc(LinksFrame.url))
        count2++;
    
    }
    else {
        if(!doc(s.get(i)))
        count2++;
    }
} 
    catch (IllegalArgumentException | IOException e) { 
     if(this.i==0){
    if(!doc(LinksFrame.url))
        count2++;
    
    }
     else {if(!doc(s.get(i)))
        count2++;
    }
}
    }
    
public boolean catch2(ArrayList<String> s, int i){
          try {
    Document url1 = Jsoup.connect(s.get(i)).get();
    return true;
}catch (HttpStatusException e) {
    return false;
   
} catch (IllegalArgumentException | IOException e) {
   return false;
}
          
     }
public boolean doc(String url) {
 
    URL u;
        try {
            u = new URL(url);
             URLConnection x=u.openConnection();
            String s= x.getContentType(); //application/pdf
            String[] result = s.split("/");
        return result[0].compareTo("application")==0;
        } 
        catch (MalformedURLException ex) {
            return false;
        }
         catch (IOException ex) {
            return false;
        }
   }
}
