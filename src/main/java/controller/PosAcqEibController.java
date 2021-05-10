package controller;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dao.*;

@Controller
public class PosAcqEibController {

	private HttpSession _session;
	Common common = new Common();
	@Autowired
	private PosAcqEibDAO PosAcqEibDAO;
	private static final Logger logger = Logger.getLogger(PosAcqEibController.class);

	@RequestMapping(value = "/dmt1/detail_acq_pos_eib", method = RequestMethod.GET)
	public String detail_issTheQuocTe(Model m, @RequestParam(value = "id", required = false) String id,
			HttpServletRequest request) {
		_session = request.getSession();
		// Check login?
		String user = (String) _session.getAttribute("userId");
		if (user == null || user.equals("")) {
			return "redirect:login.html";
		}

		_session.setAttribute("createTimeSelected", id);
		_session.setAttribute("result", PosAcqEibDAO.detail_acq_pos_eib(id));
		logger.warn("PosAcqEibController, " + user + " VIEW DETAIL CASE " + id);

		return "detail_acq_pos_eib";
	}

	@RequestMapping(value = "/dmt1/list_acq_pos_eib", method = RequestMethod.GET)
	public String list_acq_pos_Eib(Model m, HttpServletRequest request) {
		_session = request.getSession();
		// Check login?
		String user = (String) _session.getAttribute("userId");
		if (user == null || user.equals("")) {
			return "redirect:login.html";
		}

		return "list_acq_pos_eib";
	}

	@RequestMapping(value = "/dmt1/new_acq_pos_eib", method = RequestMethod.GET)
	public String new_acq_pos_eib(Model m, HttpServletRequest request) {
		_session = request.getSession();
		// Check login?
		String user = (String) _session.getAttribute("userId");
		if (user == null || user.equals("")) {
			return "redirect:login.html";
		}

		return "new_acq_pos_eib";
	}

