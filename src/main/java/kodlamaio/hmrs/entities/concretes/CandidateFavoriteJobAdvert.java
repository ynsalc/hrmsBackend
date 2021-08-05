package kodlamaio.hmrs.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="candidate_favorite_jobadverts")
public class CandidateFavoriteJobAdvert 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@JoinColumn(name="candidate_id")
	@ManyToOne
	private Candidate candidate;
	
	@JoinColumn(name="job_advert_id")
	@ManyToOne
	private JobAdvertisement jobAdvertisement;
	
	public CandidateFavoriteJobAdvert() {}

	public CandidateFavoriteJobAdvert(int id, int candidateId, int jobAdvertId) {
		super();
		this.id = id;
		this.candidate = new Candidate();
		this.candidate.setId(candidateId);
		this.jobAdvertisement = new JobAdvertisement();
		this.jobAdvertisement.setId(jobAdvertId);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public JobAdvertisement getJobAdvertisement() {
		return jobAdvertisement;
	}

	public void setJobAdvertisement(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisement = jobAdvertisement;
	}
}
