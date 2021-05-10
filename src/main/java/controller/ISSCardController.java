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
import dao.ISSCardDAO;

@Controller
public class ISSCardController {

	private static final String destinationDir = "C:/dispute-iss-card/";
	private HttpSession _session;
	Common common = new Common();

	@Autowired
	private ISSCardDAO iSSCardDAO;

	@Autowired
	private CommonDAO commonDAO;

	private static final Logger logger = Logger.getLogger(ISSCardController.class);

	// TRUY VAN GIAO DICH DE TAO CASE
	@RequestMapping(value = "/search_international_card", method = RequestMethod.POST)
	public String truyVanTheQuocTeChieuISS(Model m, HttpServletRequest request) {
		_session = request.getSession();

		// Check login?
		String user = (String) _session.getAttribute("userId");
		if (user == null || user.equals("")) {
			return "redirect:login.html";
		}

		String txt_fromDate = request.getParameter("txt_fromDate");
		String txt_toDate = request.getParameter("txt_toDate");
		String cardNo = request.getParameter("txt_cardNo");

		if (txt_fromDate == null) {
			txt_fromDate = (String) _session.getAttribute("txt_fromDate");
		}

		if (txt_toDate == null) {
			txt_toDate = (String) _session.getAttribute("txt_toDate");
		}

		if (cardNo == null) {
			cardNo = (String) _session.getAttribute("txt_cardNo");
		} else {
			cardNo = cardNo.replaceAll(" ", "");
		}

		// Return neu so the da nhap khong hop le
		if (cardNo.length() != 16 && cardNo.equals("")) {
			return "redirect:new_iss_international_card.html";
		}

		String soTheMaHoa = null;
		if (!cardNo.equals("")) {
			soTheMaHoa = commonDAO.maHoaSoThe(cardNo);
		}

		// SERVICE_CODE = 201: THE CREDIT
		_session.setAttribute("list", iSSCardDAO.truyVanTheQuocTeChieuISS(soTheMaHoa,
				common.formatTime_yyyymmdd(txt_fromDate), common.formatTime_yyyymmdd(txt_toDate)));

		// _session.setAttribute("txt_cardNo",
		// request.getParameter("txt_cardNo")));
		// _session.setAttribute("", soTheMaHoa);
		_session.setAttribute("txt_cardNo", cardNo);
		_session.setAttribute("txt_fromDate", txt_fromDate);
		_session.setAttribute("txt_toDate", txt_toDate);
		_session.setAttribute("txt_soTheMaHoa", soTheMaHoa);

		String _4LastCardNo = cardNo.substring(cardNo.length() - 4, cardNo.length());

		String logInfo = "ISSCARD=>" + user + ": Search 4_LastCardNo = " + _4LastCardNo + " from " + txt_fromDate
				+ " to " + txt_toDate;
		logger.warn(logInfo);

		return "redirect:new_iss_international_card.html";
	}

