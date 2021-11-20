package sk.upjs.gursky.pdb;

import java.nio.ByteBuffer;

import sk.upjs.gursky.bplustree.BPObject;

public class SalaryOffsetEntry implements BPObject<SalaryKey, SalaryOffsetEntry> {

	private static final long serialVersionUID = 7201705743484686330L;
	int salary;
	long offset;

	public SalaryOffsetEntry() {
	}

	public SalaryOffsetEntry(int salary, long offset) {
		this.salary = salary;
		this.offset = offset;
	}

	@Override
	public int compareTo(SalaryOffsetEntry o) {
		if (salary < o.salary) return -1;
		if (salary > o.salary) return 1;
		return 0;
	}

	@Override
	public void load(ByteBuffer bb) {
		char[] data = new char[10];

		for (int i = 0; i < 10; i++) {
			data[i] = bb.getChar();
		}
		salary = bb.getInt();
		offset = bb.getLong();
	}

	@Override
	public void save(ByteBuffer bb) {
		bb.putInt(salary);
		bb.putLong(offset);
	}

	@Override
	public int getSize() {
		return 12;
	}

	
	public SalaryKey getKey() {
		return new SalaryKey(salary);
	}
	
	public int getSalary() {
		return salary;
	}
	
	public long getOffset() {
		return offset;
	}

	@Override
	public String toString() {
		return "SalaryOffsetEntry [salary=" + salary + ", offset=" + offset + "]";
	}

}