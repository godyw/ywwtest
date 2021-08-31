package com.godv;

import java.util.ArrayList;
import java.util.List;

public interface DiyList<E> {

	public int size();
	
	public boolean isEmpty();
	
	public boolean contains(Object o);
	
	public E get(int index);
	
	public boolean add(E e);
	public void add(int index, E element);
	
	public boolean remove(Object o);
	public E remove(int index);
	
	public void clear();
	
}