	// TAO MOI CASE
	@RequestMapping(value = "/create_international_card", method = RequestMethod.POST)
	public String createCaseTheQuocTeChieuISS(Model m, HttpServletRequest request) {
		_session = request.getSession();

		// Check login?
		String user = (String) _session.getAttribute("userId");
		if (user == null || user.equals("")) {
			return "redirect:login.html";
		}

		String result = "";
		String username = (String) _session.getAttribute("userId");
		String txt_ngayTiepNhan = request.getParameter("txt_ngayTiepNhan");
		int ngayTiepNhan = Integer.parseInt(common.formatTime_yyyymmdd(txt_ngayTiepNhan));
		String txt_caseID = request.getParameter("txt_caseID");
		String txt_kenhGD = request.getParameter("kenhGiaoDich");
		String txt_loaiThe = request.getParameter("loaiThe");
		String txt_lyDoTraSoat = request.getParameter("lyDoTraSoat");
		String txt_lyDoTraSoatKhac = request.getParameter("lyDoTraSoatKhac");
		String txt_quaTrinhXuLy = request.getParameter("quaTrinhXuLy");
		String soTheMaHoa = String.valueOf(_session.getAttribute("txt_soTheMaHoa"));

		String txt_tinhTrangCase = request.getParameter("tinhTrangCase");
		int thoiGianXuLy = -1;
		if (txt_tinhTrangCase.equals("Pending")) {
			thoiGianXuLy = 30;
		} else if (txt_tinhTrangCase.equals("Offline")) {
			thoiGianXuLy = 30;
		} else if (txt_tinhTrangCase.equals("Retrieval Request")) {
			thoiGianXuLy = 30;
		}

		String createTimeOfTrxn = request.getParameter("selectedTrxn");
		int lenght_createTimeOfTrxn = createTimeOfTrxn.length();
		String createTime, trxnDate;

		for (int i = 0; i < lenght_createTimeOfTrxn; i++) {
			if (createTimeOfTrxn.charAt(i) == '-') {

				// Lay ra createTime trong field selectedTrxn trong trang new_iss_international_card.jsp
				createTime = createTimeOfTrxn.substring((i + 1), (i + 27));

				// 6 ky tu dau cua createTime se la Ngay GD: trxnDate
				trxnDate = createTime.substring(0, 8);

				String MC_VS = "";
				// GD nay cua the Credit
				String MC_VS_Credit = iSSCardDAO.check_MC_VS_Credit(createTime, trxnDate);
				// GD nay cua the Dedit
				String MC_VS_Dedit = iSSCardDAO.check_MC_VS_Debit(createTime, trxnDate);

				if (MC_VS_Credit != null) {
					MC_VS = MC_VS_Credit;
					if (MC_VS_Credit.equals("MC")) {
						txt_loaiThe = "MC CREDIT";
					}
					if (MC_VS_Credit.equals("VS")) {
						txt_loaiThe = "VS CREDIT";
					}
				}
				if (MC_VS_Dedit != null) {
					MC_VS = MC_VS_Dedit;
					if (MC_VS_Dedit.equals("MC")) {
						txt_loaiThe = "MC DEBIT";
					}
					if (MC_VS_Dedit.equals("VS")) {
						txt_loaiThe = "VS DEBIT";
					}
				}

				if (txt_tinhTrangCase.equals("Chargeback/Dispute")) {
					if (MC_VS.equals("MC")) {
						thoiGianXuLy = 45;
					} else {
						thoiGianXuLy = 30;
					}
				} else if (txt_tinhTrangCase.equals("Arbitration Chargeback")) {
					if (MC_VS.equals("MC")) {
						thoiGianXuLy = 45;
					}
				} else if (txt_tinhTrangCase.equals("Pre-Arbitration")) {
					if (MC_VS.equals("VS")) {
						thoiGianXuLy = 30;
					}
				} else if (txt_tinhTrangCase.equals("Pre-Arbitration Response")) {
					if (MC_VS.equals("VS")) {
						thoiGianXuLy = 10;
					}
				} else if (txt_tinhTrangCase.equals("Arbitration")) {
					if (MC_VS.equals("MC")) {
						thoiGianXuLy = 10;
					} else {
						thoiGianXuLy = 7;
					}
				}

				if (MC_VS_Credit != null) {
					result = iSSCardDAO.createCaseCreditCard_ChieuISS(createTime, thoiGianXuLy, username,
							common.get_SystemTime(), txt_lyDoTraSoatKhac, ngayTiepNhan, txt_caseID, txt_kenhGD,
							txt_loaiThe, txt_lyDoTraSoat, txt_tinhTrangCase, txt_quaTrinhXuLy, trxnDate);
					logger.warn(String.valueOf("ISSCARD=>USER: " + user + " CREATED CASE CREDIT: " + createTime));
				} else if (MC_VS_Dedit != null) {
					result = iSSCardDAO.createCaseDebitCard_ChieuISS(createTime, thoiGianXuLy, username,
							common.get_SystemTime(), txt_lyDoTraSoatKhac, ngayTiepNhan, txt_caseID, txt_kenhGD,
							txt_loaiThe, txt_lyDoTraSoat, txt_tinhTrangCase, txt_quaTrinhXuLy, trxnDate, soTheMaHoa);
					logger.warn(String.valueOf("ISSCARD=>USER: " + user + " CREATED CASE DEBIT: " + createTime));
				}
			}
		}
		_session.setAttribute("alert_success", result);

		return truyVanTheQuocTeChieuISS(m, request);
	}

