package membership;

import java.io.Serializable;

public class MemberDTO implements Serializable{
	
	// File I/O 사용을 위해 사용
	// 마크인터페이스
	// 디스크에 사용한 것을 검증하기 위한 목적으로 사용
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String pass;
	private String name;
	private String regidate;
	
	public MemberDTO() { }
	
	// 생성자
	public MemberDTO(String id, String pass, String name, String regidate) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.regidate = regidate;
	}

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getRegidate() {
		return regidate;
	}


	public void setRegidate(String regidate) {
		this.regidate = regidate;
	}


	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", pass=" + pass + ", name=" + name + ", regidate=" + regidate + "]";
	}
}
