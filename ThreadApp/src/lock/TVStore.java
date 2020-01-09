package lock;

public class TVStore {

	int product = 0;
	int bound = 10;

	synchronized void get() {
		while (product < 1) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		product--;
		System.out.println("���������� ����� �����!");
		System.out.println("����� �������:" + product);
		notify();
	}

	synchronized void add() {
		while (product >= bound) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		product++;
		System.out.println("����� ��� ��������!");
		System.out.println("����� �������:" + product);
		notify();
	}
}