	@RequestMapping(value = "/search_disputes_iss_card", method = RequestMethod.POST)
	public String search_disputes_iss_card(Model m, HttpServletRequest request) {
		_session = request.getSession();

		// Check login?
		String user = (String) _session.getAttribute("userId");
		if (user == null || user.equals("")) {
			return "redirect:login.html";
		}
		_session.removeAttribute("alert_success");

		String txt_loaiNgaySearch = request.getParameter("loaiNgaySearch");
		String txt_fromDate = request.getParameter("txt_fromDate");
		String txt_toDate = request.getParameter("txt_toDate");
		String txt_caseId = request.getParameter("txt_caseId");
		String txt_Cif = request.getParameter("txt_Cif");
		String txt_Channel = request.getParameter("txt_Channel");
		String txt_lyDoTraSoat = request.getParameter("txt_lyDoTraSoat");
		String txt_tinhTrangCase = request.getParameter("txt_tinhTrangCase");
		String txt_ketQuaTraSoat = request.getParameter("txt_ketQuaTraSoat");
		String txt_userCreate = request.getParameter("txt_userCreate");
		String txt_loaiThe = request.getParameter("txt_loaiThe");

		txt_loaiNgaySearch = txt_loaiNgaySearch == null ? String.valueOf(_session.getAttribute("txt_loaiNgaySearch"))
				: txt_loaiNgaySearch;
		txt_fromDate = txt_fromDate == null ? String.valueOf(_session.getAttribute("txt_fromDate")) : txt_fromDate;
		txt_toDate = txt_toDate == null ? String.valueOf(_session.getAttribute("txt_toDate")) : txt_toDate;
		txt_caseId = txt_caseId == null ? String.valueOf(_session.getAttribute("txt_caseId")) : txt_caseId;
		txt_Cif = txt_Cif == null ? String.valueOf(_session.getAttribute("txt_Cif")) : txt_Cif;
		txt_Channel = txt_Channel == null ? String.valueOf(_session.getAttribute("txt_Channel")) : txt_Channel;
		txt_lyDoTraSoat = txt_lyDoTraSoat == null ? String.valueOf(_session.getAttribute("txt_lyDoTraSoat"))
				: txt_lyDoTraSoat;
		txt_ketQuaTraSoat = txt_ketQuaTraSoat == null ? String.valueOf(_session.getAttribute("txt_ketQuaTraSoat"))
				: txt_ketQuaTraSoat;
		txt_tinhTrangCase = txt_tinhTrangCase == null ? String.valueOf(_session.getAttribute("txt_tinhTrangCase"))
				: txt_tinhTrangCase;
		txt_userCreate = txt_userCreate == null ? String.valueOf(_session.getAttribute("txt_userCreate"))
				: txt_userCreate;
		txt_loaiThe = txt_loaiThe == null ? String.valueOf(_session.getAttribute("txt_loaiThe")) : txt_loaiThe;

		_session.setAttribute("list_iss_card",
				iSSCardDAO.truyVanTable_disputes_iss_card(txt_loaiNgaySearch, common.formatTime_yyyymmdd(txt_fromDate),
						common.formatTime_yyyymmdd(txt_toDate), txt_caseId, txt_Cif, txt_Channel, txt_lyDoTraSoat,
						txt_tinhTrangCase, txt_userCreate, txt_ketQuaTraSoat, txt_loaiThe));
		_session.setAttribute("txt_loaiNgaySearch", txt_loaiNgaySearch);
		_session.setAttribute("txt_fromDate", txt_fromDate);
		_session.setAttribute("txt_toDate", txt_toDate);
		_session.setAttribute("txt_caseId", txt_caseId);
		_session.setAttribute("txt_Cif", txt_Cif);
		_session.setAttribute("txt_Channel", txt_Channel);
		_session.setAttribute("txt_lyDoTraSoat", txt_lyDoTraSoat);
		_session.setAttribute("txt_tinhTrangCase", txt_tinhTrangCase);
		_session.setAttribute("txt_ketQuaTraSoat", txt_ketQuaTraSoat);
		_session.setAttribute("txt_userCreate", txt_userCreate);
		_session.setAttribute("txt_loaiThe", txt_loaiThe);

		String logInfo = "ISSCARD=> " + user + " SEARCH DISPUTES_ISS_CARD_V2, CASE_ID =  " + txt_caseId + " FROM "
				+ txt_fromDate + " TO " + txt_toDate;
		logger.warn(logInfo);

		return "redirect:search_iss_international_card.html";
	}

