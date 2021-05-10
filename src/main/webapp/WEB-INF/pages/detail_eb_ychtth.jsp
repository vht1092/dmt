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
				<li class="dropdown-submenu"><a style="visibility: hidden;"
					hidden class="test" tabindex="-1" href="#">Người dùng<span
						class="caret"></span>
				</a>
					<ul class="dropdown-menu" style="background-color: #F9DF91;">
						<li><center>Người dùng</center></li>
						<li><a style="font-weight: bold;" tabindex="-1"
							href="usermanage.html"><span>DS người dùng</span></a></li>
					</ul></li>
			</ul>
		</div>
		<div class="dropdown">
			<button class="btn btn-default dropdown-toggle" type="button"
				data-toggle="dropdown">
				EB-Chiều NHPH(ISS)<span class="caret"></span>
			</button>
			<ul class="dropdown-menu">
				<li class="dropdown-submenu"><a class="test" tabindex="-1"
					href="#">Chuyển tiền 24/7<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li class="dropdown-submenu"><a class="test" href="#">YCHTTH<span
								class="caret"></span>
						</a>
							<ul class="dropdown-menu">
								<li><a href="eb_create_ychtth.html">Tạo mới</a></li>
								<li><a href="/dmt/dmt1/eb_update_ychtth.html">Truy
										vấn/Cập nhật</a></li>
							</ul></li>
						<li class="dropdown-submenu"><a class="test" href="#">YCTS<span
								class="caret"></span>
						</a>
							<ul class="dropdown-menu">
								<li><a href="eb_create_ycts.html">Tạo mới</a></li>
								<li><a href="eb_update_ycts.html">Truy vấn/Cập nhật</a></li>
							</ul></li>
					</ul></li>
				<li class="dropdown-submenu"><a class="test" tabindex="-1"
					href="#">DV khác</a></li>
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
		<div class="title-content">Chi tiết case thẻ EB-Chiều NHPH(ISS)</div>
	</div>
	<div class="rightContent"
		style="margin-top: 0px; margin-left: 0px; height: 10px; position: fixed;">
		<form
			action="${pageContext.request.contextPath}/update_disputes_eb_ychtth"
			method="post" style="position: fixed; margin-top: 75px;">
			<table class="form-search-iss"
				style="width: 95%; height: 100px; font-size: 10px">
				<c:forEach items="${result}" var="p">
					<tr class="thongtin1">
						<td><span>Họ tên</span> <input style="width: 65%"
							value="${p.ebCustName}" /></td>
						<td><span>Cif</span> <input style="width: 45%"
							value="${p.ebCifNo}" /></td>
						<td><span>TK nguồn</span><input style="width: 65%"
							value="${p.ebCustName}" /></td>
						<td><span>TK đích</span><input style="width: 65%"
							value="${p.ebCustName}" /></td>
					</tr>
					<tr class="thongtin1">
						<td><span>User nhập</span> <input style="width: 65%"
							value="${p.ebUserCreate}" /></td>
						<td><span hidden>ID</span> <input hidden name="ebId"
							style="width: 65%" value="${p.ebId}" /></td>
						<td></td>
						<td></td>
					</tr>
					<tr style="background-color: #E8EAED; border: 1px solid black">
						<td style="border-right: 1px solid black">
							<div class="thongtin" style="width: 100%">
								<p style="width: 100%">
									<span>Kênh GD</span><input value="${p.ebTxnChanel}" />
								</p>
								<p>
									<span>Hình thức</span> <input style="width: 45%"
										value="${p.ebHinhThuc}" />
								</p>
								<p>
									<span>Đối tác</span><input value="${p.ebPartner}" />
								</p>
								<p>
									<span>Dịch vụ</span> <input value="${p.ebServices}" />
								</p>
								<p>
									<span>Nhà cung cấp</span> <input value="${p.ebSupplier}" />
								</p>
								<p>
									<span>Case Id</span> <input name="ebCaseId"
										style="float: right; width: 45%" value="${p.ebCaseId}" />
								</p>
							</div>
						</td>
						<td style="border-right: 1px solid black">
							<div class="thongtin" style="width: 100%">
								<p style="width: 100%">
									<span>Ngày GD</span><input name="ngayTiepNhan"
										style="float: right; width: 45%"
										value="${fn:substring(p.ebTxnDt, 6, 8)}-${fn:substring(p.ebTxnDt, 4, 6)}-${fn:substring(p.ebTxnDt, 0, 4)}" />
								</p>
								<p>
									<span>Số tiền GD</span> <input style="width: 45%"
										value="<fmt:formatNumber pattern="#,##0" value="${p.ebTxnAmt}" />" />
								</p>
								<p>
									<span></span>
								</p>
								<p>
									<span></span>
								</p>
								<p>
									<span></span>
								</p>
								<p>
									<span>Ngày tiếp nhận</span> <input name="ngayTiepNhan"
										style="float: right; width: 45%"
										value="${fn:substring(p.ebRecDt, 6, 8)}-${fn:substring(p.ebRecDt, 4, 6)}-${fn:substring(p.ebRecDt, 0, 4)}"
										placeholder="dd-mm-yyyy" id="datepicker11" />
								</p>
							</div>
						</td>
						<td style="border-right: 1px solid black">
							<div class="thongtin" style="width: 100%">
								<p style="width: 100%">
									<span>Số trace</span><input value="${p.ebTrace}" />
								</p>
								<p>
									<span>Thời gian t.nhận</span> <input name="ebCreateTime"
										style="float: right; width: 45%; background-color: yellow;"
										value="${fn:substring(p.ebCreateTime, 6, 8)}-${fn:substring(p.ebCreateTime, 4, 6)}-${fn:substring(p.ebCreateTime, 0, 4)}"
										placeholder="dd-mm-yyyy" id="datepicker11" />
								</p>
								<p>
									<span></span>
								</p>
								<p>
									<span></span>
								</p>
								<p>
									<span></span>
								</p>
								<p>
									<span>T.trạng case</span> <select id="ebCaseStatus"
										onchange="onchange_CaseStatus_Ebank_ychtth()"
										name="ebCaseStatus"
										style="float: right; width: 45%; background-color: yellow;">
										<c:choose>
											<c:when test="${p.ebCaseStatus == ''}">
												<option value="" selected></option>
											</c:when>
											<c:otherwise>
												<option value=""></option>
											</c:otherwise>
										</c:choose>
										<c:choose>
											<c:when test="${p.ebCaseStatus == 'Pending'}">
												<option value="Pending" selected>Pending</option>
											</c:when>
											<c:otherwise>
												<option value="Pending">Pending</option>
											</c:otherwise>
										</c:choose>
										<c:choose>
											<c:when
												test="${p.ebCaseStatus == 'Chua cap nhat trang thai'}">
												<option value="Chua cap nhat trang thai" selected>Chưa
													cập nhật trạng thái</option>
											</c:when>
											<c:otherwise>
												<option value="Chua cap nhat trang thai">Chưa cập
													nhật trạng thái</option>
											</c:otherwise>
										</c:choose>
										<c:choose>
											<c:when test="${p.ebCaseStatus == 'Gap'}">
												<option value="Gap" selected>Gấp</option>
											</c:when>
											<c:otherwise>
												<option value="Gap">Gấp</option>
											</c:otherwise>
										</c:choose>
										<c:choose>
											<c:when test="${p.ebCaseStatus == 'Done'}">
												<option value="Done" selected>Done</option>
											</c:when>
											<c:otherwise>
												<option value="Done">Done</option>
											</c:otherwise>
										</c:choose>
									</select>
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<td colspan="2"><span>Chi tiết quá trình xử lý</span> <textarea
								name="ebProcProg" type="text" id="form7" rows="2"
								style="resize: none; background-color: #F5E278; width: 70%; float: right;">${p.ebProcProg}</textarea></td>
						<td><span>Lý do tra soát</span> <select
							onchange="nguyennhantrasoat_lydokhac_eb()" id="lyDoTraSoat"
							name="ebDisReasonCde" style="width: 45%">
								<c:choose>
									<c:when test="${p.ebDisReasonCde == ''}">
										<option value="" selected></option>
									</c:when>
									<c:otherwise>
										<option value=""></option>
									</c:otherwise>
								</c:choose>

								<c:choose>
									<c:when test="${p.ebDisReasonCde == '1'}">
										<option value="1" selected>TKTH chưa nhận được tiền</option>
									</c:when>
									<c:otherwise>
										<option value="1">TKTH chưa nhận được tiền</option>
									</c:otherwise>
								</c:choose>

								<c:choose>
									<c:when test="${p.ebDisReasonCde == '2'}">
										<option value="2" selected>KH yêu cầu chặn giao dịch,
											hoàn tiền</option>
									</c:when>
									<c:otherwise>
										<option value="2">KH yêu cầu chặn giao dịch, hoàn
											tiền</option>
									</c:otherwise>
								</c:choose>

								<c:choose>
									<c:when test="${p.ebDisReasonCde == '3'}">
										<option value="3" selected>KH chuyển nhầm TKTH</option>
									</c:when>
									<c:otherwise>
										<option value="3">KH chuyển nhầm TKTH</option>
									</c:otherwise>
								</c:choose>

								<c:choose>
									<c:when test="${p.ebDisReasonCde == '4'}">
										<option value="4" selected>KH yêu cầu thay đổi nội
											dung chuyển tiền</option>
									</c:when>
									<c:otherwise>
										<option value="4">KH yêu cầu thay đổi nội dung chuyển
											tiền</option>
									</c:otherwise>
								</c:choose>

								<c:choose>
									<c:when test="${p.ebDisReasonCde == '5'}">
										<option value="5" selected>CK SCB THÀNH CÔNG - CK SML
											TIMEOUT, 18</option>
									</c:when>
									<c:otherwise>
										<option value="5">CK SCB THÀNH CÔNG - CK SML TIMEOUT,
											18</option>
									</c:otherwise>
								</c:choose>

								<c:choose>
									<c:when test="${p.ebDisReasonCde == '6'}">
										<option value="6" selected>CK SCB THÀNH CÔNG - CK SML
											TIMEOUT TRẢ LỜI 68, 24</option>
									</c:when>
									<c:otherwise>
										<option value="6">CK SCB THÀNH CÔNG - CK SML TIMEOUT
											TRẢ LỜI 68, 24</option>
									</c:otherwise>
								</c:choose>

								<c:choose>
									<c:when test="${p.ebDisReasonCde == '7'}">
										<option value="7" selected>CẮT TIỀN FCC KHÔNG THÀNH
											CÔNG, 16</option>
									</c:when>
									<c:otherwise>
										<option value="7">CẮT TIỀN FCC KHÔNG THÀNH CÔNG, 16</option>
									</c:otherwise>
								</c:choose>

								<c:choose>
									<c:when test="${p.ebDisReasonCde == '8'}">
										<option value="8" selected>GD chờ tra soát/Chờ đối
											soát</option>
									</c:when>
									<c:otherwise>
										<option value="8">GD chờ tra soát/Chờ đối soát</option>
									</c:otherwise>
								</c:choose>

								<c:choose>
									<c:when test="${p.ebDisReasonCde == '9'}">
										<option value="9" selected>KH bị lừa đảo</option>
									</c:when>
									<c:otherwise>
										<option value="9">KH bị lừa đảo</option>
									</c:otherwise>
								</c:choose>

								<c:choose>
									<c:when test="${p.ebDisReasonCde == '10'}">
										<option value="10" selected>Lý do khác(nhập nội dung
											font tiếng việt)</option>
									</c:when>
									<c:otherwise>
										<option value="10">Lý do khác(nhập nội dung font
											tiếng việt)</option>
									</c:otherwise>
								</c:choose>
						</select></td>
					</tr>
					<tr id="eb_yctth1">
						<td><c:choose>
								<c:when test="${p.ebNgayKetThuc != 0}">
									<span>Ngày kết thúc</span>
									<input name="ebNgayKetThuc" style="float: right; width: 45%"
										value="${fn:substring(p.ebNgayKetThuc, 6, 8)}-${fn:substring(p.ebNgayKetThuc, 4, 6)}-${fn:substring(p.ebNgayKetThuc, 0, 4)}"
										placeholder="dd-mm-yyyy" id="datepicker2" />
								</c:when>
								<c:otherwise>
									<span>Ngày kết thúc</span>
									<input name="ebNgayKetThuc" style="float: right; width: 45%"
										value="" placeholder="dd-mm-yyyy" id="datepicker2" />
								</c:otherwise>
							</c:choose></td>
						<td><span>KQ tra soát</span> <select name="ebKqTraSoat"
							style="float: right; width: 45%">
								<c:choose>
									<c:when test="${p.ebKqTraSoat == ''}">
										<option value="" selected>All</option>
									</c:when>
									<c:otherwise>
										<option value="">All</option>
									</c:otherwise>
								</c:choose>

								<c:choose>
									<c:when test="${p.ebKqTraSoat == '1'}">
										<option value="1" selected>All</option>
									</c:when>
									<c:otherwise>
										<option value="1">Hoàn tiền</option>
									</c:otherwise>
								</c:choose>

								<c:choose>
									<c:when test="${p.ebKqTraSoat == '2'}">
										<option value="2" selected>Cung cấp chứng từ báo có</option>
									</c:when>
									<c:otherwise>
										<option value="2">Cung cấp chứng từ báo có</option>
									</c:otherwise>
								</c:choose>

								<c:choose>
									<c:when test="${p.ebKqTraSoat == '3'}">
										<option value="3" selected>Chặn GD, hoàn tiền</option>
									</c:when>
									<c:otherwise>
										<option value="3">Chặn GD, hoàn tiền</option>
									</c:otherwise>
								</c:choose>

								<c:choose>
									<c:when test="${p.ebKqTraSoat == '4'}">
										<option value="4" selected>Điều chỉnh nội dung chuyển
											tiền thành công</option>
									</c:when>
									<c:otherwise>
										<option value="4">Điều chỉnh nội dung chuyển tiền
											thành công</option>
									</c:otherwise>
								</c:choose>

								<c:choose>
									<c:when test="${p.ebKqTraSoat == '5'}">
										<option value="5" selected>Không thu hồi được</option>
									</c:when>
									<c:otherwise>
										<option value="5">Không thu hồi được</option>
									</c:otherwise>
								</c:choose>

								<c:choose>
									<c:when test="${p.ebKqTraSoat == '6'}">
										<option value="6" selected>Gạch nợ bổ sung</option>
									</c:when>
									<c:otherwise>
										<option value="6">Gạch nợ bổ sung</option>
									</c:otherwise>
								</c:choose>

								<c:choose>
									<c:when test="${p.ebKqTraSoat == '7'}">
										<option value="7" selected>Hủy giao dịch/hoàn tiền</option>
									</c:when>
									<c:otherwise>
										<option value="7">Hủy giao dịch/hoàn tiền</option>
									</c:otherwise>
								</c:choose>

								<c:choose>
									<c:when test="${p.ebKqTraSoat == '8'}">
										<option value="8" selected>GD thành công/KH nhận được
											hàng hóa, dịch vụ</option>
									</c:when>
									<c:otherwise>
										<option value="8">GD thành công/KH nhận được hàng
											hóa, dịch vụ</option>
									</c:otherwise>
								</c:choose>

								<c:choose>
									<c:when test="${p.ebKqTraSoat == '9'}">
										<option value="9" selected>Getcard thành công</option>
									</c:when>
									<c:otherwise>
										<option value="9">Getcard thành công</option>
									</c:otherwise>
								</c:choose>

								<c:choose>
									<c:when test="${p.ebKqTraSoat == '10'}">
										<option value="10" selected>Đối tác hoàn tiền về ví
											KH</option>
									</c:when>
									<c:otherwise>
										<option value="10">Đối tác hoàn tiền về ví KH</option>
									</c:otherwise>
								</c:choose>

								<c:choose>
									<c:when test="${p.ebKqTraSoat == '11'}">
										<option value="11" selected>Khác</option>
									</c:when>
									<c:otherwise>
										<option value="11">Khác</option>
									</c:otherwise>
								</c:choose>
						</select></td>
						<td><c:choose>
								<c:when test="${p.ebNgayHoanTra != 0}">
									<span>Ngày hoàn trả</span>
									<input name="ebNgayHoanTra" placeholder="dd-mm-yyyy"
										id="datepicker3" style="float: right; width: 45%"
										value="${fn:substring(p.ebNgayHoanTra, 6, 8)}-${fn:substring(p.ebNgayHoanTra, 4, 6)}-${fn:substring(p.ebNgayHoanTra, 0, 4)}" />
								</c:when>
								<c:otherwise>
									<span>Ngày hoàn trả</span>
									<input name="ebNgayHoanTra" placeholder="dd-mm-yyyy"
										id="datepicker3" value="" style="float: right; width: 45%" />
								</c:otherwise>
							</c:choose></td>
						<td><span>Phí hỗ trợ</span><select id="loaiThe"
							style="float: right; width: 45%" name="ebPhiHoTro">
								<c:choose>
									<c:when test="${p.ebPhiHoTro != ''}">
										<option value="${p.ebPhiHoTro}" selected></option>
									</c:when>
									<c:otherwise>
										<option value=""></option>
									</c:otherwise>
								</c:choose>

								<c:choose>
									<c:when test="${p.ebPhiHoTro != ''}">
										<option value="110000" selected>110.000</option>
									</c:when>
									<c:otherwise>
										<option value="110000">110.000</option>
									</c:otherwise>
								</c:choose>

								<c:choose>
									<c:when test="${p.ebPhiHoTro != ''}">
										<option value="22000" selected>22.000</option>
									</c:when>
									<c:otherwise>
										<option value="22000">22.000</option>
									</c:otherwise>
								</c:choose>
						</select></td>
					</tr>
					<tr id="eb_yctth2">
						<td><span>Số tiền thu hồi</span> <input name="ebSoTienThuHoi"
							style="float: right; width: 45%" value="${p.ebSoTienThuHoi}" /></td>
						<td><input type="submit" value="LƯU THÔNG TIN"
							class="btn btn-primary btn-sm rounded-0"
							style="padding-bottom: 25px; padding-top: 15px; font-weight: bold;" /></td>
						<td><a href="/dmt/dmt1/undo_eb_update_ychtth.html"
							class="btn btn-success" style="width: 45%">Trở lại</a> <a
							class="delete btn btn-danger"
							data-confirm="Xác nhận xóa case này?"
							href="/dmt/dmt1/delete_eb_update_ychtth.html?id=${p.ebId}"
							style="width: 45%">Xóa case</a></td>
						<td></td>
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