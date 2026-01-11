package bean;

import java.io.Serializable;

public class BankBean implements Serializable
{
	private String  accno;
	private String accholdername;
	private String accbal;
	
	public BankBean() {}
	
	public String getAccno() {
		return accno;
	}
	public void setAccno(String accno) {
		this.accno = accno;
	}
	public String getAccholdername() {
		return accholdername;
	}
	public void setAccholdername(String accholdername) {
		this.accholdername = accholdername;
	}
	public String getAccbal() {
		return accbal;
	}
	public void setAccbal(String accbal) {
		this.accbal = accbal;
	}
	
	
}
