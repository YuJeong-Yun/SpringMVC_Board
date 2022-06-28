package com.itwillbs.domain;

public class PageMaker {
	// 페이징 처리에 필요한 모든 정보를 저장하는 객체

	// 상단부 페이징 처리
	private int page; // 페이지 시작번호
	private int perPageNum; // 페이지 크기

	// 하단부 페이징 처리
	private int totalCount; // 총 게시글 수
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;

	private int displayPageNum = 10; // 페이지 블럭의 수

	
	public PageMaker() {
		this.page = 1;
		this.perPageNum = 10;
	}

	
	
	public void setPage(int page) {
		if (page <= 0) {
			this.page = 1;
			return;
		}
		this.page = page;
	}

	public void setPerPageNum(int perPageNum) {
		if (perPageNum <= 0 || perPageNum > 100) {
			this.perPageNum = 10;
			return;
		}
		this.perPageNum = perPageNum;
	}

	// mapper에서 사용될 메서드
	public int getPageStart() {
		return (this.page - 1) * perPageNum;
	}

	public int getPage() {
		return page;
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;

		calData();
	}

	public void calData() {
		endPage = (int) (Math.ceil(this.page / (double) displayPageNum) * displayPageNum);
		int tmpEndPage = (int) (Math.ceil(totalCount / (double) this.perPageNum));
		if (endPage > tmpEndPage) {
			endPage = tmpEndPage;
		}

		startPage = (endPage - displayPageNum) + 1;

		prev = startPage == 1 ? false : true;

		next = endPage * this.perPageNum >= totalCount ? false : true;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	public int getTotalCount() {
		return totalCount;
	}

	@Override
	public String toString() {
		return "PageMaker [page=" + page + ", perPageNum=" + perPageNum + ", totalCount=" + totalCount + ", startPage="
				+ startPage + ", endPage=" + endPage + ", prev=" + prev + ", next=" + next + ", displayPageNum="
				+ displayPageNum + "]";
	}

}
