package com.test.info;

/*
 *
 * 此为四种排序：冒泡排序、选择排序、插入排序、归并排序
 * @一、冒泡排序 假设数组中元素个数为n，n=arr.length;
 * a. i=1开始，i<arr.length；[1,arr.length-1],刚好是1，2,3,4，……n-1趟
 * b. 为了使得代码整齐有序，j也从1开始，为了覆盖，arr[0],需要比较的两个相邻元素一定是arr[j-1]和arr[j]
 * c. 关于j的范围，是每一轮缩小一个，j<=arr.length-i;
 *
 * 依据下面代码，两个相等的数位置不会移动
 * 最坏时间复杂度为：n-1,n-2,……3,2,1 n*(n-1)/2 ,即o(n^2);
 *
 * @ 二、选择排序 (实际上也用到了交换，每趟temp和起始的arr[i]交换)
 * 1.设定一个标志位flag,设定一个最小值存储变量temp,flag和temp的初始值，为flag=0,temp=arr[i]
 * arr[0];
 * 2.内层for循环，j=i+1; temp>a[j],要标记下这一趟中最小值temp,并记下temp对应元素的当前标记flag
 * 直至内层循环退出
 * 3.if语句，判断flag!=i;flag=i(证明当前元素比后面的任何一个元素都要小，因此flag没有被赋值，flag=j)
 *
 * @ 三、插入法排序(都是从比较相邻的数字开始，排序前面的数字不干涉后面的)
 * 1.外层循环，确定排序所需要的趟数。i取值从【1，n】
 * 2.设定比较的初始值temp和移动的索引j 。对于每一趟 temp=arr[i];j=i;
 * 3.先使用if语句作判断，比较arr[j-1]和temp的大小；如果arr[j-1]小于temp;直接转到arr[j]=temp;
 * 如果arr[j-1]>temp;则流程进入while循环，while(j>=1&&arr[j-1]>temp)
 * 4.前面数字arr[j-1]>temp;将arr[j-1]的值赋给arr[j];即：arr[j]=arr[j-1];
 *
 *  @ 四、归并排序
 *  1.递归函数实现分治
 *  2.merge函数实现合并
 *
 * 快捷键记忆：
 * ctrl+ "-" / "+"代码折叠和展开
 *
 *
 * */
public class BubbleSort {
	// 1.冒泡排序排序方法
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
				// temp：该趟的起始值，temp随着同arr[j]的比较而赋值，arr[j]除了基准元素temp,
				// 后面的元素依次同temp作比较
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

	// 方法3：插入法排序。第一趟插入了前两个数，以后每一趟插入1个数，直至将所有的数字从小到大依次完成排列
	public void insertedSort(int arr[]) {
		int i, j, temp;
		for (i = 1; i < arr.length; i++) {
			//	初始设置，比较的基准值temp，和基准索引j
			temp = arr[i];
			j = i;
			if (arr[j - 1] > temp) {
				while (j >= 1 && arr[j - 1] > temp) {
					arr[j] = arr[j - 1];
					j--;
				}
			}
			arr[j] = temp;
		}
	}

	// 方法4：归并排序注意分析：递归函数来分治，合并函数来归并
	public void merged(int arr[], int left, int middle, int right) {
		// 临时存储子序列的数组为a[]
		int a[] = new int[arr.length];
		// 子序列排序时，还原临时序列索引
		int tmp = left;
		// 排序过程汇中用到的临时变量third
		int third = left;
		//	后一个序列出书索引为mid
		int mid = middle + 1;
		while (left <= middle && mid <= right) {
			if (arr[left] < arr[mid]) {
				a[third++] = arr[left++];
			} else {
				a[third++] = arr[mid++];
			}
		}
		//	数组中剩余部分排序
		while (left <= middle) {
			a[third++] = arr[left++];
		}
		while (mid <= right) {
			a[third++] = arr[mid++];
		}
		//	临时存储数组a,还原成arr,以便于后面排序使用
		while (tmp <= right) {
			arr[tmp] = a[tmp++];
		}


	}


	public void interitoredSort(int arr[], int left, int right) {
		if (left < right) {
			int middle = (left + right) / 2;
			interitoredSort(arr, left, middle);
			interitoredSort(arr, middle + 1, right);
			merged(arr, left, middle, right);
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
		int arr3[] = {112, 35, 6, 7, 8, 36, 36, 19};
		bs.insertedSort(arr3);
		System.out.println("插入法排序的结果是：");
		for (int ele : arr3) {
			System.out.print(ele + "\t");
		}
		System.out.println("");
		int arr4[] = {112, 35, 6, 7, 8, 36, 36, 19};
		bs.interitoredSort(arr4, 0, arr4.length - 1);
		System.out.println("归并法排序的结果是：");
		for (int ele : arr4) {
			System.out.print(ele + "\t");
		}
		System.out.println("");
		final int C = 13 / 10;
		System.out.println(C);// 1
		final double C1 = 13 / 10;
		System.out.println(C1);// 1.0


	}
}
