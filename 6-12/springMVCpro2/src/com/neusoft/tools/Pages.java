package com.neusoft.tools;

public class Pages {
	//NΪÿҳ��ʾ10����¼
	public static int N=10;
	//��ҳҳ���еĸ���
	public static int p_N=9;
	//��ǰҳ��
	private int page=1;
	//���м�¼��
	private int count=0;
	//���е���ҳ��
	private int maxPage=0;
	//��ҳҳ�� ��ʼֵ
	private int startPage=1;
	//��ҳҳ�� ����ֵ
	private int endPage=p_N;
	

	public int getPage() {
		return page;
	}


	public void setPage(int page) {
		this.page = page;
		if(page<1){
			this.page=1;
		}
		if(page>this.maxPage){
			this.page=this.maxPage;
		}
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}

	public static int getN() {
		return N;
	}


	public static void setN(int n) {
		N = n;
	}


	public int getMaxPage() {
		return maxPage;
	}


	public void setMaxPage() {
		
		if(this.count%this.N==0){
			this.maxPage = this.count/this.N;
		}else{
			this.maxPage = this.count/this.N+1;
		}
	}


	public static int getP_N() {
		return p_N;
	}


	public static void setP_N(int p_N) {
		Pages.p_N = p_N;
	}


	public int getStartPage() {
		return startPage;
	}


	public void setStart_EndPage() {
		
		if(this.maxPage<this.p_N){
			this.startPage=1;
			this.endPage=this.maxPage;
		}else{
			if(page <= this.p_N/2+1){
				this.startPage=1;
				this.endPage=this.p_N;
			}else if(page < this.maxPage-this.p_N/2){
				this.startPage=page-this.p_N/2;
				this.endPage=page+this.p_N/2;
			}else{
				this.startPage=this.maxPage-this.p_N+1;
				this.endPage=this.maxPage;
			}
		}
	}


	public int getEndPage() {
		return endPage;
	}

	/*
	 * ���ṩ�޲ι���
	 * �����ṩ����
	 * page����ǰҳ��
	 * count�����м�¼��
	 */
	public Pages(int page,int count){
	//	this.page=page;
		this.count=count;
		this.setMaxPage();
		this.setPage(page);
		
		this.setStart_EndPage();
		this.display();
	}
	public void display(){
		System.out.println("....display......");
		System.out.println("page="+this.getPage());
		System.out.println("count="+this.getCount());
		System.out.println("MaxPage="+this.getMaxPage());
		System.out.println("StartPage="+this.getStartPage());
		System.out.println("endPage="+this.getEndPage());
	}
}
