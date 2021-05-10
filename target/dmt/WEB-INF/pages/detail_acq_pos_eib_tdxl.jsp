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
		<div class="title-content">Chi tiết nội dung xử lý ACQ_POS_EIB</div>
	</div>
	</br>
	<div class="rightContent"
		style="margin-left: 0px; height: 10px; position: fixed;">
		<div class="themThongTinTraSoatISS" style="height: 50px">
			<div id="thediv_scroll"
				style="margin-left: 130px; box-shadow: 0px 0px 12px 0px #5E9BB4">
				<table rules="groups" frame="hsides" id="testTable"
					class="tableTruyVanISS1 scroll"
					style="width: 100%; table-layout: fixed; height: 50px;">
					<thead valign="top">
						<tr class="header-table">
							<th style="width: 10%">NGÀY CẬP NHẬT</th>
							<th style="width: 10%">NỘI DUNG XỦ LÝ</th>
							<th style="width: 10%">LÝ DO R/C</th>
							<th style="width: 10%">USER</th>
							<th style="width: 10%">LINK CASE BAN ĐẦU</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listAcqPosEibTdxl}" var="p">
							<tr id="rows" class="rows">
								<td style="width: 10%;">${p.acqPosEibCreTms}</td>
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
								<td style="width: 10%;"><c:choose>
										<c:when
											test="${p.acqPosEibNoiDungXuLy == '1' || p.acqPosEibNoiDungXuLy == '2'}">
											<c:choose>
												<c:when
													test="${fn:contains(p.acqPosEibGDBatThuong1, 'acqPosEib_GDBatThuong1')}">
													<span style="color: red"> - Giao dịch bất thường,
														thẻ từ</span>
												</c:when>
											</c:choose>
											<c:choose>
												<c:when
													test="${fn:contains(p.acqPosEibGDBatThuong1, 'acqPosEib_GDBatThuong2')}">
													<span style="color: red"> - Giao dịch bất thường,
														giá trị lớn, thẻ từ</span>
												</c:when>
											</c:choose>
											<c:choose>
												<c:when
													test="${fn:contains(p.acqPosEibGDBatThuong1, 'acqPosEib_GDBatThuong3')}">
													<span style="color: red"> - Giao dịch bất thường,
														MOTO</span>
												</c:when>
											</c:choose>
											<c:choose>
												<c:when
													test="${fn:contains(p.acqPosEibGDBatThuong1, 'acqPosEib_GDBatThuong4')}">
													<span style="color: red"> - Giao dịch bất thường,
														giá trị lớn, MOTO</span>
												</c:when>
											</c:choose>
											<c:choose>
												<c:when
													test="${fn:contains(p.acqPosEibGDBatThuong1, 'acqPosEib_GDBatThuong5')}">
													<span style="color: red"> - Giao dịch bất thường,
														giá trị lớn</span>
												</c:when>
											</c:choose>
											<c:choose>
												<c:when
													test="${fn:contains(p.acqPosEibGDBatThuong1, 'acqPosEib_GDBatThuong6')}">
													<span style="color: red"> - Khác</span>
												</c:when>
											</c:choose>
										</c:when>
										<c:when test="${p.acqPosEibNoiDungXuLy == '3'}">
									{p.acqPosEibnoiDungXuLyKhac}
								</c:when>
										<c:when
											test="${p.acqPosEibNoiDungXuLy == '4' || p.acqPosEibNoiDungXuLy == '5'}">
											<c:choose>
												<c:when
													test="${fn:contains(p.acqPosEibYCXuatTrinhChungTu1, 'acqPosEib_YCXuatTrinhChungTu1')}">
													<span style="color: red">Chủ thẻ yêu cầu chứng từ có
														chữ ký</br>
													</span>
												</c:when>
											</c:choose>
											<c:choose>
												<c:when
													test="${fn:contains(p.acqPosEibYCXuatTrinhChungTu1, 'acqPosEib_YCXuatTrinhChungTu2')}">
													<span style="color: red">Chủ thẻ không nhận ra giao
														dịch</br>
													</span>
												</c:when>
											</c:choose>
											<c:choose>
												<c:when
													test="${fn:contains(p.acqPosEibYCXuatTrinhChungTu1, 'acqPosEib_YCXuatTrinhChungTu3')}">
												Chủ thẻ không đồng ý với số tiền trên hóa đơn</br>
													</span>
												</c:when>
											</c:choose>

											<c:choose>
												<c:when
													test="${fn:contains(p.acqPosEibYCXuatTrinhChungTu1, 'acqPosEib_YCXuatTrinhChungTu4')}">
													<span style="color: red">Điều tra gian lận</br></span>
												</c:when>
											</c:choose>

											<c:choose>
												<c:when
													test="${fn:contains(p.acqPosEibYCXuatTrinhChungTu1, 'acqPosEib_YCXuatTrinhChungTu5')}">
													<span style="color: red">Khác</br></span>
												</c:when>
											</c:choose>
										</c:when>
										<c:when
											test="${p.acqPosEibNoiDungXuLy == '6' && p.acqPosEibloaiThe == 'VS'}">
											<select style="width: 65%; float: right;" id="loaiThe"
												name="acqPosEib_noiDungXuLy_VS">
												<c:choose>
													<c:when test="${p.acqPosEibnoiDungXuLyVS == ''}">
														<option value="" selected></option>
													</c:when>
													<c:otherwise>
														<option value=""></option>
													</c:otherwise>
												</c:choose>
												<c:choose>
													<c:when test="${p.acqPosEibnoiDungXuLyVS == 'VS1'}">
														<option value="VS1" selected>10.1 - EMV Liability
															Shift Counterfeit Fraud</br>
														</option>
													</c:when>
													<c:otherwise>
														<option value="VS1">10.1 - EMV Liability Shift
															Counterfeit Fraud</br>
														</option>
													</c:otherwise>
												</c:choose>

												<c:choose>
													<c:when test="${p.acqPosEibnoiDungXuLyVS == 'VS2'}">
														<option value="VS2" selected>10.2 - EMV Liability
															Shift Non-Counterfeit Fraud</br>
														</option>
													</c:when>
													<c:otherwise>
														<option value="VS2">10.2 - EMV Liability Shift
															Non-Counterfeit Fraud</br>
														</option>
													</c:otherwise>
												</c:choose>

												<c:choose>
													<c:when test="${p.acqPosEibnoiDungXuLyVS == 'VS3'}">
														<option value="VS3" selected>10.3 - Other
															Fraud-Card Present Environment</br>
														</option>
													</c:when>
													<c:otherwise>
														<option value="VS3">10.3 - Other Fraud-Card
															Present Environment</br>
														</option>
													</c:otherwise>
												</c:choose>

												<c:choose>
													<c:when test="${p.acqPosEibnoiDungXuLyVS == 'VS4'}">
														<option value="VS4" selected>10.4 - Other
															Fraud-Card Absent Environment</br>
														</option>
													</c:when>
													<c:otherwise>
														<option value="VS4">10.4 - Other Fraud-Card
															Absent Environment</br>
														</option>
													</c:otherwise>
												</c:choose>

												<c:choose>
													<c:when test="${p.acqPosEibnoiDungXuLyVS == 'VS5'}">
														<option value="VS5" selected>10.5 - Visa Fraud
															Monitoring Program</br>
														</option>
													</c:when>
													<c:otherwise>
														<option value="VS5">10.5 - Visa Fraud Monitoring
															Program</br>
														</option>
													</c:otherwise>
												</c:choose>

												<c:choose>
													<c:when test="${p.acqPosEibnoiDungXuLyVS == 'VS6'}">
														<option value="VS6" selected>11.1 - Card Recovery
															Bulletin</br>
														</option>
													</c:when>
													<c:otherwise>
														<option value="VS6">11.1 - Card Recovery Bulletin</br>
														</option>
													</c:otherwise>
												</c:choose>

												<c:choose>
													<c:when test="${p.acqPosEibnoiDungXuLyVS == 'VS7'}">
														<option value="VS7" selected>11.2 - Declined
															Authorization</br>
														</option>
													</c:when>
													<c:otherwise>
														<option value="VS7">11.2 - Declined Authorization</br>
														</option>
													</c:otherwise>
												</c:choose>

												<c:choose>
													<c:when test="${p.acqPosEibnoiDungXuLyVS == 'VS8'}">
														<option value="VS8" selected>11.3 - No
															Authorization</br>
														</option>
													</c:when>
													<c:otherwise>
														<option value="VS8">11.3 - No Authorization</br>
														</option>
													</c:otherwise>
												</c:choose>

												<c:choose>
													<c:when test="${p.acqPosEibnoiDungXuLyVS == 'VS9'}">
														<option value="VS9" selected>12.1 - Late
															Presentment</br>
														</option>
													</c:when>
													<c:otherwise>
														<option value="VS9">12.1 - Late Presentment</br>
														</option>
													</c:otherwise>
												</c:choose>

												<c:choose>
													<c:when test="${p.acqPosEibnoiDungXuLyVS == 'VS10'}">
														<option value="VS10" selected>12.2 - Incorrect
															Transaction Code</br>
														</option>
													</c:when>
													<c:otherwise>
														<option value="VS10">12.2 - Incorrect Transaction
															Code</br>
														</option>
													</c:otherwise>
												</c:choose>

												<c:choose>
													<c:when test="${p.acqPosEibnoiDungXuLyVS == 'VS11'}">
														<option value="VS11" selected>12.3 - Incorrect
															Currency</br>
														</option>
													</c:when>
													<c:otherwise>
														<option value="VS11">12.3 - Incorrect Currency</br>
														</option>
													</c:otherwise>
												</c:choose>

												<c:choose>
													<c:when test="${p.acqPosEibnoiDungXuLyVS == 'VS12'}">
														<option value="VS12" selected>12.4 - Incorrect
															Account Number</br>
														</option>
													</c:when>
													<c:otherwise>
														<option value="VS12">12.4 - Incorrect Account
															Number</br>
														</option>
													</c:otherwise>
												</c:choose>

												<c:choose>
													<c:when test="${p.acqPosEibnoiDungXuLyVS == 'VS13'}">
														<option value="VS13" selected>12.5 - Incorrect
															Amount</br>
														</option>
													</c:when>
													<c:otherwise>
														<option value="VS13">12.5 - Incorrect Amount</br>
														</option>
													</c:otherwise>
												</c:choose>

												<c:choose>
													<c:when test="${p.acqPosEibnoiDungXuLyVS == 'VS14'}">
														<option value="VS14" selected>12.6 - Duplicate
															Processing/Paid by Other Means</option>
													</c:when>
													<c:otherwise>
														<option value="VS14">12.6 - Duplicate
															Processing/Paid by Other Means</option>
													</c:otherwise>
												</c:choose>

												<c:choose>
													<c:when test="${p.acqPosEibnoiDungXuLyVS == 'VS15'}">
														<option value="VS15" selected>12.7 - Invalid Data</option>
													</c:when>
													<c:otherwise>
														<option value="VS15">12.7 - Invalid Data</option>
													</c:otherwise>
												</c:choose>

												<c:choose>
													<c:when test="${p.acqPosEibnoiDungXuLyVS == 'VS15'}">
														<option value="VS15" selected>12.7 - Invalid Data</option>
													</c:when>
													<c:otherwise>
														<option value="VS15">12.7 - Invalid Data</option>
													</c:otherwise>
												</c:choose>

												<c:choose>
													<c:when test="${p.acqPosEibnoiDungXuLyVS == 'VS16'}">
														<option value="VS16" selected>13.1 -
															Merchandise/Services Not Received</option>
													</c:when>
													<c:otherwise>
														<option value="VS16">13.1 - Merchandise/Services
															Not Received</option>
													</c:otherwise>
												</c:choose>

												<c:choose>
													<c:when test="${p.acqPosEibnoiDungXuLyVS == 'VS17'}">
														<option value="VS17" selected>13.2 - Cancelled
															Recurring</option>
													</c:when>
													<c:otherwise>
														<option value="VS17">13.2 - Cancelled Recurring</option>
													</c:otherwise>
												</c:choose>

												<c:choose>
													<c:when test="${p.acqPosEibnoiDungXuLyVS == 'VS18'}">
														<option value="VS18" selected>13.3 - Not as
															Described or Defective Merchandise/Services</option>
													</c:when>
													<c:otherwise>
														<option value="VS18">13.3 - Not as Described or
															Defective Merchandise/Services</option>
													</c:otherwise>
												</c:choose>

												<c:choose>
													<c:when test="${p.acqPosEibnoiDungXuLyVS == 'VS19'}">
														<option value="VS19" selected>13.4 - Counterfeit
															Merchandise</option>
													</c:when>
													<c:otherwise>
														<option value="VS19">13.4 - Counterfeit
															Merchandise</option>
													</c:otherwise>
												</c:choose>

												<c:choose>
													<c:when test="${p.acqPosEibnoiDungXuLyVS == 'VS20'}">
														<option value="VS20" selected>13.5 -
															Misrepresentation</option>
													</c:when>
													<c:otherwise>
														<option value="VS20">13.5 - Misrepresentation</option>
													</c:otherwise>
												</c:choose>

												<c:choose>
													<c:when test="${p.acqPosEibnoiDungXuLyVS == 'VS21'}">
														<option value="VS21" selected>13.6 - Credit Not
															Processed</option>
													</c:when>
													<c:otherwise>
														<option value="VS21">13.6 - Credit Not Processed</option>
													</c:otherwise>
												</c:choose>

												<c:choose>
													<c:when test="${p.acqPosEibnoiDungXuLyVS == 'VS22'}">
														<option value="VS22" selected>13.7 - Cancelled
															Merchandise/Services</option>
													</c:when>
													<c:otherwise>
														<option value="VS22">13.7 - Cancelled
															Merchandise/Services</option>
													</c:otherwise>
												</c:choose>

												<c:choose>
													<c:when test="${p.acqPosEibnoiDungXuLyVS == 'VS23'}">
														<option value="VS23" selected>13.8 - Original
															Credit Transaction Not Accepted</option>
													</c:when>
													<c:otherwise>
														<option value="VS23">13.8 - Original Credit
															Transaction Not Accepted</option>
													</c:otherwise>
												</c:choose>

												<c:choose>
													<c:when test="${p.acqPosEibnoiDungXuLyVS == 'VS24'}">
														<option value="VS24" selected>13.9 - Non-Receipt
															of Cash or Load TransactionValue Transaction Value</option>
													</c:when>
													<c:otherwise>
														<option value="VS24">13.9 - Non-Receipt of Cash
															or Load TransactionValue Transaction Value</option>
													</c:otherwise>
												</c:choose>
											</select>
										</c:when>
										<c:when
											test="${p.acqPosEibNoiDungXuLy == '6' && p.acqPosEibloaiThe == 'MC'}">
											<select style="width: 65%; float: right;" id="loaiThe"
												name="acqPosEib_noiDungXuLy_MC">

												<c:choose>
													<c:when test="${p.acqPosEibnoiDungXuLyMC == ''}">
														<option value="" selected></option>
													</c:when>
													<c:otherwise>
														<option value=""></option>
													</c:otherwise>
												</c:choose>

												<c:choose>
													<c:when test="${p.acqPosEibnoiDungXuLyMC == 'MC1'}">
														<option value="MC1" selected>4853 - Goods or
															Services Were Either Not as Described or Defective</option>
													</c:when>
													<c:otherwise>
														<option value="MC1">4853 - Goods or Services Were
															Either Not as Described or Defective</option>
													</c:otherwise>
												</c:choose>

												<c:choose>
													<c:when test="${p.acqPosEibnoiDungXuLyMC == 'MC2'}">
														<option value="MC2" selected>4583 - Goods or
															Services Not Provided</option>
													</c:when>
													<c:otherwise>
														<option value="MC2">4583 - Goods or Services Not
															Provided</option>
													</c:otherwise>
												</c:choose>

												<c:choose>
													<c:when test="${p.acqPosEibnoiDungXuLyMC == 'MC3'}">
														<option value="MC3" selected>4853 - Digital Goods
															Purchase of USD 25 or Less</option>
													</c:when>
													<c:otherwise>
														<option value="MC3">4853 - Digital Goods Purchase
															of USD 25 or Less</option>
													</c:otherwise>
												</c:choose>

												<c:choose>
													<c:when test="${p.acqPosEibnoiDungXuLyMC == 'MC4'}">
														<option value="MC4" selected>4853 - Credit Not
															Processed</option>
													</c:when>
													<c:otherwise>
														<option value="MC4">4853 - Credit Not Processed</option>
													</c:otherwise>
												</c:choose>

												<c:choose>
													<c:when test="${p.acqPosEibnoiDungXuLyMC == 'MC5'}">
														<option value="MC5" selected>4853 - Counterfeit
															Goods</option>
													</c:when>
													<c:otherwise>
														<option value="MC5">4853 - Counterfeit Goods</option>
													</c:otherwise>
												</c:choose>

												<c:choose>
													<c:when test="${p.acqPosEibnoiDungXuLyMC == 'MC6'}">
														<option value="MC6" selected>4853 - Cardholder
															Dispute of a Recurring Transaction</option>
													</c:when>
													<c:otherwise>
														<option value="MC6">4853 - Cardholder Dispute of
															a Recurring Transaction</option>
													</c:otherwise>
												</c:choose>

												<c:choose>
													<c:when test="${p.acqPosEibnoiDungXuLyMC == 'MC7'}">
														<option value="MC7" selected>4853 - Issuer
															Dispute of a Recuring Transaction</option>
													</c:when>
													<c:otherwise>
														<option value="MC7">4853 - Issuer Dispute of a
															Recuring Transaction</option>
													</c:otherwise>
												</c:choose>

												<c:choose>
													<c:when test="${p.acqPosEibnoiDungXuLyMC == 'MC8'}">
														<option value="MC8" selected>4853 - Addendum
															Dispute</option>
													</c:when>
													<c:otherwise>
														<option value="MC8">4853 - Addendum Dispute</option>
													</c:otherwise>
												</c:choose>

												<c:choose>
													<c:when test="${p.acqPosEibnoiDungXuLyMC == 'MC9'}">
														<option value="MC9" selected>4853 - "No Show"
															Hotel Charge</option>
													</c:when>
													<c:otherwise>
														<option value="MC9">4853 - "No Show" Hotel Charge</option>
													</c:otherwise>
												</c:choose>

												<c:choose>
													<c:when test="${p.acqPosEibnoiDungXuLyMC == 'MC10'}">
														<option value="MC10" selected>4853 - Transaction
															Dit Not Complete</option>
													</c:when>
													<c:otherwise>
														<option value="MC10">4853 - Transaction Dit Not
															Complete</option>
													</c:otherwise>
												</c:choose>

												<c:choose>
													<c:when test="${p.acqPosEibnoiDungXuLyMC == 'MC11'}">
														<option value="MC11" selected>4853 - Timeshares</option>
													</c:when>
													<c:otherwise>
														<option value="MC11">4853 - Timeshares</option>
													</c:otherwise>
												</c:choose>

												<c:choose>
													<c:when test="${p.acqPosEibnoiDungXuLyMC == 'MC12'}">
														<option value="MC12" selected>4853 - Credit
															Posted as a Purchase</option>
													</c:when>
													<c:otherwise>
														<option value="MC12">4853 - Credit Posted as a
															Purchase</option>
													</c:otherwise>
												</c:choose>

												<c:choose>
													<c:when test="${p.acqPosEibnoiDungXuLyMC == 'MC13'}">
														<option value="MC13" selected>4837 - No Carholder
															Authorization</option>
													</c:when>
													<c:otherwise>
														<option value="MC13">4837 - No Carholder
															Authorization</option>
													</c:otherwise>
												</c:choose>

												<c:choose>
													<c:when test="${p.acqPosEibnoiDungXuLyMC == 'MC14'}">
														<option value="MC14" selected>4840 - Fraudulent
															Processing of a Transaction(s)</option>
													</c:when>
													<c:otherwise>
														<option value="MC14">4840 - Fraudulent Processing
															of a Transaction(s)</option>
													</c:otherwise>
												</c:choose>

												<c:choose>
													<c:when test="${p.acqPosEibnoiDungXuLyMC == 'MC15'}">
														<option value="MC15" selected>4849 - Questionable
															Merchant Activity</option>
													</c:when>
													<c:otherwise>
														<option value="MC15">4849 - Questionable Merchant
															Activity</option>
													</c:otherwise>
												</c:choose>

												<c:choose>
													<c:when test="${p.acqPosEibnoiDungXuLyMC == 'MC15'}">
														<option value="MC15" selected>4849 - Questionable
															Merchant Activity</option>
													</c:when>
													<c:otherwise>
														<option value="MC15">4849 - Questionable Merchant
															Activity</option>
													</c:otherwise>
												</c:choose>

												<c:choose>
													<c:when test="${p.acqPosEibnoiDungXuLyMC == 'MC16'}">
														<option value="MC16" selected>4863 - Cardholder
															Does Not Recoginize</option>
													</c:when>
													<c:otherwise>
														<option value="MC16">4863 - Cardholder Does Not
															Recoginize</option>
													</c:otherwise>
												</c:choose>

												<c:choose>
													<c:when test="${p.acqPosEibnoiDungXuLyMC == 'MC17'}">
														<option value="MC17" selected>4870 - Chip
															Liability Shift</option>
													</c:when>
													<c:otherwise>
														<option value="MC17">4870 - Chip Liability Shift</option>
													</c:otherwise>
												</c:choose>

												<c:choose>
													<c:when test="${p.acqPosEibnoiDungXuLyMC == 'MC18'}">
														<option value="MC18" selected>4871 - Chip
															Liability Shift - Lost/Stolen/Never Received Issue (NRI)
															Fraud</option>
													</c:when>
													<c:otherwise>
														<option value="MC18">4871 - Chip Liability Shift
															- Lost/Stolen/Never Received Issue (NRI) Fraud</option>
													</c:otherwise>
												</c:choose>

												<c:choose>
													<c:when test="${p.acqPosEibnoiDungXuLyMC == 'MC19'}">
														<option value="MC19" selected>4834 - Cardholder
															Debited More than Once for the Same Goods or Services</option>
													</c:when>
													<c:otherwise>
														<option value="MC19">4834 - Cardholder Debited
															More than Once for the Same Goods or Services</option>
													</c:otherwise>
												</c:choose>

												<c:choose>
													<c:when test="${p.acqPosEibnoiDungXuLyMC == 'MC20'}">
														<option value="MC20" selected>4834 - Transaction
															Amount Differs</option>
													</c:when>
													<c:otherwise>
														<option value="MC20">4834 - Transaction Amount
															Differs</option>
													</c:otherwise>
												</c:choose>

												<c:choose>
													<c:when test="${p.acqPosEibnoiDungXuLyMC == 'MC21'}">
														<option value="MC21" selected>4834 - ATM Disputes</option>
													</c:when>
													<c:otherwise>
														<option value="MC21">4834 - ATM Disputes</option>
													</c:otherwise>
												</c:choose>

												<c:choose>
													<c:when test="${p.acqPosEibnoiDungXuLyMC == 'MC22'}">
														<option value="MC22" selected>4834 - Charges for
															Loss, Theft, or Damages</option>
													</c:when>
													<c:otherwise>
														<option value="MC22">4834 - Charges for Loss,
															Theft, or Damages</option>
													</c:otherwise>
												</c:choose>

												<c:choose>
													<c:when test="${p.acqPosEibnoiDungXuLyMC == 'MC23'}">
														<option value="MC23" selected>4834 - Late
															Presentment</option>
													</c:when>
													<c:otherwise>
														<option value="MC23">4834 - Late Presentment</option>
													</c:otherwise>
												</c:choose>

												<c:choose>
													<c:when test="${p.acqPosEibnoiDungXuLyMC == 'MC24'}">
														<option value="MC24" selected>4834 - POI Currency
															Conversion (Dynamic Currency Conversion)</option>
													</c:when>
													<c:otherwise>
														<option value="MC24">4834 - POI Currency
															Conversion (Dynamic Currency Conversion)</option>
													</c:otherwise>
												</c:choose>

												<c:choose>
													<c:when test="${p.acqPosEibnoiDungXuLyMC == 'MC25'}">
														<option value="MC25" selected>4834 - Merchant
															Credit Correcting Error Resulting in Cardholder Currency
															Exchange Loss.</option>
													</c:when>
													<c:otherwise>
														<option value="MC25">4834 - Merchant Credit
															Correcting Error Resulting in Cardholder Currency
															Exchange Loss.</option>
													</c:otherwise>
												</c:choose>
											</select>
										</c:when>
									</c:choose></td>
								<td style="width: 10%;">${p.acqPosEibCreUser}</td>
								<td style="width: 10%;"><a
									href="detail_acq_pos_eib?id=${createTimeSelected}">${createTimeSelected}</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<!-- <input style="height: 30px; width: 100px; float: left;"
					class="btn btn-danger" type="button"
					onclick="tableToExcel('testTable', 'DISPUTE-TOOL-BY-P.KTT&NHDT')"
					value="Export"> -->
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