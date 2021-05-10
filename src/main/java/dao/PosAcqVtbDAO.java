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
public class PosAcqVtbDAO extends JdbcDaoSupport {

	@Autowired
	public PosAcqVtbDAO(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	@Autowired
	private CommonDAO commonDAO;
	private static final Logger logger = Logger.getLogger(PosAcqVtbDAO.class);

	// Thêm mới case ACQ VTB
	public List<PosAcqVtb> createCasePosAcqVtb(long acqPosVtb_CreTms, String acqPosVtb_Mid, float acqPosVtb_TxnAmt,
			String acqPosVtb_Branch, String acqPosVtb_CanBoPhuTrach, String acqPosVtb_trxnDate,
			String acqPosVtb_MerchantName, String acqPosVtb_LoaiTien, String acqPosVtb_loaiThe,
			String acqPosVtb_soTheDau, String acqPosVtb_soTheCuoi, String acqPosVtb_Tid, String acqPosVtb_ApproveCode,
			String acqPosVtb_PosMode, String acqPosVtb_RecDate, String acqPosVtb_ThoiGianCho,
			String acqPosVtb_GdGianlan, String acqPosVtb_tamGiuBaoCo, float acqPosVtb_soTienTamGiuBaoCo,
			String acqPosVtb_ThoiGianTrichNo, String acqPosVtb_TinhTrangXuLy, String acqPosVtb_NoiDungXuLy,
			String acqPosVtb_GDBatThuong1, String acqPosVtb_GDBatThuong2, String acqPosVtb_GDBatThuong3,
			String acqPosVtb_GDBatThuong4, String acqPosVtb_GDBatThuong5, String acqPosVtb_GDBatThuong6,
			String acqPosVtb_YCXuatTrinhChungTu1, String acqPosVtb_YCXuatTrinhChungTu2,
			String acqPosVtb_YCXuatTrinhChungTu3, String acqPosVtb_YCXuatTrinhChungTu4,
			String acqPosVtb_YCXuatTrinhChungTu5, String acqPosVtb_noiDungXuLy_VS, String acqPosVtb_noiDungXuLy_MC,
			String acqPosVtb_noiDungXuLy_Khac, String acqPosVtb_tienDoXuLy, String acqPosVtb_UserCre,
			String acqPosVtb_File) throws ParseException {

		Common common = new Common();
		List<PosAcqVtb> listPosAcqVtb = new ArrayList<PosAcqVtb>();

		String sql = "insert into ACQ_POS_VTB(ACQPOSVTB_CRE_TMS, ACQPOSVTB_MID, ACQPOSVTB_TRXN_AMT, ACQPOSVTB_BRANCH,"
				+ " ACQPOSVTB_CANBO_PHUTRACH, ACQPOSVTB_TRXNDATE, ACQPOSVTB_MERC_NAME, ACQPOSVTB_LOAITIEN, ACQPOSVTB_LOAITHE,"
				+ " ACQPOSVTB_SOTHEDAU, ACQPOSVTB_SOTHECUOI, ACQPOSVTB_TID, ACQPOSVTB_APV_CDE, ACQPOSVTB_POS_MODE,"
				+ " ACQPOSVTB_REC_DT, ACQPOSVTB_THOIGIANCHO, ACQPOSVTB_GDGIANLAN, ACQPOSVTB_TAMGIUBAOCO,"
				+ " ACQPOSVTB_SOTIEN_TAMGIUBAOCO, ACQPOSVTB_THOIGIANTRICHNO, ACQPOSVTB_TINHTRANGXULY,"
				+ " ACQPOSVTB_NOIDUNGXULY, ACQPOSVTB_NOIDUNGXULY_KHAC, ACQPOSVTB_GDBATTHUONG, ACQPOSVTB_YCXUATCHUNGTU,"
				+ " ACQPOSVTB_NDXL_VS, ACQPOSVTB_NDXL_MC, ACQPOSVTB_TIENDOXULY, ACQPOSVTB_USER_CRE, ACQPOSVTB_FILE)"
				+ " VALUES ('acqPosVtb_CreTms', 'acqPosVtb_Mid', 'acqPosVtb_TxnAmt', 'acqPosVtb_Branch',"
				+ " 'acqPosVtb_CanBoPhuTrach', 'acqPosVtb_trxnDate', 'acqPosVtb_MerchantName', 'acqPosVtb_LoaiTien',"
				+ " 'acqPosVtb_loaiThe','acqPosVtb_soTheDau','acqPosVtb_soTheCuoi','acqPosVtb_Tid','acqPosVtb_ApproveCode',"
				+ " 'acqPosVtb_PosMode','acqPosVtb_RecDate', 'acqPosVtb_ThoiGianCho', 'acqPosVtb_GdGianlan',"
				+ " 'acqPosVtb_tamGiuBaoCo','acqPosVtb_soTienTamGiuBaoCo','acqPosVtb_ThoiGianTrichNo',"
				+ " 'acqPosVtb_TinhTrangXuLy','acqPosVtb_NoiDungXuLy', 'acqPosVtb_noiDungXuLy_Khac', 'acqPosVtb_GDBatThuong',"
				+ " 'acqPosVtb_YCXuatTrinhChungTu'," + " 'acqPosVtb_noiDungXuLy_VS','acqPosVtb_noiDungXuLy_MC',"
				+ " 'acqPosVtb_tienDoXuLy', 'acqPosVtb_UserCre', 'acqPosVtb_File')";
		sql = sql.replaceAll("acqPosVtb_CreTms", String.valueOf(acqPosVtb_CreTms));
		sql = sql.replaceAll("acqPosVtb_Mid", acqPosVtb_Mid);
		sql = sql.replaceAll("acqPosVtb_TxnAmt", String.valueOf(acqPosVtb_TxnAmt));
		sql = sql.replaceAll("acqPosVtb_Branch", acqPosVtb_Branch);
		sql = sql.replaceAll("acqPosVtb_CanBoPhuTrach", acqPosVtb_CanBoPhuTrach.toUpperCase());
		sql = sql.replaceAll("acqPosVtb_trxnDate", acqPosVtb_trxnDate);
		sql = sql.replaceAll("acqPosVtb_MerchantName", acqPosVtb_MerchantName);
		sql = sql.replaceAll("acqPosVtb_loaiThe", acqPosVtb_loaiThe);
		sql = sql.replaceAll("acqPosVtb_soTheDau", acqPosVtb_soTheDau);
		sql = sql.replaceAll("acqPosVtb_soTheCuoi", acqPosVtb_soTheCuoi);
		sql = sql.replaceAll("acqPosVtb_Tid", acqPosVtb_Tid);
		sql = sql.replaceAll("acqPosVtb_ApproveCode", acqPosVtb_ApproveCode);
		sql = sql.replaceAll("acqPosVtb_PosMode", acqPosVtb_PosMode);
		// sql = sql.replaceAll("acqPosVtb_Reason", acqPosVtb_Reason);
		sql = sql.replaceAll("acqPosVtb_RecDate", acqPosVtb_RecDate);
		sql = sql.replaceAll("acqPosVtb_tamGiuBaoCo", acqPosVtb_tamGiuBaoCo);
		sql = sql.replaceAll("acqPosVtb_soTienTamGiuBaoCo", String.valueOf(acqPosVtb_soTienTamGiuBaoCo));
		sql = sql.replaceAll("acqPosVtb_ThoiGianTrichNo", acqPosVtb_ThoiGianTrichNo);
		sql = sql.replaceAll("acqPosVtb_TinhTrangXuLy", acqPosVtb_TinhTrangXuLy);
		sql = sql.replaceAll("acqPosVtb_NoiDungXuLy", acqPosVtb_NoiDungXuLy);
		sql = sql.replaceAll("acqPosVtb_noiDungXuLy_VS", acqPosVtb_noiDungXuLy_VS);
		sql = sql.replaceAll("acqPosVtb_noiDungXuLy_MC", acqPosVtb_noiDungXuLy_MC);
		sql = sql.replaceAll("acqPosVtb_noiDungXuLy_Khac", acqPosVtb_noiDungXuLy_Khac);
		sql = sql.replaceAll("acqPosVtb_tienDoXuLy", acqPosVtb_tienDoXuLy);
		sql = sql.replaceAll("acqPosVtb_UserCre", acqPosVtb_UserCre);
		sql = sql.replaceAll("acqPosVtb_File", acqPosVtb_File);
		sql = sql.replaceAll("acqPosVtb_LoaiTien", acqPosVtb_LoaiTien);
		// sql = sql.replaceAll("acqPosVtb_ThoiGianCho", acqPosVtb_ThoiGianCho);
		sql = sql.replaceAll("acqPosVtb_GdGianlan", acqPosVtb_GdGianlan);

		if (acqPosVtb_NoiDungXuLy.equals("1") || acqPosVtb_NoiDungXuLy.equals("2")
				|| acqPosVtb_NoiDungXuLy.equals("3")) {
			String nam = acqPosVtb_trxnDate.substring(0, 4);
			String thang = acqPosVtb_trxnDate.substring(4, 6);
			String ngay = acqPosVtb_trxnDate.substring(6, 8);
			String full_acqPosVTB_trxnDate = thang + "/" + ngay + "/" + nam + " 00:00:00";
			acqPosVtb_ThoiGianCho = String.valueOf(common.TruThoiGian(full_acqPosVTB_trxnDate));
		}

		if (acqPosVtb_NoiDungXuLy.equals("4") || acqPosVtb_NoiDungXuLy.equals("5") || acqPosVtb_RecDate.equals("6")) {
			String nam = acqPosVtb_RecDate.substring(0, 4);
			String thang = acqPosVtb_RecDate.substring(4, 6);
			String ngay = acqPosVtb_RecDate.substring(6, 8);
			String full_acqPosVTB_RecDate = thang + "/" + ngay + "/" + nam + " 00:00:00";
			acqPosVtb_ThoiGianCho = String.valueOf(common.TruThoiGian(full_acqPosVTB_RecDate));
		}
		sql = sql.replaceAll("acqPosVtb_ThoiGianCho", acqPosVtb_ThoiGianCho);

		String acqPosVtb_GDBatThuong = "";
		acqPosVtb_GDBatThuong += acqPosVtb_GDBatThuong1;
		acqPosVtb_GDBatThuong += " ";
		acqPosVtb_GDBatThuong += acqPosVtb_GDBatThuong2;
		acqPosVtb_GDBatThuong += " ";
		acqPosVtb_GDBatThuong += acqPosVtb_GDBatThuong3;
		acqPosVtb_GDBatThuong += " ";
		acqPosVtb_GDBatThuong += acqPosVtb_GDBatThuong4;
		acqPosVtb_GDBatThuong += " ";
		acqPosVtb_GDBatThuong += acqPosVtb_GDBatThuong5;
		acqPosVtb_GDBatThuong += " ";
		acqPosVtb_GDBatThuong += acqPosVtb_GDBatThuong6;
		sql = sql.replaceAll("acqPosVtb_GDBatThuong", acqPosVtb_GDBatThuong);

		String acqPosVtb_YCXuatTrinhChungTu = "";
		acqPosVtb_YCXuatTrinhChungTu += acqPosVtb_YCXuatTrinhChungTu1;
		acqPosVtb_YCXuatTrinhChungTu += " ";
		acqPosVtb_YCXuatTrinhChungTu += acqPosVtb_YCXuatTrinhChungTu2;
		acqPosVtb_YCXuatTrinhChungTu += " ";
		acqPosVtb_YCXuatTrinhChungTu += acqPosVtb_YCXuatTrinhChungTu3;
		acqPosVtb_YCXuatTrinhChungTu += " ";
		acqPosVtb_YCXuatTrinhChungTu += acqPosVtb_YCXuatTrinhChungTu4;
		acqPosVtb_YCXuatTrinhChungTu += " ";
		acqPosVtb_YCXuatTrinhChungTu += acqPosVtb_YCXuatTrinhChungTu5;
		sql = sql.replaceAll("acqPosVtb_YCXuatTrinhChungTu", acqPosVtb_YCXuatTrinhChungTu);

		try {
			getJdbcTemplate().update(sql);
		} catch (Exception e) {
			logger.warn("PosAcqVtbDAO, function createCasePosAcqVtb() error: " + e.toString());
		}
		return listPosAcqVtb;
	}

	public List<PosAcqVtb> truyVanCapNhat_ACQ_POS_VTB(String txt_fromDate, String txt_toDate, String acqPosVtbMid,
			String acqPosVtbTid, String acqPosVtb_loaiThe, String acqPosVtbsoTheDau, String acqPosVtbsoTheCuoi,
			String txt_KqGiaodich, String acqPosVtb_NoiDungXuLy) {
		List<PosAcqVtb> listPosAcqVtb = new ArrayList<PosAcqVtb>();

		String sql = "select * from acq_pos_vtb where ACQPOSVTB_TRXNDATE >= _ACQPOSVTB_TRXNDATE1 and ACQPOSVTB_TRXNDATE <= _ACQPOSVTB_TRXNDATE2 and ACQPOSVTB_MID LIKE '%_ACQPOSVTB_MID%'"
				+ " and ACQPOSVTB_TID LIKE '%_ACQPOSVTB_TID%' and ACQPOSVTB_LOAITHE LIKE '%_ACQPOSVTB_LOAITHE%' and ACQPOSVTB_SOTHEDAU LIKE '%_ACQPOSVTB_SOTHEDAU%'"
				+ " and ACQPOSVTB_SOTHECUOI LIKE '%_ACQPOSVTB_SOTHECUOI%' and ACQPOSVTB_NOIDUNGXULY LIKE '%_ACQPOSVTB_NOIDUNGXULY%'";

		sql = sql.replaceAll("_ACQPOSVTB_TRXNDATE1", txt_fromDate);
		sql = sql.replaceAll("_ACQPOSVTB_TRXNDATE2", txt_toDate);
		sql = sql.replaceAll("_ACQPOSVTB_MID", acqPosVtbMid);
		sql = sql.replaceAll("_ACQPOSVTB_TID", acqPosVtbTid);
		sql = sql.replaceAll("_ACQPOSVTB_LOAITHE", acqPosVtb_loaiThe);
		sql = sql.replaceAll("_ACQPOSVTB_SOTHEDAU", acqPosVtbsoTheDau);
		sql = sql.replaceAll("_ACQPOSVTB_SOTHECUOI", acqPosVtbsoTheCuoi);
		sql = sql.replaceAll("_ACQPOSVTB_NOIDUNGXULY", acqPosVtb_NoiDungXuLy);

		List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql);
		int count = list.size();

		if (count == 0) {
			return listPosAcqVtb;
		} else {
			for (Map<String, Object> row : list) {
				PosAcqVtb PosAcqVtb = new PosAcqVtb();
				String _acqPosVtbMid = String.valueOf(row.get("ACQPOSVTB_MID"));
				String acqPosVtbMerchantName = String.valueOf(row.get("ACQPOSVTB_MERC_NAME"));
				String _acqPosVtbTid = String.valueOf(row.get("ACQPOSVTB_TID"));
				String acqPosVtbtrxnDate = String.valueOf(row.get("ACQPOSVTB_TRXNDATE"));
				String acqPosVtbApproveCode = String.valueOf(row.get("ACQPOSVTB_APV_CDE"));
				String acqPosVtbTxnAmt = String.valueOf(row.get("ACQPOSVTB_TRXN_AMT"));
				String acqPosVtb_LoaiTien = String.valueOf(row.get("ACQPOSVTB_LOAITIEN"));
				String _acqPosVtbsoTheDau = String.valueOf(row.get("ACQPOSVTB_SOTHEDAU"));
				String _acqPosVtbsoTheCuoi = String.valueOf(row.get("ACQPOSVTB_SOTHECUOI"));
				String acqPosVtbloaiThe = String.valueOf(row.get("ACQPOSVTB_LOAITHE"));
				String _acqPosVtbPosMode = String.valueOf(row.get("ACQPOSVTB_POS_MODE"));
				String acqPosVtbBranch = String.valueOf(row.get("ACQPOSVTB_BRANCH"));
				String acqPosVtbCanBoPhuTrach = String.valueOf(row.get("ACQPOSVTB_CANBO_PHUTRACH"));
				String acqPosVtbtienDoXuLy = String.valueOf(row.get("ACQPOSVTB_TIENDOXULY"));
				String acqPosVtbtamGiuBaoCo = String.valueOf(row.get("ACQPOSVTB_TAMGIUBAOCO"));

				PosAcqVtb.setAcqPosVtbMid(_acqPosVtbMid);
				PosAcqVtb.setAcqPosVtbMerchantName(acqPosVtbMerchantName);
				PosAcqVtb.setAcqPosVtbTid(_acqPosVtbTid);
				PosAcqVtb.setAcqPosVtbtrxnDate(Integer.parseInt(acqPosVtbtrxnDate));
				PosAcqVtb.setAcqPosVtbApproveCode(acqPosVtbApproveCode);
				PosAcqVtb.setAcqPosVtbTxnAmt(acqPosVtbTxnAmt);
				PosAcqVtb.setAcqPosVtb_LoaiTien(acqPosVtb_LoaiTien);
				PosAcqVtb.setAcqPosVtbsoTheDau(_acqPosVtbsoTheDau);
				PosAcqVtb.setAcqPosVtbsoTheCuoi(_acqPosVtbsoTheCuoi);
				PosAcqVtb.setAcqPosVtbloaiThe(acqPosVtbloaiThe);
				PosAcqVtb.setAcqPosVtbPosMode(_acqPosVtbPosMode);
				PosAcqVtb.setAcqPosVtbBranch(acqPosVtbBranch);
				PosAcqVtb.setAcqPosVtbCanBoPhuTrach(acqPosVtbCanBoPhuTrach);
				PosAcqVtb.setAcqPosVtbtienDoXuLy(acqPosVtbtienDoXuLy);
				PosAcqVtb.setAcqPosVtbtamGiuBaoCo(acqPosVtbtamGiuBaoCo);

				listPosAcqVtb.add(PosAcqVtb);
			}
			return listPosAcqVtb;
		}
	}

