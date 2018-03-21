package kr.spring.qnaboard.domain;

public class QnABoardCommand {
		
	private int q_num;		// �۹�ȣ   
	private String q_col;		// ����    
	private String q_title;	    // ����    
	private String q_content;   // ����    
	private String q_answer;    // �亯(���θ���)   
	private String q_date;      // �ۼ���   
	private String q_hit;       // ��ȸ��   
	private String q_ip;        // IP�ּ�  
	private String q_nick;      // �г���   
	private String q_private;   // ��бۿ��� 
	private String m_id;        // ���̵�   
	
	
	
	public int getQ_num() {
		return q_num;
	}
	public void setQ_num(int q_num) {
		this.q_num = q_num;
	}
	public String getQ_col() {
		return q_col;
	}
	public void setQ_col(String q_col) {
		this.q_col = q_col;
	}
	public String getQ_title() {
		return q_title;
	}
	public void setQ_title(String q_title) {
		this.q_title = q_title;
	}
	public String getQ_content() {
		return q_content;
	}
	public void setQ_content(String q_content) {
		this.q_content = q_content;
	}
	public String getQ_answer() {
		return q_answer;
	}
	public void setQ_answer(String q_answer) {
		this.q_answer = q_answer;
	}
	public String getQ_date() {
		return q_date;
	}
	public void setQ_date(String q_date) {
		this.q_date = q_date;
	}
	public String getQ_hit() {
		return q_hit;
	}
	public void setQ_hit(String q_hit) {
		this.q_hit = q_hit;
	}
	public String getQ_ip() {
		return q_ip;
	}
	public void setQ_ip(String q_ip) {
		this.q_ip = q_ip;
	}
	public String getQ_nick() {
		return q_nick;
	}
	public void setQ_nick(String q_nick) {
		this.q_nick = q_nick;
	}
	public String getQ_private() {
		return q_private;
	}
	public void setQ_private(String q_private) {
		this.q_private = q_private;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	
	
	@Override
	public String toString() {
		return "QnABoardCommand [q_num=" + q_num + ", q_col=" + q_col + ", q_title=" + q_title + ", q_content="
				+ q_content + ", q_answer=" + q_answer+ ", q_date=" + q_date + ", q_hit=" + q_hit + ", q_ip=" + q_ip + ", q_nick=" + q_nick
				+ ", q_private=" + q_private + ", m_id=" + m_id + "]";
	}
}





