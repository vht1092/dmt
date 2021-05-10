package dao;

import java.math.BigDecimal;
import java.text.ParseException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import controller.Common;
import controller.LoginController;
import entity.*;
import dao.*;

@Repository
public class PosAcqEibDAO extends JdbcDaoSupport {

	@Autowired
	public PosAcqEibDAO(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	@Autowired
	private CommonDAO commonDAO;
	private static final Logger logger = Logger.getLogger(PosAcqEibDAO.class);

	// Thêm mới case ACQ Eib
	public List<PosAcqEib> createCasePosAcqEib(long acqPosEib_CreTms, String acqPosEib_Mid, float acqPosEib_TxnAmt,
			String acqPosEib_Branch, String acqPosEib_CanBoPhuTrach, String acqPosEib_trxnDate,
			String acqPosEib_MerchantName, String acqPosEib_LoaiTien, String acqPosEib_loaiThe,
			String acqPosEib_soTheDau, String acqPosEib_soTheCuoi, String acqPosEib_Tid, String acqPosEib_ApproveCode,
			String acqPosEib_PosMode, String acqPosEib_RecDate, String acqPosEib_ThoiGianCho,
			String acqPosEib_GdGianlan, String acqPosEib_tamGiuBaoCo, float acqPosEib_soTienTamGiuBaoCo,
			String acqPosEib_ThoiGianTrichNo, String acqPosEib_TinhTrangXuLy, String acqPosEib_NoiDungXuLy,
			String acqPosEib_GDBatThuong1, String acqPosEib_GDBatThuong2, String acqPosEib_GDBatThuong3,
			String acqPosEib_GDBatThuong4, String acqPosEib_GDBatThuong5, String acqPosEib_GDBatThuong6,
			String acqPosEib_YCXuatTrinhChungTu1, String acqPosEib_YCXuatTrinhChungTu2,
			String acqPosEib_YCXuatTrinhChungTu3, String acqPosEib_YCXuatTrinhChungTu4,
			String acqPosEib_YCXuatTrinhChungTu5, String acqPosEib_noiDungXuLy_VS, String acqPosEib_noiDungXuLy_MC,
			String acqPosEib_noiDungXuLy_Khac, String acqPosEib_tienDoXuLy, String acqPosEib_UserCre,
			String acqPosEib_File) throws ParseException {

		Common common = new Common();
		List<PosAcqEib> listPosAcqEib = new ArrayList<PosAcqEib>();

		String sql = "insert into ACQ_POS_Eib(ACQPOSEib_CRE_TMS, ACQPOSEib_MID, ACQPOSEib_TRXN_AMT, ACQPOSEib_BRANCH,"
				+ " ACQPOSEib_CANBO_PHUTRACH, ACQPOSEib_TRXNDATE, ACQPOSEib_MERC_NAME, ACQPOSEib_LOAITIEN, ACQPOSEib_LOAITHE,"
				+ " ACQPOSEib_SOTHEDAU, ACQPOSEib_SOTHECUOI, ACQPOSEib_TID, ACQPOSEib_APV_CDE, ACQPOSEib_POS_MODE,"
				+ " ACQPOSEib_REC_DT, ACQPOSEib_THOIGIANCHO, ACQPOSEib_GDGIANLAN, ACQPOSEib_TAMGIUBAOCO,"
				+ " ACQPOSEib_SOTIEN_TAMGIUBAOCO, ACQPOSEib_THOIGIANTRICHNO, ACQPOSEib_TINHTRANGXULY,"
				+ " ACQPOSEib_NOIDUNGXULY, ACQPOSEib_NOIDUNGXULY_KHAC, ACQPOSEib_GDBATTHUONG, ACQPOSEib_YCXUATCHUNGTU,"
				+ " ACQPOSEib_NDXL_VS, ACQPOSEib_NDXL_MC, ACQPOSEib_TIENDOXULY, ACQPOSEib_USER_CRE, ACQPOSEib_FILE)"
				+ " VALUES ('acqPosEib_CreTms', 'acqPosEib_Mid', 'acqPosEib_TxnAmt', 'acqPosEib_Branch',"
				+ " 'acqPosEib_CanBoPhuTrach', 'acqPosEib_trxnDate', 'acqPosEib_MerchantName', 'acqPosEib_LoaiTien',"
				+ " 'acqPosEib_loaiThe','acqPosEib_soTheDau','acqPosEib_soTheCuoi','acqPosEib_Tid','acqPosEib_ApproveCode',"
				+ " 'acqPosEib_PosMode','acqPosEib_RecDate', 'acqPosEib_ThoiGianCho', 'acqPosEib_GdGianlan',"
				+ " 'acqPosEib_tamGiuBaoCo','acqPosEib_soTienTamGiuBaoCo','acqPosEib_ThoiGianTrichNo',"
				+ " 'acqPosEib_TinhTrangXuLy','acqPosEib_NoiDungXuLy', 'acqPosEib_noiDungXuLy_Khac', 'acqPosEib_GDBatThuong',"
				+ " 'acqPosEib_YCXuatTrinhChungTu'," + " 'acqPosEib_noiDungXuLy_VS','acqPosEib_noiDungXuLy_MC',"
				+ " 'acqPosEib_tienDoXuLy', 'acqPosEib_UserCre', 'acqPosEib_File')";
		sql = sql.replaceAll("acqPosEib_CreTms", String.valueOf(acqPosEib_CreTms));
		sql = sql.replaceAll("acqPosEib_Mid", acqPosEib_Mid);
		sql = sql.replaceAll("acqPosEib_TxnAmt", String.valueOf(acqPosEib_TxnAmt));
		sql = sql.replaceAll("acqPosEib_Branch", acqPosEib_Branch);
		sql = sql.replaceAll("acqPosEib_CanBoPhuTrach", acqPosEib_CanBoPhuTrach.toUpperCase());
		sql = sql.replaceAll("acqPosEib_trxnDate", acqPosEib_trxnDate);
		sql = sql.replaceAll("acqPosEib_MerchantName", acqPosEib_MerchantName);
		sql = sql.replaceAll("acqPosEib_loaiThe", acqPosEib_loaiThe);
		sql = sql.replaceAll("acqPosEib_soTheDau", acqPosEib_soTheDau);
		sql = sql.replaceAll("acqPosEib_soTheCuoi", acqPosEib_soTheCuoi);
		sql = sql.replaceAll("acqPosEib_Tid", acqPosEib_Tid);
		sql = sql.replaceAll("acqPosEib_ApproveCode", acqPosEib_ApproveCode);
		sql = sql.replaceAll("acqPosEib_PosMode", acqPosEib_PosMode);
		// sql = sql.replaceAll("acqPosEib_Reason", acqPosEib_Reason);
		sql = sql.replaceAll("acqPosEib_RecDate", acqPosEib_RecDate);
		sql = sql.replaceAll("acqPosEib_tamGiuBaoCo", acqPosEib_tamGiuBaoCo);
		sql = sql.replaceAll("acqPosEib_soTienTamGiuBaoCo", String.valueOf(acqPosEib_soTienTamGiuBaoCo));
		sql = sql.replaceAll("acqPosEib_ThoiGianTrichNo", acqPosEib_ThoiGianTrichNo);
		sql = sql.replaceAll("acqPosEib_TinhTrangXuLy", acqPosEib_TinhTrangXuLy);
		sql = sql.replaceAll("acqPosEib_NoiDungXuLy", acqPosEib_NoiDungXuLy);
		sql = sql.replaceAll("acqPosEib_noiDungXuLy_VS", acqPosEib_noiDungXuLy_VS);
		sql = sql.replaceAll("acqPosEib_noiDungXuLy_MC", acqPosEib_noiDungXuLy_MC);
		sql = sql.replaceAll("acqPosEib_noiDungXuLy_Khac", acqPosEib_noiDungXuLy_Khac);
		sql = sql.replaceAll("acqPosEib_tienDoXuLy", acqPosEib_tienDoXuLy);
		sql = sql.replaceAll("acqPosEib_UserCre", acqPosEib_UserCre);
		sql = sql.replaceAll("acqPosEib_File", acqPosEib_File);
		sql = sql.replaceAll("acqPosEib_LoaiTien", acqPosEib_LoaiTien);
		sql = sql.replaceAll("acqPosEib_GdGianlan", acqPosEib_GdGianlan);

		if (acqPosEib_NoiDungXuLy.equals("1") || acqPosEib_NoiDungXuLy.equals("2")
				|| acqPosEib_NoiDungXuLy.equals("3")) {
			String nam = acqPosEib_trxnDate.substring(0, 4);
			String thang = acqPosEib_trxnDate.substring(4, 6);
			String ngay = acqPosEib_trxnDate.substring(6, 8);
			String full_acqPosEib_trxnDate = thang + "/" + ngay + "/" + nam + " 00:00:00";
			acqPosEib_ThoiGianCho = String.valueOf(common.TruThoiGian(full_acqPosEib_trxnDate));
		}

		if (acqPosEib_NoiDungXuLy.equals("4") || acqPosEib_NoiDungXuLy.equals("5")
				|| acqPosEib_NoiDungXuLy.equals("6")) {
			String nam = acqPosEib_RecDate.substring(0, 4);
			String thang = acqPosEib_RecDate.substring(4, 6);
			String ngay = acqPosEib_RecDate.substring(6, 8);
			String full_acqPosEib_RecDate = thang + "/" + ngay + "/" + nam + " 00:00:00";
			acqPosEib_ThoiGianCho = String.valueOf(common.TruThoiGian(full_acqPosEib_RecDate));
		}
		sql = sql.replaceAll("acqPosEib_ThoiGianCho", acqPosEib_ThoiGianCho);

		String acqPosEib_GDBatThuong = "";
		acqPosEib_GDBatThuong += acqPosEib_GDBatThuong1;
		acqPosEib_GDBatThuong += " ";
		acqPosEib_GDBatThuong += acqPosEib_GDBatThuong2;
		acqPosEib_GDBatThuong += " ";
		acqPosEib_GDBatThuong += acqPosEib_GDBatThuong3;
		acqPosEib_GDBatThuong += " ";
		acqPosEib_GDBatThuong += acqPosEib_GDBatThuong4;
		acqPosEib_GDBatThuong += " ";
		acqPosEib_GDBatThuong += acqPosEib_GDBatThuong5;
		acqPosEib_GDBatThuong += " ";
		acqPosEib_GDBatThuong += acqPosEib_GDBatThuong6;
		sql = sql.replaceAll("acqPosEib_GDBatThuong", acqPosEib_GDBatThuong);

		String acqPosEib_YCXuatTrinhChungTu = "";
		acqPosEib_YCXuatTrinhChungTu += acqPosEib_YCXuatTrinhChungTu1;
		acqPosEib_YCXuatTrinhChungTu += " ";
		acqPosEib_YCXuatTrinhChungTu += acqPosEib_YCXuatTrinhChungTu2;
		acqPosEib_YCXuatTrinhChungTu += " ";
		acqPosEib_YCXuatTrinhChungTu += acqPosEib_YCXuatTrinhChungTu3;
		acqPosEib_YCXuatTrinhChungTu += " ";
		acqPosEib_YCXuatTrinhChungTu += acqPosEib_YCXuatTrinhChungTu4;
		acqPosEib_YCXuatTrinhChungTu += " ";
		acqPosEib_YCXuatTrinhChungTu += acqPosEib_YCXuatTrinhChungTu5;
		sql = sql.replaceAll("acqPosEib_YCXuatTrinhChungTu", acqPosEib_YCXuatTrinhChungTu);

		// Luu thong tin noi dung xu ly vao bang acq_pos_eib_ndxl

		try {
			getJdbcTemplate().update(sql);
		} catch (Exception e) {
			logger.warn("PosAcqEibDAO, function createCasePosAcqEib() error: " + e.toString());
		}
		return listPosAcqEib;
	}

	public List<PosAcqEib> truyVanCapNhat_ACQ_POS_Eib(String txt_fromDate, String txt_toDate, String acqPosEibMid,
			String acqPosEibTid, String acqPosEib_loaiThe, String acqPosEibsoTheDau, String acqPosEibsoTheCuoi,
			String txt_KqGiaodich, String acqPosEib_NoiDungXuLy) {
		List<PosAcqEib> listPosAcqEib = new ArrayList<PosAcqEib>();

		String sql = "select * from acq_pos_Eib where ACQPOSEib_TRXNDATE >= _ACQPOSEib_TRXNDATE1 and ACQPOSEib_TRXNDATE <= _ACQPOSEib_TRXNDATE2 and ACQPOSEib_MID LIKE '%_ACQPOSEib_MID%'"
				+ " and ACQPOSEib_TID LIKE '%_ACQPOSEib_TID%' and ACQPOSEib_LOAITHE LIKE '%_ACQPOSEib_LOAITHE%' and ACQPOSEib_SOTHEDAU LIKE '%_ACQPOSEib_SOTHEDAU%'"
				+ " and ACQPOSEib_SOTHECUOI LIKE '%_ACQPOSEib_SOTHECUOI%' and ACQPOSEib_NOIDUNGXULY LIKE '%_ACQPOSEib_NOIDUNGXULY%'";

		sql = sql.replaceAll("_ACQPOSEib_TRXNDATE1", txt_fromDate);
		sql = sql.replaceAll("_ACQPOSEib_TRXNDATE2", txt_toDate);
		sql = sql.replaceAll("_ACQPOSEib_MID", acqPosEibMid);
		sql = sql.replaceAll("_ACQPOSEib_TID", acqPosEibTid);
		sql = sql.replaceAll("_ACQPOSEib_LOAITHE", acqPosEib_loaiThe);
		sql = sql.replaceAll("_ACQPOSEib_SOTHEDAU", acqPosEibsoTheDau);
		sql = sql.replaceAll("_ACQPOSEib_SOTHECUOI", acqPosEibsoTheCuoi);
		sql = sql.replaceAll("_ACQPOSEib_NOIDUNGXULY", acqPosEib_NoiDungXuLy);

		List<Map<String, Object>> list;
		try {
			list = getJdbcTemplate().queryForList(sql);
		} catch (Exception e) {
			logger.warn("PosAcqEibDAO, function truyVanCapNhat_ACQ_POS_Eib() error: " + e.toString());
			return null;
		}
		// List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql);
		int count = list.size();

		if (count == 0) {
			return listPosAcqEib;
		} else {
			for (Map<String, Object> row : list) {
				PosAcqEib PosAcqEib = new PosAcqEib();
				String _acqPosEibMid = String.valueOf(row.get("ACQPOSEib_MID"));
				String acqPosEibMerchantName = String.valueOf(row.get("ACQPOSEib_MERC_NAME"));
				String _acqPosEibTid = String.valueOf(row.get("ACQPOSEib_TID"));
				String acqPosEibtrxnDate = String.valueOf(row.get("ACQPOSEib_TRXNDATE"));
				String acqPosEibApproveCode = String.valueOf(row.get("ACQPOSEib_APV_CDE"));
				String acqPosEibTxnAmt = String.valueOf(row.get("ACQPOSEib_TRXN_AMT"));
				String acqPosEib_LoaiTien = String.valueOf(row.get("ACQPOSEib_LOAITIEN"));
				String _acqPosEibsoTheDau = String.valueOf(row.get("ACQPOSEib_SOTHEDAU"));
				String _acqPosEibsoTheCuoi = String.valueOf(row.get("ACQPOSEib_SOTHECUOI"));
				String acqPosEibloaiThe = String.valueOf(row.get("ACQPOSEib_LOAITHE"));
				String _acqPosEibPosMode = String.valueOf(row.get("ACQPOSEib_POS_MODE"));
				String acqPosEibBranch = String.valueOf(row.get("ACQPOSEib_BRANCH"));
				String acqPosEibCanBoPhuTrach = String.valueOf(row.get("ACQPOSEib_CANBO_PHUTRACH"));
				String acqPosEibtienDoXuLy = String.valueOf(row.get("ACQPOSEib_TIENDOXULY"));
				String acqPosEibtamGiuBaoCo = String.valueOf(row.get("ACQPOSEib_TAMGIUBAOCO"));
				String acqPosEibNoiDungXuLy = String.valueOf(row.get("ACQPOSEIB_NOIDUNGXULY"));
				String acqPosEibCreTms = String.valueOf(row.get("ACQPOSEIB_CRE_TMS"));

				PosAcqEib.setAcqPosEibMid(_acqPosEibMid);
				PosAcqEib.setAcqPosEibMerchantName(acqPosEibMerchantName);
				PosAcqEib.setAcqPosEibTid(_acqPosEibTid);
				PosAcqEib.setAcqPosEibtrxnDate(Integer.parseInt(acqPosEibtrxnDate));
				PosAcqEib.setAcqPosEibApproveCode(acqPosEibApproveCode);
				PosAcqEib.setAcqPosEibTxnAmt(acqPosEibTxnAmt);
				PosAcqEib.setAcqPosEib_LoaiTien(acqPosEib_LoaiTien);
				PosAcqEib.setAcqPosEibsoTheDau(_acqPosEibsoTheDau);
				PosAcqEib.setAcqPosEibsoTheCuoi(_acqPosEibsoTheCuoi);
				PosAcqEib.setAcqPosEibloaiThe(acqPosEibloaiThe);
				PosAcqEib.setAcqPosEibPosMode(_acqPosEibPosMode);
				PosAcqEib.setAcqPosEibBranch(acqPosEibBranch);
				PosAcqEib.setAcqPosEibCanBoPhuTrach(acqPosEibCanBoPhuTrach);
				PosAcqEib.setAcqPosEibtienDoXuLy(acqPosEibtienDoXuLy);
				PosAcqEib.setAcqPosEibtamGiuBaoCo(acqPosEibtamGiuBaoCo);
				PosAcqEib.setAcqPosEibNoiDungXuLy(acqPosEibNoiDungXuLy);
				PosAcqEib.setAcqPosEibCreTms(acqPosEibCreTms);

				listPosAcqEib.add(PosAcqEib);
			}
			return listPosAcqEib;
		}
	}

	public List<PosAcqEib> detail_acq_pos_eib(String createTime) {
		String sql = "select * from acq_pos_eib where ACQPOSEIB_CRE_TMS = '_ACQPOSEIB_CRE_TMS' and ROWNUM <= 1";

		sql = sql.replaceAll("_ACQPOSEIB_CRE_TMS", createTime);

		PosAcqEib result = new PosAcqEib();
		List<PosAcqEib> listPosEib = new ArrayList<PosAcqEib>();
		List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql);
		int count = list.size();

		if (count == 0) {
			return null;
		} else {
			for (Map<String, Object> row : list) {

				String acqPosEibNoiDungXuLy = String.valueOf(row.get("ACQPOSEIB_NOIDUNGXULY"));
				String acqPosEibRecDate = String.valueOf(row.get("ACQPOSEIB_REC_DT"));
				String acqPosEibThoiGianCho = String.valueOf(row.get("ACQPOSEIB_THOIGIANCHO"));
				String acqPosEibGdGianlan = String.valueOf(row.get("ACQPOSEIB_GDGIANLAN"));
				String acqPosEibtamGiuBaoCo = String.valueOf(row.get("ACQPOSEIB_TAMGIUBAOCO"));
				String acqPosEibsoTienTamGiuBaoCo = String.valueOf(row.get("ACQPOSEIB_SOTIEN_TAMGIUBAOCO"));
				String acqPosEibThoiGianTrichNo = String.valueOf(row.get("ACQPOSEIB_THOIGIANTRICHNO"));
				String acqPosEibTinhTrangXuLy = String.valueOf(row.get("ACQPOSEIB_TINHTRANGXULY"));
				String acqPosEibFile = String.valueOf(row.get("ACQPOSEIB_FILE"));
				String acqPosEibtienDoXuLy = String.valueOf(row.get("ACQPOSEIB_TIENDOXULY"));
				String acqPosEibGDBatThuong = String.valueOf(row.get("ACQPOSEIB_GDBATTHUONG"));
				String acqPosEibYCXuatTrinhChungTu = String.valueOf(row.get("ACQPOSEIB_YCXUATCHUNGTU"));
				String acqPosEibnoiDungXuLyKhac = String.valueOf(row.get("ACQPOSEIB_NOIDUNGXULY_KHAC"));
				String acqPosEibloaiThe = String.valueOf(row.get("ACQPOSEIB_LOAITHE"));
				String acqPosEibnoiDungXuLyVS = String.valueOf(row.get("ACQPOSEIB_NDXL_VS"));
				String acqPosEibnoiDungXuLyMC = String.valueOf(row.get("ACQPOSEIB_NDXL_MC"));

				result.setAcqPosEibNoiDungXuLy(acqPosEibNoiDungXuLy);
				result.setAcqPosEibRecDate(Integer.parseInt(acqPosEibRecDate));
				result.setAcqPosEibThoiGianCho(acqPosEibThoiGianCho);
				result.setAcqPosEibGdGianlan(acqPosEibGdGianlan);
				result.setAcqPosEibtamGiuBaoCo(acqPosEibtamGiuBaoCo);
				result.setAcqPosEibsoTienTamGiuBaoCo(acqPosEibsoTienTamGiuBaoCo);
				result.setAcqPosEibThoiGianTrichNo(Integer.parseInt(acqPosEibThoiGianTrichNo));
				result.setAcqPosEibTinhTrangXuLy(acqPosEibTinhTrangXuLy);
				result.setAcqPosEibFile(acqPosEibFile);
				result.setAcqPosEibtienDoXuLy(acqPosEibtienDoXuLy);
				result.setAcqPosEibGDBatThuong1(acqPosEibGDBatThuong);
				result.setAcqPosEibYCXuatTrinhChungTu1(acqPosEibYCXuatTrinhChungTu);
				result.setAcqPosEibnoiDungXuLyKhac(acqPosEibnoiDungXuLyKhac);
				result.setAcqPosEibloaiThe(acqPosEibloaiThe);
				result.setAcqPosEibnoiDungXuLyVS(acqPosEibnoiDungXuLyVS);
				result.setAcqPosEibnoiDungXuLyMC(acqPosEibnoiDungXuLyMC);

				listPosEib.add(result);
				return listPosEib;
			}
		}
		return listPosEib;
	}

