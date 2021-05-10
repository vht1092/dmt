<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.io.*"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CHI TIẾT CASE: THẺ-CHIỀU NHPH(ISS)</title>
<link rel="SHORTCUT ICON"
	href="<%=request.getContextPath()%>/resources/img/logo/favicon.ico">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/style.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/style_old_version2.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="http://code.jquery.com/jquery-1.7.2.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>


<script>
	$(function() {
		$('#datepicker1').datepicker({
			dateFormat : 'dd-mm-yy'
		});
		$('#datepicker2').datepicker({
			dateFormat : 'dd-mm-yy'
		});
		$('#datepicker3').datepicker({
			dateFormat : 'dd-mm-yy'
		});
		$('#datepicker4').datepicker({
			dateFormat : 'dd-mm-yy'
		});
		$('#datepicker5').datepicker({
			dateFormat : 'dd-mm-yy'
		});
		$('#datepicker6').datepicker({
			dateFormat : 'dd-mm-yy'
		});
		$('#datepicker7').datepicker({
			dateFormat : 'dd-mm-yy'
		});
		$('#datepicker8').datepicker({
			dateFormat : 'dd-mm-yy'
		});
		$('#datepicker9').datepicker({
			dateFormat : 'dd-mm-yy'
		});
		$('#datepicker10').datepicker({
			dateFormat : 'dd-mm-yy'
		});
		$('#datepicker11').datepicker({
			dateFormat : 'dd-mm-yy'
		});
	});
</script>
<style>
.dropdown-submenu {
	position: relative;
}

.dropdown-submenu .dropdown-menu {
	top: 0;
	left: 100%;
	margin-top: -1px;
}

.dtHorizontalVerticalExampleWrapper {
	max-width: 600px;
	margin: 0 auto;
}

#dtHorizontalVerticalExample th, td {
	white-space: nowrap;
}

table, table tr, table tr td {
	cursor: pointer;
}

table tr.active td {
	background-color: #D5EAD5;
}

.scroll {
	width: 100%;
	height: 10px;
	text-align: center;
	vertical-align: middle;
}

.scroll center {
	font-size: 12px;
}

.form-control {
	height: 30px;
}

.thongtin span {
	width: 100%;
}

.thongtin p {
	width: 100%;
}

.thongtin input {
	float: right;
	width: 45%;
}

