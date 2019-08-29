package com.studentapp.student.service;

import java.util.List;

public interface CRUDService<E> {

	List<E> getAll();

	E create(E entity);

	E update(E entity);

	void delete(E entity);

	E getByID(Long id);

}
