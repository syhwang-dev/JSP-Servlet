package membership;

import java.util.ArrayList;

// DAO를 테스트해보기 위한 코드
public class MemberDAOTest {
	private static MemberDAO memberDAO = new MemberDAO();  // 에러 처리 1. MemberDAO.java에서 디폴트 생성자를 만들어야 함.
	
	public static void printMemberDTO() {
		// Test getMemberDTO()
		MemberDTO memberDTO = memberDAO.getMemberDTO("test1", "1111");  //  memberDAO 에러가 발생하면 private static MemberDAO memberDAO = new MemberDAO(); 와 같이 static을 넣어주면 됨.
		System.out.println(memberDTO);
	}
	

	public static void printAllMemberDTO() {
		// 모든 멤버를 가져와서 화면에 출력
		// Test getAllMemberDTO()
		ArrayList<MemberDTO> list = memberDAO.getAllMemberDTO();
		for ( MemberDTO m : list) {
			System.out.println(m);
		}
	}
	
	public static void insertMemberDTO() {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("Home");
		memberDTO.setPass("1234");
		memberDTO.setName("홍길동");
		memberDAO.insertMemberDTO(memberDTO);
		
	}

	public static void main(String[] args) {
		// CRUD를 이용해 코드를 작성해보자.
		// Create(생성), Read(읽기), Update(갱신), Delete(삭제)
		
//		printMemberDTO();
//		printAllMemberDTO();
		
		System.out.println("-".repeat(80));
		
		insertMemberDTO();
		printAllMemberDTO();
		
		System.out.println("-".repeat(80));
		

	}

}