	@RequestMapping(value = "detail_iss_international_card", method = RequestMethod.GET)
	public String detail_issTheQuocTe(Model m, @RequestParam(value = "id", required = false) String id,
			HttpServletRequest request) throws ParseException {
		_session = request.getSession();
		// Check login?
		String user = (String) _session.getAttribute("userId");
		if (user == null || user.equals("")) {
			return "redirect:login.html";
		}
		_session.setAttribute("createTimeSelected", id);
		String userId = String.valueOf(_session.getAttribute("userId"));
		iSSCardDAO.capNhatThoiGianXuLyConLai_TheQuocTe(userId);
		_session.setAttribute("result", iSSCardDAO.chitiet_TheQuocTe_ISS(id));

		String logInfo = "ISSCARD=> " + user + " VIEW DETAIL CASE_ID = " + id;
		logger.warn(logInfo);
		return "detail_iss_international_card";
	}

	@RequestMapping(value = "undo_iss_international_card", method = RequestMethod.GET)
	public String undo_iss_international_card(Model m, @RequestParam(value = "id", required = false) Long id,
			HttpServletRequest request) {
		_session = request.getSession();
		// Check login?
		String user = (String) _session.getAttribute("userId");
		if (user == null || user.equals("")) {
			return "redirect:login.html";
		}
		return "redirect:search_iss_international_card.html";
	}

	@RequestMapping(value = "undo_iss_local_card", method = RequestMethod.GET)
	public String undo_iss_local_card(Model m, @RequestParam(value = "id", required = false) Long id,
			HttpServletRequest request) {
		_session = request.getSession();
		// Check login?
		String user = (String) _session.getAttribute("userId");
		if (user == null || user.equals("")) {
			return "redirect:login.html";
		}
		return "redirect:search_iss_local_card.html";
	}

	@RequestMapping(value = "case_can_xu_ly", method = RequestMethod.GET)
	public String case_can_xu_ly(HttpServletRequest request) {
		_session = request.getSession();
		// Check login?
		String user = (String) _session.getAttribute("userId");
		if (user == null || user.equals("")) {
			return "redirect:login.html";
		}
		_session.setAttribute("list_iss_card", iSSCardDAO.theQuocTe_getCaseCanXuLy());
		return "redirect:search_iss_international_card.html";
	}

	@RequestMapping(value = "case_den_han", method = RequestMethod.GET)
	public String case_den_han(HttpServletRequest request) {
		_session = request.getSession();
		// Check login?
		String user = (String) _session.getAttribute("userId");
		if (user == null || user.equals("")) {
			return "redirect:login.html";
		}
		_session.setAttribute("list_iss_card", iSSCardDAO.theQuocTe_getCaseDenHan());
		return "redirect:search_iss_international_card.html";
	}

	@RequestMapping(value = "case_qua_han", method = RequestMethod.GET)
	public String case_qua_han(HttpServletRequest request) {
		_session = request.getSession();
		// Check login?
		String user = (String) _session.getAttribute("userId");
		if (user == null || user.equals("")) {
			return "redirect:login.html";
		}
		_session.setAttribute("list_iss_card", iSSCardDAO.theQuocTe_getCaseQuaHan());
		return "redirect:search_iss_international_card.html";
	}

