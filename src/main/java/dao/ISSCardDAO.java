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
import entity.DisputesIssCard;
import entity.*;
import dao.*;

@Repository
public class ISSCardDAO extends JdbcDaoSupport {

	@Autowired
	public ISSCardDAO(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	@Autowired
	private CommonDAO commonDAO;
	private static final Logger logger = Logger.getLogger(ISSCardDAO.class);

	public List<DisputesIssCard> truyVanTheQuocTeChieuISS(String cardNo, String fromDate, String toDate) {

		List<DisputesIssCard> listIssCard = new ArrayList<DisputesIssCard>();

		String sql = "select * from "
				+ " ((select b.F9_OA008_CRE_TMS as D_CREATETIME, a.CUST_NAME, a.LOC, a.CIF, (substr(ccps.ded2(b.FX_OA008_USED_PAN, ''), 1, 6) || 'XXXXXX' || substr(ccps.ded2(b.FX_OA008_USED_PAN, ''), -4, 4)) PANMASK, b.FX_OA008_USED_PAN D_PAN, "
				+ "  b.FX_OA008_MERC_NAME D_MERNAME, a.CRD_PGM, "
				+ " b.FX_OA008_ORI_MID D_MID,   b.FX_OA008_TID D_TID,b.F9_OA008_ACQ_ICA D_ICA,   b.F9_OA008_DT D_TXNDATE, "
				+ " b.F9_OA008_ORI_AMT D_AMT,(F9_OA008_AMT_REQ + F9_OA008_LOAD_FEE + F9_OA008_SURCHRG_FEE + "
				+ " F9_OA008_SURCHRG_VAT_FEE + F9_OA008_ISS_SURCHRG_FEE + F9_OA008_ISS_SURCHRG_VAT_FEE) "
				+ " D_LOCAL_AMT, b.F9_OA008_CRNCY_CDE D_CURRENCY,b.FX_OA008_GIVEN_APV_CDE D_APPCDE, b.F9_OA008_STAN D_TRACE, "
				+ " b.FX_OA008_POS_MODE D_POSMODE, b.F9_OA008_MCC D_MCC, nvl((select 'Y'  from ccps.oa126@am where PX_OA126_PAN = b.FX_OA008_USED_PAN and P9_OA126_SEQ_NUM = b.P9_OA008_SEQ and rownum <= 1), 'N') CRD_3D_IND from fpt.ppt_emb_card_detail a, oa008@am b "
				+ " where a.PAN = b.FX_OA008_USED_PAN and b.F9_OA008_DT >= _222 and b.F9_OA008_DT <= _333)  "
				+ " UNION "
				+ " (select b.F9_OA150_CRE_TMS as D_CREATETIME, a.CUST_NAME, a.LOC, a.CIF, (substr(ccps.ded2(b.FX_OA150_USED_PAN, ''), 1, 6) || 'XXXXXX' || substr(ccps.ded2(b.FX_OA150_USED_PAN, ''), -4, 4)) PANMASK, b.FX_OA150_USED_PAN D_PAN, "
				+ "  b.FX_OA150_MERC_NAME D_MERNAME, a.CRD_PGM, "
				+ " b.FX_OA150_ORI_MID D_MID,   b.FX_OA150_TID D_TID,b.F9_OA150_ACQ_ICA D_ICA,   b.F9_OA150_DT D_TXNDATE, "
				+ " b.F9_OA150_ORI_AMT D_AMT,(F9_OA150_AMT_REQ + F9_OA150_SURCHRG_FEE + F9_OA150_SURCHRG_VAT_FEE  "
				+ " + F9_OA150_MARKUP_FEE + F9_OA150_MARKUP_VAT_FEE) "
				+ " D_LOCAL_AMT, b.F9_OA150_CRNCY_CDE D_CURRENCY,b.FX_OA150_GIVEN_APV_CDE D_APPCDE, b.F9_OA150_STAN D_TRACE, "
				+ " b.FX_OA150_POS_MODE D_POSMODE, b.F9_OA150_MCC D_MCC, nvl((select 'Y'  from ccps.oa126@am where PX_OA126_PAN = b.FX_OA150_USED_PAN and P9_OA126_SEQ_NUM = b.P9_OA150_SEQ and rownum <= 1), 'N') CRD_3D_IND from fpt.ppt_emb_card_detail a, OA150@am b "
				+ " where a.PAN = b.FX_OA150_USED_PAN and FX_OA150_CRD_BRN in ('MC', 'VS') and b.F9_OA150_DT >= _222 and b.F9_OA150_DT <= _333) "
				+ " UNION "
				+ " (select TO_NUMBER(CONCAT(b.P9_IB006_REQ_DT, CONCAT(TO_CHAR(b.F9_IB006_ACCT_NO), TO_CHAR(PX_IB006_APV_CDE)))) as D_CREATETIME,  "
				+ "a.CUST_NAME, a.LOC, a.CIF, (substr(ccps.ded2(b.FX_IB006_USED_PAN, ''), 1, 6) || 'XXXXXX' || substr(ccps.ded2(b.FX_IB006_USED_PAN, ''), -4, 4)) PANMASK, b.FX_IB006_USED_PAN D_PAN,   "
				+ "b.FX_IB006_CRD_ACCPT_NAL D_MERNAME, a.CRD_PGM, "
				+ " b.FX_IB006_ORI_MID D_MID, (select b.FX_IB007_TID from ccps.ib006@im a, ib007@im b where a.FX_IB006_USED_PAN = b.PX_IB007_PAN "
				+ "  and a.P9_IB006_REQ_DT = b.P9_IB007_REQ_DT and a.PX_IB006_APV_CDE = b.PX_IB007_APV_CDE and ROWNUM <= 1) D_TID,  "
				+ " b.F9_IB006_ISS_ICA D_ICA, b.P9_IB006_REQ_DT D_TXNDATE, "
				+ " b.F9_IB006_ORI_AMT D_AMT,(F9_IB006_AMT_REQ + F9_IB006_LOAD_FEE + F9_IB006_SURCHRG_FEE + "
				+ " F9_IB006_SURCHRG_VAT_FEE + F9_IB006_ISS_SURCHRG_FEE + F9_IB006_ISS_SURCHRG_VAT_FEE) D_LOCAL_AMT, "
				+ "  b.F9_IB006_CURR_CDE D_CURRENCY,b.FX_IB006_GIVEN_APV_CDE D_APPCDE, b.F9_IB006_STAN D_TRACE, "
				+ " '' D_POSMODE, b.F9_IB006_MCC D_MCC, nvl((select 'Y'  from ccps.oa126@am where PX_OA126_PAN = b.FX_IB006_USED_PAN and P9_OA126_SEQ_NUM = b.F9_IB006_SEQ and rownum <= 1), 'N') CRD_3D_IND from fpt.ppt_emb_card_detail a, ccps.ib006@im b "
				+ " where a.PAN = b.FX_IB006_USED_PAN and b.P9_IB006_REQ_DT >= _222 and b.P9_IB006_REQ_DT <= _333) "
				+ " UNION "
				+ " (select TO_NUMBER(CONCAT(CONCAT(TO_CHAR(b.P9_IB009_REQ_DT), TO_CHAR(b.PX_IB009_APV_CDE)), SUBSTR(b.F9_IB009_SEQ, LENGTH(F9_IB009_SEQ) - 2, LENGTH(F9_IB009_SEQ)))) as D_CREATETIME,  "
				+ " a.CUST_NAME, a.LOC, a.CIF, (substr(ccps.ded2(b.FX_IB009_USED_PAN, ''), 1, 6) || 'XXXXXX' || substr(ccps.ded2(b.FX_IB009_USED_PAN, ''), -4, 4)) PANMASK, b.FX_IB009_USED_PAN D_PAN,  b.FX_IB009_MERC_NAME D_MERNAME, a.CRD_PGM, "
				+ " b.FX_IB009_ORI_MID D_MID,   b.FX_IB009_TID D_TID,b.F9_IB009_ACQ_ICA D_ICA,   b.F9_IB009_DT D_TXNDATE, "
				+ " b.F9_IB009_ORI_AMT D_AMT,(F9_IB009_AMT_REQ + F9_IB009_SURCHRG_FEE + F9_IB009_SURCHRG_VAT_FEE  "
				+ " + F9_IB009_LOAD_FEE + F9_IB009_LOAD_VAT_FEE) "
				+ " D_LOCAL_AMT, b.F9_IB009_CRNCY_CDE D_CURRENCY,b.FX_IB009_GIVEN_APV_CDE D_APPCDE, b.F9_IB009_STAN D_TRACE, "
				+ " b.FX_IB009_POS_MODE D_POSMODE, b.F9_IB009_MCC D_MCC, nvl((select 'Y'  from ccps.oa126@am where PX_OA126_PAN = b.FX_IB009_USED_PAN and P9_OA126_SEQ_NUM = b.F9_IB009_SEQ and rownum <= 1), 'N') CRD_3D_IND from fpt.ppt_emb_card_detail a, IB009@im b "
				+ " where a.PAN = b.FX_IB009_USED_PAN and FX_IB009_CRD_BRN in ('MC', 'VS') "
				+ "  and b.F9_IB009_DT >= _222 and b.F9_IB009_DT <= _333) "
				+ " ) where D_PAN = '_111' and D_CREATETIME not in (select CRD_CRE_TMS from ccps.disputes_iss_card_v2) order by D_CREATETIME desc";

		if (cardNo.equals("")) {
			sql = sql.replaceAll("D_PAN = '_111' and", "");
		} else {
			sql = sql.replaceAll("_111", cardNo);
		}
		sql = sql.replaceAll("_222", fromDate);
		sql = sql.replaceAll("_333", toDate);

		List<Map<String, Object>> list;
		try {
			list = getJdbcTemplate().queryForList(sql);
		} catch (Exception e) {
			logger.warn("ISSCardDao, function truyVanTheQuocTeChieuISS() error: " + e.toString());
			return null;
		}

		int count = list.size();

		if (count == 0) {
			return listIssCard;
		} else {
			int countRecords = 0;
			for (Map<String, Object> row : list) {
				DisputesIssCard issCard = new DisputesIssCard();

				// issCard.setCrdCreTms(Long.parseLong(String.valueOf(row.get("D_CREATETIME"))));
				String createTime = String.valueOf(row.get("D_CREATETIME"));
				if (createTime.length() == 17) {
					createTime = createTime + "000000000";
				}
				issCard.setCrdCreTms(createTime);
				issCard.setCrdCifNo(String.valueOf(row.get("CIF")));
				issCard.setCrdCustName(String.valueOf(row.get("CUST_NAME")));
				issCard.setCrdLoc(String.valueOf(row.get("LOC")));
				issCard.setCrdPan(String.valueOf(row.get("PANMASK")));
				issCard.setCrdMercName(String.valueOf(row.get("D_MERNAME")));
				issCard.setCrdMercId(String.valueOf(row.get("D_MID")));
				issCard.setCrdTid(String.valueOf(row.get("D_TID")));
				issCard.setCrdTxnDt(Integer.parseInt(String.valueOf(row.get("D_TXNDATE"))));

				issCard.setCrdTxnAmt(Float.parseFloat(String.valueOf(row.get("D_AMT"))));
				issCard.setCrdCurrCde(String.valueOf(row.get("D_CURRENCY")));
				issCard.setIca(String.valueOf(row.get("D_ICA")));

				String CrdVndAmt = String.valueOf(row.get("D_LOCAL_AMT"));
				issCard.setCrdVndAmt(Float.parseFloat(CrdVndAmt));

				String CrdMcc = String.valueOf(row.get("D_MCC"));
				issCard.setCrdMcc(Integer.parseInt(CrdMcc));

				issCard.setCrdPosMode(String.valueOf(row.get("D_POSMODE")));
				issCard.setCrdApvCde(String.valueOf(row.get("D_APPCDE")));
				issCard.setCrdTrace(String.valueOf(row.get("D_TRACE")));
				issCard.setcrd3dIn(String.valueOf(row.get("CRD_3D_IND")));

				countRecords++;

				// CHI LAY RA 200 ROWS DAU TIEN
				if (countRecords <= 200) {
					listIssCard.add(issCard);
				} else {
					break;
				}
			}
		}
		return listIssCard;
	}

	// XU LY THE MOI CASE
	public String createCaseCreditCard_ChieuISS(String createTimeTxn, int thoiGianXuLy, String userName,
			long systemTime, String nguyenNhanKhac, int ngayTiepNhan, String caseID, String txnChannel, String cardType,
			String reasonCode, String caseStatus, String tienDoXuLy, String trxnDate) {

		// Luu case GD hien tai tu bang oa008
		String createTimeTxn_17word = createTimeTxn.replaceAll("000000000", "");
		String sql = "insert into ccps.disputes_iss_card_v2 (CRD_CRE_TMS, CRD_CUST_NAME, CRD_CARD_PROGRAM, CRD_LOC, CRD_CIF_NO,\r\n" + 
				"CRD_PAN, CRD_MERC_NAME, CRD_MERC_ID, CRD_TID, CRD_ICA, CRD_TXN_DT, CRD_PST_DT, CRD_TXN_AMT,\r\n" + 
				"CRD_CURR_CDE, CRD_VND_AMT, CRD_APV_CDE, CRD_TRACE, CRD_POS_MODE, CRD_MCC, CRD_3D_IND, CRD_REC_DT,\r\n" + 
				"CRD_CASE_ID, CRD_TXN_CHANNEL, CRD_CARD_TYPE, CRD_DIS_REASON_CDE, CRD_CASE_STATUS,\r\n" + 
				"CRD_PROC_PROG, CRD_THOIGIANXULY, CRD_USER_CRE, CRD_TIME_CRE, NGUYENNHANKHAC) \r\n" + 
				"SELECT " + createTimeTxn_17word + " ,\r\n" + 
				"a.CUST_NAME,\r\n" + 
				"a.CRD_PGM,\r\n" + 
				"a.LOC,\r\n" + 
				"a.CIF,\r\n" + 
				"FX_OA008_USED_PAN,\r\n" + 
				"FX_OA008_MERC_NAME,\r\n" + 
				"FX_OA008_ORI_MID,\r\n" + 
				"FX_OA008_TID,\r\n" + 
				"F9_OA008_ACQ_ICA,\r\n" + 
				"F9_OA008_DT,\r\n" + 
				"(select a.P9_IRC_PST_DT from ccps.irc02@im a where a.F9_IRC_LOC_ACCT = F9_OA008_ACCT_NUM and a.F9_IRC_TXN_DT = F9_OA008_DT\r\n" + 
				"and a.P9_IRC_OWN_CRN = F9_OA008_PRIN_CRN\r\n" + 
				"and a.FX_IRC_APV_CDE = FX_OA008_GIVEN_APV_CDE\r\n" + 
				"and a.F9_IRC_RCV_ICA = F9_OA008_ISS_ICA\r\n" + 
				"and rownum <= 1\r\n" + 
				") AS CRD_PST_DT,\r\n" + 
				"F9_OA008_ORI_AMT,\r\n" + 
				"F9_OA008_CRNCY_CDE,\r\n" + 
				"F9_OA008_AMT_REQ + F9_OA008_LOAD_FEE + F9_OA008_SURCHRG_FEE + F9_OA008_SURCHRG_VAT_FEE + F9_OA008_ISS_SURCHRG_FEE + F9_OA008_ISS_SURCHRG_VAT_FEE,\r\n" + 
				"FX_OA008_GIVEN_APV_CDE,\r\n" + 
				"F9_OA008_STAN,\r\n" + 
				"FX_OA008_POS_MODE,\r\n" + 
				"F9_OA008_MCC,\r\n" + 
				"nvl((select 'Y'  from ccps.oa126@am where PX_OA126_PAN = FX_OA008_USED_PAN and P9_OA126_SEQ_NUM = P9_OA008_SEQ And rownum <= 1), 'N'),\r\n" + 
				"'" + ngayTiepNhan +"','"+caseID+"','"+txnChannel+"','"+cardType+"','"+reasonCode+"','"+caseStatus+"','"+tienDoXuLy+"','"+thoiGianXuLy+"','"+userName.toUpperCase()+"','"+systemTime+"','"+nguyenNhanKhac + "'\r\n" + 
				"from fpt.ppt_emb_card_detail a, oa008@am b\r\n" + 
				"where a.PAN = b.FX_OA008_USED_PAN and F9_OA008_CRE_TMS = " + createTimeTxn_17word + " and ROWNUM <= 1";

		// Luu case GD qua khu tu bang IB006
		ThongTinKH info = getThongTinKH_GD_Credit_TrongQuaKhu(createTimeTxn, trxnDate);
		String sql2 = "insert into ccps.disputes_iss_card_v2 (CRD_CRE_TMS, CRD_CUST_NAME, CRD_CARD_PROGRAM, CRD_LOC, CRD_CIF_NO,\r\n" + 
				"CRD_PAN, CRD_MERC_NAME, CRD_MERC_ID, CRD_TID, CRD_ICA, CRD_TXN_DT, CRD_PST_DT, CRD_TXN_AMT,\r\n" + 
				"CRD_CURR_CDE, CRD_VND_AMT, CRD_APV_CDE, CRD_TRACE, CRD_MCC, CRD_3D_IND, CRD_REC_DT,\r\n" + 
				"CRD_CASE_ID, CRD_TXN_CHANNEL, CRD_CARD_TYPE, CRD_DIS_REASON_CDE, CRD_CASE_STATUS,\r\n" + 
				"CRD_PROC_PROG, CRD_THOIGIANXULY, CRD_USER_CRE, CRD_TIME_CRE, NGUYENNHANKHAC) \r\n" + 
				"SELECT " + createTimeTxn_17word + ",'" + info.getHoTen() + "','" + info.getcardProgram() + "','" + info.getLoc() + "','" + info.getCif() + "', \r\n" + 
				"FX_IB006_USED_PAN,FX_IB006_CRD_ACCPT_NAL,FX_IB006_ORI_MID,FX_IB007_TID,\r\n" + 
				"F9_IB006_ISS_ICA,P9_IB006_REQ_DT,c.P9_IRC_PST_DT,F9_IB006_ORI_AMT,F9_IB006_CURR_CDE,\r\n" + 
				"F9_IB006_AMT_REQ + F9_IB006_LOAD_FEE + F9_IB006_SURCHRG_FEE +  F9_IB006_SURCHRG_VAT_FEE + F9_IB006_ISS_SURCHRG_FEE + F9_IB006_ISS_SURCHRG_VAT_FEE AS CRD_VND_AMT,\r\n" + 
				"FX_IB006_GIVEN_APV_CDE,F9_IB006_STAN,F9_IB006_MCC,CASE WHEN PX_OA126_PAN IS NULL THEN 'N' ELSE 'Y' END CRD_3D_IND,\r\n" + 
				ngayTiepNhan + ",'" + caseID + "','" + txnChannel + "','" + cardType + "','" + reasonCode + "','" + caseStatus + "','" + tienDoXuLy + "','" + thoiGianXuLy + "','" + userName.toUpperCase() + "'," + systemTime + ",'" + nguyenNhanKhac + "'\r\n" + 
				"FROM CCPS.IB006@IM b\r\n" + 
				"LEFT JOIN ib007@im a ON b.FX_IB006_USED_PAN = a.PX_IB007_PAN and b.P9_IB006_REQ_DT = a.P9_IB007_REQ_DT  \r\n" + 
				"LEFT JOIN ccps.irc02@im c ON b.F9_IB006_ACCT_NO = c.F9_IRC_LOC_ACCT and b.P9_IB006_REQ_DT = c.F9_IRC_TXN_DT and b.F9_IB006_PRIN_CRN = c.P9_IRC_OWN_CRN and c.FX_IRC_APV_CDE = b.FX_IB006_GIVEN_APV_CDE\r\n" + 
				"LEFT JOIN ccps.oa126@am d ON PX_OA126_PAN=FX_IB006_USED_PAN AND P9_OA126_SEQ_NUM=F9_IB006_SEQ\r\n" + 
				"WHERE b.P9_IB006_REQ_DT = " + trxnDate + " \r\n" + 
				"and TO_NUMBER(CONCAT(b.P9_IB006_REQ_DT, CONCAT(TO_CHAR(b.F9_IB006_ACCT_NO), TO_CHAR(PX_IB006_APV_CDE)))) = " + createTimeTxn_17word + " and rownum <= 1";

		String logInfo = userName + " CREATE SUCCESS: CASE_ID = " + caseID + ". CREATE_TIME = " + systemTime;
		String logInfoFail = userName + " CREATE FAILED: ";

		// Kiem tra co phai GD hien tai trong bang oaOO8 hay khong?
		boolean kiemTraGDHienTai = check_GD_HienTai(createTimeTxn, trxnDate);

		// kiemTraGDHienTai = true la GD hien tai
		if (kiemTraGDHienTai == true) {
			try {
				logger.warn(logInfo);
				getJdbcTemplate().update(sql);
				return "Create case success, case id: " + caseID;
			} catch (Exception e) {
				logger.warn("ISSCardDao, function createCaseCreditCard_ChieuISS() error: " + e.toString());
				return "Create case not success, case id: " + caseID;
			}
		} else { // kiemTraGDHienTai = false la GD qua khu
			try {
				logger.warn(logInfo);
				getJdbcTemplate().update(sql2);
				return "Create case success, case id: " + caseID;
			} catch (Exception e1) {
				logger.warn(logInfoFail + e1.toString());
				logger.warn("ISSCardDao, function createCaseCreditCard_ChieuISS() error: " + e1.toString());
				return "Create case not success, case id: " + caseID;
			}
		}
	}

	// THEM MOI CASE THE THANH TOAN QUOC TE
	public String createCaseDebitCard_ChieuISS(String createTimeTxn, int thoiGianXuLy, String userName, long systemTime,
			String nguyenNhanKhac, int ngayTiepNhan, String caseID, String txnChannel, String cardType,
			String reasonCode, String caseStatus, String tienDoXuLy, String trxnDate, String soTheMaHoa) {

		// List<DisputesIssCard> listIssCard = new ArrayList<DisputesIssCard>();
		ThongTinKH info = getThongTinKH_Debit(createTimeTxn);

		String createTimeTxn_17word = createTimeTxn.replaceAll("000000000", "");
		String sql = "insert into ccps.disputes_iss_card_v2 (CRD_CRE_TMS, CRD_CUST_NAME, CRD_CARD_PROGRAM, CRD_LOC, CRD_CIF_NO,"
				+ " CRD_PAN, CRD_MERC_NAME, CRD_MERC_ID, CRD_TID, CRD_ICA, CRD_TXN_DT, CRD_PST_DT, CRD_TXN_AMT,"
				+ " CRD_CURR_CDE, CRD_VND_AMT, CRD_APV_CDE, CRD_TRACE, CRD_POS_MODE, CRD_MCC, CRD_3D_IND, CRD_REC_DT,"
				+ " CRD_CASE_ID, CRD_TXN_CHANNEL, CRD_CARD_TYPE, CRD_DIS_REASON_CDE, CRD_CASE_STATUS,"
				+ " CRD_PROC_PROG, CRD_THOIGIANXULY, CRD_USER_CRE, CRD_TIME_CRE, NGUYENNHANKHAC) " + " VALUES ("
				+ createTimeTxn_17word + ",'" + info.getHoTen() + "','" + info.getcardProgram() + "','" + info.getLoc()
				+ "','" + info.getCif() + "'," + " (select FX_OA150_USED_PAN from oa150@am where F9_oa150_CRE_TMS = "
				+ createTimeTxn_17word + " ),  " + " (select FX_oa150_MERC_NAME from oa150@am where F9_oa150_CRE_TMS = "
				+ createTimeTxn_17word + " ),  " + " (select FX_OA150_ORI_MID from oa150@am where F9_oa150_CRE_TMS = "
				+ createTimeTxn_17word + " ), " + " (select FX_oa150_TID from oa150@am where F9_oa150_CRE_TMS = "
				+ createTimeTxn_17word + " )," + " (select F9_oa150_ACQ_ICA from oa150@am where F9_oa150_CRE_TMS = "
				+ createTimeTxn_17word + " ),  " + " (select F9_oa150_DT from oa150@am where F9_oa150_CRE_TMS =  "
				+ createTimeTxn_17word + "), "
				+ " (select a.P9_IRC_PST_DT from ccps.irc02@im a, oa150@am b  where b.F9_oa150_CRE_TMS = "
				+ createTimeTxn_17word + "" + " and b.F9_oa150_ACCT_NUM = a.F9_IRC_LOC_ACCT"
				+ " and b.F9_oa150_DT = a.F9_IRC_TXN_DT and b.F9_oa150_PRIN_CRN = a.P9_IRC_OWN_CRN"
				+ " and a.FX_IRC_APV_CDE = b.FX_oa150_GIVEN_APV_CDE),"
				+ " (select F9_oa150_ORI_AMT from oa150@am where F9_oa150_CRE_TMS =    " + createTimeTxn_17word + " ),"
				+ " (select F9_OA150_CRNCY_CDE from oa150@am where F9_oa150_CRE_TMS =    " + createTimeTxn_17word
				+ " )," + " (select (F9_OA150_AMT_REQ + F9_OA150_SURCHRG_FEE + F9_OA150_SURCHRG_VAT_FEE"
				+ " + F9_OA150_MARKUP_FEE + F9_OA150_MARKUP_VAT_FEE) " + " from oa150@am where F9_oa150_CRE_TMS =  "
				+ createTimeTxn_17word + " ),  "
				+ " (select FX_oa150_GIVEN_APV_CDE from oa150@am where F9_oa150_CRE_TMS = " + createTimeTxn_17word
				+ " )," + " (select F9_oa150_STAN from oa150@am where F9_oa150_CRE_TMS = " + createTimeTxn_17word
				+ " )," + " (select FX_oa150_POS_MODE from oa150@am where F9_oa150_CRE_TMS =  " + createTimeTxn_17word
				+ " )," + " (select F9_oa150_MCC from oa150@am where F9_oa150_CRE_TMS = " + createTimeTxn_17word + "), "
				+ " nvl((select 'Y'  from ccps.oa126@am where PX_OA126_PAN = (select FX_OA150_USED_PAN from oa150@am"
				+ " where F9_OA150_CRE_TMS = " + createTimeTxn_17word + ") and P9_OA126_SEQ_NUM ="
				+ " (select P9_OA150_SEQ from oa150@am where F9_OA150_CRE_TMS = " + createTimeTxn_17word
				+ ") and rownum <= 1), 'N'), " + ngayTiepNhan + ",'" + caseID + "','" + txnChannel + "','" + cardType
				+ "','" + reasonCode + "','" + caseStatus + "','" + tienDoXuLy + "','" + thoiGianXuLy + "','"
				+ userName.toUpperCase() + "'," + systemTime + ",'" + nguyenNhanKhac + "')";

		ThongTinKH info_QuaKhu = getThongTinKH_Debit_GD_QuaKhu(createTimeTxn, trxnDate);
		String sql2 = "insert into ccps.disputes_iss_card_v2 (CRD_CRE_TMS, CRD_CUST_NAME, CRD_CARD_PROGRAM, CRD_LOC, CRD_CIF_NO, "
				+ "                CRD_PAN, CRD_MERC_NAME, CRD_MERC_ID, CRD_TID, CRD_ICA, CRD_TXN_DT, CRD_PST_DT, CRD_TXN_AMT, "
				+ "                CRD_CURR_CDE, CRD_VND_AMT, CRD_APV_CDE, CRD_TRACE, CRD_POS_MODE, CRD_MCC, CRD_3D_IND, CRD_REC_DT, "
				+ "                 CRD_CASE_ID, CRD_TXN_CHANNEL, CRD_CARD_TYPE, CRD_DIS_REASON_CDE, CRD_CASE_STATUS, "
				+ "                 CRD_PROC_PROG, CRD_THOIGIANXULYCONLAI, CRD_USER_CRE, CRD_TIME_CRE, NGUYENNHANKHAC)  "
				+ "VALUES  " + "(" + createTimeTxn_17word + ", '" + info_QuaKhu.getHoTen() + "' , '"
				+ info_QuaKhu.getcardProgram() + "', '" + info_QuaKhu.getLoc() + "', '" + info_QuaKhu.getCif() + "',  "
				+ "(SELECT FX_IB009_USED_PAN from IB009@im b where dieukien), "
				+ "(SELECT FX_IB009_MERC_NAME from IB009@im b where dieukien), "
				+ "(SELECT FX_IB009_ORI_MID from IB009@im b where dieukien), "
				+ "(SELECT FX_IB009_TID from IB009@im b where dieukien), "
				+ "(SELECT F9_IB009_ISS_ICA from IB009@im b where dieukien), "
				+ "(SELECT P9_IB009_REQ_DT from IB009@im b where dieukien), "
				+ "(select a.P9_IRC_PST_DT from ccps.irc02@im a, IB009@im b where a.FX_IRC_APV_CDE = b.FX_IB009_GIVEN_APV_CDE and b.P9_IB009_REQ_DT = a.F9_IRC_TXN_DT and b.F9_IB009_PRIN_CRN = a.P9_IRC_OWN_CRN "
				+ "and dieukien), " + "(SELECT F9_IB009_AMT_REQ from IB009@im b where dieukien), "
				+ "(SELECT F9_IB009_CRNCY_CDE from IB009@im b where dieukien), "
				+ "(SELECT (F9_IB009_AMT_REQ + F9_IB009_LOAD_FEE + F9_IB009_SURCHRG_FEE + "
				+ " F9_IB009_SURCHRG_VAT_FEE) from IB009@im b where dieukien), "
				+ "(SELECT FX_IB009_GIVEN_APV_CDE from IB009@im b where dieukien), "
				+ "(SELECT F9_IB009_STAN from IB009@im b where dieukien), '', "
				+ "(SELECT F9_IB009_MCC from IB009@im b where dieukien), "
				+ "(select NVL((select 'Y' from ccps.oa126@am where PX_OA126_PAN = (select FX_IB009_USED_PAN from IB009@im b where dieukien) and ROWNUM <= 1), 'N') from dual), "
				+ ngayTiepNhan + ",'" + caseID + "','" + txnChannel + "','" + cardType + "','" + reasonCode + "','"
				+ caseStatus + "','" + tienDoXuLy + "','" + thoiGianXuLy + "','" + userName.toUpperCase() + "',"
				+ systemTime + ",'" + nguyenNhanKhac + "')";
		sql2 = sql2.replaceAll("dieukien",
				"b.P9_IB009_REQ_DT = " + trxnDate
						+ " and (TO_NUMBER(CONCAT(CONCAT(TO_CHAR(P9_IB009_REQ_DT), TO_CHAR(PX_IB009_APV_CDE)), SUBSTR(b.F9_IB009_SEQ, LENGTH(b.F9_IB009_SEQ) - 2, LENGTH(b.F9_IB009_SEQ)))) = "
						+ createTimeTxn_17word + " and FX_IB009_USED_PAN = '" + soTheMaHoa + "' and rownum <= 1)");

		// Kiem tra co phai GD hien tai trong bang oa15O hay khong?
		boolean kiemTraGDHienTai = check_GD_Debit_HienTai(createTimeTxn, trxnDate);

		String logInfo = userName + " CREATE SUCCESS: CASE_ID = " + caseID + ". CREATE_TIME = " + systemTime;
		String logInfoFail = userName + " CREATE FAILED: ";

		// kiemTraGDHienTai = true la GD hien tai
		if (kiemTraGDHienTai == true) {
			try {
				getJdbcTemplate().update(sql);
				logger.warn(logInfo);
				return "Create case success, case id: " + caseID;
			} catch (Exception e) {
				logger.warn(logInfoFail + e.toString());
				logger.warn("ISSCardDao, function createCaseDebitCard_ChieuISS() error: " + e.toString());
				return "Create case not success, case id: " + caseID;
			}
		} else { // kiemTraGDHienTai = false la GD qua khu
			try {
				getJdbcTemplate().update(sql2);
				logger.warn(logInfo);
				return "Create case success, case id: " + caseID;
			} catch (Exception e1) {
				logger.warn(logInfoFail + e1.toString());
				logger.warn("ISSCardDao, function createCaseDebitCard_ChieuISS() error: " + e1.toString());
				return "Create case not success, case id: " + caseID;
			}
		}
	}

	// Ham kiem tra Giao dich cua the nay la VS hay MC - Credit
	public String check_MC_VS_Credit(String createTime, String trxnDate) {
		String sql = "select FX_IR121_CRD_BRN from oa008@am a, ir121@im b where F9_OA008_CRE_TMS = "
				+ createTime.replaceAll("000000000", "")
				+ " and trim(a.FX_OA008_CRD_PGM) = trim(b.PX_IR121_CRD_PGM) and F9_OA008_REQ_DT = " + trxnDate
				+ " and ROWNUM <= 1";
		String sql2 = "select FX_IR121_CRD_BRN from ir121@im a, ccps.ib006@im b"
				+ " where TO_NUMBER(CONCAT(b.P9_IB006_REQ_DT, CONCAT(TO_CHAR(b.F9_IB006_ACCT_NO), TO_CHAR(PX_IB006_APV_CDE)))) = "
				+ createTime + " and trim(a.PX_IR121_CRD_PGM) = trim(b.FX_IB006_CRD_PGM) and b.P9_IB006_REQ_DT = "
				+ trxnDate + " and rownum <= 1";
		String result = null;
		try {
			result = String.valueOf(getJdbcTemplate().queryForObject(sql, String.class));
		} catch (Exception e) {
			logger.warn("ISSCardDao, function check_MC_VS_Credit() error: " + e.toString());
		}
		if (result == null) {
			try {
				result = String.valueOf(getJdbcTemplate().queryForObject(sql2, String.class));
			} catch (Exception e) {
				logger.warn("ISSCardDao, function check_MC_VS_Credit() error: " + e.toString());
			}
		}
		return result;
	}

	// Ham kiem tra Giao dich cua the nay la VS hay MC - Debit
	public String check_MC_VS_Debit(String createTime, String trxnDate) {
		createTime = createTime.replaceAll("000000000", ""); // Loai bo
																// 000000000
																// trong
																// createTime
		String sql = "select FX_IR121_CRD_BRN from oa150@am a, ir121@im b where F9_OA150_CRE_TMS = " + createTime
				+ " and trim(a.FX_OA150_CRD_PGM) = trim(b.PX_IR121_CRD_PGM) and F9_OA150_REQ_DT = " + trxnDate;
		String sql2 = "select FX_IR121_CRD_BRN from ir121@im a, IB009@im b where TO_NUMBER(CONCAT(CONCAT(TO_CHAR(b.P9_IB009_REQ_DT), TO_CHAR(b.PX_IB009_APV_CDE)), SUBSTR(b.F9_IB009_SEQ, LENGTH(F9_IB009_SEQ) - 2, LENGTH(F9_IB009_SEQ)))) = "
				+ createTime + " and trim(a.PX_IR121_CRD_PGM) = trim(b.FX_IB009_CRD_PGM) and b.P9_IB009_REQ_DT = "
				+ trxnDate + " and rownum <= 1";
		String result = null;
		try {
			result = String.valueOf(getJdbcTemplate().queryForObject(sql, String.class));
		} catch (Exception e) {
			logger.warn("ISSCardDao, function check_MC_VS_Debit() error: " + e.toString());
		}
		if (result == null) {
			try {
				result = String.valueOf(getJdbcTemplate().queryForObject(sql2, String.class));
			} catch (Exception e) {
				logger.warn("ISSCardDao, function check_MC_VS_Debit() error: " + e.toString());
			}
		}
		return result;
	}

	// Ham kiem tra giao dich the CREDIT o hien tai hay trong qua khu
	public boolean check_GD_HienTai(String createTime, String trxnDate) {
		String sql = "select FX_OA008_USED_PAN from oa008@am where F9_OA008_REQ_DT  = " + trxnDate
				+ " and F9_OA008_CRE_TMS = " + createTime.replaceAll("000000000", "") + " and rownum <= 1";
		try {
			if (String.valueOf(getJdbcTemplate().queryForObject(sql, String.class)) != null) {
				return true;
			}
		} catch (Exception e) {
			logger.warn("ISSCardDao, function check_GD_HienTai() error: " + e.toString());
		}
		return false;
	}

	// Ham kiem tra giao dich the DEDIT o hien tai hay trong qua khu
	public boolean check_GD_Debit_HienTai(String createTime, String trxnDate) {
		String sql = "select FX_OA150_USED_PAN from oa150@am where F9_OA150_REQ_DT = " + trxnDate
				+ " and F9_OA150_CRE_TMS = " + createTime.replaceAll("000000000", "") + " and rownum <= 1";
		try {
			if (String.valueOf(getJdbcTemplate().queryForObject(sql, String.class)) != null) {
				return true;
			}
		} catch (Exception e) {
			logger.warn("ISSCardDao, function check_GD_Debit_HienTai() error: " + e.toString());
		}
		return false;
	}

	// Lay thong tin KH: Ho ten, CIF, LOC tu bang fpt.ppt_emb_card_detail
	// hoac
	// ir056/IR025

	public ThongTinKH getThongTinKH_Debit(String createTime) {
		String sql1 = "select CUST_NAME, LOC, CIF, CRD_PGM from fpt.ppt_emb_card_detail a, oa008@am b "
				+ " where b.F9_OA008_CRE_TMS = " + createTime.replaceAll("000000000", "")
				+ " and a.PAN = b.FX_OA008_USED_PAN";
		String sql2 = "select  CONCAT(CONCAT(CONCAT(CONCAT(trim(a.FX_IR025_EMB_LST_NM), ' '), "
				+ " trim(a.FX_IR025_EMB_MID_NM)), ' '), trim(a.FX_IR025_EMB_NAME)) CUST_NAME,"
				+ " F9_IR025_LOC_ACCT LOC, trim(c.FX_IR056_CIF_NO) CIF, trim(a.FX_IR025_CRD_PGM) CRD_PGM"
				+ " from IR025@im a, oa150@am b , ir056@im c" + " where a.PX_IR025_PAN = b.FX_OA150_USED_PAN "
				+ " and F9_OA150_CRE_TMS = " + createTime.replaceAll("000000000", "")
				+ " and c.P9_IR056_CRN = a.F9_IR025_CRN";
		String sql3 = "select CUST_NAME, LOC, CIF, CRD_PGM from fpt.ppt_emb_card_detail a, oa150@am b"
				+ " where b.F9_OA150_CRE_TMS = " + createTime.replaceAll("000000000", "")
				+ " and a.PAN = b.FX_OA150_USED_PAN";

		ThongTinKH info = new ThongTinKH();
		List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql1);
		int count = list.size();

		if (count == 0) {

		} else {
			for (Map<String, Object> row : list) {
				String _hoTen = String.valueOf(row.get("CUST_NAME"));
				String _cif = String.valueOf(row.get("LOC"));
				String _Loc = String.valueOf(row.get("CIF"));
				String _CardProgram = String.valueOf(row.get("CRD_PGM"));

				info.setHoTen(_hoTen);
				info.setLoc(_cif);
				info.setCif(_Loc);
				info.setcardProgram(_CardProgram);
				return info;
			}
		}

		// Neu Sql1 ko tim thay thong tin KH thi kiem tra tiep sql2
		if (info.getHoTen() == null) {
			list = getJdbcTemplate().queryForList(sql2);
			count = list.size();

			if (count == 0) {

			} else {
				for (Map<String, Object> row : list) {
					String _hoTen = String.valueOf(row.get("CUST_NAME"));
					String _cif = String.valueOf(row.get("LOC"));
					String _Loc = String.valueOf(row.get("CIF"));
					String _CardProgram = String.valueOf(row.get("CRD_PGM"));

					info.setHoTen(_hoTen);
					info.setLoc(_cif);
					info.setCif(_Loc);
					info.setcardProgram(_CardProgram);
					return info;
				}
			}
		}

		// Neu Sql2 ko tim thay thong tin KH thi kiem tra tiep sql3
		if (info.getHoTen() == null) {
			list = getJdbcTemplate().queryForList(sql3);
			count = list.size();

			if (count == 0) {
				return info;
			} else {
				for (Map<String, Object> row : list) {
					String _hoTen = String.valueOf(row.get("CUST_NAME"));
					String _cif = String.valueOf(row.get("LOC"));
					String _Loc = String.valueOf(row.get("CIF"));
					String _CardProgram = String.valueOf(row.get("CRD_PGM"));

					info.setHoTen(_hoTen);
					info.setLoc(_cif);
					info.setCif(_Loc);
					info.setcardProgram(_CardProgram);
					return info;
				}
			}
		}
		return info;
	}

