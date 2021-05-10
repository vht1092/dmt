package controller;

import java.math.BigDecimal;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dao.CommonDAO;
import dao.IssEbankDAO;
import dao.IssEbankDAO;

@Controller
public class IssEbankController {

	private static final String destinationDir = "C:/dispute-iss-card/";
	private HttpSession _session;
	Common common = new Common();
	@Autowired
	private IssEbankDAO IssEbankDAO;
	@Autowired
	private CommonDAO commonDAO;
	private static final Logger logger = Logger.getLogger(IssEbankController.class);

	@RequestMapping(value = "/dmt1/detail_eb_ychtth", method = RequestMethod.GET)
	public String detail_eb_ychtth(Model m, @RequestParam(value = "id", required = false) String id,
			HttpServletRequest request) {
		_session = request.getSession();
		// Check login?
		String user = (String) _session.getAttribute("fullName");
		if (user == null || user.equals("")) {
			return "redirect:login.html";
		}
		_session.setAttribute("result", IssEbankDAO.get_detail_disputes_ebank_ychtth(id));
		logger.warn(String.valueOf("EBANK=>USER: " + user + " VIEW DEATAIL CASE " + id));
		return "detail_eb_ychtth";
	}

	@RequestMapping(value = "/dmt1/eb_update_ychtth", method = RequestMethod.GET)
	public String eb_update_ychtth(Model m, HttpServletRequest request) {
		_session = request.getSession();
		// Check login?
		String user = (String) _session.getAttribute("fullName");
		if (user == null || user.equals("")) {
			return "redirect:login.html";
		}

		_session.setAttribute("listUserCreate", IssEbankDAO.get_userCreateCase());
		_session.setAttribute("listPartner", IssEbankDAO.get_DoiTac());
		_session.setAttribute("listServices", IssEbankDAO.get_DichVu());
		logger.warn(String.valueOf("EBANK=>USER: " + user + " ACCESS PAGE eb_update_ychtth.html"));
		return "eb_update_ychtth";
	}

	@RequestMapping(value = "/dmt2/search_eb_create_ychtth", method = RequestMethod.POST)
	public String search_eb_create_ychtth(Model m, HttpServletRequest request) {
		_session = request.getSession();

		// Check login?
		String user = (String) _session.getAttribute("fullName");
		if (user == null || user.equals("")) {
			return "redirect:login.html";
		}

		String txt_fromDate = request.getParameter("txt_fromDate");
		String txt_toDate = request.getParameter("txt_toDate");
		String txt_cifNo = request.getParameter("txt_cifNo");
		String txt_account = request.getParameter("txt_account");
		if (txt_fromDate == null) {
			txt_fromDate = String.valueOf(_session.getAttribute("txt_fromDate"));
		}

		if (txt_toDate == null) {
			txt_toDate = String.valueOf(_session.getAttribute("txt_toDate"));
		}

		if (txt_cifNo == null) {
			txt_cifNo = String.valueOf(_session.getAttribute("txt_cifNo"));
		}

		if (txt_account == null) {
			txt_account = String.valueOf(_session.getAttribute("txt_account"));
		}

		// SERVICE_CODE = 201: THE CREDIT
		_session.setAttribute("list", IssEbankDAO.truyVanTaoMoi_EbankIss(txt_cifNo, txt_account,
				common.formatTime_yyyymmdd(txt_fromDate), common.formatTime_yyyymmdd(txt_toDate)));

		_session.setAttribute("txt_cifNo", txt_cifNo);
		_session.setAttribute("txt_account", txt_account);
		_session.setAttribute("txt_fromDate", txt_fromDate);
		_session.setAttribute("txt_toDate", txt_toDate);

		logger.warn(String.valueOf("EBANK=>USER: " + user + " SEARCH CASE TO CREATE, CIF: " + txt_cifNo));

		HomeController home = new HomeController();
		return home.eb_create_ychtth(m, request);
	}

