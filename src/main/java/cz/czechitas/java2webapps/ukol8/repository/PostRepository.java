package cz.czechitas.java2webapps.ukol8.repository;

import cz.czechitas.java2webapps.ukol8.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query(value = "SELECT p.* FROM post p WHERE p.published <= TRUNC(SYSDATE) ORDER BY p.published DESC", nativeQuery = true)
    Page<Post> findNewestSlugs(Pageable pageable);

    Post findBySlug(String slug);
}
