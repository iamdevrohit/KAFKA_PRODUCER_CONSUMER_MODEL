package net.kafkademo.consumer.repository;

import net.kafkademo.consumer.entity.WikimediaRecentChange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WikimediaRecentChangesRepository extends JpaRepository<WikimediaRecentChange,Long> {

}
