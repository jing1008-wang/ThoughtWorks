package thoughtWorks;

import java.util.Scanner;

public class MiGong {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		//输入道路网格的行列个数
		System.out.println("请输入道路网格的行数和列数:");
		int m =0;
		int n =0;
		try {
			m = in.nextInt();
			n = in.nextInt();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			System.out.println("Incorrect command format​.");
			e.printStackTrace();
			System.exit(0);
		}
		//判断是否有效
		checkMN(m,n);
		//输入道路网格间连通情况字符串
		System.out.println("请输入道路网格间连通情况字符串:");
		in.nextLine();
		String s = in.nextLine();
		//核实字符串是否符合要求
		if(Check(s)) {
			//划分得到道路网格的各个坐标
			String[] str = s.trim().split("[ \\;\\,]");
			for(int i=0;i<str.length;i++) {
				//坐标数字非负整数时
				if(Integer.parseInt(str[i])<0||Integer.parseInt(str[i])>Integer.MAX_VALUE){
					System.out.println("Number out of range.");
					System.exit(0);
				}
			}
			//创建渲染网格
			CreateMiGong(m,n,str);
		}
	}
	public static boolean checkMN(int m,int n) {
		if(m<=0||n<=0||m>Integer.MAX_VALUE||n>Integer.MAX_VALUE) {
			System.out.println("Number out of range.");
		}
		return false;
	}
	public static boolean Check(String s) {
		if(s==null||s.trim().equals("")) {
			System.out.println("Incorrect command format​.");
			return false;
		}
//		if(!s.matches("^\\d+$")) {
//			System.out.println("Incorrect number format​.");
//			return false;
//		}
		return true;
	}
	public static void CreateMiGong(int m,int n,String[] str) {
		if(str.length<4) {
			System.out.println("Incorrect command format.");
		}
		int row = m*2+1;
		int col = n*2+1;
		int[][] mg = new int[row][col];
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				mg[i][j]=0;
				//System.out.print(mg[i][j]+" ");
			}
			//System.out.println();
		}
		for(int i=0;i<str.length;i=i+4) {
			int x1=Integer.parseInt(str[i]);
			int y1=Integer.parseInt(str[i+1]);
			int x2=Integer.parseInt(str[i+2]);
			int y2=Integer.parseInt(str[i+3]);
			//只有当输入的两个网格对应的行坐标或者列坐标对应时才能够连通
			if(!checkLianTong(x1,y1,x2,y2)){
				System.out.println("Maze format error.");
				System.exit(0);
			}
			if(x1==x2||y1==y2) {
				//定义行列中较大的那个坐标
				int rmax=0,rmin=0,cmax=0,cmin=0;
				rmax=x1>x2?x1:x2;
				rmin=x1>x2?x2:x1;
				cmax=y1>y2?y1:y2;
				cmin=y1>y2?y2:y1;
				if(x1==x2) {
					for(int j=cmin*2+1;j<=cmax*2+1;j++) {
						mg[x1*2+1][j]=1;
					}
				}
				if(y1==y2) {
					for(int j=rmin*2+1;j<=rmax*2+1;j++) {
						mg[j][y1*2+1]=1;
					}
				}
			}
		}
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
//				System.out.print(mg[i][j]+" ");
				if(mg[i][j]==1)
					System.out.print("[R] ");
				if(mg[i][j]==0)
					System.out.print("[w] ");
			}
			System.out.println();
		}
	}
	public static boolean checkLianTong(int x1,int y1,int x2,int y2) {
		if(x1!=x2||y1!=y2) {
		}
		return false;
	}
}
