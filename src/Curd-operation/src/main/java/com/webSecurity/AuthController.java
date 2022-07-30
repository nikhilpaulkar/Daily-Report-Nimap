package com.webSecurity;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import com.entity.User;
import com.exception.ResourceNotFoundException;
import com.service.UserService;
public class AuthController 
{
	@PostMapping("/login")
	public ResponseEntity<?> createAuthenticationToken(@Validated @RequestBody User user ) throws Exception, ResourceNotFoundException 
	{

		try 
		{

			User user = UserService.findByEmail(authenticationRequest.getEmail());

			if (!UserService.comparePassword(authenticationRequest.getPassword(), user.getPassword())) {

				return new ResponseEntity<>(new Error("Invalid Credential", "invalidCreds"), HttpStatus.UNAUTHORIZED);
			}
			
			System.out.println("DATa"+user.getEmail());
			final String token = JwtTokenUtil.generateToken(user);
			 
			List<UserService> permissions = UserService.getUserPermission(user.getId());
			Logger logger = new Logger();
			logger.setToken(token);
			Calendar calender = Calendar.getInstance();
			calender.add(Calendar.HOUR_OF_DAY, 5);
			logger.setExpireAt(calender.getTime());
			loggerService.createLogger(logger, user);
			return new ResponseEntity<>(new SuccessResponse("Success", "success", new JwtAuthResponse(token, permissions,user.getEmail(),user.getPassword(),user.getId())), HttpStatus.OK);
			
		} catch (ResourceNotFoundException e) 
		{

			return new ResponseEntity<>(new (e.getMessage(), "userNotFound"), HttpStatus.NOT_FOUND);

		}

	}
	
	@GetMapping("/logout")
	public ResponseEntity<?> logoutUser(@RequestHeader("Authorization") String token, HttpServletRequest request) throws Exception 
	{

		UserService.logoutUser(token, ((User) request.getAttribute("userData")).getId(), ((User) request.getAttribute("userData")).getEmail());
		return new ResponseEntity<>(new ErrorRespons("Logout Successfully", "logoutSuccess"), HttpStatus.OK);

	}

	@PostMapping("/forgotpassword")
	public ResponseEntity<?> forgotPass(@Validated @RequestBody ForgotPassword forgotPassBody, HttpServletRequest request) throws Exception {

		try 
		{

			User userEntity = UserService.findByEmail(forgotPassBody.getEmail());
		    Calendar calender = Calendar.getInstance();
			calender.add(Calendar.MINUTE, 5);    
			forgotPassBody.createForgotPasswordRequest(userEntity.getId(), token, calender.getTime());
			email.sendSimpleMessage(userEntity.getEmail(), "Test", url);
			return new ResponseEntity<>(new ("Password reset link sent on Registerd Email", "passwordRestLinkMail", null), HttpStatus.OK);

		} catch (ResourceNotFoundException e) 
		{

			throw new ResourceNotFoundException("Enter valid Mail Id");
		}

	}

}
}
