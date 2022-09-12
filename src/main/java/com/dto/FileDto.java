package com.dto;

public class FileDto 
{
	  private int id;
	  private String filename;
	  private String filetype;
	  private long size;
	  private String mimetype;
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
	public String getFiletype() {
		return filetype;
	}
	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
	public String getMimetype() {
		return mimetype;
	}
	public void setMimetype(String mimetype) {
		this.mimetype = mimetype;
	}
	public FileDto(int id, String filename, String filetype, long size, String mimetype) {
		super();
		this.id = id;
		this.filename = filename;
		this.filetype = filetype;
		this.size = size;
		this.mimetype = mimetype;
	}
	public FileDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	  
	  
	  
	  
}
