package com.easynews.easynewsserver.repository;

import com.easynews.easynewsserver.model.db.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
}
