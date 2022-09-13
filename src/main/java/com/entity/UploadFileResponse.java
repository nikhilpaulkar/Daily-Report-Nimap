package com.entity;

public class UploadFileResponse 
{
	private int  id;

	private String filename;

	private String path;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public UploadFileResponse(int id, String filename, String path) {
		super();
		this.id = id;
		this.filename = filename;
		this.path = path;
	}

	public UploadFileResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
