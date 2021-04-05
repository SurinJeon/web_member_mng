package web_member_mng.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web_member_mng.dao.MemberDao;
import web_member_mng.dto.Member;

public class MemberDaoImpl implements MemberDao {
	private static final MemberDaoImpl instance = new MemberDaoImpl();
	private Connection con;
	
	private MemberDaoImpl() {
		
	}
	
	public static MemberDaoImpl getInstance() {
		return instance;
	}
	
	
	@Override
	public List<Member> selectMembersByAll() {
		String sql = "select id, passwd, name, age, gender, email from member";
		try(PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();){
			if(rs.next()) {
				List<Member> list = new ArrayList<Member>();
				do {
					list.add(getMember(rs));
				} while(rs.next());
				return list;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Member selectMemberByIdForInfo(Member member) {
		String sql = "select id, name, age, gender, email"
					+ " from member"
					+ " where id = ?";
		
		try(PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, member.getId());
			try (ResultSet rs = pstmt.executeQuery();) {
				if (rs.next()) {
					return getMember(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	
	@Override
	public Member selectMemberById(Member member) {
		String sql = "select id, name, age, gender, email"
					+ " from member"
					+ " where id = ? and passwd = password(?)";
		
		try(PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPasswd());
			
			try (ResultSet rs = pstmt.executeQuery();) {
				if (rs.next()) {
					return getMember(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

	private Member getMember(ResultSet rs) throws SQLException {
		String id = rs.getString("id");
		String name = rs.getString("name");
		int age = rs.getInt("age");
		String gender = rs.getString("gender");
		String email = rs.getString("email");
		
		return new Member(id, name, age, gender, email);
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	@Override
	public int insertMember(Member member) {
		String sql = "insert into member"
				+ "  values(?, password(?), ?, ?, ?, ?)";
		try(PreparedStatement pstmt = con.prepareStatement(sql);){
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPasswd());
			pstmt.setString(3, member.getName());
			pstmt.setInt(4, member.getAge());
			pstmt.setString(5, member.getGender());
			pstmt.setString(6, member.getEmail());
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int updateMember(Member member) {
		String sql = "update member"
				+ " set id = ?, passwd = password(?), name = ?, age = ?, gender = ?, email = ?"
				+ " where id = ?";
		
		try(PreparedStatement pstmt = con.prepareStatement(sql);){
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPasswd());
			pstmt.setString(3, member.getName());
			pstmt.setInt(4, member.getAge());
			pstmt.setString(5, member.getGender());
			pstmt.setString(6, member.getEmail());
			pstmt.setString(7, member.getId());
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public int deleteMember(Member member) {
		String sql = "delete from member where id = ?";
		try(PreparedStatement pstmt = con.prepareStatement(sql);){
			pstmt.setString(1, member.getId());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
}