	public void update_acq_pos_eib(String userUpdate, long updateTime, String acqPosEib_GdGianlan,
			String acqPosEib_tamGiuBaoCo, float acqPosEib_soTienTamGiuBaoCo_float, String acqPosEib_ThoiGianTrichNo,
			String acqPosEib_TinhTrangXuLy, String acqPosEib_File, String acqPosEib_tienDoXuLy, long updateID) {

		String sql = "UPDATE acq_pos_eib SET ACQPOSEIB_USERUPDT = '_ACQPOSEIB_USERUPDT', ACQPOSEIB_TIME_UPDT = '_ACQPOSEIB_TIME_UPDT',"
				+ " ACQPOSEIB_GDGIANLAN = '_ACQPOSEIB_GDGIANLAN', ACQPOSEIB_TAMGIUBAOCO = '_ACQPOSEIB_TAMGIUBAOCO', ACQPOSEIB_SOTIEN_TAMGIUBAOCO = '_ACQPOSEIB_SOTIEN_TAMGIUBAOCO',"
				+ " ACQPOSEIB_THOIGIANTRICHNO = '_ACQPOSEIB_THOIGIANTRICHNO', ACQPOSEIB_TINHTRANGXULY = '_ACQPOSEIB_TINHTRANGXULY',"
				+ " ACQPOSEIB_FILE = '_ACQPOSEIB_FILE', ACQPOSEIB_TIENDOXULY = '_ACQPOSEIB_TIENDOXULY' WHERE ACQPOSEIB_CRE_TMS = '_ACQPOSEIB_CRE_TMS'";

		sql = sql.replaceAll("_ACQPOSEIB_USERUPDT", userUpdate);
		sql = sql.replaceAll("_ACQPOSEIB_TIME_UPDT", String.valueOf(updateTime));
		sql = sql.replaceAll("_ACQPOSEIB_GDGIANLAN", acqPosEib_GdGianlan);
		sql = sql.replaceAll("_ACQPOSEIB_TAMGIUBAOCO", acqPosEib_tamGiuBaoCo);
		sql = sql.replaceAll("_ACQPOSEIB_SOTIEN_TAMGIUBAOCO", String.valueOf(acqPosEib_soTienTamGiuBaoCo_float));
		sql = sql.replaceAll("_ACQPOSEIB_THOIGIANTRICHNO", acqPosEib_ThoiGianTrichNo);
		sql = sql.replaceAll("_ACQPOSEIB_TINHTRANGXULY", acqPosEib_TinhTrangXuLy);
		sql = sql.replaceAll("_ACQPOSEIB_FILE", acqPosEib_File);
		sql = sql.replaceAll("_ACQPOSEIB_TIENDOXULY", acqPosEib_tienDoXuLy);
		sql = sql.replaceAll("_ACQPOSEIB_CRE_TMS", String.valueOf(updateID));

		try {
			getJdbcTemplate().update(sql);
		} catch (Exception e) {
			logger.warn("PosAcqEibDAO, function update_acq_pos_eib() error: " + e.toString());
		}

	}

