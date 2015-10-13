package org.cx.test;

public class Arithmetic {

	public static void main(String[] args) {
		int[] a={1,3,7,9};
		int[] b={1,5,7,9};
		
		for(int i=0; i<a.length; i++) {
			boolean flag = false;
			for(int j=0; j<a.length; j++) {
				if (a[i] == b[j]) {
					flag = true;
					break;
				}
				System.out.println(a[i]);
			}
		}
	}

}
