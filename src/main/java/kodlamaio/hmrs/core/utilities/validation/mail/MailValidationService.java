package kodlamaio.hmrs.core.utilities.validation.mail;

public interface MailValidationService 
{
	boolean mailSend(String email, String code);
	String codeGenerator();
}