	public void themMoiNoiDungXuLy(String userUpdate, long updateTime, String acqPosEib_NoiDungXuLy,
			String acqPosEib_GDBatThuong1, String acqPosEib_GDBatThuong2, String acqPosEib_GDBatThuong3,
			String acqPosEib_GDBatThuong4, String acqPosEib_GDBatThuong5, String acqPosEib_GDBatThuong6,
			String acqPosEib_YCXuatTrinhChungTu1, String acqPosEib_YCXuatTrinhChungTu2,
			String acqPosEib_YCXuatTrinhChungTu3, String acqPosEib_YCXuatTrinhChungTu4,
			String acqPosEib_YCXuatTrinhChungTu5, String acqPosEib_noiDungXuLy_VS, String acqPosEib_noiDungXuLy_MC,
			String acqPosEib_noiDungXuLy_Khac, long updateID) {

		String sql = "INSERT into acq_pos_eib_ndxl VALUES('ACQPOSEIB_CRE_TMS', 'ACQPOSEIB_NOIDUNGXULY', 'ACQPOSEIB_NOIDUNGXULY_KHAC', 'ACQPOSEIB_GDBATTHUONG',"
				+ "'ACQPOSEIB_YCXUATCHUNGTU', '', 'ACQPOSEIB_USER_CRE', 'ACQPOSEIB_NDXL_VS', 'ACQPOSEIB_NDXL_MC', 'ACQPOSEIB_NDXL_ID')";
		sql = sql.replaceAll("ACQPOSEIB_CRE_TMS", String.valueOf(updateTime));
		sql = sql.replaceAll("ACQPOSEIB_USER_CRE", userUpdate);
		sql = sql.replaceAll("ACQPOSEIB_NOIDUNGXULY", acqPosEib_NoiDungXuLy);
		sql = sql.replaceAll("ACQPOSEIB_NOIDUNGXULY_KHAC", acqPosEib_noiDungXuLy_Khac);

		String acqPosEib_GDBatThuong = "";
		acqPosEib_GDBatThuong += acqPosEib_GDBatThuong1;
		acqPosEib_GDBatThuong += " ";
		acqPosEib_GDBatThuong += acqPosEib_GDBatThuong2;
		acqPosEib_GDBatThuong += " ";
		acqPosEib_GDBatThuong += acqPosEib_GDBatThuong3;
		acqPosEib_GDBatThuong += " ";
		acqPosEib_GDBatThuong += acqPosEib_GDBatThuong4;
		acqPosEib_GDBatThuong += " ";
		acqPosEib_GDBatThuong += acqPosEib_GDBatThuong5;
		acqPosEib_GDBatThuong += " ";
		acqPosEib_GDBatThuong += acqPosEib_GDBatThuong6;
		sql = sql.replaceAll("ACQPOSEIB_GDBATTHUONG", acqPosEib_GDBatThuong);

		String acqPosEib_YCXuatTrinhChungTu = "";
		acqPosEib_YCXuatTrinhChungTu += acqPosEib_YCXuatTrinhChungTu1;
		acqPosEib_YCXuatTrinhChungTu += " ";
		acqPosEib_YCXuatTrinhChungTu += acqPosEib_YCXuatTrinhChungTu2;
		acqPosEib_YCXuatTrinhChungTu += " ";
		acqPosEib_YCXuatTrinhChungTu += acqPosEib_YCXuatTrinhChungTu3;
		acqPosEib_YCXuatTrinhChungTu += " ";
		acqPosEib_YCXuatTrinhChungTu += acqPosEib_YCXuatTrinhChungTu4;
		acqPosEib_YCXuatTrinhChungTu += " ";
		acqPosEib_YCXuatTrinhChungTu += acqPosEib_YCXuatTrinhChungTu5;
		sql = sql.replaceAll("ACQPOSEIB_YCXUATCHUNGTU", acqPosEib_YCXuatTrinhChungTu);

		sql = sql.replaceAll("ACQPOSEIB_NDXL_VS", acqPosEib_noiDungXuLy_VS);
		sql = sql.replaceAll("ACQPOSEIB_NDXL_MC", acqPosEib_noiDungXuLy_MC);
		sql = sql.replaceAll("ACQPOSEIB_NDXL_ID", String.valueOf(updateID));

		try {
			getJdbcTemplate().update(sql);
		} catch (Exception e) {
			logger.warn("PosAcqEibDAO, function themMoiNoiDungXuLy() error: " + e.toString());
		}
	}

