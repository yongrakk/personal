package global.sesoc.test11.dto;

public class Member {

	private String userid;
	private String userpwd;
	private String username;
	private String useremail;
	public Member(String userid, String userpwd, String username, String useremail) {
		super();
		this.userid = userid;
		this.userpwd = userpwd;
		this.username = username;
		this.useremail = useremail;
	}
	public Member() {
	}
	public String getUserid() {
		return userid;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public String getUsername() {
		return username;
	}
	public String getUseremail() {
		return useremail;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	@Override
	public String toString() {
		return "Member [userid=" + userid + ", userpwd=" + userpwd + ", username=" + username + ", useremail="
				+ useremail + "]";
	}
	
}
