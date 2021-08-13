package global.sesoc.test11.dto;

public class Comments {
	private int commentsnum;
	private String username;
	private String useremail;
	private String regdate;
	private String commenttext;
	public Comments(int commentsnum, String username, String useremail, String regdate, String commenttext) {
		super();
		this.commentsnum = commentsnum;
		this.username = username;
		this.useremail = useremail;
		this.regdate = regdate;
		this.commenttext = commenttext;
	}
	
	public Comments() {
		// TODO Auto-generated constructor stub
	}

	public int getCommentsnum() {
		return commentsnum;
	}

	public void setCommentsnum(int commentsnum) {
		this.commentsnum = commentsnum;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getCommenttext() {
		return commenttext;
	}

	public void setCommenttext(String commenttext) {
		this.commenttext = commenttext;
	}

	@Override
	public String toString() {
		return "Comments [commentsnum=" + commentsnum + ", username=" + username + ", useremail=" + useremail
				+ ", regdate=" + regdate + ", commenttext=" + commenttext + "]";
	}
	
}
