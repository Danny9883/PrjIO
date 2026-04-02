package ex04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Zipcode05_2 {

	public static void main(String[] args) throws IOException {
//		4. 한국의 시도명 출력 - 17건 
//		   서울
//		   부산
//		   ... 
//		   충북
		
		String	      path     = Zipcode05_2.class.getResource("").getPath();
		String        fname    = "zipcode.csv";
		File          infile   = new File( path + fname );
		if ( !infile.exists() ) {
			System.out.println(fname + "이 없습니다.");
			System.exit(-1);
		}
		
		FileReader     fr   = new FileReader(infile);
		BufferedReader br   = new BufferedReader(fr);
		
		br.readLine();       // 제목 skip
		String  line     = "";
		int     totcnt   = 0;
		String  pervSido = "";

		long   startTime = System.nanoTime(); 
		
		int    cnt       = 0;
		int    linecnt   = 0;
		List <String>  sidoList  = new ArrayList<>();
		List <Integer> cntList   = new ArrayList<>();
		while ( (line=br.readLine()) != null ) {
			PostVo    vo  = new PostVo( line );
			String  sido  = vo.getSido(); 
			if ( !sido.equals(pervSido) ) {
				if (linecnt != 0) {
					cntList.add(linecnt);
				}
					sidoList.add(sido);
					pervSido = sido;
					linecnt=1;
					cnt++;
			} else {
				linecnt++;
			}
			
			totcnt++;
		} 
		cntList.add(linecnt);
		
		long   endTime  = System.nanoTime();
		double execTime = (endTime - startTime)/1000000000.0;
		
		
		br.close();
		fr.close();
		
		for (int i = 0; i < sidoList.size(); i++) {
			System.out.println(sidoList.get(i) + ": 내용 수 " + cntList.get(i));
		}
		
		System.out.println("도시 수 : " + cnt );
		System.out.println("전체 자료수 : " + totcnt );
		System.out.printf("소요 시간 : %.4f 초\n", execTime);
	}

}