	@RequestMapping(value = "/dmt1/search_update_Eb_ychtth", method = RequestMethod.POST)
	public String search_update_Eb_ychtth(Model m, HttpServletRequest request) throws ParseException {
		_session = request.getSession();

		// Check login?
		String user = (String) _session.getAttribute("fullName");
		if (user == null || user.equals("")) {
			return "redirect:login.html";
		}

		String loaiNgaySearch = String.valueOf(request.getParameter("loaiNgaySearch"));
		String txt_fromDate = String.valueOf(request.getParameter("txt_fromDate"));
		String txt_toDate = String.valueOf(request.getParameter("txt_toDate"));
		String txt_caseId = String.valueOf(request.getParameter("txt_caseId"));
		String txt_Cif = String.valueOf(request.getParameter("txt_Cif"));
		String txt_Channel = String.valueOf(request.getParameter("txt_Channel"));
		String txt_lyDoTraSoat = String.valueOf(request.getParameter("txt_lyDoTraSoat"));
		String txt_tinhTrangCase = String.valueOf(request.getParameter("txt_tinhTrangCase"));
		String txt_ketQuaTraSoat = String.valueOf(request.getParameter("txt_ketQuaTraSoat"));
		String txt_userCreate = String.valueOf(request.getParameter("txt_userCreate"));
		String txt_Services = String.valueOf(request.getParameter("txt_Services"));
		String txt_Partner = String.valueOf(request.getParameter("txt_Partner"));

		loaiNgaySearch = loaiNgaySearch.equals("null") ? String.valueOf(_session.getAttribute("loaiNgaySearch"))
				: loaiNgaySearch;
		txt_fromDate = txt_fromDate.equals("null") ? String.valueOf(_session.getAttribute("txt_fromDate"))
				: txt_fromDate;
		txt_toDate = txt_toDate.equals("null") ? String.valueOf(_session.getAttribute("txt_toDate")) : txt_toDate;
		txt_caseId = txt_caseId.equals("null") ? String.valueOf(_session.getAttribute("txt_caseId")) : txt_caseId;
		txt_Cif = txt_Cif.equals("null") ? String.valueOf(_session.getAttribute("txt_Cif")) : txt_Cif;
		txt_Channel = txt_Channel.equals("null") ? String.valueOf(_session.getAttribute("txt_Channel")) : txt_Channel;
		txt_lyDoTraSoat = txt_lyDoTraSoat.equals("null") ? String.valueOf(_session.getAttribute("txt_lyDoTraSoat"))
				: txt_lyDoTraSoat;
		txt_tinhTrangCase = txt_tinhTrangCase.equals("null")
				? String.valueOf(_session.getAttribute("txt_tinhTrangCase")) : txt_tinhTrangCase;
		txt_ketQuaTraSoat = txt_ketQuaTraSoat.equals("null")
				? String.valueOf(_session.getAttribute("txt_ketQuaTraSoat")) : txt_ketQuaTraSoat;
		txt_userCreate = txt_userCreate.equals("null") ? String.valueOf(_session.getAttribute("txt_userCreate"))
				: txt_userCreate;
		txt_Services = txt_Services.equals("null") ? String.valueOf(_session.getAttribute("txt_Services"))
				: txt_Services;
		txt_Partner = txt_Services.equals("null") ? String.valueOf(_session.getAttribute("txt_Partner")) : txt_Partner;

		_session.setAttribute("loaiNgaySearch", loaiNgaySearch);
		_session.setAttribute("txt_fromDate", txt_fromDate);
		_session.setAttribute("txt_toDate", txt_toDate);
		_session.setAttribute("txt_caseId", txt_caseId);
		_session.setAttribute("txt_Cif", txt_Cif);
		_session.setAttribute("txt_Channel", txt_Channel);
		_session.setAttribute("txt_lyDoTraSoat", txt_lyDoTraSoat);
		_session.setAttribute("txt_tinhTrangCase", txt_tinhTrangCase);
		_session.setAttribute("txt_ketQuaTraSoat", txt_ketQuaTraSoat);
		_session.setAttribute("txt_userCreate", txt_userCreate);
		_session.setAttribute("txt_Services", txt_Services);
		_session.setAttribute("txt_Partner", txt_Partner);

		_session.setAttribute("list_eb_ychtth",
				IssEbankDAO.truyVanCapNhat_EbankIss(loaiNgaySearch, common.formatTime_yyyymmdd(txt_fromDate),
						common.formatTime_yyyymmdd(txt_toDate), txt_caseId, txt_Cif, txt_Channel, txt_lyDoTraSoat,
						txt_tinhTrangCase, txt_ketQuaTraSoat, txt_userCreate, txt_Services, txt_Partner));
		return "eb_update_ychtth";
	}

