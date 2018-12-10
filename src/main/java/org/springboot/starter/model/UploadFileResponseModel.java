package org.springboot.starter.model;

import java.io.Serializable;

public class UploadFileResponseModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3939358027280350563L;
	
	private String fileName;
    private String fileDownloadUri;
    private String fileType;
    private long size;
    
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileDownloadUri() {
		return fileDownloadUri;
	}
	public void setFileDownloadUri(String fileDownloadUri) {
		this.fileDownloadUri = fileDownloadUri;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
}