	@RequestMapping(value = "/dmt1/create_acq_eib", method = RequestMethod.POST)
	public String create_new_acq_pos_eib(Model m, HttpServletRequest request) throws ParseException {
		_session = request.getSession();
		// Check login?
		String user = (String) _session.getAttribute("userId");
		if (user == null || user.equals("")) {
			return "redirect:login.html";
		}

		String acqPosEib_UserCre = (String) _session.getAttribute("userId");

		String acqPosEib_Mid = request.getParameter("acqPosEib_Mid");

		String acqPosEib_TxnAmt = request.getParameter("acqPosEib_TxnAmt");
		float acqPosEib_TxnAmt_float = 0;
		if (!acqPosEib_TxnAmt.equals("")) {
			acqPosEib_TxnAmt_float = Float.parseFloat(acqPosEib_TxnAmt);
		}

		String acqPosEib_Branch = request.getParameter("acqPosEib_Branch");
		String acqPosEib_CanBoPhuTrach = request.getParameter("acqPosEib_CanBoPhuTrach");
		String acqPosEib_trxnDate = request.getParameter("acqPosEib_trxnDate");
		String acqPosEib_MerchantName = request.getParameter("acqPosEib_MerchantName");
		String acqPosEib_LoaiTien = request.getParameter("acqPosEib_LoaiTien");
		String acqPosEib_loaiThe = request.getParameter("acqPosEib_loaiThe");
		String acqPosEib_soTheDau = request.getParameter("acqPosEib_soTheDau");
		String acqPosEib_soTheCuoi = request.getParameter("acqPosEib_soTheCuoi");
		String acqPosEib_Tid = request.getParameter("acqPosEib_Tid");
		String acqPosEib_ApproveCode = request.getParameter("acqPosEib_ApproveCode");
		String acqPosEib_PosMode = request.getParameter("acqPosEib_PosMode");
		// String acqPosEib_Reason = request.getParameter("acqPosEib_Reason");
		String acqPosEib_RecDate = request.getParameter("acqPosEib_RecDate");
		String acqPosEib_ThoiGianCho = request.getParameter("acqPosEib_ThoiGianCho");
		String acqPosEib_tamGiuBaoCo = request.getParameter("acqPosEib_tamGiuBaoCo");
		String acqPosEib_GdGianlan = request.getParameter("acqPosEib_GdGianlan");

		String acqPosEib_soTienTamGiuBaoCo = String.valueOf(request.getParameter("acqPosEib_soTienTamGiuBaoCo"));
		float acqPosEib_soTienTamGiuBaoCo_float = 0;
		if (!acqPosEib_soTienTamGiuBaoCo.equals("")) {
			acqPosEib_soTienTamGiuBaoCo_float = Float.parseFloat(acqPosEib_soTienTamGiuBaoCo);
		}

		String acqPosEib_ThoiGianTrichNo = request.getParameter("acqPosEib_ThoiGianTrichNo");
		String acqPosEib_TinhTrangXuLy = request.getParameter("acqPosEib_TinhTrangXuLy");
		String acqPosEib_NoiDungXuLy = request.getParameter("acqPosEib_NoiDungXuLy");

		String acqPosEib_GDBatThuong1 = request.getParameter("acqPosEib_GDBatThuong1") != null
				? request.getParameter("acqPosEib_GDBatThuong1") : "";
		String acqPosEib_GDBatThuong2 = request.getParameter("acqPosEib_GDBatThuong2") != null
				? request.getParameter("acqPosEib_GDBatThuong2") : "";
		String acqPosEib_GDBatThuong3 = request.getParameter("acqPosEib_GDBatThuong3") != null
				? request.getParameter("acqPosEib_GDBatThuong3") : "";
		String acqPosEib_GDBatThuong4 = request.getParameter("acqPosEib_GDBatThuong4") != null
				? request.getParameter("acqPosEib_GDBatThuong4") : "";
		String acqPosEib_GDBatThuong5 = request.getParameter("acqPosEib_GDBatThuong5") != null
				? request.getParameter("acqPosEib_GDBatThuong5") : "";
		String acqPosEib_GDBatThuong6 = request.getParameter("acqPosEib_GDBatThuong6") != null
				? request.getParameter("acqPosEib_GDBatThuong6") : "";

		// String sBrand = cbxBranch.getValue() != null ?
		// cbxBranch.getValue().toString() : "";

		String acqPosEib_YCXuatTrinhChungTu1 = request.getParameter("acqPosEib_YCXuatTrinhChungTu1") != null
				? request.getParameter("acqPosEib_YCXuatTrinhChungTu1") : "";
		String acqPosEib_YCXuatTrinhChungTu2 = request.getParameter("acqPosEib_YCXuatTrinhChungTu2") != null
				? request.getParameter("acqPosEib_YCXuatTrinhChungTu2") : "";
		String acqPosEib_YCXuatTrinhChungTu3 = request.getParameter("acqPosEib_YCXuatTrinhChungTu3") != null
				? request.getParameter("acqPosEib_YCXuatTrinhChungTu3") : "";
		String acqPosEib_YCXuatTrinhChungTu4 = request.getParameter("acqPosEib_YCXuatTrinhChungTu4") != null
				? request.getParameter("acqPosEib_YCXuatTrinhChungTu4") : "";
		String acqPosEib_YCXuatTrinhChungTu5 = request.getParameter("acqPosEib_YCXuatTrinhChungTu5") != null
				? request.getParameter("acqPosEib_YCXuatTrinhChungTu5") : "";

		String acqPosEib_noiDungXuLy_VS = request.getParameter("acqPosEib_noiDungXuLy_VS");
		String acqPosEib_noiDungXuLy_MC = request.getParameter("acqPosEib_noiDungXuLy_MC");
		String acqPosEib_noiDungXuLy_Khac = request.getParameter("acqPosEib_noiDungXuLy_Khac");
		String acqPosEib_tienDoXuLy = request.getParameter("acqPosEib_tienDoXuLy");
		String acqPosEib_File = request.getParameter("acqPosEib_File");
		long createTime = common.get_SystemTime();

		_session.setAttribute("listUserCreate",
				PosAcqEibDAO.createCasePosAcqEib(createTime, acqPosEib_Mid, acqPosEib_TxnAmt_float, acqPosEib_Branch,
						acqPosEib_CanBoPhuTrach, common.formatTime_yyyymmdd(acqPosEib_trxnDate), acqPosEib_MerchantName,
						acqPosEib_LoaiTien, acqPosEib_loaiThe, acqPosEib_soTheDau, acqPosEib_soTheCuoi, acqPosEib_Tid,
						acqPosEib_ApproveCode, acqPosEib_PosMode, common.formatTime_yyyymmdd(acqPosEib_RecDate),
						acqPosEib_ThoiGianCho, acqPosEib_GdGianlan, acqPosEib_tamGiuBaoCo,
						acqPosEib_soTienTamGiuBaoCo_float, common.formatTime_yyyymmdd(acqPosEib_ThoiGianTrichNo),
						acqPosEib_TinhTrangXuLy, acqPosEib_NoiDungXuLy, acqPosEib_GDBatThuong1, acqPosEib_GDBatThuong2,
						acqPosEib_GDBatThuong3, acqPosEib_GDBatThuong4, acqPosEib_GDBatThuong5, acqPosEib_GDBatThuong6,
						acqPosEib_YCXuatTrinhChungTu1, acqPosEib_YCXuatTrinhChungTu2, acqPosEib_YCXuatTrinhChungTu3,
						acqPosEib_YCXuatTrinhChungTu4, acqPosEib_YCXuatTrinhChungTu5, acqPosEib_noiDungXuLy_VS,
						acqPosEib_noiDungXuLy_MC, acqPosEib_noiDungXuLy_Khac, acqPosEib_tienDoXuLy, acqPosEib_UserCre,
						acqPosEib_File));
		PosAcqEibDAO.themMoiNoiDungXuLy(acqPosEib_UserCre, createTime, acqPosEib_NoiDungXuLy, acqPosEib_GDBatThuong1,
				acqPosEib_GDBatThuong2, acqPosEib_GDBatThuong3, acqPosEib_GDBatThuong4, acqPosEib_GDBatThuong5,
				acqPosEib_GDBatThuong6, acqPosEib_YCXuatTrinhChungTu1, acqPosEib_YCXuatTrinhChungTu2,
				acqPosEib_YCXuatTrinhChungTu3, acqPosEib_YCXuatTrinhChungTu4, acqPosEib_YCXuatTrinhChungTu5,
				acqPosEib_noiDungXuLy_VS, acqPosEib_noiDungXuLy_MC, acqPosEib_noiDungXuLy_Khac, createTime);
		_session.setAttribute("alert_success", "CREATE CASE SUCCESSFULLY !");
		logger.warn("PosAcqEibController, " + user + " CREATED CASE " + createTime);

		return "new_acq_pos_eib";
	}