.thongtin1 input {
	float: right;
	width: 45%
}
</style>
</head>
<body onload="startTime()">
	<header style="margin-bottom: 50px">
		<div class="nameProject">
			<p>
				<a href="index.html">Dispute Management Tool</a>
			</p>
		</div>
		<div class="userLogin">
			<p>
				Hi, <a href="${pageContext.request.contextPath}/logout"
					class="logout" title="Đăng xuất">${fullName}</a>
			</p>
			</br>
			<p id="txt" style="margin-left: 180px; margin-top: -15px"></p>
		</div>
	</header>

	<div class="menu-bar"
		style="box-shadow: 8px 8px 16px 0px #5E9BB4; position: fixed; margin-top: 60px; z-index: 1;">
		<div class="dropdown">
			<button class="btn btn-default dropdown-toggle" type="button"
				data-toggle="dropdown">
				Thẻ-Chiều NHPH(ISS)<span class="caret"></span>
			</button>
			<ul class="dropdown-menu">
				<li class="dropdown-submenu"><a class="test" tabindex="-1"
					href="#">Thẻ quốc tế<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><center>Thẻ quốc tế</center></li>
						<li><a tabindex="-1" href="new_iss_international_card.html"><span
								style="font-weight: bold;">Thêm case mới</span></a></li>
						<li><a tabindex="-1"
							href="search_iss_international_card.html"><span
								style="font-weight: bold;">Truy vấn/Cập nhật</span></a></li>
					</ul></li>
				<li class="dropdown-submenu"><a class="test" tabindex="-1"
					href="#" style="visibility: hidden;">Thẻ nội địa<span
						class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><center>Thẻ nội địa</center></li>
						<li><a tabindex="-1" href="new_iss_local_card.html"><span>Thêm
									case mới</span></a></li>
						<li><a tabindex="-1" href="#"><span style="color: green">Case
									cần xử lý</span></a></li>
						<li><a tabindex="-1" href="#"><span
								style="color: purple;">Case đến hạn</span></a></li>
						<li><a tabindex="-1" href="#"><span style="color: red">Case
									quá hạn</span></a></li>
						<li><a tabindex="-1" href="search_iss_local_card.html">Truy
								vấn/Cập nhật</a></li>
					</ul></li>
			</ul>
		</div>
		<div class="dropdown">
			<button class="btn btn-default dropdown-toggle" type="button"
				data-toggle="dropdown">
				EB-Chiều NHPH(ISS)<span class="caret"></span>
			</button>
			<ul class="dropdown-menu">
				<li><a tabindex="-1" href="#">HTML</a></li>
				<li><a tabindex="-1" href="#">CSS</a></li>
				<li class="dropdown-submenu"><a class="test" tabindex="-1"
					href="#">New dropdown <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a tabindex="-1" href="#">2nd level dropdown</a></li>
						<li><a tabindex="-1" href="#">2nd level dropdown</a></li>
						<li class="dropdown-submenu"><a class="test" href="#">Another
								dropdown <span class="caret"></span>
						</a>
							<ul class="dropdown-menu">
								<li><a href="#">3rd level dropdown</a></li>
								<li><a href="#">3rd level dropdown</a></li>
							</ul></li>
					</ul></li>
			</ul>
		</div>
		<div class="dropdown">
			<button class="btn btn-default dropdown-toggle" type="button"
				data-toggle="dropdown">
				ATM-Chiều NHTT(ACQ) <span class="caret"></span>
			</button>
			<ul class="dropdown-menu">
				<li><a tabindex="-1" href="#">HTML</a></li>
				<li><a tabindex="-1" href="#">CSS</a></li>
				<li class="dropdown-submenu"><a class="test" tabindex="-1"
					href="#">New dropdown <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a tabindex="-1" href="#">2nd level dropdown</a></li>
						<li><a tabindex="-1" href="#">2nd level dropdown</a></li>
						<li class="dropdown-submenu"><a class="test" href="#">Another
								dropdown <span class="caret"></span>
						</a>
							<ul class="dropdown-menu">
								<li><a href="#">3rd level dropdown</a></li>
								<li><a href="#">3rd level dropdown</a></li>
							</ul></li>
					</ul></li>
			</ul>
		</div>
		<div class="dropdown">
			<button class="btn btn-default dropdown-toggle" type="button"
				data-toggle="dropdown">
				POS-Chiều NHTT(ACQ) <span class="caret"></span>
			</button>
			<ul class="dropdown-menu">
				<li><a tabindex="-1" href="#">HTML</a></li>
				<li><a tabindex="-1" href="#">CSS</a></li>
				<li class="dropdown-submenu"><a class="test" tabindex="-1"
					href="#">New dropdown <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a tabindex="-1" href="#">2nd level dropdown</a></li>
						<li><a tabindex="-1" href="#">2nd level dropdown</a></li>
						<li class="dropdown-submenu"><a class="test" href="#">Another
								dropdown <span class="caret"></span>
						</a>
							<ul class="dropdown-menu">
								<li><a href="#">3rd level dropdown</a></li>
								<li><a href="#">3rd level dropdown</a></li>
							</ul></li>
					</ul></li>
			</ul>
		</div>
		<div class="title-content">Chi tiết case thẻ quốc tế-Chiều
			NHPH(ISS)</div>

	</div>
	<div class="rightContent"
		style="margin-top: 0px; margin-left: 0px; height: 10px; position: fixed;">
		<form
			action="${pageContext.request.contextPath}/update_disputes_iss_card"
			method="post" style="position: fixed; margin-top: 75px;">
			<table class="form-search-iss"
				style="width: 95%; height: 100px; font-size: 10px">
				<c:forEach items="${result}" var="p">
					<tr class="thongtin1">
						<td><span>Họ tên</span> <input style="width: 65%"
							value="${p.crdCustName}" /></td>
						<td><span>Số thẻ</span> <input style="width: 60%"
							value="${fn:substring(p.crdPan, 0, 4)} ${fn:substring(p.crdPan, 4, 8)} ${fn:substring(p.crdPan, 8, 12)} ${fn:substring(p.crdPan, 12, 16)}" /></td>
						<td><span>Cif</span> <input style="width: 45%"
							value="${p.crdCifNo}" /></td>
						<td><span>User nhập</span> <input style="width: 45%"
							value="${p.crdUserCreate}" /></td>
					</tr>
					<tr>
						<td><span>Case ID</span> <input name="caseId"
							style="float: right; width: 45%" value="${p.crdCaseId}" /></td>
						<td><span>Ngày t.nhận</span> <input name="ngayTiepNhan"
							style="float: right; width: 45%"
							value="${fn:substring(p.crdRecDt, 6, 8)}-${fn:substring(p.crdRecDt, 4, 6)}-${fn:substring(p.crdRecDt, 0, 4)}"
							placeholder="dd-mm-yyyy" id="datepicker11" /></td>
						<td><span>T.trạng case</span> <select name="crdCaseStatus"
							id="crdCaseStatus" onchange="onchange_CaseStatus()"
							style="background-color: #F5E278; float: right; width: 45%">
								<c:choose>
									<c:when test="${p.crdCaseStatus == ''}">
										<option value="" selected></option>
									</c:when>
									<c:otherwise>
										<option value=""></option>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${p.crdCaseStatus == 'Pending'}">
										<option value="Pending" selected>Pending</option>
									</c:when>
									<c:otherwise>
										<option value="Pending">Pending</option>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${p.crdCaseStatus == 'Offline'}">
										<option value="Offline" selected>Offline</option>
									</c:when>
									<c:otherwise>
										<option value="Offline">Offline</option>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${p.crdCaseStatus == 'Retrieval Request'}">
										<option value="Retrieval Request" selected>Retrieval
											Request</option>
									</c:when>
									<c:otherwise>
										<option value="Retrieval Request">Retrieval Request</option>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${p.crdCaseStatus == 'Chargeback/Dispute'}">
										<option value="Chargeback/Dispute" selected>Chargeback/Dispute</option>
									</c:when>
									<c:otherwise>
										<option value="Chargeback/Dispute">Chargeback/Dispute</option>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${p.crdCaseStatus == 'Arbitration Chargeback'}">
										<option value="Arbitration Chargeback" selected>Arbitration
											Chargeback</option>
									</c:when>
									<c:otherwise>
										<option value="Arbitration Chargeback">Arbitration
											Chargeback</option>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${p.crdCaseStatus == 'Pre-Arbitration'}">
										<option value="Pre-Arbitration" selected>Pre-Arbitration</option>
									</c:when>
									<c:otherwise>
										<option value="Pre-Arbitration">Pre-Arbitration</option>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${p.crdCaseStatus == 'Pre-Arbitration Response'}">
										<option value="Pre-Arbitration Response" selected>Pre-Arbitration
											Response</option>
									</c:when>
									<c:otherwise>
										<option value="Pre-Arbitration Response">Pre-Arbitration
											Response</option>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${p.crdCaseStatus == 'Arbitration'}">
										<option value="Arbitration" selected>Arbitration</option>
									</c:when>
									<c:otherwise>
										<option value="Arbitration">Arbitration</option>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${p.crdCaseStatus == 'Done'}">
										<option value="Done" selected>Done</option>
									</c:when>
									<c:otherwise>
										<option value="Done">Done</option>
									</c:otherwise>
								</c:choose>
						</select></td>
						<td><c:choose>
								<c:when test="${p.crdCaseStatus != 'Done'}">
									<span style="font-size: 12px">Th.gian x.lý còn lại</span>
									<c:choose>
										<c:when test="${p.crdThoiGianXuLyConLai != -999}">
											<input name="crdThoiGianXuLyConLai"
												value="${p.crdThoiGianXuLyConLai}"
												style="background-color: #F5E278; float: right; width: 45%" readonly" />
										</c:when>
										<c:otherwise>
											<input name="crdThoiGianXuLyConLai" value=""
												style="background-color: #F5E278; float: right; width: 45%"
												readonly="readonly" />
										</c:otherwise>
									</c:choose>
								</c:when>
							</c:choose></td>
					</tr>
					<tr style="background-color: #E8EAED; border: 1px solid black">
						<td style="border-right: 1px solid black">
							<div class="thongtin" style="width: 100%">
								<p style="width: 100%">
									<span>ICA</span><input value="${p.ica}" />
								</p>
								<p>
									<span>ĐVCNT</span> <input style="width: 45%"
										value="${p.crdMercName}" />
								</p>
								<p>
									<span>MID</span><input value="${p.crdMercId}" />
								</p>
								<p>
									<span>TID</span> <input value="${p.crdTid}" />
								</p>
							</div>
						</td>
						<td style="border-right: 1px solid black">
							<div class="thongtin" style="width: 100%">
								<p style="width: 100%">
									<span>Ngày GD</span> <input
										value="${fn:substring(p.crdTxnDt, 6, 8)}-${fn:substring(p.crdTxnDt, 4, 6)}-${fn:substring(p.crdTxnDt, 0, 4)}" />
								</p>
								<p>
									<span>Số tiền GD</span>
									<c:choose>
										<c:when test="${p.crdCurrCde != '704'}">
											<input value="${p.crdTxnAmt}" />
										</c:when>
										<c:otherwise>
											<input
												value="<fmt:formatNumber pattern="#,##0" value="${p.crdTxnAmt}" />" />
										</c:otherwise>
									</c:choose>
								</p>
								<p>
									<span>Loại tiền</span> <input value="${p.crdCurrCde}" />
								</p>
								<p>
									<span>Tiền q.đổi</span> <input
										value="<fmt:formatNumber pattern="#,##0" value="${p.crdVndAmt}" />" />
								</p>
							</div>
						</td>
						<td style="border-right: 1px solid black">
							<div class="thongtin" style="width: 100%">
								<p style="width: 100%">
									<span>Ngày h.toán</span>
									<c:choose>
										<c:when test="${p.crdPstDt !=  0}">
											<input
												value="${fn:substring(p.crdPstDt, 6, 8)}-${fn:substring(p.crdPstDt, 4, 6)}-${fn:substring(p.crdPstDt, 0, 4)}" />
										</c:when>
										<c:otherwise>
											<input value="" />
										</c:otherwise>
									</c:choose>
								</p>
								<p>
									<span>Trace</span> <input value="${p.crdTrace}" />
								</p>
								<p>
									<span>POS mode</span>
									<c:choose>
										<c:when test="${p.crdPosMode != 'null'}">
											<input value="${fn:substring(p.crdPosMode, 0, 2)}" />
										</c:when>
										<c:otherwise>
											<input value="" />
										</c:otherwise>
									</c:choose>
								</p>
								<p>
									<span>3D ind</span> <input value="${p.crd3dIn}" />
								</p>
							</div>
						</td>
						<td style="border-right: 1px solid black">
							<div class="thongtin" style="width: 100%">
								<p>
									<span>Mã cấp phép</span> <input value="${p.crdApvCde}" />
								</p>

								<p>
									<span>Lý do tra soát</span> <select name="crdDisReasonCde"
										id="crdDisReasonCde"
										style="width: 45%; background-color: #F5E278; float: right;">
										<c:choose>
											<c:when test="${p.crdDisReasonCde == ''}">
												<option value="" selected></option>
											</c:when>
											<c:otherwise>
												<option value=""></option>
											</c:otherwise>
										</c:choose>
										<c:choose>
											<c:when test="${p.crdDisReasonCde == '1'}">
												<option value="1" selected>Không thực hiện giao
													dịch</option>
											</c:when>
											<c:otherwise>
												<option value="1">Không thực hiện giao dịch</option>
											</c:otherwise>
										</c:choose>
										<c:choose>
											<c:when test="${p.crdDisReasonCde == '2'}">
												<option value="2" selected>Giao dịch báo nợ
													hai/nhiều lần</option>
											</c:when>
											<c:otherwise>
												<option value="2">Giao dịch báo nợ hai/nhiều lần</option>
											</c:otherwise>
										</c:choose>
										<c:choose>
											<c:when test="${p.crdDisReasonCde == '3'}">
												<option value="3" selected>Đã thanh toán bằng hình
													thức khác</option>
											</c:when>
											<c:otherwise>
												<option value="3">Đã thanh toán bằng hình thức khác</option>
											</c:otherwise>
										</c:choose>
										<c:choose>
											<c:when test="${p.crdDisReasonCde == '4'}">
												<option value="4" selected>Số tiền ghi nợ vào thẻ
													không đúng với hóa đơn</option>
											</c:when>
											<c:otherwise>
												<option value="4">Số tiền ghi nợ vào thẻ không đúng
													với hóa đơn</option>
											</c:otherwise>
										</c:choose>
										<c:choose>
											<c:when test="${p.crdDisReasonCde == '5'}">
												<option value="5" selected>Không nhận được hàng
													hóa/dịch vụ</option>
											</c:when>
											<c:otherwise>
												<option value="5">Không nhận được hàng hóa/dịch vụ</option>
											</c:otherwise>
										</c:choose>
										<c:choose>
											<c:when test="${p.crdDisReasonCde == '6'}">
												<option value="6" selected>Giao dịch đã được thông
													báo hủy/hoàn trả nhưng không nhận được hoàn trả</option>
											</c:when>
											<c:otherwise>
												<option value="6">Giao dịch đã được thông báo
													hủy/hoàn trả nhưng không nhận được hoàn trả</option>
											</c:otherwise>
										</c:choose>
										<c:choose>
											<c:when test="${p.crdDisReasonCde == '7'}">
												<option value="7" selected>Không nhận được tiền
													nhưng tài khoản/thẻ bị trừ tiền</option>
											</c:when>
											<c:otherwise>
												<option value="7">Không nhận được tiền nhưng tài
													khoản/thẻ bị trừ tiền</option>
											</c:otherwise>
										</c:choose>
										<c:choose>
											<c:when test="${p.crdDisReasonCde == '8'}">
												<option value="8" selected>Giao dịch không thành
													công nhưng tài khoản/thẻ bị trừ tiền</option>
											</c:when>
											<c:otherwise>
												<option value="8">Giao dịch không thành công nhưng
													tài khoản/thẻ bị trừ tiền</option>
											</c:otherwise>
										</c:choose>
										<c:choose>
											<c:when test="${p.crdDisReasonCde == '9'}">
												<option value="9" selected>Lý do khác</option>
											</c:when>
											<c:otherwise>
												<option value="9">Lý do khác</option>
											</c:otherwise>
										</c:choose>
									</select>
								</p>
								<p>
									<span>Lý do khác</span>
									<c:choose>
										<c:when test="${p.nguyennhankhac != ''} ">
											<input style="width: 45%" name="lyDoTraSoatKhac"
												value="${p.nguyennhankhac}" />
										</c:when>
										<c:otherwise>
											<input style="width: 45%" name="lyDoTraSoatKhac" value="" />
										</c:otherwise>
									</c:choose>
								</p>
								<p>&nbsp;</p>
							</div>
						</td>
					</tr>
					<tr>
						<td colspan="2"><span>Chi tiết quá trình xử lý</span> <textarea
								name="quaTrinhXuLy" type="text" id="form7" rows="2"
								style="resize: none; background-color: #F5E278; width: 70%; float: right;">${p.crdProcProg}</textarea></td>
						<c:choose>
							<c:when test="${p.crdCaseStatus == 'Retrieval Request'}">
								<td id="RR1" style="background-color: #ADFF52"><span>RR
										code: </br>
								</span> <input name="rrCode" value="${p.rrCode}" /></td>
								<td id="RR2" style="background-color: #ADFF52"><span>Ngày
										RR: </br>
								</span> <input name="rrDate"
									value="${fn:substring(p.rrDate, 6, 8)}-${fn:substring(p.rrDate, 4, 6)}-${fn:substring(p.rrDate, 0, 4)}"
									placeholder="dd-mm-yyyy" id="datepicker1" /></td>
							</c:when>
							<c:otherwise>
								<td id="RR1"><span>RR code: </span> <input
									style="float: right; width: 45%" name="rrCode"
									value="${p.rrCode}" /></td>
								<td id="RR2"><span>Ngày RR: </span> <c:choose>
										<c:when test="${p.rrDate != '0'}">
											<input style="float: right; width: 45%" name="rrDate"
												value="${fn:substring(p.rrDate, 6, 8)}-${fn:substring(p.rrDate, 4, 6)}-${fn:substring(p.rrDate, 0, 4)}"
												placeholder="dd-mm-yyyy" id="datepicker1" />
										</c:when>
										<c:otherwise>
											<input name="rrDate" value="" placeholder="dd-mm-yyyy"
												id="datepicker1" />
										</c:otherwise>
									</c:choose></td>
							</c:otherwise>
						</c:choose>
						<td></td>
					</tr>
					<tr>
						<c:choose>
							<c:when test="${p.crdCaseStatus == 'Chargeback/Dispute'}">
								<td id="CB1" style="background-color: #ADFF52"><span>CB
										code: </span> </br> <input name="cbCode" value="${p.cbCode}" /></td>
								<td id="CB2" style="background-color: #ADFF52"><span>Ngày
										CB: </span> </br> <c:choose>
										<c:when test="${p.cbDate != '0'}">
											<input name="cbDate"
												value="${fn:substring(p.cbDate, 6, 8)}-${fn:substring(p.cbDate, 4, 6)}-${fn:substring(p.cbDate, 0, 4)}"
												placeholder="dd-mm-yyyy" id="datepicker2" />
										</c:when>
										<c:otherwise>
											<input name="cbDate" value="" placeholder="dd-mm-yyyy"
												id="datepicker2" />
										</c:otherwise>
									</c:choose></td>
								<td id="CB3" style="background-color: #ADFF52"><span>Ngày
										TXT: </span></br> <c:choose>
										<c:when test="${p.cbNgayTxt != '0'}">
											<input name="cbNgayTxt"
												value="${fn:substring(p.cbNgayTxt, 6, 8)}-${fn:substring(p.cbNgayTxt, 4, 6)}-${fn:substring(p.cbNgayTxt, 0, 4)}"
												placeholder="dd-mm-yyyy" id="datepicker3" />
										</c:when>
										<c:otherwise>
											<input name="cbNgayTxt" value="" placeholder="dd-mm-yyyy"
												id="datepicker3" />
										</c:otherwise>
									</c:choose></td>
								<td id="CB4" style="background-color: #ADFF52"><span>Thời
										gian xử lý còn lại(TXT): </span></br> <input name="cbThoigianconlaiTxt"
									value="${p.cbThoigianconlaiTxt}" readonly="readonly" /></td>
							</c:when>
							<c:otherwise>
								<td id="CB1"><span>CB code: </span> </br> <input name="cbCode"
									value="${p.cbCode}" /></td>
								<td id="CB2"><span>Ngày CB: </span> </br> <c:choose>
										<c:when test="${p.cbDate != '0'}">
											<input name="cbDate"
												value="${fn:substring(p.cbDate, 6, 8)}-${fn:substring(p.cbDate, 4, 6)}-${fn:substring(p.cbDate, 0, 4)}"
												placeholder="dd-mm-yyyy" id="datepicker2" />
										</c:when>
										<c:otherwise>
											<input name="cbDate" value="" placeholder="dd-mm-yyyy"
												id="datepicker2" />
										</c:otherwise>
									</c:choose></td>
								<td id="CB3"><span>Ngày TXT: </span></br> <c:choose>
										<c:when test="${p.cbNgayTxt != '0'}">
											<input name="cbNgayTxt"
												value="${fn:substring(p.cbNgayTxt, 6, 8)}-${fn:substring(p.cbNgayTxt, 4, 6)}-${fn:substring(p.cbNgayTxt, 0, 4)}"
												placeholder="dd-mm-yyyy" id="datepicker3" />
										</c:when>
										<c:otherwise>
											<input name="cbNgayTxt" value="" placeholder="dd-mm-yyyy"
												id="datepicker3" />
										</c:otherwise>
									</c:choose></td>
								<td id="CB4"><span>T.gian x.lý còn lại(TXT): </span> </br> <input
									style="width: 40%" name="cbThoigianconlaiTxt"
									value="${p.cbThoigianconlaiTxt}" readonly="readonly" /></td>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${p.crdCaseStatus == 'Pre-Arbitration Response'}">
								<td id="PRE_ARB_RESP" style="background-color: #ADFF52"><span>Ngày
										Pre-arb response: </span> </br> <input name="preArRespDate"
									value="${fn:substring(p.preArRespDate, 6, 8)}-${fn:substring(p.preArRespDate, 4, 6)}-${fn:substring(p.preArRespDate, 0, 4)}"
									placeholder="dd-mm-yyyy" id="datepicker4" /></td>
							</c:when>
							<c:otherwise>
								<td id="PRE_ARB_RESP"><span>Ngày Pre-arb response: </span></br>
									<c:choose>
										<c:when test="${p.preArRespDate != '0'}">
											<input name="preArRespDate"
												value="${fn:substring(p.preArRespDate, 6, 8)}-${fn:substring(p.preArRespDate, 4, 6)}-${fn:substring(p.preArRespDate, 0, 4)}"
												placeholder="dd-mm-yyyy" id="datepicker4" />
										</c:when>
										<c:otherwise>
											<input name="preArRespDate" value="" placeholder="dd-mm-yyyy"
												id="datepicker4" />
										</c:otherwise>
									</c:choose></td>
							</c:otherwise>
						</c:choose>

						<td></td>
					</tr>
					<tr>
						<c:choose>
							<c:when test="${p.crdCaseStatus == 'Arbitration Chargeback'}">
								<td id="AR1" style="background-color: #ADFF52"><span>Arb-CB
										code: </br>
								</span> <input name="acCode" value="${p.acCode}" /></td>
								<td id="AR2" style="background-color: #ADFF52"><span>Ngày
										Arb-CB: </br>
								</span> <input name="acDate"
									value="${fn:substring(p.acDate, 6, 8)}-${fn:substring(p.acDate, 4, 6)}-${fn:substring(p.acDate, 0, 4)}"
									placeholder="dd-mm-yyyy" id="datepicker5" /></td>
							</c:when>
							<c:otherwise>
								<td id="AR1"><span>Arb-CB code: </span> </br> <input
									name="acCode" value="${p.acCode}" /></td>
								<td id="AR2"><span>Ngày Arb-CB: </span> </br> <c:choose>
										<c:when test="${p.acDate != '0'}">
											<input name="acDate"
												value="${fn:substring(p.acDate, 6, 8)}-${fn:substring(p.acDate, 4, 6)}-${fn:substring(p.acDate, 0, 4)}"
												placeholder="dd-mm-yyyy" id="datepicker5" />
										</c:when>
										<c:otherwise>
											<input name="acDate" value="" placeholder="dd-mm-yyyy"
												id="datepicker5" />
										</c:otherwise>
									</c:choose></td>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${p.crdCaseStatus == 'Arbitration'}">
								<td id="AC1" style="background-color: #ADFF52"><span>Arbitration
										code: </br>
								</span> <input name="arCode" value="${p.arCode}" /></td>
								<td id="AC2" style="background-color: #ADFF52"><span>Ngày
										Arbitration: </br>
								</span> <input name="arDate"
									value="${fn:substring(p.arDate, 6, 8)}-${fn:substring(p.arDate, 4, 6)}-${fn:substring(p.arDate, 0, 4)}"
									placeholder="dd-mm-yyyy" id="datepicker6" /></td>
							</c:when>
							<c:otherwise>
								<td id="AC1"><span>Arbitration code: </br>
								</span> <input name="arCode" value="${p.arCode}" /></td>
								<td id="AC2"><span>Ngày Arbitration: </span> </br> <c:choose>
										<c:when test="${p.arDate != '0'}">
											<input name="arDate"
												value="${fn:substring(p.arDate, 6, 8)}-${fn:substring(p.arDate, 4, 6)}-${fn:substring(p.arDate, 0, 4)}"
												placeholder="dd-mm-yyyy" id="datepicker6" />
										</c:when>
										<c:otherwise>
											<input name="arDate" value="" placeholder="dd-mm-yyyy"
												id="datepicker6" />
										</c:otherwise>
									</c:choose></td>
							</c:otherwise>
						</c:choose>
						<td><input type="submit" value="LƯU THÔNG TIN"
							class="btn btn-primary btn-sm rounded-0"
							style="padding-bottom: 25px; padding-top: 15px; font-weight: bold;" /></td>
					</tr>
					<c:choose>
						<c:when test="${p.crdCaseStatus == 'Pre-Arbitration'}">
							<tr style="background-color: #ADFF52">
								<td id="PR1"><span>Pre-arb code: </br>
								</span> <input name="preArCode" value="${p.preArCode}" /></td>
								<td id="PR2"><span>Ngày Pre-arb: </span></br> <c:choose>
										<c:when test="${p.preArDate != '0'}">
											<input name="preArDate"
												value="${fn:substring(p.preArDate, 6, 8)}-${fn:substring(p.preArDate, 4, 6)}-${fn:substring(p.preArDate, 0, 4)}"
												placeholder="dd-mm-yyyy" id="datepicker7" />
										</c:when>
										<c:otherwise>
											<input name="preArDate" value="" placeholder="dd-mm-yyyy"
												id="datepicker7" />
										</c:otherwise>
									</c:choose></td>
								<td id="PR3"><span>Ngày phản hồi Pre-abr: </span></br> <c:choose>
										<c:when test="${p.preArNgayphanhoi != '0'}">
											<input name="preArNgayphanhoi"
												value="${fn:substring(p.preArNgayphanhoi, 6, 8)}-${fn:substring(p.preArNgayphanhoi, 4, 6)}-${fn:substring(p.preArNgayphanhoi, 0, 4)}"
												placeholder="dd-mm-yyyy" id="datepicker8" />
										</c:when>
										<c:otherwise>
											<input name="preArNgayphanhoi" value=""
												placeholder="dd-mm-yyyy" id="datepicker8" />
										</c:otherwise>
									</c:choose></td>
								<td id="PR4"><span>Thời gian xử lý còn lại(Pre-abr):
								</span></br> <input value="${p.preArThoigianconlai}" readonly="readonly" /></td>
								<td><a href="undo_iss_international_card.html"
									class="btn btn-success" style="width: 60%">Trở lại</a> <a
									class="delete btn btn-danger"
									data-confirm="Xác nhận xóa case này?"
									href="delete_iss_international_card.html?id=${createTimeSelected}"
									style="width: 60%">Xóa case</a></td>
								<td></td>
							</tr>
						</c:when>
						<c:otherwise>
							<tr>
								<td id="PR1"><span>Pre-arb code: </br>
								</span> <input name="preArCode" value="" /></td>
								<td id="PR2"><span>Ngày Pre-arb: </span></br> <input
									name="preArDate" value="" placeholder="dd-mm-yyyy"
									id="datepicker7" /></td>
								<td id="PR3"><span>Ngày phản hồi Pre-abr: </span></br> <input
									name="preArNgayphanhoi" value="" placeholder="dd-mm-yyyy"
									id="datepicker8" /></td>
								<td id="PR4"><span>Thời gian xử lý còn lại(Pre-abr):
								</span></br> <input name="preArThoigianconlai"
									value="${p.preArThoigianconlai}" readonly="readonly" /></td>
								<td><a href="undo_iss_international_card.html"
									class="btn btn-success" style="width: 60%">Trở lại</a> <a
									class="delete btn btn-danger"
									data-confirm="Xác nhận xóa case này?"
									href="delete_iss_international_card.html?id=${createTimeSelected}"
									style="width: 60%">Xóa case</a></td>
								<td></td>
							</tr>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${p.crdCaseStatus == 'Done'}">
							<tr>
								<td id="Done1" style="background-color: #ADFF52"><span>Ngày
										kết thúc: </br>
								</span> <c:choose>
										<c:when test="${p.doneEndDate != '0'}">
											<input name="doneEndDate"
												value="${fn:substring(p.doneEndDate, 6, 8)}-${fn:substring(p.doneEndDate, 4, 6)}-${fn:substring(p.doneEndDate, 0, 4)}"
												placeholder="dd-mm-yyyy" id="datepicker9" />
										</c:when>
										<c:otherwise>
											<input name="doneEndDate" value="" placeholder="dd-mm-yyyy"
												id="datepicker9" />
										</c:otherwise>
									</c:choose></td>
								<td id="Done2" style="background-color: #ADFF52"><span>Kết
										quả tra soát: </span></br> <select name="doneResult" style="width: 75%">
										<c:choose>
											<c:when test="${p.doneResult == ''}">
												<option value="" selected></option>
											</c:when>
											<c:otherwise>
											</c:otherwise>
										</c:choose>

										<c:choose>
											<c:when test="${p.doneResult == '1'}">
												<option value="1" selected>KH ngưng tra soát</option>
											</c:when>
											<c:otherwise>
												<option value="1">KH ngưng tra soát</option>
											</c:otherwise>
										</c:choose>

										<c:choose>
											<c:when test="${p.doneResult == '2'}">
												<option value="2" selected>KH chấp nhận chứng từ</option>
											</c:when>
											<c:otherwise>
												<option value="2">KH chấp nhận chứng từ</option>
											</c:otherwise>
										</c:choose>

										<c:choose>
											<c:when test="${p.doneResult == '3'}">
												<option value="3" selected>SCB đòi bồi hoàn thành
													công</option>
											</c:when>
											<c:otherwise>
												<option value="3">SCB đòi bồi hoàn thành công</option>
											</c:otherwise>
										</c:choose>
										<c:choose>
											<c:when test="${p.doneResult == '4'}">
												<option value="4" selected>SCB chịu tổn thất</option>
											</c:when>
											<c:otherwise>
												<option value="4">SCB chịu tổn thất</option>
											</c:otherwise>
										</c:choose>

										<c:choose>
											<c:when test="${p.doneResult == '5'}">
												<option value="5" selected>SCB giải treo giao dịch</option>
											</c:when>
											<c:otherwise>
												<option value="5">SCB giải treo giao dịch</option>
											</c:otherwise>
										</c:choose>

										<c:choose>
											<c:when test="${p.doneResult == '6'}">
												<option value="6" selected>SCB hoàn trả theo yêu
													cầu của NHTT/ĐVCNT</option>
											</c:when>
											<c:otherwise>
												<option value="6">SCB hoàn trả theo yêu cầu của
													NHTT/ĐVCNT</option>
											</c:otherwise>
										</c:choose>

										<c:choose>
											<c:when test="${p.doneResult == '7'}">
												<option value="7" selected>NHTT/ĐVCNT hoàn trả giao
													dịch</option>
											</c:when>
											<c:otherwise>
												<option value="7">NHTT/ĐVCNT hoàn trả giao dịch</option>
											</c:otherwise>
										</c:choose>

										<c:choose>
											<c:when test="${p.doneResult == '8'}">
												<option value="8" selected>TQT thực hiện hoàn trả</option>
											</c:when>
											<c:otherwise>
												<option value="8">TQT thực hiện hoàn trả</option>
											</c:otherwise>
										</c:choose>
										<c:choose>
											<c:when test="${p.doneResult == '9'}">
												<option value="9" selected>Khác</option>
											</c:when>
											<c:otherwise>
												<option value="9">Khác</option>
											</c:otherwise>
										</c:choose>
								</select></td>
								<td id="Done3" style="background-color: #ADFF52"><span>Ngày
										hoàn trả: </span></br> <c:choose>
										<c:when test="${p.doneNgayhoantra != 0}">
											<input name="doneNgayhoantra"
												value="${fn:substring(p.doneNgayhoantra, 6, 8)}-${fn:substring(p.doneNgayhoantra, 4, 6)}-${fn:substring(p.doneNgayhoantra, 0, 4)}"
												placeholder="dd-mm-yyyy" id="datepicker10" />
										</c:when>
										<c:otherwise>
											<input name="doneNgayhoantra" value=""
												placeholder="dd-mm-yyyy" id="datepicker10" />
										</c:otherwise>
									</c:choose></td>
								<td id="Done4" style="background-color: #ADFF52"><span>Thu
										phí khiếu nại sai: </span></br> <select name="donePhikhieunaisai">

										<c:choose>
											<c:when test="${p.donePhikhieunaisai == ''}">
												<option value="" selected></option>
											</c:when>
											<c:otherwise>
												<option value=""></option>
											</c:otherwise>
										</c:choose>
										<c:choose>
											<c:when test="${p.donePhikhieunaisai == 'Co'}">
												<option value="Co" selected>Có</option>
											</c:when>
											<c:otherwise>
												<option value="Co">Có</option>
											</c:otherwise>
										</c:choose>
										<c:choose>
											<c:when test="${p.donePhikhieunaisai == 'Khong'}">
												<option value="Khong" selected>Không</option>
											</c:when>
											<c:otherwise>
												<option value="Khong">Không</option>
											</c:otherwise>
										</c:choose>
								</select></td>
								<td id="Done5" style="background-color: #ADFF52"><span>KQ
										tr/soát khác(nếu có): </span></br> <c:choose>
										<c:when test="${p.doneKqKhac != 'null'}">
											<input name="doneKqKhac" value="${p.doneKqKhac}"
												placeholder="KQ tr/soát khác" />
										</c:when>
										<c:otherwise>
											<input name="doneKqKhac" value=""
												placeholder="KQ tr/soát khác" />
										</c:otherwise>
									</c:choose></td>
								<td></td>
							</tr>
						</c:when>
						<c:otherwise>
							<tr>
								<td id="Done1"><span>Ngày kết thúc: </br>
								</span> <c:choose>
										<c:when test="${p.doneEndDate != '0'}">
											<input name="doneEndDate"
												value="${fn:substring(p.doneEndDate, 6, 8)}-${fn:substring(p.doneEndDate, 4, 6)}-${fn:substring(p.doneEndDate, 0, 4)}"
												placeholder="dd-mm-yyyy" id="datepicker9" />
										</c:when>
										<c:otherwise>
											<input name="doneEndDate" value="" placeholder="dd-mm-yyyy"
												id="datepicker9" />
										</c:otherwise>
									</c:choose></td>
								<td id="Done2"><span>Kết quả tra soát: </span></br> <select
									name="doneResult" style="width: 75%">
										<c:choose>
											<c:when test="${p.doneResult == ''}">
												<option value="" selected></option>
											</c:when>
											<c:otherwise>
												<option value="" selected></option>
											</c:otherwise>
										</c:choose>

										<c:choose>
											<c:when test="${p.doneResult == '1'}">
												<option value="1" selected>KH ngưng tra soát</option>
											</c:when>
											<c:otherwise>
												<option value="1">KH ngưng tra soát</option>
											</c:otherwise>
										</c:choose>

										<c:choose>
											<c:when test="${p.doneResult == '2'}">
												<option value="2" selected>KH chấp nhận chứng từ</option>
											</c:when>
											<c:otherwise>
												<option value="2">KH chấp nhận chứng từ</option>
											</c:otherwise>
										</c:choose>

										<c:choose>
											<c:when test="${p.doneResult == '3'}">
												<option value="3" selected>SCB đòi bồi hoàn thành
													công</option>
											</c:when>
											<c:otherwise>
												<option value="3">SCB đòi bồi hoàn thành công</option>
											</c:otherwise>
										</c:choose>
										<c:choose>
											<c:when test="${p.doneResult == '4'}">
												<option value="4" selected>SCB chịu tổn thất</option>
											</c:when>
											<c:otherwise>
												<option value="4">SCB chịu tổn thất</option>
											</c:otherwise>
										</c:choose>

										<c:choose>
											<c:when test="${p.doneResult == '5'}">
												<option value="5" selected>SCB giải treo giao dịch</option>
											</c:when>
											<c:otherwise>
												<option value="5">SCB giải treo giao dịch</option>
											</c:otherwise>
										</c:choose>

										<c:choose>
											<c:when test="${p.doneResult == '6'}">
												<option value="6" selected>SCB hoàn trả theo yêu
													cầu của NHTT/ĐVCNT</option>
											</c:when>
											<c:otherwise>
												<option value="6">SCB hoàn trả theo yêu cầu của
													NHTT/ĐVCNT</option>
											</c:otherwise>
										</c:choose>

										<c:choose>
											<c:when test="${p.doneResult == '7'}">
												<option value="7" selected>NHTT/ĐVCNT hoàn trả giao
													dịch</option>
											</c:when>
											<c:otherwise>
												<option value="7">NHTT/ĐVCNT hoàn trả giao dịch</option>
											</c:otherwise>
										</c:choose>

										<c:choose>
											<c:when test="${p.doneResult == '8'}">
												<option value="8" selected>TQT thực hiện hoàn trả</option>
											</c:when>
											<c:otherwise>
												<option value="8">TQT thực hiện hoàn trả</option>
											</c:otherwise>
										</c:choose>
										<c:choose>
											<c:when test="${p.doneResult == '9'}">
												<option value="9" selected>Khác</option>
											</c:when>
											<c:otherwise>
												<option value="9">Khác</option>
											</c:otherwise>
										</c:choose>
								</select></td>
								<td id="Done3"><span>Ngày hoàn trả: </span></br> <c:choose>
										<c:when test="${p.doneNgayhoantra != 0}">
											<input name="doneNgayhoantra"
												value="${fn:substring(p.doneNgayhoantra, 6, 8)}-${fn:substring(p.doneNgayhoantra, 4, 6)}-${fn:substring(p.doneNgayhoantra, 0, 4)}"
												placeholder="dd-mm-yyyy" id="datepicker10" />
										</c:when>
										<c:otherwise>
											<input name="doneNgayhoantra" value=""
												placeholder="dd-mm-yyyy" id="datepicker10" />
										</c:otherwise>
									</c:choose></td>
								<td id="Done4"><span>Thu phí khiếu nại sai: </span></br> <select
									name="donePhikhieunaisai" style="width: 75%">
										<c:choose>
											<c:when test="${p.donePhikhieunaisai == ''}">
												<option value="" selected></option>
											</c:when>
											<c:otherwise>
												<option value=""></option>
											</c:otherwise>
										</c:choose>
										<c:choose>
											<c:when test="${p.donePhikhieunaisai == 'Co'}">
												<option value="Co" selected>Có</option>
											</c:when>
											<c:otherwise>
												<option value="Co">Có</option>
											</c:otherwise>
										</c:choose>
										<c:choose>
											<c:when test="${p.donePhikhieunaisai == 'Khong'}">
												<option value="Khong" selected>Không</option>
											</c:when>
											<c:otherwise>
												<option value="Khong">Không</option>
											</c:otherwise>
										</c:choose>
								</select></td>
								<td id="Done5"><span>KQ tr/soát khác(nếu có): </span></br> <input
									name="doneKqKhac" value="" placeholder="KQ tr/soát khác" /></td>
								<td></td>
							</tr>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</table>
		</form>
	</div>

	<footer> </footer>
	<script>
		$(document).ready(function() {
			$('.dropdown-submenu a.test').on("click", function(e) {
				$(this).next('ul').toggle();
				e.stopPropagation();
				e.preventDefault();
			});
		});
		$('.delete').on("click", function(e) {
			e.preventDefault();

			var choice = confirm($(this).attr('data-confirm'));

			if (choice) {
				window.location.href = $(this).attr('href');
			}
		});
	</script>
	<script src="<%=request.getContextPath()%>/resources/js/common.js"></script>
	<script>
		document.getElementById('slitCardNo').addEventListener(
				'input',
				function(e) {
					e.target.value = e.target.value.replace(/[^\dA-Z]/g, '')
							.replace(/(.{4})/g, '$1 ').trim();
				});
		function caps(id) {
			document.getElementById(id).value = document.getElementById(id).value
					.toUpperCase();
		}
	</script>

	<script>
		$(document).ready(
				function() {
					$("#testTable").children("tbody").children("tr").children(
							"td").click(function() {
						$(this.parentNode).toggleClass("active");
					});
				});
	</script>
</body>
</html>