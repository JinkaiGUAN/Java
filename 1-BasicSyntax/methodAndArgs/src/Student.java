
public class Student {
	private Sting name;
	private int age;
	private boolean male;

	public void setName(String name) {
		name = name;
	}

	public String getName() {
		return name;
	}

	public void setAge(int age) {
		age = age;
	}

	public int getAge() {
		return age;
	}


	public void setMale(boolean b) {
		male = b;
	}

	public booleam isMale() {
		return male;
	}

	
}


import java.util.Scanner;


public class Demo {

	public static void main(String[] args) {

		// System.in represents the input from the keyboard
		// Get int number: scanner.nextInt();
		// Get sting: scanner.next();

		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		String str = scanner.next();
	}

}


import java.util.Random;

public calss Demo {
	public static void main(String[] args) {
		// random.nextInt(): 生成一个int， 再int所有范围内
		// random.nextInt(int n): 生成一个 [1, n) 的整数
		Random random = new Random();

	}
}


import java.util.ArrayList;

/**
 * 
 * ArrayList 方法
 * 
 * public boolean add(E e), 向集合中添加元素， 参数类型与泛型一致。 ArrayList 添加一定会成功，
 *  因此返回元素可不用， 但是对于其他集合， 则可能需要使用返回值。
 * public E get(int index), 从集合中获取元素， 参数是索引编号， 返回值就是对应位置的元素
 * public E remove(int index), 从集合中删除元素， 参数是索引编号， 返回值就是被删除的元素
 * public int size()， 获取集合长度， 返回集合中元素的个数
 * 
 * 如果希望再集合ArrayList中储存类型基本数据， 必须使用基本类型对应的"包装类"
 * 基本类型 - 包装类
 * byte - Byte
 * short - Short
 * int - Integer
 * long - Long 
 * float - Float
 * double - Double
 * char - Character
 * boolean - Boolean
 * 
 * 从JDK 1.5 开始， 指出自动装箱， 自动拆箱。
 * 
 * 自动装箱： 基本类型 --> 包装类型
 * 自动拆箱： 包装类型 --> 基本类型
 * 
 */
public class Demo {
	public static void Main(String[] args) {
		// 泛型只能是引用类型， 不能是基本类型

		ArrayList<String> list = new ArrayList<>(); // 右边<>中的泛型可以不填， 但是左边不行。
		System,out.println(list); // 直接打印ArrayList可以变成打印内部内容， 因为ArrayList默认处理为toString（）。

		list.add("ABB"); // 添加元素
		String name = list.get(0);
		list.remove(0);
		int size = list.size();
	}
}