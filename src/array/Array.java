package array;

public class Array<E> {
	private E[] data;
	private int size;

	public Array(int capacity) {
		this.data = (E[]) new Object[capacity];
	}

	public Array() {
		this(10);
	}

	public int getCapacity() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public E get(int index) {
		if (index < 0 || index >= this.size)
			throw new IllegalArgumentException("Get failed, Require index>=0 and index<size");
		return this.data[index];
	}

	public void set(int index, E e) {
		if (index < 0 || index >= this.size)
			throw new IllegalArgumentException("Get failed, Require index>=0 and index<size");
		this.data[index] = e;
	}

	public void addLast(E e) {
		this.add(this.size, e);
	}

	public boolean contains(E e) {
		for (int i = 0; i < this.size; i++) {
			if (this.data[i].equals(e)) {
				return true;
			}
		}
		return false;
	}

	public int find(E e) {
		for (int i = 0; i < data.length; i++) {
			if (this.data[i].equals(e)) {
				return i;
			}
		}
		return -1;
	}

	// return the delete value
	public E remove(int index) {
		if (index < 0 || index >= this.size)
			throw new IllegalArgumentException("Delete failed..Index is illegal..");
		E ret = data[index];
		for (int i = index + 1; i < this.size; i++) {
			this.data[i - 1] = this.data[i];
		}
		this.size--;
		data[this.size] = null;
		if (size == data.length / 4&&data.length/2!=0) {
			resize(data.length / 2);
		}
		return ret;
	}

	public E removeFirst() {
		return remove(0);
	}

	public E removeLast() {
		return remove(size - 1);
	}

	public void removeElement(E e) {
		int index = find(e);
		if (index != -1) {
			remove(index);
		}
	}

	public void addFirst(E e) {
		this.add(0, e);
	}

	public void add(int index, E e) {
		if (this.size == data.length)
			resize(2 * data.length);
		if (index < 0 || index > this.size)
			throw new IllegalArgumentException("Add last failed,require index>=0 and index<=size");
		for (int i = size - 1; i >= index; i--) {
			data[i + 1] = data[i];
		}
		data[index] = e;
		this.size++;
	}

	private void resize(int capacity) {
		// TODO Auto-generated method stub
		E[] newData = (E[]) new Object[capacity];
		for (int i = 0; i < this.size; i++) {
			newData[i] = data[i];
		}
		data = newData;
	}

	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append(String.format("Array: size= %d capacity= %d\n", this.size, this.data.length));
		res.append('[');
		for (int i = 0; i < this.size; i++) {
			res.append(data[i]);
			if (i != this.size - 1) {
				res.append(", ");
			}
		}
		res.append(']');
		return res.toString();
	}


	public  int getSize(){
		return this.size;
	}


	public E getLast(){
		return get(size-1);
	}

	public  E getFirst(){
		return  get(0);
	}

}
