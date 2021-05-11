package net.codejava.controller;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import net.codejava.model.Member;
import net.codejava.model.ProfileRrfLinker;
import net.codejava.model.Rrf;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.codejava.DAO.MemberDao;
import net.codejava.DAO.ProfileRrfLinkerDao;
import net.codejava.DAO.RrfDao;

import net.codejava.DAO.BuyerRepository;
import net.codejava.DAO.CheckoutRepository;
import net.codejava.DAO.ClientDao;
import net.codejava.DAO.EmployeeDao;
import net.codejava.DAO.ExamRepository;
import net.codejava.DAO.ScheduleRepository;
import net.codejava.DAO.SkillsDao;
import net.codejava.DAO.UpdateExam;
import net.codejava.DAO.UserRepository;
import net.codejava.DAO.enabledisable;
import net.codejava.DAO.listexamRepository;
import net.codejava.model.Buyer;
import net.codejava.model.Checkout;
import net.codejava.model.Client;
import net.codejava.model.Employee;
import net.codejava.model.Exam;
import net.codejava.model.Shedule;
import net.codejava.model.User;
import net.codejava.model.listofexam;
import net.codejava.model.skills;
import net.codejava.services.FileService;
import net.codejava.services.Updateservice;

@RestController
public class AppController {
	
	@Autowired
	MemberDao md;
	@Autowired
	ProfileRrfLinkerDao prd;
	
	@Autowired 
	EmployeeDao ed;
	
	@Autowired
	ClientDao cd;
	
	@Autowired
	private BuyerRepository BuyerRepo;
	@Autowired
	private FileService fileService;
	
	@Autowired
	RrfDao rd;

	@Autowired
	SkillsDao skd;
	private int rrfsno;

	List<String> suggestions1= new ArrayList<String>();
	@GetMapping("")
	public ModelAndView viewHomePage() {
		return new ModelAndView("index1");
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
		private RrfDao UpdateRrf;

		
		
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
			
			return new ModelAndView( "login1");
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
			
			String s1=req.getParameter("skills");
			r.setSkills(s1);
			rd.save(r);
			
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
			List<Client> listexam = cd.findAll();
			model.addAttribute("listexam", listexam);
			
			return new ModelAndView("listofexam");	
			}
		@GetMapping("/addmanager")
		public ModelAndView addmanager(Model model) {
		return new ModelAndView("addmanager");	
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
		@PostMapping("/newreg")
		public ModelAndView examRegister1(HttpServletRequest req) {
			int id=Integer.parseInt(req.getParameter("examcode"));
			String email=req.getParameter("duration");
			String name=req.getParameter("examname");
			Client c= new Client();
			c.setClientName(name);
			c.setEmail(email);
			c.setClientid(id);
			cd.save(c);
			return new ModelAndView("Success");
		}

		@GetMapping("/Addlistexam")
		public ModelAndView view15(Model model) {
		List<skills> s=skd.findAll();
			model.addAttribute("yes",s);
		model.addAttribute("new","nde");
			return new ModelAndView("employee");	
			
			}
		
		
		@GetMapping("/client")
		public ModelAndView client() {
		
			
			return new ModelAndView("client");	
			
			}
		 @PostMapping("/uploadFile")
		    public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {

		        fileService.uploadFile(file);

		        redirectAttributes.addFlashAttribute("message",
		            "You successfully uploaded " + file.getOriginalFilename() + "!");

		        return "redirect:/";
		    }
		
		
		
		
		
		
		
		/*to view the skills*/
		
		@GetMapping("/requirement")
		public ModelAndView requirements(Model model) {
		List <Rrf> rf=rd.findAll();
		model.addAttribute("rf",rf);
			return new ModelAndView("viewtest");	
			
			}
	/*TO link the profiles with rrf  *********************************************/
		
		
		@GetMapping("/linking/{sno}")
		public ModelAndView linking(@PathVariable(name = "sno") int sno, Model model) {
			
				
			
				rrfsno=sno;
			System.out.print(rrfsno);
			List<Employee>e=ed.findAll();
			model.addAttribute("employee",e);
			return new ModelAndView("linkviewprofile");	
			
			}
		
		/* *************************************************** */
		@GetMapping("/linked/{sno}")
		public ModelAndView linked(@PathVariable(name = "sno") int sno, Model model) {
	
	ProfileRrfLinker prl=new ProfileRrfLinker();
	prl.setPrno(sno);
	System.out.print(rrfsno);
	prl.setRrfno(rrfsno);
	prd.save(prl);
			return new ModelAndView("linkviewprofile");	
			
			}
	/* *********************************** */	
		
		@GetMapping("/employeeprocess")
		public ModelAndView view155(HttpServletRequest req,Model model) {
			String name= req.getParameter("empname");
			int exp= Integer.parseInt(req.getParameter("exp"));
			Employee e=new Employee();
			
			e.setName(name);
			e.setExperience(exp);
			
			
		String l=req.getParameter("added");
		e.setSkills(l);
		ed.save(e);
			
			
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
	     
		 @RequestMapping(value = "/save")
	     public ModelAndView saveProduct(HttpServletRequest req) {
			 int id=Integer.parseInt(req.getParameter("examcode"));
			 String email=req.getParameter("duration");
			 String name=req.getParameter("examname");
			 Client c=new Client();
			 c.setClientid(id);
			 c.setClientName(name);
			 c.setEmail(email);
			 cd.save(c);
			 
	          
	         return new ModelAndView("redirect:/listofexam");
	     }

		 @GetMapping("/Updatedetails/{email}")
			public ModelAndView view18(@PathVariable(name = "email") String email, Model model) {
			Client c=new Client();
			c=cd.findByEmail(email);
			
					model.addAttribute("c",c);
				return new ModelAndView("Updatedetails");	
				}
		 
		 
		 
		 @RequestMapping(value = "/save2", method = RequestMethod.POST)
	     public ModelAndView saveProduct6(@ModelAttribute("product") Rrf lia,Model model) {
			 UpdateRrf.save(lia);
				List <Rrf> rf=rd.findAll();
				model.addAttribute("rf",rf);
	          
	         return new ModelAndView("viewtest");
	     }

		 @GetMapping("/updaterrf/{sno}")
			public ModelAndView view96(@PathVariable(name = "sno") int sno, Model model) {
			Rrf emp=new Rrf();
			System.out.print(sno);
			 emp=rd.findById(sno);
			 model.addAttribute("emp",emp);
				return new ModelAndView("updaterrf");	
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
	 
		 
		 
		 @GetMapping("/viewEmployee")
			public ModelAndView ViewSchedule1(Model model) {
				List<Employee> emp = ed.findAll();
				model.addAttribute("emp", emp);
				
				return new ModelAndView("ViewEmployee");	
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
				
				if(email.equals("ishanrawat71@yahoo.com") && pass.equals("1234567")) {
					return new ModelAndView("java");
				}
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
			String firstThreeCharacters;
			
			@RequestMapping(value="/skillnameautocomplete")
			@ResponseBody
			public List<String> skillnameautocomplete(@RequestParam(value="term", required = false, defaultValue="") String term){
				List<String> suggestions= new ArrayList<String>();
				
				List<skills>sk=skd.findAll();
			
				int count=0;
			
				String newstring="";
				//System.out.print(term);

				for(skills s : sk) {
					
					if(s.getSkill().contains(term)) {
					
						
					suggestions.add(s.getSkill());
					}
							
					
				}
				
				return suggestions;
				
			}
			
		
			
		
}
