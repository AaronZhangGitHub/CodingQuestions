import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
     public static TimeZone tz = TimeZone.getTimeZone("UTC");
     public static DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
   
    //getters
    public static String getIsoDate(int timeSinceEpoch){
         Date date = new Date((long)timeSinceEpoch*1000);
         df.setTimeZone(tz);
         return df.format(date);
    }
    public static Double getPercentileApproximation(PriorityQueue<Double> heap){
       int popNum = heap.size()- (int)(Math.round((heap.size() * .9)));
       Double res = null;
       
        while(popNum >= 0){
          res = heap.poll();
          popNum --;
       }
       if(res == null){
            res = heap.poll();
       }
        
       return res;

    }
    public static int getMinuteMarker(int secondsSinceEpoch){
    //returns the start of the minute this time belongs to.
    //ie, 962668859 would go to 962668800, 962668865 wold go to 962668860 
        if(secondsSinceEpoch%60 == 0)
            return secondsSinceEpoch;
        else{
            return secondsSinceEpoch - (secondsSinceEpoch%60);
        }
    }
    
    public static void main(String args[] ) throws Exception {
         Scanner scan = new Scanner(System.in); 
         PriorityQueue<Double> currHeap = new PriorityQueue<>(10, Collections.reverseOrder());
         PriorityQueue<Double> nextHeap = new PriorityQueue<>(10, Collections.reverseOrder());

         double currProcessingTime = 0.0;
         int currTimeSinceEpoch = 0, currMinuteMarker = -1, nextMinuteMarker = -1;
         boolean process = true;
        
         while(scan.hasNextInt()){
             //Read in Int
             currTimeSinceEpoch = scan.nextInt();
             //Read in Double
             if(scan.hasNextDouble()){
                 currProcessingTime = scan.nextDouble();
                 if(currProcessingTime < 0 || currProcessingTime > 150){
                   //invalid time  
                   process = false;
                 }         
             }
             else{ 
                process = false;
             }

             if(currMinuteMarker == -1){  //first time read in
                 currMinuteMarker = getMinuteMarker(currTimeSinceEpoch);
             }
             
              if(getMinuteMarker(currTimeSinceEpoch) - currMinuteMarker > -60){     
                if((getMinuteMarker(currTimeSinceEpoch) - currMinuteMarker < 0) && nextMinuteMarker == -1) {
                     //rearrange heaps, this currEpochTime occurred in the previous minute but isn't late
                     nextHeap = currHeap;
                     currHeap = new PriorityQueue<>(10, Collections.reverseOrder());
                     nextMinuteMarker = currMinuteMarker;
                     currMinuteMarker = getMinuteMarker(currTimeSinceEpoch);
                }
             }else{
                  //request is more than a minute late
                  process = false;
              }
             
             //PROCESS DATA if the inputs were valid
             if(process){ 
                 if(getMinuteMarker(currTimeSinceEpoch) != currMinuteMarker){ 
                     if(nextMinuteMarker != -1 && (Math.abs(currTimeSinceEpoch - nextMinuteMarker)) > 59){
                           //process current
                           System.out.println(getIsoDate(currMinuteMarker)+" " + getPercentileApproximation(currHeap)); 
                           
                           //set currHeap to nextHeap and update minute markers for each.
                           currHeap = nextHeap;
                           nextHeap = new PriorityQueue<>(10, Collections.reverseOrder());
                           nextHeap.add(new Double(currProcessingTime));
                           currMinuteMarker = nextMinuteMarker;
                           nextMinuteMarker = getMinuteMarker(currTimeSinceEpoch);
                     }else{
                         //current input belongs in nextHeap
                         nextHeap.add(new Double(currProcessingTime));
                         if(nextMinuteMarker == -1)
                             nextMinuteMarker = getMinuteMarker(currTimeSinceEpoch);
                     }
                 }else{ 
                     //still in current minute, just update currHeap
                     currHeap.add(new Double(currProcessingTime));
                 } 
            }else{
                 System.err.println(currTimeSinceEpoch + " " + currProcessingTime+ " : Request too late");
             }
            //reset for next input set 
            process = true;
         }
        
         //print out heaps that weren't processed in while loop
         if(currHeap.size() != 0){
             System.out.println(getIsoDate(currMinuteMarker)+" " + getPercentileApproximation(currHeap));
         }
         if(nextHeap.size() != 0){
                 System.out.println(getIsoDate(nextMinuteMarker)+" " + getPercentileApproximation(nextHeap)); 
         }
     
    }
}



