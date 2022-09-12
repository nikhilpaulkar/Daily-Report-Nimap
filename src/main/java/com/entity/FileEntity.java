package com.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

@Entity
@Table(name="file")
@Where(clause="isactive=true")
@SQLDelete(sql="UPDATE file SET isactive=false WHERE id=?")

public class FileEntity 
{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

  private int id;
  private String filename;
  private String filetype;
  private long size;
  private String mimetype;
  @CreationTimestamp
  private Date createdat;
  @UpdateTimestamp
  private Date updatedat;
  private boolean isactive=true;

	public int getId()
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public String getFilename() 
	{
		return filename;
	}

	public void setFilename(String filename)
	{
		this.filename = filename;
	}

	public String getFiletype() 
	
	{
		return filetype;
	}

	public void setFiletype(String filetype) 
	{
		this.filetype = filetype;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) 
	{
		this.size = size;
	}

	public String getMimetype()
	{
		return mimetype;
	}

	public void setMimetype(String mimetype) 
	{
		this.mimetype = mimetype;
	}

	public Date getCreatedat() {
		return createdat;
	}

	public void setCreatedat(Date createdat) {
		this.createdat = createdat;
	}

	public Date getUpdatedat() 
	{
		return updatedat;
	}

	public void setUpdatedat(Date updatedat)
	{
		this.updatedat = updatedat;
		
	}
	

	public boolean isIsactive() {
		return isactive;
	}

	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}

	

	public FileEntity(int id, String filename, String filetype, long size, String mimetype, Date createdat,
			Date updatedat, boolean isactive) {
		super();
		this.id = id;
		this.filename = filename;
		this.filetype = filetype;
		this.size = size;
		this.mimetype = mimetype;
		this.createdat = createdat;
		this.updatedat = updatedat;
		this.isactive = isactive;
	}

	public FileEntity()
	{
		super();
		
	}
  
  
 


}