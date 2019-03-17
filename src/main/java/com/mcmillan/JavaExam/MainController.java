package com.mcmillan.JavaExam;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mcmillan.JavaExam.models.Show;
import com.mcmillan.JavaExam.models.User;
import com.mcmillan.JavaExam.services.ReviewService;
import com.mcmillan.JavaExam.services.ShowService;
import com.mcmillan.JavaExam.services.UserService;

@Controller
public class MainController {
	private final UserService userService;
	private final ShowService showService;
	private final ReviewService reviewService;
	
	public MainController(UserService userService, ShowService showService, ReviewService reviewService) {
		this.userService = userService;
		this.showService = showService;
		this.reviewService = reviewService;
	}
	@GetMapping("/")
		public String Welcome() {
	return "Welcome.jsp";
	}
	
	@GetMapping("/ecommerce")
		public String Ecommerce() {
	
	return "Ecommerce.jsp";
	}
	
	@GetMapping("/login")
	public String loginRegistration(Model model) {
		System.out.println("\n\n<<------------Login and Registration Form---------->>\n\n");
		model.addAttribute("user", new User());
		return "LoginRegistration.jsp";
	}
	@PostMapping("/processRegistration")
	public String processRegistration(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		System.out.println("\n\n<<----------Processing User Registration---------->>\n\n");
		
		System.out.println("Name:" + user.getName());
		System.out.println("Email:" + user.getEmail());
		System.out.println("Password:" + user.getPassword());
		
		if(result.hasErrors()) {
			System.out.println("Registration error");
			return "LoginRegistration.jsp";
		}
		else {
			System.out.println("Successfully registered :-)");
			userService.createUser(user);
			session.setAttribute("name", user.getName());
			session.setAttribute("id", user.getId());
			session.setAttribute("user", userService.findById(user.getId()));
			
			System.out.println("id created" + session.getAttribute("id"));
			return "redirect:/dashboard";
		}
	}
	@PostMapping("processLogin")
	public String processLogin(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		System.out.println("\n\n<<--------------Processing User Login------->>\n\n");
		System.out.println("Email: " + user.getEmail());
		System.out.println("Password:" +user.getPassword());
		
		if(result.hasErrors()) {
			System.out.println("Login error");
			return "redirect:/login";
		}
		else if(userService.authenticateUser(user.getEmail(), user.getPassword())) {
			System.out.println("Verifying user");
			
			session.setAttribute("name", userService.findByEmail(user.getEmail()).getName());
			session.setAttribute("id", userService.findByEmail(user.getEmail()).getId());
			
			System.out.println(session.getAttribute("id"));
			System.out.println("Name:" + session.getAttribute("name"));
			return "redirect:/dashboard";
		}
		else {
			return "LoginRegistration.jsp";
		}
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		System.out.println("\n\n<<-----------------Logout User------>>\n\n");
		session.invalidate();
		return "redirect:/login";
	}
//------------------------------------------dashboard----------------------------
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session, Model model) {
		List<Show> shows = showService.findAllShows();
		model.addAttribute("shows", shows);
		User user=userService.findById((Long) session.getAttribute("id"));
		System.out.println("Displaying user: " + user.getName());
//		List<Show> reviews =user.getShow();
//		model.addAttribute("reviews", reviews);
		return "Dashboard.jsp";
	}
	@GetMapping("/newCreate")
	public String newCreate(HttpSession session, Model model) {
		System.out.println("This user is: " + userService.findById((Long) session.getAttribute("id")));
		model.addAttribute("thisUser", userService.findById((Long) session.getAttribute("id")));
		model.addAttribute("user", new User());
		model.addAttribute("show", new Show());
		
		return "Create.jsp";
	}
	@PostMapping("/processCreate")
	public String processCreate(@Valid @ModelAttribute("show") Show show, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			System.out.println("Try again.");
			return "Create.jsp";
//--------important to return then redirect--------------------
		}
		else {
			System.out.println("Creating a new idea");
			System.out.println(show.getTitle());
			System.out.println(show.getNetwork());
			System.out.println(show.getUser());
			
			User user=userService.findById((Long) session.getAttribute("id"));
			show.setUser(user);
			
			showService.createdShow(show);
			return "redirect:/dashboard";
			
//------------------working on below--------------------------------------
		}
	}
//this is the show edit page route--------------------------
	@RequestMapping("/ShowShow/{id}/edit")
	public String showUpdate(@Valid @ModelAttribute("show") Show show, Model model,BindingResult result, HttpSession session, @PathVariable("id")Long id) {
		Show s = showService.findShowById(id);
		Long userId = (Long) session.getAttribute("id");
		
		User user = userService.findById(userId);
		model.addAttribute("user", user);
		
    	model.addAttribute("show", s);
    	return "Edit.jsp";
}
	@RequestMapping("ShowShow/{id}")
	public String showShow(HttpSession session, @PathVariable("id") Long id, Model model) {
			Show show = showService.findShowById(id);
			model.addAttribute("show", show);
			return "Show.jsp";
		}
//edit and update route to the do processing on edit page 
    @PostMapping(value="/shows/{id}/edit")
    public String update(@Valid @ModelAttribute("show") Show show, BindingResult result, @PathVariable("id")Long s, HttpSession session) {
    	if (result.hasErrors()) {
    		return "/Edit.jsp";
    	} else {
    		Long userId = (Long) session.getAttribute("id");
    		User u = userService.findById(userId);
    		show.setUser(u);
    		showService.updateShow(show);
    		return "redirect:/dashboard";
    	}
    }
	@RequestMapping("/deleteShow/{id}")
	public String deleteShow(@PathVariable("id") Long id) {
		showService.delete(id);
		return "redirect:/dashboard";
		}
//	*********************************adding for rating*****************************************
//	@RequestMapping(value="/shows/{id}", method=RequestMethod.POST)
//    public String addReview(@PathVariable("id") long id, @RequestParam(value="number", required=true) Float rating) {
//    	if(rating.length() == 0) {
//    		return "show";
//    	}
//    	else {
//            String email = principal.getRating();
//            User user = userService.findByEmail(email).get(0);
//            Review review = new Review();
//            review.setNumber(number);
//    		this.showService.addReview(review, id, user);
//    		return "redirect:/shows/" + id;	
//    	}
}
