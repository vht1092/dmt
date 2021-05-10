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
					href="#" style="background-color: #F9DF91;">Thẻ nội địa<span
						class="caret"></span>
				</a>
					<ul class="dropdown-menu" style="background-color: #F9DF91;">
						<li><center>Thẻ nội địa</center></li>
						<li><a style="font-weight: bold;" tabindex="-1"
							href="new_iss_local_card.html"><span>Thêm case mới</span></a></li>
						<li><a style="font-weight: bold;" tabindex="-1"
							href="search_iss_local_card.html">Truy vấn/Cập nhật</a></li>
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
		<div class="title-content">Chi tiết case thẻ nội địa-Chiều
			NHPH(ISS)</div>

	</div>
	<div class="rightContent"
		style="margin-top: 0px; margin-left: 0px; height: 10px; position: fixed;">
		<form
			action="${pageContext.request.contextPath}/update_disputes_local_card"
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
						<td></td>
					</tr>
					<tr>
						<td><span>Case ID</span> <input name="caseId"
							style="float: right; width: 45%" value="${p.crdCaseId}" /></td>
						<td><span>Ngày t.nhận</span> <input name="ngayTiepNhan"
							style="float: right; width: 45%"
							value="${fn:substring(p.crdRecDt, 6, 8)}-${fn:substring(p.crdRecDt, 4, 6)}-${fn:substring(p.crdRecDt, 0, 4)}"
							placeholder="dd-mm-yyyy" id="datepicker11" /></td>
						<td><span>T.trạng case</span> <select
							style="width: 45%; float: right; background-color: #F5E278;"
							id="tinhTrangCase" name="tinhTrangCase"
							onchange="onchange_CaseStatus_Local()">
								<c:choose>
									<c:when test="${p.crdCaseStatus == '' }">
										<option value="" selected></option>
									</c:when>
									<c:otherwise>
										<option value=""></option>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${p.crdCaseStatus == 'Pending' }">
										<option value="Pending" selected>Pending</option>
									</c:when>
									<c:otherwise>
										<option value="Pending">Pending</option>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${p.crdCaseStatus == 'TS lan 1' }">
										<option value="TS lan 1" selected>TS lần 1</option>
									</c:when>
									<c:otherwise>
										<option value="TS lan 1">TS lần 1</option>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${p.crdCaseStatus == 'TS lan 2' }">
										<option value="TS lan 2" selected>TS lần 2</option>
									</c:when>
									<c:otherwise>
										<option value="TS lan 2">TS lần 2</option>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${p.crdCaseStatus == 'Thuong luong, hoa giai' }">
										<option value="Thuong luong, hoa giai" selected>Thương
											lượng, hòa giải</option>
									</c:when>
									<c:otherwise>
										<option value="Thuong luong, hoa giai">Thương lượng,
											hòa giải</option>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when
										test="${p.crdCaseStatus == 'HD hoa giai Napas/Trong tai/Toa an' }">
										<option value="HD hoa giai Napas/Trong tai/Toa an" selected>HĐ
											hòa giải Napas/Trọng tài/Tòa án</option>
									</c:when>
									<c:otherwise>
										<option value="HD hoa giai Napas/Trong tai/Toa an">HĐ
											hòa giải Napas/Trọng tài/Tòa án</option>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${p.crdCaseStatus == 'Done' }">
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
												style="background-color: #F5E278; float: right; width: 45%"
												readonly />
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
								<p>
									<span>ĐVCNT</span> <input style="width: 45%"
										value="${p.crdMercName}" />
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
									<span>Số tiền GD</span> <input
										value="<fmt:formatNumber pattern="#,##0" value="${p.crdTxnAmt}" />" />
								</p>
							</div>
						</td>
						<td style="border-right: 1px solid black">
							<div class="thongtin" style="width: 100%">
								<p>
									<span>Mã cấp phép</span> <input value="${p.crdApvCde}" />
								</p>
								<p>
									<span>Trace</span> <input value="${p.crdTrace}" />
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<td colspan="2"><span>Ch.tiết q.trình x.lý</span> <textarea
								name="quaTrinhXuLy" type="text" id="form7" rows="2"
								style="resize: none; background-color: #F5E278; width: 70%; float: right;">${p.crdProcProg}</textarea></td>
						<td><span>Lý do tra soát</span> <select
							style="width: 45%; background-color: #F5E278;"
							onchange="nguyennhantrasoat_lydokhac()" id="lyDoTraSoat"
							name="lyDoTraSoat">
								<c:choose>
									<c:when test="${p.crdDisReasonCde == '' }">
										<option value="" selected></option>
									</c:when>
									<c:otherwise>
										<option value=""></option>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${p.crdDisReasonCde == '1' }">
										<option value="1" selected>Không thực hiện giao dịch</option>
									</c:when>
									<c:otherwise>
										<option value="1">Không thực hiện giao dịch</option>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${p.crdDisReasonCde == '2' }">
										<option value="2" selected>Giao dịch báo nợ hai/nhiều
											lần</option>
									</c:when>
									<c:otherwise>
										<option value="2">Giao dịch báo nợ hai/nhiều lần</option>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${p.crdDisReasonCde == '3' }">
										<option value="3" selected>Đã thanh toán bằng hình
											thức khác</option>
									</c:when>
									<c:otherwise>
										<option value="3">Đã thanh toán bằng hình thức khác</option>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${p.crdDisReasonCde == '4' }">
										<option value="4" selected>Số tiền ghi nợ vào thẻ
											không đúng với hóa đơn</option>
									</c:when>
									<c:otherwise>
										<option value="4">Số tiền ghi nợ vào thẻ không đúng
											với hóa đơn</option>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${p.crdDisReasonCde == '5' }">
										<option value="5" selected>Không nhận được hàng
											hóa/dịch vụ</option>
									</c:when>
									<c:otherwise>
										<option value="5">Không nhận được hàng hóa/dịch vụ</option>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${p.crdDisReasonCde == '6' }">
										<option value="6" selected>Giao dịch đã được thông
											báo hủy/hoàn trả nhưng không nhận được hoàn trả</option>
									</c:when>
									<c:otherwise>
										<option value="6">Giao dịch đã được thông báo
											hủy/hoàn trả nhưng không nhận được hoàn trả</option>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${p.crdDisReasonCde == '7' }">
										<option value="7" selected>Không nhận được tiền nhưng
											tài khoản/thẻ bị trừ tiền</option>
									</c:when>
									<c:otherwise>
										<option value="7">Không nhận được tiền nhưng tài
											khoản/thẻ bị trừ tiền</option>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${p.crdDisReasonCde == '8' }">
										<option value="8" selected>Giao dịch không thành công
											nhưng tài khoản/thẻ bị trừ tiền</option>
									</c:when>
									<c:otherwise>
										<option value="8">Giao dịch không thành công nhưng
											tài khoản/thẻ bị trừ tiền</option>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${p.crdDisReasonCde == '9' }">
										<option value="1" selected>ATM chi tiền không đủ</option>
									</c:when>
									<c:otherwise>
										<option value="1">ATM chi tiền không đủ</option>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${p.crdDisReasonCde == '10' }">
										<option value="1" selected>ATM chi tiền khác với số
											tiền ghi nợ</option>
									</c:when>
									<c:otherwise>
										<option value="1">ATM chi tiền khác với số tiền ghi
											nợ</option>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${p.crdDisReasonCde == '11' }">
										<option value="1" selected>ATM nuốt lại tiền</option>
									</c:when>
									<c:otherwise>
										<option value="1">ATM nuốt lại tiền</option>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${p.crdDisReasonCde == '12' }">
										<option value="9" selected>Lý do khác(nhập nội dung
											font tiếng việt)</option>
									</c:when>
									<c:otherwise>
										<option value="9" selected>Lý do khác(nhập nội dung
											font tiếng việt)</option>
									</c:otherwise>
								</c:choose>

						</select></td>
						<td><c:choose>
								<c:when test="${p.nguyennhankhac != 'null'}">
									<input name="nguyennhankhac" value="${p.nguyennhankhac}" />
								</c:when>
								<c:otherwise>
									<input name="nguyennhankhac" value="" />
								</c:otherwise>
							</c:choose></td>
					</tr>
					<tr>
						<c:choose>
							<c:when test="${p.crdCaseStatus == 'TS lan 1' }">
								<td id="crdTsLan1" style="background-color: #ADFF52"><span>Mã
										TS lần 1</span><br /> <c:choose>
										<c:when test="${p.crdTsLan1 != 'null'}">
											<input name="crdTsLan1" value="${p.crdTsLan1}" />
										</c:when>
										<c:otherwise>
											<input name="crdTsLan1" value="" />
										</c:otherwise>
									</c:choose></td>
								<td id="crdNgayTsLan1" style="background-color: #ADFF52"><span>Ngày
										TS lần 1</span> <br /> <c:choose>
										<c:when test="${p.crdNgayTsLan1 != '0'}">
											<input name="crdNgayTsLan1"
												value="${fn:substring(p.crdNgayTsLan1, 6, 8)}-${fn:substring(p.crdNgayTsLan1, 4, 6)}-${fn:substring(p.crdNgayTsLan1, 0, 4)}"
												placeholder="dd-mm-yyyy" id="datepicker2" />
										</c:when>
										<c:otherwise>
											<input name="crdNgayTsLan1" value="" placeholder="dd-mm-yyyy"
												id="datepicker9" />
										</c:otherwise>
									</c:choose></td>
								<td id="crdNgayTsLan1Txt" style="background-color: #ADFF52"><span>Ngày
										TXT</span> <br /> <c:choose>
										<c:when test="${p.crdNgayTsLan1Txt != '0'}">
											<input name="crdNgayTsLan1Txt"
												value="${fn:substring(p.crdNgayTsLan1Txt, 6, 8)}-${fn:substring(p.crdNgayTsLan1Txt, 4, 6)}-${fn:substring(p.crdNgayTsLan1Txt, 0, 4)}"
												placeholder="dd-mm-yyyy" id="datepicker8" />
										</c:when>
										<c:otherwise>
											<input name="crdNgayTsLan1Txt" value=""
												placeholder="dd-mm-yyyy" id="datepicker8" />
										</c:otherwise>
									</c:choose></td>
								<td id="crdNgayTsLan1TxtTime" style="background-color: #ADFF52"><span>Th.gian
										x.lý còn lại TXT</span> <br /> <c:choose>
										<c:when test="${p.crdNgayTsLan1TxtTime != '-999'}">
											<input name="crdNgayTsLan1TxtTime"
												value="${p.crdNgayTsLan1TxtTime}" readonly />
										</c:when>
										<c:otherwise>
											<input name="crdNgayTsLan1TxtTime" value="" readonly />
										</c:otherwise>
									</c:choose></td>
							</c:when>
							<c:otherwise>
								<td id="crdTsLan1"><span>Mã TS lần 1</span><br /> <c:choose>
										<c:when test="${p.crdTsLan1 != 'null'}">
											<input name="crdTsLan1" value="${p.crdTsLan1}" />
										</c:when>
										<c:otherwise>
											<input name="crdTsLan1" value="" />
										</c:otherwise>
									</c:choose></td>
								<td id="crdNgayTsLan1"><span>Ngày TS lần 1</span> <br /> <c:choose>
										<c:when test="${p.crdNgayTsLan1 != null}">
											<input name="crdNgayTsLan1" value="" placeholder="dd-mm-yyyy"
												id="datepicker2" />
										</c:when>
										<c:otherwise>
											<input name="crdNgayTsLan1" value="" placeholder="dd-mm-yyyy"
												id="datepicker9" />
										</c:otherwise>
									</c:choose></td>
								<td id="crdNgayTsLan1Txt"><span>Ngày TXT</span> <br /> <c:choose>
										<c:when test="${p.crdNgayTsLan1Txt != '0'}">
											<input name="crdNgayTsLan1Txt"
												value="${fn:substring(p.crdNgayTsLan1Txt, 6, 8)}-${fn:substring(p.crdNgayTsLan1Txt, 4, 6)}-${fn:substring(p.crdNgayTsLan1Txt, 0, 4)}"
												placeholder="dd-mm-yyyy" id="datepicker8" />
										</c:when>
										<c:otherwise>
											<input name="crdNgayTsLan1Txt" value="" id="datepicker8" />
										</c:otherwise>
									</c:choose></td>
								<td id="crdNgayTsLan1TxtTime"><span>Th.gian x.lý còn
										lại TXT</span> <br /> <c:choose>
										<c:when test="${p.crdNgayTsLan1TxtTime != '-999'}">
											<input name="crdNgayTsLan1TxtTime"
												value="${p.crdNgayTsLan1TxtTime}" readonly />
										</c:when>
										<c:otherwise>
											<input name="crdNgayTsLan1TxtTime" value="" readonly />
										</c:otherwise>
									</c:choose></td>
							</c:otherwise>
						</c:choose>
					</tr>
					<tr>
						<c:choose>
							<c:when test="${p.crdCaseStatus == 'TS lan 2' }">
								<td id="crdTsLan2" style="background-color: #ADFF52"><span>Mã
										TS lần 2</span> <br /> <c:choose>
										<c:when test="${p.crdTsLan2 != 'null'}">
											<input name="crdTsLan2" value="${p.crdTsLan2}" />
										</c:when>
										<c:otherwise>
											<input name="crdTsLan2" value="" />
										</c:otherwise>
									</c:choose></td>
								<td id="crdNgayTsLan2" style="background-color: #ADFF52"><span>Ngày
										TS lần 2</span><br /> <c:choose>
										<c:when test="${p.crdNgayTsLan2 != '0'}">
											<input name="crdNgayTsLan2"
												value="${fn:substring(p.crdNgayTsLan2, 6, 8)}-${fn:substring(p.crdNgayTsLan2, 4, 6)}-${fn:substring(p.crdNgayTsLan2, 0, 4)}"
												placeholder="dd-mm-yyyy" id="datepicker3" />
										</c:when>
										<c:otherwise>
											<input name="crdNgayTsLan2" value="" placeholder="dd-mm-yyyy"
												id="datepicker3" />
										</c:otherwise>
									</c:choose></td>
							</c:when>
							<c:otherwise>
								<td id="crdTsLan2"><span>Mã TS lần 2</span> <br /> <c:choose>
										<c:when test="${p.crdTsLan2 != 'null'}">
											<input name="crdTsLan2" value="" />
										</c:when>
										<c:otherwise>
											<input name="crdTsLan2" value="" />
										</c:otherwise>
									</c:choose></td>
								<td id="crdNgayTsLan2"><span>Ngày TS lần 2</span><br /> <c:choose>
										<c:when test="${p.crdNgayTsLan2 != '0'}">
											<input name="crdNgayTsLan2"
												value="${fn:substring(p.crdNgayTsLan2, 6, 8)}-${fn:substring(p.crdNgayTsLan2, 4, 6)}-${fn:substring(p.crdNgayTsLan2, 0, 4)}"
												placeholder="dd-mm-yyyy" id="datepicker3" />
										</c:when>
										<c:otherwise>
											<input name="crdNgayTsLan2" value="" placeholder="dd-mm-yyyy"
												id="datepicker3" />
										</c:otherwise>
									</c:choose></td>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${p.crdCaseStatus == 'Thuong luong, hoa giai' }">
								<td id="crdNgayThuongLuong" style="background-color: #ADFF52"><span>Ngày
										thương lượng, hòa giải</span><br /> <c:choose>
										<c:when test="${p.crdNgayThuongLuong != '0'}">
											<input name="crdNgayThuongLuong"
												value="${fn:substring(p.crdNgayThuongLuong, 6, 8)}-${fn:substring(p.crdNgayThuongLuong, 4, 6)}-${fn:substring(p.crdNgayThuongLuong, 0, 4)}"
												placeholder="dd-mm-yyyy" id="datepicker4" />
										</c:when>
										<c:otherwise>
											<input name="crdNgayThuongLuong" value=""
												placeholder="dd-mm-yyyy" id="datepicker4" />
										</c:otherwise>
									</c:choose></td>
							</c:when>
							<c:otherwise>
								<td id="crdNgayThuongLuong"><span>Ngày thương lượng,
										hòa giải</span><br /> <c:choose>
										<c:when test="${p.crdNgayThuongLuong != '0'}">
											<input name="crdNgayThuongLuong"
												value="${fn:substring(p.crdNgayThuongLuong, 6, 8)}-${fn:substring(p.crdNgayThuongLuong, 4, 6)}-${fn:substring(p.crdNgayThuongLuong, 0, 4)}"
												placeholder="dd-mm-yyyy" id="datepicker4" />
										</c:when>
										<c:otherwise>
											<input name="crdNgayThuongLuong" value=""
												placeholder="dd-mm-yyyy" id="datepicker4" />
										</c:otherwise>
									</c:choose></td>
							</c:otherwise>
						</c:choose>

						<c:choose>
							<c:when
								test="${p.crdCaseStatus == 'HD hoa giai Napas/Trong tai/Toa an' }">
								<td id="crdNgayHoaGiaiNapas" style="background-color: #ADFF52"><span>Ngày
										hội đồng hòa giải Napas/Trọng tài/Tòa án</span><br /> <c:choose>
										<c:when test="${p.crdNgayHoaGiaiNapas != '0'}">
											<input name="crdNgayHoaGiaiNapas"
												value="${fn:substring(p.crdNgayHoaGiaiNapas, 6, 8)}-${fn:substring(p.crdNgayHoaGiaiNapas, 4, 6)}-${fn:substring(p.crdNgayHoaGiaiNapas, 0, 4)}"
												placeholder="dd-mm-yyyy" id="datepicker5" />
										</c:when>
										<c:otherwise>
											<input name="crdNgayHoaGiaiNapas" value=""
												placeholder="dd-mm-yyyy" id="datepicker5" />
										</c:otherwise>
									</c:choose></td>
							</c:when>
							<c:otherwise>
								<td id="crdNgayHoaGiaiNapas"><span>Ngày hội đồng hòa
										giải Napas/Trọng tài/Tòa án</span><br /> <c:choose>
										<c:when test="${p.crdNgayHoaGiaiNapas != '0'}">
											<input name="crdNgayHoaGiaiNapas"
												value="${fn:substring(p.crdNgayHoaGiaiNapas, 6, 8)}-${fn:substring(p.crdNgayHoaGiaiNapas, 4, 6)}-${fn:substring(p.crdNgayHoaGiaiNapas, 0, 4)}"
												placeholder="dd-mm-yyyy" id="datepicker5" />
										</c:when>
										<c:otherwise>
											<input name="crdNgayHoaGiaiNapas" value=""
												placeholder="dd-mm-yyyy" id="datepicker5" />
										</c:otherwise>
									</c:choose></td>
							</c:otherwise>
						</c:choose>
					</tr>
					<c:choose>
						<c:when test="${p.crdCaseStatus == 'Done' }">
							<tr id="donex" style="background-color: #ADFF52">
								<td id="doneEndDate"><span>Ngày kết thúc</span> <br /> <c:choose>
										<c:when test="${p.doneEndDate != '0'}">
											<input name="doneEndDate"
												value="${fn:substring(p.doneEndDate, 6, 8)}-${fn:substring(p.doneEndDate, 4, 6)}-${fn:substring(p.doneEndDate, 0, 4)}"
												placeholder="dd-mm-yyyy" id="datepicker6" />
										</c:when>
										<c:otherwise>
											<input name="doneEndDate" value="" placeholder="dd-mm-yyyy"
												id="datepicker6" />
										</c:otherwise>
									</c:choose></td>
								<td id="doneResult"><span>Kết quả tra soát</span> <br /> <select
									name="doneResult" style="width: 70%">
										<c:choose>
											<c:when test="${p.doneResult == '1'}">
												<option value="1" selected></option>
											</c:when>
											<c:otherwise>
												<option value="1"></option>
											</c:otherwise>
										</c:choose>
										<c:choose>
											<c:when test="${p.doneResult == '2'}">
												<option value="2" selected>KH ngừng tra soát</option>
											</c:when>
											<c:otherwise>
												<option value="2">KH ngừng tra soát</option>
											</c:otherwise>
										</c:choose>
										<c:choose>
											<c:when test="${p.doneResult == '3'}">
												<option value="3" selected>KH chấp nhận chứng từ</option>
											</c:when>
											<c:otherwise>
												<option value="3">KH chấp nhận chứng từ</option>
											</c:otherwise>
										</c:choose>
										<c:choose>
											<c:when test="${p.doneResult == '4'}">
												<option value="4" selected>NHTT hoàn trả giao dịch</option>
											</c:when>
											<c:otherwise>
												<option value="4">NHTT hoàn trả giao dịch</option>
											</c:otherwise>
										</c:choose>
										<c:choose>
											<c:when test="${p.doneResult == '5'}">
												<option value="5" selected>TQT thực hiện hoàn trả</option>>
											</c:when>
											<c:otherwise>
												<option value="5">TQT thực hiện hoàn trả</option>
											</c:otherwise>
										</c:choose>
										<c:choose>
											<c:when test="${p.doneResult == '5'}">
												<option value="6" selected>Khác: _____(font tiếng
													việt)</option>
											</c:when>
											<c:otherwise>
												<option value="6">Khác: _____(font tiếng việt)</option>
											</c:otherwise>
										</c:choose>
								</select> </select></td>
								<td id="doneNgayhoantra"><span>Ngày hoàn trả</span><br />
									<c:choose>
										<c:when test="${p.doneNgayhoantra != 0}">
											<input name="doneNgayhoantra"
												value="${fn:substring(p.doneNgayhoantra, 6, 8)}-${fn:substring(p.doneNgayhoantra, 4, 6)}-${fn:substring(p.doneNgayhoantra, 0, 4)}"
												placeholder="dd-mm-yyyy" id="datepicker7" />
										</c:when>
										<c:otherwise>
											<input name="doneNgayhoantra" value=""
												placeholder="dd-mm-yyyy" id="datepicker7" />
										</c:otherwise>
									</c:choose></td>
								<td id="donePhikhieunaisai"><span>Thu phí khiếu nại
										sai</span><br /> <select name="donePhikhieunaisai"
									style="width: 75%">
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
							</tr>
						</c:when>
						<c:otherwise>
							<tr id="donex">
								<td id="doneEndDate"><span>Ngày kết thúc</span> <br /> <c:choose>
										<c:when test="${p.doneEndDate != '0'}">
											<input name="doneEndDate"
												value="${fn:substring(p.doneEndDate, 6, 8)}-${fn:substring(p.doneEndDate, 4, 6)}-${fn:substring(p.doneEndDate, 0, 4)}"
												placeholder="dd-mm-yyyy" id="datepicker6" />
										</c:when>
										<c:otherwise>
											<input name="doneEndDate" value="" placeholder="dd-mm-yyyy"
												id="datepicker6" />
										</c:otherwise>
									</c:choose></td>
								<td id="doneResult"><span>Kết quả tra soát</span> <br /> <select
									name="doneResult" style="width: 70%">
										<c:choose>
											<c:when test="${p.doneResult == '1'}">
												<option value="1" selected></option>
											</c:when>
											<c:otherwise>
												<option value="1"></option>
											</c:otherwise>
										</c:choose>
										<c:choose>
											<c:when test="${p.doneResult == '2'}">
												<option value="2" selected>KH ngừng tra soát</option>
											</c:when>
											<c:otherwise>
												<option value="2">KH ngừng tra soát</option>
											</c:otherwise>
										</c:choose>
										<c:choose>
											<c:when test="${p.doneResult == '3'}">
												<option value="3" selected>KH chấp nhận chứng từ</option>
											</c:when>
											<c:otherwise>
												<option value="3">KH chấp nhận chứng từ</option>
											</c:otherwise>
										</c:choose>
										<c:choose>
											<c:when test="${p.doneResult == '4'}">
												<option value="4" selected>NHTT hoàn trả giao dịch</option>
											</c:when>
											<c:otherwise>
												<option value="4">NHTT hoàn trả giao dịch</option>
											</c:otherwise>
										</c:choose>
										<c:choose>
											<c:when test="${p.doneResult == '5'}">
												<option value="5" selected>TQT thực hiện hoàn trả</option>>
											</c:when>
											<c:otherwise>
												<option value="5">TQT thực hiện hoàn trả</option>
											</c:otherwise>
										</c:choose>
										<c:choose>
											<c:when test="${p.doneResult == '5'}">
												<option value="6">Khác: _____(font tiếng việt)</option>
											</c:when>
											<c:otherwise>
												<option value="6">Khác: _____(font tiếng việt)</option>
											</c:otherwise>
										</c:choose>
								</select></td>
								<td id="doneNgayhoantra"><span>Ngày hoàn trả</span><br />
									<c:choose>
										<c:when test="${p.doneNgayhoantra != 0}">
											<input name="doneNgayhoantra"
												value="${fn:substring(p.doneNgayhoantra, 6, 8)}-${fn:substring(p.doneNgayhoantra, 4, 6)}-${fn:substring(p.doneNgayhoantra, 0, 4)}"
												placeholder="dd-mm-yyyy" id="datepicker7" />
										</c:when>
										<c:otherwise>
											<input name="doneNgayhoantra" value=""
												placeholder="dd-mm-yyyy" id="datepicker7" />
										</c:otherwise>
									</c:choose></td>
								<td id="donePhikhieunaisai"><span>Thu phí khiếu nại
										sai</span><br /> <select name="donePhikhieunaisai"
									style="width: 75%">
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
							</tr>
						</c:otherwise>
					</c:choose>

					<tr>
						<td><input type="submit" value="LƯU THÔNG TIN"
							class="btn btn-primary btn-sm rounded-0"
							style="padding-bottom: 25px; padding-top: 15px; font-weight: bold;" /></td>
						<td><a href="undo_iss_local_card.html"
							class="btn btn-success" style="width: 50%">TRỞ LẠI</a></td>
						<td><a href="undo_iss_international_card.html"
							class="btn btn-danger" style="width: 50%">XÓA CASE</a></td>
					</tr>
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