	@RequestMapping(value = "/update_disputes_iss_card", method = RequestMethod.POST)
	public String update_disputes_iss_card(Model m, HttpServletRequest request) {
		_session = request.getSession();

		// Check login?
		String user = (String) _session.getAttribute("userId");
		if (user == null || user.equals("")) {
			return "redirect:login.html";
		}

		String crdCaseStatus = request.getParameter("crdCaseStatus");
		String crdDisReasonCde = request.getParameter("crdDisReasonCde");
		String lyDoTraSoatKhac = request.getParameter("lyDoTraSoatKhac");
		String quaTrinhXuLy = request.getParameter("quaTrinhXuLy");

		String rrCode = request.getParameter("rrCode");
		String rrDate = request.getParameter("rrDate");
		String cbCode = request.getParameter("cbCode");
		String cbDate = request.getParameter("cbDate");
		String cbNgayTxt = request.getParameter("cbNgayTxt");
		String cbThoigianconlaiTxt = request.getParameter("cbThoigianconlaiTxt");
		String acCode = request.getParameter("acCode");
		String acDate = request.getParameter("acDate");
		String preArCode = request.getParameter("preArCode");
		String preArDate = request.getParameter("preArDate");
		String preArNgayphanhoi = request.getParameter("preArNgayphanhoi");
		String preArThoigianconlai = request.getParameter("preArThoigianconlai");
		String preArRespDate = request.getParameter("preArRespDate");
		String arCode = request.getParameter("arCode");
		String arDate = request.getParameter("arDate");
		String doneEndDate = request.getParameter("doneEndDate");
		String doneResult = request.getParameter("doneResult");
		String doneKqKhac = request.getParameter("doneKqKhac");
		String doneNgayhoantra = request.getParameter("doneNgayhoantra");
		String donePhikhieunaisai = request.getParameter("donePhikhieunaisai");
		String caseId = request.getParameter("caseId");
		String ngayTiepNhan = request.getParameter("ngayTiepNhan");

		String userUpdate = String.valueOf(_session.getAttribute("userId")).toUpperCase();
		String createTime = String.valueOf(_session.getAttribute("createTimeSelected"));
		String updateTime = String.valueOf(common.get_SystemTime());

		try {
			iSSCardDAO.update_case_iss_international_card(rrCode, rrDate, cbCode, cbDate, cbNgayTxt,
					cbThoigianconlaiTxt, acCode, acDate, preArCode, preArDate, preArNgayphanhoi, preArThoigianconlai,
					preArRespDate, arCode, arDate, doneEndDate, doneResult, doneKqKhac, doneNgayhoantra,
					donePhikhieunaisai, crdCaseStatus, crdDisReasonCde, lyDoTraSoatKhac, quaTrinhXuLy, createTime,
					updateTime, userUpdate, caseId, ngayTiepNhan);
			_session.setAttribute("alert_update_success", "Upade case successfully !");
			iSSCardDAO.capNhatThoiGianXuLyConLai_TheQuocTe(String.valueOf(_session.getAttribute("userId")));

			String logInfo = "ISSCARD=> " + user + " UPDATE CASE_ID = " + caseId;
			logger.warn(logInfo);
		} catch (Exception e) {
			// System.out.println("LOI UPDATE CASE: " + e.toString());
			String logInfo = "ISSCARD=> " + user + " UPDATE FAILE CASE_ID = " + caseId;
			logger.warn(logInfo);
		}
		return search_disputes_iss_card(m, request); // "redirect:search_iss_international_card.html";
	}

	// ================================= LOCAL CARD
	// =================================

	@RequestMapping(value = "/search_local_card", method = RequestMethod.POST)
	public String truyVanTheNoiDiaChieuISS(Model m, HttpServletRequest request) {
		_session = request.getSession();

		// Check login?
		String user = (String) _session.getAttribute("userId");
		if (user == null || user.equals("")) {
			return "redirect:login.html";
		}

		String txt_fromDate = request.getParameter("txt_fromDate");
		String txt_toDate = request.getParameter("txt_toDate");
		String cardNo = request.getParameter("txt_cardNo");

		if (txt_fromDate == null) {
			txt_fromDate = String.valueOf(_session.getAttribute("txt_fromDate"));
		}

		if (txt_toDate == null) {
			txt_toDate = String.valueOf(_session.getAttribute("txt_toDate"));
		}

		if (cardNo == null) {
			cardNo = String.valueOf(_session.getAttribute("txt_cardNo")).replaceAll(" ", "");
		} else {
			cardNo = cardNo.replaceAll(" ", "");
		}

		// Return neu so the da nhap khong hop le
		if (cardNo.length() != 16 && !cardNo.equals("")) {
			return "redirect:new_iss_international_card.html";
		}

		if (!cardNo.equals("")) {
			cardNo = commonDAO.maHoaSoThe(cardNo);
		}

		// SERVICE_CODE = 201: THE CREDIT
		_session.setAttribute("listLocal", iSSCardDAO.truyVan_BangGD_TheNoiDia(cardNo,
				common.formatTime_yyyymmdd(txt_fromDate), common.formatTime_yyyymmdd(txt_toDate)));

		_session.setAttribute("txt_cardNo", request.getParameter("txt_cardNo"));
		_session.setAttribute("txt_fromDate", txt_fromDate);
		_session.setAttribute("txt_toDate", txt_toDate);

		String _4LastCardNo = cardNo.substring(cardNo.length() - 4, cardNo.length());

		String logInfo = "LOCALCARD=>" + user + ": Search 4_LastCardNo = " + _4LastCardNo + " from " + txt_fromDate
				+ " to " + txt_toDate;
		logger.warn(logInfo);

		return "redirect:new_iss_local_card.html";
	}

