package kodlamaio.hmrs.entities.dtos;

public class CvEducationAddDto 
{
	private int resumeId;
	private int schoolId;
	private String department;
	private String startYear;
	private String endYear;
	
	public CvEducationAddDto() {}
	
	public CvEducationAddDto(int resumeId, int schoolId, String department, String startYear, String endYear) {
		super();
		this.resumeId = resumeId;
		this.schoolId = schoolId;
		this.department = department;
		this.startYear = startYear;
		this.endYear = endYear;
	}
	public int getResumeId() {
		return resumeId;
	}
	public void setResumeId(int resumeId) {
		this.resumeId = resumeId;
	}
	public int getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getStartYear() {
		return startYear;
	}
	public void setStartYear(String startYear) {
		this.startYear = startYear;
	}
	public String getEndYear() {
		return endYear;
	}
	public void setEndYear(String endYear) {
		this.endYear = endYear;
	}
}
