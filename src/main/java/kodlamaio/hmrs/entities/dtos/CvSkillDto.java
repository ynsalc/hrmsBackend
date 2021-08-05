package kodlamaio.hmrs.entities.dtos;

public class CvSkillDto 
{
	private int resumeId;
	private String skillName;
	
	public CvSkillDto() {}
	
	public CvSkillDto(int resumeId, String skillName) 
	{
		this.resumeId=resumeId;
		this.skillName=skillName;
	}

	public int getResumeId() {
		return resumeId;
	}

	public void setResumeId(int resumeId) {
		this.resumeId = resumeId;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
}
