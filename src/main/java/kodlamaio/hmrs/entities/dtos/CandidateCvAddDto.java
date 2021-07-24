package kodlamaio.hmrs.entities.dtos;

public class CandidateCvAddDto 
{
	private int candidateId;
	private String githubLink;
	private String linkedinLink;
	private String coverLetter;
	private String createdDate;
	
	public CandidateCvAddDto() {}
	
	public CandidateCvAddDto(int candidateId, String githubLink, String linkedinLink, String coverLetter,
			String createdDate) {
		super();
		this.candidateId = candidateId;
		this.githubLink = githubLink;
		this.linkedinLink = linkedinLink;
		this.coverLetter = coverLetter;
		this.createdDate = createdDate;
	}

	public int getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}

	public String getGithubAddress() {
		return githubLink;
	}

	public void setGithubAddress(String githubLink) {
		this.githubLink = githubLink;
	}

	public String getLinkedinAddress() {
		return linkedinLink;
	}

	public void setLinkedinAddress(String linkedinLink) {
		this.linkedinLink = linkedinLink;
	}

	public String getCoverLetter() {
		return coverLetter;
	}

	public void setCoverLetter(String coverLetter) {
		this.coverLetter = coverLetter;
	}

	public String getCreateDate() {
		return createdDate;
	}

	public void setCreateDate(String createdDate) {
		this.createdDate = createdDate;
	}
}
