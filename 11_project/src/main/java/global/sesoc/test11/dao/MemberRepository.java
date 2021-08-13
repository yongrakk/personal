package global.sesoc.test11.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import global.sesoc.test11.dto.Member;

@Repository
public class MemberRepository {

	@Autowired
	SqlSession session;
	
	public int insertMember(Member member) {
		MemberMapper mapper =session.getMapper(MemberMapper.class);
		int result = mapper.insertMember(member);
		return result;
	}
	public Member login(Member member) {
		MemberMapper mapper = session.getMapper(MemberMapper.class);
		Member logmember =mapper.selectOne(member);
		return logmember;
	}
}
