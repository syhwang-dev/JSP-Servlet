// 여러 개 만들기
package fileio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import membership.MemberDTO;

public class ObjectMain2 {

	public void serialize(MemberDTO obj, String fileName) throws IOException {
		try (FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {

			oos.writeObject(obj);
		}
	}
	// 같은 이름의 메소드에 파라미터 이름만 다른 것 - 오버로딩
	public void serialize(List<MemberDTO> list, String fileName) throws IOException {
		try (FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {

			for (MemberDTO m : list)
				oos.writeObject(m);
		}
	}

//	public MemberDTO deserialize(String fileName) throws IOException, ClassNotFoundException {
//		MemberDTO m = null;
//		try (FileInputStream fis = new FileInputStream(fileName);
//				ObjectInputStream ois = new ObjectInputStream(fis);) {
//
//			m = (MemberDTO)ois.readObject();
//		}		
//		return m;
//	}	
	
	public List<MemberDTO> deserialize(String fileName) throws IOException, ClassNotFoundException {
		Object m = null;
		List<MemberDTO> list = new ArrayList<>();
		try (FileInputStream fis = new FileInputStream(fileName);
				ObjectInputStream ois = new ObjectInputStream(fis);) {

//			while ((m = ois.readObject()) != null) {
//				list.add(MemberDTO)m);
//			}
			
			for (int i=0; i<2; i++) {
				m = ois.readObject();
				list.add((MemberDTO)m);
			}
		}		
		return list;
	}
	
	public static void main(String[] args) throws Exception {
		
		ObjectMain2 om = new ObjectMain2();
		
		List<MemberDTO> list = new ArrayList<>();
		list.add(new MemberDTO("100", "1234", "홍길동1", "2023-05-31"));
		list.add(new MemberDTO("200", "5678", "홍길동2", "2023-05-30"));
		list.add(new MemberDTO("300", "9123", "홍길동3", "2023-05-29"));
		
		om.serialize(list, "testObject2.dat");
		

//		System.out.println(m);
	}
}
