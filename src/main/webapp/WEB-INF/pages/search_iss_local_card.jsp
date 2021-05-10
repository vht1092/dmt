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
<title>TRUY VẤN CASE: THẺ-CHIỀU NHPH(ISS)</title>
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
		<div class="title-content">Truy vấn/Cập nhật thẻ nội địa-Chiều
			NHPH(ISS)</div>
		<form
			action="${pageContext.request.contextPath}/search_iss_local_card"
			method="post" style="position: fixed; margin-top: 75px;">
			<table class="form-search-iss" style="width: 100%; margin-left: -5%;">
				<tr>
					<td><span>Theo</span> <select name="loaiNgaySearch"
						class="form-control">
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
							<c:when test="${txt_caseId != ''}">
								<input name="txt_caseId" class="form-control"
									value="${txt_caseId}" />
							</c:when>
							<c:otherwise>
								<input name="txt_caseId" class="form-control" />
							</c:otherwise>
						</c:choose></td>
					<td><span>CIF</span> <c:choose>
							<c:when test="${txt_caseId != ''}">
								<input name="txt_Cif" class="form-control" value="${ txt_Cif}" />
							</c:when>
							<c:otherwise>
								<input name="txt_Cif" class="form-control" />
							</c:otherwise>
						</c:choose></td>
				</tr>
				<tr>
					<td><span>Trace</span> <c:choose>
							<c:when test="${txt_trace != ''}">
								<input name="txt_trace" class="form-control"
									value="${txt_trace}" />
							</c:when>
							<c:otherwise>
								<input name="txt_trace" class="form-control" />
							</c:otherwise>
						</c:choose></td>
					<td><span>Lý do tra soát</span><select
						onchange="nguyennhantrasoat_lydokhac()" class="form-control"
						id="lyDoTraSoat" name="txt_lyDoTraSoat">
							<option value=""></option>
							<option value="1">Không thực hiện giao dịch</option>
							<option value="2">Giao dịch báo nợ hai/nhiều lần</option>
							<option value="3">Đã thanh toán bằng hình thức khác</option>
							<option value="4">Số tiền ghi nợ vào thẻ không đúng với
								hóa đơn</option>
							<option value="5">Không nhận được hàng hóa/dịch vụ</option>
							<option value="6">GD đã được TB hủy/hoàn trả nhưng ko
								nhận được hoàn trả</option>
							<option value="7">Không nhận được tiền nhưng tài
								khoản/thẻ bị trừ tiền</option>
							<option value="8">Giao dịch không thành công nhưng tài
								khoản/thẻ bị trừ tiền</option>
							<option value="1">ATM chi tiền không đủ</option>
							<option value="1">ATM chi tiền khác với số tiền ghi nợ</option>
							<option value="1">ATM nuốt lại tiền</option>
							<option value="9">Lý do khác(nhập nội dung font tiếng
								việt)</option>
					</select></td>
					<td><span>Tình trạng case</span> <select class="form-control"
						id="tinhTrangCase" name="txt_tinhTrangCase">
							<option value=""></option>
							<option value="Pending">Pending</option>
							<option value="TS lan 1">TS lần 1</option>
							<option value="TS lan 2">TS lần 2</option>
							<option value="Thuong luong, hoa giai">Thương lượng, hòa
								giải</option>
							<option value="HD hoa giai Napas/Trong tai/Toa an">HĐ
								hòa giải Napas/Trọng tài/Tòa án</option>
							<option value="Done">Done</option>
					</select></td>
					<td><span>KQ tra soát</span> <select name="txt_ketQuaTraSoat"
						style="width: 85%" class="form-control">
							<c:choose>
								<c:when test="${txt_ketQuaTraSoat == '' }">
									<option value="" selected="selected"></option>
								</c:when>
								<c:otherwise>
									<option value=""></option>
								</c:otherwise>
							</c:choose>
							<option value="">All</option>
							<c:choose>
								<c:when test="${txt_ketQuaTraSoat == '1' }">
									<option value="1" selected="selected">KH ngừng tra
										soát</option>
								</c:when>
								<c:otherwise>
									<option value="1">KH ngừng tra soát</option>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${txt_ketQuaTraSoat == '2' }">
									<option value="2" selected="selected">KH chấp nhận
										chứng từ</option>
								</c:when>
								<c:otherwise>
									<option value="2">KH chấp nhận chứng từ</option>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${txt_ketQuaTraSoat == '3' }">
									<option value="3" selected="selected">NHTT hoàn trả
										giao dịch</option>
								</c:when>
								<c:otherwise>
									<option value="3">NHTT hoàn trả giao dịch</option>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${txt_ketQuaTraSoat == '4' }">
									<option value="4" selected="selected">TQT thực hiện
										hoàn trả</option>
								</c:when>
								<c:otherwise>
									<option value="4">TQT thực hiện hoàn trả</option>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${txt_ketQuaTraSoat == '5' }">
									<option value="5" selected="selected">Khác</option>
								</c:when>
								<c:otherwise>
									<option value="5">Khác</option>
								</c:otherwise>
							</c:choose>
					</select></td>

				</tr>
				<tr>
					<td><input type="submit" value="SEARCH"
						style="float: left; width: 80%"
						class="form-control btn btn-success" /></td>
					<td><a href="case_can_xu_ly.html" class="btn btn-info"
						style="width: 80%">Case cần xử lý</a></td>
					<td><a href="case_den_han.html" class="btn btn-warning"
						style="width: 80%">Case đến hạn</a></td>
					<td><a href="case_qua_han.html" class="btn btn-danger"
						style="width: 80%">Case quá hạn</a></td>
				</tr>
				<tr>
					<td><marquee
							style="font-weight: bold; float: left; color: red; width: ̣90%; margin-left: 5px"
							behavior="alternate">${alert_update_success}</marquee></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</table>
		</form>
	</div>
	</br>
	<div class="rightContent"
		style="margin-top: 360px; margin-left: 0px; height: 10px; position: fixed;">
		<div class="themThongTinTraSoatISS" style="height: 50px">
			<div id="thediv_scroll"
				style="margin-top: -65px; margin-left: 130px; box-shadow: 0px 0px 12px 0px #5E9BB4"">
				<table rules="groups" frame="hsides" id="testTable"
					class="tableTruyVanISS1 scroll"
					style="width: 200%; table-layout: fixed; height: 50px;">
					<thead valign="top">
						<tr class="header-table">
							<th style="width: 10%">Ngày tiếp nhận</th>
							<th style="width: 10%">TG x.lý còn lại</th>
							<th style="width: 14%">Case ID</th>
							<th style="width: 22%">Chủ thẻ</th>
							<th style="width: 8%">CIF</th>
							<th style="width: 14%">Số thẻ</th>
							<th style="width: 30%">ĐVCNT</th>
							<th style="width: 10%">TID</th>
							<th style="width: 10%">Ngày GD</th>
							<th style="width: 10%">Số tiền GD</th>
							<th style="width: 10%">Mã cấp phép</th>
							<th style="width: 8%">Trace</th>
							<th style="width: 30%">Lý do tra soát</th>
							<th style="width: 25%">Tình trạng case</th>
							<th style="width: 40%">Ch/tiết q/trình xử lý</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list_iss_card_local}" var="p">
							<tr id="rows" class="rows">
								<td style="width: 10%; text-decoration: none;">${fn:substring(p.crdRecDt, 6, 8)}/${fn:substring(p.crdRecDt, 4, 6)}/${fn:substring(p.crdRecDt, 0, 4)}</td>
								<td style="width: 10%">${p.crdThoiGianXuLyConLai}</td>
								<td style="width: 14%">&nbsp;${fn:substring(p.crdCaseId, 0, 15)}</td>
								<td style="width: 22%; text-align: left;"><a
									href="detail_iss_local_card.html?id=${p.crdCreTms}">${p.crdCustName}</a></td>
								<td style="width: 8%">&nbsp; ${p.crdCifNo}</td>
								<td style="width: 14%">${fn:substring(p.crdPan, 0, 4)}
									${fn:substring(p.crdPan, 4, 8)} ${fn:substring(p.crdPan, 8, 12)}
									${fn:substring(p.crdPan, 12, 16)}</td>
								<td style="width: 30%; text-align: left;">&nbsp; ${p.crdMercName}</td>
								<td style="width: 10%;">${p.crdTid}</td>
								<td style="width: 10%">${fn:substring(p.crdTxnDt, 6, 8)}/${fn:substring(p.crdTxnDt, 4, 6)}/${fn:substring(p.crdTxnDt, 0, 4)}</td>
								<td style="width: 10%; text-align: right;"><fmt:formatNumber
										pattern="#,##0" value="${p.crdTxnAmt}" /></td>
								<td style="width: 10%">${p.crdApvCde}</td>
								<td style="width: 8%">${p.crdTrace}</td>
								<td style="text-align: left; width: 35%"><c:choose>
										<c:when test=""></c:when>
										<c:when test="${p.crdDisReasonCde == '1'}">Không thực hiện giao dịch</c:when>
										<c:when test="${p.crdDisReasonCde == '2'}">Giao dịch báo nợ hai/nhiều lần</c:when>
										<c:when test="${p.crdDisReasonCde == '3'}">Đã thanh toán bằng hình thức khác</c:when>
										<c:when test="${p.crdDisReasonCde == '4'}">Số tiền ghi nợ thẻ ko đúng với HĐ</c:when>
										<c:when test="${p.crdDisReasonCde == '5'}">Không nhận được hàng hóa/dịch vụ</c:when>
										<c:when test="${p.crdDisReasonCde == '6'}">GD đc TB hủy/hoàn trả, ko nhận được hoàn trả</c:when>
										<c:when test="${p.crdDisReasonCde == '7'}">Không nhận được tiền, tài khoản/thẻ bị trừ tiền</c:when>
										<c:when test="${p.crdDisReasonCde == '8'}">GD không th/công, tài khoản/thẻ bị trừ tiền</c:when>
										<c:when test="${p.crdDisReasonCde == '9'}">${fn:substring(p.nguyennhankhac, 0, 50)}</c:when>
									</c:choose></td>
								<td style="width: 25%">${p.crdCaseStatus}</td>
								<td style="width: 40%; text-align: left"><c:choose>
										<c:when test="${p.crdProcProg != 'null'}">${fn:substring(p.crdProcProg, 0, 50)}</c:when>
									</c:choose></td>
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