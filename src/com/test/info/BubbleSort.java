package com.test.info;

/*
 *
 * @冒泡排序 假设数组中元素个数为n，n=arr.length;
 * a. i=1开始，i<arr.length；[1,arr.length-1],刚好是1，2,3,4，……n-1趟
 * b. 为了使得代码整齐有序，j也从1开始，为了覆盖，arr[0],需要比较的两个相邻元素一定是arr[j-1]和arr[j]
 * c. 关于j的范围，是每一轮缩小一个，j<=arr.length-i;
 *
 * 依据下面代码，两个相等的数位置不会移动
 * 最坏时间复杂度为：n-1,n-2,……3,2,1 n*(n-1)/2 ,即o(n^2);
 *
 * @ 选择排序
 * 1.设定一个标志位flag,设定一个最小值存储变量temp,flag和temp的初始值，为flag=0,temp=arr[i]
 * arr[0];
 * 2.内层for循环，j=i+1; temp>a[j],要标记下这一趟中最小值temp,并记下temp对应元素的当前标记flag
 * 直至内层循环退出
 * 3.if语句，判断flag!=i;flag=i(证明当前元素比后面的任何一个元素都要小，因此flag没有被赋值，flag=j)
 *
 * */
public class BubbleSort {
	// 冒泡排序排序方法
	public void bubbleSort(int[] arr) {
		//	n个数，需要n-1趟就可以作升序排列
		for (int i = 1; i < arr.length; i++) {
			// 相邻两个数arr[j-1]和arr[j]比较
			for (int j = 1; j <= arr.length - i; j++) {
				if (arr[j - 1] > arr[j]) {
					// 满足条件,就交换arr[j-1]和arr[j]的值
					int temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;

				}
			}
		}
	}

	// 方法2：选择排序
	public void selectedSort(int arr[]) {
		int i, j;
		int temp = 0;
		// 找到每一趟中最小的temp，其元素索引标记为flag;
		int flag;
		for (i = 0; i < arr.length - 1; i++) {
			// 比较的起始点-初始条件
			temp = arr[i];
			flag = i;
			// 一趟下来，可以找到该趟中的最小temp
			for (j = i + 1; j < arr.length; j++) {
				if (temp > arr[j]) {
					temp = arr[j];
					flag = j;
				}
			}
			//	flag=i;是在每一趟中，初始设定的，如果flag!=i;表示flag至少被改变过哪怕一次，就将(arr[flag]=arr[i])
			//	arr[i]的值赋给arr[flag]; 然后arr[i] = temp;就完成了该趟的起始值和该趟的最小值的交换
			if (flag != i) {
				arr[flag] = arr[i];
				arr[i] = temp;
			}

		}
	}

	public static void main(String[] args) {
		// 实例化一个对象
		BubbleSort bs = new BubbleSort();
		// 提供一个数组
		int arr[] = {112, 35, 6, 7, 8, 36, 36, 19};
		bs.bubbleSort(arr);
		//	输出arr,jdk1.5后，使用forEach输出
		System.out.println("冒泡法升序排列后的数组：");
		for (int elem : arr) {
			System.out.print(elem + "\t");
		}
		int arr1[] = {112, 35, 6, 7, 8, 36, 36, 19};
		bs.selectedSort(arr1);
		// 使用jdk1.5后退出的forEach语句输出
		System.out.println("");
		System.out.println("选择法升序排序后的数组：");
		for (int elm : arr1) {
			System.out.print(elm + "\t");
		}
		System.out.println("");
		final int C = 13 / 10;
		System.out.println(C);// 1
		final double C1 = 13 / 10;
		System.out.println(C1);// 1.0


	}
}