	@RequestMapping(value = "/dmt1/search_acq_pos_eib", method = RequestMethod.POST)
	public String search_acq_pos_Eib(Model m, HttpServletRequest request) {
		_session = request.getSession();
		String user = (String) _session.getAttribute("userId");

		String txt_fromDate = request.getParameter("txt_fromDate");
		String txt_toDate = request.getParameter("txt_toDate");
		String acqPosEibMid = request.getParameter("acqPosEibMid");
		String acqPosEibTid = request.getParameter("acqPosEibTid");
		String acqPosEib_loaiThe = request.getParameter("acqPosEib_loaiThe");
		String acqPosEibsoTheDau = request.getParameter("acqPosEibsoTheDau");
		String acqPosEibsoTheCuoi = request.getParameter("acqPosEibsoTheCuoi");
		String txt_KqGiaodich = request.getParameter("txt_KqGiaodich");
		String acqPosEib_NoiDungXuLy = request.getParameter("acqPosEib_NoiDungXuLy");

		_session.setAttribute("txt_fromDate", txt_fromDate);
		_session.setAttribute("txt_toDate", txt_toDate);

		_session.setAttribute("listAcqPosEib",
				PosAcqEibDAO.truyVanCapNhat_ACQ_POS_Eib(common.formatTime_yyyymmdd(txt_fromDate),
						common.formatTime_yyyymmdd(txt_toDate), acqPosEibMid, acqPosEibTid, acqPosEib_loaiThe,
						acqPosEibsoTheDau, acqPosEibsoTheCuoi, txt_KqGiaodich, acqPosEib_NoiDungXuLy));
		logger.warn("PosAcqEibController, " + user + " SEARCH CASE FROM " + txt_fromDate + " TO " + txt_toDate);
		return "redirect:list_acq_pos_eib.html";
	}

