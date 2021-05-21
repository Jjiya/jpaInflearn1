package jpabook.jpashop;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository{
	@PersistenceContext
	private EntityManager em;	//	implementation 'org.springframework.boot:spring-boot-starter-data-jpa' 빌드.그라들에서 이 설정 덕분에 따로 안해도 됨
	
	public Long save(Member member) {
		em.persist(member);
		return member.getId();
	}
	
	public Member find(Long id) {
		return em.find(Member.class, id);
	}
}