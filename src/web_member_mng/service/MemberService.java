package web_member_mng.service;

import java.util.List;

import web_member_mng.dao.impl.MemberDaoImpl;
import web_member_mng.ds.JndiDS;
import web_member_mng.dto.Member;

public class MemberService {

	private MemberDaoImpl dao;
	
	public MemberService() {
		dao = MemberDaoImpl.getInstance();
		dao.setCon(JndiDS.getConnection()); // JndiDS getConnection은 static으로 해놔서 가능함
		// 여기서 con을 설정한 다음 dao에도 con을 전달해줌
	}
	
	public Member loginMember(Member member) {
		return dao.selectMemberById(member);
	}
	
	public Member memberInfo(Member member) {
		return dao.selectMemberByIdForInfo(member);
	}
	
	public List<Member> memberList(){
		return dao.selectMembersByAll();
	}
	
	public int addMember(Member member) {
		return dao.insertMember(member);
	}
	
	public int deleteMember(Member member) {
		return dao.deleteMember(member);
	}
	
	public int modifyMember(Member member) {
		return dao.updateMember(member);
	}
}
