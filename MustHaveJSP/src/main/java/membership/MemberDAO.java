package membership;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import common.JDBCConnect3;

public class MemberDAO extends JDBCConnect3 {
	
	// 디폴트 생성자 (Ctrl + Space를 사용하면 바로 생성됨.)
	public MemberDAO() {}
	
	// 명시한 데이터베이스
	public MemberDAO(String drv, String url, String id, String pw) {
		super(drv, url, id, pw);
	}
	
	// 모든 유저들의 정보를 반환
//	public ArrayList<MemberDTO> getAllMemberDTO() {
//		Connection con = getConnection();  // 호출할 때 마다 DB에 연결하기 때문에 소요 시간이 걸려 바람직한 방법은 아님. 하지만 안전함.
//		if (con == null) return null;
//		Statement st = null;
//		ResultSet rs = null;
//		
//		ArrayList<MemberDTO> list = null;
//		
//		try {
//			st = con.createStatement();		
//			rs = st.executeQuery("select * from member");
//			
//			list = new ArrayList<>();
//			
//			while (rs.next()) {
//				MemberDTO dto = new MemberDTO();
//				dto.setId(rs.getString("id"));
//				dto.setPass(rs.getString("pass"));
//				dto.setName(rs.getString(3));
//				dto.setRegidate(rs.getString(4));
//				
//				list.add(dto);
//			}
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (rs != null) rs.close();
//				if (st != null) st.close();
//				con.close();
//			} catch (Exception e) {}
//		}
//		
//		return dto; 
//	}
	
	// executeQuery
	public MemberDTO getMemberDTO(String uid, String upass) {
		MemberDTO dto = new MemberDTO();
		String query = "select * from member where id=? and pass=?";
		
		Connection con = getConnection();  // 호출할 때 마다 DB에 연결하기 때문에 소요 시간이 걸려 바람직한 방법은 아님. 하지만 안전함.
		if (con == null) return null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, uid);
			psmt.setString(2, upass);
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				dto.setId(rs.getString("id"));
				dto.setPass(rs.getString("pass"));
				dto.setName(rs.getString("name"));
				dto.setRegidate(rs.getString("regidate"));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (rs != null) rs.close();
				if (psmt != null) psmt.close();
				con.close();
			} catch (Exception e) {}
		}
		
		return dto; 
	}
	
	
	// 모든 회원 정보를 반환
	public ArrayList<MemberDTO> getAllMemberDTO() {
		Connection con = getConnection();  // 호출할 때 마다 DB에 연결하기 때문에 소요 시간이 걸려 바람직한 방법은 아님. 하지만 안전함.
		if (con == null) return null;
		Statement st = null;
		ResultSet rs = null;
		
		ArrayList<MemberDTO> list = null;
		
		try {
			st = con.createStatement();		
			rs = st.executeQuery("select * from member");
			
			list = new ArrayList<>();
			
			while (rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setId(rs.getString("id"));
				dto.setPass(rs.getString("pass"));
				dto.setName(rs.getString(3));
				dto.setRegidate(rs.getString(4));
				
				list.add(dto);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (st != null) st.close();
				con.close();
			} catch (Exception e) {}
		}
		
		return list; 
	}

	// executeQuery
	// 새로운 회원을 입력
	public int insertMemberDTO(MemberDTO member) {
		String sql = "insert into member(id, pass, name) values (?, ?, ?)";
		
		Connection con = getConnection();  // 호출할 때 마다 DB에 연결하기 때문에 소요 시간이 걸려 바람직한 방법은 아님. 하지만 안전함.
		if (con == null) return 0;
		PreparedStatement psmt = null;
		int ret = 0;
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, member.getId());
			psmt.setString(2, member.getPass());
			psmt.setString(3, member.getName());
			ret = psmt.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (psmt != null) psmt.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ret;
	}
	
	
	// 기존 회원 정보를 변경
//	public int updateMemberDTO(MemberDTO member) {
//		String sql = "update member set name=?, pass=?, where id=?";
//		
//		Connection con = getConnection();  // 호출할 때 마다 DB에 연결하기 때문에 소요 시간이 걸려 바람직한 방법은 아님. 하지만 안전함.
//		if (con == null) return 0;
//		PreparedStatement psmt = null;
//		int ret = 0;
//		
//		try {
//			psmt = con.prepareStatement(null)
//		}
//		
//		return 0;
//	}
	
	// 기존 회원 삭제
	public int deleteMemberDTO(MemberDTO member) {
		return 0;
		
	}
		
	
}