	public ThongTinKH getThongTinKH_Debit_GD_QuaKhu(String createTime, String trxnDate) {
		createTime = createTime.replaceAll("000000000", "");
		String sql1 = "select CUST_NAME, LOC, CIF, CRD_PGM from fpt.ppt_emb_card_detail a, IB009@im b where a.PAN = b.FX_IB009_USED_PAN and b.P9_IB009_REQ_DT = "
				+ trxnDate
				+ " and (TO_NUMBER(CONCAT(CONCAT(TO_CHAR(b.P9_IB009_REQ_DT), TO_CHAR(b.PX_IB009_APV_CDE)), SUBSTR(b.F9_IB009_SEQ, LENGTH(b.F9_IB009_SEQ) - 2, LENGTH(b.F9_IB009_SEQ)))) = "
				+ createTime + " and rownum <= 1)";
		String sql2 = "select CONCAT(CONCAT(CONCAT(CONCAT(trim(a.FX_IR025_EMB_LST_NM), ' '), trim(a.FX_IR025_EMB_MID_NM)), ' '), trim(a.FX_IR025_EMB_NAME)) CUST_NAME, F9_IR025_LOC_ACCT LOC, trim(c.FX_IR056_CIF_NO) CIF, trim(a.FX_IR025_CRD_PGM) CRD_PGM from IR025@im a, IB009@im b , ir056@im c where a.PX_IR025_PAN = b.FX_IB009_USED_PAN and c.P9_IR056_CRN = a.F9_IR025_CRN and b.P9_IB009_REQ_DT = "
				+ trxnDate
				+ " and (TO_NUMBER(CONCAT(CONCAT(TO_CHAR(b.P9_IB009_REQ_DT), TO_CHAR(b.PX_IB009_APV_CDE)), SUBSTR(b.F9_IB009_SEQ, LENGTH(b.F9_IB009_SEQ) - 2, LENGTH(b.F9_IB009_SEQ)))) = "
				+ createTime + " and rownum <= 1)";
		String sql3 = "select CUST_NAME, LOC, CIF, CRD_PGM from fpt.ppt_emb_card_detail a, IB009@am b where a.PAN = b.FX_IB009_USED_PAN and b.P9_IB009_REQ_DT = "
				+ trxnDate
				+ " and(TO_NUMBER(CONCAT(CONCAT(TO_CHAR(b.P9_IB009_REQ_DT), TO_CHAR(b.PX_IB009_APV_CDE)), SUBSTR(b.F9_IB009_SEQ, LENGTH(b.F9_IB009_SEQ) - 2, LENGTH(b.F9_IB009_SEQ)))) = "
				+ createTime + " and rownum <= 1)";

		ThongTinKH info = new ThongTinKH();
		List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql1);
		int count = list.size();

