package com.entity;

import java.io.Serializable;
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

public class FileEntity implements Serializable

{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

  private int id;
  private String filename;
  private String type;
  private long size;
  private String mimetype;
  @CreationTimestamp
  private Date createdat;
  @UpdateTimestamp
  private Date updatedat;
  private String encoding;
  private String originalname;
 
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

	public String gettype() 
	
	{
		return type;
	}

	public void setype(String type) 
	{
		this.type = type;
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

		public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	public String getOriginalname() {
		return originalname;
	}

	public void setOriginalname(String originalname) {
		this.originalname = originalname;
	}

	

	
	public FileEntity(int id, String filename, String type, long size, String mimetype, Date createdat, Date updatedat,
			String encoding, String originalname) {
		super();
		this.id = id;
		this.filename = filename;
		this.type = type;
		this.size = size;
		this.mimetype = mimetype;
		this.createdat = createdat;
		this.updatedat = updatedat;
		this.encoding = encoding;
		this.originalname = originalname;
		
	}

	public FileEntity()
	{
		super();
		
	}
  
  
 


}