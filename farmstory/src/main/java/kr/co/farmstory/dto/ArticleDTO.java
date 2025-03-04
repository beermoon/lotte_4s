package kr.co.farmstory.dto;

public class ArticleDTO {
	private String title;
	private String content;
	private String file;
	
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	
	
	@Override
	public String toString() {
		return "CommunityDTO [title=" + title + ", content=" + content + ", file=" + file + "]";
	}
	
	
	
}
