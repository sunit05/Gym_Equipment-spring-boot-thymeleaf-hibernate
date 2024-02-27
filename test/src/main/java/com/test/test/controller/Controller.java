package com.test.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.test.model.Task;
import com.test.test.repository.TestRepository;

@RestController
@RequestMapping("/persian/")
public class Controller {

	@Autowired
	private TestRepository taskRepository;

	@GetMapping
	public List<Task> getAllTasks() {
		return taskRepository.findAll();
	}

	@GetMapping("/{id}")
	public Task getTaskById(@PathVariable Long id) {
		return taskRepository.findById(id).orElse(null);
	}

	@PostMapping
	public Task createTask(@RequestBody Task task) {
		return taskRepository.save(task);
	}

	@PutMapping("/{id}")
	public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
		task.setId(id);
		return taskRepository.save(task);
	}

	@DeleteMapping("/{id}")
	public void deleteTask(@PathVariable Long id) {
		taskRepository.deleteById(id);
	}

	@PostMapping("/login")
	public String Login(@RequestBody Task task) {
		
		List<Task> ts = taskRepository.findAll();
		String un=task.getUn();
		String pw=task.getPw();
		
		Task ap=taskRepository.findByUn(un);
		System.out.println(un);
		
//		for (Task t : ts) {
//			if (t.getUn().equals(un) && t.getPw().equals(pw)) {
//				return "success";
//			}
//		}
	
		if(un!=null) {
			return "success!";
		}
		return "incorrect username & password!";
		
	}
}
