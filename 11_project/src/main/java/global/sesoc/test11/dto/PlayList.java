package global.sesoc.test11.dto;

public class PlayList {

	private int playlistnum;
	private String userid;
	private String playlisttitle;
	private String thumnail;
	private String videoid;
	
	public PlayList(int playlistnum, String userid, String playlisttitle, String thumnail,String videoid) {
		super();
		this.playlistnum = playlistnum;
		this.userid = userid;
		this.playlisttitle = playlisttitle;
		this.thumnail = thumnail;
		this.videoid = videoid;
	}
	
	public PlayList() {
		// TODO Auto-generated constructor stub
	}

	public int getPlaylistnum() {
		return playlistnum;
	}

	public String getUserid() {
		return userid;
	}

	public String getPlaylisttitle() {
		return playlisttitle;
	}

	public String getThumnail() {
		return thumnail;
	}

	public void setPlaylistnum(int playlistnum) {
		this.playlistnum = playlistnum;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public void setPlaylisttitle(String playlisttitle) {
		this.playlisttitle = playlisttitle;
	}

	public void setThumnail(String thumnail) {
		this.thumnail = thumnail;
	}
	public String getVideoid() {
		return videoid;
	}

	public void setVideoid(String videoid) {
		this.videoid = videoid;
	}

	@Override
	public String toString() {
		return "PlayList [playlistnum=" + playlistnum + ", userid=" + userid + ", playlisttitle=" + playlisttitle
				+ ", thumnail=" + thumnail + ", videoid=" + videoid + "]";
	}

	
	
}
