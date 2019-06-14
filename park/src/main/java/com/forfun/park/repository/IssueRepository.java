package com.forfun.park.repository;

import com.forfun.park.models.Issue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Long> {
    Page<Issue> findByUserId(long id, Pageable pageable);

    Page<Issue> findByTitleLikeOrBodyLike(String qT, String qB, Pageable pageable);

    Page<Issue> findByUserIdAndActiveTrue(long id, Pageable pageable);
    Page<Issue> findByUserIdAndActiveFalse(long id, Pageable pageable);
}
