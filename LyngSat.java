package Michael.Eder.Aut;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class LyngSat {
	
public static final String sURL = "https://www.lyngsat.com/";
public static final String[] ASurls = {"europe", "atlantic", "america", "asia"};
public static final String sHtml = ".html";
public static final double NULL_MED = 0.0;

public static class SSat {
	 String sName = "";
	 double fDegLong;
	 public SSat (String sName, double fDegLong) {
		 this.sName = sName;
		 this.fDegLong= fDegLong;
	}
 };
 
public static final SSat[] ASats1 = {
	new LyngSat.SSat("Astra 1", 19.2),
	new LyngSat.SSat("Hobird", 13.0),
	new LyngSat.SSat("Eutelsat 9", 9.0),
	new LyngSat.SSat("Astra 2", 28.2)
	}; 

public static void main(String[] args) {
	FV_init();
	FV_wrk();
	FV_finish();
}

public static void FV_init() {
	 SSat sat1, sat2;
	 int I_len_sats = ASats1.length;
	
	 URL url;
	 String sName, sHtmlSite;
	 double F_deg_long;
	 
	 for (int i1 = 0; i1 < I_len_sats; i1++) {
		 sat1 = ASats1[i1];
		 sName      = sat1.sName;
	     F_deg_long = sat1.fDegLong;

		sat2  = new SSat(sName, NULL_MED);
	     
        try {
        	sHtmlSite = "https://www.lyngsat.com/" + ASurls[i1] + sHtml;
            url = new URL(sHtmlSite);
            URLConnection conn = url.openConnection();

            // open the stream and put it into BufferedReader
            BufferedReader br = new BufferedReader(
                               new InputStreamReader(conn.getInputStream()));

            String inputLine;
            while ((inputLine = br.readLine()) != null) {
                    System.out.println(inputLine);
            }
            br.close();

            System.out.println("Done");

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

	 } 
}

public static void FV_wrk() {
	}

public static void FV_finish() {
	System.exit(0);
  }
}

