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
import controller.IssEbankController;
import controller.LoginController;
import entity.*;
import dao.*;

@Repository
public class IssEbankDAO extends JdbcDaoSupport {

	@Autowired
	public IssEbankDAO(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	Common common = new Common();

	@Autowired
	private CommonDAO commonDAO;
	private static final Logger logger = Logger.getLogger(IssEbankDAO.class);

	// TRUY VAN GIAO DICH DE TAO CASE
	public List<DisputesIssEb> truyVanTaoMoi_EbankIss(String input_cifNo, String input_accountNo, String input_fromDate,
			String input_toDate) {

		List<DisputesIssEb> listIssEb = new ArrayList<DisputesIssEb>();

		String sql = "SELECT * FROM sms_scb.dwh_ib_tran WHERE TO_CHAR (trn_dt, 'yyyymmdd') >= '_111'"
				+ " AND TO_CHAR (trn_dt, 'yyyymmdd') <= '_222' AND cust_id LIKE ('%_333%')"
				+ " AND to_acct LIKE ('%_444%')";

		if (input_cifNo.equals("")) {
			sql = sql.replaceAll("'_333'", "");
		} else {
			sql = sql.replaceAll("_333", input_cifNo);
		}

		if (input_accountNo.equals("")) {
			sql = sql.replaceAll("_444", "");
		} else {
			sql = sql.replaceAll("_444", input_accountNo);
		}
		sql = sql.replaceAll("_111", input_fromDate);
		sql = sql.replaceAll("_222", input_toDate);

		List<Map<String, Object>> list;
		try {
			list = getJdbcTemplate().queryForList(sql);
		} catch (Exception e) {
			logger.warn("IssEbankDAO, function truyVanTaoMoi_EbankIss() error: " + e.toString());
			return null;
		}
		// List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql);
		int count = list.size();

		if (count == 0) {
			return listIssEb;
		} else {
			int countRecords = 0;
			for (Map<String, Object> row : list) {
				DisputesIssEb issEbank = new DisputesIssEb();

				// String createTime =
				//
				String ebTxnDt = String.valueOf(row.get("TRN_DT")).replaceAll("-", "").replaceAll(" 00:00:00.0", "");
				String ebTxnChanel = String.valueOf(row.get("CHANEL_ID"));
				switch (ebTxnChanel) {
				case "01":
					ebTxnChanel = "IB";
					break;
				case "02":
					ebTxnChanel = "AUTO";
					break;
				case "03":
					ebTxnChanel = "MB";
					break;
				case "11":
					ebTxnChanel = "TQ";
					break;
				default:
					ebTxnChanel = "";
					break;
				}
				String ebFccRef = String.valueOf(row.get("TRN_REF_NO_FCC"));
				String ebCifNo = String.valueOf(row.get("CUST_ID"));
				String ebDesAcct = String.valueOf(row.get("FROM_ACCT"));
				String ebSrcAcct = String.valueOf(row.get("TO_ACCT"));

				String ebTrace = String.valueOf(row.get("TRACE_NO"));
				if (ebTrace.equals("null")) {
					ebTrace = "";
				}
				String ebTxnAmt = String.valueOf(row.get("LCY_AMOUNT"));
				String ebDesc = String.valueOf(row.get("RESP_DESC"));
				if (ebDesc.equals("null")) {
					ebDesc = "";
				}
				String ebNhph = String.valueOf(row.get("BANK_SEND"));
				String ebNhth = String.valueOf(row.get("BANK_RECEIVER"));
				if (ebNhth.equals("null")) {
					ebNhth = "";
				}
				String ebTt = String.valueOf(row.get("SCB_TRAN_TYPE"));
				if (ebTt.equals("null")) {
					ebTt = "";
				}
				String ebTxnStatus = String.valueOf(row.get("TRAN_STATUS"));
				if (ebTxnStatus.equals("00")) {
					ebTxnStatus = "Success";
				}
				String ebDvquanlytk = String.valueOf(row.get("BRANCH_CODE"));

				// ID CAU BANG GOM 21 KY TU: ebCifNo + timeStamp
				String timeStamp = String.valueOf(row.get("TIME_STAMP"));
				timeStamp = timeStamp.replaceAll("-", "");
				timeStamp = timeStamp.replaceAll(":", "");
				timeStamp = timeStamp.replaceAll(" ", "");

				// Lay ra yyyymmdd cua timeStamp
				String trxnDateOf_timeStamp = timeStamp.substring(0, 8);

				// Dinh dang lai trxnDateOf_timeStamp theo format ddmmyyyy
				String format_trxnDateOf_timeStamp = trxnDateOf_timeStamp.substring(6, 8)
						+ trxnDateOf_timeStamp.substring(4, 6) + trxnDateOf_timeStamp.substring(0, 4);

				// timeStamp: ddmmyyyhhmmss
				timeStamp = format_trxnDateOf_timeStamp + timeStamp.replaceAll(trxnDateOf_timeStamp, "");

				String ebankId = (ebCifNo + timeStamp).substring(0, 21);

				issEbank.setEbId(ebankId);
				issEbank.setEbTxnDt(Integer.parseInt(ebTxnDt));
				issEbank.setEbTxnChanel(ebTxnChanel);
				issEbank.setEbFccRef(ebFccRef);
				issEbank.setEbCifNo(ebCifNo);
				issEbank.setEbFromAcct(ebSrcAcct);
				issEbank.setEbToAcct(ebDesAcct);
				issEbank.setEbTrace(ebTrace);
				issEbank.setEbTxnAmt(ebTxnAmt);
				issEbank.setEbDesc(ebDesc);
				issEbank.setEbNhph(ebNhph);
				issEbank.setEbNhth(ebNhth);
				issEbank.setEbTt(ebTt);
				issEbank.setEbTxnStatus(ebTxnStatus);
				issEbank.setEbDvquanlytk(ebDvquanlytk);
				countRecords++;

				// LAY RA 200 ROWS DAU TIEN
				if (countRecords <= 200) {
					listIssEb.add(issEbank);
				} else {
					break;
				}
			}
		}
		return listIssEb;
	}

	// THEM MOI CASE EBANK
	public String create_eb_ychtth(String ebank_id, String username, long systemDate, String txt_lyDoTraSoatKhac,
			int ngayTiepNhan, String txt_caseID, String txt_kenhGD, String txt_lyDoTraSoat, String txt_tinhTrangCase,
			String txt_quaTrinhXuLy, String txt_phiHoTro, String txt_ghiChu, String trxnDate, String formatTrxnDate) {

		DisputesIssEb issEbank = new DisputesIssEb();
		issEbank = get_ThongTin_dwh_ib_tran(ebank_id, formatTrxnDate);

		String sql = "insert into disputes_iss_ebank_v2(EB_ID, EB_TXT_DATE, EB_PARTNER, EB_TXN_CHANNEL, EB_FCC_REF, EB_CIF, EB_FROM_ACCT, EB_TO_ACCT, EB_TRACE_NO, EB_TXN_AMT,"
				+ " EB_DESC, EB_NHPH, EB_NHTT, EB_TT, EB_STATUS, EB_DV_QLTK, EB_REC_DATE, EB_CASE_ID, EB_REASON_CODE, EB_REASON_OTHER,"
				+ " EB_CASE_STATUS, EB_PHIHOTRO, EB_NOTE, EB_PROC_PROG, EB_USER_CREATE, EB_CREATE_TIME, EB_SERVICES)"
				+ " VALUES('ebank_id', 'trxnDate', 'ebPartner', 'ebTxnChanel', 'ebFccRef', 'ebCifNo', 'ebFromAcct', 'ebToAcct', 'ebTrace',"
				+ "'ebTxnAmt', 'ebDesc', 'ebNhph', 'ebNhth', 'ebTt', 'ebStatus', 'ebDvquanlytk', 'ebRecDt', 'ebCaseId', 'txt_lyDoTraSoat', 'txt_lyDoTraSoatKhac',"
				+ " 'txt_tinhTrangCase', 'txt_phiHoTro', 'txt_ghiChu', 'txt_quaTrinhXuLy', 'username', 'systemDate', 'ebServices')";

		sql = sql.replaceAll("ebank_id", ebank_id);
		sql = sql.replaceAll("trxnDate", trxnDate);
		sql = sql.replaceAll("ebRecDt", String.valueOf(ngayTiepNhan));
		sql = sql.replaceAll("ebPartner", issEbank.getEbPartner());
		sql = sql.replaceAll("ebTxnChanel", issEbank.getEbTxnChanel());
		sql = sql.replaceAll("ebFccRef", issEbank.getEbFccRef());
		sql = sql.replaceAll("ebCifNo", issEbank.getEbCifNo());
		sql = sql.replaceAll("ebFromAcct", issEbank.getEbFromAcct());
		sql = sql.replaceAll("ebToAcct", issEbank.getEbToAcct());
		sql = sql.replaceAll("ebTrace", issEbank.getEbTrace());
		sql = sql.replaceAll("ebTxnAmt", String.valueOf(issEbank.getEbTxnAmt()));
		sql = sql.replaceAll("ebDesc", issEbank.getEbDesc());
		sql = sql.replaceAll("ebNhph", issEbank.getEbNhph());
		sql = sql.replaceAll("ebNhth", issEbank.getEbNhth());
		sql = sql.replaceAll("ebTt", issEbank.getEbTt());
		sql = sql.replaceAll("ebStatus", issEbank.getEbTxnStatus());
		sql = sql.replaceAll("ebDvquanlytk", issEbank.getEbDvquanlytk());
		sql = sql.replaceAll("ebRecDt", String.valueOf(issEbank.getEbRecDt()));
		sql = sql.replaceAll("ebCaseId", txt_caseID);
		sql = sql.replaceAll("txt_lyDoTraSoat", txt_lyDoTraSoat);
		sql = sql.replaceAll("txt_lyDoTraSoatKhac", txt_lyDoTraSoatKhac);
		sql = sql.replaceAll("txt_tinhTrangCase", txt_tinhTrangCase);
		sql = sql.replaceAll("txt_phiHoTro", txt_phiHoTro);
		sql = sql.replaceAll("txt_ghiChu", txt_ghiChu);
		sql = sql.replaceAll("txt_quaTrinhXuLy", txt_quaTrinhXuLy);
		sql = sql.replaceAll("username", username);
		sql = sql.replaceAll("txt_ghiChu", txt_ghiChu);
		sql = sql.replaceAll("systemDate", String.valueOf(systemDate));
		sql = sql.replaceAll("ebServices", issEbank.getEbServices());

		return sql;
	}

	// LAY THONG TU BANG DWH_IB_TRAN
	public DisputesIssEb get_ThongTin_dwh_ib_tran(String ebId, String formatTrxnDate) {
		String sql = "select * from sms_scb.DWH_IB_TRAN where to_char(TRN_DT, 'dd/mm/yyyy') = 'INPUT_TRN_DT' and CONCAT(CUST_ID, to_char(TIME_STAMP, 'ddmmyyyyhh24miss')) = 'INPUT_EBID'";
		sql = sql.replaceAll("INPUT_TRN_DT", formatTrxnDate);
		sql = sql.replaceAll("INPUT_EBID", ebId);

		DisputesIssEb issEbank = new DisputesIssEb();
		List<Map<String, Object>> list;
		try {
			list = getJdbcTemplate().queryForList(sql);
		} catch (Exception e) {
			logger.warn("IssEbankDAO, function get_ThongTin_dwh_ib_tran() error: " + e.toString());
			return null;
		}
		// List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql);
		int count = list.size();

		if (count == 0) {
			return null;
		} else {
			for (Map<String, Object> row : list) {
				String ebTxnDt = String.valueOf(row.get("TRN_DT")).replaceAll("-", "").replaceAll(" 00:00:00.0", "");
				String ebTxnChanel = String.valueOf(row.get("CHANEL_ID"));
				switch (ebTxnChanel) {
				case "01":
					ebTxnChanel = "IB";
					break;
				case "02":
					ebTxnChanel = "AUTO";
				case "03":
					ebTxnChanel = "MB";
				case "11":
					ebTxnChanel = "TQ";
					break;
				default:
					ebTxnChanel = "";
				}
				String ebFccRef = String.valueOf(row.get("TRN_REF_NO_FCC"));
				String ebCifNo = String.valueOf(row.get("CUST_ID"));

				String ebDesAcct = String.valueOf(row.get("FROM_ACCT"));
				String ebSrcAcct = String.valueOf(row.get("TO_ACCT"));
				String ebTrace = String.valueOf(row.get("TRACE_NO"));
				if (ebTrace.equals("null")) {
					ebTrace = "";
				}
				String ebTxnAmt = String.valueOf(row.get("LCY_AMOUNT"));
				String ebDesc = String.valueOf(row.get("TRN_DESC"));
				if (ebDesc.equals("null")) {
					ebDesc = "";
				}
				String ebNhph = String.valueOf(row.get("BANK_SEND"));
				String ebNhth = String.valueOf(row.get("BANK_RECEIVER"));
				if (ebNhth.equals("null")) {
					ebNhth = "";
				}
				String ebTt = String.valueOf(row.get("SCB_TRAN_TYPE"));
				if (ebTt.equals("null")) {
					ebTt = "";
				}
				String ebTxnStatus = String.valueOf(row.get("TRAN_STATUS"));
				if (ebTxnStatus.equals("00")) {
					ebTxnStatus = "Success";
				}
				String ebDvquanlytk = String.valueOf(row.get("BRANCH_CODE"));
				String ebPartner = String.valueOf(row.get("PARTNER_ID"));
				String ebServices = String.valueOf(row.get("SERVICE_ID"));

				issEbank.setEbId(ebId);
				issEbank.setEbTxnDt(Integer.parseInt(ebTxnDt));
				issEbank.setEbTxnChanel(ebTxnChanel);
				issEbank.setEbFccRef(ebFccRef);
				issEbank.setEbCifNo(ebCifNo);
				issEbank.setEbFromAcct(ebSrcAcct);
				issEbank.setEbToAcct(ebDesAcct);
				issEbank.setEbTrace(ebTrace);
				issEbank.setEbTxnAmt(ebTxnAmt);
				issEbank.setEbDesc(ebDesc);
				issEbank.setEbNhph(ebNhph);
				issEbank.setEbNhth(ebNhth);
				issEbank.setEbTt(ebTt);
				issEbank.setEbTxnStatus(ebTxnStatus);
				issEbank.setEbDvquanlytk(ebDvquanlytk);
				issEbank.setEbPartner(ebPartner);
				issEbank.setEbServices(ebServices);
				return issEbank;
			}
		}
		return issEbank;
	}

	// LAY THONG TIN CASE TU BANG disputes_iss_ebank_v2
	public List<DisputesIssEb> get_detail_disputes_ebank_ychtth(String ebId) {
		String sql = "select * from disputes_iss_ebank_v2 where EB_ID = 'ebId'";
		sql = sql.replaceAll("ebId", ebId);
		DisputesIssEb issEbank = new DisputesIssEb();

		List<DisputesIssEb> listIssEbank = new ArrayList<DisputesIssEb>();
		List<Map<String, Object>> list;
		try {
			list = getJdbcTemplate().queryForList(sql);
		} catch (Exception e) {
			logger.warn("IssEbankDAO, function get_detail_disputes_ebank_ychtth() error: " + e.toString());
			return null;
		}
		// List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql);
		int count = list.size();

		if (count == 0) {
			return null;
		} else {
			for (Map<String, Object> row : list) {
				String ebCustName = String.valueOf(row.get("EB_CUST_NAME"));
				String ebCifNo = String.valueOf(row.get("EB_CIF"));
				String ebFromAcct = String.valueOf(row.get("EB_FROM_ACCT"));
				String ebToAcct = String.valueOf(row.get("EB_TO_ACCT"));
				String ebUserCreate = String.valueOf(row.get("EB_USER_CREATE"));
				String ebCreateTime = String.valueOf(row.get("EB_CREATE_TIME"));
				String ebCaseId = String.valueOf(row.get("EB_CASE_ID"));
				int ebRecDt = Integer.parseInt(String.valueOf(row.get("EB_REC_DATE")));
				String ebCaseStatus = String.valueOf(row.get("EB_CASE_STATUS"));
				int ebTxnDt = Integer.parseInt(String.valueOf(row.get("EB_TXT_DATE")));
				String ebTxnAmt = String.valueOf(row.get("EB_TXN_AMT"));
				String ebDisReasonCde = String.valueOf(row.get("EB_REASON_CODE"));
				String ebProcProg = String.valueOf(row.get("EB_PROC_PROG"));
				String ebTxnChanel = String.valueOf(row.get("EB_TXN_CHANNEL"));
				String ebHinhThuc = String.valueOf(row.get("EB_HINHTHUC"));
				String ebPartner = String.valueOf(row.get("EB_PARTNER"));
				String ebServices = String.valueOf(row.get("EB_SERVICES"));
				String ebSupplier = String.valueOf(row.get("EB_SUPPLIERS"));
				String ebTrace = String.valueOf(row.get("EB_TRACE_NO"));
				String ebKqTraSoat = String.valueOf(row.get("EB_KQTRASOAT"));

				String ebNgayKetThuc = String.valueOf(row.get("EB_NGAYKETTHUC"));
				if (!ebNgayKetThuc.equals("null")) {
					issEbank.setEbNgayKetThuc(Integer.parseInt(ebNgayKetThuc));
				} else {
					issEbank.setEbNgayKetThuc(0);
				}

				String ebNgayHoanTra = String.valueOf(row.get("EB_NGAYHOANTRA"));
				if (!ebNgayHoanTra.equals("null")) {
					issEbank.setEbNgayHoanTra(Integer.parseInt(ebNgayHoanTra));
				} else {
					issEbank.setEbNgayHoanTra(0);
				}

				String ebPhiHoTro = String.valueOf(row.get("EB_PHIHOTRO"));
				if (!ebPhiHoTro.equals("null")) {
					issEbank.setEbPhiHoTro(Integer.parseInt(ebPhiHoTro));
				} else {
					issEbank.setEbNgayHoanTra(0);
				}

				String ebSoTienThuHoi = String.valueOf(row.get("EB_SOTIENTHUHOI"));
				if (!ebSoTienThuHoi.equals("null")) {
					issEbank.setEbSoTienThuHoi(Integer.parseInt(ebSoTienThuHoi));
				} else {
					issEbank.setEbSoTienThuHoi(0);
				}

				issEbank.setEbId(ebId);
				issEbank.setEbKqTraSoat(ebKqTraSoat);
				issEbank.setEbCustName(ebCustName);
				issEbank.setEbCifNo(ebCifNo);
				issEbank.setEbFromAcct(ebFromAcct);
				issEbank.setEbToAcct(ebToAcct);
				issEbank.setEbUserCreate(ebUserCreate);
				issEbank.setEbCaseId(ebCaseId);
				issEbank.setEbRecDt(ebRecDt);
				issEbank.setEbCaseStatus(ebCaseStatus);
				issEbank.setEbTxnDt(ebTxnDt);
				issEbank.setEbTxnAmt(ebTxnAmt);
				issEbank.setEbDisReasonCde(ebDisReasonCde);
				issEbank.setEbProcProg(ebProcProg);
				issEbank.setEbTxnChanel(ebTxnChanel);
				issEbank.setEbHinhThuc(ebHinhThuc);
				issEbank.setEbPartner(ebPartner);
				issEbank.setEbServices(ebServices);
				issEbank.setEbSupplier(ebSupplier);
				issEbank.setEbTrace(ebTrace);
				issEbank.setEbCreateTime(ebCreateTime);
				listIssEbank.add(issEbank);
			}
		}
		return listIssEbank;
	}

	// KIEM TRA CO CASE VOI ID LA ebId TRONG BANG disputes_iss_ebank_v2 HAY
	// KHONG?
	// COUNT = 0 => FALSE => CASE KHONG TON TAI
	// COUNT != 0 => TRUE => CASE TON TAI
	public boolean get_disputes_ebank_v2(String ebId) {
		String sql = "select * from disputes_iss_ebank_v2 where EB_ID = 'ebId'";
		sql = sql.replaceAll("ebId", ebId);
		List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql);
		int count = list.size();

		if (count == 0) {
			return false;
		}
		return true;
	}

