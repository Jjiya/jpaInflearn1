package jpabook.jpashop;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest2 {

	@Autowired MemberRepository memberRepository;
	
	@Test
	@Transactional
	public void testMember() throws Exception {
//		given
		Member member = new Member();
		member.setUsername("memberA");
		
//		when
		Long saveId = memberRepository.save(member);
		System.out.println("반환 >>" + saveId);
		Member findMember = memberRepository.find(saveId);
		System.out.println(findMember + " // " + findMember.getClass().getName() );
		
//		then
		Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
	}


}
