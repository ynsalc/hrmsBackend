package kodlamaio.hmrs.core.utilities.validation.mail;

import java.security.SecureRandom;

public class MailValidationManager implements MailValidationService
{

	@Override
	public boolean mailSend(String email, String code) 
	{
		System.out.println(email + " Mail adresine kod gönderildi. Doğrulama kodu : " + code);
		return true;
	}

	@Override
	public String codeGenerator() 
	{
		int length = 10;
			
		final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

		SecureRandom random = new SecureRandom();
		StringBuilder sb = new StringBuilder();
			
		for (int i = 0; i < length; i++)
		{
			int randomIndex = random.nextInt(chars.length());
			sb.append(chars.charAt(randomIndex));
		}

		return sb.toString();
	}
	
}
