package fileupload;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Vector;

import common.JDBCConnect;

// public class MyfileDAO extends DBConnPool {
public class MyfileDAO extends JDBCConnect{
	public int insertFile(MyfileDTO dto) {
		int applyResult = 0;
		
//		Connection con = getConnection();
//		if (con == null) return 0;
//		PreparedStatement psmt = null;
		
		int ret = 0;
		
		try {
			// idx는 자동 생성이므로 생략
            String query = "INSERT INTO myfile ( "
                    + " name, title, cate, ofile, sfile) "
                    + " VALUES ( "
                    + " ?, ?, ?, ?, ?)";
            
            psmt = con.prepareStatement(query);
            psmt.setString(1, dto.getName());
            psmt.setString(2, dto.getTitle());  
            psmt.setString(3, dto.getCate());
            psmt.setString(4, dto.getOfile());
            psmt.setString(5, dto.getSfile());
            
            applyResult = psmt.executeUpdate();
			
		}
		catch (Exception e) {
			System.out.println("INSERT 중 예외 발생");
			e.printStackTrace();
		}
		return applyResult;
	}
	
    public List<MyfileDTO> myFileList() {
        List<MyfileDTO> fileList = new Vector<MyfileDTO>();

        // 쿼리문 작성
        String query = "SELECT * FROM myfile ORDER BY idx DESC";
        
        try {
            psmt = con.prepareStatement(query);  // 쿼리 준비
            rs = psmt.executeQuery();  // 쿼리 실행

            while (rs.next()) { 
                MyfileDTO dto = new MyfileDTO();
                dto.setIdx(rs.getString(1));
                dto.setName(rs.getString(2));
                dto.setTitle(rs.getString(3));
                dto.setCate(rs.getString(4));
                dto.setOfile(rs.getString(5));
                dto.setSfile(rs.getString(6));
                dto.setPostdate(rs.getString(7));
                
                fileList.add(dto);
            }
        }
        catch (Exception e) {
            System.out.println("SELECT 시 예외 발생");
            e.printStackTrace();
        }        
        
        return fileList;  // 목록 반환
    }
	
	// 생성한 insertFile을 main문에서 테스트하기
	public static void main(String[] args) { 
		/*
		# 방법1과 방법2의 결과는 같음.
		방법1.
		// 1. 데이터 입력 객체를 만듦.
		MyfileDAO dao = new MyfileDAO();
		
		// 2. 입력할 DTO 객체를 만듦.
		MyfileDTO dto = new MyfileDTO();
		
		// 3. 입력할 내용을 DTO 객체에 설정
		dto.setName("A1");
		dto.setTitle("B1");
		dto.setCate("C1");
		dto.setOfile("D1");
		dto.setSfile("E1");
		
		// 4. 데이터를 입력함.
		dao.insertFile(dto);	
	
		
		방법2.
		// 1. 데이터 입력 객체를 만듦.
		MyfileDAO dao = new MyfileDAO();
		
		// 2. DTO 객체를 생성해서 입력함. - 이 방법은 DTO에 기본생성자 및 toString이 있어야 함.
		// 객체를 생성하고 값을 바로 넣는 프로세스
		dao.insertFile(new MyfileDTO("A", "B", "C", "D", "E"));
		*/
		
		
		
		
		//// 1. 내용 입력하기
		// MyfileDAO
		MyfileDAO dao = new MyfileDAO();
		
		// MyfileDTO
		MyfileDTO dto = new MyfileDTO();
		
//		dto.setName("A1");
//		dto.setTitle("B1");
//		dto.setCate("C1");
//		dto.setOfile("D1");
//		dto.setSfile("E1");
//		
//		dao.insertFile(dto);
		
		//// 2. 파일 목록 보기
//		MyfileDAO dao = new MyfileDAO();
		List<MyfileDTO> fileLists = dao.myFileList();
		for (MyfileDTO f : fileLists) {
			System.out.print(f.getIdx() + " ");
			System.out.print(f.getName() + " ");
			System.out.print(f.getTitle() + " ");
			System.out.print(f.getCate() + " ");
			System.out.print(f.getOfile() + " ");
			System.out.print(f.getSfile() + " ");
			System.out.println();
		}
//		System.out.println();
		
		dao.close();
	}
}
