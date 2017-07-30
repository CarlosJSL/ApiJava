package config;

import java.io.Serializable;
import java.util.List;

public interface IGenericDAO<T, Type extends Serializable> {

	void saveOrUpdate(T entity) throws IllegalArgumentException;


	void save(T entity) throws IllegalArgumentException;

	List<T> listAll();
}
