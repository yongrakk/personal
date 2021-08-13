package global.sesoc.test11.dto;

public class Board {

	private int boardnum;
	private String userid;
	private String title;
	private String boardtext;
	private int hitcount;
	private String regdate;
	private String originalfile;
	private String savedfile;
	public Board(int boardnum, String userid, String title, String boardtext, int hitcount, String regdate,
			String originalfile, String savedfile) {
		super();
		this.boardnum = boardnum;
		this.userid = userid;
		this.title = title;
		this.boardtext = boardtext;
		this.hitcount = hitcount;
		this.regdate = regdate;
		this.originalfile = originalfile;
		this.savedfile = savedfile;
	}
	
	public Board() {
		// TODO Auto-generated constructor stub
	}

	public int getBoardnum() {
		return boardnum;
	}

	public String getUserid() {
		return userid;
	}

	public String getTitle() {
		return title;
	}

	public String getBoardtext() {
		return boardtext;
	}

	public int getHitcount() {
		return hitcount;
	}

	public String getRegdate() {
		return regdate;
	}

	public String getOriginalfile() {
		return originalfile;
	}

	public String getSavedfile() {
		return savedfile;
	}

	public void setBoardnum(int boardnum) {
		this.boardnum = boardnum;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setBoardtext(String boardtext) {
		this.boardtext = boardtext;
	}

	public void setHitcount(int hitcount) {
		this.hitcount = hitcount;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public void setOriginalfile(String originalfile) {
		this.originalfile = originalfile;
	}

	public void setSavedfile(String savedfile) {
		this.savedfile = savedfile;
	}

	@Override
	public String toString() {
		return "Board [boardnum=" + boardnum + ", userid=" + userid + ", title=" + title + ", boardtext=" + boardtext
				+ ", hitcount=" + hitcount + ", regdate=" + regdate + ", originalfile=" + originalfile + ", savedfile="
				+ savedfile + "]";
	}
	
}