	@RequestMapping(value = "/create_local_card", method = RequestMethod.POST)
	public String createCaseTheNoiDiaChieuISS(Model m, HttpServletRequest request) {
		_session = request.getSession();

		// Check login?
		String user = (String) _session.getAttribute("userId");
		if (user == null || user.equals("")) {
			return "redirect:login.html";
		}

		String username = (String) _session.getAttribute("userId");
		String txt_ngayTiepNhan = request.getParameter("txt_ngayTiepNhan");
		int ngayTiepNhan = Integer.parseInt(common.formatTime_yyyymmdd(txt_ngayTiepNhan));
		String txt_caseID = request.getParameter("txt_caseID");
		String txt_kenhGD = request.getParameter("kenhGiaoDich");
		String txt_loaiThe = "LOCAL DEBIT";
		String txt_lyDoTraSoat = request.getParameter("lyDoTraSoat");
		String txt_lyDoTraSoatKhac = request.getParameter("lyDoTraSoatKhac");
		String txt_quaTrinhXuLy = request.getParameter("quaTrinhXuLy");
		String kenhGiaoDich = request.getParameter("kenhGiaoDich");

		String txt_tinhTrangCase = request.getParameter("tinhTrangCase");
		int thoiGianXuLy = -1;
		if (txt_tinhTrangCase.equals("TS lan 1")) {
			if (txt_kenhGD.equals("ATM")) {
				thoiGianXuLy = 5;
			} else { // POS
				thoiGianXuLy = 10;
			}
		}
		if (txt_tinhTrangCase.equals("TS lan 2")) {
			thoiGianXuLy = 5;
		}
		if (txt_tinhTrangCase.equals("Thuong luong, hoa giai")
				|| txt_tinhTrangCase.equals("HD hoa giai Napas/Trong tai/Toa an")) {
			thoiGianXuLy = 30;
		}

		String createTimeOfTrxn = request.getParameter("selectedTrxn");
		int lenght_createTimeOfTrxn = createTimeOfTrxn.length();
		String createTime, trxnDate;

		for (int i = 0; i < lenght_createTimeOfTrxn; i++) {
			if (createTimeOfTrxn.charAt(i) == '-') {

				// Cáº¯t láº¥y ra CreateTime Ä‘Ã£ chá»�n trong field áº©n
				// selectedTrxn
				createTime = createTimeOfTrxn.substring((i + 1), (i + 18));

				// Cáº¯t 6 kÃ½ tá»± Ä‘áº§u láº¥y TrxnDate tá»« createTime
				trxnDate = createTime.substring(0, 8);

				iSSCardDAO.createCaseLocalCard_ChieuISS(createTime, thoiGianXuLy, username.toUpperCase(),
						common.get_SystemTime(), txt_lyDoTraSoatKhac, ngayTiepNhan, txt_caseID, txt_kenhGD, txt_loaiThe,
						txt_lyDoTraSoat, txt_tinhTrangCase, txt_quaTrinhXuLy, trxnDate, kenhGiaoDich);
				logger.warn(String.valueOf("LOCALCARD=>USER: " + user + " CREATED CASE: " + createTime));

			}
		}
		_session.setAttribute("alert_success", "Create local card successfully, case id: " + txt_caseID);
		return truyVanTheNoiDiaChieuISS(m, request);
	}

