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
			<ul class="dropdown-menu" style="right: 0; left: auto;">
				<li class="dropdown-submenu" style="right: 0px; left: auto;"><a
					class="test" tabindex="-1" href="#">Thêm mới<span class="caret"></span></a>
					<ul class="dropdown-menu" style="right: 250px; left: auto;">
						<li class="dropdown-submenu" style="right: 0; left: auto;"><a
							class="test" href="/dmt/dmt1/new_acq_pos_vtb.html">Thêm mới
								case VTB</a></li>
						<li class="dropdown-submenu" style="right: 0; left: auto;"><a
							class="test" href="/dmt/dmt1/list_acq_pos_vtb.html">Truy
								vấn/Cập nhật case VTB</a></li>
						<li class="dropdown-submenu" style="right: 0; left: auto;"><a
							class="test" href="/dmt/dmt1/new_acq_pos_eib.html">Thêm mới
								case EIB </a></li>
						<li class="dropdown-submenu" style="right: 0; left: auto;"><a
							class="test" href="/dmt/dmt1/list_acq_pos_eib.html">Truy
								vấn/Cập nhật case EIB</a></li>
					</ul></li>
				<li class="dropdown-submenu"><a class="test" tabindex="-1"
					href="#">DV khác</a></li>
			</ul>
		</div>
		<div class="title-content">Truy vấn/Cập nhật ACQ_POS_EIB</div>
		<form
			action="${pageContext.request.contextPath}/dmt1/search_acq_pos_eib"
			method="post" style="position: fixed; margin-top: 75px;">
			<table class="form-search-iss" style="width: 100%; margin-left: -5%;">
				<tr>
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
					<td><span>MID</span> <c:choose>
							<c:when test="${acqPosEibMid != '' && acqPosEibMid != 'null'}">
								<input name="acqPosEibMid" class="form-control"
									value="${acqPosEibMid}" />
							</c:when>
							<c:otherwise>
								<input name="acqPosEibMid" class="form-control" />
							</c:otherwise>
						</c:choose></td>
					<td><span>TID</span> <c:choose>
							<c:when test="${acqPosEibTid != '' && acqPosEibTid != null}">
								<input name="acqPosEibTid" class="form-control"
									value="${acqPosEibTid}" />
							</c:when>
							<c:otherwise>
								<input name="acqPosEibTid" class="form-control" value="" />
							</c:otherwise>
						</c:choose></td>
					<td><span>Loại thẻ</span> <select style="width: 85%"
						class="form-control" id="loaiThe" name="acqPosEib_loaiThe">
							<option value="" selected="selected"></option>
							<option value="MC">MC</option>
							<option value="VS">VS</option>
							<option value="JCB">JCB</option>
							<option value="DCI">DCI</option>
							<option value="BNVN">BNVN</option>
							<option value="Khac">Khác</option>
					</select></td>
				</tr>
				<tr>
					<td><span>Số thẻ đầu</span> <c:choose>
							<c:when
								test="${acqPosEibsoTheDau != '' && acqPosEibsoTheDau != 'null'}">
								<input name="acqPosEibsoTheDau" class="form-control"
									value="${acqPosEibsoTheDau}" />
							</c:when>
							<c:otherwise>
								<input name="acqPosEibsoTheDau" class="form-control" />
							</c:otherwise>
						</c:choose></td>
					<td><span>Số thẻ cuối</span> <c:choose>
							<c:when
								test="${acqPosEibsoTheCuoi != '' && acqPosEibsoTheCuoi != null}">
								<input name="acqPosEibsoTheCuoi" class="form-control"
									value="${acqPosEibsoTheCuoi}" />
							</c:when>
							<c:otherwise>
								<input name="acqPosEibsoTheCuoi" class="form-control" value="" />
							</c:otherwise>
						</c:choose></td>
					<td><span>KQ giao dịch</span> <select name="txt_KqGiaodich"
						style="width: 85%" class="form-control">
							<c:choose>
								<c:when test="${txt_KqGiaodich == ''}">
									<option value="" selected></option>
								</c:when>
								<c:otherwise>
									<option value=""></option>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${txt_KqGiaodich == ''}">
									<option value="" selected>Thành công</option>
								</c:when>
								<c:otherwise>
									<option value="">Thành công</option>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${txt_KqGiaodich == 'Offline'}">
									<option value="Offline" selected>Thất bại</option>
								</c:when>
								<c:otherwise>
									<option value="Offline">Thất bại</option>
								</c:otherwise>
							</c:choose>
					</select></td>
					<td><span>Lý do y/c xuất trình chứng từ</span> <select
						style="width: 85%" class="form-control" id="loaiThe"
						name="acqPosEib_NoiDungXuLy">
							<option value="" selected="selected"></option>
							<option value="1">Xác thực giao dịch bất thường từ SCB</option>
							<option value="2">Xác thực giao dịch bất thường từ EIB</option>
							<option value="3">Báo cáo gian lận</option>
							<option value="4">Yêu cầu xuất trình chứng từ - Offline</option>
							<option value="5">Yêu cầu xuất trình chứng từ - RR</option>
							<option value="6">Đòi bồi hoàn lần 1 -
								Chargeback/Dispute</option>
							<option value="7">Khác</option>
					</select></td>
					<td><input type="submit" value="SEARCH"
						style="float: left; width: 80%"
						class="form-control btn btn-success" /></td>
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
	<div class="rightContent"
		style="margin-top: 360px; margin-left: 0px; height: 10px; position: fixed;">
		<div class="themThongTinTraSoatISS" style="height: 50px">
			<div id="thediv_scroll"
				style="margin-top: -65px; margin-left: 130px; box-shadow: 0px 0px 12px 0px #5E9BB4">
				<table rules="groups" frame="hsides" id="testTable"
					class="tableTruyVanISS1 scroll"
					style="width: 300%; table-layout: fixed; height: 50px;">
					<thead valign="top">
						<tr class="header-table">
							<th style="width: 10%">MID</th>
							<th style="width: 10%">Tên MID</th>
							<th style="width: 10%">TID</th>
							<th style="width: 10%">Thời gian GD</th>
							<th style="width: 10%">Mã chuẩn chi</th>
							<th style="width: 10%">Số tiền GD gốc</th>
							<th style="width: 10%">Đơn vị tiền GD</th>
							<th style="width: 10%">Số thẻ</th>
							<th style="width: 10%">Loại thẻ</th>
							<th style="width: 10%">POS entry mode</th>
							<th style="width: 10%">Đơn vị quản lý</th>
							<th style="width: 10%">CB phụ trách</th>
							<th style="width: 10%">Xử lý đặc biệt</th>
							<th style="width: 10%">Tiến độ xử lý/ghi chú</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listAcqPosEib}" var="p">
							<tr id="rows" class="rows">
								<c:choose>
									<c:when
										test="${p.acqPosEibNoiDungXuLy == '1' ||  p.acqPosEibNoiDungXuLy == '2'}">
										<td style="width: 10%; background-color: #C4D79B"><a
											href="detail_acq_pos_eib?id=${p.acqPosEibCreTms}"><a
												href="detail_acq_pos_eib?id=${p.acqPosEibCreTms}">${p.acqPosEibMid}</a></a></td>
									</c:when>
									<c:when test="${p.acqPosEibNoiDungXuLy == '3' }">
										<td style="width: 10%; background-color: yellow;"><a
											href="detail_acq_pos_eib?id=${p.acqPosEibCreTms}">${p.acqPosEibMid}</a></td>
									</c:when>
									<c:when test="${p.acqPosEibNoiDungXuLy == '4' }">
										<td style="width: 10%; background-color: #8DB4E2;"><a
											href="detail_acq_pos_eib?id=${p.acqPosEibCreTms}">${p.acqPosEibMid}</a></td>
									</c:when>
									<c:when
										test="${p.acqPosEibNoiDungXuLy == '4' || p.acqPosEibNoiDungXuLy == '5'}">
										<td style="width: 10%; background-color: #8DB4E2;"><a
											href="detail_acq_pos_eib?id=${p.acqPosEibCreTms}">${p.acqPosEibMid}</a></td>
									</c:when>
									<c:when
										test="${p.acqPosEibNoiDungXuLy == '6' || p.acqPosEibNoiDungXuLy == '7'}">
										<td style="width: 10%; background-color: #FABF8F;"><a
											href="detail_acq_pos_eib?id=${p.acqPosEibCreTms}">${p.acqPosEibMid}</a></td>
									</c:when>
									<c:when test="${p.acqPosEibNoiDungXuLy == '8'}">
										<td style="width: 10%; background-color: red;"><a
											href="detail_acq_pos_eib?id=${p.acqPosEibCreTms}">${p.acqPosEibMid}</a></td>
									</c:when>
									<c:when test="${p.acqPosEibNoiDungXuLy == '9'}">
										<td style="width: 10%; background-color: #B1A0C7;"><a
											href="detail_acq_pos_eib?id=${p.acqPosEibCreTms}">${p.acqPosEibMid}</a></td>
									</c:when>
									<c:when test="${p.acqPosEibNoiDungXuLy == '10'}">
										<td style="width: 10%; background-color: white;"><a
											href="detail_acq_pos_eib?id=${p.acqPosEibCreTms}">${p.acqPosEibMid}</a></td>
									</c:when>
								</c:choose>

								<td style="width: 10%;">${p.acqPosEibMerchantName}</td>
								<td style="width: 10%;">${p.acqPosEibTid}</td>
								<td style="width: 10%;">${p.acqPosEibtrxnDate}</td>
								<td style="width: 10%;">${p.acqPosEibApproveCode}</td>
								<td style="width: 10%;">${p.acqPosEibTxnAmt}</td>
								<td style="width: 10%;">${p.acqPosEib_LoaiTien}</td>
								<td style="width: 10%;">${p.acqPosEibsoTheDau}&nbsp;XXXXXX
									${p.acqPosEibsoTheCuoi}</td>
								<td style="width: 10%;">${p.acqPosEibloaiThe}</td>
								<td style="width: 10%;">${p.acqPosEibPosMode}</td>
								<td style="width: 10%;">${p.acqPosEibBranch}</td>
								<td style="width: 10%;">${p.acqPosEibCanBoPhuTrach}</td>
								<td style="width: 10%;"><c:choose>
										<c:when test="${p.acqPosEibNoiDungXuLy == '1'}">Xác thực giao dịch bất thường từ SCB</c:when>
										<c:when test="${p.acqPosEibNoiDungXuLy == '2'}">Xác thực giao dịch bất thường từ EIB</c:when>
										<c:when test="${p.acqPosEibNoiDungXuLy == '3'}">Báo cáo gian lận</c:when>
										<c:when test="${p.acqPosEibNoiDungXuLy == '4'}">Yêu cầu xuất trình chứng từ - Offline</c:when>
										<c:when test="${p.acqPosEibNoiDungXuLy == '5'}">Yêu cầu xuất trình chứng từ - RR</c:when>
										<c:when test="${p.acqPosEibNoiDungXuLy == '6'}">Đòi bồi hoàn lần 1 -
								Chargeback/Dispute</c:when>
										<c:when test="${p.acqPosEibNoiDungXuLy == '7'}">Khác</c:when>
									</c:choose></td>
								<td style="width: 10%;">${p.acqPosEibtienDoXuLy}</td>
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