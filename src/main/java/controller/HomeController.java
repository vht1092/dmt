package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.*;

@Controller
public class HomeController {

	private HttpSession _session;
	@Autowired
	private ISSCardDAO iSSCardDAO;

	@Autowired
	private IssEbankDAO iSSEbankDAO;

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String TrangChu(Model m, HttpServletRequest request) {
		_session = request.getSession();
		// Check login?
		String user = (String) _session.getAttribute("userId");
		if (user == null || user.equals("")) {
			return "redirect:login.html";
		}
		iSSEbankDAO.update_CustName_PhoneNumber(); // module Ebank
		iSSCardDAO.capNhatSoTheNull();
		return "index";
	}

	@RequestMapping(value = "eb_create_ychtth", method = RequestMethod.GET)
	public String eb_create_ychtth(Model m, HttpServletRequest request) {
		_session = request.getSession();
		// Check login?
		String user = (String) _session.getAttribute("userId");
		if (user == null || user.equals("")) {
			return "redirect:login.html";
		}
		return "eb_create_ychtth";
	}

	@RequestMapping(value = "new_iss_international_card", method = RequestMethod.GET)
	public String create_issTheQuocTe(Model m, HttpServletRequest request) {
		_session = request.getSession();
		// Check login?
		String user = (String) _session.getAttribute("userId");
		if (user == null || user.equals("")) {
			return "redirect:login.html";
		}
		// Bien iss_card dung de phan loai The Quoc Te or The Noi Dia
		_session.setAttribute("iss_card", "iss_international_card");
		return "new_iss_international_card";
	}

	@RequestMapping(value = "new_iss_local_card", method = RequestMethod.GET)
	public String create_issTheNoiDia(Model m, HttpServletRequest request) {
		_session = request.getSession();
		// Check login?
		String user = (String) _session.getAttribute("userId");
		if (user == null || user.equals("")) {
			return "redirect:login.html";
		}
		// Bien iss_card dung de phan loai The Quoc Te or The Noi Dia
		_session.setAttribute("iss_card", "iss_international_card");
		return "new_iss_local_card";
	}

	@RequestMapping(value = "search_iss_international_card", method = RequestMethod.GET)
	public String search_issTheQuocTe(Model m, HttpServletRequest request) {
		_session = request.getSession();
		// Check login?
		String user = (String) _session.getAttribute("userId");
		if (user == null || user.equals("")) {
			return "redirect:login.html";
		}
		m.addAttribute("list", iSSCardDAO.get_userCreateCase());

		// iSSCardDAO.xuLyCreateTimeSauKhiImportFile();
		// iSSCardDAO.xuLyMaHoaSoTheSauKhiImportFile();
		return "search_iss_international_card";
	}

	@RequestMapping(value = "search_iss_local_card", method = RequestMethod.GET)
	public String search_iss_local_card(Model m, HttpServletRequest request) {
		_session = request.getSession();
		// Check login?
		String user = (String) _session.getAttribute("userId");
		if (user == null || user.equals("")) {
			return "redirect:login.html";
		}
		m.addAttribute("list", iSSCardDAO.get_userCreateCase());
		return "search_iss_local_card";
	}
}
