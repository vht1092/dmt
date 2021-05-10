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
		<div class="title-content">Chi tiết case ACQ POS EIB</div>

	</div>
	<div class="rightContent"
		style="margin-top: 0px; margin-left: 0px; height: 10px; position: fixed;">
		<form
			action="${pageContext.request.contextPath}/dmt1/update_acq_pos_eib"
			method="post" style="position: fixed; margin-top: 75px;">
			<table class="form-search-iss"
				style="width: 95%; height: 100px; font-size: 10px">
				<c:forEach items="${result}" var="p">
					<tr class="thongtin1">
						<td><span><a
								href="detail_acq_pos_eib_tdxl?id=${createTimeSelected}"
								style="font-size: 13px; font-style: italic; background-color: yellow;">Nội
									dung xử lý</a></span> <select style="width: 65%; float: right;"
							id="loaiThe">
								<c:choose>
									<c:when test="${p.acqPosEibNoiDungXuLy == ''}">
										<option value="" selected></option>
									</c:when>
									<c:otherwise>
										<option value=""></option>
									</c:otherwise>
								</c:choose>

								<c:choose>
									<c:when test="${p.acqPosEibNoiDungXuLy == '1'}">
										<option value="1" selected>Xác thực giao dịch bất
											thường từ SCB</option>
									</c:when>
									<c:otherwise>
										<option value="1">Xác thực giao dịch bất thường từ
											SCB</option>
									</c:otherwise>
								</c:choose>

								<c:choose>
									<c:when test="${p.acqPosEibNoiDungXuLy == '2'}">
										<option value="2" selected>Xác thực giao dịch bất
											thường từ EIB</option>
									</c:when>
									<c:otherwise>
										<option value="2">Xác thực giao dịch bất thường từ
											EIB</option>
									</c:otherwise>
								</c:choose>

								<c:choose>
									<c:when test="${p.acqPosEibNoiDungXuLy == '3'}">
										<option value="3" selected>Báo cáo gian lận</option>
									</c:when>
									<c:otherwise>
										<option value="3">Báo cáo gian lận</option>
									</c:otherwise>
								</c:choose>

								<c:choose>
									<c:when test="${p.acqPosEibNoiDungXuLy == '4'}">
										<option value="4" selected>Yêu cầu xuất trình chứng
											từOffline</option>
									</c:when>
									<c:otherwise>
										<option value="4">Yêu cầu xuất trình chứng từ -
											Offline</option>
									</c:otherwise>
								</c:choose>

								<c:choose>
									<c:when test="${p.acqPosEibNoiDungXuLy == '5'}">
										<option value="5" selected>Yêu cầu xuất trình chứng
											từRR</option>
									</c:when>
									<c:otherwise>
										<option value="5">Yêu cầu xuất trình chứng từRR</option>
									</c:otherwise>
								</c:choose>

								<c:choose>
									<c:when test="${p.acqPosEibNoiDungXuLy == '6'}">
										<option value="6" selected>Đòi bồi hoàn lần 1 -
											Chargeback/Dispute</option>
									</c:when>
									<c:otherwise>
										<option value="6">Đòi bồi hoàn lần 1 -
											Chargeback/Dispute</option>
									</c:otherwise>
								</c:choose>

								<c:choose>
									<c:when test="${p.acqPosEibNoiDungXuLy == '7'}">
										<option value="7" selected>Khác</option>
									</c:when>
									<c:otherwise>
										<option value="7">Khác</option>
									</c:otherwise>
								</c:choose>

						</select></td>

						<td><span>Thời gian nhận</span> <input
							placeholder="Thời gian GD: dd-mm-yyyy" id="datepicker1"
							style="width: 65%"
							value="${fn:substring(p.acqPosEibRecDate, 6, 8)}-${fn:substring(p.acqPosEibRecDate, 4, 6)}-${fn:substring(p.acqPosEibRecDate, 0, 4)}" /></td>
						<td><span>Thời gian chờ</span> <input style="width: 45%"
							value="${p.acqPosEibThoiGianCho}" /></td>
					</tr>
					<tr class="thongtin1">
						<td><span>GD gian lận</span> <select
							style="width: 65%; float: right;" id="loaiThe"
							name="acqPosEib_GdGianlan">
								<c:choose>
									<c:when test="${p.acqPosEibGdGianlan == ''}">
										<option value="" selected></option>
									</c:when>
									<c:otherwise>
										<option value=""></option>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${p.acqPosEibGdGianlan == 'Co'}">
										<option value="Co" selected>Có</option>
									</c:when>
									<c:otherwise>
										<option value="Co">Có</option>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${p.acqPosEibGdGianlan == 'Khong'}">
										<option value="Khong" selected>Không</option>
									</c:when>
									<c:otherwise>
										<option value="Khong">Không</option>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${p.acqPosEibGdGianlan == 'Chua xac dinh'}">
										<option value="Chua xac dinh" selected>Chưa xác định</option>
									</c:when>
									<c:otherwise>
										<option value="Chua xac dinh">Chưa xác định</option>
									</c:otherwise>
								</c:choose>
						</select></td>
						<td><span>Tạm giữ báo có</span> <select style="width: 65%"
							id="loaiThe" name="acqPosEib_tamGiuBaoCo">
								<c:choose>
									<c:when test="${p.acqPosEibtamGiuBaoCo == ''}">
										<option value="" selected></option>
									</c:when>
									<c:otherwise>
										<option value=""></option>
									</c:otherwise>
								</c:choose>

								<c:choose>
									<c:when test="${p.acqPosEibtamGiuBaoCo == 'Co'}">
										<option value="Co" selected>Có</option>
									</c:when>
									<c:otherwise>
										<option value="Co">Có</option>
									</c:otherwise>
								</c:choose>

								<c:choose>
									<c:when test="${p.acqPosEibtamGiuBaoCo == 'Khong'}">
										<option value="Khong" selected>Không</option>
									</c:when>
									<c:otherwise>
										<option value="Khong">Không</option>
									</c:otherwise>
								</c:choose>

								<c:choose>
									<c:when test="${p.acqPosEibtamGiuBaoCo == 'Chua xac dinh'}">
										<option value="Chua xac dinh" selected>Chưa xác định</option>
									</c:when>
									<c:otherwise>
										<option value="Chua xac dinh">Chưa xác định</option>
									</c:otherwise>
								</c:choose>
						</select></td>
						<td><span>Số tiền tạm giữ báo có</span> <input
							name="acqPosEib_soTienTamGiuBaoCo" style="width: 45%"
							value="${p.acqPosEibsoTienTamGiuBaoCo }" /></td>
						<td></td>
					</tr>
					<tr class="thongtin1">
						<td><span>Th/gian trích nợ</span> <input
							name="acqPosEib_ThoiGianTrichNo"
							placeholder="Thời gian GD: dd-mm-yyyy" id="datepicker2"
							style="width: 65%"
							value="${fn:substring(p.acqPosEibThoiGianTrichNo, 6, 8)}-${fn:substring(p.acqPosEibThoiGianTrichNo, 4, 6)}-${fn:substring(p.acqPosEibThoiGianTrichNo, 0, 4)}" /></td>
						<td><span>Tình trạng xử lý </span> <select style="width: 65%"
							id="loaiThe" name="acqPosEibTinhTrangXuLy">
								<c:choose>
									<c:when test="${p.acqPosEibTinhTrangXuLy == ''}">
										<option value="" selected></option>
									</c:when>
									<c:otherwise>
										<option value=""></option>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${p.acqPosEibTinhTrangXuLy == 'Dang xu ly'}">
										<option value="Dang xu ly" selected>Đang xử lý</option>
									</c:when>
									<c:otherwise>
										<option value="Dang xu ly">Đang xử lý</option>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${p.acqPosEibTinhTrangXuLy == 'Ket thuc'}">
										<option value="Ket thuc" selected>Kết thúc</option>
									</c:when>
									<c:otherwise>
										<option value="Ket thuc">Kết thúc</option>
									</c:otherwise>
								</c:choose>

						</select></td>
						<td><span>Chứng từ đính kèm</span> <input type="file"
							name="acqPosEib_File" style="width: 45%" value="" /></td>
						<td></td>
					</tr>
					<tr>
						<td><span>Lý do/RC: </span> <c:choose>
								<c:when
									test="${p.acqPosEibNoiDungXuLy == '1' || p.acqPosEibNoiDungXuLy == '2'}">
									<c:choose>
										<c:when
											test="${fn:contains(p.acqPosEibGDBatThuong1, 'acqPosEib_GDBatThuong1')}">
											<span style="color: red"> - Giao dịch bất thường, thẻ
												từ</span>
										</c:when>
									</c:choose>
									<c:choose>
										<c:when
											test="${fn:contains(p.acqPosEibGDBatThuong1, 'acqPosEib_GDBatThuong2')}">
											<span style="color: red"> - Giao dịch bất thường, giá
												trị lớn, thẻ từ</span>
										</c:when>
									</c:choose>
									<c:choose>
										<c:when
											test="${fn:contains(p.acqPosEibGDBatThuong1, 'acqPosEib_GDBatThuong3')}">
											<span style="color: red"> - Giao dịch bất thường, MOTO</span>
										</c:when>
									</c:choose>
									<c:choose>
										<c:when
											test="${fn:contains(p.acqPosEibGDBatThuong1, 'acqPosEib_GDBatThuong4')}">
											<span style="color: red"> - Giao dịch bất thường, giá
												trị lớn, MOTO</span>
										</c:when>
									</c:choose>
									<c:choose>
										<c:when
											test="${fn:contains(p.acqPosEibGDBatThuong1, 'acqPosEib_GDBatThuong5')}">
											<span style="color: red"> - Giao dịch bất thường, giá
												trị lớn</span>
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
												chữ ký</span>
										</c:when>
									</c:choose>
									<c:choose>
										<c:when
											test="${fn:contains(p.acqPosEibYCXuatTrinhChungTu1, 'acqPosEib_YCXuatTrinhChungTu2')}">
											<span style="color: red">Chủ thẻ không nhận ra giao
												dịch</span>
										</c:when>
									</c:choose>
									<c:choose>
										<c:when
											test="${fn:contains(p.acqPosEibYCXuatTrinhChungTu1, 'acqPosEib_YCXuatTrinhChungTu3')}">
												Chủ thẻ không đồng ý với số tiền trên hóa đơn</span>
										</c:when>
									</c:choose>

									<c:choose>
										<c:when
											test="${fn:contains(p.acqPosEibYCXuatTrinhChungTu1, 'acqPosEib_YCXuatTrinhChungTu4')}">
											<span style="color: red">Điều tra gian lận</span>
										</c:when>
									</c:choose>

									<c:choose>
										<c:when
											test="${fn:contains(p.acqPosEibYCXuatTrinhChungTu1, 'acqPosEib_YCXuatTrinhChungTu5')}">
											<span style="color: red">Khác</span>
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
													Shift Counterfeit Fraud</option>
											</c:when>
											<c:otherwise>
												<option value="VS1">10.1 - EMV Liability Shift
													Counterfeit Fraud</option>
											</c:otherwise>
										</c:choose>

										<c:choose>
											<c:when test="${p.acqPosEibnoiDungXuLyVS == 'VS2'}">
												<option value="VS2" selected>10.2 - EMV Liability
													Shift Non-Counterfeit Fraud</option>
											</c:when>
											<c:otherwise>
												<option value="VS2">10.2 - EMV Liability Shift
													Non-Counterfeit Fraud</option>
											</c:otherwise>
										</c:choose>

										<c:choose>
											<c:when test="${p.acqPosEibnoiDungXuLyVS == 'VS3'}">
												<option value="VS3" selected>10.3 - Other
													Fraud-Card Present Environment</option>
											</c:when>
											<c:otherwise>
												<option value="VS3">10.3 - Other Fraud-Card Present
													Environment</option>
											</c:otherwise>
										</c:choose>

										<c:choose>
											<c:when test="${p.acqPosEibnoiDungXuLyVS == 'VS4'}">
												<option value="VS4" selected>10.4 - Other
													Fraud-Card Absent Environment</option>
											</c:when>
											<c:otherwise>
												<option value="VS4">10.4 - Other Fraud-Card Absent
													Environment</option>
											</c:otherwise>
										</c:choose>

										<c:choose>
											<c:when test="${p.acqPosEibnoiDungXuLyVS == 'VS5'}">
												<option value="VS5" selected>10.5 - Visa Fraud
													Monitoring Program</option>
											</c:when>
											<c:otherwise>
												<option value="VS5">10.5 - Visa Fraud Monitoring
													Program</option>
											</c:otherwise>
										</c:choose>

										<c:choose>
											<c:when test="${p.acqPosEibnoiDungXuLyVS == 'VS6'}">
												<option value="VS6" selected>11.1 - Card Recovery
													Bulletin</option>
											</c:when>
											<c:otherwise>
												<option value="VS6">11.1 - Card Recovery Bulletin</option>
											</c:otherwise>
										</c:choose>

										<c:choose>
											<c:when test="${p.acqPosEibnoiDungXuLyVS == 'VS7'}">
												<option value="VS7" selected>11.2 - Declined
													Authorization</option>
											</c:when>
											<c:otherwise>
												<option value="VS7">11.2 - Declined Authorization</option>
											</c:otherwise>
										</c:choose>

										<c:choose>
											<c:when test="${p.acqPosEibnoiDungXuLyVS == 'VS8'}">
												<option value="VS8" selected>11.3 - No
													Authorization</option>
											</c:when>
											<c:otherwise>
												<option value="VS8">11.3 - No Authorization</option>
											</c:otherwise>
										</c:choose>

										<c:choose>
											<c:when test="${p.acqPosEibnoiDungXuLyVS == 'VS9'}">
												<option value="VS9" selected>12.1 - Late
													Presentment</option>
											</c:when>
											<c:otherwise>
												<option value="VS9">12.1 - Late Presentment</option>
											</c:otherwise>
										</c:choose>

										<c:choose>
											<c:when test="${p.acqPosEibnoiDungXuLyVS == 'VS10'}">
												<option value="VS10" selected>12.2 - Incorrect
													Transaction Code</option>
											</c:when>
											<c:otherwise>
												<option value="VS10">12.2 - Incorrect Transaction
													Code</option>
											</c:otherwise>
										</c:choose>

										<c:choose>
											<c:when test="${p.acqPosEibnoiDungXuLyVS == 'VS11'}">
												<option value="VS11" selected>12.3 - Incorrect
													Currency</option>
											</c:when>
											<c:otherwise>
												<option value="VS11">12.3 - Incorrect Currency</option>
											</c:otherwise>
										</c:choose>

										<c:choose>
											<c:when test="${p.acqPosEibnoiDungXuLyVS == 'VS12'}">
												<option value="VS12" selected>12.4 - Incorrect
													Account Number</option>
											</c:when>
											<c:otherwise>
												<option value="VS12">12.4 - Incorrect Account
													Number</option>
											</c:otherwise>
										</c:choose>

										<c:choose>
											<c:when test="${p.acqPosEibnoiDungXuLyVS == 'VS13'}">
												<option value="VS13" selected>12.5 - Incorrect
													Amount</option>
											</c:when>
											<c:otherwise>
												<option value="VS13">12.5 - Incorrect Amount</option>
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
												<option value="VS19">13.4 - Counterfeit Merchandise</option>
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
												<option value="VS24" selected>13.9 - Non-Receipt of
													Cash or Load TransactionValue Transaction Value</option>
											</c:when>
											<c:otherwise>
												<option value="VS24">13.9 - Non-Receipt of Cash or
													Load TransactionValue Transaction Value</option>
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
												<option value="MC6">4853 - Cardholder Dispute of a
													Recurring Transaction</option>
											</c:otherwise>
										</c:choose>

										<c:choose>
											<c:when test="${p.acqPosEibnoiDungXuLyMC == 'MC7'}">
												<option value="MC7" selected>4853 - Issuer Dispute
													of a Recuring Transaction</option>
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
												<option value="MC9" selected>4853 - "No Show" Hotel
													Charge</option>
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
												<option value="MC12" selected>4853 - Credit Posted
													as a Purchase</option>
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
												<option value="MC17" selected>4870 - Chip Liability
													Shift</option>
											</c:when>
											<c:otherwise>
												<option value="MC17">4870 - Chip Liability Shift</option>
											</c:otherwise>
										</c:choose>

										<c:choose>
											<c:when test="${p.acqPosEibnoiDungXuLyMC == 'MC18'}">
												<option value="MC18" selected>4871 - Chip Liability
													Shift - Lost/Stolen/Never Received Issue (NRI) Fraud</option>
											</c:when>
											<c:otherwise>
												<option value="MC18">4871 - Chip Liability Shift -
													Lost/Stolen/Never Received Issue (NRI) Fraud</option>
											</c:otherwise>
										</c:choose>

										<c:choose>
											<c:when test="${p.acqPosEibnoiDungXuLyMC == 'MC19'}">
												<option value="MC19" selected>4834 - Cardholder
													Debited More than Once for the Same Goods or Services</option>
											</c:when>
											<c:otherwise>
												<option value="MC19">4834 - Cardholder Debited More
													than Once for the Same Goods or Services</option>
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
												<option value="MC24">4834 - POI Currency Conversion
													(Dynamic Currency Conversion)</option>
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
													Correcting Error Resulting in Cardholder Currency Exchange
													Loss.</option>
											</c:otherwise>
										</c:choose>
									</select>
								</c:when>
							</c:choose></td>
						<td></td>
						<td><input type="radio" id="themMoiNoiDungXuLy"
							name="themMoiNoiDungXuLy" value="themMoiNoiDungXuLy"
							onchange="onchange_themMoiNoiDungXuLy()" /> <span for="male">Thêm
								mới ND xử lý</span> &nbsp;&nbsp; <input type="radio"
							id="huyThemMoiNoiDungXuLy" name="themMoiNoiDungXuLy"
							value="huyThemMoiNoiDungXuLy"
							onchange="onchange_huyThemMoiNoiDungXuLy()" /> <span for="male">Hủy</span></td>
					</tr>
					<tr class="thongtin1">
						<td colspan="4"><span>Tiến độ xử lý/ghi chú</span> <textarea
								class="form-control" name="acqPosEib_tienDoXuLy"
								class="rounded-0" id="exampleFormControlTextarea1" rows="4"
								cols="50" style="width: 40%">${p.acqPosEibtienDoXuLy}</textarea></td>

					</tr>
					<tr id="themNoiDungXuly1">
						<td><select style="width: 85%" id="loaiThe"
							name="acqPosEib_NoiDungXuLy" class="form-control">
								<option value="" selected="selected">Nội dung xử lý</option>
								<option value="1">Xác thực giao dịch bất thường từ SCB</option>
								<option value="2">Xác thực giao dịch bất thường từ EIB</option>
								<option value="3">Báo cáo gian lận</option>
								<option value="4">Yêu cầu xuất trình chứng từ - Offline</option>
								<option value="5">Yêu cầu xuất trình chứng từ - RR</option>
								<option value="6">Đòi bồi hoàn lần 1 -
									Chargeback/Dispute</option>
								<option value="7">Khác</option>
						</select></td>
						<td><div class="dropdown" style="width: 85%">
								<button class="btn btn-default dropdown-toggle" type="button"
									id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="true">
									Xác thực GD bất thường <span class="caret"></span>
								</button>
								<ul name="acqPosEib_GDBatThuong"
									class="dropdown-menu checkbox-menu allow-focus"
									aria-labelledby="dropdownMenu1" style="width: 170%">

									<li><label> <input name="acqPosEib_GDBatThuong1"
											type="checkbox" value="acqPosEib_GDBatThuong1"> Giao
											dịch bất thường, thẻ từ
									</label></li>
									<li><label> <input name="acqPosEib_GDBatThuong2"
											type="checkbox" value="acqPosEib_GDBatThuong2"> Giao
											dịch bất thường, giá trị lớn, thẻ từ
									</label></li>
									<li><label> <input name="acqPosEib_GDBatThuong3"
											type="checkbox" value="acqPosEib_GDBatThuong3"> Giao
											dịch bất thường, MOTO
									</label></li>
									<li><label> <input name="acqPosEib_GDBatThuong4"
											type="checkbox" value="acqPosEib_GDBatThuong4"> Giao
											dịch bất thường, giá trị lớn, MOTO
									</label></li>
									<li><label> <input name="acqPosEib_GDBatThuong5"
											type="checkbox" value="acqPosEib_GDBatThuong5"> Giao
											dịch bất thường, giá trị lớn
									</label></li>
									<li><label> <input name="acqPosEib_GDBatThuong6"
											type="checkbox" value="acqPosEib_GDBatThuong6"> Khác
									</label></li>
								</ul>
							</div></td>
						<td><div class="dropdown" style="width: 85%">
								<button class="btn btn-default dropdown-toggle" type="button"
									id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="true">
									Y/c xuất trình chứng từ <span class="caret"></span>
								</button>
								<ul name="acqPosEib_YCXuatTrinhChungTu"
									class="dropdown-menu checkbox-menu allow-focus"
									aria-labelledby="dropdownMenu1" style="width: 170%">

									<li><label> <input
											name="acqPosEib_YCXuatTrinhChungTu1" type="checkbox"
											value="acqPosEib_YCXuatTrinhChungTu1"> Chủ thẻ yêu
											cầu chứng từ có chữ ký
									</label></li>
									<li><label> <input
											name="acqPosEib_YCXuatTrinhChungTu2" type="checkbox"
											value="acqPosEib_YCXuatTrinhChungTu2"> Chủ thẻ không
											nhận ra giao dịch
									</label></li>
									<li><label> <input
											name="acqPosEib_YCXuatTrinhChungTu3" type="checkbox"
											value="acqPosEib_YCXuatTrinhChungTu3"> Chủ thẻ không
											đồng ý với số tiền trên hóa đơn
									</label></li>
									<li><label> <input
											name="acqPosEib_YCXuatTrinhChungTu4" type="checkbox"
											value="acqPosEib_YCXuatTrinhChungTu4"> Điều tra gian
											lận
									</label></li>
									<li><label> <input
											name="acqPosEib_YCXuatTrinhChungTu5" type="checkbox"
											value="acqPosEib_YCXuatTrinhChungTu5"> Khác
									</label></li>
								</ul>
							</div></td>
						<td><select class="form-control" style="width: 85%"
							id="loaiThe" name="acqPosEib_noiDungXuLy_VS">
								<option value="">VS -Đòi bồi hoàn lần 1 -
									Chargeback/Dispute --------</option>
								<option value="VS1">10.1 - EMV Liability Shift
									Counterfeit Fraud</option>
								<option value="VS2">10.2 - EMV Liability Shift
									Non-Counterfeit Fraud</option>
								<option value="VS3">10.3 - Other Fraud-Card Present
									Environment</option>
								<option value="VS4">10.4 - Other Fraud-Card Absent
									Environment</option>
								<option value="VS5">10.5 - Visa Fraud Monitoring
									Program</option>
								<option value="VS6">11.1 - Card Recovery Bulletin</option>
								<option value="VS7">11.2 - Declined Authorization</option>
								<option value="VS8">11.3 - No Authorization</option>
								<option value="VS9">12.1 - Late Presentment</option>
								<option value="VS10">12.2 - Incorrect Transaction Code</option>
								<option value="VS11">12.3 - Incorrect Currency</option>
								<option value="VS12">12.4 - Incorrect Account Number</option>
								<option value="VS13">12.5 - Incorrect Amount</option>
								<option value="VS14">12.6 - Duplicate Processing/Paid
									by Other Means</option>
								<option value="VS15">12.7 - Invalid Data</option>
								<option value="VS16">13.1 - Merchandise/Services Not
									Received</option>
								<option value="VS17">13.2 - Cancelled Recurring</option>
								<option value="VS18">13.3 - Not as Described or
									Defective Merchandise/Services</option>
								<option value="VS19">13.4 - Counterfeit Merchandise</option>
								<option value="VS20">13.5 - Misrepresentation</option>
								<option value="VS21">13.6 - Credit Not Processed</option>
								<option value="VS22">13.7 - Cancelled
									Merchandise/Services</option>
								<option value="VS23">13.8 - Original Credit Transaction
									Not Accepted</option>
								<option value="VS24">13.9 - Non-Receipt of Cash or Load
									TransactionValue Transaction Value</option>

						</select></td>

					</tr>
					<tr id="themNoiDungXuly2">
						<td><input name="acqPosEib_noiDungXuLy_Khac"
							placeholder="Nội dung xử lý khác" class="form-control"></input></td>
						<td><select style="width: 85%" class="form-control"
							id="loaiThe" name="acqPosEib_noiDungXuLy_MC">
								<option value="">MC -Đòi bồi hoàn lần 1 -
									Chargeback/Dispute --------</option>
								<option value="MC1">4853 - Goods or Services Were
									Either Not as Described or Defective</option>
								<option value="MC2">4583 - Goods or Services Not
									Provided</option>
								<option value="MC3">4853 - Digital Goods Purchase of
									USD 25 or Less</option>
								<option value="MC4">4853 - Credit Not Processed</option>
								<option value="MC5">4853 - Counterfeit Goods</option>
								<option value="MC6">4853 - Cardholder Dispute of a
									Recurring Transaction</option>
								<option value="MC7">4853 - Issuer Dispute of a Recuring
									Transaction</option>
								<option value="MC8">4853 - Addendum Dispute</option>
								<option value="MC9">4853 - "No Show" Hotel Charge</option>
								<option value="MC10">4853 - Transaction Dit Not
									Complete</option>
								<option value="MC11">4853 - Timeshares</option>
								<option value="MC12">4853 - Credit Posted as a Purchase</option>
								<option value="MC13">4837 - No Carholder Authorization</option>
								<option value="MC14">4840 - Fraudulent Processing of a
									Transaction(s)</option>
								<option value="MC15">4849 - Questionable Merchant
									Activity</option>
								<option value="MC16">4863 - Cardholder Does Not
									Recoginize</option>
								<option value="MC17">4870 - Chip Liability Shift</option>
								<option value="MC18">4871 - Chip Liability Shift -
									Lost/Stolen/Never Received Issue (NRI) Fraud</option>
								<option value="MC19">4834 - Cardholder Debited More
									than Once for the Same Goods or Services</option>
								<option value="MC20">4834 - Transaction Amount Differs</option>
								<option value="MC21">4834 - ATM Disputes</option>
								<option value="MC22">4834 - Charges for Loss, Theft, or
									Damages</option>
								<option value="MC23">4834 - Late Presentment</option>
								<option value="MC24">4834 - POI Currency Conversion
									(Dynamic Currency Conversion)</option>
								<option value="MC25">4834 - Merchant Credit Correcting
									Error Resulting in Cardholder Currency Exchange Loss.</option>
						</select></td>
						<td><input type="submit" class="btn btn-success"
							style="width: 80%; height: 30px" value="LƯU THÔNG TIN" /></td>
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