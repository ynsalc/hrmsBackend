package kodlamaio.hmrs.entities.dtos;

public class CvLanguageDto 
{
	private int resumeId;
	private String languageName;
	private int level;
	
	public CvLanguageDto() {}
	
	public CvLanguageDto(int resumeId, String languageName, int level) 
	{
		super();
		this.resumeId = resumeId;
		this.languageName = languageName;
		this.level = level;
	}
	public int getResumeId() {
		return resumeId;
	}
	public void setResumeId(int resumeId) {
		this.resumeId = resumeId;
	}
	public String getLanguageName() {
		return languageName;
	}
	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
}
