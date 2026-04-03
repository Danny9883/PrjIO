package ex04;

public class PostVo {
	// zipcode,sido,gugun,dong,bunji,seq
	private  String  zipcode;
	private  String  sido;
	private  String  gugun;
	private  String  dong;
	private  String  bunji;
	private  int     seq;
	
	// Constructor
	public PostVo() {}
	public PostVo(String zipcode, String sido, String gugun, String dong, String bunji, int seq) {
		this.zipcode = zipcode;
		this.sido = sido;
		this.gugun = gugun;
		this.dong = dong;
		this.bunji = bunji;
		this.seq = seq;
	}
	public PostVo(String line) {
		String  []  li   = line.trim().split(",");
		this.zipcode     = li[0].trim();
		this.sido        = li[1].trim();
		this.gugun       = li[2].trim();
		this.dong        = li[3].trim();
		this.bunji       = li[4].trim();
		this.seq         = Integer.parseInt(li[5].trim());
	}


	// get/set
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getSido() {
		return sido;
	}
	public void setSido(String sido) {
		this.sido = sido;
	}
	public String getGugun() {
		return gugun;
	}
	public void setGugun(String gugun) {
		this.gugun = gugun;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public String getBunji() {
		return bunji;
	}
	public void setBunji(String bunji) {
		this.bunji = bunji;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}

	
	// toString
	@Override
	public String toString() {
		return "PostVo [zipcode=" + zipcode + ", sido=" + sido + ", gugun=" + gugun + ", dong=" + dong + ", bunji="
				+ bunji + ", seq=" + seq + "]";
	}
	public String getAddress() {
		String result = "[" + zipcode + "]" + sido + " " + gugun + " " + dong + " " +
				bunji + " " + seq ;
		return result;
	}
	
	
	
} // class end
