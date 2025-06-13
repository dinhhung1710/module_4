@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @Autowired
    private UserValidator userValidator;

    @GetMapping("/home")
    public String showHomePage() {
        return "user/home";
    }

    @GetMapping("/signup")
    public String showSignUpPage(Model model) {
        model.addAttribute("user", new User());
        return "user/signup";
    }

    @PostMapping("/signup")
    public String registerUser(@Valid @ModelAttribute User user, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        userValidator.validate(user, bindingResult);

        if (bindingResult.hasErrors()) {
            return "user/signup";
        }

        userService.save(user);
        redirectAttributes.addFlashAttribute("user", user);
        return "redirect:/user/result";
    }

    @GetMapping("/result")
    public String showResultPage(@ModelAttribute("user") User user, Model model) {
        model.addAttribute("user", user);
        return "user/result";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model, @ModelAttribute("user") User user) {
        if (user == null) {
            model.addAttribute("user", new User());
        }
        return "user/login";
    }

    @PostMapping("/login")
    public String doLogin(@ModelAttribute("user") User user,
                          Model model,
                          RedirectAttributes redirectAttributes) {
        User found = userService.findByEmailAndPassword(user.getEmail(), user.getPassword());
        if (found != null) {
            redirectAttributes.addFlashAttribute("user", found);
            return "redirect:/user/info";
        }
        model.addAttribute("error", "Email hoặc mật khẩu không đúng");
        return "user/login";
    }

    @GetMapping("/info")
    public String showInfoPage(@ModelAttribute("user") User user, Model model) {
        if (user == null || user.getEmail() == null) {
            return "redirect:/user/login";
        }
        model.addAttribute("user", user);
        return "user/info";
    }

    @GetMapping("/logout")
    public String logout(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message", "Bạn đã đăng xuất thành công!");
        return "redirect:/user/login";
    }
}
