package com.tistory.heowc.repository;

import com.tistory.heowc.domain.Member;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends PagingAndSortingRepository<Member, String> {
}