	public List<PosAcqEib> detail_acq_pos_eib_tdxl(String createtimeId) {
		List<PosAcqEib> listPosAcqEib = new ArrayList<PosAcqEib>();

		String sql = "select * from acq_pos_eib_ndxl where ACQPOSEIB_NDXL_ID = '_ACQPOSEIB_NDXL_ID' ORDER by ACQPOSEIB_CRE_TMS";
		sql = sql.replaceAll("_ACQPOSEIB_NDXL_ID", createtimeId);

		List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql);
		int count = list.size();

		if (count == 0) {
			return listPosAcqEib;
		} else {
			for (Map<String, Object> row : list) {
				PosAcqEib PosAcqEib = new PosAcqEib();

				String acqPosEibCreTms = String.valueOf(row.get("ACQPOSEIB_CRE_TMS"));
				String acqPosEibNoiDungXuLy = String.valueOf(row.get("ACQPOSEIB_NOIDUNGXULY"));
				String acqPosEibnoiDungXuLyKhac = String.valueOf(row.get("ACQPOSEIB_NOIDUNGXULY_KHAC"));
				String acqPosEibGDBatThuong1 = String.valueOf(row.get("ACQPOSEIB_GDBATTHUONG"));
				String acqPosEibYCXuatTrinhChungTu1 = String.valueOf(row.get("ACQPOSEIB_YCXUATCHUNGTU"));
				String acqPosEibnoiDungXuLyVS = String.valueOf(row.get("ACQPOSEIB_NDXL_VS"));
				String acqPosEibnoiDungXuLyMC = String.valueOf(row.get("ACQPOSEIB_NDXL_MC"));
				String acqPosEibCreUser = String.valueOf(row.get("ACQPOSEIB_USER_CRE"));

				PosAcqEib.setAcqPosEibCreTms(acqPosEibCreTms);
				PosAcqEib.setAcqPosEibNoiDungXuLy(acqPosEibNoiDungXuLy);
				PosAcqEib.setAcqPosEibnoiDungXuLyKhac(acqPosEibnoiDungXuLyKhac);
				PosAcqEib.setAcqPosEibGDBatThuong1(acqPosEibGDBatThuong1);
				PosAcqEib.setAcqPosEibYCXuatTrinhChungTu1(acqPosEibYCXuatTrinhChungTu1);
				PosAcqEib.setAcqPosEibnoiDungXuLyVS(acqPosEibnoiDungXuLyVS);
				PosAcqEib.setAcqPosEibnoiDungXuLyMC(acqPosEibnoiDungXuLyMC);
				PosAcqEib.setAcqPosEibCreUser(acqPosEibCreUser);

				listPosAcqEib.add(PosAcqEib);
			}
			return listPosAcqEib;
		}
	}
}
