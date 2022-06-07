package kr.swu.dia.covid19sido;

public class Covid19sidoVO {
	private String std_day;  // 기준일시(yyyymmdd)
	private String gubun;  // 시도명(한글) 
	private String def_cnt;  // 확진자 수   
	private String death_cnt;  // 사망자 수   
	private String isol_clear_cnt;  // 격리 해제 수 
	private String over_flow_cnt;  // 해외유입 수  
	private String local_occ_cnt;  // 지역발생 수  
	//private String reg_date       ;  // 등록일시    
	
	
	
	public Covid19sidoVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Covid19sidoVO(String std_day, String gubun, String def_cnt, String death_cnt, String isol_clear_cnt,
			String over_flow_cnt, String local_occ_cnt) {
		super();
		this.std_day = std_day;
		this.gubun = gubun;
		this.def_cnt = def_cnt;
		this.death_cnt = death_cnt;
		this.isol_clear_cnt = isol_clear_cnt;
		this.over_flow_cnt = over_flow_cnt;
		this.local_occ_cnt = local_occ_cnt;
		//this.reg_date = reg_date;
	}
	
	public String getStd_day() {
		return std_day;
	}
	
	public void setStd_day(String std_day) {
		this.std_day = std_day;
	}
	
	public String getGubun() {
		return gubun;
	}
	
	public void setGubun(String gubun) {
		this.gubun = gubun;
	}
	
	public String getDef_cnt() {
		return def_cnt;
	}
	
	public void setDef_cnt(String def_cnt) {
		this.def_cnt = def_cnt;
	}
	
	public String getDeath_cnt() {
		return death_cnt;
	}
	
	public void setDeath_cnt(String death_cnt) {
		this.death_cnt = death_cnt;
	}
	
	public String getIsol_clear_cnt() {
		return isol_clear_cnt;
	}
	
	public void setIsol_clear_cnt(String isol_clear_cnt) {
		this.isol_clear_cnt = isol_clear_cnt;
	}
	public String getOver_flow_cnt() {
		return over_flow_cnt;
	}
	public void setOver_flow_cnt(String over_flow_cnt) {
		this.over_flow_cnt = over_flow_cnt;
	}
	public String getLocal_occ_cnt() {
		return local_occ_cnt;
	}
	public void setLocal_occ_cnt(String local_occ_cnt) {
		this.local_occ_cnt = local_occ_cnt;
	}
	/*
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	*/


}
