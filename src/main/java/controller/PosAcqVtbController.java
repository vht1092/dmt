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
public class PosAcqVtbController {

	private HttpSession _session;
	Common common = new Common();
	@Autowired
	private PosAcqVtbDAO PosAcqVtbDAO;
	private static final Logger logger = Logger.getLogger(PosAcqVtbController.class);

	@RequestMapping(value = "/dmt1/list_acq_pos_vtb", method = RequestMethod.GET)
	public String list_acq_pos_vtb(Model m, HttpServletRequest request) {
		_session = request.getSession();
		// Check login?
		String user = (String) _session.getAttribute("fullName");
		if (user == null || user.equals("")) {
			return "redirect:login.html";
		}

		return "list_acq_pos_vtb";
	}

	@RequestMapping(value = "/dmt1/new_acq_pos_vtb", method = RequestMethod.GET)
	public String new_acq_pos_vtb(Model m, HttpServletRequest request) {
		_session = request.getSession();
		// Check login?
		String user = (String) _session.getAttribute("fullName");
		if (user == null || user.equals("")) {
			return "redirect:login.html";
		}

		return "new_acq_pos_vtb";
	}

	@RequestMapping(value = "/dmt1/create_acq_vtb", method = RequestMethod.POST)
	public String create_new_acq_pos_vtb(Model m, HttpServletRequest request) throws ParseException {
		_session = request.getSession();
		// Check login?
		String user = (String) _session.getAttribute("fullName");
		if (user == null || user.equals("")) {
			return "redirect:login.html";
		}

		String acqPosVtb_UserCre = (String) _session.getAttribute("userId");

		String acqPosVtb_Mid = request.getParameter("acqPosVtb_Mid");

		String acqPosVtb_TxnAmt = request.getParameter("acqPosVtb_TxnAmt");
		float acqPosVtb_TxnAmt_float = 0;
		if (!acqPosVtb_TxnAmt.equals("")) {
			acqPosVtb_TxnAmt_float = Float.parseFloat(acqPosVtb_TxnAmt);
		}

		String acqPosVtb_Branch = request.getParameter("acqPosVtb_Branch");
		String acqPosVtb_CanBoPhuTrach = request.getParameter("acqPosVtb_CanBoPhuTrach");
		String acqPosVtb_trxnDate = request.getParameter("acqPosVtb_trxnDate");
		String acqPosVtb_MerchantName = request.getParameter("acqPosVtb_MerchantName");
		String acqPosVtb_LoaiTien = request.getParameter("acqPosVtb_LoaiTien");
		String acqPosVtb_loaiThe = request.getParameter("acqPosVtb_loaiThe");
		String acqPosVtb_soTheDau = request.getParameter("acqPosVtb_soTheDau");
		String acqPosVtb_soTheCuoi = request.getParameter("acqPosVtb_soTheCuoi");
		String acqPosVtb_Tid = request.getParameter("acqPosVtb_Tid");
		String acqPosVtb_ApproveCode = request.getParameter("acqPosVtb_ApproveCode");
		String acqPosVtb_PosMode = request.getParameter("acqPosVtb_PosMode");
		// String acqPosVtb_Reason = request.getParameter("acqPosVtb_Reason");
		String acqPosVtb_RecDate = request.getParameter("acqPosVtb_RecDate");
		String acqPosVtb_ThoiGianCho = request.getParameter("acqPosVtb_ThoiGianCho");
		String acqPosVtb_tamGiuBaoCo = request.getParameter("acqPosVtb_tamGiuBaoCo");
		String acqPosVtb_GdGianlan = request.getParameter("acqPosVtb_GdGianlan");

		String acqPosVtb_soTienTamGiuBaoCo = String.valueOf(request.getParameter("acqPosVtb_soTienTamGiuBaoCo"));
		float acqPosVtb_soTienTamGiuBaoCo_float = 0;
		if (!acqPosVtb_soTienTamGiuBaoCo.equals("")) {
			acqPosVtb_soTienTamGiuBaoCo_float = Float.parseFloat(acqPosVtb_soTienTamGiuBaoCo);
		}

		String acqPosVtb_ThoiGianTrichNo = request.getParameter("acqPosVtb_ThoiGianTrichNo");
		String acqPosVtb_TinhTrangXuLy = request.getParameter("acqPosVtb_TinhTrangXuLy");
		String acqPosVtb_NoiDungXuLy = request.getParameter("acqPosVtb_NoiDungXuLy");

		String acqPosVtb_GDBatThuong1 = request.getParameter("acqPosVtb_GDBatThuong1") != null
				? request.getParameter("acqPosVtb_GDBatThuong1") : "";
		String acqPosVtb_GDBatThuong2 = request.getParameter("acqPosVtb_GDBatThuong2") != null
				? request.getParameter("acqPosVtb_GDBatThuong2") : "";
		String acqPosVtb_GDBatThuong3 = request.getParameter("acqPosVtb_GDBatThuong3") != null
				? request.getParameter("acqPosVtb_GDBatThuong3") : "";
		String acqPosVtb_GDBatThuong4 = request.getParameter("acqPosVtb_GDBatThuong4") != null
				? request.getParameter("acqPosVtb_GDBatThuong4") : "";
		String acqPosVtb_GDBatThuong5 = request.getParameter("acqPosVtb_GDBatThuong5") != null
				? request.getParameter("acqPosVtb_GDBatThuong5") : "";
		String acqPosVtb_GDBatThuong6 = request.getParameter("acqPosVtb_GDBatThuong6") != null
				? request.getParameter("acqPosVtb_GDBatThuong6") : "";

		// String sBrand = cbxBranch.getValue() != null ?
		// cbxBranch.getValue().toString() : "";

		String acqPosVtb_YCXuatTrinhChungTu1 = request.getParameter("acqPosVtb_YCXuatTrinhChungTu1") != null
				? request.getParameter("acqPosVtb_YCXuatTrinhChungTu1") : "";
		String acqPosVtb_YCXuatTrinhChungTu2 = request.getParameter("acqPosVtb_YCXuatTrinhChungTu2") != null
				? request.getParameter("acqPosVtb_YCXuatTrinhChungTu2") : "";
		String acqPosVtb_YCXuatTrinhChungTu3 = request.getParameter("acqPosVtb_YCXuatTrinhChungTu3") != null
				? request.getParameter("acqPosVtb_YCXuatTrinhChungTu3") : "";
		String acqPosVtb_YCXuatTrinhChungTu4 = request.getParameter("acqPosVtb_YCXuatTrinhChungTu4") != null
				? request.getParameter("acqPosVtb_YCXuatTrinhChungTu4") : "";
		String acqPosVtb_YCXuatTrinhChungTu5 = request.getParameter("acqPosVtb_YCXuatTrinhChungTu5") != null
				? request.getParameter("acqPosVtb_YCXuatTrinhChungTu5") : "";

		String acqPosVtb_noiDungXuLy_VS = request.getParameter("acqPosVtb_noiDungXuLy_VS");
		String acqPosVtb_noiDungXuLy_MC = request.getParameter("acqPosVtb_noiDungXuLy_MC");
		String acqPosVtb_noiDungXuLy_Khac = request.getParameter("acqPosVtb_noiDungXuLy_Khac");
		String acqPosVtb_tienDoXuLy = request.getParameter("acqPosVtb_tienDoXuLy");
		String acqPosVtb_File = request.getParameter("acqPosVtb_File");
		long updateTime = common.get_SystemTime();

		_session.setAttribute("listUserCreate",
				PosAcqVtbDAO.createCasePosAcqVtb(updateTime, acqPosVtb_Mid, acqPosVtb_TxnAmt_float, acqPosVtb_Branch,
						acqPosVtb_CanBoPhuTrach, common.formatTime_yyyymmdd(acqPosVtb_trxnDate), acqPosVtb_MerchantName,
						acqPosVtb_LoaiTien, acqPosVtb_loaiThe, acqPosVtb_soTheDau, acqPosVtb_soTheCuoi, acqPosVtb_Tid,
						acqPosVtb_ApproveCode, acqPosVtb_PosMode, common.formatTime_yyyymmdd(acqPosVtb_RecDate),
						acqPosVtb_ThoiGianCho, acqPosVtb_GdGianlan, acqPosVtb_tamGiuBaoCo,
						acqPosVtb_soTienTamGiuBaoCo_float, common.formatTime_yyyymmdd(acqPosVtb_ThoiGianTrichNo),
						acqPosVtb_TinhTrangXuLy, acqPosVtb_NoiDungXuLy, acqPosVtb_GDBatThuong1, acqPosVtb_GDBatThuong2,
						acqPosVtb_GDBatThuong3, acqPosVtb_GDBatThuong4, acqPosVtb_GDBatThuong5, acqPosVtb_GDBatThuong6,
						acqPosVtb_YCXuatTrinhChungTu1, acqPosVtb_YCXuatTrinhChungTu2, acqPosVtb_YCXuatTrinhChungTu3,
						acqPosVtb_YCXuatTrinhChungTu4, acqPosVtb_YCXuatTrinhChungTu5, acqPosVtb_noiDungXuLy_VS,
						acqPosVtb_noiDungXuLy_MC, acqPosVtb_noiDungXuLy_Khac, acqPosVtb_tienDoXuLy, acqPosVtb_UserCre,
						acqPosVtb_File));
		PosAcqVtbDAO.themMoiNoiDungXuLy(acqPosVtb_UserCre, updateTime, acqPosVtb_NoiDungXuLy, acqPosVtb_GDBatThuong1,
				acqPosVtb_GDBatThuong2, acqPosVtb_GDBatThuong3, acqPosVtb_GDBatThuong4, acqPosVtb_GDBatThuong5,
				acqPosVtb_GDBatThuong6, acqPosVtb_YCXuatTrinhChungTu1, acqPosVtb_YCXuatTrinhChungTu2,
				acqPosVtb_YCXuatTrinhChungTu3, acqPosVtb_YCXuatTrinhChungTu4, acqPosVtb_YCXuatTrinhChungTu5,
				acqPosVtb_noiDungXuLy_VS, acqPosVtb_noiDungXuLy_MC, acqPosVtb_noiDungXuLy_Khac, updateTime);
		_session.setAttribute("alert_success", "CREATE CASE SUCCESSFULLY !");
		logger.warn("PosAcqVtbController, " + user + " CREATED CASE " + updateTime);

		return "new_acq_pos_vtb";
	}

