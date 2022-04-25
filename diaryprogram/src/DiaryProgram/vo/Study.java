package DiaryProgram.vo;

import java.util.Calendar;

public class Study extends Plan{
//========== 필드 ==========
	private int targetPage;     // 목표   페이지 수
	private int achievedPage;   // 달성한 페이지 수
	
//========= get and set ==========	
	public int getTargetPage() {
		return targetPage;
	}
	public void setTargetPage(int targetPage) {
		this.targetPage = targetPage;
	}
	public int getAchievedPage() {
		return achievedPage;
	}
	public void setAchievedPage(int achievedPage) {
		this.achievedPage += achievedPage;
	}
	
//=========== 생성자 ============
	
	public Study() {}
	
	public Study(int targetPage) {
		this.targetPage = targetPage;
	}
	
	public Study(int targetPage, int achievedPage) {
		this.targetPage = targetPage;
		this.achievedPage = achievedPage;
	}
	
	public Study(String planName,long targetTime,int targetPage) {
		super(planName,targetTime);
		this.targetPage=targetPage;
	}
	
	public Study(int planCode,String planName,long targetTime,long achievedTime,String memberId,Calendar planDate,boolean isAchieved,int targetPage,int achievedPage) {
		super(planCode, planName, targetTime, achievedTime,memberId,planDate,isAchieved);
		this.targetPage=targetPage;
		this.achievedPage=achievedPage;
	}
	
	//=========== equals ============
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Study other = (Study) obj;
		if (targetPage != other.targetPage)
			return false;
		return true;
	}
	
	//========== toString ============
	@Override
	public String toString() {
		String str=String.format("계획명:: %s , 목표시간:: %d%s , 달성시간:: %d%s , 목표페이지수:: %d , 달성페이지수:: %d  %s",super.getPlanName(),
				(super.getTargetTime()/60000>=60?super.getTargetTime()/3600000:super.getTargetTime()/60000),(super.getTargetTime()/60000>=60?"시간":"분"),
				(super.getAchievedTime()/60000>=60?super.getAchievedTime()/3600000:super.getAchievedTime()/60000),(super.getAchievedTime()/60000>=60?"시간":"분"),
				targetPage,achievedPage,(super.isAchieved()?"참 잘했어요!":"분발하세요."));
		return str;
	}	
	
	public String rankString(int i) {
		String str=String.format("%d등  ID :: %s , 달성페이지:: %d",i+1,super.getMemberId(),achievedPage);
		return str;
	}
	
	//========== Comparable ============
	@Override
	public int compareTo(Plan o) {
		return -(achievedPage-((Study)o).achievedPage);
	}	

	
}
