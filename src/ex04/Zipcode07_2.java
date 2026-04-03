package ex04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Zipcode07_2 {

	public static void main(String[] args) {
		// 7. 부산진구 우편번호를 파일 (.csv) 로 출력
		String    path       = "D:\\dev\\java\\PrjIO\\src\\ex04\\";
		String    inFname    = "zipcode.csv";
		String    outFname   = "zipcode_busanjingu.csv";
		
		FileReader     fr    = null;
		FileWriter     fw    = null;
		BufferedReader br    = null;
		BufferedWriter bw    = null;
		
		try {
			fr = new FileReader( path + inFname );
			fw = new FileWriter( path + outFname );
			
			br = new BufferedReader( fr );
			bw = new BufferedWriter( fw );
			
			// 7. 부산진구 우편번호를 파일 (.csv) 로 출력
			br.readLine();
			String  line = "";
			while ( (line = br.readLine()) != null ) {
				PostVo   postVo  = new PostVo( line ); 
				String   sido    = postVo.getSido();
				String   gugun   = postVo.getGugun();
				
				if ( sido.equals("부산") ) {
					if ( gugun.contains("진구") ) {
						String result = postVo.getAddress();
						System.out.println( line );
						bw.write( result + "\n" );
						// 결과가 bin 폴더에 저장됨
					}
				}
			}
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if( br != null ) br.close();
				if( bw != null ) bw.close();
				if( fr != null ) fr.close();
				if( fw != null ) fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	} // main end

}
