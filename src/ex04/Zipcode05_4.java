package ex04;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

interface  Ipo  {
	void  input(String fname) throws FileNotFoundException, IOException;
	void  process();
	void  output();
}

class ZipcodeMap implements Ipo {
	
	FileReader       fr;
	BufferedReader   br;
	
	Map<String, Integer> sidoMap  = new TreeMap<>();
	int                  totCnt   = 0 ;

	@Override
	public void input(String fname) throws IOException {
		
		fr  = new FileReader(fname);
		br  = new BufferedReader(fr);
		br.readLine();
		String line = "";
		
		while ( (line = br.readLine()) != null ) {
			PostVo   vo     = new PostVo(line);
			String   sido   = vo.getSido();
			
			sidoMap.put( sido, sidoMap.getOrDefault( sido,0 )+1 );
			totCnt++;
		}
		
		
		
		br.close();
		fr.close();
	}
	
	@Override
	public void process() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void output() {
		
		for (Map.Entry<String, Integer> sidoList : sidoMap.entrySet()) {
			String  key = sidoList.getKey();
			Integer val = sidoList.getValue();
			
			System.out.println(key + " = "  + val);
		}
		
		System.out.println( "총 " + totCnt + " 건");
	
	}

}


public class Zipcode05_4 {

	// map 사용
	public static void main(String[] args) throws IOException {
		ZipcodeMap   zMap  = new ZipcodeMap();
		
		String      path    = ZipcodeMap.class.getResource("").getPath();
		String      fname   = "zipcode.csv";
		
		zMap.input( path+fname );
		zMap.process();
		zMap.output();
		
	}

}
