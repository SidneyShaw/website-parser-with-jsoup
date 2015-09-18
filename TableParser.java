/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package htmlparser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author kgabit
 */
public class TableParser {
    public static void main(String[] args) throws IOException {
        Document d;
            d = Jsoup.connect("http://stats.oecd.org/index.aspx?DatasetCode=MEI_CLI").get();
            
            Element table = d.select("table[class=DataTable]").first();
            int count = table.select("tbody tr").size(); // access tbody .select(tbody tr")
//            System.out.println("Table size: "+count); // row count
//            System.out.println(table.select("tr[class=row1]").text());
//            System.out.println("--------------------------------------");
//            System.out.println(table.select("tbody tr").get(count-1).text()); // get(index) 0<=index<=count-1
            
            for(int i=0; i<count; i++) {
                System.out.println(table.select("tbody tr").get(i).text());
                System.out.println("------------------------------------------");
            }
    }
}
