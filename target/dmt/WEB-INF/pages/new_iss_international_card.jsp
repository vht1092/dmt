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
<title>THÊM MỚI CASE: THẺ-CHIỀU NHPH(ISS)</title>
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
				<li class="dropdown-submenu" hidden><a class="test"
					tabindex="-1" href="#" style="background-color: #F9DF91;">Thẻ
						nội địa<span class="caret"></span>
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
		<div class="title-content">Thêm mới case thẻ quốc tế-Chiều
			NHPH(ISS)</div>
		<form
			action="${pageContext.request.contextPath}/search_international_card"
			method="post" style="position: fixed; margin-top: 75px;"
			autocomplete="off">
			<table class="form-search-iss" style="width: 100%;">
				<tr>
					<td><input autocomplete="off" name="txt_cardNo" type="text"
						class="form-control" value="" minlenght="10" maxlength="19"
						id="slitCardNo" onkeypress="return keyPressWord(event);"
						placeholder="Số thẻ" required /></td>
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
							<th style="width: 5%;"></th>
							<th>Chủ thẻ</th>
							<th style="width: 15%">LOC</th>
							<th style="width: 15%">CIF</th>
							<th>Số thẻ</th>
							<th>ĐVCNT</th>
							<th>MID</th>
							<th style="width: 15%">TID</th>
							<th style="width: 15%">ICA</th>
							<th style="width: 15%">Ngày GD</th>
							<th style="width: 15%">Số tiền GD</th>
							<th style="width: 15%">Loại tiền</th>
							<th style="width: 15%">Số tiền q.đổi</th>
							<th style="width: 15%">Mã cấp phép</th>
							<th style="width: 15%">Trace</th>
							<th style="width: 15%">POS mode</th>
							<th style="width: 15%">MCC</th>
							<th style="width: 15%">3D Ind</th>
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
									value="${p.crdCreTms}"></td>
								<td style="border: 1px solid #D5EAD5">${fn:substring(p.crdCustName, 0, 20)}</td>
								<td style="width: 15%">${p.crdLoc}</td>
								<td style="width: 15%">${p.crdCifNo}</td>
								<td>${p.crdPan}</td>
								<td>${fn:substring(p.crdMercName, 0, 20)}</td>
								<td>${p.crdMercId}</td>
								<td style="width: 15%">${p.crdTid}</td>
								<td style="width: 15%">${p.ica}</td>
								<td style="width: 15%">${fn:substring(p.crdTxnDt, 6, 8)}/${fn:substring(p.crdTxnDt, 4, 6)}/${fn:substring(p.crdTxnDt, 0, 4)}</td>
								<td style="width: 15%"><fmt:formatNumber pattern="#,##0"
										value="${p.crdTxnAmt}" />.00</td>
								<td style="width: 15%">${p.crdCurrCde}</td>
								<td style="width: 15%"><fmt:formatNumber pattern="#,##0"
										value="${p.crdVndAmt}" />.00</td>
								<td style="width: 15%">${p.crdApvCde}</td>
								<td style="width: 15%">${p.crdTrace}</td>
								<td style="width: 15%">${fn:substring(p.crdPosMode, 0, 2)}</td>
								<td style="width: 15%">${p.crdMcc}</td>
								<td style="width: 15%">${p.crd3dIn}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<form
			action="${pageContext.request.contextPath}/create_international_card"
			method="post" style="margin-top: 300px;">
			<input class="form-control" id="selectedTrxn" name="selectedTrxn"
				style="margin-top: 200px; position: fixed; width: 100%; visibility: hidden;"
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
					<td style="width: 16%"><span>Kênh giao dịch</span> <select
						class="form-control" id="kenhGiaoDich" name="kenhGiaoDich">
							<option value=""></option>
							<option value="ATM">ATM</option>
							<option value="POS">POS</option>
							<option value="E-commerce">E-commerce</option>
							<option value="QR">QR</option>
							<option value="Samsung Pay">Samsung Pay</option>
					</select></td>

					<td style="width: 16%"><span>Loại thẻ</span> <select
						class="form-control" id="loaiThe" name="loaiThe">
							<option value=""></option>
							<option value="MC CREDIT">MC CREDIT</option>
							<option value="MC DEBIT">MC DEBIT</option>
							<option value="VS CREDIT">VS CREDIT</option>
							<option value="VS DEBIT">VS DEBIT</option>
					</select></td>
					<td style="width: 16%"><span>Lý do tra soát</span> <select
						onchange="nguyennhantrasoat_lydokhac()" class="form-control"
						id="lyDoTraSoat" name="lyDoTraSoat">
							<option value=""></option>
							<option value="1">Không thực hiện giao dịch</option>
							<option value="2">Giao dịch báo nợ hai/nhiều lần</option>
							<option value="3">Đã thanh toán bằng hình thức khác</option>
							<option value="4">Số tiền ghi nợ vào thẻ không đúng với
								hóa đơn</option>
							<option value="5">Không nhận được hàng hóa/dịch vụ</option>
							<option value="6">Giao dịch đã được thông báo hủy/hoàn
								trả nhưng không nhận được hoàn trả</option>
							<option value="7">Không nhận được tiền nhưng tài
								khoản/thẻ bị trừ tiền</option>
							<option value="8">Giao dịch không thành công nhưng tài
								khoản/thẻ bị trừ tiền</option>
							<option value="9">Lý do khác(nhập nội dung font tiếng
								việt)</option>
					</select></td>
					<td style="width: 16%"><span>Tình trạng case</span> <select
						class="form-control" id="tinhTrangCase" name="tinhTrangCase">
							<option value=""></option>
							<option value="Pending">Pending</option>
							<option value="Offline">Offline</option>
							<option value="Retrieval Request">Retrieval Request</option>
							<option value="Chargeback/Dispute">Chargeback/Dispute</option>
							<option value="Arbitration Chargeback">Arbitration
								Chargeback</option>
							<option value="Pre-Arbitration">Pre-Arbitration</option>
							<option value="Pre-Arbitration Response">Pre-Arbitration
								Response</option>
							<option value="Arbitration">Arbitration</option>
							<option value="Done">Done</option>
					</select></td>
				</tr>
				<tr>
					<td colspan="3"><span>Chi tiết quá trình xử lý</span>
						<div class="md-form">
							<textarea name="quaTrinhXuLy" type="text" id="form7"
								class="md-textarea form-control" rows="3"></textarea>
						</div></td>
					<td style="width: 16%"><input type="submit"
						value="LƯU THÔNG TIN" style="height: 30px; width: 75%"
						class="btn btn-success" /></td>
					<td style="width: 16%;"><input style="visibility: hidden;"
						name="lyDoTraSoatKhac" id="lyDoTraSoatKhac"
						placeholder="Lý do tra soát khác" class="form-control" type="text" /></td>
					<td style="width: 16%"></td>
				</tr>
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