package kodlamaio.hmrs.entities.dtos;

public class CvExperienceAddDto 
{
	private int resumeId;
	private String companyName;
	private String position;
	private String startYear;
	private String endYear;
	
	public CvExperienceAddDto() {}
	
	public CvExperienceAddDto(int resumeId, String companyName, String position, String startYear, String endYear) {
		super();
		this.resumeId = resumeId;
		this.companyName = companyName;
		this.position = position;
		this.startYear = startYear;
		this.endYear = endYear;
	}
	public int getResumeId() {
		return resumeId;
	}
	public void setResumeId(int resumeId) {
		this.resumeId = resumeId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
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
