package web_member_mng.dao;

import java.util.List;

import web_member_mng.dto.Member;

public interface MemberDao {
	Member selectMemberById(Member member);
	List<Member> selectMembersByAll();
	Member selectMemberByIdForInfo(Member member);
	int insertMember(Member member);
	int updateMember(Member member);
	int deleteMember(Member member);
}
