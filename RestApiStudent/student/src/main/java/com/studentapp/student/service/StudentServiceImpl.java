package com.studentapp.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentapp.student.entity.Student;
import com.studentapp.student.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	StudentRepository studentRepository;

	@Override
	public List<Student> getAll() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	@Override
	public Student create(Student entity) {
		// TODO Auto-generated method stub
		return studentRepository.save(entity);
	}

	@Override
	public Student update(Student entity) {
		// TODO Auto-generated method stub
		return studentRepository.save(entity);
	}

	@Override
	public void delete(Student entity) {
		// TODO Auto-generated method stub
		studentRepository.delete(entity);
	}

	@Override
	public Student getByID(Long id) {
		// TODO Auto-generated method stub
		return studentRepository.getOne(id);
	}

}