	// THEM MOI CASE VAO BANG disputes_iss_ebank_v2
	public boolean saveDB_create_eb_ychtth(String sql) {
		try {
			getJdbcTemplate().update(sql);
		} catch (Exception e) {
			logger.warn("IssEbankDAO, function saveDB_create_eb_ychtth() error: " + e.toString());
			return false;
		}
		return true;
	}

	// Lay danh sach user create case: Su dung lai entity ThongTinKH de luu danh
	// sach CRD_USER_CRE
	public List<ThongTinKH> get_userCreateCase() {
		String sql = "select DISTINCT(EB_USER_CREATE) from disputes_iss_ebank_v2";

		List<ThongTinKH> listThongTinKH = new ArrayList<ThongTinKH>();
		List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql);
		int count = list.size();
		if (count == 0) {
			return null;
		} else {
			for (Map<String, Object> row : list) {
				ThongTinKH info = new ThongTinKH();
				String _hoTen = String.valueOf(row.get("EB_USER_CREATE"));
				info.setHoTen(_hoTen);
				listThongTinKH.add(info);
			}
		}
		return listThongTinKH;
	}

	// Lay danh sach EB_PARTNER: Su dung lai entity ThongTinKH de luu danh
	// sach EB_PARTNER
	public List<ThongTinKH> get_DoiTac() {
		String sql = "select DISTINCT(EB_PARTNER) from disputes_iss_ebank_v2";

		List<ThongTinKH> listThongTinKH = new ArrayList<ThongTinKH>();
		List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql);
		int count = list.size();
		if (count == 0) {
			return null;
		} else {
			for (Map<String, Object> row : list) {
				ThongTinKH info = new ThongTinKH();
				String _hoTen = String.valueOf(row.get("EB_PARTNER"));
				info.setHoTen(_hoTen);
				listThongTinKH.add(info);
			}
		}
		return listThongTinKH;
	}

	// Lay danh sach EB_SERVICES: Su dung lai entity ThongTinKH de luu danh
	// sach EB_SERVICES
	public List<ThongTinKH> get_DichVu() {
		String sql = "select DISTINCT(EB_SERVICES) from disputes_iss_ebank_v2 WHERE trim(EB_SERVICES) is not null";

		List<ThongTinKH> listThongTinKH = new ArrayList<ThongTinKH>();
		List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql);
		int count = list.size();
		if (count == 0) {
			return null;
		} else {
			for (Map<String, Object> row : list) {
				ThongTinKH info = new ThongTinKH();
				String _hoTen = String.valueOf(row.get("EB_SERVICES"));
				info.setHoTen(_hoTen);
				listThongTinKH.add(info);
			}
		}
		return listThongTinKH;
	}

	// TRUY VAN BANG disputes_iss_ebank_v2 CHO MUC DICH XEM CHI TIET VA UPDATE
	// CASE
	public List<DisputesIssEb> truyVanCapNhat_EbankIss(String loaiNgaySearch, String txt_fromDate, String txt_toDate,
			String txt_caseId, String txt_Cif, String txt_Channel, String txt_lyDoTraSoat, String txt_tinhTrangCase,
			String txt_ketQuaTraSoat, String txt_userCreate, String txt_Services, String txt_Partner)
			throws ParseException {
		update_CustName_PhoneNumber();
		capNhatThoiGianXuLyConLai_eb_ychtth();
		String sql = "select * from disputes_iss_ebank_v2"
				+ " where EB_TXT_DATE >= _111 and EB_TXT_DATE <= _222 and EB_REC_DATE >= _111 and EB_REC_DATE <= _222"
				+ " and EB_REASON_CODE like ('%txt_lyDoTraSoat%') and EB_CASE_ID like ('%txt_caseId%') and EB_CIF like ('%txt_Cif%') and EB_TXN_CHANNEL like ('%txt_Channel%')"
				+ " and EB_CASE_STATUS like ('%txt_tinhTrangCase%') and EB_STATUS like ('%txt_ketQuaTraSoat%')"
				+ " and EB_USER_CREATE like ('%txt_userCreate%') and EB_SERVICES like ('%txt_Services%') and EB_PARTNER like ('%txt_Partner%') and status is null";
		if (loaiNgaySearch.equals("ngayGD")) {
			sql = sql.replaceAll("and EB_REC_DATE >= _111 and EB_REC_DATE <= _222", "");
		} else {
			sql = sql.replaceAll("EB_TXT_DATE >= _111 and EB_TXT_DATE <= _222 and", "");
		}
		sql = sql.replaceAll("_111", txt_fromDate);
		sql = sql.replaceAll("_222", txt_toDate);
		sql = sql.replaceAll("txt_caseId", txt_caseId);
		sql = sql.replaceAll("txt_Cif", txt_Cif);
		sql = sql.replaceAll("txt_Channel", txt_Channel);
		sql = sql.replaceAll("txt_lyDoTraSoat", txt_lyDoTraSoat);
		sql = sql.replaceAll("txt_tinhTrangCase", txt_tinhTrangCase);
		sql = sql.replaceAll("txt_ketQuaTraSoat", txt_ketQuaTraSoat);
		sql = sql.replaceAll("txt_userCreate", txt_userCreate);
		sql = sql.replaceAll("txt_Services", txt_Services);
		sql = sql.replaceAll("txt_Partner", txt_Partner);

		List<Map<String, Object>> list;
		try {
			list = getJdbcTemplate().queryForList(sql);
		} catch (Exception e) {
			logger.warn("IssEbankDAO, function truyVanCapNhat_EbankIss() error: " + e.toString());
			return null;
		}
		// List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql);
		int count = list.size();
		List<DisputesIssEb> listIssEbank = new ArrayList<DisputesIssEb>();

		if (count == 0) {
			return listIssEbank;
		} else {
			for (Map<String, Object> row : list) {
				DisputesIssEb issEbank = new DisputesIssEb();
				String ebId = String.valueOf(row.get("EB_ID"));
				String ebRecDt = String.valueOf(row.get("EB_REC_DATE"));
				String ebCaseId = String.valueOf(row.get("EB_CASE_ID"));
				String ebCifNo = String.valueOf(row.get("EB_CIF"));
				String ebCustName = String.valueOf(row.get("EB_CUST_NAME"));
				String ebTxnChanel = String.valueOf(row.get("EB_TXN_CHANNEL"));
				String ebHinhThuc = String.valueOf(row.get("EB_HINHTHUC"));
				String ebPartner = String.valueOf(row.get("EB_PARTNER"));
				String ebServices = String.valueOf(row.get("EB_SERVICES"));
				String ebSupplier = String.valueOf(row.get("EB_SUPPLIERS"));
				String ebFromAcct = String.valueOf(row.get("EB_FROM_ACCT"));
				String ebToAcct = String.valueOf(row.get("EB_TO_ACCT"));
				String ebTxnAmt = String.valueOf(row.get("EB_TXN_AMT"));
				String ebTrace = String.valueOf(row.get("EB_TRACE_NO"));
				String ebPhiHoTro = String.valueOf(row.get("EB_PHIHOTRO"));
				String ebNhth = String.valueOf(row.get("EB_NHTT"));
				String ebDisReasonCde = String.valueOf(row.get("EB_REASON_CODE"));
				String ebCaseStatus = String.valueOf(row.get("EB_CASE_STATUS"));
				String ebCreateTime = String.valueOf(row.get("EB_CREATE_TIME"));
				String ebUserCreate = String.valueOf(row.get("EB_USER_CREATE"));
				issEbank.setEbRecDt(Integer.parseInt(ebRecDt));
				issEbank.setEbId(ebId);
				issEbank.setEbCaseId(ebCaseId);
				issEbank.setEbCifNo(ebCifNo);
				issEbank.setEbCustName(ebCustName);
				issEbank.setEbTxnChanel(ebTxnChanel);
				issEbank.setEbHinhThuc(ebHinhThuc);
				issEbank.setEbPartner(ebPartner);
				issEbank.setEbServices(ebServices);
				issEbank.setEbSupplier(ebSupplier);
				issEbank.setEbFromAcct(ebFromAcct);
				issEbank.setEbToAcct(ebToAcct);
				issEbank.setEbTxnAmt((ebTxnAmt));
				issEbank.setEbTrace(ebTrace);

				if (!ebPhiHoTro.equals("null")) {
					issEbank.setEbPhiHoTro(Double.parseDouble(ebPhiHoTro));
				}

				issEbank.setEbNhth(ebNhth);
				issEbank.setEbDisReasonCde(ebDisReasonCde);
				issEbank.setEbCaseStatus(ebCaseStatus);
				issEbank.setEbCreateTime(ebCreateTime);
				issEbank.setEbUserCreate(ebUserCreate);
				listIssEbank.add(issEbank);
			}
		}

		return listIssEbank;
	}

	// CAP NHAT DU LIEU HO TEN & SDT KH
	public void update_CustName_PhoneNumber() {
		String sql = "select trim(FX_IR056_NAME) FX_IR056_NAME, trim(FX_IR056_HP) FX_IR056_HP, trim(FX_IR056_CIF_NO) FX_IR056_CIF_NO from ir056@im where trim(FX_IR056_CIF_NO) in (select EB_CIF from disputes_iss_ebank_v2 where trim(EB_CUST_NAME) is null and trim(EB_CIF) is not null)";
		List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql);
		int count = list.size();
		if (count == 0) {
			return;
		} else {
			for (Map<String, Object> row : list) {
				String custName = String.valueOf(row.get("FX_IR056_NAME"));
				String phoneNumber = String.valueOf(row.get("FX_IR056_HP"));
				String cifno = String.valueOf(row.get("FX_IR056_CIF_NO"));
				String sqlUpdate = "update disputes_iss_ebank_v2 set EB_CUST_NAME = '_111', EB_PHONE_NUMBER = '_222' where EB_CIF = '_333'";
				sqlUpdate = sqlUpdate.replaceAll("_111", custName);
				sqlUpdate = sqlUpdate.replaceAll("_222", phoneNumber);
				sqlUpdate = sqlUpdate.replaceAll("_333", cifno);

				try {
					getJdbcTemplate().update(sqlUpdate);
				} catch (Exception e) {
					logger.warn("IssEbankDAO, function update_CustName_PhoneNumber() error: " + e.toString());
				}
			}
		}
	}

	// CAP NHAT THONG TIN CASE
	public void update_disputes_iss_ebank(String ebId, String userUpdate, String updateTimes, String ebCaseStatus,
			String ebDisReasonCde, String ebProcProg, String ebNgayKetThuc, String ebKqTraSoat, String ebNgayHoanTra,
			String ebPhiHoTro, String ebSoTienThuHoi) {

		/*
		 * BUOC1: Luu thong tin du lieu cua ebId vao bang
		 * disputes_iss_ebank_history
		 */
		String sql = "insert into disputes_iss_ebank_history (select * from disputes_iss_ebank_v2 where eb_id = '"
				+ ebId + "')";
		getJdbcTemplate().update(sql);

		/*
		 * BUOC2: Cap nhat userUpdate va updateTimes vao bang
		 * disputes_iss_ebank_history
		 */
		String updateHistory = "update disputes_iss_ebank_history set EB_USER_UPDATE = '_EB_USER_UPDATE', EB_UPDATE_TIME = '_EB_UPDATE_TIME' where eb_id = '_EB_ID'";
		updateHistory = updateHistory.replaceAll("_EB_USER_UPDATE", userUpdate);
		updateHistory = updateHistory.replaceAll("_EB_UPDATE_TIME", updateTimes);
		getJdbcTemplate().update(updateHistory);

		// BUOC3: XU LY CAP NHAT CASE CHO BANG disputes_iss_ebank_v2
		String sqlUpdate = "update disputes_iss_ebank_v2 set EB_USER_UPDATE = '_EB_USER_UPDATE', EB_UPDATE_TIME = '_EB_UPDATE_TIME',"
				+ "EB_CASE_STATUS = '_EB_CASE_STATUS', EB_REASON_CODE = '_EB_REASON_CODE', EB_PROC_PROG = '_EB_PROC_PROG',"
				+ "EB_NGAYKETTHUC = '_EB_NGAYKETTHUC', EB_KQTRASOAT = '_EB_KQTRASOAT', EB_NGAYHOANTRA = '_EB_NGAYHOANTRA',"
				+ "EB_PHIHOTRO = '_EB_PHIHOTRO', EB_SOTIENTHUHOI = '_EB_SOTIENTHUHOI' where EB_ID = '_EB_ID'";
		sqlUpdate = sqlUpdate.replaceAll("_EB_REASON_CODE", ebDisReasonCde);
		sqlUpdate = sqlUpdate.replaceAll("_EB_CASE_STATUS", ebCaseStatus);
		sqlUpdate = sqlUpdate.replaceAll("_EB_PROC_PROG", ebProcProg);
		sqlUpdate = sqlUpdate.replaceAll("_EB_USER_UPDATE", userUpdate);
		sqlUpdate = sqlUpdate.replaceAll("_EB_UPDATE_TIME", updateTimes);
		sqlUpdate = sqlUpdate.replaceAll("_EB_ID", ebId);

		if (ebCaseStatus.equals("Done")) {
			sqlUpdate = sqlUpdate.replaceAll("_EB_NGAYKETTHUC", ebNgayKetThuc);
			sqlUpdate = sqlUpdate.replaceAll("_EB_KQTRASOAT", ebKqTraSoat);
			sqlUpdate = sqlUpdate.replaceAll("_EB_NGAYHOANTRA", ebNgayHoanTra);
			sqlUpdate = sqlUpdate.replaceAll("_EB_PHIHOTRO", ebPhiHoTro);
			sqlUpdate = sqlUpdate.replaceAll("_EB_SOTIENTHUHOI", ebSoTienThuHoi);
		} else {
			sqlUpdate = sqlUpdate.replaceAll("_EB_NGAYKETTHUC", "000000");
			sqlUpdate = sqlUpdate.replaceAll("_EB_KQTRASOAT", "");
			sqlUpdate = sqlUpdate.replaceAll("_EB_NGAYHOANTRA", "000000");
			sqlUpdate = sqlUpdate.replaceAll("_EB_PHIHOTRO", "0");
			sqlUpdate = sqlUpdate.replaceAll("_EB_SOTIENTHUHOI", "0");
		}
		try {
			getJdbcTemplate().update(sqlUpdate);
		} catch (Exception e) {
			logger.warn("IssEbankDAO, function update_disputes_iss_ebank() error: " + e.toString());
		}
	}

	// CASE BI XOA SE CO STATUS = 1
	public void delete_case_eb_ychtth(String createTime) {
		String sqll = "update disputes_iss_ebank_v2 set STATUS = 1 where eb_id = '" + createTime + "'";
		try {
			getJdbcTemplate().update(sqll);
		} catch (Exception e) {
			System.out.println("LOI DELETE CASE EB YCHTTH: " + e.toString());
		}
	}

	// LAY DANH SACH CASE "CAN XU LY"
	public List<DisputesIssEb> eb_ychtth_getCaseCanXuLy() {
		String sql = "select * from disputes_iss_ebank_v2 where EB_CASE_STATUS = 'Pending' and status is null";

		List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql);
		int count = list.size();
		List<DisputesIssEb> listIssEbank = new ArrayList<DisputesIssEb>();

		if (count == 0) {
			return listIssEbank;
		} else {
			for (Map<String, Object> row : list) {
				DisputesIssEb issEbank = new DisputesIssEb();
				String ebId = String.valueOf(row.get("EB_ID"));
				String ebRecDt = String.valueOf(row.get("EB_REC_DATE"));
				String ebCaseId = String.valueOf(row.get("EB_CASE_ID"));
				String ebCifNo = String.valueOf(row.get("EB_CIF"));
				String ebCustName = String.valueOf(row.get("EB_CUST_NAME"));
				String ebTxnChanel = String.valueOf(row.get("EB_TXN_CHANNEL"));
				String ebHinhThuc = String.valueOf(row.get("EB_HINHTHUC"));
				String ebPartner = String.valueOf(row.get("EB_PARTNER"));
				String ebServices = String.valueOf(row.get("EB_SERVICES"));
				String ebSupplier = String.valueOf(row.get("EB_SUPPLIERS"));
				String ebFromAcct = String.valueOf(row.get("EB_FROM_ACCT"));
				String ebToAcct = String.valueOf(row.get("EB_TO_ACCT"));
				String ebTxnAmt = String.valueOf(row.get("EB_TXN_AMT"));
				String ebTrace = String.valueOf(row.get("EB_TRACE_NO"));
				String ebPhiHoTro = String.valueOf(row.get("EB_PHIHOTRO"));
				String ebNhth = String.valueOf(row.get("EB_NHTT"));
				String ebDisReasonCde = String.valueOf(row.get("EB_REASON_CODE"));
				String ebCaseStatus = String.valueOf(row.get("EB_CASE_STATUS"));
				String ebCreateTime = String.valueOf(row.get("EB_CREATE_TIME"));
				String ebUserCreate = String.valueOf(row.get("EB_USER_CREATE"));
				issEbank.setEbRecDt(Integer.parseInt(ebRecDt));
				issEbank.setEbId(ebId);
				issEbank.setEbCaseId(ebCaseId);
				issEbank.setEbCifNo(ebCifNo);
				issEbank.setEbCustName(ebCustName);
				issEbank.setEbTxnChanel(ebTxnChanel);
				issEbank.setEbHinhThuc(ebHinhThuc);
				issEbank.setEbPartner(ebPartner);
				issEbank.setEbServices(ebServices);
				issEbank.setEbSupplier(ebSupplier);
				issEbank.setEbFromAcct(ebFromAcct);
				issEbank.setEbToAcct(ebToAcct);
				issEbank.setEbTxnAmt(ebTxnAmt);
				issEbank.setEbTrace(ebTrace);

				if (!ebPhiHoTro.equals("null")) {
					issEbank.setEbPhiHoTro(Double.parseDouble(ebPhiHoTro));
				}

				issEbank.setEbNhth(ebNhth);
				issEbank.setEbDisReasonCde(ebDisReasonCde);
				issEbank.setEbCaseStatus(ebCaseStatus);
				issEbank.setEbCreateTime(ebCreateTime);
				issEbank.setEbUserCreate(ebUserCreate);
				listIssEbank.add(issEbank);
			}
		}

		return listIssEbank;
	}

	// LAY DS CASE DEN HAN
	public List<DisputesIssEb> eb_ychtth_getCaseDenHan() {
		String sql = "select * from disputes_iss_ebank_v2 where EB_THOIGIANXULYCONLAI >= 30 and EB_THOIGIANXULYCONLAI <= 45  and status is null";

		List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql);
		int count = list.size();
		List<DisputesIssEb> listIssEbank = new ArrayList<DisputesIssEb>();

		if (count == 0) {
			return listIssEbank;
		} else {
			for (Map<String, Object> row : list) {
				DisputesIssEb issEbank = new DisputesIssEb();
				String ebId = String.valueOf(row.get("EB_ID"));
				String ebRecDt = String.valueOf(row.get("EB_REC_DATE"));
				String ebCaseId = String.valueOf(row.get("EB_CASE_ID"));
				String ebCifNo = String.valueOf(row.get("EB_CIF"));
				String ebCustName = String.valueOf(row.get("EB_CUST_NAME"));
				String ebTxnChanel = String.valueOf(row.get("EB_TXN_CHANNEL"));
				String ebHinhThuc = String.valueOf(row.get("EB_HINHTHUC"));
				String ebPartner = String.valueOf(row.get("EB_PARTNER"));
				String ebServices = String.valueOf(row.get("EB_SERVICES"));
				String ebSupplier = String.valueOf(row.get("EB_SUPPLIERS"));
				String ebFromAcct = String.valueOf(row.get("EB_FROM_ACCT"));
				String ebToAcct = String.valueOf(row.get("EB_TO_ACCT"));
				String ebTxnAmt = String.valueOf(row.get("EB_TXN_AMT"));
				String ebTrace = String.valueOf(row.get("EB_TRACE_NO"));
				String ebPhiHoTro = String.valueOf(row.get("EB_PHIHOTRO"));
				String ebNhth = String.valueOf(row.get("EB_NHTT"));
				String ebDisReasonCde = String.valueOf(row.get("EB_REASON_CODE"));
				String ebCaseStatus = String.valueOf(row.get("EB_CASE_STATUS"));
				String ebCreateTime = String.valueOf(row.get("EB_CREATE_TIME"));
				String ebUserCreate = String.valueOf(row.get("EB_USER_CREATE"));
				issEbank.setEbRecDt(Integer.parseInt(ebRecDt));
				issEbank.setEbId(ebId);
				issEbank.setEbCaseId(ebCaseId);
				issEbank.setEbCifNo(ebCifNo);
				issEbank.setEbCustName(ebCustName);
				issEbank.setEbTxnChanel(ebTxnChanel);
				issEbank.setEbHinhThuc(ebHinhThuc);
				issEbank.setEbPartner(ebPartner);
				issEbank.setEbServices(ebServices);
				issEbank.setEbSupplier(ebSupplier);
				issEbank.setEbFromAcct(ebFromAcct);
				issEbank.setEbToAcct(ebToAcct);
				issEbank.setEbTxnAmt(ebTxnAmt);
				issEbank.setEbTrace(ebTrace);

				if (!ebPhiHoTro.equals("null")) {
					issEbank.setEbPhiHoTro(Double.parseDouble(ebPhiHoTro));
				}

				issEbank.setEbNhth(ebNhth);
				issEbank.setEbDisReasonCde(ebDisReasonCde);
				issEbank.setEbCaseStatus(ebCaseStatus);
				issEbank.setEbCreateTime(ebCreateTime);
				issEbank.setEbUserCreate(ebUserCreate);
				listIssEbank.add(issEbank);
			}
		}

		return listIssEbank;
	}

	// LAY DS CASE QUA HAN
	public List<DisputesIssEb> eb_ychtth_getCaseQuaHan() {
		String sql = "select * from disputes_iss_ebank_v2 where EB_THOIGIANXULYCONLAI > 45  and status is null";

		List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql);
		int count = list.size();
		List<DisputesIssEb> listIssEbank = new ArrayList<DisputesIssEb>();

		if (count == 0) {
			return listIssEbank;
		} else {
			for (Map<String, Object> row : list) {
				DisputesIssEb issEbank = new DisputesIssEb();
				String ebId = String.valueOf(row.get("EB_ID"));
				String ebRecDt = String.valueOf(row.get("EB_REC_DATE"));
				String ebCaseId = String.valueOf(row.get("EB_CASE_ID"));
				String ebCifNo = String.valueOf(row.get("EB_CIF"));
				String ebCustName = String.valueOf(row.get("EB_CUST_NAME"));
				String ebTxnChanel = String.valueOf(row.get("EB_TXN_CHANNEL"));
				String ebHinhThuc = String.valueOf(row.get("EB_HINHTHUC"));
				String ebPartner = String.valueOf(row.get("EB_PARTNER"));
				String ebServices = String.valueOf(row.get("EB_SERVICES"));
				String ebSupplier = String.valueOf(row.get("EB_SUPPLIERS"));
				String ebFromAcct = String.valueOf(row.get("EB_FROM_ACCT"));
				String ebToAcct = String.valueOf(row.get("EB_TO_ACCT"));
				String ebTxnAmt = String.valueOf(row.get("EB_TXN_AMT"));
				String ebTrace = String.valueOf(row.get("EB_TRACE_NO"));
				String ebPhiHoTro = String.valueOf(row.get("EB_PHIHOTRO"));
				String ebNhth = String.valueOf(row.get("EB_NHTT"));
				String ebDisReasonCde = String.valueOf(row.get("EB_REASON_CODE"));
				String ebCaseStatus = String.valueOf(row.get("EB_CASE_STATUS"));
				String ebCreateTime = String.valueOf(row.get("EB_CREATE_TIME"));
				String ebUserCreate = String.valueOf(row.get("EB_USER_CREATE"));
				issEbank.setEbRecDt(Integer.parseInt(ebRecDt));
				issEbank.setEbId(ebId);
				issEbank.setEbCaseId(ebCaseId);
				issEbank.setEbCifNo(ebCifNo);
				issEbank.setEbCustName(ebCustName);
				issEbank.setEbTxnChanel(ebTxnChanel);
				issEbank.setEbHinhThuc(ebHinhThuc);
				issEbank.setEbPartner(ebPartner);
				issEbank.setEbServices(ebServices);
				issEbank.setEbSupplier(ebSupplier);
				issEbank.setEbFromAcct(ebFromAcct);
				issEbank.setEbToAcct(ebToAcct);
				issEbank.setEbTxnAmt(ebTxnAmt);
				issEbank.setEbTrace(ebTrace);

				if (!ebPhiHoTro.equals("null")) {
					issEbank.setEbPhiHoTro(Double.parseDouble(ebPhiHoTro));
				}

				issEbank.setEbNhth(ebNhth);
				issEbank.setEbDisReasonCde(ebDisReasonCde);
				issEbank.setEbCaseStatus(ebCaseStatus);
				issEbank.setEbCreateTime(ebCreateTime);
				issEbank.setEbUserCreate(ebUserCreate);
				listIssEbank.add(issEbank);
			}
		}

		return listIssEbank;
	}

	// LAY DS CASE XU LY GAP
	public List<DisputesIssEb> eb_ychtth_getCaseXuLyGap() {
		String sql = "select * from disputes_iss_ebank_v2 where EB_CASE_STATUS = 'Gap' and status is null";

		List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql);
		int count = list.size();
		List<DisputesIssEb> listIssEbank = new ArrayList<DisputesIssEb>();

		if (count == 0) {
			return listIssEbank;
		} else {
			for (Map<String, Object> row : list) {
				DisputesIssEb issEbank = new DisputesIssEb();
				String ebId = String.valueOf(row.get("EB_ID"));
				String ebRecDt = String.valueOf(row.get("EB_REC_DATE"));
				String ebCaseId = String.valueOf(row.get("EB_CASE_ID"));
				String ebCifNo = String.valueOf(row.get("EB_CIF"));
				String ebCustName = String.valueOf(row.get("EB_CUST_NAME"));
				String ebTxnChanel = String.valueOf(row.get("EB_TXN_CHANNEL"));
				String ebHinhThuc = String.valueOf(row.get("EB_HINHTHUC"));
				String ebPartner = String.valueOf(row.get("EB_PARTNER"));
				String ebServices = String.valueOf(row.get("EB_SERVICES"));
				String ebSupplier = String.valueOf(row.get("EB_SUPPLIERS"));
				String ebFromAcct = String.valueOf(row.get("EB_FROM_ACCT"));
				String ebToAcct = String.valueOf(row.get("EB_TO_ACCT"));
				String ebTxnAmt = String.valueOf(row.get("EB_TXN_AMT"));
				String ebTrace = String.valueOf(row.get("EB_TRACE_NO"));
				String ebPhiHoTro = String.valueOf(row.get("EB_PHIHOTRO"));
				String ebNhth = String.valueOf(row.get("EB_NHTT"));
				String ebDisReasonCde = String.valueOf(row.get("EB_REASON_CODE"));
				String ebCaseStatus = String.valueOf(row.get("EB_CASE_STATUS"));
				String ebCreateTime = String.valueOf(row.get("EB_CREATE_TIME"));
				String ebUserCreate = String.valueOf(row.get("EB_USER_CREATE"));
				issEbank.setEbRecDt(Integer.parseInt(ebRecDt));
				issEbank.setEbId(ebId);
				issEbank.setEbCaseId(ebCaseId);
				issEbank.setEbCifNo(ebCifNo);
				issEbank.setEbCustName(ebCustName);
				issEbank.setEbTxnChanel(ebTxnChanel);
				issEbank.setEbHinhThuc(ebHinhThuc);
				issEbank.setEbPartner(ebPartner);
				issEbank.setEbServices(ebServices);
				issEbank.setEbSupplier(ebSupplier);
				issEbank.setEbFromAcct(ebFromAcct);
				issEbank.setEbToAcct(ebToAcct);
				issEbank.setEbTxnAmt(ebTxnAmt);
				issEbank.setEbTrace(ebTrace);

				if (!ebPhiHoTro.equals("null")) {
					issEbank.setEbPhiHoTro(Double.parseDouble(ebPhiHoTro));
				}

				issEbank.setEbNhth(ebNhth);
				issEbank.setEbDisReasonCde(ebDisReasonCde);
				issEbank.setEbCaseStatus(ebCaseStatus);
				issEbank.setEbCreateTime(ebCreateTime);
				issEbank.setEbUserCreate(ebUserCreate);
				listIssEbank.add(issEbank);
			}
		}

		return listIssEbank;
	}

	// CAP NHAT THOI GIAN XU LY CON LAI CUA CASE
	public void capNhatThoiGianXuLyConLai_eb_ychtth() throws ParseException {
		String sql = "select * from disputes_iss_ebank_v2 where EB_CASE_STATUS != 'Done'";
		List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql);
		int count = list.size();
		String sqlUpate = "update disputes_iss_ebank_v2 set EB_THOIGIANXULYCONLAI = '_111' where EB_ID = '_222'";

		if (count == 0) {
			return;
		} else {
			Common common = new Common();
			for (Map<String, Object> row : list) {
				int soNgayTroiQua = 0;
				String ebId = String.valueOf(String.valueOf(row.get("EB_ID")));
				String recDate = String.valueOf(String.valueOf(row.get("EB_REC_DATE")));
				String nam = recDate.substring(0, 4);
				String thang = recDate.substring(4, 6);
				String ngay = recDate.substring(6, 8);
				String full_RecDate = thang + "/" + ngay + "/" + nam + " 00:00:00";
				soNgayTroiQua = common.TruThoiGian(full_RecDate);
				sqlUpate = sqlUpate.replaceAll("_111", String.valueOf(soNgayTroiQua));
				sqlUpate = sqlUpate.replaceAll("_222", String.valueOf(ebId));
				try {
					getJdbcTemplate().update(sqlUpate);

					String EB_ID = "EB_ID = '" + ebId + "'";
					String EB_THOIGIANXULYCONLAI = "EB_THOIGIANXULYCONLAI = '" + soNgayTroiQua + "'";
					sqlUpate = sqlUpate.replaceAll(EB_ID, "EB_ID = '_222'");
					sqlUpate = sqlUpate.replaceAll(EB_THOIGIANXULYCONLAI, "EB_THOIGIANXULYCONLAI = '_111'");
				} catch (Exception e) {
					System.out.println("Loi update thoi gian xu ly con lai eb_ychtth: " + e.toString());
				}
			}
		}
	}

}
