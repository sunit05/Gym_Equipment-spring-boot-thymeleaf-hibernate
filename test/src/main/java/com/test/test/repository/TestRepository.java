package com.test.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.test.model.Task;

public interface TestRepository extends JpaRepository<Task, Long> {

	public Task findByUn(String un);
}
