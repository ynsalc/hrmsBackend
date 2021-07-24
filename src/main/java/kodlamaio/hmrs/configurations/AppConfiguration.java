package kodlamaio.hmrs.configurations;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hmrs.core.utilities.cloudinaryImplements.CloudinaryManager;
import kodlamaio.hmrs.core.utilities.cloudinaryImplements.CloudinaryService;
import kodlamaio.hmrs.core.utilities.validation.mail.MailValidationManager;
import kodlamaio.hmrs.core.utilities.validation.mail.MailValidationService;
import kodlamaio.hmrs.core.utilities.validation.person.PersonValidationManager;
import kodlamaio.hmrs.core.utilities.validation.person.PersonValidationService;

@Configuration
public class AppConfiguration 
{
	@Bean
	public Cloudinary cloudinaryUser() {
		return new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "dfdwbrwrw",
				"api_key", "512637441299687",
				"api_secret", "PJkxGl0whT91ynYKfj4NJMptPUI"
			));
	}

    @Bean
    public CloudinaryService cloudinaryService() {
        return new CloudinaryManager(cloudinaryUser());
    }
	
	@Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper;
    }

    @Bean
    public PersonValidationService validatePersonService(){
        return new PersonValidationManager();
    }

    @Bean
    public MailValidationService mailService(){
        return new MailValidationManager();
    }
}
