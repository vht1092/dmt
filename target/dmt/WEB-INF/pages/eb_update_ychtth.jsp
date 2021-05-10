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
<title>TRUY VẤN CASE: EB-CHIỀU NHPH(ISS)</title>
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

table.scroll thead {
	width: 100%;
	background: #29827B;
}

table.scroll thead tr:after {
	content: '';
	overflow-y: scroll;
	visibility: hidden;
}

table.scroll thead th {
	flex: 1 auto;
	display: block;
	color: #fff;
}

table.scroll tbody {
	display: block;
	width: 100%;
	overflow-y: auto;
	height: 300px;
	max-height: 600px;
}

table.scroll thead tr, table.scroll tbody tr {
	display: flex;
	text-align: center;
	vertical-align: middle;
}

table.scroll tbody tr td {
	flex: 1 auto;
	word-wrap: break;
	text-align: center;
	vertical-align: middle;
}

table.scroll thead tr th, table.scroll tbody tr td {
	width: 25%;
	padding: 3px;
	text-align: center;
	text-align: center;
	vertical-align: middle;
}

.form-search-iss td {
	width: 20%;
}

.form-search-iss .form-control {
	height: 30px;
}

.header-table th {
	width: 10%
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
		<div class="title-content">Truy vấn/Cập nhật EB-Chiều NHPH(ISS)</div>
		<form
			action="${pageContext.request.contextPath}/dmt1/search_update_Eb_ychtth"
			method="post" style="position: fixed; margin-top: 75px;">
			<table class="form-search-iss" style="width: 100%; margin-left: -5%;">
				<tr>
					<td><span>Theo</span> <select name="loaiNgaySearch"
						class="form-control" style="width: 85%">
							<c:choose>
								<c:when test="${txt_loaiNgaySearch == 'ngayGD'}">
									<option value="ngayGD" selected="selected">Ngày giao
										dịch</option>
									<option value="ngayTiepNhan">Ngày tiếp nhận</option>
								</c:when>
								<c:otherwise>
									<option value="ngayGD">Ngày giao dịch</option>
									<option value="ngayTiepNhan" selected="selected">Ngày
										tiếp nhận</option>
								</c:otherwise>
							</c:choose>
					</select></td>
					<td><span>Từ ngày</span> <c:choose>
							<c:when test="${txt_fromDate != ''}">
								<input autocomplete="off" name="txt_fromDate"
									class="form-control" type="text" value="${txt_fromDate}"
									placeholder="Từ ngày: dd-mm-yyyy" id="datepicker1" required />
							</c:when>
							<c:otherwise>
								<input autocomplete="off" name="txt_fromDate"
									class="form-control" type="text"
									placeholder="Từ ngày: dd-mm-yyyy" id="datepicker1" required />
							</c:otherwise>
						</c:choose></td>
					<td><span>Đến ngày</span> <c:choose>
							<c:when test="${txt_toDate != ''}">
								<input autocomplete="off" name="txt_toDate" class="form-control"
									type="text" value="${txt_toDate}"
									placeholder="Đến ngày: dd-mm-yyyy" id="datepicker2" required />
							</c:when>
							<c:otherwise>
								<input autocomplete="off" name="txt_toDate" class="form-control"
									type="text" placeholder="Đến ngày: dd-mm-yyyy" id="datepicker2"
									required />
							</c:otherwise>
						</c:choose></td>
					<td><span>Case ID</span> <c:choose>
							<c:when test="${txt_caseId != '' && txt_caseId != 'null'}">
								<input name="txt_caseId" class="form-control"
									value="${txt_caseId}" />
							</c:when>
							<c:otherwise>
								<input name="txt_caseId" class="form-control" />
							</c:otherwise>
						</c:choose></td>
					<td><span>CIF</span> <c:choose>
							<c:when test="${txt_Cif != '' && txt_Cif != null}">
								<input name="txt_Cif" class="form-control" value="${txt_Cif}" />
							</c:when>
							<c:otherwise>
								<input name="txt_Cif" class="form-control" value="" />
							</c:otherwise>
						</c:choose></td>
				</tr>
				<tr>
					<td><span>Kênh GD</span> <select name="txt_Channel"
						class="form-control" style="width: 85%">
							<c:choose>
								<c:when test="${txt_Channel == '' }">
									<option value="" selected="selected">All</option>
								</c:when>
								<c:otherwise>
									<option value="">All</option>
								</c:otherwise>
							</c:choose>

							<c:choose>
								<c:when test="${txt_Channel == 'EB' }">
									<option value="ATM" selected="selected">ATM</option>
								</c:when>
								<c:otherwise>
									<option value="ATM">ATM</option>
								</c:otherwise>
							</c:choose>

							<c:choose>
								<c:when test="${txt_Channel == 'AUTO' }">
									<option value="AUTO" selected="selected">AUTO</option>
								</c:when>
								<c:otherwise>
									<option value="AUTO">AUTO</option>
								</c:otherwise>
							</c:choose>

							<c:choose>
								<c:when test="${txt_Channel == 'MB' }">
									<option value="MB" selected="selected">MB</option>
								</c:when>
								<c:otherwise>
									<option value="MB">MB</option>
								</c:otherwise>
							</c:choose>

							<c:choose>
								<c:when test="${txt_Channel == 'TQ' }">
									<option value="TQ" selected="selected">TQ</option>
								</c:when>
								<c:otherwise>
									<option value="TQ">TQ</option>
								</c:otherwise>
							</c:choose>
					</select></td>
					<td><span>Lý do tra soát</span> <select name="txt_lyDoTraSoat"
						class="form-control" style="width: 85%">
							<c:choose>
								<c:when test="${ebDisReasonCde == '' }">
									<option value="" selected></option>
								</c:when>
								<c:otherwise>
									<option value=""></option>
								</c:otherwise>
							</c:choose>

							<c:choose>
								<c:when test="${ebDisReasonCde == '1' }">
									<option value="1" selected>TKTH chưa nhận được tiền</option>
								</c:when>
								<c:otherwise>
									<option value="1">TKTH chưa nhận được tiền</option>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${ebDisReasonCde == '2' }">
									<option value="2" selected>KH yêu cầu chặn giao dịch,
										hoàn tiền</option>
								</c:when>
								<c:otherwise>
									<option value="2">KH yêu cầu chặn giao dịch, hoàn tiền</option>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${ebDisReasonCde == '3' }">
									<option value="3" selected>KH chuyển nhầm TKTH</option>
								</c:when>
								<c:otherwise>
									<option value="3">KH chuyển nhầm TKTH</option>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${ebDisReasonCde == '4' }">
									<option value="4" selected>KH yêu cầu thay đổi nội
										dung chuyển tiền</option>
								</c:when>
								<c:otherwise>
									<option value="4">KH yêu cầu thay đổi nội dung chuyển
										tiền</option>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${ebDisReasonCde == '5' }">
									<option value="5" selected>CK SCB THÀNH CÔNG - CK SML
										TIMEOUT, 18</option>
								</c:when>
								<c:otherwise>
									<option value="5">CK SCB THÀNH CÔNG - CK SML TIMEOUT,
										18</option>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${ebDisReasonCde == '6' }">
									<option value="6" selected>CK SCB THÀNH CÔNG - CK SML
										TIMEOUT TRẢ LỜI 68, 24</option>
								</c:when>
								<c:otherwise>
									<option value="6">CK SCB THÀNH CÔNG - CK SML TIMEOUT
										TRẢ LỜI 68, 24</option>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${ebDisReasonCde == '7' }">
									<option value="7" selected>CẮT TIỀN FCC KHÔNG THÀNH
										CÔNG, 16</option>
								</c:when>
								<c:otherwise>
									<option value="7">CẮT TIỀN FCC KHÔNG THÀNH CÔNG, 16</option>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${ebDisReasonCde == '8' }">
									<option value="8" selected>GD chờ tra soát/Chờ đối
										soát</option>
								</c:when>
								<c:otherwise>
									<option value="8">GD chờ tra soát/Chờ đối soát</option>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${ebDisReasonCde == '9' }">
									<option value="9" selected>KH bị lừa đảo</option>
								</c:when>
								<c:otherwise>
									<option value="9">KH bị lừa đảo</option>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${ebDisReasonCde == '10' }">
									<option value="10" selected>Lý do khác</option>
								</c:when>
								<c:otherwise>
									<option value="10">Lý do khác</option>
								</c:otherwise>
							</c:choose>
					</select></td>
					<td><span>Tình trạng case</span> <select style="width: 85%"
						class="form-control" id="tinhTrangCase" name="txt_tinhTrangCase">
							<c:choose>
								<c:when test="${txt_tinhTrangCase == '' }">
									<option value="" selected></option>
								</c:when>
								<c:otherwise>
									<option value=""></option>
								</c:otherwise>
							</c:choose>

							<c:choose>
								<c:when test="${txt_tinhTrangCase == 'Pending' }">
									<option value="Pending" selected>Pending</option>
								</c:when>
								<c:otherwise>
									<option value="Pending">Pending</option>
								</c:otherwise>
							</c:choose>

							<c:choose>
								<c:when
									test="${txt_tinhTrangCase == 'Chua cap nhat trang thai' }">
									<option value="Chua cap nhat trang thai" selected>Chưa
										cập nhật trạng thái</option>
								</c:when>
								<c:otherwise>
									<option value="Chua cap nhat trang thai">Chưa cập nhật
										trạng thái</option>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${txt_tinhTrangCase == 'Gap' }">
									<option value="Gap" selected>Gấp</option>
								</c:when>
								<c:otherwise>
									<option value="Gap">Gấp</option>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${txt_tinhTrangCase == 'Done' }">
									<option value="Done" selected>Done</option>
								</c:when>
								<c:otherwise>
									<option value="Done">Done</option>
								</c:otherwise>
							</c:choose>
					</select></td>
					<td><span>KQ tra soát</span> <select name="txt_ketQuaTraSoat"
						style="width: 85%" class="form-control">

							<c:choose>
								<c:when test="${txt_ketQuaTraSoat == '' }">
									<option value="" selected>All</option>
								</c:when>
								<c:otherwise>
									<option value="">All</option>
								</c:otherwise>
							</c:choose>

							<c:choose>
								<c:when test="${txt_ketQuaTraSoat == '1' }">
									<option value="1" selected>Hoàn tiền</option>
								</c:when>
								<c:otherwise>
									<option value="1">Hoàn tiền</option>
								</c:otherwise>
							</c:choose>

							<c:choose>
								<c:when test="${txt_ketQuaTraSoat == '2' }">
									<option value="2" selected>Cung cấp chứng từ báo có</option>
								</c:when>
								<c:otherwise>
									<option value="2">Cung cấp chứng từ báo có</option>
								</c:otherwise>
							</c:choose>

							<c:choose>
								<c:when test="${txt_ketQuaTraSoat == '3' }">
									<option value="3" selected>Chặn GD, hoàn tiền</option>
								</c:when>
								<c:otherwise>
									<option value="3">Chặn GD, hoàn tiền</option>
								</c:otherwise>
							</c:choose>

							<c:choose>
								<c:when test="${txt_ketQuaTraSoat == '4' }">
									<option value="4" selected>Điều chỉnh nội dung chuyển
										tiền thành công</option>
								</c:when>
								<c:otherwise>
									<option value="4">Điều chỉnh nội dung chuyển tiền
										thành công</option>
								</c:otherwise>
							</c:choose>

							<c:choose>
								<c:when test="${txt_ketQuaTraSoat == '5' }">
									<option value="5" selected>Không thu hồi được</option>
								</c:when>
								<c:otherwise>
									<option value="5">Không thu hồi được</option>
								</c:otherwise>
							</c:choose>

							<c:choose>
								<c:when test="${txt_ketQuaTraSoat == '5' }">
									<option value="6" selected>Gạch nợ bổ sung</option>
								</c:when>
								<c:otherwise>
									<option value="6">Gạch nợ bổ sung</option>
								</c:otherwise>
							</c:choose>

							<c:choose>
								<c:when test="${txt_ketQuaTraSoat == '7' }">
									<option value="7" selected>Hủy giao dịch/hoàn tiền</option>
								</c:when>
								<c:otherwise>
									<option value="7">Hủy giao dịch/hoàn tiền</option>
								</c:otherwise>
							</c:choose>


							<c:choose>
								<c:when test="${txt_ketQuaTraSoat == '8' }">
									<option value="8" selected>GD thành công/KH nhận được
										hàng hóa, dịch vụ</option>
								</c:when>
								<c:otherwise>
									<option value="8">GD thành công/KH nhận được hàng hóa,
										dịch vụ</option>
								</c:otherwise>
							</c:choose>

							<c:choose>
								<c:when test="${txt_ketQuaTraSoat == '8' }">
									<option value="9" selected>Getcard thành công</option>
								</c:when>
								<c:otherwise>
									<option value="9">Getcard thành công</option>
								</c:otherwise>
							</c:choose>

							<c:choose>
								<c:when test="${txt_ketQuaTraSoat == '8' }">
									<option value="10" selected>Đối tác hoàn tiền về ví KH</option>
								</c:when>
								<c:otherwise>
									<option value="10">Đối tác hoàn tiền về ví KH</option>
								</c:otherwise>
							</c:choose>

							<c:choose>
								<c:when test="${txt_ketQuaTraSoat == '8' }">
									<option value="11" selected>Khác</option>
								</c:when>
								<c:otherwise>
									<option value="11">Khác</option>
								</c:otherwise>
							</c:choose>
					</select></td>
				</tr>
				<tr>
					<td><select name="txt_Partner"
						style="width: 85%; float: left; margin-right: 5px; line-height: 125px"
						class="form-control">
							<option value="">Đối tác</option>
							<c:forEach items="${listPartner}" var="ebPartner">
								<option value="${ebPartner.hoTen}">${ebPartner.hoTen}</option>
							</c:forEach>
					</select></td>
					<td><select name="txt_Services"
						style="width: 85%; float: left; margin-right: 5px; line-height: 125px"
						class="form-control">
							<option value="" selected>Dịch vụ</option>
							<c:forEach items="${listServices}" var="ebServices">
								<option value="${ebServices.hoTen}">${ebServices.hoTen}</option>
							</c:forEach>
					</select></td>
					<td><select name="txt_userCreate"
						style="width: 85%; float: left; margin-right: 5px; line-height: 125px"
						class="form-control">
							<option value="">User</option>
							<c:forEach items="${listUserCreate}" var="userCreate">
								<option value="${userCreate.hoTen}">${userCreate.hoTen}</option>
							</c:forEach>
					</select></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td><input type="submit" value="SEARCH"
						style="float: left; width: 80%"
						class="form-control btn btn-success" /></td>
					<td><a href="/dmt/dmt1/case_can_xu_ly_eb_ychtth.html"
						class="btn btn-info" style="width: 80%">Case cần xử lý</a></td>
					<td><a href="/dmt/dmt1/case_den_han_eb_ychtth.html"
						class="btn btn-warning" style="width: 80%">Case đến hạn</a></td>
					<td><a href="/dmt/dmt1/case_qua_han_eb_ychtth.html"
						class="btn btn-danger" style="width: 80%">Case quá hạn</a></td>
					<td><a href="/dmt/dmt1/case_xulygap_eb_ychtth.html"
						class="btn btn-warning" style="width: 80%">Case xử lý gấp</a></td>
				</tr>
				<tr>
					<td><marquee
							style="font-weight: bold; float: left; color: red; width: ̣90%; margin-left: 5px"
							behavior="alternate">${alert_update_success}</marquee> <c:choose>
							<c:when test="${alert_delete_success != null }">
								<marquee
									style="font-weight: bold; float: left; color: red; width: ̣90%; margin-left: 5px"
									behavior="alternate">${alert_delete_success}</marquee>
							</c:when>
						</c:choose></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</table>
		</form>
	</div>
	</br>
	</br>
	</br>
	<div class="rightContent"
		style="margin-top: 360px; margin-left: 0px; height: 10px; position: fixed;">
		<div class="themThongTinTraSoatISS" style="height: 50px">
			<div id="thediv_scroll"
				style="margin-top: -65px; margin-left: 130px; box-shadow: 0px 0px 12px 0px #5E9BB4"">
				<table rules="groups" frame="hsides" id="testTable"
					class="tableTruyVanISS1 scroll"
					style="width: 250%; table-layout: fixed; height: 50px;">
					<thead valign="top">
						<tr class="header-table">
							<th>Ngày tiếp nhận</th>
							<th>Case ID</th>
							<th>Khách hàng</th>
							<th>CIF</th>
							<th>Kênh GD</th>
							<th>Hình thức</th>
							<th>Đối tác</th>
							<th>Dịch vụ</th>
							<th>NCC</th>
							<th>TK nguồn</th>
							<th>TK đích</th>
							<th>Số tiền GD</th>
							<th>Số trace</th>
							<th>Phí hỗ trợ</th>
							<th>NHTH</th>
							<th>Lý do TS</th>
							<th>Tình trạng case</th>
							<th>Thời gian t.nhận</th>
							<th>User nhập</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list_eb_ychtth}" var="p">
							<tr id="rows" class="rows">
								<td><a href="/dmt/dmt1/detail_eb_ychtth.html?id=${p.ebId}">${fn:substring(p.ebRecDt, 6, 8)}/${fn:substring(p.ebRecDt, 4, 6)}/${fn:substring(p.ebRecDt, 0, 4)}</a></td>
								<td>${p.ebCaseId}</td>
								<td>${p.ebCustName}</td>
								<td>${p.ebCifNo}</td>
								<td>${p.ebTxnChanel}</td>
								<td>${p.ebHinhThuc}</td>
								<td>${p.ebPartner}</td>
								<td>${p.ebServices}</td>
								<td>${p.ebSupplier}</td>
								<td>${p.ebFromAcct}</td>
								<td>${p.ebToAcct}</td>
								<td><fmt:formatNumber pattern="#,##0" value="${p.ebTxnAmt}" /></td>
								<td>${p.ebTrace}</td>
								<td>${p.ebPhiHoTro}</td>
								<td>${p.ebNhth}<c:choose>
										<c:when test=""></c:when>
									</c:choose>
								</td>
								<td>${p.ebDisReasonCde}</td>
								<td>${p.ebCaseStatus}</td>
								<td>${p.ebCreateTime}</td>
								<td>${p.ebUserCreate}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<input style="height: 30px; width: 100px; float: left;"
					class="btn btn-danger" type="button"
					onclick="tableToExcel('testTable', 'DISPUTE-TOOL-BY-P.KTT&NHDT')"
					value="Export">
			</div>
		</div>
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
	<script>
		var tableToExcel = (function() {
			var uri = 'data:application/vnd.ms-excel;base64,', template = '<html xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:x="urn:schemas-microsoft-com:office:excel" xmlns="http://www.w3.org/TR/REC-html40"><head><!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name>{worksheet}</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]--></head><body><table>{table}</table></body></html>', base64 = function(
					s) {
				return window.btoa(unescape(encodeURIComponent(s)))
			}, format = function(s, c) {
				return s.replace(/{(\w+)}/g, function(m, p) {
					return c[p];
				})
			}
			return function(table, name) {
				if (!table.nodeType)
					table = document.getElementById(table)
				var ctx = {
					worksheet : name || 'Worksheet',
					table : table.innerHTML
				}
				window.location.href = uri + base64(format(template, ctx))
			}
		})()
	</script>
</body>
</html>