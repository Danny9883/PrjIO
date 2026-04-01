package ex04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class TestZipCode {

	public static void main(String[] args) throws IOException {
		String         path      = "D:/dev/java/PrjIO/src/ex04/";
		String         filename  = "zipcode.csv";
		FileReader     fr        = new FileReader(path + filename);
		BufferedReader br        = new BufferedReader(fr);
		
		Scanner        in        = new Scanner(System.in);
		System.out.println("시/도 : 1 , 구/군(도>시) : 2 , 동/건물 : 3  전체키워드검색 : 4   번호를 입력하세요.");
		int            findnum   = in.nextInt();
		in.nextLine();
		switch (findnum) {
		case 1 : System.out.println("검색할 시/도 를 입력하세요"); break;
		case 2 : System.out.println("검색할 구/군(시) 을 입력하세요"); break;
		case 3 : System.out.println("검색할 동, 혹은 건물명을 입력하세요"); break;
		case 4 : System.out.println("검색할 키워드를 입력하세요."); break;
		default : System.out.println("비 검색 모드"); break;
		}
		String         find      = in.nextLine();
		
		String         line      = "";
		br.readLine();
		String         title     = "우편번호  시/도  구/군   동     번지                SEQ";
		System.out.println(title);
		
		int tot    = 0;
		int search = 0;
		while ( (line=br.readLine()) != null ) {
			tot++;
			String [] li    = line.split(",");
			String zip      = li[0].trim();
			String sido     = li[1].trim();
			String gugun    = li[2].trim();
			String dong     = li[3];
			String bunji    = li[4].trim();
			int    seq      = Integer.parseInt(li[5].trim());
			
			if (findnum==1) {
				if ( sido.contains(find) ) {
					String fmt = "%s  %s  %s  %s  %s      %d";
					String msg = String.format(fmt, zip,sido,gugun,dong,bunji,seq);
					System.out.println(msg);
					search++;
				}
			} else if (findnum==2) {
				if ( gugun.contains(find) ) {
					String fmt = "%s  %s  %s  %s  %s      %d";
					String msg = String.format(fmt, zip,sido,gugun,dong,bunji,seq);
					System.out.println(msg);
					search++;
				}		
			} else if (findnum==3) {
				if ( dong.contains(find) ) {
					String fmt = "%s  %s  %s  %s  %s      %d";
					String msg = String.format(fmt, zip,sido,gugun,dong,bunji,seq);
					System.out.println(msg);
					search++;
				}
			} else if (findnum==4) {
				if ( line.contains(find) ) {
					String fmt = "%s  %s  %s  %s  %s      %d";
					String msg = String.format(fmt, zip,sido,gugun,dong,bunji,seq);
					System.out.println(msg);
					search++;
				}
			}
		} // while end
		
		System.out.println();
		System.out.println("검색된 자료수 : " + search + "건");
		System.out.println("전체 자료수   : " + tot + "건");
		
		
		
		
		fr.close();
		br.close();
		
		
	}

}
