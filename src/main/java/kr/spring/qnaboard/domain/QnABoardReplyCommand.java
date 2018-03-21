package kr.spring.qnaboard.domain;

public class QnABoardReplyCommand {
	private String br_num; 			//댓글번호
	private String br_content; 		// 댓글내용
	private String br_date; 		//작성일 
	private String br_ip; 			//작성자ip
	private String q_num; 			//글번호
	private String m_id; 			//작성자 ID
	public String getBr_num() {
		return br_num;
	}
	public void setBr_num(String br_num) {
		this.br_num = br_num;
	}
	public String getBr_content() {
		return br_content;
	}
	public void setBr_content(String br_content) {
		this.br_content = br_content;
	}
	public String getBr_date() {
		return br_date;
	}
	public void setBr_date(String br_date) {
		this.br_date = br_date;
	}
	public String getBr_ip() {
		return br_ip;
	}
	public void setBr_ip(String br_ip) {
		this.br_ip = br_ip;
	}
	public String getQ_num() {
		return q_num;
	}
	public void setQ_num(String q_num) {
		this.q_num = q_num;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	@Override
	public String toString() {
		return "QnABoardReplyCommand [br_num=" + br_num + ", br_content=" + br_content + ", br_date=" + br_date
				+ ", br_ip=" + br_ip + ", q_num=" + q_num + ", m_id=" + m_id + "]";
	}
	
	
	
}
