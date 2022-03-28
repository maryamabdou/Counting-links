/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package html;

import static html.Implementation.linksThreads;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



/**
 *
 * @author windows10
 */
public class Threads {
    public static ExecutorService fixedThreadPool = Executors.newFixedThreadPool(LinksFrame.thread1);
  
protected int size,k,flag;
    
    public void checkThread() {
        k=1;
        Implementation imp1= new Implementation();
        Thread t1= new Thread(imp1);
         t1.start();
        try{
        t1.join();
        }
        catch(InterruptedException e){
            
        }
        size=linksThreads.size();
        for(int i=1;i<=LinksFrame.depth;i++){
        while(k<size){
            Implementation imp= new Implementation();
            imp.index=k;
            imp.depth=i;
         fixedThreadPool.execute(imp) ;
            k++;
        } 
        if(i<LinksFrame.depth)
        while(Implementation.check!=k){
           System.out.println("");
        }
          size=linksThreads.size();
          
       }
    } 
 }