	@RequestMapping(value = "/dmt1/update_acq_pos_eib", method = RequestMethod.POST)
	public String update_acq_pos_eib(Model m, HttpServletRequest request) throws ParseException {
		_session = request.getSession();
		// Check login?
		String user = (String) _session.getAttribute("userId");
		if (user == null || user.equals("")) {
			return "redirect:login.html";
		}

		String acqPosEib_GdGianlan = request.getParameter("acqPosEib_GdGianlan");
		String acqPosEib_tamGiuBaoCo = request.getParameter("acqPosEib_tamGiuBaoCo");
		String acqPosEib_soTienTamGiuBaoCo = String.valueOf(request.getParameter("acqPosEib_soTienTamGiuBaoCo"));
		float acqPosEib_soTienTamGiuBaoCo_float = 0;
		if (!acqPosEib_soTienTamGiuBaoCo.equals("")) {
			acqPosEib_soTienTamGiuBaoCo_float = Float.parseFloat(acqPosEib_soTienTamGiuBaoCo);
		}

		String acqPosEib_ThoiGianTrichNo = request.getParameter("acqPosEib_ThoiGianTrichNo");
		int ngayTrichNo = Integer.parseInt(common.formatTime_yyyymmdd(acqPosEib_ThoiGianTrichNo));

		String acqPosEib_TinhTrangXuLy = request.getParameter("acqPosEibTinhTrangXuLy");
		String acqPosEib_File = request.getParameter("acqPosEib_File");
		String acqPosEib_tienDoXuLy = request.getParameter("acqPosEib_tienDoXuLy");

		String userUpdate = String.valueOf(_session.getAttribute("userId")).toUpperCase();
		long updateTime = common.get_SystemTime();

		// Them moi noi dung xu ly

		// updateID la ACQPOSEIB_CRE_TMS của case cần thêm NDXL
		long updateID = Long.parseLong(String.valueOf(_session.getAttribute("createTimeSelected")));

		String themMoiNoiDungXuLy = request.getParameter("themMoiNoiDungXuLy");
		String acqPosEib_NoiDungXuLy = request.getParameter("acqPosEib_NoiDungXuLy");
		String acqPosEib_GDBatThuong1 = request.getParameter("acqPosEib_GDBatThuong1") != null
				? request.getParameter("acqPosEib_GDBatThuong1") : "";
		String acqPosEib_GDBatThuong2 = request.getParameter("acqPosEib_GDBatThuong2") != null
				? request.getParameter("acqPosEib_GDBatThuong2") : "";
		String acqPosEib_GDBatThuong3 = request.getParameter("acqPosEib_GDBatThuong3") != null
				? request.getParameter("acqPosEib_GDBatThuong3") : "";
		String acqPosEib_GDBatThuong4 = request.getParameter("acqPosEib_GDBatThuong4") != null
				? request.getParameter("acqPosEib_GDBatThuong4") : "";
		String acqPosEib_GDBatThuong5 = request.getParameter("acqPosEib_GDBatThuong5") != null
				? request.getParameter("acqPosEib_GDBatThuong5") : "";
		String acqPosEib_GDBatThuong6 = request.getParameter("acqPosEib_GDBatThuong6") != null
				? request.getParameter("acqPosEib_GDBatThuong6") : "";
		String acqPosEib_YCXuatTrinhChungTu1 = request.getParameter("acqPosEib_YCXuatTrinhChungTu1") != null
				? request.getParameter("acqPosEib_YCXuatTrinhChungTu1") : "";
		String acqPosEib_YCXuatTrinhChungTu2 = request.getParameter("acqPosEib_YCXuatTrinhChungTu2") != null
				? request.getParameter("acqPosEib_YCXuatTrinhChungTu2") : "";
		String acqPosEib_YCXuatTrinhChungTu3 = request.getParameter("acqPosEib_YCXuatTrinhChungTu3") != null
				? request.getParameter("acqPosEib_YCXuatTrinhChungTu3") : "";
		String acqPosEib_YCXuatTrinhChungTu4 = request.getParameter("acqPosEib_YCXuatTrinhChungTu4") != null
				? request.getParameter("acqPosEib_YCXuatTrinhChungTu4") : "";
		String acqPosEib_YCXuatTrinhChungTu5 = request.getParameter("acqPosEib_YCXuatTrinhChungTu5") != null
				? request.getParameter("acqPosEib_YCXuatTrinhChungTu5") : "";
		String acqPosEib_noiDungXuLy_VS = request.getParameter("acqPosEib_noiDungXuLy_VS");
		String acqPosEib_noiDungXuLy_MC = request.getParameter("acqPosEib_noiDungXuLy_MC");
		String acqPosEib_noiDungXuLy_Khac = request.getParameter("acqPosEib_noiDungXuLy_Khac");

		try {
			PosAcqEibDAO.update_acq_pos_eib(userUpdate, updateTime, acqPosEib_GdGianlan, acqPosEib_tamGiuBaoCo,
					acqPosEib_soTienTamGiuBaoCo_float, String.valueOf(ngayTrichNo), acqPosEib_TinhTrangXuLy,
					acqPosEib_File, acqPosEib_tienDoXuLy, updateID);

			if (themMoiNoiDungXuLy.equals("themMoiNoiDungXuLy")) {
				PosAcqEibDAO.themMoiNoiDungXuLy(userUpdate, updateTime, acqPosEib_NoiDungXuLy, acqPosEib_GDBatThuong1,
						acqPosEib_GDBatThuong2, acqPosEib_GDBatThuong3, acqPosEib_GDBatThuong4, acqPosEib_GDBatThuong5,
						acqPosEib_GDBatThuong6, acqPosEib_YCXuatTrinhChungTu1, acqPosEib_YCXuatTrinhChungTu2,
						acqPosEib_YCXuatTrinhChungTu3, acqPosEib_YCXuatTrinhChungTu4, acqPosEib_YCXuatTrinhChungTu5,
						acqPosEib_noiDungXuLy_VS, acqPosEib_noiDungXuLy_MC, acqPosEib_noiDungXuLy_Khac, updateID);
			}
			logger.warn("PosAcqEibController, " + user + " UPDATED CASE " + updateID);
			_session.setAttribute("alert_update_success", "UPDATE CASE SUCCESSFULLY !");
		} catch (Exception e) {
			logger.warn("PosAcqEibController, " + user + " UPDATED CASE ERROR: " + e.toString());
		}

		return "redirect:list_acq_pos_eib.html";
	}

	@RequestMapping(value = "/dmt1/detail_acq_pos_eib_tdxl", method = RequestMethod.GET)
	public String detail_acq_pos_eib_tdxl(Model m, @RequestParam(value = "id", required = false) String id,
			HttpServletRequest request) throws ParseException {
		_session = request.getSession();
		// Check login?
		String user = (String) _session.getAttribute("userId");
		if (user == null || user.equals("")) {
			return "redirect:login.html";
		}

		_session.setAttribute("createTimeSelected", id);
		_session.setAttribute("listAcqPosEibTdxl", PosAcqEibDAO.detail_acq_pos_eib_tdxl(id));

		return "detail_acq_pos_eib_tdxl";
	}
}
