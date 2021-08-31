package com.godv;

import java.util.Arrays;

public class DiyArrayList<E> implements DiyList<E>{
	private Object[] elementData;
	private int size;
	
	public DiyArrayList() {
		super();
		elementData = new Object[10];
	}
	
	public DiyArrayList(int length) {
		super();
		elementData = new Object[length];
	}
	private void rangeCheckForAdd(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }
	private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E get(int index) {
		rangeCheckForAdd(index);
		return (E) elementData[index];
	}

	@Override
	public boolean add(E e) {
		if (size == elementData.length) {
			int oldelement = elementData.length;
			int newelement = oldelement + (oldelement >> 1);
			//把旧的数组的元素放到新的扩容后的数组里面
			elementData = Arrays.copyOf(elementData, newelement);
		}
		this.elementData[size++] = e;
		return true;
	}

	@Override
	public void add(int index, E element) {
		//检查范围
		rangeCheckForAdd(index);
		//扩容
		if (size == elementData.length) {
			int oldelement = elementData.length;
			int newelement = oldelement + (oldelement >> 1);
			//把旧的数组的元素放到新的扩容后的数组里面
			elementData = Arrays.copyOf(elementData, newelement);
		}
		//
		System.arraycopy(elementData, index, elementData, index + 1, index - size);
		elementData[index] = element;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E remove(int index) {
		rangeCheckForAdd(index);
		System.arraycopy(elementData, index + 1, elementData, index, size - index - 1);
		elementData[--size] = null;
		return null;
	}

	@Override
	public void clear() {
		for (int i = 0; i < size; i++) {
			elementData[i] = null;
		}
		size = 0;
	}
	
}
