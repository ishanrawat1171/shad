package net.codejava.controller;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import net.codejava.model.Member;
import net.codejava.model.Rrf;
import net.codejava.model.RrfSkillLinker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import net.codejava.DAO.MemberDao;
import net.codejava.DAO.RrfDao;
import net.codejava.DAO.RrfSkillLinkerDao;
import net.codejava.DAO.BuyerRepository;
import net.codejava.DAO.CheckoutRepository;
import net.codejava.DAO.EmployeeDao;
import net.codejava.DAO.EmployeeSkillLinkDao;
import net.codejava.DAO.ExamRepository;
import net.codejava.DAO.ScheduleRepository;
import net.codejava.DAO.SkillsDao;
import net.codejava.DAO.UpdateExam;
import net.codejava.DAO.UserRepository;
import net.codejava.DAO.enabledisable;
import net.codejava.DAO.listexamRepository;
import net.codejava.model.Buyer;
import net.codejava.model.Checkout;
import net.codejava.model.Employee;
import net.codejava.model.EmployeeSkillLink;
import net.codejava.model.Exam;
import net.codejava.model.Shedule;
import net.codejava.model.User;
import net.codejava.model.listofexam;
import net.codejava.services.Updateservice;

@RestController
public class AppController {
	
	@Autowired
	MemberDao md;
	
	@Autowired 
	EmployeeDao ed;
	@Autowired 
	SkillsDao sd;
	@Autowired 
	EmployeeSkillLinkDao eld;
	
	@Autowired
	private BuyerRepository BuyerRepo;
	
	@Autowired
	RrfDao rd;
	@Autowired
	RrfSkillLinkerDao rsd;

	
	@GetMapping("")
	public ModelAndView viewHomePage() {
		return new ModelAndView("index");
	}

	@GetMapping("/register")
	public ModelAndView showRegistrationForm(Model model) {
		model.addAttribute("user", new User());
		
		return new ModelAndView("signup_form");
	}
	

	
	private String getSiteURL(HttpServletRequest request) {
		String siteURL = request.getRequestURL().toString();
		return siteURL.replace(request.getServletPath(), "");
	}	
	

	

	
	

	
	
	@GetMapping("/Coinregistration")
	public ModelAndView CoinRegistration(Model model) {
		
		
		return new ModelAndView("CoinReg");
	}

	
	
		
		@PostMapping("/buyer1")
		public ModelAndView BuyerRegister(Buyer Buyer) {
			
			
			
			BuyerRepo.save(Buyer);
			
			return new ModelAndView("successBuy");
		}
		@GetMapping("/remote")
		public ModelAndView rem(Model model)
		{
			return new ModelAndView("neww");
		}

		@Autowired
		private UserRepository userRepo;

		@Autowired
		private CheckoutRepository CheckoutRepo;
		
		@Autowired
		private UpdateExam UpdateRepo;
		
		
		@Autowired
		private enabledisable enabledRepo;
		
		
		@Autowired
		private ExamRepository ExamRepo;
		

		@Autowired
		private listexamRepository liRepo;
		
		
		@Autowired
		private ScheduleRepository 	viRepo;
		
		@Autowired
		private MemberDao 	memRepo;

		
		
		
		@GetMapping("/admin")
		public ModelAndView viewHomePage1() {
			return new ModelAndView ("index1") ;
		}
		@GetMapping("/login")
		public ModelAndView viewHomePage3() {
			return new ModelAndView ("login") ;
		}
		@GetMapping("/login1")
		public ModelAndView viewHomePage2() {
			return new ModelAndView ("login1") ;
		}
		
		@GetMapping("/register1")
		public ModelAndView showRegistrationForm1(Model model) {
			model.addAttribute("user", new User());
			
			return new ModelAndView ("signup_form1");
		}
		
		@PostMapping("/process_register")
		public ModelAndView processRegister(User user) {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	 String encodedPassword = passwordEncoder.encode(user.getPassword());
			user.setPassword(encodedPassword);
			
			userRepo.save(user);
			
			return new ModelAndView( "register_success");
		}
		@PostMapping("/process_register1")
		public ModelAndView processRegister1(Member mem) {
		
			
			memRepo.save(mem);
			
			return new ModelAndView( "register_success");
		}
		
		@GetMapping("/users")
		public ModelAndView view() {
			
			
			return new ModelAndView("Homepage");
		}
		@GetMapping("/Homepage")
		public ModelAndView view4() {
			
			
			return new ModelAndView("Homepage");
		}

		@GetMapping("/user")
		public ModelAndView listUsers(Model model) {
			List<User> listUsers = userRepo.findAll();
			model.addAttribute("listUsers", listUsers);
			
			return new ModelAndView("user");	}
		