	@RequestMapping(value = "/dmt1/search_acq_pos_vtb", method = RequestMethod.POST)
	public String search_acq_pos_vtb(Model m, HttpServletRequest request) {
		_session = request.getSession();
		String user = (String) _session.getAttribute("fullName");

		String txt_fromDate = request.getParameter("txt_fromDate");
		String txt_toDate = request.getParameter("txt_toDate");
		String acqPosVtbMid = request.getParameter("acqPosVtbMid");
		String acqPosVtbTid = request.getParameter("acqPosVtbTid");
		String acqPosVtb_loaiThe = request.getParameter("acqPosVtb_loaiThe");
		String acqPosVtbsoTheDau = request.getParameter("acqPosVtbsoTheDau");
		String acqPosVtbsoTheCuoi = request.getParameter("acqPosVtbsoTheCuoi");
		String txt_KqGiaodich = request.getParameter("txt_KqGiaodich");
		String acqPosVtb_NoiDungXuLy = request.getParameter("acqPosVtb_NoiDungXuLy");

		_session.setAttribute("listAcqPosVtb",
				PosAcqVtbDAO.truyVanCapNhat_ACQ_POS_VTB(common.formatTime_yyyymmdd(txt_fromDate),
						common.formatTime_yyyymmdd(txt_toDate), acqPosVtbMid, acqPosVtbTid, acqPosVtb_loaiThe,
						acqPosVtbsoTheDau, acqPosVtbsoTheCuoi, txt_KqGiaodich, acqPosVtb_NoiDungXuLy));
		logger.warn("PosAcqVtbController, " + user + " SEARCH CASE FROM " + txt_fromDate + " TO " + txt_toDate);
		return "redirect:list_acq_pos_vtb.html";
	}

	@RequestMapping(value = "/dmt1/detail_acq_pos_vtb", method = RequestMethod.GET)
	public String detail_acq_pos_vtb(Model m, @RequestParam(value = "id", required = false) String id,
			HttpServletRequest request) {
		_session = request.getSession();
		// Check login?
		String user = (String) _session.getAttribute("fullName");
		if (user == null || user.equals("")) {
			return "redirect:login.html";
		}

		_session.setAttribute("createTimeSelected", id);
		_session.setAttribute("result", PosAcqVtbDAO.detail_acq_pos_vtb(id));

		return "detail_acq_pos_vtb";
	}
}