	@RequestMapping(value = "/dmt2/create_eb_ychtth", method = RequestMethod.POST)
	public String create_eb_ychtth(Model m, HttpServletRequest request) {
		_session = request.getSession();

		// Check login?
		String user = (String) _session.getAttribute("fullName");
		if (user == null || user.equals("")) {
			return "redirect:login.html";
		}

		String username = (String) _session.getAttribute("userId");
		String txt_ngayTiepNhan = request.getParameter("txt_ngayTiepNhan");
		int ngayTiepNhan = Integer.parseInt(common.formatTime_yyyymmdd(txt_ngayTiepNhan));
		String txt_caseID = request.getParameter("txt_caseID");
		String txt_kenhGD = request.getParameter("kenhGiaoDich");
		String txt_lyDoTraSoat = request.getParameter("txt_lyDoTraSoat");
		String txt_lyDoTraSoatKhac = request.getParameter("txt_lyDoTraSoatKhac");
		String txt_quaTrinhXuLy = request.getParameter("txt_quaTrinhXuLy");
		String txt_tinhTrangCase = request.getParameter("txt_tinhTrangCase");
		String txt_phiHoTro = request.getParameter("txt_phiHoTro");
		String txt_ghiChu = request.getParameter("txt_ghiChu");

		String txt_ebank_id = request.getParameter("selectedTrxn");
		int lenght_createTimeOfTrxn = txt_ebank_id.length();
		String ebank_id, result = "";
		String[] sqlCreateArray;
		sqlCreateArray = new String[10];
		int index = 0;

		for (int i = 0; i < lenght_createTimeOfTrxn; i++) {
			if (txt_ebank_id.charAt(i) == '-') {

				// LAY RA CREATETIME TU FIELD selectedTrxn => SU DUNG LAM
				// EBANK_ID
				ebank_id = txt_ebank_id.substring((i + 1), (i + 22));

				// trxnDate: ddmmyyy
				String trxnDate = ebank_id.substring(7, 15);
				// formatTrxnDate: dd/mm/yyyy
				String formatTrxnDate = trxnDate.substring(0, 2) + "/" + trxnDate.substring(2, 4) + "/"
						+ trxnDate.substring(4, 8);

				result = IssEbankDAO.create_eb_ychtth(ebank_id, username, common.get_SystemTime(), txt_lyDoTraSoatKhac,
						ngayTiepNhan, txt_caseID, txt_kenhGD, txt_lyDoTraSoat, txt_tinhTrangCase, txt_quaTrinhXuLy,
						txt_phiHoTro, txt_ghiChu, trxnDate, formatTrxnDate);
				logger.warn(String.valueOf("EBANK=>USER: " + user + " CREATED CASE " + ebank_id));
				sqlCreateArray[index] = result;
				index++;
			}
		}
		_session.setAttribute("selectedTrxn", txt_ebank_id);
		_session.setAttribute("result", result);
		_session.setAttribute("sqlCreateArray", sqlCreateArray);
		_session.setAttribute("alert_success", "Please click SUBMIT to complete...");
		return search_eb_create_ychtth(m, request);
	}