		@GetMapping("/rrf")
		public ModelAndView rrf(Model model) {
			
			
			return new ModelAndView("rrf");	}
		@GetMapping("/rrfprocess")
		public ModelAndView rrfprocess(Model model, HttpServletRequest req) {
			
			int exp=Integer.parseInt(req.getParameter("exp"));
			Rrf r=new Rrf();
			r.setExperience(exp);
			rd.save(r);
			String s1=req.getParameter("vehicle1");
			String s2=req.getParameter("vehicle2");
			String s3=req.getParameter("vehicle3");
			if(s1!=null) {
				RrfSkillLinker link= new RrfSkillLinker();
				link.setRrfno(r.getSno());
				link.setSkillsno(1);
				rsd.save(link);
			}
			if(s2!=null) {
				RrfSkillLinker link= new RrfSkillLinker();
				link.setRrfno(r.getSno());
				link.setSkillsno(2);
				rsd.save(link);
			}
			if(s3!=null) {
				RrfSkillLinker link= new RrfSkillLinker();
				link.setRrfno(r.getSno());
				link.setSkillsno(3);
				rsd.save(link);
			}
			return new ModelAndView("rrf");	
			}
		@GetMapping("/Checkout")
		public ModelAndView view1() {
			
			
			return new ModelAndView("Checkout");
		}
		
		
		@PostMapping("/Checkout1")
		public ModelAndView checkoutform(Checkout Checkout) {
		
			CheckoutRepo.save(Checkout);
			return new ModelAndView("Success");
		}
		
		@GetMapping("/java")
		public ModelAndView view2() {
			
			
			return new ModelAndView("java");
		}
		
		@GetMapping("/c++")
		public ModelAndView view3() {
			
			
			return new ModelAndView("c++");
		}
		@GetMapping("/phps")
		public ModelAndView view5() {
			
			
			return new ModelAndView("phps");
		}
		@GetMapping("/springboot")
		public ModelAndView view6() {
			
			
			return new ModelAndView("springboot");
		}

		@GetMapping("/java1")
			public ModelAndView view7() {
				return new ModelAndView("java1");
			}
		@GetMapping("/SQL")
		public ModelAndView view8() {
			
			
			return new ModelAndView("SQL");
		}
		@GetMapping("/springboot1")
		public ModelAndView view9() {
			
			
			return new ModelAndView("springboot1");
		}
		@GetMapping("/BootStrap")
		public ModelAndView view10() {
			
			
			return new ModelAndView("BootStrap");
		}
	
		
		
		
		@GetMapping("/Exam")
		public ModelAndView view11() {
			
			
			return new ModelAndView("exam");
		}
		
		@PostMapping("/Exam1")
		public ModelAndView examform(Exam exam) {
		
			ExamRepo.save(exam);
			return new ModelAndView("Success1");
		}
		
		@GetMapping("/Score")
		public ModelAndView view13() {
			
			
			return new ModelAndView("Score");
		}
		
		
		@GetMapping("/listofexam")
		public ModelAndView listexam(Model model) {
			List<listofexam> listexam = liRepo.findAll();
			model.addAttribute("listexam", listexam);
			
			return new ModelAndView("listofexam");	
			}
		
		@GetMapping("/Viewmanager")
		public ModelAndView listmanager(Model model) {
			List<Member> listmanager = memRepo.findAll();
			model.addAttribute("listmanager", listmanager);
			
			return new ModelAndView("Viewmanager");	
			}
		
		@PostMapping("/exam_register")
		public ModelAndView examRegister(listofexam li) {
			
			liRepo.save(li);
			
			return new ModelAndView("Success");
		}
		

		@GetMapping("/Addlistexam")
		public ModelAndView view15() {
		
			
			return new ModelAndView("employee");	
			
			}
		
		
		/*to view the skills*/
		
