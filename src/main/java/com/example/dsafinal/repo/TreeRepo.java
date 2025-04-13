package com.example.dsafinal.repo;

// imports
import com.example.dsafinal.model.TreeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * TreeRepo accesses and performs CRUD operations on the TreeEntity found in /model.
 * This class extends the JpaRepository to allow methods for handling entities!
 */
@Repository
public interface TreeRepo extends JpaRepository<TreeEntity, Long> {
    // unless custom queries are required, this class can mostly stay empty
}
