package com.jdbc.vo;

public class SelectVo {
	private Integer stuId;
	private String stuName;
	private String stuGender;
	private Integer chinese;
	private Integer foreign;
	private Integer heart;
	private Integer java;
	private Integer physics;

	public Integer getStuId() {
		return stuId;
	}

	public void setStuId(Integer stuId) {
		this.stuId = stuId;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getStuGender() {
		return stuGender;
	}

	public void setStuGender(String stuGender) {
		this.stuGender = stuGender;
	}

	public Integer getChinese() {
		return chinese;
	}

	public void setChinese(Integer chinese) {
		this.chinese = chinese;
	}

	public Integer getForeign() {
		return foreign;
	}

	public void setForeign(Integer foreign) {
		this.foreign = foreign;
	}

	public Integer getHeart() {
		return heart;
	}

	public void setHeart(Integer heart) {
		this.heart = heart;
	}

	public Integer getJava() {
		return java;
	}

	public void setJava(Integer java) {
		this.java = java;
	}

	public Integer getPhysics() {
		return physics;
	}

	public void setPhysics(Integer physics) {
		this.physics = physics;
	}

	@Override
	public String toString() {
		return "SelectVo [stuId=" + stuId + ", stuName=" + stuName + ", stuGender=" + stuGender + ", chinese=" + chinese
				+ ", foreign=" + foreign + ", heart=" + heart + ", java=" + java + ", physics=" + physics + "]" + "\n";
	}

	public SelectVo(Integer stuId, String stuName, String stuGender, Integer chinese, Integer foreign, Integer heart,
			Integer java, Integer physics) {
		super();
		this.stuId = stuId;
		this.stuName = stuName;
		this.stuGender = stuGender;
		this.chinese = chinese;
		this.foreign = foreign;
		this.heart = heart;
		this.java = java;
		this.physics = physics;
	}

	public SelectVo() {
		// TODO Auto-generated constructor stub
	}
}