	@RequestMapping(value = "/search_iss_local_card", method = RequestMethod.POST)
	public String search_iss_local_card(Model m, HttpServletRequest request) {
		_session = request.getSession();

		// Check login?
		String user = (String) _session.getAttribute("userId");
		if (user == null || user.equals("")) {
			return "redirect:login.html";
		}
		_session.removeAttribute("alert_success");

		String txt_loaiNgaySearch = request.getParameter("loaiNgaySearch");
		String txt_fromDate = request.getParameter("txt_fromDate");
		String txt_toDate = request.getParameter("txt_toDate");
		String txt_caseId = request.getParameter("txt_caseId");
		String txt_Cif = request.getParameter("txt_Cif");
		String txt_Trace = request.getParameter("txt_trace");
		String txt_lyDoTraSoat = request.getParameter("txt_lyDoTraSoat");
		String txt_tinhTrangCase = request.getParameter("txt_tinhTrangCase");
		String txt_ketQuaTraSoat = request.getParameter("txt_ketQuaTraSoat");

		if (txt_loaiNgaySearch == null) {
			txt_loaiNgaySearch = String.valueOf(_session.getAttribute("txt_loaiNgaySearch"));
		}

		if (txt_fromDate == null) {
			txt_fromDate = String.valueOf(_session.getAttribute("txt_fromDate"));
		}

		if (txt_toDate == null) {
			txt_toDate = String.valueOf(_session.getAttribute("txt_toDate"));
		}

		if (txt_caseId == null) {
			txt_caseId = String.valueOf(_session.getAttribute("txt_caseId"));
		}

		if (txt_Cif == null) {
			txt_Cif = String.valueOf(_session.getAttribute("txt_Cif"));
		}

		if (txt_Trace == null) {
			txt_Trace = String.valueOf(_session.getAttribute("txt_Trace"));
		}

		if (txt_lyDoTraSoat == null) {
			txt_lyDoTraSoat = String.valueOf(_session.getAttribute("txt_lyDoTraSoat"));
		}

		if (txt_ketQuaTraSoat == null) {
			txt_ketQuaTraSoat = String.valueOf(_session.getAttribute("txt_ketQuaTraSoat"));
		}

		if (txt_tinhTrangCase == null) {
			txt_tinhTrangCase = String.valueOf(_session.getAttribute("txt_tinhTrangCase"));
		}

		_session.setAttribute("list_iss_card_local",
				iSSCardDAO.truyVanTable_disputes_local_card(txt_loaiNgaySearch,
						common.formatTime_yyyymmdd(txt_fromDate), common.formatTime_yyyymmdd(txt_toDate), txt_caseId,
						txt_Cif, txt_Trace, txt_lyDoTraSoat, txt_tinhTrangCase, txt_ketQuaTraSoat));
		_session.setAttribute("txt_loaiNgaySearch", txt_loaiNgaySearch);
		_session.setAttribute("txt_fromDate", txt_fromDate);
		_session.setAttribute("txt_toDate", txt_toDate);
		_session.setAttribute("txt_caseId", txt_caseId);
		_session.setAttribute("txt_Cif", txt_Cif);
		_session.setAttribute("txt_Trace", txt_Trace);
		_session.setAttribute("txt_lyDoTraSoat", txt_lyDoTraSoat);
		_session.setAttribute("txt_tinhTrangCase", txt_tinhTrangCase);
		_session.setAttribute("txt_ketQuaTraSoat", txt_ketQuaTraSoat);

		String logInfo = "LOCALCARD=> " + user + " SEARCH DISPUTES_ISS_CARD_V2, CASE_ID =  " + txt_caseId + " FROM "
				+ txt_fromDate + " TO " + txt_toDate;
		logger.warn(logInfo);

		return "redirect:search_iss_local_card.html";
	}

	@RequestMapping(value = "detail_iss_local_card", method = RequestMethod.GET)
	public String detail_iss_local_card(Model m, @RequestParam(value = "id", required = false) Long id,
			HttpServletRequest request) throws ParseException {
		_session = request.getSession();
		// Check login?
		String user = (String) _session.getAttribute("userId");
		if (user == null || user.equals("")) {
			return "redirect:login.html";
		}
		_session.setAttribute("createTimeSelected", id);
		String userId = String.valueOf(_session.getAttribute("userId"));
		iSSCardDAO.capNhatThoiGianXuLyConLai_TheNoiDia(userId);

		_session.setAttribute("result", iSSCardDAO.chitiet_TheNoiDia_ISS(id));
		String logInfo = "LOCALCARD=> " + user + " VIEW DETAIL CASE_ID = " + id;
		logger.warn(logInfo);
		return "detail_iss_local_card";
	}

