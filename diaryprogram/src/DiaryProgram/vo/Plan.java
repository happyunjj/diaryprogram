package DiaryProgram.vo;

import java.util.Calendar;

public class Plan implements Comparable<Plan>{

//========== 필드 ==========
	private int planCode;         // 계획 코드
	private String planName;      // 계획 이름
	private long targetTime;      // 목표 시간
	private long achievedTime;    // 달성한 시간
	private String memberId;      // 계획 세운 사람의 ID (회원의 기본키)
	private Calendar planDate;        // 해당 계획을 세운 날짜
	private boolean isAchieved;   // 성취 여부

	
//========== getter and setter ============
	public int getPlanCode() {
		return planCode;
	}

	public void setPlanCode(int planCode) {
		this.planCode = planCode;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public long getAchievedTime() {
		return achievedTime;
	}

	public void setAchievedTime(long achievedTime) {
		this.achievedTime += achievedTime;
	}

	public long getTargetTime() {
		return targetTime;
	}

	public void setTargetTime(long targetTime) {
		this.targetTime = targetTime;
	}
	

	public boolean isAchieved() {
		return isAchieved;
	}

	public void setAchieved(boolean isAchieved) {
		this.isAchieved = isAchieved;
	}
	
	public Calendar getPlanDate() {
		return planDate;
	}

	public void setPlanDate(Calendar planDate) {
		this.planDate = planDate;
	}
	
	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	//========== 생성자 ==========
	public Plan() {}
	
	public Plan(boolean isAchieved) {
		this.isAchieved = isAchieved;
	}
	
	public Plan(String planName,long targetTime) {
		this.planName=planName;
		this.targetTime=targetTime;
	}
	
	public Plan(int planCode, String planName, long targetTime, long achievedTime) {
		this.planCode = planCode;
		this.planName = planName;
		this.targetTime = targetTime;
		this.achievedTime = achievedTime;
	}
	
	public Plan(int planCode, String planName, long targetTime, long achievedTime,String memberId,Calendar planDate, boolean isAchieved) {
		this.planCode = planCode;
		this.planName = planName;
		this.targetTime = targetTime;
		this.achievedTime = achievedTime;
		this.memberId=memberId;
		this.planDate=planDate;
		this.isAchieved = isAchieved;
	}
	
	//========== equals ============
	
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Plan other = (Plan) obj;
			if (memberId == null) {
				if (other.memberId != null)
					return false;
			} else if (!memberId.equals(other.memberId))
				return false;
			if (planDate == null) {
				if (other.planDate != null)
					return false;
			} else if (!(planDate.get(Calendar.YEAR)==other.planDate.get(Calendar.YEAR)&&
					planDate.get(Calendar.MONTH)==other.planDate.get(Calendar.MONTH)&&
					planDate.get(Calendar.DATE)==other.planDate.get(Calendar.DATE)))
				return false;
			if (planName == null) {
				if (other.planName != null)
					return false;
			} else if (!planName.equals(other.planName))
				return false;
			if (targetTime != other.targetTime)
				return false;
			return true;
		}

		//========== toString ============
		@Override
		public String toString() {
			String str=String.format("계획명:: %s , 목표시간:: %d%s , 달성시간:: %d%s  %s",planName,
					(targetTime/60000>=60?targetTime/3600000:targetTime/60000),(targetTime/60000>=60?"시간":"분"),
					(achievedTime/60000>=60?achievedTime/3600000:achievedTime/60000),(achievedTime/60000>=60?"시간":"분"),
					(isAchieved?"♥ 완료 ♥":"힘내세요T_T"));
			return str;
		}
		
		public String rankString(int i) {
			String str=String.format("%d등  ID :: %s , 달성시간:: %d%s",i+1,memberId,
					(achievedTime/60000>=60?achievedTime/3600000:achievedTime/60000),(achievedTime/60000>=60?"시간":"분"));
			return str;
		}

		//========== compareTo ============
		@Override
		public int compareTo(Plan o) {
			// TODO Auto-generated method stub
			return -(Double.compare(achievedTime, o.achievedTime));
		}
		



	
}