	public void themMoiNoiDungXuLy(String userUpdate, long updateTime, String acqPosVTB_NoiDungXuLy,
			String acqPosVTB_GDBatThuong1, String acqPosVTB_GDBatThuong2, String acqPosVTB_GDBatThuong3,
			String acqPosVTB_GDBatThuong4, String acqPosVTB_GDBatThuong5, String acqPosVTB_GDBatThuong6,
			String acqPosVTB_YCXuatTrinhChungTu1, String acqPosVTB_YCXuatTrinhChungTu2,
			String acqPosVTB_YCXuatTrinhChungTu3, String acqPosVTB_YCXuatTrinhChungTu4,
			String acqPosVTB_YCXuatTrinhChungTu5, String acqPosVTB_noiDungXuLy_VS, String acqPosVTB_noiDungXuLy_MC,
			String acqPosVTB_noiDungXuLy_Khac, long updateID) {

		String sql = "INSERT into acq_pos_vtb_ndxl VALUES('ACQPOSVTB_CRE_TMS', 'ACQPOSVTB_NOIDUNGXULY', 'ACQPOSVTB_NOIDUNGXULY_KHAC', 'ACQPOSVTB_GDBATTHUONG',"
				+ "'ACQPOSVTB_YCXUATCHUNGTU', '', 'ACQPOSVTB_USER_CRE', 'ACQPOSVTB_NDXL_VS', 'ACQPOSVTB_NDXL_MC', 'ACQPOSVTB_NDXL_ID')";
		sql = sql.replaceAll("ACQPOSVTB_CRE_TMS", String.valueOf(updateTime));
		sql = sql.replaceAll("ACQPOSVTB_USER_CRE", userUpdate);
		sql = sql.replaceAll("ACQPOSVTB_NOIDUNGXULY", acqPosVTB_NoiDungXuLy);
		sql = sql.replaceAll("ACQPOSVTB_NOIDUNGXULY_KHAC", acqPosVTB_noiDungXuLy_Khac);

		String acqPosVTB_GDBatThuong = "";
		acqPosVTB_GDBatThuong += acqPosVTB_GDBatThuong1;
		acqPosVTB_GDBatThuong += " ";
		acqPosVTB_GDBatThuong += acqPosVTB_GDBatThuong2;
		acqPosVTB_GDBatThuong += " ";
		acqPosVTB_GDBatThuong += acqPosVTB_GDBatThuong3;
		acqPosVTB_GDBatThuong += " ";
		acqPosVTB_GDBatThuong += acqPosVTB_GDBatThuong4;
		acqPosVTB_GDBatThuong += " ";
		acqPosVTB_GDBatThuong += acqPosVTB_GDBatThuong5;
		acqPosVTB_GDBatThuong += " ";
		acqPosVTB_GDBatThuong += acqPosVTB_GDBatThuong6;
		sql = sql.replaceAll("ACQPOSVTB_GDBATTHUONG", acqPosVTB_GDBatThuong);

		String acqPosVTB_YCXuatTrinhChungTu = "";
		acqPosVTB_YCXuatTrinhChungTu += acqPosVTB_YCXuatTrinhChungTu1;
		acqPosVTB_YCXuatTrinhChungTu += " ";
		acqPosVTB_YCXuatTrinhChungTu += acqPosVTB_YCXuatTrinhChungTu2;
		acqPosVTB_YCXuatTrinhChungTu += " ";
		acqPosVTB_YCXuatTrinhChungTu += acqPosVTB_YCXuatTrinhChungTu3;
		acqPosVTB_YCXuatTrinhChungTu += " ";
		acqPosVTB_YCXuatTrinhChungTu += acqPosVTB_YCXuatTrinhChungTu4;
		acqPosVTB_YCXuatTrinhChungTu += " ";
		acqPosVTB_YCXuatTrinhChungTu += acqPosVTB_YCXuatTrinhChungTu5;
		sql = sql.replaceAll("ACQPOSVTB_YCXUATCHUNGTU", acqPosVTB_YCXuatTrinhChungTu);

		sql = sql.replaceAll("ACQPOSVTB_NDXL_VS", acqPosVTB_noiDungXuLy_VS);
		sql = sql.replaceAll("ACQPOSVTB_NDXL_MC", acqPosVTB_noiDungXuLy_MC);
		sql = sql.replaceAll("ACQPOSVTB_NDXL_ID", String.valueOf(updateID));

		try {
			getJdbcTemplate().update(sql);
		} catch (Exception e) {
			logger.warn("PosAcqVtbDAO, function themMoiNoiDungXuLy() error: " + e.toString());
		}
	}

