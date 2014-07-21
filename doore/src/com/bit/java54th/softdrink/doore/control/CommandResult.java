package com.bit.java54th.softdrink.doore.control;

public class CommandResult {
	private String viewURL;	
	private String contentType;
	private String content;
	
	public CommandResult(String viewURL) {
		this(viewURL, null, null);		
	}
	
	public CommandResult(String contentType, String content) {
		this(null, contentType, content);		
	}
	
	
	private CommandResult(String viewURL, String contentType, String content) {
		this.viewURL = viewURL;
		this.contentType = contentType;
		this.content = content;		
	}
	
	public String getViewURL() {
		return viewURL;
	}

	public void setViewURL(String viewURL) {
		this.viewURL = viewURL;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public boolean hasView() {
		return (viewURL != null ? true : false);
	}
}