		if (count == 0) {

		} else {
			for (Map<String, Object> row : list) {
				String _hoTen = String.valueOf(row.get("CUST_NAME"));
				String _cif = String.valueOf(row.get("LOC"));
				String _Loc = String.valueOf(row.get("CIF"));
				String _CardProgram = String.valueOf(row.get("CRD_PGM"));

				info.setHoTen(_hoTen);
				info.setLoc(_cif);
				info.setCif(_Loc);
				info.setcardProgram(_CardProgram);
				return info;
			}
		}

		// Neu Sql1 ko tim thay thong tin KH thi kiem tra tiep sql2
		if (info.getHoTen() == null) {
			list = getJdbcTemplate().queryForList(sql2);
			count = list.size();

			if (count == 0) {

			} else {
				for (Map<String, Object> row : list) {
					String _hoTen = String.valueOf(row.get("CUST_NAME"));
					String _cif = String.valueOf(row.get("LOC"));
					String _Loc = String.valueOf(row.get("CIF"));
					String _CardProgram = String.valueOf(row.get("CRD_PGM"));

					info.setHoTen(_hoTen);
					info.setLoc(_cif);
					info.setCif(_Loc);
					info.setcardProgram(_CardProgram);
					return info;
				}
			}
		}

		// Neu Sql2 ko tim thay thong tin KH thi kiem tra tiep sql3
		if (info.getHoTen() == null) {
			list = getJdbcTemplate().queryForList(sql3);
			count = list.size();

			if (count == 0) {
				return info;
			} else {
				for (Map<String, Object> row : list) {
					String _hoTen = String.valueOf(row.get("CUST_NAME"));
					String _cif = String.valueOf(row.get("LOC"));
					String _Loc = String.valueOf(row.get("CIF"));
					String _CardProgram = String.valueOf(row.get("CRD_PGM"));

					info.setHoTen(_hoTen);
					info.setLoc(_cif);
					info.setCif(_Loc);
					info.setcardProgram(_CardProgram);
					return info;
				}
			}
		}
		return info;
	}

	public ThongTinKH getThongTinKH_GD_Credit_TrongQuaKhu(String createTime, String trxnDate) {
		String sql = "select a.CUST_NAME, a.CRD_PGM, a.LOC, a.CIF "
				+ "from fpt.ppt_emb_card_detail a, ccps.ib006@im b  "
				+ "where a.PAN = b.FX_IB006_USED_PAN and  b.P9_IB006_REQ_DT = " + trxnDate
				+ " and (TO_NUMBER(CONCAT(b.P9_IB006_REQ_DT, CONCAT(TO_CHAR(b.F9_IB006_ACCT_NO), TO_CHAR(PX_IB006_APV_CDE)))) = "
				+ createTime + " and rownum <= 1)";
		ThongTinKH info = new ThongTinKH();
		List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql);
		int count = list.size();
		if (count == 0) {

		} else {
			for (Map<String, Object> row : list) {
				String _hoTen = String.valueOf(row.get("CUST_NAME"));
				String _cif = String.valueOf(row.get("LOC"));
				String _Loc = String.valueOf(row.get("CIF"));
				String _CardProgram = String.valueOf(row.get("CRD_PGM"));

				info.setHoTen(_hoTen);
				info.setLoc(_cif);
				info.setCif(_Loc);
				info.setcardProgram(_CardProgram);
				return info;
			}
		}
		return info;
	}

	// Lay danh sach user create case: Su dung lai entity ThongTinKH de luu danh
	// sach CRD_USER_CRE
	public List<ThongTinKH> get_userCreateCase() {
		String sql = "select DISTINCT(CRD_USER_CRE) from ccps.disputes_iss_card_v2";

		List<ThongTinKH> listThongTinKH = new ArrayList<ThongTinKH>();
		List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql);
		int count = list.size();
		if (count == 0) {
			return null;
		} else {
			for (Map<String, Object> row : list) {
				ThongTinKH info = new ThongTinKH();
				String _hoTen = String.valueOf(row.get("CRD_USER_CRE"));
				info.setHoTen(_hoTen);
				listThongTinKH.add(info);
			}
		}
		return listThongTinKH;
	}

	public List<DisputesIssCard> truyVanTable_disputes_iss_card(String loaiNgaySearch, String fromDate, String toDate,
			String caseId, String cifNo, String trxnChannel, String reasonCode, String caseStatus, String userCreate,
			String kqTraSoat, String loaiThe) {
		capNhat_XuLy_DuLieu_Null();
		List<DisputesIssCard> listIssCard = new ArrayList<DisputesIssCard>();

		String sql = "select CRD_CRE_TMS, CRD_REC_DT, CRD_CASE_ID, CRD_CUST_NAME, CRD_LOC, CRD_CIF_NO, (SELECT PX_IRPANMAP_PANMASK FROM ccps.ir_pan_map@im where px_irpanmap_pan = CRD_PAN) SO_THE_FULL,"
				+ " CRD_CARD_TYPE, CRD_TXN_CHANNEL, CRD_PROC_PROG, CRD_MERC_NAME, CRD_MERC_ID, CRD_TID, CRD_TXN_DT, CRD_PST_DT, CRD_TXN_AMT, CRD_CURR_CDE, CRD_VND_AMT, CRD_APV_CDE, CRD_TRACE,"
				+ " CRD_POS_MODE, CRD_ICA, CRD_3D_IND, CRD_DIS_REASON_CDE, CRD_CASE_STATUS, CRD_THOIGIANXULYCONLAI,"
				+ " CRD_USER_CRE, CRD_MCC, NGUYENNHANKHAC, CRD_ARN, CB_NGAY_TXT, CB_THOIGIANCONLAI_TXT, PRE_AR_NGAYPHANHOI, PRE_AR_THOIGIANCONLAI from ccps.disputes_iss_card_v2 where CRD_TXN_DT >= _111_ and CRD_TXN_DT <= _1111 and CRD_REC_DT >= _222_ and CRD_REC_DT <= _2222 and CRD_CASE_ID = '_333'"
				+ " and CRD_CIF_NO = '_444' and CRD_TXN_CHANNEL = '_555' and CRD_DIS_REASON_CDE = '_666'"
				+ " and CRD_CASE_STATUS = '_777' and CRD_USER_CRE = '_888'  and CRD_CARD_TYPE = '_1000' and CRD_CARD_TYPE != 'LOCAL DEBIT' and STATUS is null order by CRD_REC_DT desc ";

		if (loaiNgaySearch.equals("ngayGD")) {
			sql = sql.replaceAll("_111_", fromDate);
			sql = sql.replaceAll("_1111", toDate);
			sql = sql.replaceAll("CRD_REC_DT >= _222_ and ", "");
			sql = sql.replaceAll("CRD_REC_DT <= _2222 and ", "");
		} else {
			sql = sql.replaceAll("_222_", fromDate);
			sql = sql.replaceAll("_2222", toDate);
			sql = sql.replaceAll("CRD_TXN_DT >= _111_ and ", "");
			sql = sql.replaceAll("CRD_TXN_DT <= _1111 and ", "");
		}

		// caseId
		if (caseId.equals("")) {
			sql = sql.replaceAll("and CRD_CASE_ID = '_333'", "");
		} else {
			sql = sql.replaceAll("_333", caseId);
		}
		// cifNo
		if (cifNo.equals("")) {
			sql = sql.replaceAll("and CRD_CIF_NO = '_444'", "");
		} else {
			sql = sql.replaceAll("_444", cifNo);
		}
		// trxnChannel
		if (trxnChannel.equals("")) {
			sql = sql.replaceAll("and CRD_TXN_CHANNEL = '_555'", "");
		} else {
			sql = sql.replaceAll("_555", trxnChannel);
		}
		// reasonCode
		if (reasonCode.equals("")) {
			sql = sql.replaceAll("and CRD_DIS_REASON_CDE = '_666'", "");
		} else {
			sql = sql.replaceAll("_666", reasonCode);
		}
		// caseStatus
		if (caseStatus.equals("")) {
			sql = sql.replaceAll("and CRD_CASE_STATUS = '_777'", "");
		} else {
			sql = sql.replaceAll("_777", caseStatus);
		}
		// userCreate
		if (userCreate.equals("")) {
			sql = sql.replaceAll("and CRD_USER_CRE = '_888'", "");
		} else {
			sql = sql.replaceAll("_888", userCreate);
		}

		// // kqTraSoat: and DONE_RESULT = '_999'
		// if (kqTraSoat.equals("")) {
		// sql = sql.replaceAll("and DONE_RESULT = '_999'", "");
		// } else {
		// sql = sql.replaceAll("_999", kqTraSoat);
		// }

		// loaiThe
		if (loaiThe.equals("")) {
			sql = sql.replaceAll("and CRD_CARD_TYPE = '_1000'", "");
		} else {
			sql = sql.replaceAll("_1000", loaiThe);
		}

		//
		sql = sql.replaceAll("= 'null'", "like ('%')");

		List<Map<String, Object>> list;
		try {
			list = getJdbcTemplate().queryForList(sql);
		} catch (Exception e) {
			logger.warn("ISSCardDao, function truyVanTable_disputes_iss_card() error: " + e.toString());
			return null;
		}

		int count = list.size();

		if (count == 0) {
			return listIssCard;
		} else {
			for (Map<String, Object> row : list) {
				DisputesIssCard issCard = new DisputesIssCard();

				// issCard.setCrdCreTms(Long.parseLong(String.valueOf(row.get("CRD_CRE_TMS"))));
				issCard.setCrdCreTms(String.valueOf(row.get("CRD_CRE_TMS")));
				issCard.setCrdRecDt(Integer.parseInt(String.valueOf(row.get("CRD_REC_DT"))));
				issCard.setCrdCaseId(String.valueOf(row.get("CRD_CASE_ID")));
				issCard.setCrdCustName(String.valueOf(row.get("CRD_CUST_NAME")));
				issCard.setCrdLoc(String.valueOf(row.get("CRD_LOC")));
				issCard.setCrdCifNo(String.valueOf(row.get("CRD_CIF_NO")));
				issCard.setCrdPan(String.valueOf(row.get("SO_THE_FULL")));

				String cardType = String.valueOf(row.get("CRD_CARD_TYPE"));
				issCard.setCrdCrdType(cardType);
				issCard.setcrdTrxnChannel(String.valueOf(row.get("CRD_TXN_CHANNEL")));
				issCard.setCrdMercName(String.valueOf(row.get("CRD_MERC_NAME")));
				issCard.setCrdMercId(String.valueOf(row.get("CRD_MERC_ID")));
				issCard.setCrdTid(String.valueOf(row.get("CRD_TID")));
				issCard.setIca(String.valueOf(row.get("CRD_ICA")));
				issCard.setCrdTxnDt(Integer.parseInt(String.valueOf(row.get("CRD_TXN_DT"))));
				String postingDate = String.valueOf(row.get("CRD_PST_DT"));
				if (!postingDate.equals("null")) {
					issCard.setCrdPstDt(Integer.parseInt(postingDate));
				}
				issCard.setCrdTxnAmt(Float.parseFloat(String.valueOf(row.get("CRD_TXN_AMT"))));
				issCard.setCrdCurrCde(String.valueOf(row.get("CRD_CURR_CDE")));
				issCard.setCrdVndAmt(Float.parseFloat(String.valueOf(row.get("CRD_VND_AMT"))));
				issCard.setCrdApvCde(String.valueOf(row.get("CRD_APV_CDE")));
				issCard.setCrdTrace(String.valueOf(row.get("CRD_TRACE")));
				issCard.setCrdPosMode(String.valueOf(row.get("CRD_POS_MODE")));
				issCard.setcrd3dIn(String.valueOf(row.get("CRD_3D_IND")));
				issCard.setCrdMcc(Integer.parseInt(String.valueOf(row.get("CRD_MCC"))));
				issCard.setCrdDisReasonCde(String.valueOf(row.get("CRD_DIS_REASON_CDE")));
				issCard.setCrdCaseStatus(String.valueOf(row.get("CRD_CASE_STATUS")));

				String CbNgayTxt = String.valueOf(row.get("CB_NGAY_TXT"));
				if (!CbNgayTxt.equals("null")) {
					issCard.setCbNgayTxt(Integer.parseInt(CbNgayTxt));
					String CB_THOIGIANCONLAI_TXT = String.valueOf(row.get("CB_THOIGIANCONLAI_TXT"));
					if (!"null".equals(CB_THOIGIANCONLAI_TXT)) {
						issCard.setCbThoigianconlaiTxt(Integer.parseInt(CB_THOIGIANCONLAI_TXT));
					}
				}

				String PreArDate = String.valueOf(row.get("PRE_AR_NGAYPHANHOI"));
				if (!PreArDate.equals("null") && (cardType.equals("VS CREDIT") || cardType.equals("VS DEBIT"))) {
					issCard.setPreArNgayphanhoi(Integer.parseInt(PreArDate));
					issCard.setPreArThoigianconlai(Integer.parseInt(String.valueOf(row.get("PRE_AR_THOIGIANCONLAI"))));
				}

				String thoiGianXuLyConLai = String.valueOf(row.get("CRD_THOIGIANXULYCONLAI"));
				if (!thoiGianXuLyConLai.equals("null")) {
					issCard.setcrdThoiGianXuLyConLai(Integer.parseInt(thoiGianXuLyConLai));
				}

				issCard.setcrdUserCreate(String.valueOf(row.get("CRD_USER_CRE")));
				issCard.setnguyennhankhac(String.valueOf(row.get("NGUYENNHANKHAC")));
				issCard.setCrdProcProg(String.valueOf(row.get("CRD_PROC_PROG")));
				issCard.setCrdArn(String.valueOf(row.get("CRD_ARN")));
				listIssCard.add(issCard);
			}
		}
		return listIssCard;
	}

	public List<DisputesIssCard> truyVanTable_disputes_local_card(String loaiNgaySearch, String fromDate, String toDate,
			String caseId, String cifNo, String traceCode, String reasonCode, String caseStatus, String kqTraSoat) {
		capNhatPostingDate();
		List<DisputesIssCard> listIssCard = new ArrayList<DisputesIssCard>();

		String sql = "select CRD_CRE_TMS, CRD_REC_DT, CRD_CASE_ID, CRD_CUST_NAME, CRD_LOC, CRD_CIF_NO,  "
				+ "(SELECT PX_IRPANMAP_PANMASK FROM ccps.ir_pan_map@im where px_irpanmap_pan = CRD_PAN) SO_THE_FULL,"
				+ " CRD_PROC_PROG, CRD_MERC_NAME, CRD_TID, CRD_TXN_DT, CRD_TXN_AMT, CRD_APV_CDE, CRD_TRACE,"
				+ " CRD_DIS_REASON_CDE, CRD_CASE_STATUS, CRD_THOIGIANXULYCONLAI, NGUYENNHANKHAC  "
				+ " from ccps.disputes_iss_card_v2  "
				+ " where CRD_TXN_DT >= _111_ and CRD_TXN_DT <= _1111 and CRD_REC_DT >= _222_ and CRD_REC_DT <= _2222 and CRD_CASE_ID = '_333' "
				+ " and CRD_CIF_NO = '_444' and CRD_TRACE = '_555' and CRD_DIS_REASON_CDE = '_666' "
				+ " and CRD_CASE_STATUS = '_777' and DONE_RESULT = '_888' and CRD_CARD_TYPE = 'LOCAL DEBIT' order by CRD_REC_DT desc "
				+ "";

		if (loaiNgaySearch.equals("ngayGD")) {
			sql = sql.replaceAll("_111_", fromDate);
			sql = sql.replaceAll("_1111", toDate);
			sql = sql.replaceAll("CRD_REC_DT >= _222_ and ", "");
			sql = sql.replaceAll("CRD_REC_DT <= _2222 and ", "");
		} else {
			sql = sql.replaceAll("_222_", fromDate);
			sql = sql.replaceAll("_2222", toDate);
			sql = sql.replaceAll("CRD_TXN_DT >= _111_ and ", "");
			sql = sql.replaceAll("CRD_TXN_DT <= _1111 and ", "");
		}

		// caseId
		if (caseId.equals("")) {
			sql = sql.replaceAll("and CRD_CASE_ID = '_333'", "");
		} else {
			sql = sql.replaceAll("_333", caseId);
		}
		// cifNo
		if (cifNo.equals("")) {
			sql = sql.replaceAll("and CRD_CIF_NO = '_444'", "");
		} else {
			sql = sql.replaceAll("_444", cifNo);
		}

		// CRD_TRACE
		if (reasonCode.equals("")) {
			sql = sql.replaceAll("and CRD_TRACE = '_555'", "");
		} else {
			sql = sql.replaceAll("_555", traceCode);
		}
		// CRD_DIS_REASON_CDE
		if (reasonCode.equals("")) {
			sql = sql.replaceAll("and CRD_DIS_REASON_CDE = '_666'", "");
		} else {
			sql = sql.replaceAll("_666", reasonCode);
		}
		// caseStatus
		if (caseStatus.equals("")) {
			sql = sql.replaceAll("and CRD_CASE_STATUS = '_777'", "");
		} else {
			sql = sql.replaceAll("_777", caseStatus);
		}

		// kqTraSoat
		if (kqTraSoat.equals("")) {
			sql = sql.replaceAll("and DONE_RESULT = '_888'", "");
		} else {
			sql = sql.replaceAll("_888", kqTraSoat);
		}

		List<Map<String, Object>> list;
		try {
			list = getJdbcTemplate().queryForList(sql);
		} catch (Exception e) {
			logger.warn("ISSCardDao, function truyVanTable_disputes_local_card() error: " + e.toString());
			return null;
		}
		int count = list.size();

		if (count == 0) {
			return listIssCard;
		} else {
			for (Map<String, Object> row : list) {
				DisputesIssCard issCard = new DisputesIssCard();

				// issCard.setCrdCreTms(Long.parseLong(String.valueOf(row.get("CRD_CRE_TMS"))));
				issCard.setCrdCreTms(String.valueOf(row.get("CRD_CRE_TMS")));
				issCard.setCrdRecDt(Integer.parseInt(String.valueOf(row.get("CRD_REC_DT"))));
				issCard.setCrdCaseId(String.valueOf(row.get("CRD_CASE_ID")));
				issCard.setCrdCustName(String.valueOf(row.get("CRD_CUST_NAME")));
				issCard.setCrdLoc(String.valueOf(row.get("CRD_LOC")));
				issCard.setCrdCifNo(String.valueOf(row.get("CRD_CIF_NO")));
				issCard.setCrdPan(String.valueOf(row.get("SO_THE_FULL")));
				issCard.setCrdProcProg(String.valueOf(row.get("CRD_PROC_PROG")));
				issCard.setCrdMercName(String.valueOf(row.get("CRD_MERC_NAME")));
				issCard.setCrdTid(String.valueOf(row.get("CRD_TID")));
				issCard.setCrdTxnDt(Integer.parseInt(String.valueOf(row.get("CRD_TXN_DT"))));
				issCard.setCrdTxnAmt(Float.parseFloat(String.valueOf(row.get("CRD_TXN_AMT"))));
				issCard.setCrdApvCde(String.valueOf(row.get("CRD_APV_CDE")));
				issCard.setCrdTrace(String.valueOf(row.get("CRD_TRACE")));
				issCard.setCrdDisReasonCde(String.valueOf(row.get("CRD_DIS_REASON_CDE")));
				issCard.setCrdCaseStatus(String.valueOf(row.get("CRD_CASE_STATUS")));
				issCard.setnguyennhankhac(String.valueOf(row.get("NGUYENNHANKHAC")));
				String thoiGianXuLyConLai = String.valueOf(row.get("CRD_THOIGIANXULYCONLAI"));
				if (!thoiGianXuLyConLai.equals("null")) {
					issCard.setcrdThoiGianXuLyConLai(Integer.parseInt(thoiGianXuLyConLai));
				}
				listIssCard.add(issCard);
			}
		}
		return listIssCard;
	}

	public List<DisputesIssCard> theQuocTe_getCaseCanXuLy() {
		List<DisputesIssCard> listIssCard = new ArrayList<DisputesIssCard>();

		String sql = "select CRD_CRE_TMS, CRD_REC_DT, CRD_CASE_ID, CRD_CUST_NAME, CRD_LOC, CRD_CIF_NO, (SELECT PX_IRPANMAP_PANMASK FROM ccps.ir_pan_map@im where px_irpanmap_pan = CRD_PAN) SO_THE_FULL,"
				+ " CRD_CARD_TYPE, CRD_TXN_CHANNEL, CRD_PROC_PROG, CRD_MERC_NAME, CRD_MERC_ID, CRD_TID, CRD_TXN_DT, CRD_PST_DT, CRD_TXN_AMT, CRD_CURR_CDE, CRD_VND_AMT, CRD_APV_CDE, CRD_TRACE,"
				+ " CRD_POS_MODE, CRD_ICA, CRD_3D_IND, CRD_DIS_REASON_CDE, CRD_CASE_STATUS, CRD_THOIGIANXULYCONLAI,"
				+ " CRD_USER_CRE, CRD_MCC, NGUYENNHANKHAC from ccps.disputes_iss_card_v2 where CRD_CASE_STATUS = 'Pending' and CRD_CASE_STATUS != 'Done' order by CRD_REC_DT desc";

		List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql);
		int count = list.size();

		if (count == 0) {
			return listIssCard;
		} else {
			for (Map<String, Object> row : list) {
				DisputesIssCard issCard = new DisputesIssCard();

				// issCard.setCrdCreTms(Long.parseLong(String.valueOf(row.get("CRD_CRE_TMS"))));
				issCard.setCrdCreTms(String.valueOf(row.get("CRD_CRE_TMS")));
				issCard.setCrdRecDt(Integer.parseInt(String.valueOf(row.get("CRD_REC_DT"))));
				issCard.setCrdCaseId(String.valueOf(row.get("CRD_CASE_ID")));
				issCard.setCrdCustName(String.valueOf(row.get("CRD_CUST_NAME")));
				issCard.setCrdLoc(String.valueOf(row.get("CRD_LOC")));
				issCard.setCrdCifNo(String.valueOf(row.get("CRD_CIF_NO")));
				issCard.setCrdPan(String.valueOf(row.get("SO_THE_FULL")));
				issCard.setCrdCrdType(String.valueOf(row.get("CRD_CARD_TYPE")));
				issCard.setcrdTrxnChannel(String.valueOf(row.get("CRD_TXN_CHANNEL")));
				issCard.setCrdMercName(String.valueOf(row.get("CRD_MERC_NAME")));
				issCard.setCrdMercId(String.valueOf(row.get("CRD_MERC_ID")));
				issCard.setCrdTid(String.valueOf(row.get("CRD_TID")));
				issCard.setIca(String.valueOf(row.get("CRD_ICA")));
				issCard.setCrdTxnDt(Integer.parseInt(String.valueOf(row.get("CRD_TXN_DT"))));
				String postingDate = String.valueOf(row.get("CRD_PST_DT"));
				if (!postingDate.equals("null")) {
					issCard.setCrdPstDt(Integer.parseInt(postingDate));
				}
				issCard.setCrdTxnAmt(Float.parseFloat(String.valueOf(row.get("CRD_TXN_AMT"))));
				issCard.setCrdCurrCde(String.valueOf(row.get("CRD_CURR_CDE")));
				issCard.setCrdVndAmt(Float.parseFloat(String.valueOf(row.get("CRD_VND_AMT"))));
				issCard.setCrdApvCde(String.valueOf(row.get("CRD_APV_CDE")));
				issCard.setCrdTrace(String.valueOf(row.get("CRD_TRACE")));
				issCard.setCrdPosMode(String.valueOf(row.get("CRD_POS_MODE")));
				issCard.setcrd3dIn(String.valueOf(row.get("CRD_3D_IND")));
				issCard.setCrdMcc(Integer.parseInt(String.valueOf(row.get("CRD_MCC"))));
				issCard.setCrdDisReasonCde(String.valueOf(row.get("CRD_DIS_REASON_CDE")));
				issCard.setCrdCaseStatus(String.valueOf(row.get("CRD_CASE_STATUS")));

				String thoiGianXuLyConLai = String.valueOf(row.get("CRD_THOIGIANXULYCONLAI"));
				if (!thoiGianXuLyConLai.equals("null")) {
					issCard.setcrdThoiGianXuLyConLai(Integer.parseInt(thoiGianXuLyConLai));
				}

				issCard.setcrdUserCreate(String.valueOf(row.get("CRD_USER_CRE")));
				issCard.setnguyennhankhac(String.valueOf(row.get("NGUYENNHANKHAC")));
				issCard.setCrdProcProg(String.valueOf(row.get("CRD_PROC_PROG")));
				listIssCard.add(issCard);
			}
		}
		return listIssCard;
	}

	public List<DisputesIssCard> theQuocTe_getCaseDenHan() {
		List<DisputesIssCard> listIssCard = new ArrayList<DisputesIssCard>();

		String sql = "select CRD_CRE_TMS, CRD_REC_DT, CRD_CASE_ID, CRD_CUST_NAME, CRD_LOC, CRD_CIF_NO, (SELECT PX_IRPANMAP_PANMASK FROM ccps.ir_pan_map@im where px_irpanmap_pan = CRD_PAN) SO_THE_FULL,"
				+ " CRD_CARD_TYPE, CRD_TXN_CHANNEL, CRD_PROC_PROG, CRD_MERC_NAME, CRD_MERC_ID, CRD_TID, CRD_TXN_DT, CRD_PST_DT, CRD_TXN_AMT, CRD_CURR_CDE, CRD_VND_AMT, CRD_APV_CDE, CRD_TRACE,"
				+ " CRD_POS_MODE, CRD_ICA, CRD_3D_IND, CRD_DIS_REASON_CDE, CRD_CASE_STATUS, CRD_THOIGIANXULYCONLAI,"
				+ " CRD_USER_CRE, CRD_MCC, NGUYENNHANKHAC from ccps.disputes_iss_card_v2 where CRD_THOIGIANXULYCONLAI > 0 and CRD_THOIGIANXULYCONLAI <= 5 and CRD_CASE_STATUS != 'Done' order by CRD_REC_DT desc";

		List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql);
		int count = list.size();

		if (count == 0) {
			return listIssCard;
		} else {
			for (Map<String, Object> row : list) {
				DisputesIssCard issCard = new DisputesIssCard();

				// issCard.setCrdCreTms(Long.parseLong(String.valueOf(row.get("CRD_CRE_TMS"))));
				issCard.setCrdCreTms(String.valueOf(row.get("CRD_CRE_TMS")));
				issCard.setCrdRecDt(Integer.parseInt(String.valueOf(row.get("CRD_REC_DT"))));
				issCard.setCrdCaseId(String.valueOf(row.get("CRD_CASE_ID")));
				issCard.setCrdCustName(String.valueOf(row.get("CRD_CUST_NAME")));
				issCard.setCrdLoc(String.valueOf(row.get("CRD_LOC")));
				issCard.setCrdCifNo(String.valueOf(row.get("CRD_CIF_NO")));
				issCard.setCrdPan(String.valueOf(row.get("SO_THE_FULL")));
				issCard.setCrdCrdType(String.valueOf(row.get("CRD_CARD_TYPE")));
				issCard.setcrdTrxnChannel(String.valueOf(row.get("CRD_TXN_CHANNEL")));
				issCard.setCrdMercName(String.valueOf(row.get("CRD_MERC_NAME")));
				issCard.setCrdMercId(String.valueOf(row.get("CRD_MERC_ID")));
				issCard.setCrdTid(String.valueOf(row.get("CRD_TID")));
				issCard.setIca(String.valueOf(row.get("CRD_ICA")));
				issCard.setCrdTxnDt(Integer.parseInt(String.valueOf(row.get("CRD_TXN_DT"))));
				String postingDate = String.valueOf(row.get("CRD_PST_DT"));
				if (!postingDate.equals("null")) {
					issCard.setCrdPstDt(Integer.parseInt(postingDate));
				}
				issCard.setCrdTxnAmt(Float.parseFloat(String.valueOf(row.get("CRD_TXN_AMT"))));
				issCard.setCrdCurrCde(String.valueOf(row.get("CRD_CURR_CDE")));
				issCard.setCrdVndAmt(Float.parseFloat(String.valueOf(row.get("CRD_VND_AMT"))));
				issCard.setCrdApvCde(String.valueOf(row.get("CRD_APV_CDE")));
				issCard.setCrdTrace(String.valueOf(row.get("CRD_TRACE")));
				issCard.setCrdPosMode(String.valueOf(row.get("CRD_POS_MODE")));
				issCard.setcrd3dIn(String.valueOf(row.get("CRD_3D_IND")));
				issCard.setCrdMcc(Integer.parseInt(String.valueOf(row.get("CRD_MCC"))));
				issCard.setCrdDisReasonCde(String.valueOf(row.get("CRD_DIS_REASON_CDE")));
				issCard.setCrdCaseStatus(String.valueOf(row.get("CRD_CASE_STATUS")));

				String thoiGianXuLyConLai = String.valueOf(row.get("CRD_THOIGIANXULYCONLAI"));
				if (!thoiGianXuLyConLai.equals("null")) {
					issCard.setcrdThoiGianXuLyConLai(Integer.parseInt(thoiGianXuLyConLai));
				}

				issCard.setcrdUserCreate(String.valueOf(row.get("CRD_USER_CRE")));
				issCard.setnguyennhankhac(String.valueOf(row.get("NGUYENNHANKHAC")));
				issCard.setCrdProcProg(String.valueOf(row.get("CRD_PROC_PROG")));
				listIssCard.add(issCard);
			}
		}
		return listIssCard;
	}

	public List<DisputesIssCard> theQuocTe_getCaseQuaHan() {
		List<DisputesIssCard> listIssCard = new ArrayList<DisputesIssCard>();

		String sql = "select CRD_CRE_TMS, CRD_REC_DT, CRD_CASE_ID, CRD_CUST_NAME, CRD_LOC, CRD_CIF_NO, (SELECT PX_IRPANMAP_PANMASK FROM ccps.ir_pan_map@im where px_irpanmap_pan = CRD_PAN) SO_THE_FULL,"
				+ " CRD_CARD_TYPE, CRD_TXN_CHANNEL, CRD_PROC_PROG, CRD_MERC_NAME, CRD_MERC_ID, CRD_TID, CRD_TXN_DT, CRD_PST_DT, CRD_TXN_AMT, CRD_CURR_CDE, CRD_VND_AMT, CRD_APV_CDE, CRD_TRACE,"
				+ " CRD_POS_MODE, CRD_ICA, CRD_3D_IND, CRD_DIS_REASON_CDE, CRD_CASE_STATUS, CRD_THOIGIANXULYCONLAI,"
				+ " CRD_USER_CRE, CRD_MCC, NGUYENNHANKHAC from ccps.disputes_iss_card_v2 where CRD_THOIGIANXULYCONLAI < 0 and CRD_CASE_STATUS != 'Done' order by CRD_REC_DT desc";

		List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql);
		int count = list.size();

		if (count == 0) {
			return listIssCard;
		} else {
			for (Map<String, Object> row : list) {
				DisputesIssCard issCard = new DisputesIssCard();

				// issCard.setCrdCreTms(Long.parseLong(String.valueOf(row.get("CRD_CRE_TMS"))));
				issCard.setCrdCreTms(String.valueOf(row.get("CRD_CRE_TMS")));
				issCard.setCrdRecDt(Integer.parseInt(String.valueOf(row.get("CRD_REC_DT"))));
				issCard.setCrdCaseId(String.valueOf(row.get("CRD_CASE_ID")));
				issCard.setCrdCustName(String.valueOf(row.get("CRD_CUST_NAME")));
				issCard.setCrdLoc(String.valueOf(row.get("CRD_LOC")));
				issCard.setCrdCifNo(String.valueOf(row.get("CRD_CIF_NO")));
				issCard.setCrdPan(String.valueOf(row.get("SO_THE_FULL")));
				issCard.setCrdCrdType(String.valueOf(row.get("CRD_CARD_TYPE")));
				issCard.setcrdTrxnChannel(String.valueOf(row.get("CRD_TXN_CHANNEL")));
				issCard.setCrdMercName(String.valueOf(row.get("CRD_MERC_NAME")));
				issCard.setCrdMercId(String.valueOf(row.get("CRD_MERC_ID")));
				issCard.setCrdTid(String.valueOf(row.get("CRD_TID")));
				issCard.setIca(String.valueOf(row.get("CRD_ICA")));
				issCard.setCrdTxnDt(Integer.parseInt(String.valueOf(row.get("CRD_TXN_DT"))));
				String postingDate = String.valueOf(row.get("CRD_PST_DT"));
				if (!postingDate.equals("null")) {
					issCard.setCrdPstDt(Integer.parseInt(postingDate));
				}
				issCard.setCrdTxnAmt(Float.parseFloat(String.valueOf(row.get("CRD_TXN_AMT"))));
				issCard.setCrdCurrCde(String.valueOf(row.get("CRD_CURR_CDE")));
				issCard.setCrdVndAmt(Float.parseFloat(String.valueOf(row.get("CRD_VND_AMT"))));
				issCard.setCrdApvCde(String.valueOf(row.get("CRD_APV_CDE")));
				issCard.setCrdTrace(String.valueOf(row.get("CRD_TRACE")));
				issCard.setCrdPosMode(String.valueOf(row.get("CRD_POS_MODE")));
				issCard.setcrd3dIn(String.valueOf(row.get("CRD_3D_IND")));
				issCard.setCrdMcc(Integer.parseInt(String.valueOf(row.get("CRD_MCC"))));
				issCard.setCrdDisReasonCde(String.valueOf(row.get("CRD_DIS_REASON_CDE")));
				issCard.setCrdCaseStatus(String.valueOf(row.get("CRD_CASE_STATUS")));

				String thoiGianXuLyConLai = String.valueOf(row.get("CRD_THOIGIANXULYCONLAI"));
				if (!thoiGianXuLyConLai.equals("null")) {
					issCard.setcrdThoiGianXuLyConLai(Integer.parseInt(thoiGianXuLyConLai));
				}

				issCard.setcrdUserCreate(String.valueOf(row.get("CRD_USER_CRE")));
				issCard.setnguyennhankhac(String.valueOf(row.get("NGUYENNHANKHAC")));
				issCard.setCrdProcProg(String.valueOf(row.get("CRD_PROC_PROG")));
				listIssCard.add(issCard);
			}
		}
		return listIssCard;
	}

	void capNhatPostingDate() {
		String sql = "select CRD_PAN, CRD_LOC, CRD_APV_CDE, CRD_PST_DT, CRD_CARD_TYPE from ccps.disputes_iss_card_v2 where CRD_PST_DT is null or CRD_ARN is null and CRD_CARD_TYPE != 'LOCAL DEBIT'";
		List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql);
		int count = list.size();
		if (count == 0) {
			return;
		} else {
			for (Map<String, Object> row : list) {
				String panNumber = String.valueOf(row.get("CRD_PAN"));
				String locNumber = String.valueOf(row.get("CRD_LOC"));
				String aprroveCode = String.valueOf(row.get("CRD_APV_CDE"));
				String loaiThe = String.valueOf(row.get("CRD_CARD_TYPE"));
				String sqlUpdate = "";
				if (loaiThe.equals("MC CREDIT") || loaiThe.equals("VS CREDIT")) {
					sqlUpdate = "update ccps.disputes_iss_card_v2 set CRD_PST_DT = (select b.P9_IRC_PST_DT from ccps.irc02@im b "
							+ " where b.PX_IRC_OWN_PAN = 'INPUT_PAN' and b.F9_IRC_LOC_ACCT = 'INPUT_LOC' and b.FX_IRC_APV_CDE = 'INPUT_APPCODE' and rownum <= 1),"
							+ " CRD_ARN = (select b.FX_IRC_ARN from ccps.irc02@im b where b.PX_IRC_OWN_PAN = 'INPUT_PAN'"
							+ " and b.F9_IRC_LOC_ACCT = 'INPUT_LOC' and b.FX_IRC_APV_CDE = 'INPUT_APPCODE' and rownum <= 1) "
							+ " where CRD_PAN = 'INPUT_PAN' and CRD_LOC = 'INPUT_LOC' and CRD_APV_CDE = 'INPUT_APPCODE' and CRD_CARD_TYPE != 'LOCAL DEBIT'";
				} else {
					sqlUpdate = "update ccps.disputes_iss_card_v2 set CRD_PST_DT = (select b.P9_IRC_PST_DT from ccps.irc04@im b "
							+ " where b.PX_IRC_OWN_PAN = 'INPUT_PAN' and b.F9_IRC_LOC_ACCT = 'INPUT_LOC' and b.FX_IRC_APV_CDE = 'INPUT_APPCODE' and rownum <= 1),"
							+ " CRD_ARN =  (select b.FX_IRC_ARN from ccps.irc04@im b where b.PX_IRC_OWN_PAN = 'INPUT_PAN'"
							+ " and b.F9_IRC_LOC_ACCT = 'INPUT_LOC' and b.FX_IRC_APV_CDE = 'INPUT_APPCODE' and rownum <= 1)"
							+ " where CRD_PAN = 'INPUT_PAN' and CRD_LOC = 'INPUT_LOC' and CRD_APV_CDE = 'INPUT_APPCODE' and CRD_CARD_TYPE != 'LOCAL DEBIT'";
				}

				sqlUpdate = sqlUpdate.replaceAll("INPUT_PAN", panNumber);
				sqlUpdate = sqlUpdate.replaceAll("INPUT_LOC", locNumber);
				sqlUpdate = sqlUpdate.replaceAll("INPUT_APPCODE", aprroveCode);

				try {
					getJdbcTemplate().update(sqlUpdate);
				} catch (Exception e) {
					logger.warn("ISSCardDao, function capNhatPostingDate() error: " + e.toString());
				}
			}
		}
	}

	// CAP NHAT SO THE NEU SO THE BI NULL
	public void capNhatSoTheNull() {
		String sql = "select CRD_LOC from disputes_iss_card_v2 where CRD_PAN is null";
		List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql);
		int count = list.size();
		if (count == 0) {
			return;
		} else {
			for (Map<String, Object> row : list) {
				String locNumber = String.valueOf(row.get("CRD_LOC"));
				xuLyCapNhatSoTheNull(locNumber);
			}
		}
		return;
	}

	// CAP NHAT SO THE NEU SO THE BI NULL DUA VAO SO LOC
	void xuLyCapNhatSoTheNull(String LocNumber) {
		String cardNumber = null;
		String sql_TheChinh = "select PX_IR025_PAN from ir025@im where F9_IR025_LOC_ACCT = 'INPUT_LOC' AND ROWNUM <= 1";
		String sql_ThePhu = "SELECT * FROM IR275@IM WHERE F9_IR275_LOC_ACCT = 'INPUT_LOC' AND ROWNUM <= 1";

		sql_TheChinh = sql_TheChinh.replaceAll("INPUT_LOC", LocNumber);
		sql_ThePhu = sql_ThePhu.replaceAll("INPUT_LOC", LocNumber);

		List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql_TheChinh);
		int countTheChinh = list.size();

		// Neu countTheChinh = 0, tuc la khong co so LOC the chinh nao bi null
		// So The
		// Neu countTheChinh = 0, xu ly cap nhat so the Phu bi null
		if (countTheChinh != 0) {
			for (Map<String, Object> row : list) {
				cardNumber = String.valueOf(row.get("PX_IR025_PAN"));
				break;
			}
		} else {
			list = getJdbcTemplate().queryForList(sql_ThePhu);
			int countThePhu = list.size();
			if (countThePhu == 0) {
				return;
			}
			for (Map<String, Object> row : list) {
				cardNumber = String.valueOf(row.get("PX_IR275_OWN_PAN"));
				break;
			}
		}
		String sqlUpdate = "update disputes_iss_card_v2 set CRD_PAN = 'INPUT_CARDNO' WHERE CRD_LOC = 'INPUT_LOC'";
		sqlUpdate = sqlUpdate.replaceAll("INPUT_CARDNO", cardNumber);
		sqlUpdate = sqlUpdate.replaceAll("INPUT_LOC", LocNumber);
		try {
			getJdbcTemplate().update(sqlUpdate);
		} catch (Exception e) {
			logger.warn("ISSCardDao, function capNhatSoTheChinh() error: " + e.toString());
		}
	}

	public List<DisputesIssCard> chitiet_TheQuocTe_ISS(String createTime) {
		String sql = "select CRD_CUST_NAME, (substr(ccps.ded2(CRD_PAN, ''), 1, 6) || 'xxxxxx' || substr(ccps.ded2(CRD_PAN, ''), -4, 4)) PAN, CRD_CIF_NO, CRD_USER_CRE, "
				+ "CRD_ICA, CRD_MERC_NAME, CRD_MERC_ID, CRD_TID, CRD_CASE_ID, CRD_TXN_DT, CRD_PST_DT, CRD_TXN_AMT, "
				+ "CRD_CURR_CDE, CRD_VND_AMT, CRD_REC_DT, CRD_APV_CDE, CRD_TRACE, CRD_POS_MODE, CRD_3D_IND, "
				+ "CRD_THOIGIANXULYCONLAI, CRD_CASE_STATUS, CRD_DIS_REASON_CDE, CRD_PROC_PROG, RR_CODE, RR_DATE,"
				+ " CB_CODE, CB_DATE, CB_NGAY_TXT, CB_THOIGIANCONLAI_TXT, AC_CODE, AC_DATE, PRE_AR_CODE,"
				+ " PRE_AR_DATE, PRE_AR_NGAYPHANHOI, PRE_AR_THOIGIANCONLAI, PRE_AR_RESP_DATE, AR_CODE, AR_DATE,"
				+ " DONE_END_DATE, DONE_RESULT, DONE_KQ_KHAC, STATUS, CRD_DIS_RESULT, DONE_NGAYHOANTRA, DONE_PHIKHIEUNAISAI, NGUYENNHANKHAC"
				+ " from ccps.disputes_iss_card_v2 where crd_cre_tms = " + createTime + " and rownum <= 1";

		DisputesIssCard result = new DisputesIssCard();
		List<DisputesIssCard> listIssCard = new ArrayList<DisputesIssCard>();

		List<Map<String, Object>> list;
		try {
			list = getJdbcTemplate().queryForList(sql);
		} catch (Exception e) {
			logger.warn("ISSCardDao, function chitiet_TheQuocTe_ISS() error: " + e.toString());
			return null;
		}
		int count = list.size();

		if (count == 0) {
			return null;
		} else {
			for (Map<String, Object> row : list) {

				String custName = String.valueOf(row.get("CRD_CUST_NAME"));
				String soThe = String.valueOf(row.get("PAN"));
				String cifNo = String.valueOf(row.get("CRD_CIF_NO"));
				String userCreate = String.valueOf(row.get("CRD_USER_CRE"));
				String ica = String.valueOf(row.get("CRD_ICA"));
				String merchantName = String.valueOf(row.get("CRD_MERC_NAME"));
				String merchantId = String.valueOf(row.get("CRD_MERC_ID"));
				String tId = String.valueOf(row.get("CRD_TID"));
				String caseId = String.valueOf(row.get("CRD_CASE_ID"));
				String trxnDate = String.valueOf(row.get("CRD_TXN_DT"));
				String postingDate = String.valueOf(row.get("CRD_PST_DT"));
				String trxnAmt = String.valueOf(row.get("CRD_TXN_AMT"));
				String currCode = String.valueOf(row.get("CRD_CURR_CDE"));
				String vndAmt = String.valueOf(row.get("CRD_VND_AMT"));
				String recDate = String.valueOf(row.get("CRD_REC_DT"));
				String appCode = String.valueOf(row.get("CRD_APV_CDE"));
				String trace = String.valueOf(row.get("CRD_TRACE"));
				String posMode = String.valueOf(row.get("CRD_POS_MODE"));
				String _3dIn = String.valueOf(row.get("CRD_3D_IND"));

				String thoiGianXuLyConLai = String.valueOf(row.get("CRD_THOIGIANXULYCONLAI"));
				String caseStatus = String.valueOf(row.get("CRD_CASE_STATUS"));
				String reasonCode = String.valueOf(row.get("CRD_DIS_REASON_CDE"));
				String tienDoXuLy = String.valueOf(row.get("CRD_PROC_PROG"));

				String rrCode = String.valueOf(row.get("RR_CODE"));
				String rrDate = String.valueOf(row.get("RR_DATE"));
				String cbCode = String.valueOf(row.get("CB_CODE"));
				String cbDate = String.valueOf(row.get("CB_DATE"));
				String cbNgayTxt = String.valueOf(row.get("CB_NGAY_TXT"));
				String cbThoigianconlaiTxt = String.valueOf(row.get("CB_THOIGIANCONLAI_TXT"));
				String acCode = String.valueOf(row.get("AC_CODE"));
				String acDate = String.valueOf(row.get("AC_DATE"));
				String preArCode = String.valueOf(row.get("PRE_AR_CODE"));
				String preArDate = String.valueOf(row.get("PRE_AR_DATE"));
				String preArNgayphanhoi = String.valueOf(row.get("PRE_AR_NGAYPHANHOI"));
				String preArThoigianconlai = String.valueOf(row.get("PRE_AR_THOIGIANCONLAI"));
				String preArRespDate = String.valueOf(row.get("PRE_AR_RESP_DATE"));
				String arCode = String.valueOf(row.get("AR_CODE"));
				String arDate = String.valueOf(row.get("AR_DATE"));
				String doneEndDate = String.valueOf(row.get("DONE_END_DATE"));
				String doneResult = String.valueOf(row.get("DONE_RESULT"));
				String doneNgayhoantra = String.valueOf(row.get("DONE_NGAYHOANTRA"));
				String donePhikhieunaisai = String.valueOf(row.get("DONE_PHIKHIEUNAISAI"));
				String nguyenNhanKhac = String.valueOf(row.get("NGUYENNHANKHAC"));
				String doneKQKhac = String.valueOf(row.get("DONE_KQ_KHAC"));

				if (!rrCode.equals("null")) {
					result.setRrCode(rrCode);
				} else {
					result.setRrCode("");
				}

				if (!rrDate.equals("null")) {
					result.setRrDate(Integer.parseInt(rrDate));
				} else {
					result.setRrDate(00000000);
				}

				if (!cbCode.equals("null")) {
					result.setCbCode(cbCode);
				} else {
					result.setCbCode("");
				}

				if (!cbDate.equals("null")) {
					result.setCbDate(Integer.parseInt(cbDate));
				} else {
					result.setCbDate(00000000);
				}

				if (!cbNgayTxt.equals("null")) {
					result.setCbNgayTxt(Integer.parseInt(cbNgayTxt));
				} else {
					result.setCbNgayTxt(00000000);
				}

				if (!cbThoigianconlaiTxt.equals("null")) {
					result.setCbThoigianconlaiTxt(Integer.parseInt(cbThoigianconlaiTxt));
				} else {
					result.setCbThoigianconlaiTxt(00000000);
				}

				if (!acCode.equals("null")) {
					result.setAcCode(acCode);
				} else {
					result.setAcCode("");
				}

				if (!acDate.equals("null")) {
					result.setAcDate(Integer.parseInt(acDate));
				} else {
					result.setAcDate(00000000);
				}

				if (!preArCode.equals("null")) {
					result.setPreArCode(preArCode);
				} else {
					result.setPreArCode("");
				}

				if (!preArDate.equals("null")) {
					result.setPreArDate(Integer.parseInt(preArDate));
				} else {
					result.setPreArDate(00000000);
				}

				if (!preArDate.equals("null")) {
					result.setPreArNgayphanhoi(Integer.parseInt(preArDate));
				} else {
					result.setPreArNgayphanhoi(00000000);
				}

				if (!preArRespDate.equals("null")) {
					result.setPreArRespDate(Integer.parseInt(preArRespDate));
				} else {
					result.setPreArRespDate(00000000);
				}

				if (!arCode.equals("null")) {
					result.setArCode(arCode);
				} else {
					result.setArCode("");
				}

				if (!arDate.equals("null")) {
					result.setArDate(Integer.parseInt(arDate));
				} else {
					result.setArDate(00000000);
				}
				if (!doneEndDate.equals("null")) {
					result.setDoneEndDate(Integer.parseInt(doneEndDate));
				} else {
					result.setDoneEndDate(00000000);
				}

				result.setDoneResult(doneResult);

				if (!doneNgayhoantra.equals("null")) {
					result.setDoneNgayhoantra(Integer.parseInt(doneNgayhoantra));
				} else {
					result.setDoneNgayhoantra(00000000);
				}
				if (!preArNgayphanhoi.equals("null")) {
					result.setPreArNgayphanhoi(Integer.parseInt(preArNgayphanhoi));
				} else {
					result.setPreArNgayphanhoi(00000000);
				}
				result.setDonePhikhieunaisai(donePhikhieunaisai);

				if (!preArThoigianconlai.equals("null")) {
					result.setPreArThoigianconlai(Integer.parseInt(preArThoigianconlai));
				} else {
					result.setPreArThoigianconlai(Integer.parseInt("00000000"));
				}

				result.setCrdCustName(custName);
				result.setCrdPan(soThe);
				result.setCrdCifNo(cifNo);
				result.setcrdUserCreate(userCreate);
				result.setIca(ica);
				result.setCrdMercName(merchantName);
				result.setCrdMercId(merchantId);
				result.setCrdTid(tId);
				result.setCrdCaseId(caseId);
				result.setCrdTxnDt(Integer.parseInt(trxnDate));
				if (!postingDate.equals("null")) {
					result.setCrdPstDt(Integer.parseInt(postingDate));
				} else {
					result.setCrdPstDt(0);
				}
				result.setCrdTxnAmt(Float.parseFloat(trxnAmt));
				result.setCrdCurrCde(currCode);
				result.setCrdVndAmt(Float.parseFloat(vndAmt));
				result.setCrdRecDt(Integer.parseInt(recDate));
				result.setCrdApvCde(appCode);
				result.setCrdTrace(trace);
				result.setCrdPosMode(posMode);
				result.setcrd3dIn(_3dIn);

				if (!thoiGianXuLyConLai.equals("null")) {
					result.setcrdThoiGianXuLyConLai(Integer.parseInt(thoiGianXuLyConLai));
				} else {
					result.setcrdThoiGianXuLyConLai(-999);// -999 flag ghi nhan
															// thoiGianXuLyConLai
															// = null
				}

				result.setCrdCaseStatus(caseStatus);
				result.setCrdDisReasonCde(reasonCode);
				result.setnguyennhankhac(nguyenNhanKhac);
				result.setdoneKqKhac(doneKQKhac);

				if (tienDoXuLy.equals("null")) {
					result.setCrdProcProg("");
				} else {
					result.setCrdProcProg(tienDoXuLy);
				}

				listIssCard.add(result);
				return listIssCard;
			}
		}
		return null;
	}

	public void update_case_iss_international_card(String rrCode, String rrDate, String cbCode, String cbDate,
			String cbNgayTxt, String cbThoigianconlaiTxt, String acCode, String acDate, String preArCode,
			String preArDate, String preArNgayphanhoi, String preArThoigianconlai, String preArRespDate, String arCode,
			String arDate, String doneEndDate, String doneResult, String doneKqKhac, String doneNgayhoantra,
			String donePhikhieunaisai, String crdCaseStatus, String crdDisReasonCde, String lyDoTraSoatKhac,
			String quaTrinhXuLy, String createTime, String updateTime, String userUpdate, String caseId,
			String ngayTiepNhan) {
		Common common = new Common();
		String sql = "update ccps.disputes_iss_card_v2 set CRD_CASE_STATUS = '_001', CRD_DIS_REASON_CDE = '_002', CRD_PROC_PROG = '_003', RR_CODE = '_004', RR_DATE = _005, CB_CODE = '_006', CB_DATE = _007, CB_NGAY_TXT = _008, AC_CODE = '_009', AC_DATE = _010, PRE_AR_CODE = '_011', PRE_AR_DATE = _012, PRE_AR_NGAYPHANHOI = _013, PRE_AR_RESP_DATE = _014,  AR_CODE = '_015', AR_DATE = _016, DONE_END_DATE = _017, DONE_RESULT = '_018', DONE_NGAYHOANTRA = '_019', DONE_PHIKHIEUNAISAI = '_020', CRD_USER_UPDT = '_021', crd_time_updt = _022, NGUYENNHANKHAC = '_024', DONE_KQ_KHAC = '_025', CRD_CASE_ID = '_026', CRD_REC_DT = '_027' where crd_cre_tms = _023";
		sql = sql.replaceAll("_001", crdCaseStatus);
		sql = sql.replaceAll("_002", crdDisReasonCde);
		sql = sql.replaceAll("_003", quaTrinhXuLy);
		sql = sql.replaceAll("_021", userUpdate);
		sql = sql.replaceAll("_022", updateTime);
		sql = sql.replaceAll("_023", createTime);
		sql = sql.replaceAll("_024", lyDoTraSoatKhac);
		sql = sql.replaceAll("_025", String.valueOf(doneKqKhac));
		sql = sql.replaceAll("_026", caseId);
		sql = sql.replaceAll("_027", common.formatTime_yyyymmdd(ngayTiepNhan));

		if (crdCaseStatus.equals("Pending") || crdCaseStatus.equals("Offline")) {
			sql = sql.replaceAll(
					"RR_CODE = '_004', RR_DATE = _005, CB_CODE = '_006', CB_DATE = _007, CB_NGAY_TXT = _008, AC_CODE = '_009', AC_DATE = _010, PRE_AR_CODE = '_011', PRE_AR_DATE = _012, PRE_AR_NGAYPHANHOI = _013, PRE_AR_RESP_DATE = _014,  AR_CODE = '_015', AR_DATE = _016, DONE_END_DATE = _017, DONE_RESULT = '_018', DONE_NGAYHOANTRA = '_019', DONE_PHIKHIEUNAISAI = '_020', ",
					"");
		}
		if (crdCaseStatus.equals("Retrieval Request")) {
			sql = sql.replaceAll(
					"CB_CODE = '_006', CB_DATE = _007, CB_NGAY_TXT = _008, AC_CODE = '_009', AC_DATE = _010, PRE_AR_CODE = '_011', PRE_AR_DATE = _012, PRE_AR_NGAYPHANHOI = _013, PRE_AR_RESP_DATE = _014,  AR_CODE = '_015', AR_DATE = _016, DONE_END_DATE = _017, DONE_RESULT = '_018', DONE_NGAYHOANTRA = '_019', DONE_PHIKHIEUNAISAI = '_020', ",
					"");
			sql = sql.replaceAll("_004", rrCode);
			if (rrDate.equals("--0") || rrDate.equals("")) {
				sql = sql.replaceAll("RR_DATE = _005, ", "");
			} else {
				sql = sql.replaceAll("_005", common.formatTime_yyyymmdd(rrDate));
			}
		}
		if (crdCaseStatus.equals("Chargeback/Dispute")) {
			sql = sql.replaceAll("RR_CODE = '_004', RR_DATE = _005, ", "");
			sql = sql.replaceAll(
					"AC_CODE = '_009', AC_DATE = _010, PRE_AR_CODE = '_011', PRE_AR_DATE = _012, PRE_AR_NGAYPHANHOI = _013, PRE_AR_RESP_DATE = _014,  AR_CODE = '_015', AR_DATE = _016, DONE_END_DATE = _017, DONE_RESULT = '_018', DONE_NGAYHOANTRA = '_019', DONE_PHIKHIEUNAISAI = '_020', ",
					"");
			sql = sql.replaceAll("_006", cbCode);
			if (cbDate.equals("--0") || cbDate.equals("")) {
				sql = sql.replaceAll("CB_DATE = _007, ", "");
			} else {
				sql = sql.replaceAll("_007", common.formatTime_yyyymmdd(cbDate));
			}
			if (null == cbNgayTxt || cbNgayTxt.equals("--0") || cbNgayTxt.equals("")) {
				sql = sql.replaceAll("CB_NGAY_TXT = _008, ", "");
			} else {
				sql = sql.replaceAll("_008", common.formatTime_yyyymmdd(cbNgayTxt));
			}
		}
		if (crdCaseStatus.equals("Arbitration Chargeback")) {
			sql = sql.replaceAll(
					"RR_CODE = '_004', RR_DATE = _005, CB_CODE = '_006', CB_DATE = _007, CB_NGAY_TXT = _008, ", "");
			sql = sql.replaceAll(
					"PRE_AR_CODE = '_011', PRE_AR_DATE = _012, PRE_AR_NGAYPHANHOI = _013, PRE_AR_RESP_DATE = _014,  AR_CODE = '_015', AR_DATE = _016, DONE_END_DATE = _017, DONE_RESULT = '_018', DONE_NGAYHOANTRA = '_019', DONE_PHIKHIEUNAISAI = '_020', ",
					"");
			sql = sql.replaceAll("_009", acCode);

			if (acDate.equals("--0") || acDate.equals("")) {
				sql = sql.replaceAll("AC_DATE = _010, ", "");
			} else {
				sql = sql.replaceAll("_010", common.formatTime_yyyymmdd(acDate));
			}
		}
		if (crdCaseStatus.equals("Pre-Arbitration")) {
			sql = sql.replaceAll(
					"RR_CODE = '_004', RR_DATE = _005, CB_CODE = '_006', CB_DATE = _007, CB_NGAY_TXT = _008, AC_CODE = '_009', AC_DATE = _010, ",
					"");
			sql = sql.replaceAll(
					"PRE_AR_RESP_DATE = _014,  AR_CODE = '_015', AR_DATE = _016, DONE_END_DATE = _017, DONE_RESULT = '_018', DONE_NGAYHOANTRA = '_019', DONE_PHIKHIEUNAISAI = '_020', ",
					"");
			sql = sql.replaceAll("_011", preArCode);
			if (preArDate.equals("--0") || preArDate.equals("")) {
				sql = sql.replaceAll("_012", "");
			} else {
				sql = sql.replaceAll("_012", common.formatTime_yyyymmdd(preArDate));
			}
			if (preArNgayphanhoi.equals("--0") || preArNgayphanhoi.equals("")) {
				sql = sql.replaceAll("_013", "''");
			} else {
				sql = sql.replaceAll("_013", common.formatTime_yyyymmdd(preArNgayphanhoi));
			}
		}
		if (crdCaseStatus.equals("Pre-Arbitration Response")) {
			sql = sql.replaceAll(
					"RR_CODE = '_004', RR_DATE = _005, CB_CODE = '_006', CB_DATE = _007, CB_NGAY_TXT = _008, AC_CODE = '_009', AC_DATE = _010, PRE_AR_CODE = '_011', PRE_AR_DATE = _012, PRE_AR_NGAYPHANHOI = _013, ",
					"");
			sql = sql.replaceAll(
					" AR_CODE = '_015', AR_DATE = _016, DONE_END_DATE = _017, DONE_RESULT = '_018', DONE_NGAYHOANTRA = '_019', DONE_PHIKHIEUNAISAI = '_020', ",
					"");

			if (preArRespDate.equals("--0") || preArRespDate.equals("")) {
				sql = sql.replaceAll("PRE_AR_RESP_DATE = _014,", "");
			} else {
				sql = sql.replaceAll("_014", common.formatTime_yyyymmdd(preArRespDate));
			}
		}
		if (crdCaseStatus.equals("Arbitration")) {
			sql = sql.replaceAll(
					"RR_CODE = '_004', RR_DATE = _005, CB_CODE = '_006', CB_DATE = _007, CB_NGAY_TXT = _008, AC_CODE = '_009', AC_DATE = _010, PRE_AR_CODE = '_011', PRE_AR_DATE = _012, PRE_AR_NGAYPHANHOI = _013, PRE_AR_RESP_DATE = _014,  ",
					"");
			sql = sql.replaceAll(
					"DONE_END_DATE = _017, DONE_RESULT = '_018', DONE_NGAYHOANTRA = '_019', DONE_PHIKHIEUNAISAI = '_020', ",
					"");
			sql = sql.replaceAll("_015", arCode);
			if (arDate.equals("--0") || arDate.equals("")) {
				sql = sql.replaceAll("AR_DATE = _016,", "");
			} else {
				sql = sql.replaceAll("_016", common.formatTime_yyyymmdd(arDate));
			}

		}
		if (crdCaseStatus.equals("Done")) {
			sql = sql.replaceAll(
					"RR_CODE = '_004', RR_DATE = _005, CB_CODE = '_006', CB_DATE = _007, CB_NGAY_TXT = _008, AC_CODE = '_009', AC_DATE = _010, PRE_AR_CODE = '_011', PRE_AR_DATE = _012, PRE_AR_NGAYPHANHOI = _013, PRE_AR_RESP_DATE = _014,  AR_CODE = '_015', AR_DATE = _016, ",
					"");
			if (doneEndDate.equals("--0") || doneEndDate.equals("")) {
				sql = sql.replaceAll("DONE_END_DATE = _017,", "");
			} else {
				sql = sql.replaceAll("_017", common.formatTime_yyyymmdd(doneEndDate));
			}

			sql = sql.replaceAll("_018", doneResult);

			if (doneNgayhoantra.equals("--0") || doneNgayhoantra.equals("")) {
				sql = sql.replaceAll("DONE_NGAYHOANTRA = '_019',", "");
			} else {
				sql = sql.replaceAll("_019", common.formatTime_yyyymmdd(doneNgayhoantra));
			}

			sql = sql.replaceAll("_020", donePhikhieunaisai);
		}
		try {
			getJdbcTemplate().update(sql);
		} catch (Exception e) {
			logger.warn("ISSCardDao, function update_case_iss_international_card() error: " + e.toString());
		}
	}

	// ============== LOCAL CARD =================

	public List<DisputesIssCard> truyVan_BangGD_TheNoiDia(String cardNo, String fromDate, String toDate) {

		List<DisputesIssCard> listIssCard = new ArrayList<DisputesIssCard>();

		String sql = "select CONCAT(F9_DW008_DT, CONCAT(SUBSTR(F9_DW008_SEQ, 0, LENGTH(F9_DW008_SEQ) - 3), FX_DW008_GIVEN_APV_CDE)) as D_CREATETIME, trim(a.FX_IR056_NAME) CUST_NAME, trim(a.FX_IR056_CIF_NO) CIF,"
				+ " b.FX_DW008_PAN D_PAN, (SELECT ccps.ded2(b.FX_DW008_PAN, '') from dual) PANMASK, trim(b.FX_DW008_MERC_NAME) D_MERNAME, b.FX_DW008_TID D_TID,"
				+ " b.F9_DW008_DT D_TXNDATE, b.F9_DW008_ORI_AMT D_AMT, b.FX_DW008_GIVEN_APV_CDE D_APPCDE,"
				+ " b.F9_DW008_STAN D_TRACE, trim(FX_DW008_CRD_PGM) CRD_PGM from ir056@im a, dw008 b"
				+ " where b.FX_DW008_CRD_BRN = 'LC' and b.F9_DW008_PRIN_CRN = a.P9_IR056_CRN and"
				+ " F9_DW008_DT >= 222 and F9_DW008_DT <= 333 and b.FX_DW008_PAN = '111' and CONCAT(F9_DW008_DT, CONCAT(SUBSTR(F9_DW008_SEQ, 0, LENGTH(F9_DW008_SEQ) - 3), FX_DW008_GIVEN_APV_CDE)) not in (SELECT CRD_CRE_TMS from ccps.disputes_iss_card_v2)";

		if (cardNo.equals("")) {
			sql = sql.replaceAll("and b.FX_DW008_PAN = '111'", "");
		} else {
			sql = sql.replaceAll("111", cardNo);
		}
		sql = sql.replaceAll("222", fromDate);
		sql = sql.replaceAll("333", toDate);

		List<Map<String, Object>> list;
		try {
			list = getJdbcTemplate().queryForList(sql);
		} catch (Exception e) {
			logger.warn("ISSCardDao, function truyVan_BangGD_TheNoiDia() error: " + e.toString());
			return null;
		}
		int count = list.size();

		if (count == 0) {
			return listIssCard;
		} else {
			int countRecords = 0;
			for (Map<String, Object> row : list) {
				DisputesIssCard issCard = new DisputesIssCard();

				// issCard.setCrdCreTms(Long.parseLong(String.valueOf(row.get("D_CREATETIME"))));
				issCard.setCrdCreTms(String.valueOf(row.get("D_CREATETIME")));
				issCard.setCrdCustName(String.valueOf(row.get("CUST_NAME")));
				issCard.setCrdCifNo(String.valueOf(row.get("CIF")));
				issCard.setCrdPan(String.valueOf(row.get("PANMASK")));
				issCard.setCrdMercName(String.valueOf(row.get("D_MERNAME")));
				issCard.setCrdTid(String.valueOf(row.get("D_TID")));
				issCard.setCrdTxnDt(Integer.parseInt(String.valueOf(row.get("D_TXNDATE"))));
				issCard.setCrdTxnAmt(Float.parseFloat(String.valueOf(row.get("D_AMT"))));
				issCard.setCrdVndAmt(0);
				issCard.setCrdApvCde(String.valueOf(row.get("D_APPCDE")));
				issCard.setCrdTrace(String.valueOf(row.get("D_TRACE")));

				countRecords++;

				if (countRecords <= 200) { // Chá»‰ láº¥y ra 500 records Ä‘áº§u
											// tiÃªn
					listIssCard.add(issCard);
				} else {
					break;
				}
			}
		}
		return listIssCard;
	}

	public void capNhatThoiGianXuLyConLai_TheQuocTe(String username) throws ParseException {
		String sql = "select * from ccps.disputes_iss_card_v2 where crd_user_cre = 'username' and CRD_CARD_TYPE != 'LOCAL DEBIT'";
		sql = sql.replaceAll("username", username.toUpperCase());
		List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql);
		int count = list.size();

		List<DisputesIssCard> listIssCard = new ArrayList<DisputesIssCard>();
		String sqlUpate = "update ccps.disputes_iss_card_v2 set CRD_THOIGIANXULYCONLAI = '_111' where CRD_CRE_TMS = '_222' and CRD_CARD_TYPE != 'LOCAL DEBIT'";

		if (count == 0) {
			return;
		} else {
			Common common = new Common();
			for (Map<String, Object> row : list) {
				DisputesIssCard issCard = new DisputesIssCard();

				String caseStatus = String.valueOf(row.get("CRD_CASE_STATUS"));
				String cardtype = String.valueOf(row.get("CRD_CARD_TYPE"));

				if (!caseStatus.equals("Done") && !caseStatus.equals("")) {
					String recDate = String.valueOf(String.valueOf(row.get("CRD_REC_DT")));
					String nam = recDate.substring(0, 4);
					String thang = recDate.substring(4, 6);
					String ngay = recDate.substring(6, 8);
					String full_RecDate = thang + "/" + ngay + "/" + nam + " 00:00:00";

					String createTime = String.valueOf(row.get("CRD_CRE_TMS"));
					int soNgayTroiQua = 0;
					int thoiGianXuLy = 0;
					if (!String.valueOf(row.get("CRD_THOIGIANXULY")).equals("null")) {
						thoiGianXuLy = Integer.parseInt(String.valueOf(row.get("CRD_THOIGIANXULY")));
					}
					int thoiGianXuLyConLai = 0;

					if (caseStatus.equals("Offline") || caseStatus.equals("Pending")) {
						// Cap nhat Thoi gian xu ly con lai = Thoi gian xu ly -
						// so ngay troi qua
						soNgayTroiQua = common.TruThoiGian(full_RecDate);
						thoiGianXuLyConLai = 30 - soNgayTroiQua;
					}
					if (caseStatus.equals("Retrieval Request")) {
						String ngayRR = String.valueOf(String.valueOf(row.get("RR_DATE")));
						if (!ngayRR.equals("null")) {
							String nam_ngayRR = ngayRR.substring(0, 4);
							String thang_ngayRR = ngayRR.substring(4, 6);
							String ngay_ngayRR = ngayRR.substring(6, 8);
							String full_ngayRR = thang_ngayRR + "/" + ngay_ngayRR + "/" + nam_ngayRR + " 00:00:00";
							int thoiGianTroiQua_RR = common.TruThoiGian(full_ngayRR);
							// Cap nhat Thoi gian xu ly con lai = Thoi gian xu
							// ly - thoiGianTroiQua_RR
							thoiGianXuLyConLai = 30 - thoiGianTroiQua_RR;
						}
					}
					if (caseStatus.equals("Chargeback/Dispute")) {
						String ngayCB = String.valueOf(String.valueOf(row.get("CB_DATE")));
						if (!ngayCB.equals("null")) {
							String nam_ngayCB = ngayCB.substring(0, 4);
							String thang_ngayCB = ngayCB.substring(4, 6);
							String ngay_ngayCB = ngayCB.substring(6, 8);
							String full_ngayCB = thang_ngayCB + "/" + ngay_ngayCB + "/" + nam_ngayCB + " 00:00:00";
							int thoiGianTroiQua_CB = common.TruThoiGian(full_ngayCB);

							// Cap nhat Thoi gian xu ly con lai = Thoi gian xu
							// ly - thoiGianTroiQua_CB
							if (cardtype.equals("VS DEBIT") || cardtype.equals("VS CREDIT")) {
								thoiGianXuLy = 30;
							} else {
								thoiGianXuLy = 45;
							}
							thoiGianXuLyConLai = thoiGianXuLy - thoiGianTroiQua_CB;
						}
					}
					if ((cardtype.equals("MC DEBIT") || cardtype.equals("MC CREDIT"))
							&& caseStatus.equals("Arbitration Chargeback")) {
						String ngayAC = String.valueOf(String.valueOf(row.get("AC_DATE")));
						if (!ngayAC.equals("null")) {
							String nam_ngayAC = ngayAC.substring(0, 4);
							String thang_ngayAC = ngayAC.substring(4, 6);
							String ngay_ngayAC = ngayAC.substring(6, 8);
							String full_ngayAC = thang_ngayAC + "/" + ngay_ngayAC + "/" + nam_ngayAC + " 00:00:00";
							int thoiGianTroiQua_AC = common.TruThoiGian(full_ngayAC);
							// Cap nhat Thoi gian xu ly con lai = 45 -
							// thoiGianTroiQua_AC
							thoiGianXuLyConLai = 45 - thoiGianTroiQua_AC;
						}
					}
					if ((cardtype.equals("VS DEBIT") || cardtype.equals("VS CREDIT"))
							&& caseStatus.equals("Pre-Arbitration")) {
						String ngayPreAr = String.valueOf(String.valueOf(row.get("PRE_AR_DATE")));
						if (!ngayPreAr.equals("null")) {
							String nam_ngayPreAr = ngayPreAr.substring(0, 4);
							String thang_ngayPreAr = ngayPreAr.substring(4, 6);
							String ngay_ngayPreAr = ngayPreAr.substring(6, 8);
							String full_ngayPreArC = thang_ngayPreAr + "/" + ngay_ngayPreAr + "/" + nam_ngayPreAr
									+ " 00:00:00";
							int thoiGianTroiQua_PreArC = common.TruThoiGian(full_ngayPreArC);
							// Cap nhat Thoi gian xu ly con lai = 30 -
							// thoiGianTroiQua_PreArC
							thoiGianXuLyConLai = 30 - thoiGianTroiQua_PreArC;
						}
					}

					if ((cardtype.equals("VS DEBIT") || cardtype.equals("VS CREDIT"))
							&& caseStatus.equals("Pre-Arbitration Response")) {
						String ngayPreArResp = String.valueOf(String.valueOf(row.get("PRE_AR_RESP_DATE")));
						if (!ngayPreArResp.equals("null")) {
							String nam_ngayPreArResp = ngayPreArResp.substring(0, 4);
							String thang_ngayPreArResp = ngayPreArResp.substring(4, 6);
							String ngay_ngayPreArResp = ngayPreArResp.substring(6, 8);
							String full_ngayPreArResp = thang_ngayPreArResp + "/" + ngay_ngayPreArResp + "/"
									+ nam_ngayPreArResp + " 00:00:00";
							int thoiGianTroiQua_ngayPreArResp = common.TruThoiGian(full_ngayPreArResp);
							// Cap nhat Thoi gian xu ly con lai = 10 -
							// thoiGianTroiQua_PreArC
							thoiGianXuLyConLai = 10 - thoiGianTroiQua_ngayPreArResp;
						}
					}

					if (caseStatus.equals("Arbitration")) {
						String ngayAr = String.valueOf(String.valueOf(row.get("AR_DATE")));
						if (!ngayAr.equals("null")) {
							String nam_ngayAr = ngayAr.substring(0, 4);
							String thang_ngayAr = ngayAr.substring(4, 6);
							String ngay_ngayAr = ngayAr.substring(6, 8);
							String full_ngayAr = thang_ngayAr + "/" + ngay_ngayAr + "/" + nam_ngayAr + " 00:00:00";
							int thoiGianTroiQua_ngayAr = common.TruThoiGian(full_ngayAr);

							if (cardtype.equals("VS DEBIT") || cardtype.equals("VS CREDIT")) {
								thoiGianXuLy = 7;
							} else {
								thoiGianXuLy = 10;
							}
							// Cap nhat Thoi gian xu ly con lai = Thoi gian xu
							// ly - thoiGianTroiQua_ngayAr
							thoiGianXuLyConLai = thoiGianXuLy - thoiGianTroiQua_ngayAr;
						}
					}

					sqlUpate = sqlUpate.replaceAll("_111", String.valueOf(thoiGianXuLyConLai));
					sqlUpate = sqlUpate.replaceAll("_222", String.valueOf(createTime));

					try {
						getJdbcTemplate().update(sqlUpate);
						// cap nhat lai sqlUpate nhu khai bao luc dau
						String temp = "CRD_THOIGIANXULYCONLAI = '" + String.valueOf(thoiGianXuLyConLai) + "'";
						sqlUpate = sqlUpate.replaceAll(temp, "CRD_THOIGIANXULYCONLAI = '_111'");
						sqlUpate = sqlUpate.replaceAll(String.valueOf(row.get("CRD_CRE_TMS")), "_222");
					} catch (Exception e) {
						logger.warn(
								"ISSCardDao, function 1capNhatThoiGianXuLyConLai_TheQuocTe() error: " + e.toString());
					}
				}
				// Cap nhat thoi gian Tai xuat trinh
				if (caseStatus.equals("Chargeback/Dispute")) {
					String ngayTXT = String.valueOf(String.valueOf(row.get("CB_NGAY_TXT")));
					int thoiGianXuLy = Integer.parseInt(String.valueOf(row.get("CRD_THOIGIANXULY")));
					if (!ngayTXT.equals("null")) {

						String nam_ngayTXT = ngayTXT.substring(0, 4);
						String thang_ngayTXT = ngayTXT.substring(4, 6);
						String ngay_ngayTXT = ngayTXT.substring(6, 8);
						String full_ngayTXT = thang_ngayTXT + "/" + ngay_ngayTXT + "/" + nam_ngayTXT + " 00:00:00";
						int thoiGianTroiQua = common.TruThoiGian(full_ngayTXT);
						if (cardtype.equals("MC DEBIT") || cardtype.equals("MC CREDIT")) {
							thoiGianXuLy = 45;
						}
						int thoiGianXuLyConLaiTXT = thoiGianXuLy - thoiGianTroiQua;

						String createTime = String.valueOf(row.get("CRD_CRE_TMS"));
						String sql_updateCB = "update ccps.disputes_iss_card_v2 set CB_THOIGIANCONLAI_TXT = '_111' where CRD_CRE_TMS = '_222'";
						sql_updateCB = sql_updateCB.replaceAll("_111", String.valueOf(thoiGianXuLyConLaiTXT));
						sql_updateCB = sql_updateCB.replaceAll("_222", createTime);
						try {
							getJdbcTemplate().update(sql_updateCB);
							// cap nhat lai sqlUpate nhu khai bao luc dau
							String temp = "CB_THOIGIANCONLAI_TXT = '" + String.valueOf(thoiGianXuLyConLaiTXT) + "'";
							sqlUpate = sqlUpate.replaceAll(temp, "CB_THOIGIANCONLAI_TXT = '_111'");
							sqlUpate = sqlUpate.replaceAll(String.valueOf(row.get("CRD_CRE_TMS")), "_222");
						} catch (Exception e) {
							logger.warn("ISSCardDao, function 2capNhatThoiGianXuLyConLai_TheQuocTe() error: "
									+ e.toString());
						}
					}
				}
				if ((cardtype.equals("VS DEBIT") || cardtype.equals("VS CREDIT"))
						&& caseStatus.equals("Pre-Arbitration")) {
					String ngayPreAR = String.valueOf(String.valueOf(row.get("PRE_AR_NGAYPHANHOI")));
					if (!ngayPreAR.equals("null")) {
						String nam = ngayPreAR.substring(0, 4);
						String thang = ngayPreAR.substring(4, 6);
						String ngay = ngayPreAR.substring(6, 8);
						String full_RecDate = thang + "/" + ngay + "/" + nam + " 00:00:00";
						int thoiGianTroiQua = common.TruThoiGian(full_RecDate);

						int thoiGianXuLyConLaiPreAR = 10 - thoiGianTroiQua;

						String createTime = String.valueOf(row.get("CRD_CRE_TMS"));
						String sql_updatePreAR = "update ccps.disputes_iss_card_v2 set PRE_AR_THOIGIANCONLAI = '_111' where CRD_CRE_TMS = '_222'";
						sql_updatePreAR = sql_updatePreAR.replaceAll("_111", String.valueOf(thoiGianXuLyConLaiPreAR));
						sql_updatePreAR = sql_updatePreAR.replaceAll("_222", createTime);
						try {
							getJdbcTemplate().update(sql_updatePreAR);
							// cap nhat lai sqlUpate nhu khai bao luc dau
							String temp = "PRE_AR_THOIGIANCONLAI = '" + String.valueOf(thoiGianXuLyConLaiPreAR) + "'";
							sqlUpate = sqlUpate.replaceAll(temp, "PRE_AR_THOIGIANCONLAI = '_111'");
							sqlUpate = sqlUpate.replaceAll(String.valueOf(row.get("CRD_CRE_TMS")), "_222");
						} catch (Exception e) {
							logger.warn("ISSCardDao, function 3capNhatThoiGianXuLyConLai_TheQuocTe() error: "
									+ e.toString());
						}
					}
				}
			}
		}
	}

	public void capNhatThoiGianXuLyConLai_TheNoiDia(String username) throws ParseException {
		String sql = "select * from ccps.disputes_iss_card_v2 where crd_user_cre = 'username' and CRD_CARD_TYPE = 'LOCAL DEBIT'";
		sql = sql.replaceAll("username", username.toUpperCase());
		List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql);
		int count = list.size();

		String sqlUpate = "update ccps.disputes_iss_card_v2 set CRD_THOIGIANXULYCONLAI = '_111' where CRD_CRE_TMS = '_222' and CRD_CARD_TYPE = 'LOCAL DEBIT'";

		if (count == 0) {
			return;
		} else {
			Common common = new Common();
			for (Map<String, Object> row : list) {

				sqlUpate = sqlUpate.replaceAll("_222", String.valueOf(row.get("CRD_CRE_TMS")));
				String createTime = String.valueOf(row.get("CRD_CRE_TMS"));
				String caseStatus = String.valueOf(row.get("CRD_CASE_STATUS"));
				String cardChannel = String.valueOf(row.get("CRD_TXN_CHANNEL"));

				String recDate = String.valueOf(row.get("CRD_REC_DT"));
				String nam = recDate.substring(0, 4);
				String thang = recDate.substring(4, 6);
				String ngay = recDate.substring(6, 8);
				LocalDate ngayTiepNhan = LocalDate.of(Integer.parseInt(nam), Integer.parseInt(thang),
						Integer.parseInt(ngay));

				LocalDateTime now = LocalDateTime.now();
				String year = common._formatTime(now.getYear());
				String month = common._formatTime(now.getMonthValue());
				String day = common._formatTime(now.getDayOfMonth());
				LocalDate ngayHienTai = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month),
						Integer.parseInt(day));

				int soNgayLamViecDaTroiQua = common.tinhSoNgayLamViec(ngayTiepNhan, ngayHienTai);
				// Cap nhat thoi gian xu ly con lai
				int thoiGianXuLyConLai = 0;
				if (caseStatus.equals("TS lan 1")) {
					String ngayTsLan1 = String.valueOf(row.get("CRD_NGAYTS_LAN1"));
					if (!ngayTsLan1.equals("")) {

						String namTsLan1 = ngayTsLan1.substring(0, 4);
						String thangTsLan1 = ngayTsLan1.substring(4, 6);
						String ngay_TsLan1 = ngayTsLan1.substring(6, 8);
						LocalDate format_ngay_TsLan1 = LocalDate.of(Integer.parseInt(namTsLan1),
								Integer.parseInt(thangTsLan1), Integer.parseInt(ngay_TsLan1));

						int soNgayLamViecDaTroiQua_TsLan1 = common.tinhSoNgayLamViec(format_ngay_TsLan1, ngayHienTai);
						if (cardChannel.equals("ATM")) {
							thoiGianXuLyConLai = 5 - soNgayLamViecDaTroiQua_TsLan1;
						} else if (cardChannel.equals("POS")) {
							thoiGianXuLyConLai = 10 - soNgayLamViecDaTroiQua_TsLan1;
						}
					} else {
						if (cardChannel.equals("ATM")) {
							thoiGianXuLyConLai = 5 - soNgayLamViecDaTroiQua;
						} else if (cardChannel.equals("POS")) {
							thoiGianXuLyConLai = 10 - soNgayLamViecDaTroiQua;
						}
					}

				} else if (caseStatus.equals("Pending")) {
					if (cardChannel.equals("ATM")) {
						thoiGianXuLyConLai = 5 - soNgayLamViecDaTroiQua;
					} else if (cardChannel.equals("POS")) {
						thoiGianXuLyConLai = 10 - soNgayLamViecDaTroiQua;
					}
				} else if (caseStatus.equals("TS lan 2")) {
					thoiGianXuLyConLai = 5 - soNgayLamViecDaTroiQua;
				} else if (caseStatus.equals("HD hoa giai Napas/Trong tai/Toa an")) {
					thoiGianXuLyConLai = 30 - soNgayLamViecDaTroiQua;
				}
				sqlUpate = sqlUpate.replaceAll("_111", String.valueOf(thoiGianXuLyConLai));
				try {
					getJdbcTemplate().update(sqlUpate);
					// cap nhat lai sqlUpate nhu khai bao luc dau
					String temp = "CRD_THOIGIANXULYCONLAI = '" + String.valueOf(thoiGianXuLyConLai) + "'";
					sqlUpate = sqlUpate.replaceAll(temp, "CRD_THOIGIANXULYCONLAI = '_111'");
					sqlUpate = sqlUpate.replaceAll(String.valueOf(row.get("CRD_CRE_TMS")), "_222");
				} catch (Exception e) {
					logger.warn("ISSCardDao, function 1capNhatThoiGianXuLyConLai_TheNoiDia() error: " + e.toString());
				}

				// cap nhat thoi gian xu ly con lai TXT
				if (caseStatus.equals("TS lan 1")) {
					String crdNgayTsLan1TxtTime = String.valueOf(String.valueOf(row.get("CRD_NGAYTS_LAN1_TXT")));
					if (!crdNgayTsLan1TxtTime.equals("null")) {
						int thoiGianXuLyConLaiTxt = 18 - soNgayLamViecDaTroiQua;

						String sql_update = "update ccps.disputes_iss_card_v2 set CRD_NGAYTS_LAN1_TXT_TIME = '_111' where CRD_CRE_TMS = '_222' and CRD_CARD_TYPE = 'LOCAL DEBIT'";
						sql_update = sql_update.replaceAll("_111", String.valueOf(thoiGianXuLyConLaiTxt));
						sql_update = sql_update.replaceAll("_222", createTime);
						try {
							getJdbcTemplate().update(sql_update);
							// cap nhat lai sqlUpate nhu khai bao luc dau
							String temp = "CRD_NGAYTS_LAN1_TXT_TIME = '" + String.valueOf(thoiGianXuLyConLaiTxt) + "'";
							sqlUpate = sqlUpate.replaceAll(temp, "PRE_AR_THOIGIANCONLAI = '_111'");
							sqlUpate = sqlUpate.replaceAll(String.valueOf(row.get("CRD_CRE_TMS")), "_222");
						} catch (Exception e) {
							logger.warn("ISSCardDao, function 2capNhatThoiGianXuLyConLai_TheNoiDia() error: "
									+ e.toString());
						}
					}
				}
			}
		}
	}

	public void capNhat_XuLy_DuLieu_Null() {
		String sql1 = "update disputes_iss_card_v2 set CRD_TXN_DT = '10000000' where CRD_TXN_DT is null";
		String sql2 = "update disputes_iss_card_v2 set CRD_TXN_AMT = 0 where CRD_TXN_AMT is null";
		String sql3 = "update disputes_iss_card_v2 set crd_vnd_amt = 0 where crd_vnd_amt is null";
		String sql4 = "update disputes_iss_card_v2 set CRD_MCC = 0 where CRD_MCC is null";
		String sql5 = "update disputes_iss_card_v2 set CRD_THOIGIANXULY = -1  where CRD_CASE_STATUS != 'Done' and CRD_THOIGIANXULY is null";
		try {
			getJdbcTemplate().update(sql1);
			getJdbcTemplate().update(sql2);
			getJdbcTemplate().update(sql3);
			getJdbcTemplate().update(sql4);
			getJdbcTemplate().update(sql5);
		} catch (Exception e) {
			logger.warn("ISSCardDao, function capNhat_XuLy_DuLieu_Null() error: " + e.toString());
		}
		return;
	}

	// ThÃªm má»›i case tháº» tÃ­n dá»¥ng quá»‘c táº¿ chiá»�u ISS
	public List<DisputesIssCard> createCaseLocalCard_ChieuISS(String createTimeTxn, int thoiGianXuLy, String userName,
			long systemTime, String nguyenNhanKhac, int ngayTiepNhan, String caseID, String txnChannel, String cardType,
			String reasonCode, String caseStatus, String tienDoXuLy, String trxnDate, String kenhGiaoDich) {

		List<DisputesIssCard> listIssCard = new ArrayList<DisputesIssCard>();

		// Lay thong tin KH.
		ThongTinKH info = getThongTinKH_GD_Local_Card(createTimeTxn, trxnDate);
		String hoten = info.getHoTen();
		String cif = info.getCif();

		String sql = "INSERT into ccps.disputes_iss_card_v2(CRD_CRE_TMS, CRD_REC_DT, CRD_CUST_NAME, CRD_CIF_NO, CRD_PAN, CRD_MERC_NAME,  "
				+ "CRD_TID, CRD_TXN_DT, CRD_TXN_AMT, CRD_APV_CDE, CRD_TRACE, CRD_CARD_PROGRAM, CRD_CASE_ID, CRD_DIS_REASON_CDE, NGUYENNHANKHAC,  "
				+ "CRD_PROC_PROG, CRD_CASE_STATUS, CRD_THOIGIANXULY, CRD_TIME_CRE, CRD_CARD_TYPE, CRD_USER_CRE, crd_txn_channel) "
				+ "VALUES(" + createTimeTxn + "," + ngayTiepNhan + ", '" + hoten + "'," + "'" + cif + "',"
				+ "(select b.FX_DW008_PAN from dw008 b where dieukien), "
				+ "(select b.FX_DW008_MERC_NAME from dw008 b where dieukien), "
				+ "(select b.FX_DW008_TID from dw008 b where dieukien), "
				+ "(select b.F9_DW008_DT from dw008 b where dieukien), "
				+ "(select b.F9_DW008_ORI_AMT from dw008 b where dieukien), "
				+ "(select b.FX_DW008_GIVEN_APV_CDE from dw008 b where dieukien), "
				+ "(select b.F9_DW008_STAN from dw008 b where dieukien), "
				+ "(select b.FX_DW008_CRD_PGM from dw008 b where dieukien), " + "'" + caseID + "', '" + reasonCode
				+ "', '" + nguyenNhanKhac + "', '" + tienDoXuLy + "', '" + caseStatus + "', '" + thoiGianXuLy + "', "
				+ systemTime + ", 'LOCAL DEBIT', '" + userName.toUpperCase() + "', '" + kenhGiaoDich + "') ";

		String dieukien = "b.F9_DW008_DT = " + trxnDate
				+ " and b.FX_DW008_CRD_BRN = 'LC' and CONCAT(F9_DW008_DT, CONCAT(SUBSTR(F9_DW008_SEQ, 0, LENGTH(F9_DW008_SEQ) - 3), FX_DW008_GIVEN_APV_CDE)) = "
				+ createTimeTxn;
		sql = sql.replaceAll("dieukien", dieukien);
		try {
			getJdbcTemplate().update(sql);
		} catch (Exception e) {
			logger.warn("ISSCardDao, function createCaseLocalCard_ChieuISS() error: " + e.toString());
		}
		return listIssCard;
	}

	public ThongTinKH getThongTinKH_GD_Local_Card(String createTime, String trxnDate) {
		String sql = "select trim(a.FX_IR056_NAME) CUST_NAME, trim(a.FX_IR056_CIF_NO) CIF from ir056@im a, dw008 b where b.F9_DW008_DT = "
				+ trxnDate + " and b.FX_DW008_CRD_BRN = 'LC' and b.F9_DW008_PRIN_CRN = a.P9_IR056_CRN"
				+ " and CONCAT(F9_DW008_DT, CONCAT(SUBSTR(F9_DW008_SEQ, 0, LENGTH(F9_DW008_SEQ) - 3), FX_DW008_GIVEN_APV_CDE)) = "
				+ createTime;
		ThongTinKH info = new ThongTinKH();

		List<Map<String, Object>> list;
		try {
			list = getJdbcTemplate().queryForList(sql);
		} catch (Exception e) {
			logger.warn("ISSCardDao, function getThongTinKH_GD_Local_Card() error: " + e.toString());
			return null;
		}
		int count = list.size();
		if (count == 0) {

		} else {
			for (Map<String, Object> row : list) {
				String _hoTen = String.valueOf(row.get("CUST_NAME"));
				String _cif = String.valueOf(row.get("LOC"));
				String _Loc = String.valueOf(row.get("CIF"));
				String _CardProgram = String.valueOf(row.get("CRD_PGM"));

				info.setHoTen(_hoTen);
				info.setLoc(_cif);
				info.setCif(_Loc);
				info.setcardProgram(_CardProgram);
				return info;
			}
		}
		return info;
	}

	public List<DisputesIssCard> chitiet_TheNoiDia_ISS(long createTime) {
		String sql = "select CRD_CUST_NAME, (SELECT ccps.ded2(CRD_PAN,'') from dual) PAN, CRD_CIF_NO,  "
				+ " CRD_MERC_NAME, CRD_TID, CRD_CASE_ID, CRD_TXN_DT, CRD_TXN_AMT, CRD_REC_DT, CRD_APV_CDE, CRD_TRACE, "
				+ " CRD_THOIGIANXULYCONLAI, CRD_CASE_STATUS, CRD_DIS_REASON_CDE, CRD_PROC_PROG,DONE_END_DATE, DONE_RESULT, DONE_KQ_KHAC, "
				+ "  DONE_NGAYHOANTRA, DONE_PHIKHIEUNAISAI, NGUYENNHANKHAC, CRD_TS_LAN1, CRD_NGAYTS_LAN1, CRD_TS_LAN2, "
				+ "   CRD_NGAYTS_LAN2, CRD_NGAYTHUONGLUONG, CRD_NGAYHOAGIAI_NAPAS, CRD_NGAYTS_LAN1_TXT, CRD_NGAYTS_LAN1_TXT_TIME "
				+ "   from ccps.disputes_iss_card_v2 where CRD_CARD_TYPE = 'LOCAL DEBIT' and crd_cre_tms = "
				+ createTime + " and rownum <= 1";

		DisputesIssCard result = new DisputesIssCard();
		List<DisputesIssCard> listIssCard = new ArrayList<DisputesIssCard>();
		List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql);
		int count = list.size();

		if (count == 0) {
			return null;
		} else {
			for (Map<String, Object> row : list) {

				String custName = String.valueOf(row.get("CRD_CUST_NAME"));
				String soThe = String.valueOf(row.get("PAN"));
				String cifNo = String.valueOf(row.get("CRD_CIF_NO"));
				String merchantName = String.valueOf(row.get("CRD_MERC_NAME"));
				String tId = String.valueOf(row.get("CRD_TID"));
				String caseId = String.valueOf(row.get("CRD_CASE_ID"));
				String trxnDate = String.valueOf(row.get("CRD_TXN_DT"));
				String trxnAmt = String.valueOf(row.get("CRD_TXN_AMT"));
				String recDate = String.valueOf(row.get("CRD_REC_DT"));
				String appCode = String.valueOf(row.get("CRD_APV_CDE"));
				String traceCode = String.valueOf(row.get("CRD_TRACE"));
				String thoiGianXuLyConLai = String.valueOf(row.get("CRD_THOIGIANXULYCONLAI"));
				String caseStatus = String.valueOf(row.get("CRD_CASE_STATUS"));
				String reasonCode = String.valueOf(row.get("CRD_DIS_REASON_CDE"));
				String tienDoXuLy = String.valueOf(row.get("CRD_PROC_PROG"));
				String doneEndDate = String.valueOf(row.get("DONE_END_DATE"));
				String doneResult = String.valueOf(row.get("DONE_RESULT"));
				String doneKQKhac = String.valueOf(row.get("DONE_KQ_KHAC"));
				String doneNgayhoantra = String.valueOf(row.get("DONE_NGAYHOANTRA"));
				String donePhikhieunaisai = String.valueOf(row.get("DONE_PHIKHIEUNAISAI"));
				String nguyenNhanKhac = String.valueOf(row.get("NGUYENNHANKHAC"));
				String tsLan1 = String.valueOf(row.get("CRD_TS_LAN1"));
				String ngayTsLan1 = String.valueOf(row.get("CRD_NGAYTS_LAN1"));
				String ngayTsLan1Txt = String.valueOf(row.get("CRD_NGAYTS_LAN1_TXT"));
				String ngayTsLan1TxtTime = String.valueOf(row.get("CRD_NGAYTS_LAN1_TXT_TIME"));
				String tsLan2 = String.valueOf(row.get("CRD_TS_LAN2"));
				String ngayTsLan2 = String.valueOf(row.get("CRD_NGAYTS_LAN2"));
				String ngayThuongLuong = String.valueOf(row.get("CRD_NGAYTHUONGLUONG"));
				String ngayHoaGiaiNapas = String.valueOf(row.get("CRD_NGAYHOAGIAI_NAPAS"));

				if (!doneEndDate.equals("null")) {
					result.setDoneEndDate(Integer.parseInt(doneEndDate));
				} else {
					result.setDoneEndDate(00000000);
				}

				result.setDoneResult(doneResult);

				if (!doneNgayhoantra.equals("null")) {
					result.setDoneNgayhoantra(Integer.parseInt(doneNgayhoantra));
				} else {
					result.setDoneNgayhoantra(00000000);
				}

				result.setDoneResult(doneResult);
				result.setDonePhikhieunaisai(donePhikhieunaisai);
				result.setCrdCustName(custName);
				result.setCrdPan(soThe);
				result.setCrdCifNo(cifNo);
				result.setCrdMercName(merchantName);
				result.setCrdTid(tId);
				result.setCrdCaseId(caseId);
				result.setCrdTxnDt(Integer.parseInt(trxnDate));
				result.setCrdTxnAmt(Float.parseFloat(trxnAmt));
				result.setCrdRecDt(Integer.parseInt(recDate));
				result.setCrdApvCde(appCode);
				result.setCrdTrace(traceCode);
				result.setCrdTsLan1(tsLan1);
				result.setCrdTsLan2(tsLan2);

				if (!ngayTsLan1.equals("null")) {
					result.setCrdNgayTsLan1(Integer.parseInt(ngayTsLan1));
				}

				if (!ngayTsLan1Txt.equals("null")) {
					result.setCrdNgayTsLan1Txt(Integer.parseInt(ngayTsLan1Txt));
				}

				if (!ngayTsLan1TxtTime.equals("null")) {
					result.setCrdNgayTsLan1TxtTime(Integer.parseInt(ngayTsLan1TxtTime));
				} else {
					result.setCrdNgayTsLan1TxtTime(-999);// -999 flag ghi nhan
															// thoiGianXuLyConLai
															// = null
				}

				if (!ngayTsLan2.equals("null")) {
					result.setCrdNgayTsLan2(Integer.parseInt(ngayTsLan2));
				}

				if (!ngayThuongLuong.equals("null")) {
					result.setCrdNgayThuongLuong(Integer.parseInt(ngayThuongLuong));
				}

				if (!ngayHoaGiaiNapas.equals("null")) {
					result.setCrdNgayHoaGiaiNapas(Integer.parseInt(ngayHoaGiaiNapas));
				}

				if (!thoiGianXuLyConLai.equals("null")) {
					result.setcrdThoiGianXuLyConLai(Integer.parseInt(thoiGianXuLyConLai));
				} else {
					result.setcrdThoiGianXuLyConLai(-999);// -999 flag ghi nhan
															// thoiGianXuLyConLai
															// = null
				}

				result.setCrdCaseStatus(caseStatus);
				result.setCrdDisReasonCde(reasonCode);
				result.setnguyennhankhac(nguyenNhanKhac);
				result.setdoneKqKhac(doneKQKhac);

				if (tienDoXuLy.equals("null")) {
					result.setCrdProcProg("");
				} else {
					result.setCrdProcProg(tienDoXuLy);
				}

				listIssCard.add(result);
				return listIssCard;
			}
		}
		return null;
	}

	public void update_case_iss_local_card(String crdTsLan1, String crdNgayTsLan1, String crdNgayTsLan1Txt,
			String crdTsLan2, String crdNgayTsLan2, String crdNgayThuongLuong, String crdNgayHoaGiaiNapas,
			String doneEndDate, String doneResult, String doneNgayhoantra, String donePhikhieunaisai,
			String crdCaseStatus, String crdDisReasonCde, String lyDoTraSoatKhac, String quaTrinhXuLy,
			String createTime, String updateTime, String userUpdate) {
		Common common = new Common();
		String sql = "update ccps.disputes_iss_card_v2 set CRD_CASE_STATUS = '_010', CRD_PROC_PROG = '_011', CRD_DIS_REASON_CDE = '_012', NGUYENNHANKHAC = '_013', CRD_TS_LAN1 = '_014', CRD_NGAYTS_LAN1 = '_015', CRD_NGAYTS_LAN1_TXT = '_027', CRD_TS_LAN2 = '_016', CRD_NGAYTS_LAN2 = '_017', CRD_NGAYTHUONGLUONG = '_018', CRD_NGAYHOAGIAI_NAPAS = '_019', DONE_END_DATE = _020, DONE_RESULT = '_021', DONE_NGAYHOANTRA = '_022', DONE_PHIKHIEUNAISAI = '_023', CRD_USER_UPDT = '_024', CRD_TIME_UPDT = '_025' where CRD_CARD_TYPE = 'LOCAL DEBIT' and CRD_CRE_TMS = _026";
		sql = sql.replaceAll("_010", crdCaseStatus);
		sql = sql.replaceAll("_011", quaTrinhXuLy);
		sql = sql.replaceAll("_012", crdDisReasonCde);
		sql = sql.replaceAll("_013", lyDoTraSoatKhac);

		sql = sql.replaceAll("_024", userUpdate);
		sql = sql.replaceAll("_025", updateTime);
		sql = sql.replaceAll("_026", createTime);

		if (crdCaseStatus.equals("Pending")) {
			sql = sql.replaceAll(
					"CRD_TS_LAN1 = '_014', CRD_NGAYTS_LAN1 = '_015', CRD_NGAYTS_LAN1_TXT = '_027', CRD_TS_LAN2 = '_016', CRD_NGAYTS_LAN2 = '_017', CRD_NGAYTHUONGLUONG = '_018', CRD_NGAYHOAGIAI_NAPAS = '_019', DONE_END_DATE = _020, DONE_RESULT = '_021', DONE_NGAYHOANTRA = '_022', DONE_PHIKHIEUNAISAI = '_023',",
					"");
		}
		if (crdCaseStatus.equals("TS lan 1")) {
			sql = sql.replaceAll(
					" CRD_TS_LAN2 = '_016', CRD_NGAYTS_LAN2 = '_017', CRD_NGAYTHUONGLUONG = '_018', CRD_NGAYHOAGIAI_NAPAS = '_019', DONE_END_DATE = _020, DONE_RESULT = '_021', DONE_NGAYHOANTRA = '_022', DONE_PHIKHIEUNAISAI = '_023', ",
					"");
			sql = sql.replaceAll("_014", crdTsLan1);
			if (crdNgayTsLan1.equals("--0") || crdNgayTsLan1.equals("")) {
				sql = sql.replaceAll("CRD_NGAYTS_LAN1 = '_015',", "");
			} else {
				sql = sql.replaceAll("_015", common.formatTime_yyyymmdd(crdNgayTsLan1));
			}
			if (crdNgayTsLan1Txt.equals("--0") || crdNgayTsLan1Txt.equals("")) {
				sql = sql.replaceAll("CRD_NGAYTS_LAN1_TXT = '_027',", "");
			} else {
				sql = sql.replaceAll("_027", common.formatTime_yyyymmdd(crdNgayTsLan1Txt));
			}
		}
		if (crdCaseStatus.equals("TS lan 2")) {
			sql = sql.replaceAll(" CRD_TS_LAN1 = '_014', CRD_NGAYTS_LAN1 = '_015', CRD_NGAYTS_LAN1_TXT = '_027',", "");
			sql = sql.replaceAll(
					"CRD_NGAYTHUONGLUONG = '_018', CRD_NGAYHOAGIAI_NAPAS = '_019', DONE_END_DATE = _020, DONE_RESULT = '_021', DONE_NGAYHOANTRA = '_022', DONE_PHIKHIEUNAISAI = '_023', ",
					"");
			sql = sql.replaceAll("_016", crdTsLan2);
			if (crdNgayTsLan2.equals("--0") || crdNgayTsLan2.equals("")) {
				sql = sql.replaceAll("CRD_NGAYTS_LAN2 = '_017',", "");
			} else {
				sql = sql.replaceAll("_017", common.formatTime_yyyymmdd(crdNgayTsLan2));
			}
		}
		if (crdCaseStatus.equals("Thuong luong, hoa giai")) {
			sql = sql.replaceAll(
					"CRD_TS_LAN1 = '_014', CRD_NGAYTS_LAN1 = '_015', CRD_NGAYTS_LAN1_TXT = '_027', CRD_TS_LAN2 = '_016', CRD_NGAYTS_LAN2 = '_017', ",
					"");
			sql = sql.replaceAll(
					" CRD_NGAYHOAGIAI_NAPAS = '_019', DONE_END_DATE = _020, DONE_RESULT = '_021', DONE_NGAYHOANTRA = '_022', DONE_PHIKHIEUNAISAI = '_023', ",
					"");
			if (crdNgayThuongLuong.equals("--0") || crdNgayThuongLuong.equals("")) {
				sql = sql.replaceAll("CRD_NGAYTHUONGLUONG = '_018',", "");
			} else {
				sql = sql.replaceAll("_018", common.formatTime_yyyymmdd(crdNgayThuongLuong));
			}
		}
		if (crdCaseStatus.equals("HD hoa giai Napas/Trong tai/Toa an")) {
			sql = sql.replaceAll(
					"CRD_TS_LAN1 = '_014', CRD_NGAYTS_LAN1 = '_015', CRD_NGAYTS_LAN1_TXT = '_027', CRD_TS_LAN2 = '_016', CRD_NGAYTS_LAN2 = '_017', CRD_NGAYTHUONGLUONG = '_018', ",
					"");
			sql = sql.replaceAll(
					"DONE_END_DATE = _020, DONE_RESULT = '_021', DONE_NGAYHOANTRA = '_022', DONE_PHIKHIEUNAISAI = '_023', ",
					"");
			if (crdNgayHoaGiaiNapas.equals("--0") || crdNgayHoaGiaiNapas.equals("")) {
				sql = sql.replaceAll("CRD_NGAYHOAGIAI_NAPAS = '_019',", "");
			} else {
				sql = sql.replaceAll("_019", common.formatTime_yyyymmdd(crdNgayHoaGiaiNapas));
			}
		}

		if (crdCaseStatus.equals("Done")) {
			sql = sql.replaceAll(
					"CRD_TS_LAN1 = '_014', CRD_NGAYTS_LAN1 = '_015', CRD_NGAYTS_LAN1_TXT = '_027', CRD_TS_LAN2 = '_016', CRD_NGAYTS_LAN2 = '_017', CRD_NGAYTHUONGLUONG = '_018', CRD_NGAYHOAGIAI_NAPAS = '_019', ",
					"");
			if (doneEndDate.equals("--0") || doneEndDate.equals("")) {
				sql = sql.replaceAll("DONE_END_DATE = _020,", "");
			} else {
				sql = sql.replaceAll("_020", common.formatTime_yyyymmdd(doneEndDate));
			}
			sql = sql.replaceAll("_021", doneResult);
			if (doneEndDate.equals("--0") || doneEndDate.equals("")) {
				sql = sql.replaceAll("DONE_NGAYHOANTRA = '_022',", "");
			} else {
				sql = sql.replaceAll("_022", common.formatTime_yyyymmdd(doneNgayhoantra));
			}
			sql = sql.replaceAll("_023", donePhikhieunaisai);
		}

		try {
			getJdbcTemplate().update(sql);
		} catch (Exception e) {
			logger.warn("ISSCardDao, function update_case_iss_local_card() error: " + e.toString());
		}
	}

	public void delete_case_iss_local_card(String createTime) {
		String sql = "update ccps.disputes_iss_card_v2 set STATUS = '1' where CRD_CRE_TMS = " + createTime
				+ " and rownum <= 1";
		try {
			getJdbcTemplate().update(sql);
		} catch (Exception e) {
			System.out.println("LOI DELETE CASE THE QUOC TE: " + e.toString());
		}
	}

	public void xuLyCreateTimeSauKhiImportFile() {
		String sql1 = "select * from ccps.disputes_iss_card_v2 where LENGTH(CRD_CRE_TMS) < 17";
		String sql = "update ccps.disputes_iss_card_v2 set crd_cre_tms = _111 where CRD_PAN = '_222' and CRD_TXN_DT = '_333' and CRD_APV_CDE = _444 and CRD_CRE_TMS = '_555'";

		DisputesIssCard result = new DisputesIssCard();
		List<DisputesIssCard> listIssCard = new ArrayList<DisputesIssCard>();
		List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql1);
		int count = list.size();

		if (count == 0) {
			return;
		} else {
			long i = 1;
			for (Map<String, Object> row : list) {
				long temp = Long.parseLong("20191202092710187");
				long createTime = temp + i;

				String createTime_DB = String.valueOf(row.get("crd_cre_tms"));
				String pan = String.valueOf(row.get("CRD_PAN"));
				String trxnDate = String.valueOf(row.get("CRD_TXN_DT"));
				String appCode = String.valueOf(row.get("CRD_APV_CDE"));
				sql = sql.replaceAll("_111", String.valueOf(createTime));
				sql = sql.replaceAll("_222", pan);
				sql = sql.replaceAll("_333", trxnDate);

				if (appCode.equals("null")) {
					sql = sql.replaceAll("= _444", "is null");
				} else {
					sql = sql.replaceAll("_444", appCode);
				}
				sql = sql.replaceAll("_555", createTime_DB);

				try {
					getJdbcTemplate().update(sql);
					sql = sql.replaceAll(String.valueOf(createTime), "_111");
					sql = sql.replaceAll(pan, "_222");
					sql = sql.replaceAll(trxnDate, "_333");
					sql = sql.replaceAll(createTime_DB, "_555");
					if (appCode.equals("null")) {
						sql = sql.replaceAll("CRD_APV_CDE is null", "CRD_APV_CDE = _444");
					} else {
						sql = sql.replaceAll(appCode, "_444");
					}

					i++;
				} catch (Exception e) {
					logger.warn("ISSCardDao, function xuLyCreateTimeSauKhiImportFile() error: " + e.toString());
				}
			}
		}
	}

	public void xuLyMaHoaSoTheSauKhiImportFile() {
		String sql1 = "select CRD_CRE_TMS, CRD_PAN from ccps.disputes_iss_card_v2 where LENGTH(CRD_PAN) <= 16";
		String sql = "update ccps.disputes_iss_card_v2 set CRD_PAN = '_111' where CRD_CRE_TMS = '_222'";

		DisputesIssCard result = new DisputesIssCard();
		List<DisputesIssCard> listIssCard = new ArrayList<DisputesIssCard>();
		List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql1);
		int count = list.size();

		if (count == 0) {
			return;
		} else {
			for (Map<String, Object> row : list) {

				String createTime = String.valueOf(row.get("CRD_CRE_TMS"));
				String pan = String.valueOf(row.get("CRD_PAN"));
				String maHoa = commonDAO.maHoaSoThe(pan);
				sql = sql.replaceAll("_111", maHoa); // ma hoa so the & update
														// lai vao DB
				sql = sql.replaceAll("_222", createTime);

				try {
					getJdbcTemplate().update(sql);
					sql = sql.replaceAll(maHoa, "_111");
					sql = sql.replaceAll(createTime, "_222");
				} catch (Exception e) {
					logger.warn("ISSCardDao, function xuLyMaHoaSoTheSauKhiImportFile() error: " + e.toString());
				}
			}
		}
	}
}
