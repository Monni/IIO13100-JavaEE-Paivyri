package Paivyri.solution;

import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        java.util.Date parsed = null;
		try {
			parsed = format.parse("20110210");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        java.sql.Date pvm = new java.sql.Date(parsed.getTime());
        
        // Kunhan saan jonkin kellonajan konstruktoriin
        java.sql.Time klo = new java.sql.Time(648466848);



        
        //Date pvm, Time klo, String nimi, String ruoannimi, int ruoanmaara, int kalorit, int hiilihydraatit, int proteiini, int rasva
        Ruokailu ruokailu = new Ruokailu(pvm, klo, "Miika", "Persikkaa", 150, 200);
        System.out.println(ruokailu.toString());
    }
}
