package web_member_mng.dao;

import java.sql.Connection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import web_member_mng.dao.impl.MemberDaoImpl;
import web_member_mng.dto.Member;

public class MemberDaoTest {
	private static Connection con;
	private MemberDaoImpl dao;
	
	@BeforeClass // MemberDaoTest.java가 수행 되기 전에 호출
	public static void setUpBeforeClass() throws Exception {
		con = JdbcUtil.getConnection();
		
	}

	@Before // test method가 호출 되기 전에 호출
	public void setUp() throws Exception {
		dao = MemberDaoImpl.getInstance();
		dao.setCon(con);
	}

	@Test
	public void testSelectMemberByIdSuccess() {
		System.out.println("testSelectMemberByIdSuccess()");
		Member member = new Member("1", "1111");	
		Member memberLogin = dao.selectMemberById(member);
		
		// 해당 검색 결과가 null이라면 아이디가 아예 없거나, 비번이 잘못된 것
		// null이 아니라면 로그인 가능함
		
		Assert.assertNotNull(memberLogin);
		System.out.println(memberLogin);
	}
	
	@Test
	public void testSelectMemberByIdFail() {
		System.out.println("testSelectMemberByIdFail()");
		Member member = new Member("1", "1112");	
		Member memberLogin = dao.selectMemberById(member);
		
		Assert.assertNull(memberLogin);
		System.out.println(memberLogin);
		
	}
	
	@Test
	public void testInsertMember() {
		System.out.println("testInsertMember()");
		Member newMember = new Member("2", "1111", "짱짱수린", 20, "여자", "zzangsurin@test.co.kr");	
		int res = dao.insertMember(newMember);
		
		Assert.assertEquals(1, res);
		System.out.println(dao.selectMemberById(new Member("2", "1111")));
		
	}
	
}
