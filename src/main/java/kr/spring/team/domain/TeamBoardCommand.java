package kr.spring.team.domain;

import java.io.IOException;
import java.sql.Date;
import java.util.Arrays;

import org.springframework.web.multipart.MultipartFile;

public class TeamBoardCommand {
	private String m_nick;
	private int g_num;
	private int tb_num;
	private String tb_title;
	private String tb_content;
	private MultipartFile upload;
	private byte[] uploadfile;
	private String filename;
	private Date tb_date;
	
	public String getM_nick() {
		return m_nick;
	}
	public void setM_nick(String m_nick) {
		this.m_nick = m_nick;
	}
	public int getG_num() {
		return g_num;
	}
	public void setG_num(int g_num) {
		this.g_num = g_num;
	}

	public int getTb_num() {
		return tb_num;
	}
	public void setTb_num(int tb_num) {
		this.tb_num = tb_num;
	}
	public String getTb_title() {
		return tb_title;
	}
	public void setTb_title(String tb_title) {
		this.tb_title = tb_title;
	}
	public String getTb_content() {
		return tb_content;
	}
	public void setTb_content(String tb_content) {
		this.tb_content = tb_content;
	}
	public MultipartFile getUpload() {
		return upload;
	}
	public void setUpload(MultipartFile upload) throws IOException {
		this.upload = upload;
		
		//MultipartFile -> byte[]
		setUploadfile(upload.getBytes());
		//파일명 셋팅
		setFilename(upload.getOriginalFilename());
	}
	public byte[] getUploadfile() {
		return uploadfile;
	}
	public void setUploadfile(byte[] uploadfile) {
		this.uploadfile = uploadfile;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public Date getTb_date() {
		return tb_date;
	}
	public void setTb_date(Date tb_date) {
		this.tb_date = tb_date;
	}
	@Override
	public String toString() {
		return "TeamBoardCommand [m_nick=" + m_nick + ", g_num=" + g_num + ", tb_num=" + tb_num
				+ ", tb_title=" + tb_title + ", tb_content=" + tb_content + ", upload=" + upload + ", uploadfile="
				+ Arrays.toString(uploadfile) + ", filename=" + filename + ", tb_date=" + tb_date + "]";
	}
	
	
}