	public List<PosAcqVtb> detail_acq_pos_vtb(String createTime) {
		String sql = "select * from acq_pos_vtb where ACQPOSVTB_CRE_TMS = '_ACQPOSVTB_CRE_TMS' and ROWNUM <= 1";

		sql = sql.replaceAll("_ACQPOSVTB_CRE_TMS", createTime);

		PosAcqVtb result = new PosAcqVtb();
		List<PosAcqVtb> listPosVTB = new ArrayList<PosAcqVtb>();
		List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql);
		int count = list.size();

		if (count == 0) {
			return null;
		} else {
			for (Map<String, Object> row : list) {

				String acqPosVTBNoiDungXuLy = String.valueOf(row.get("ACQPOSVTB_NOIDUNGXULY"));
				String acqPosVTBRecDate = String.valueOf(row.get("ACQPOSVTB_REC_DT"));
				String acqPosVTBThoiGianCho = String.valueOf(row.get("ACQPOSVTB_THOIGIANCHO"));
				String acqPosVTBGdGianlan = String.valueOf(row.get("ACQPOSVTB_GDGIANLAN"));
				String acqPosVTBtamGiuBaoCo = String.valueOf(row.get("ACQPOSVTB_TAMGIUBAOCO"));
				String acqPosVTBsoTienTamGiuBaoCo = String.valueOf(row.get("ACQPOSVTB_SOTIEN_TAMGIUBAOCO"));
				String acqPosVTBThoiGianTrichNo = String.valueOf(row.get("ACQPOSVTB_THOIGIANTRICHNO"));
				String acqPosVTBTinhTrangXuLy = String.valueOf(row.get("ACQPOSVTB_TINHTRANGXULY"));
				String acqPosVTBFile = String.valueOf(row.get("ACQPOSVTB_FILE"));
				String acqPosVTBtienDoXuLy = String.valueOf(row.get("ACQPOSVTB_TIENDOXULY"));
				String acqPosVTBGDBatThuong = String.valueOf(row.get("ACQPOSVTB_GDBATTHUONG"));
				String acqPosVTBYCXuatTrinhChungTu = String.valueOf(row.get("ACQPOSVTB_YCXUATCHUNGTU"));
				String acqPosVTBnoiDungXuLyKhac = String.valueOf(row.get("ACQPOSVTB_NOIDUNGXULY_KHAC"));
				String acqPosVTBloaiThe = String.valueOf(row.get("ACQPOSVTB_LOAITHE"));
				String acqPosVTBnoiDungXuLyVS = String.valueOf(row.get("ACQPOSVTB_NDXL_VS"));
				String acqPosVTBnoiDungXuLyMC = String.valueOf(row.get("ACQPOSVTB_NDXL_MC"));

				result.setAcqPosVtbNoiDungXuLy(acqPosVTBNoiDungXuLy);
				result.setAcqPosVtbRecDate(Integer.parseInt(acqPosVTBRecDate));
				result.setAcqPosVtbThoiGianCho(acqPosVTBThoiGianCho);
				result.setAcqPosVtbGdGianlan(acqPosVTBGdGianlan);
				result.setAcqPosVtbtamGiuBaoCo(acqPosVTBtamGiuBaoCo);
				result.setAcqPosVtbsoTienTamGiuBaoCo(acqPosVTBsoTienTamGiuBaoCo);
				result.setAcqPosVtbThoiGianTrichNo(Integer.parseInt(acqPosVTBThoiGianTrichNo));
				result.setAcqPosVtbTinhTrangXuLy(acqPosVTBTinhTrangXuLy);
				result.setAcqPosVtbFile(acqPosVTBFile);
				result.setAcqPosVtbtienDoXuLy(acqPosVTBtienDoXuLy);
				result.setAcqPosVtbGDBatThuong1(acqPosVTBGDBatThuong);
				result.setAcqPosVtbYCXuatTrinhChungTu1(acqPosVTBYCXuatTrinhChungTu);
				result.setAcqPosVtbnoiDungXuLyKhac(acqPosVTBnoiDungXuLyKhac);
				result.setAcqPosVtbloaiThe(acqPosVTBloaiThe);
				result.setAcqPosVtbnoiDungXuLyVS(acqPosVTBnoiDungXuLyVS);
				result.setAcqPosVtbnoiDungXuLyMC(acqPosVTBnoiDungXuLyMC);

				listPosVTB.add(result);
				return listPosVTB;
			}
		}
		return listPosVTB;
	}
}
