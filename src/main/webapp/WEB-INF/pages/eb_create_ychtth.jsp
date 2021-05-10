<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.io.*"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>THÊM MỚI CASE: EB-CHIỀU NHPH(ISS)</title>
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
		<div class="title-content">Thêm mới case EB-Chiều NHPH(ISS)</div>
		<form
			action="${pageContext.request.contextPath}/dmt2/search_eb_create_ychtth"
			method="post" style="position: fixed; margin-top: 75px;"
			autocomplete="off">
			<table class="form-search-iss" style="width: 90%; margin-left: -2%">
				<tr>
					<td><c:choose>
							<c:when test="${txt_cifNo != ''}">
								<input autocomplete="off" name="txt_cifNo" type="text"
									class="form-control" value="${txt_cifNo}" minlenght="7"
									onkeypress="return keyPressWord(event);" placeholder="Số Cif"
									style="width: 120px" required />
							</c:when>
							<c:otherwise>
								<input autocomplete="off" name="txt_cifNo" type="text"
									class="form-control" value="" minlenght="7"
									onkeypress="return keyPressWord(event);" placeholder="Số Cif"
									style="width: 120px" required />
							</c:otherwise>
						</c:choose></td>
					<td><c:choose>
							<c:when test="${txt_account != ''}">
								<input autocomplete="off" name="txt_account" type="text"
									class="form-control" value="${txt_account}"
									onkeypress="return keyPressWord(event);"
									placeholder="Tài khoản đích" style="width: 150px" />
							</c:when>
							<c:otherwise>
								<input autocomplete="off" name="txt_account" type="text"
									class="form-control" value=""
									onkeypress="return keyPressWord(event);"
									placeholder="Tài khoản đích" style="width: 150px" />
							</c:otherwise>
						</c:choose></td>
					<td><c:choose>
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
					<td><c:choose>
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
					<td><input type="submit" class="btn btn-success"
						style="height: 30px" value="TRUY VẤN" /> <span
						class="btn btn-danger" style="height: 30px; width: 98px"
						onclick="clearForms()">XÓA</span></td>
					<td></td>
				</tr>
			</table>
		</form>
	</div>
	<div class="rightContent"
		style="margin-top: 180px; margin-left: 0px; height: 10px; position: fixed;">
		<div class="themThongTinTraSoatISS" style="height: 50px">
			<div id="thediv_scroll"
				style="margin-top: -65px; margin-left: 130px; box-shadow: 0px 0px 12px 0px #5E9BB4"">
				<table rules="groups" frame="hsides" id="testTable"
					class="tableTruyVanISS1 scroll"
					style="width: 180%; table-layout: fixed; height: 50px;">
					<thead valign="top">
						<tr class="header-table">
							<th style="width: 2%"></th>
							<th>Ngày GD</th>
							<th style="width: 15%">Kênh</th>
							<th style="width: 15%">Số GD FCC</th>
							<th>Mã CIF</th>
							<th>TK nguồn</th>
							<th>TK đích</th>
							<th style="width: 15%">Trace</th>
							<th style="width: 15%">Số tiền</th>
							<th style="width: 15%">Diễn giải</th>
							<th style="width: 15%">NHPH</th>
							<th style="width: 15%">NHTH</th>
							<th style="width: 15%">Mã TT</th>
							<th style="width: 15%">Trạng thái GD</th>
							<th style="width: 15%">ĐV quản lý TK</th>
						</tr>
					</thead>
					<%
						int index = 1;
					%>
					<tbody>
						<c:forEach items="${list}" var="p">
							<tr id="rows" class="rows">
								<td style="width: 5%;"><input
									onclick="selectedTrxn_Click(this.id)"
									style="font-size: 2px; height: 13px" type="checkbox"
									name="createTime"
									id="createTime<%out.println(String.format("%d", index));index++;%>"
									value="${p.ebId}"></td>
								<td style="width: 15%">${fn:substring(p.ebTxnDt, 6, 8)}/${fn:substring(p.ebTxnDt, 4, 6)}/${fn:substring(p.ebTxnDt, 0, 4)}</td>
								<td style="width: 15%">${p.ebTxnChanel}</td>
								<td style="width: 15%">${p.ebFccRef}</td>
								<td>${p.ebCifNo}</td>
								<td>${p.ebFromAcct}</td>
								<td>${p.ebToAcct}</td>
								<td style="width: 15%">${p.ebTrace}</td>
								<td style="width: 15%"><fmt:formatNumber pattern="#,##0"
										value="${p.ebTxnAmt}" />.00</td>
								<td style="width: 15%">${p.ebDesc}</td>
								<td style="width: 15%">${p.ebNhph}</td>
								<td style="width: 15%">${p.ebNhth}</td>
								<td style="width: 15%">${p.ebTt}</td>
								<td style="width: 15%">${p.ebTxnStatus}</td>
								<td style="width: 15%">${p.ebDvquanlytk}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<form
			action="${pageContext.request.contextPath}/dmt2/create_eb_ychtth"
			method="post" style="margin-top: 300px;">
			<input class="form-control" id="selectedTrxn" name="selectedTrxn"
				style="margin-top: 200px; position: fixed; width: 100%; height: 5px; visibility: hidden;"
				required /> </br>
			<marquee
				style="font-weight: bold; float: left; color: red; width: 30%; margin-left: 5px"
				behavior="alternate">${alert_success}</marquee>
			<table style="width: 100%; height: auto;">
				<tr>
					<td style="width: 16%"><span>Ngày tiếp nhận</span> <input
						autocomplete="off" name="txt_ngayTiepNhan" class="form-control"
						type="text" placeholder="dd-mm-yyyy" id="datepicker3" required /></td>
					<td style="width: 16%"><span>Case ID</span> <input
						autocomplete="off" name="txt_caseID" type="text"
						class="form-control" /></td>
					<td style="width: 16%"><span>Lý do tra soát</span> <select
						onchange="nguyennhantrasoat_lydokhac_eb()" class="form-control"
						id="lyDoTraSoat" name="txt_lyDoTraSoat">
							<option value=""></option>
							<option value="1">TKTH chưa nhận được tiền</option>
							<option value="2">KH yêu cầu chặn giao dịch, hoàn tiền</option>
							<option value="3">KH chuyển nhầm TKTH</option>
							<option value="4">KH yêu cầu thay đổi nội dung chuyển
								tiền</option>
							<option value="5">CK SCB THÀNH CÔNG - CK SML TIMEOUT, 18</option>
							<option value="6">CK SCB THÀNH CÔNG - CK SML TIMEOUT TRẢ
								LỜI 68, 24</option>
							<option value="7">CẮT TIỀN FCC KHÔNG THÀNH CÔNG, 16</option>
							<option value="8">GD chờ tra soát/Chờ đối soát</option>
							<option value="9">KH bị lừa đảo</option>
							<option value="10">Lý do khác(nhập nội dung font tiếng
								việt)</option>
					</select></td>
					<td style="width: 16%"><span>Tình trạng case</span> <select
						class="form-control" id="tinhTrangCase" name="txt_tinhTrangCase">
							<option value=""></option>
							<option value="Pending">Pending</option>
							<option value="Chua cap nhat trang thai">Chưa cập nhật
								trạng thái</option>
							<option value="Gap">Gấp</option>
							<option value="Done">Done</option>
					</select></td>

					<td style="width: 16%"><span>Phí hỗ trợ</span> <select
						class="form-control" id="loaiThe" name="txt_phiHoTro">
							<option value=""></option>
							<option value="110000">110.000</option>
							<option value="22000">22.000</option>
					</select></td>
					<td style="width: 16%"><span>Ghi chú</span> <input
						autocomplete="off" name="txt_ghiChu" type="text"
						class="form-control" /></td>
				</tr>
				<tr>
					<td colspan="3"><span>Chi tiết quá trình xử lý</span>
						<div class="md-form">
							<textarea name="txt_quaTrinhXuLy" type="text" id="form7"
								class="md-textarea form-control" rows="3"></textarea>
						</div></td>
					<td style="width: 16%"><input type="submit" value="LƯU THÔNG TIN"
						style="height: 30px; width: 72%" class="btn btn-success" /></td>
					<td style="width: 16%;"><input style="visibility: hidden;"
						name="txt_lyDoTraSoatKhac" id="lyDoTraSoatKhac"
						placeholder="Lý do tra soát khác" class="form-control" type="text" /></td>
					<td style="width: 16%"></td>
				</tr>
			</table>
		</form>
		<form
			action="${pageContext.request.contextPath}/dmt1/saveDB_create_eb_ychtth"
			method="post">
			<input name="selectedTrxn" class="form-control" type="text"
				style="width: 48%; float: left; margin-left: 1%; margin-right: 2%; visibility: hidden;"
				required="required" readonly="readonly" value="${selectedTrxn}" />

			<input name="result" class="form-control" type="text"
				style="width: 48%; float: left; margin-left: 1%; margin-right: 2%; visibility: hidden;"
				required="required" readonly="readonly" value="${result}" /> <input
				type="submit" value="SUBMIT" style="height: 30px; width: 10.5%"
				class="btn btn-danger" />
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