		@GetMapping("/requirement")
		public ModelAndView requirements(Model model) {
			List<Integer> ids=eld.getAllid();
			
			List<String> li1 =new ArrayList<String>();
			List<List> megalist=new ArrayList<List>();
			
			Set<Integer> s = new LinkedHashSet<Integer>(ids);  
			System.out.print(s);
			Integer arr[] = new Integer[s.size()];
			s.toArray(arr);
			
			List<String> li=new ArrayList<String>();
			 int n = s.size();
			    List<Integer> aList = new ArrayList<Integer>(n);
			    for (Integer x : s)
			      aList.add(x);
			    System.out.print(aList);
			   
			    
			for(int i=0;i<s.size();i++) {
			
				 List<String> listnew = new ArrayList<String>(n);
		 listnew =eld.retskillno(aList.get(i));
		
		
		 
		for(int j=0;j<listnew.size();j++) {
			List<String> listnew1 = new ArrayList<String>(n);
			;
			if(Integer.parseInt(listnew.get(j))== 1) {
				listnew1.add("cpp");
			}
			else if(Integer.parseInt(listnew.get(j))== 2) {
				listnew1.add("java");
			}
			else {
				listnew1.add("c");
			}
			megalist.add(listnew1);
		}
		System.out.print(megalist);
		
			
			}
			
		
		model.addAttribute("abc",megalist);
		List<Employee> listemployee = ed.findAll();
		model.addAttribute("listemployee", listemployee);
			
			return new ModelAndView("viewtest");	
			
			}
		@GetMapping("/employeeprocess")
		public ModelAndView view155(HttpServletRequest req,Model model) {
			String name= req.getParameter("empname");
			int exp= Integer.parseInt(req.getParameter("exp"));
			Employee e=new Employee();
			
			e.setName(name);
			e.setExperience(exp);
			ed.save(e);
			
		String l=req.getParameter("vehicle1");
		String l1=req.getParameter("vehicle2");
		String l2=req.getParameter("vehicle3");
		
			if(l!=null) {
				EmployeeSkillLink link= new EmployeeSkillLink();
				link.setEmpSno(e.getSno());
				link.setSkillSno(1);
				eld.save(link);
			}
			if(l1!=null) {
				EmployeeSkillLink link= new EmployeeSkillLink();
				link.setEmpSno(e.getSno());
				link.setSkillSno(2);
				eld.save(link);
				
			}
			if(l2!=null) {
				EmployeeSkillLink link= new EmployeeSkillLink();
				link.setEmpSno(e.getSno());
				link.setSkillSno(3);
				eld.save(link);
			}
			
			return new ModelAndView("employee");	
			
			}
		@GetMapping("/javadetail")
		public ModelAndView view16() {
			
			
			return new ModelAndView("javadetail");
		}
		
		 @PutMapping("/edit/{examcode}")
	     public ModelAndView showEditProductPage(@PathVariable(name = "examcode") long examcode) {
	         ModelAndView mav = new ModelAndView("edit_product");
	         listofexam lie = ((Updateservice) UpdateRepo).get(examcode);
	         mav.addObject("listofexam", lie);
	          
	         return mav;
	     }
	     
		 @RequestMapping(value = "/save", method = RequestMethod.POST)
	     public ModelAndView saveProduct(@ModelAttribute("product") listofexam lie) {
			 UpdateRepo.save(lie);
	          
	         return new ModelAndView("redirect:/listofexam");
	     }

		 @GetMapping("/Updatedetails")
			public ModelAndView view18() {
			
				
				return new ModelAndView("Updatedetails");	
				}
		 
		 @GetMapping("/enabledisable/{email}")
			public ModelAndView singlePathVariable(@PathVariable("email") String email, Model model) {
				Member mem=memRepo.findByEmail(email);
				model.addAttribute("mem",mem);
				return new ModelAndView("enabledisable");	
				}
		
		 
		 
		 
		 
		 
		 
		 @GetMapping("/schedule")
		 
			public ModelAndView view20() {
				return new ModelAndView("schedule");
			}
		 
		 @GetMapping("/Viewschedule")
	public ModelAndView viewschedule(Shedule sc) {
			
			viRepo.save(sc);
			
			return new ModelAndView("Success");	
			
			}
	 
		 
		 
		
		 
			@GetMapping("/ViewSchedule")
			public ModelAndView ViewSchedule(Model model) {
				List<Shedule> ViewSchedule = viRepo.findAll();
				model.addAttribute("ViewSchedule", ViewSchedule);
				
				return new ModelAndView("ViewSchedule");	
				}
			@RequestMapping(value="checkuser")
			public ModelAndView checkUser(HttpServletRequest req, Model model) {
				ModelAndView mv=null;
				String email=req.getParameter("lemail");
				String pass=req.getParameter("lpass");
				
				Member m=md.findByEmail(email);
				System.out.println(m);
				
				
				if(m !=null) {
				
					if(pass.equals(m.getPassword())) {
						
						model.addAttribute("value", m.getUserName());
						if(m.getAccess()==1)
						mv=new ModelAndView("neww");
						else
							mv=new ModelAndView("adminaccess");
						
					}
					else {
						model.addAttribute("msg", "Password Wrong");
						mv=new ModelAndView("login1");
					}
				}
				else {
					model.addAttribute("msg", "User Not Found Please Register");
					mv=new ModelAndView("login1");
				}
				return mv;
			}
			
			@GetMapping("/save/{email}")
			public ModelAndView singlePathVariable1(@PathVariable("email") String email, Model model,HttpServletRequest req) {
				ModelAndView mv=null;
				
				String gen=req.getParameter("gender");
				Member m=memRepo.findByEmail(email);
				if(gen.equals("disable")) {
					m.setAccess(0);
					System.out.print("abc");
					
					
				}
				else {
					m.setAccess(1);
				}
				memRepo.save(m);
				mv=new ModelAndView("Success");
			
				return mv;
			}
			
		
}
