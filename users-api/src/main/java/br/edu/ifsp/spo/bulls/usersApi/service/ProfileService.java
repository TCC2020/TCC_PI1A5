package br.edu.ifsp.spo.bulls.usersApi.service;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import br.edu.ifsp.spo.bulls.usersApi.bean.ProfileBeanUtil;
import br.edu.ifsp.spo.bulls.usersApi.bean.UserBeanUtil;
import br.edu.ifsp.spo.bulls.usersApi.domain.Profile;
import br.edu.ifsp.spo.bulls.usersApi.domain.User;
import br.edu.ifsp.spo.bulls.usersApi.dto.ProfileTO;
import br.edu.ifsp.spo.bulls.usersApi.dto.UserTO;
import br.edu.ifsp.spo.bulls.usersApi.exception.ResourceNotFoundException;
import br.edu.ifsp.spo.bulls.usersApi.repository.ProfileRepository;
import br.edu.ifsp.spo.bulls.usersApi.service.impl.EmailServiceImpl;

@Service
public class ProfileService {
	
	@Autowired
	private ProfileRepository profileRep;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	EmailServiceImpl email;
	
	@Autowired
	private ProfileBeanUtil beanUtil;
	
	@Autowired
	private UserBeanUtil userBeanUtil;
	
	
	public Profile save(Profile entity) throws Exception {
		
		return profileRep.save(entity);
	}
	
	public ProfileTO getByUser(String username) {
		
		UserTO user = userService.getByUserName(username, null);
		Profile profile =  profileRep.findByUser(userBeanUtil.toUser(user));
		
		return beanUtil.toProfileTO(profile);
	}

	public Profile getByUsername(String username) {
		return profileRep.findByUser(userService.getByUsername(username));
	}

	public ProfileTO getByToken(String token) {
		User user = userService.getByToken(token);
		Profile profile;

		if(user != null) {
			profile =  profileRep.findByUser(user);
			return beanUtil.toProfileTO(profile);
		}
		return null;
	}

	public ProfileTO getById(int id) {
		
		Profile profile = profileRep.findById(id).orElseThrow( () -> new ResourceNotFoundException("Profile not found"));
		
		return beanUtil.toProfileTO(profile); 
	}

	public Profile getDomainById(int id) {

		Profile profile = profileRep.findById(id).orElseThrow( () -> new ResourceNotFoundException("Profile not found"));

		return profile;
	}

	public void delete(int  id) {
		
		profileRep.findById(id).orElseThrow( () -> new ResourceNotFoundException("Profile not found"));
		profileRep.deleteById(id);
	}
	
	public void deleteByUser(User  user) {
		
		Profile profile = profileRep.findByUser(user);
		profileRep.deleteById(profile.getId());
	}

	public ProfileTO update(ProfileTO entity) throws Exception {
		
		Profile retorno = profileRep.findById(entity.getId()).map( profile -> {
			profile.setBirthDate(entity.getBirthDate());
			profile.setCity(entity.getCity());
			profile.setCountry(entity.getCountry());
			profile.setName(entity.getName());
			profile.setLastName(entity.getLastName());
			profile.setState(entity.getState());
			return profileRep.save(profile);
		}).orElseThrow( () -> new ResourceNotFoundException("Profile not found"));

		return beanUtil.toProfileTO(retorno);
	}

	public HashSet<ProfileTO> getAll() {

		HashSet<Profile> profile =  profileRep.findAll();
		return beanUtil.toProfileTO(profile);
	}

	public Profile getDomainByToken(String token) {
		User user = userService.getByToken(token);
		Profile profile;

		if(user != null) {
			return  profileRep.findByUser(user);
		}
		return null;
	}

	public HashSet<Profile> getAllDomainById(Iterable<Integer> ids) {
		return profileRep.findAllById(ids);
	}

	public HttpStatus updateProfileImage(String url, String token) {
		Profile profile = getDomainByToken(token);
		profile.setProfileImage(url);
		profileRep.save(profile);
		return HttpStatus.CREATED;
	}
}