	@RequestMapping(value = "delete_iss_international_card", method = RequestMethod.GET)
	public String delete_iss_local_card(Model m, @RequestParam(value = "id", required = false) String id,
			HttpServletRequest request) throws ParseException {
		_session = request.getSession();
		// Check login?
		String user = (String) _session.getAttribute("userId");
		if (user == null || user.equals("")) {
			return "redirect:login.html";
		}
		_session.setAttribute("createTimeSelected", id);
		iSSCardDAO.delete_case_iss_local_card(id);
		_session.setAttribute("alert_delete_success", "Delete case successfully");

		String logInfo = "LOCALCARD=>" + user + " DELETE CASE_ID = " + id;
		logger.warn(logInfo);
		return search_disputes_iss_card(m, request);
	}

	@RequestMapping(value = "/update_disputes_local_card", method = RequestMethod.POST)
	public String update_disputes_local_card(Model m, HttpServletRequest request) {
		_session = request.getSession();

		// Check login?
		String user = (String) _session.getAttribute("userId");
		if (user == null || user.equals("")) {
			return "redirect:login.html";
		}

		String crdCaseStatus = request.getParameter("tinhTrangCase");
		String quaTrinhXuLy = request.getParameter("quaTrinhXuLy");
		String crdDisReasonCde = request.getParameter("lyDoTraSoat");
		String lyDoTraSoatKhac = request.getParameter("nguyennhankhac");
		String crdTsLan1 = request.getParameter("crdTsLan1");
		String crdNgayTsLan1 = request.getParameter("crdNgayTsLan1");
		String crdNgayTsLan1Txt = request.getParameter("crdNgayTsLan1Txt");
		String crdTsLan2 = request.getParameter("crdTsLan2");
		String crdNgayTsLan2 = request.getParameter("crdNgayTsLan2");
		String crdNgayThuongLuong = request.getParameter("crdNgayThuongLuong");
		String crdNgayHoaGiaiNapas = request.getParameter("crdNgayHoaGiaiNapas");
		String doneEndDate = request.getParameter("doneEndDate");
		String doneResult = request.getParameter("doneResult");
		String doneNgayhoantra = request.getParameter("doneNgayhoantra");
		String donePhikhieunaisai = request.getParameter("donePhikhieunaisai");
		// String doneKqKhac =
		// )request.getParameter("doneKqKhac");
		// String caseId = )request.getParameter("caseId");
		// String ngayTiepNhan =
		// )request.getParameter("ngayTiepNhan");

		String userUpdate = String.valueOf(_session.getAttribute("userId")).toUpperCase();
		String createTime = String.valueOf(_session.getAttribute("createTimeSelected"));
		String updateTime = String.valueOf(common.get_SystemTime());

		try {
			iSSCardDAO.update_case_iss_local_card(crdTsLan1, crdNgayTsLan1, crdNgayTsLan1Txt, crdTsLan2, crdNgayTsLan2,
					crdNgayThuongLuong, crdNgayHoaGiaiNapas, doneEndDate, doneResult, doneNgayhoantra,
					donePhikhieunaisai, crdCaseStatus, crdDisReasonCde, lyDoTraSoatKhac, quaTrinhXuLy, createTime,
					updateTime, userUpdate);
			_session.setAttribute("alert_update_success", "Update case local card successfully !");
			iSSCardDAO.capNhatThoiGianXuLyConLai_TheNoiDia(String.valueOf(_session.getAttribute("userId")));

			String logInfo = "LOCALCARD=> " + user + " UPDATE CASE_ID = " + createTime;
			logger.warn(logInfo);
		} catch (Exception e) {
			System.out.println("LOI UPDATE CASE: " + e.toString());
		}
		return search_iss_local_card(m, request); // "redirect:search_iss_international_card.html";
	}
}
