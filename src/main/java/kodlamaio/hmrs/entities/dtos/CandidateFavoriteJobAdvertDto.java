package kodlamaio.hmrs.entities.dtos;

public class CandidateFavoriteJobAdvertDto 
{
	private int id;
	private int candidateId;
	private int jobAdvertId;
	
	public CandidateFavoriteJobAdvertDto() {}
	
	public CandidateFavoriteJobAdvertDto(int id, int candidateId, int jobAdvertId) {
		super();
		this.id = id;
		this.candidateId = candidateId;
		this.jobAdvertId = jobAdvertId;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCandidateId() {
		return candidateId;
	}
	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}
	public int getJobAdvertId() {
		return jobAdvertId;
	}
	public void setJobAdvertId(int jobAdvertId) {
		this.jobAdvertId = jobAdvertId;
	}
}
