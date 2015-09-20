/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package htmlparser;

import java.io.IOException;
import java.text.SimpleDateFormat;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 *
 * @author kgabit
 */
public class OilParser {
    static String div1="slick-viewport slick-viewport-top slick-viewport-right";
    static String div2="grid-canvas grid-canvas-top grid-canvas-right";
    //grid-canvas grid-canvas-top grid-canvas-right
    static SimpleDateFormat formatter = new SimpleDateFormat( "yyyyMM" );
    static String end = formatter.format(new java.util.Date()); // параметр для URL
    
   public static void main(String[] args) throws IOException {
       Document d;
            d = Jsoup.connect("http://www.eia.gov/beta/steo/#/?v=6&f=M&start=200501&end="+end).get();
            
            Element div = d.select("div[class="+div1+"]").select("div[class="+div2+"]").last(); // US (50 countries)
            System.out.println("test: "+d.location());
  
   } 
}
