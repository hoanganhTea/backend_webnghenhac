package com.example.webnghenhac.repository;

import com.example.webnghenhac.entity.MusicTai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface MusicTaiRepository extends JpaRepository<MusicTai, UUID> {
    Optional<MusicTai> findByName(String name);
    boolean existsByName(String name);
}