	@RequestMapping(value = "/dmt1/saveDB_create_eb_ychtth", method = RequestMethod.POST)
	public String saveDB_create_eb_ychtth(Model m, HttpServletRequest request) {
		_session = request.getSession();

		// Check login?
		String user = (String) _session.getAttribute("fullName");
		if (user == null || user.equals("")) {
			return "redirect:login.html";
		}

		// KIEM TRA selectedTrxn CO TRUNG VS ID TRONG BANG
		// disputes_iss_ebank_v2?
		String selectedTrxn = request.getParameter("selectedTrxn");
		int lenght_createTimeOfTrxn = selectedTrxn.length();
		String ebank_id;

		for (int i = 0; i < lenght_createTimeOfTrxn; i++) {
			if (selectedTrxn.charAt(i) == '-') {

				// LAY RA CREATETIME TU FIELD selectedTrxn => SU DUNG LAM
				// EBANK_ID
				ebank_id = selectedTrxn.substring((i + 1), (i + 22));

				// NEU TON TAI ebank_id TRONG BANG disputes_iss_ebank_v2 THI TRA
				// VE
				if (IssEbankDAO.get_disputes_ebank_v2(ebank_id) == true) {
					_session.setAttribute("alert_success", "Error: Case already exist !");
					logger.warn(String.valueOf("EBANK=>USER: " + user
							+ " CREATED CASE NOT SUCCESS: Case already exist, CASE ID: " + ebank_id));
					return "eb_create_ychtth";
				}
			}
		}

		// sqlCreateArray: CHUA CAC CAU LENH INSERT TU HAM create_eb_ychtth TRA
		// VE
		String[] sqlCreateArray = (String[]) _session.getAttribute("sqlCreateArray");
		int lenght = sqlCreateArray.length;
		for (int i = 0; i < lenght; i++) {
			String query = sqlCreateArray[i];
			if (query != null) {
				boolean result = IssEbankDAO.saveDB_create_eb_ychtth(query);
				if (result == true) {
					_session.setAttribute("alert_success", "Submit success !");
					logger.warn(String.valueOf("EBANK=>USER: " + user + " CREATED CASE SUCCESS"));
				} else {
					_session.setAttribute("alert_success", "Error: Create case not success !");
					logger.warn(String.valueOf("EBANK=>USER: " + user + " CREATED CASE NOT SUCCESS"));
					return "eb_create_ychtth";
				}
			}
		}
		return "eb_create_ychtth";
	}

	@RequestMapping(value = "/update_disputes_eb_ychtth", method = RequestMethod.POST)
	public String update_disputes_eb_ychtth(Model m, HttpServletRequest request) {
		String user = (String) _session.getAttribute("fullName");

		// Luu thong tin du lieu hien tai vao bang History
		String edId = request.getParameter("ebId");
		String userUpdate = String.valueOf(_session.getAttribute("userId"));
		String updateTimes = String.valueOf(common.get_SystemTime());

		String ebCaseStatus = request.getParameter("ebCaseStatus");
		String ebDisReasonCde = request.getParameter("ebDisReasonCde");
		String ebProcProg = request.getParameter("ebProcProg");
		String ebNgayKetThuc = request.getParameter("ebNgayKetThuc");
		if (!ebNgayKetThuc.equals("")) {
			ebNgayKetThuc = common.formatTime_yyyymmdd(ebNgayKetThuc);
		}
		String ebKqTraSoat = request.getParameter("ebKqTraSoat");
		String ebNgayHoanTra = request.getParameter("ebNgayHoanTra");
		if (!ebNgayHoanTra.equals("")) {
			ebNgayHoanTra = common.formatTime_yyyymmdd(ebNgayHoanTra);
		}
		String ebPhiHoTro = request.getParameter("ebPhiHoTro");
		String ebSoTienThuHoi = request.getParameter("ebSoTienThuHoi");

		IssEbankDAO.update_disputes_iss_ebank(edId, userUpdate, updateTimes, ebCaseStatus, ebDisReasonCde, ebProcProg,
				ebNgayKetThuc, ebKqTraSoat, ebNgayHoanTra, ebPhiHoTro, ebSoTienThuHoi);
		logger.warn(String.valueOf("EBANK=>USER: " + user + " UPDATE CASE " + edId));

		// return eb_update_ychtth(m, request);
		return "redirect:/dmt1/eb_update_ychtth.html";
	}

