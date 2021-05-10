package entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class DisputesIssCard implements Serializable {

	private BigDecimal crdId;
	private String crdCreTms;
	private String crdUid;
	private String crdCifNo;
	private String crdCustName;
	private String crdLoc;
	private String crdPan;
	private String crdBrn;
	private String crdAcq;
	private String crdMercName;
	private String crdMercId;
	private String crdTid;
	private Integer crdTxnDt;
	private Integer crdPstDt; // ngay hach toan
	private Float crdTxnAmt;
	private String crdCurrCde;
	private Float crdVndAmt;
	private String crdTxnType;
	private String crdFraudTxn;
	private String crdPosMode;
	private Integer crdMcc;
	private String crdApvCde;
	private String crdTrace;
	private String crdArn;
	private Integer crdRecDt;
	private String crdDisReasonCde;
	private String crdProcProg;
	private String crdCaseStatus;
	private String crdTxnProcResult;
	private BigDecimal crdDisFee;
	private Integer crdFeeChargeDt;
	private String crdCaseId;
	private String crdDocument;
	private String crdRemark;
	private String crdCrdType;
	private Integer crdNgayhoantragd;
	private String crdCusgrp;
	private String status;

	private String rrCode;
	private Integer rrDate;
	private String cbCode;
	private Integer cbDate;
	private Integer cbNgayTxt;
	private Integer cbThoigianconlaiTxt;
	private String acCode;
	private Integer acDate;
	private String preArCode;
	private Integer preArDate;
	private Integer preArNgayphanhoi;
	private Integer preArThoigianconlai;
	private Integer preArRespDate;
	private String arCode;
	private Integer arDate;
	private Integer doneEndDate;
	private String doneResult;
	private Integer doneNgayhoantra;
	private String donePhikhieunaisai;

	private String ica;
	private Integer crdThoiGianXuLy;
	private Integer crdThoiGianXuLyConLai;
	private String crdUserCreate;
	private String crd3dIn;
	private String crdCardProgram;
	private String nguyennhankhac;
	private String crdTrxnChannel;
	private String doneKqKhac;
	private Integer crdTxnAmt_int; // crdTxnAmt_integer

	private String crdTsLan1;
	private Integer crdNgayTsLan1;
	private String crdTsLan2;
	private Integer crdNgayTsLan2;
	private Integer crdNgayThuongLuong;
	private Integer crdNgayHoaGiaiNapas;
	private Integer crdNgayTsLan1Txt;
	private Integer crdNgayTsLan1TxtTime;

	public DisputesIssCard() {
	}

	public DisputesIssCard(BigDecimal crdId) {
		this.crdId = crdId;
	}

	public DisputesIssCard(BigDecimal crdId, String crdCreTms, String crdUid, String crdCifNo, String crdCustName,
			String crdLoc, String crdPan, String crdBrn, String crdAcq, String crdMercName, String crdMercId,
			String crdTid, Integer crdTxnDt, Integer crdPstDt, Float crdTxnAmt, String crdCurrCde, Float crdVndAmt,
			String crdTxnType, String crdFraudTxn, String crdPosMode, Integer crdMcc, String crdApvCde, String crdTrace,
			String crdArn, Integer crdRecDt, String crdDisReasonCde, String crdProcProg, String crdCaseStatus,
			String crdTxnProcResult, BigDecimal crdDisFee, Integer crdFeeChargeDt, String crdCaseId, String crdDocument,
			String crdRemark, String crdCrdType, Integer crdNgayhoantragd, String crdCusgrp, String status,
			String rrCode, Integer rrDate, String cbCode, Integer cbDate, Integer cbNgayTxt,
			Integer cbThoigianconlaiTxt, String acCode, Integer acDate, String preArCode, Integer preArDate,
			Integer preArNgayphanhoi, Integer preArThoigianconlai, Integer preArRespDate, String arCode, Integer arDate,
			Integer doneEndDate, String doneResult, Integer doneNgayhoantra, String donePhikhieunaisai, String ica,
			String localAmount, Integer crdThoiGianXuLy, Integer crdThoiGianXuLyConLai, String crdUserCreate,
			String crd3dIn, String crdCardProgram, String nguyennhankhac, String crdTrxnChannel, String doneKqKhac) {
		this.crdId = crdId;
		this.crdCreTms = crdCreTms;
		this.crdUid = crdUid;
		this.crdCifNo = crdCifNo;
		this.crdCustName = crdCustName;
		this.crdLoc = crdLoc;
		this.crdPan = crdPan;
		this.crdBrn = crdBrn;
		this.crdAcq = crdAcq;
		this.crdMercName = crdMercName;
		this.crdMercId = crdMercId;
		this.crdTid = crdTid;
		this.crdTxnDt = crdTxnDt;
		this.crdPstDt = crdPstDt;
		this.crdTxnAmt = crdTxnAmt;
		this.crdCurrCde = crdCurrCde;
		this.crdVndAmt = crdVndAmt;
		this.crdTxnType = crdTxnType;
		this.crdFraudTxn = crdFraudTxn;
		this.crdPosMode = crdPosMode;
		this.crdMcc = crdMcc;
		this.crdApvCde = crdApvCde;
		this.crdTrace = crdTrace;
		this.crdArn = crdArn;
		this.crdRecDt = crdRecDt;
		this.crdDisReasonCde = crdDisReasonCde;
		this.crdProcProg = crdProcProg;
		this.crdCaseStatus = crdCaseStatus;
		this.crdTxnProcResult = crdTxnProcResult;
		this.crdDisFee = crdDisFee;
		this.crdFeeChargeDt = crdFeeChargeDt;
		this.crdCaseId = crdCaseId;
		this.crdDocument = crdDocument;
		this.crdRemark = crdRemark;
		this.crdCrdType = crdCrdType;
		this.crdNgayhoantragd = crdNgayhoantragd;
		this.crdCusgrp = crdCusgrp;
		this.status = status;

		this.rrCode = rrCode;
		this.rrDate = rrDate;
		this.cbCode = cbCode;
		this.cbDate = cbDate;
		this.cbNgayTxt = cbNgayTxt;
		this.cbThoigianconlaiTxt = cbThoigianconlaiTxt;
		this.acCode = acCode;
		this.acDate = acDate;
		this.preArCode = preArCode;
		this.preArDate = preArDate;
		this.preArNgayphanhoi = preArNgayphanhoi;
		this.preArThoigianconlai = preArThoigianconlai;
		this.preArRespDate = preArRespDate;
		this.arCode = arCode;
		this.arDate = arDate;
		this.doneEndDate = doneEndDate;
		this.doneResult = doneResult;
		this.doneNgayhoantra = doneNgayhoantra;
		this.donePhikhieunaisai = donePhikhieunaisai;

		this.ica = ica;
		this.crdThoiGianXuLyConLai = crdThoiGianXuLy;
		this.crdThoiGianXuLyConLai = crdThoiGianXuLyConLai;
		this.crdUserCreate = crdUserCreate;
		this.crd3dIn = crd3dIn;
		this.crdCardProgram = crdCardProgram;
		this.nguyennhankhac = nguyennhankhac;
		this.crdTrxnChannel = crdTrxnChannel;
		this.doneKqKhac = doneKqKhac;
	}

	public BigDecimal getCrdId() {
		return this.crdId;
	}

	public void setCrdId(BigDecimal crdId) {
		this.crdId = crdId;
	}

	public String getCrdCreTms() {
		return this.crdCreTms;
	}

	public void setCrdCreTms(String crdCreTms) {
		this.crdCreTms = crdCreTms;
	}

	public String getCrdUid() {
		return this.crdUid;
	}

	public void setCrdUid(String crdUid) {
		this.crdUid = crdUid;
	}

	public String getCrdCifNo() {
		return this.crdCifNo;
	}

	public void setCrdCifNo(String crdCifNo) {
		this.crdCifNo = crdCifNo;
	}

	public String getCrdCustName() {
		return this.crdCustName;
	}

	public void setCrdCustName(String crdCustName) {
		this.crdCustName = crdCustName;
	}

	public String getCrdLoc() {
		return this.crdLoc;
	}

	public void setCrdLoc(String crdLoc) {
		this.crdLoc = crdLoc;
	}

	public String getCrdPan() {
		return this.crdPan;
	}

	public void setCrdPan(String crdPan) {
		this.crdPan = crdPan;
	}

	public String getCrdBrn() {
		return this.crdBrn;
	}

	public void setCrdBrn(String crdBrn) {
		this.crdBrn = crdBrn;
	}

	public String getCrdAcq() {
		return this.crdAcq;
	}

	public void setCrdAcq(String crdAcq) {
		this.crdAcq = crdAcq;
	}

	public String getCrdMercName() {
		return this.crdMercName;
	}

	public void setCrdMercName(String crdMercName) {
		this.crdMercName = crdMercName;
	}

	public String getCrdMercId() {
		return this.crdMercId;
	}

	public void setCrdMercId(String crdMercId) {
		this.crdMercId = crdMercId;
	}

	public String getCrdTid() {
		return this.crdTid;
	}

	public void setCrdTid(String crdTid) {
		this.crdTid = crdTid;
	}

	public Integer getCrdTxnDt() {
		return this.crdTxnDt;
	}

	public void setCrdTxnDt(Integer crdTxnDt) {
		this.crdTxnDt = crdTxnDt;
	}

	public Integer getCrdPstDt() {
		return this.crdPstDt;
	}

	public void setCrdPstDt(Integer crdPstDt) {
		this.crdPstDt = crdPstDt;
	}

	public Float getCrdTxnAmt() {
		return this.crdTxnAmt;
	}

	public void setCrdTxnAmt(float crdTxnAmt) {
		this.crdTxnAmt = crdTxnAmt;
	}

	public String getCrdCurrCde() {
		return this.crdCurrCde;
	}

	public void setCrdCurrCde(String crdCurrCde) {
		this.crdCurrCde = crdCurrCde;
	}

	public float getCrdVndAmt() {
		return this.crdVndAmt;
	}

	public void setCrdVndAmt(float crdVndAmt) {
		this.crdVndAmt = crdVndAmt;
	}

	public String getCrdTxnType() {
		return this.crdTxnType;
	}

	public void setCrdTxnType(String crdTxnType) {
		this.crdTxnType = crdTxnType;
	}

	public String getCrdFraudTxn() {
		return this.crdFraudTxn;
	}

	public void setCrdFraudTxn(String crdFraudTxn) {
		this.crdFraudTxn = crdFraudTxn;
	}

	public String getCrdPosMode() {
		return this.crdPosMode;
	}

	public void setCrdPosMode(String crdPosMode) {
		this.crdPosMode = crdPosMode;
	}

	public Integer getCrdMcc() {
		return this.crdMcc;
	}

	public void setCrdMcc(Integer crdMcc) {
		this.crdMcc = crdMcc;
	}

	public String getCrdApvCde() {
		return this.crdApvCde;
	}

	public void setCrdApvCde(String crdApvCde) {
		this.crdApvCde = crdApvCde;
	}

	public String getCrdTrace() {
		return this.crdTrace;
	}

	public void setCrdTrace(String crdTrace) {
		this.crdTrace = crdTrace;
	}

	public String getCrdArn() {
		return this.crdArn;
	}

	public void setCrdArn(String crdArn) {
		this.crdArn = crdArn;
	}

	public Integer getCrdRecDt() {
		return this.crdRecDt;
	}

	public void setCrdRecDt(Integer crdRecDt) {
		this.crdRecDt = crdRecDt;
	}

	public String getCrdDisReasonCde() {
		return this.crdDisReasonCde;
	}

	public void setCrdDisReasonCde(String crdDisReasonCde) {
		this.crdDisReasonCde = crdDisReasonCde;
	}

	public String getCrdProcProg() {
		return this.crdProcProg;
	}

	public void setCrdProcProg(String crdProcProg) {
		this.crdProcProg = crdProcProg;
	}

	public String getCrdCaseStatus() {
		return this.crdCaseStatus;
	}

	public void setCrdCaseStatus(String crdCaseStatus) {
		this.crdCaseStatus = crdCaseStatus;
	}

	public String getCrdTxnProcResult() {
		return this.crdTxnProcResult;
	}

	public void setCrdTxnProcResult(String crdTxnProcResult) {
		this.crdTxnProcResult = crdTxnProcResult;
	}

	public BigDecimal getCrdDisFee() {
		return this.crdDisFee;
	}

	public void setCrdDisFee(BigDecimal crdDisFee) {
		this.crdDisFee = crdDisFee;
	}

	public Integer getCrdFeeChargeDt() {
		return this.crdFeeChargeDt;
	}

	public void setCrdFeeChargeDt(Integer crdFeeChargeDt) {
		this.crdFeeChargeDt = crdFeeChargeDt;
	}

	public String getCrdCaseId() {
		return this.crdCaseId;
	}

	public void setCrdCaseId(String crdCaseId) {
		this.crdCaseId = crdCaseId;
	}

	public String getCrdDocument() {
		return this.crdDocument;
	}

	public void setCrdDocument(String crdDocument) {
		this.crdDocument = crdDocument;
	}

	public String getCrdRemark() {
		return this.crdRemark;
	}

	public void setCrdRemark(String crdRemark) {
		this.crdRemark = crdRemark;
	}

	public String getCrdCrdType() {
		return this.crdCrdType;
	}

	public void setCrdCrdType(String crdCrdType) {
		this.crdCrdType = crdCrdType;
	}

	public Integer getcrdNgayhoantragd() {
		return this.crdNgayhoantragd;
	}

	public void setcrdNgayhoantragd(Integer crdNgayhoantragd) {
		this.crdNgayhoantragd = crdNgayhoantragd;
	}

	public String getCusgrp() {
		return this.crdCusgrp;
	}

	public void setCusgrp(String crdCusgrp) {
		this.crdCusgrp = crdCusgrp;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIca() {
		return this.ica;
	}

	public void setIca(String ica) {
		this.ica = ica;
	}

	public void setcrdThoiGianXuLy(Integer crdThoiGianXuLy) {
		this.crdThoiGianXuLy = crdThoiGianXuLy;
	}

	public Integer getcrdThoiGianXuLy() {
		return this.crdThoiGianXuLy;
	}

	public void setcrdThoiGianXuLyConLai(Integer crdThoiGianXuLyConLai) {
		this.crdThoiGianXuLyConLai = crdThoiGianXuLyConLai;
	}

	public Integer getcrdThoiGianXuLyConLai() {
		return this.crdThoiGianXuLyConLai;
	}

	public String getcrdUserCreate() {
		return this.crdUserCreate;
	}

	public void setcrdUserCreate(String crdUserCreate) {
		this.crdUserCreate = crdUserCreate;
	}

	public String getcrd3dIn() {
		return this.crd3dIn;
	}

	public void setcrd3dIn(String crd3dIn) {
		this.crd3dIn = crd3dIn;
	}

	public String getcrdCardProgram() {
		return this.crdCardProgram;
	}

	public void setcrdCardProgram(String crdCardProgram) {
		this.crdCardProgram = crdCardProgram;
	}

	public String getRrCode() {
		return rrCode;
	}

	public void setRrCode(String rrCode) {
		this.rrCode = rrCode;
	}

	public Integer getRrDate() {
		return rrDate;
	}

	public void setRrDate(Integer rrDate) {
		this.rrDate = rrDate;
	}

	public String getCbCode() {
		return cbCode;
	}

	public void setCbCode(String cbCode) {
		this.cbCode = cbCode;
	}

	public Integer getCbDate() {
		return cbDate;
	}

	public void setCbDate(Integer cbDate) {
		this.cbDate = cbDate;
	}

	public Integer getCbNgayTxt() {
		return cbNgayTxt;
	}

	public void setCbNgayTxt(Integer cbNgayTxt) {
		this.cbNgayTxt = cbNgayTxt;
	}

	public Integer getCbThoigianconlaiTxt() {
		return cbThoigianconlaiTxt;
	}

	public void setCbThoigianconlaiTxt(Integer cbThoigianconlaiTxt) {
		this.cbThoigianconlaiTxt = cbThoigianconlaiTxt;
	}

	public String getAcCode() {
		return acCode;
	}

	public void setAcCode(String acCode) {
		this.acCode = acCode;
	}

	public Integer getAcDate() {
		return acDate;
	}

	public void setAcDate(Integer acDate) {
		this.acDate = acDate;
	}

	public String getPreArCode() {
		return preArCode;
	}

	public void setPreArCode(String preArCode) {
		this.preArCode = preArCode;
	}

	public Integer getPreArDate() {
		return preArDate;
	}

	public void setPreArDate(Integer preArDate) {
		this.preArDate = preArDate;
	}

	public Integer getPreArNgayphanhoi() {
		return preArNgayphanhoi;
	}

	public void setPreArNgayphanhoi(Integer preArNgayphanhoi) {
		this.preArNgayphanhoi = preArNgayphanhoi;
	}

	public Integer getPreArThoigianconlai() {
		return preArThoigianconlai;
	}

	public void setPreArThoigianconlai(Integer preArThoigianconlai) {
		this.preArThoigianconlai = preArThoigianconlai;
	}

	public Integer getPreArRespDate() {
		return preArRespDate;
	}

	public void setPreArRespDate(Integer preArRespDate) {
		this.preArRespDate = preArRespDate;
	}

	public String getArCode() {
		return arCode;
	}

	public void setArCode(String arCode) {
		this.arCode = arCode;
	}

	public Integer getArDate() {
		return arDate;
	}

	public void setArDate(Integer arDate) {
		this.arDate = arDate;
	}

	public Integer getDoneEndDate() {
		return doneEndDate;
	}

	public void setDoneEndDate(Integer doneEndDate) {
		this.doneEndDate = doneEndDate;
	}

	public String getDoneResult() {
		return doneResult;
	}

	public void setDoneResult(String doneResult) {
		this.doneResult = doneResult;
	}

	public Integer getDoneNgayhoantra() {
		return doneNgayhoantra;
	}

	public void setDoneNgayhoantra(Integer doneNgayhoantra) {
		this.doneNgayhoantra = doneNgayhoantra;
	}

	public String getDonePhikhieunaisai() {
		return donePhikhieunaisai;
	}

	public void setDonePhikhieunaisai(String donePhikhieunaisai) {
		this.donePhikhieunaisai = donePhikhieunaisai;
	}

	public String getnguyennhankhac() {
		return nguyennhankhac;
	}

	public void setnguyennhankhac(String nguyennhankhac) {
		this.nguyennhankhac = nguyennhankhac;
	}

	public String getcrdTrxnChannel() {
		return crdTrxnChannel;
	}

	public void setcrdTrxnChannel(String crdTrxnChannel) {
		this.crdTrxnChannel = crdTrxnChannel;
	}

	public String getdoneKqKhac() {
		return doneKqKhac;
	}

	public void setdoneKqKhac(String doneKqKhac) {
		this.doneKqKhac = doneKqKhac;
	}

	public Integer getCrdTxnAmt_int() {
		return this.crdTxnAmt_int;
	}

	public void setCrdTxnAmt_int(int crdTxnAmt_int) {
		this.crdTxnAmt_int = crdTxnAmt_int;
	}

	public String getCrdTsLan1() {
		return crdTsLan1;
	}

	public void setCrdTsLan1(String crdTsLan1) {
		this.crdTsLan1 = crdTsLan1;
	}

	public Integer getCrdNgayTsLan1() {
		return crdNgayTsLan1;
	}

	public void setCrdNgayTsLan1(Integer crdNgayTsLan1) {
		this.crdNgayTsLan1 = crdNgayTsLan1;
	}

	public String getCrdTsLan2() {
		return crdTsLan2;
	}

	public void setCrdTsLan2(String crdTsLan2) {
		this.crdTsLan2 = crdTsLan2;
	}

	public Integer getCrdNgayTsLan2() {
		return crdNgayTsLan2;
	}

	public void setCrdNgayTsLan2(Integer crdNgayTsLan2) {
		this.crdNgayTsLan2 = crdNgayTsLan2;
	}

	public Integer getCrdNgayThuongLuong() {
		return crdNgayThuongLuong;
	}

	public void setCrdNgayThuongLuong(Integer crdNgayThuongLuong) {
		this.crdNgayThuongLuong = crdNgayThuongLuong;
	}

	public Integer getCrdNgayHoaGiaiNapas() {
		return crdNgayHoaGiaiNapas;
	}

	public void setCrdNgayHoaGiaiNapas(Integer crdNgayHoaGiaiNapas) {
		this.crdNgayHoaGiaiNapas = crdNgayHoaGiaiNapas;
	}

	public Integer getCrdNgayTsLan1Txt() {
		return crdNgayTsLan1Txt;
	}

	public void setCrdNgayTsLan1Txt(Integer crdNgayTsLan1Txt) {
		this.crdNgayTsLan1Txt = crdNgayTsLan1Txt;
	}

	public Integer getCrdNgayTsLan1TxtTime() {
		return crdNgayTsLan1TxtTime;
	}

	public void setCrdNgayTsLan1TxtTime(Integer crdNgayTsLan1TxtTime) {
		this.crdNgayTsLan1TxtTime = crdNgayTsLan1TxtTime;
	}
}
