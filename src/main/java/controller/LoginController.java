package controller;

import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import dao.CommonDAO;
import dao.ISSCardDAO;
import dao.IssEbankDAO;
import dao.LoginDAO;
import entity.DisputesUser;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinService;
import com.vaadin.server.ClientConnector.DetachEvent;
import com.vaadin.server.ClientConnector.DetachListener;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;

import config.SecurityUtils;

@Controller
public class LoginController {

	private HttpSession _session;

	@Autowired
	private LoginDAO loginDAO;
	@Autowired
	private ISSCardDAO iSSCardDAO;
	@Autowired
	private IssEbankDAO IssEbankDAO;
	@Autowired
	private CommonDAO commonDAO;
	@Autowired
	private AuthenticationManager authentionManager;

	private static final Logger logger = Logger.getLogger(LoginController.class);

	@RequestMapping(value = "detailuser", method = RequestMethod.GET)
	public String detailuser(Model m, @RequestParam(value = "id", required = false) String id,
			HttpServletRequest request) throws SQLException {
		_session = request.getSession();
		// Check login?
		String user = String.valueOf(_session.getAttribute("fullName"));
		if (user.equals("null")) {
			return "login";
		}
		_session.setAttribute("detailUser", loginDAO.get_DetailUser_TypeList(id));
		return "detailuser";
	}

	@RequestMapping(value = "usermanage", method = RequestMethod.GET)
	public String usermanage(Model m, HttpServletRequest request) {
		_session = request.getSession();
		// Check login?
		String user = String.valueOf(_session.getAttribute("fullName"));
		if (user.equals("null")) {
			return "login";
		}
		_session.setAttribute("listUser", loginDAO.listAllUser());
		return "usermanage";
	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String page_login(Model m, HttpServletRequest request) {
		_session = request.getSession();
		// Check login?
		String user = String.valueOf(_session.getAttribute("fullName"));
		if (!user.equals("null")) {
			return "index";
		}
		return "login";
	}

	// @RequestMapping(value = "changepassword", method = RequestMethod.GET)
	// public String page_changePassword(Model m, HttpServletRequest request) {
	// _session = request.getSession();
	// return "changepassword";
	// }

	// EnDeCryption objEnDe = new EnDeCryption();

	// XU LY KIEM TRA DANG NHAP
	@RequestMapping(value = "/checklogin", method = RequestMethod.POST)
	public String checkLogin(HttpServletRequest request, Model m) throws ParseException, SQLException {
		_session = request.getSession();
		Common comon = new Common();
		DisputesUser user = new DisputesUser();

		// LAY THONG TIN TU LOGIN.JSP
		String frm_username = request.getParameter("username").toUpperCase();
		String frm_password_input = request.getParameter("password");

		// KIEM TRA USERNAME CO TON TAI HAY KHONG?
		user = loginDAO.findUserLogin(frm_username);
		String username = user.getUsername();

		if (username == null) {
			// DANG NHAP THAT BAI
			_session.setAttribute("error", "ERROR: INVALID USERNAME OR PASSWORD");
			logger.warn(String.valueOf("USER: " + frm_username + " LOGIN FAILED => USER NOT FOUND"));
			return "redirect:login.html";
		}

		// KIEM TRA USER AD?
		boolean isLogin = false;
		try {
			Authentication token = authentionManager
					.authenticate(new UsernamePasswordAuthenticationToken(frm_username, frm_password_input));
			isLogin = token != null ? true : false;

			// DANG NHAP THANH CONG
			if (isLogin == true) {
				String userId = user.getUsername();
				_session.setAttribute("userId", userId.toUpperCase());
				_session.setAttribute("fullName", user.getFullname());
				_session.setAttribute("userRole", user.getUserRole());

				// CAP NHAT NHUNG THONG TIN CAN THIET				
				iSSCardDAO.capNhatThoiGianXuLyConLai_TheNoiDia(userId);
				iSSCardDAO.capNhatThoiGianXuLyConLai_TheQuocTe(userId);
				

				// Cap nhat thoi gian login
				loginDAO.updateTimeLastLogin(comon.get_SystemTime(), userId);

				logger.warn(String.valueOf("USER: " + frm_username + " LOGIN SUCCESSFULL"));
				return "redirect:index.html";
			}
		} catch (Exception e) {
			// DANG NHAP THAT BAI
			_session.setAttribute("error", "ERROR: INVALID USERNAME OR PASSWORD");
			logger.warn(String.valueOf("USER: " + frm_username + " LOGIN FALED, WITH TRY-CATCH: " + e.toString()));
			return "redirect:login.html";
		}
		return "redirect:login.html";
	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout() {
		_session.removeAttribute("error");
		_session.removeAttribute("userId");
		_session.removeAttribute("fullName");
		_session.removeAttribute("username");
		return "redirect:login.html";
	}
}