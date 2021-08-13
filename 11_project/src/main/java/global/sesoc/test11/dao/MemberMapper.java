package global.sesoc.test11.dao;

import global.sesoc.test11.dto.Member;

public interface MemberMapper {

	public int insertMember(Member member);
	public Member selectOne(Member member);
}