	@RequestMapping(value = "/dmt1/undo_eb_update_ychtth", method = RequestMethod.GET)
	public String undo_eb_update_ychtth(Model m, @RequestParam(value = "id", required = false) Long id,
			HttpServletRequest request) {
		_session = request.getSession();
		// Check login?
		String user = (String) _session.getAttribute("fullName");
		if (user == null || user.equals("")) {
			return "redirect:login.html";
		}
		return "redirect:eb_update_ychtth.html";
	}

	@RequestMapping(value = "/dmt1/delete_eb_update_ychtth", method = RequestMethod.GET)
	public String delete_eb_update_ychtth(Model m, @RequestParam(value = "id", required = false) String id,
			HttpServletRequest request) throws ParseException {
		_session = request.getSession();
		// Check login?
		String user = (String) _session.getAttribute("fullName");
		if (user == null || user.equals("")) {
			return "redirect:login.html";
		}
		_session.setAttribute("createTimeSelected", id);
		IssEbankDAO.delete_case_eb_ychtth(id);
		_session.setAttribute("alert_delete_success", "Delete case successfull !");
		logger.warn(String.valueOf("USER: " + user + " DELETED CASE " + id));
		return search_update_Eb_ychtth(m, request);
	}

	@RequestMapping(value = "/dmt1/case_can_xu_ly_eb_ychtth", method = RequestMethod.GET)
	public String case_can_xu_ly_eb_ychtth(HttpServletRequest request) {
		_session = request.getSession();
		// Check login?
		String user = (String) _session.getAttribute("fullName");
		if (user == null || user.equals("")) {
			return "redirect:login.html";
		}
		_session.setAttribute("list_eb_ychtth", IssEbankDAO.eb_ychtth_getCaseCanXuLy());
		return "redirect:eb_update_ychtth.html";
	}

	@RequestMapping(value = "/dmt1/case_den_han_eb_ychtth", method = RequestMethod.GET)
	public String case_den_han_eb_ychtth(HttpServletRequest request) {
		_session = request.getSession();
		// Check login?
		String user = (String) _session.getAttribute("fullName");
		if (user == null || user.equals("")) {
			return "redirect:login.html";
		}
		_session.setAttribute("list_eb_ychtth", IssEbankDAO.eb_ychtth_getCaseDenHan());
		return "redirect:eb_update_ychtth.html";
	}

	@RequestMapping(value = "/dmt1/case_qua_han_eb_ychtth", method = RequestMethod.GET)
	public String case_qua_han_eb_ychtth(HttpServletRequest request) {
		_session = request.getSession();
		// Check login?
		String user = (String) _session.getAttribute("fullName");
		if (user == null || user.equals("")) {
			return "redirect:login.html";
		}
		_session.setAttribute("list_eb_ychtth", IssEbankDAO.eb_ychtth_getCaseQuaHan());
		return "redirect:eb_update_ychtth.html";
	}

	@RequestMapping(value = "/dmt1/case_xulygap_eb_ychtth", method = RequestMethod.GET)
	public String case_xulygap_eb_ychtth(HttpServletRequest request) {
		_session = request.getSession();
		// Check login?
		String user = (String) _session.getAttribute("fullName");
		if (user == null || user.equals("")) {
			return "redirect:login.html";
		}
		_session.setAttribute("list_eb_ychtth", IssEbankDAO.eb_ychtth_getCaseXuLyGap());
		return "redirect:eb_update_ychtth.html";
	}
}
