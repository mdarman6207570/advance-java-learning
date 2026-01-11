package bean;

import java.io.Serializable;

public class UserBean implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	
	String uname;
	String upwd;
	
	public UserBean()
	{
		
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpwd() {
		return upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	
	
}
