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

.form-search-iss td {
	width: 20%;
}

.form-search-iss .form-control {
	height: 30px;
}

.checkbox-menu li label {
	display: block;
	padding: 3px 10px;
	clear: both;
	font-weight: normal;
	line-height: 1.42857143;
	color: #333;
	white-space: nowrap;
	margin: 0;
	transition: background-color .4s ease;
}

.checkbox-menu li input {
	margin: 0px 5px;
	top: 2px;
	position: relative;
}

.checkbox-menu li.active label {
	background-color: #cbcbff;
	font-weight: bold;
}

.checkbox-menu li label:hover, .checkbox-menu li label:focus {
	background-color: #f5f5f5;
}

.checkbox-menu li.active label:hover, .checkbox-menu li.active label:focus
	{
	background-color: #b8b8ff;
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
		<div class="title-content">Thêm mới case ACQ-POS-VTB</div>
		<form action="${pageContext.request.contextPath}/dmt1/create_acq_vtb"
			method="post" style="position: fixed; margin-top: 75px;">
			<table class="form-search-iss" style="width: 100%; margin-left: -5%;">
				<tr>
					<td><input name="acqPosVtb_Mid" placeholder="MID"
						class="form-control"></input></td>
					<td><input name="acqPosVtb_TxnAmt"
						placeholder="Số tiền giao dịch" class="form-control"
						onkeypress="return keyPressWord(event);"></input></td>
					<td><input name="acqPosVtb_Branch"
						placeholder="Đơn vị quản lý" class="form-control"
						onkeypress="return keyPressWord(event);"></input></td>
					<td><input name="acqPosVtb_CanBoPhuTrach"
						placeholder="Cán bộ phụ trách" class="form-control"></input></td>
					<td><input autocomplete="off" name="acqPosVtb_trxnDate"
						class="form-control" type="text"
						placeholder="Thời gian GD: dd-mm-yyyy" id="datepicker1" required /></td>
				</tr>
				<tr>
					<td><input name="acqPosVtb_MerchantName" placeholder="Tên MID"
						class="form-control"></input></td>
					<td><select style="width: 85%" class="form-control"
						id="loaiThe" name="acqPosVtb_LoaiTien">
							<option value="" selected="selected">Loại tiền GD</option>
							<option value="VND">VND</option>
							<option value="USD">USD</option>
					</select></td>
					<td><select style="width: 85%" class="form-control"
						id="loaiThe" name="acqPosVtb_loaiThe">
							<option value="" selected="selected">Loại thẻ</option>
							<option value="MC">MC</option>
							<option value="VS">VS</option>
							<option value="JCB">JCB</option>
							<option value="DCI">DCI</option>
							<option value="BNVN">BNVN</option>
							<option value="Khac">Khác</option>
					</select></td>
					<td><input name="acqPosVtb_soTheDau"
						placeholder="Số thẻ: 6 số đầu" class="form-control"
						onkeypress="return keyPressWord(event);" maxlength="6"></input></td>
					<td><input name="acqPosVtb_soTheCuoi"
						placeholder="Số thẻ: 4 số cuối" class="form-control"
						onkeypress="return keyPressWord(event);" maxlength="4"></input></td>
				</tr>
				<tr>
					<td><input name="acqPosVtb_Tid" placeholder="TID"
						class="form-control"></input></td>
					<td><input name="acqPosVtb_ApproveCode"
						placeholder="Mã chuẩn chi" class="form-control"></input></td>
					<td><select style="width: 85%" class="form-control"
						id="loaiThe" name="acqPosVtb_PosMode">
							<option value="" selected="selected">Pos mode</option>
							<option value="00">Entry mode unknown</option>
							<option value="01">Manual Entry</option>
							<option value="05">Auto-Entry Via Chip</option>
							<option value="07">Auto-Entry Via Contactless M/Chip</option>
							<option value="81">Entry via electronic commerce,
								including chip</option>
							<option value="90">Auto-Entry via magnetic stripe</option>
							<option value="91">Auto-Entry via contactless magnetic
								stripe</option>
					</select></td>
				</tr>
				<tr>
					<th colspan="5" style="color: #396691"><center>XỬ LÝ
							ĐẶC BIỆT</center></th>
				</tr>
				<tr>
					<td><input autocomplete="off" name="acqPosVtb_RecDate"
						class="form-control" type="text" value=""
						placeholder="Thời gian nhận: dd-mm-yyyy" id="datepicker2" required /></td>
					<td><input name="acqPosVtb_ThoiGianCho"
						placeholder="Thời gian chờ" class="form-control"></input></td>
					<td><select style="width: 85%" class="form-control"
						id="loaiThe" name="acqPosVtb_GdGianlan">
							<option value="" selected="selected">Giao dịch gian lận</option>
							<option value="Co">Có</option>
							<option value="Khong">Không</option>
							<option value="Chua xac dinh">Chưa xác định</option>
					</select></td>
					<td></td>
					<td></td>
				</tr>

				<tr>
					<td><select style="width: 85%" class="form-control"
						id="loaiThe" name="acqPosVtb_tamGiuBaoCo">
							<option value="" selected="selected">Tạm giữ báo có</option>
							<option value="Co">Có</option>
							<option value="Khong">Không</option>
							<option value="Chua xac dinh">Chưa xác định</option>
					</select></td>
					<td><input name="acqPosVtb_soTienTamGiuBaoCo"
						placeholder="Số tiền tạm giữ báo có" class="form-control"
						onkeypress="return keyPressWord(event);"></input></td>
					<td><input autocomplete="off" name="acqPosVtb_ThoiGianTrichNo"
						class="form-control" type="text" value="${txt_fromDate}"
						placeholder="Th.gian trích nợ: dd-mm-yyyy" id="datepicker3"
						required /></td>
					<td><select style="width: 85%" class="form-control"
						id="loaiThe" name="acqPosVtb_TinhTrangXuLy">
							<option value="" selected="selected">Tình trạng xử lý
								case</option>
							<option value="Dang xu ly">Đang xử lý</option>
							<option value="Ket thuc">Kết thúc</option>
					</select></td>
					<td><input type="file" name="acqPosVtb_File"
						placeholder="Chứng từ đính kèm" class="form-control"
						style="width: 85%"></input></td>
				</tr>
				<tr>
					<td><select style="width: 85%" class="form-control"
						id="loaiThe" name="acqPosVtb_NoiDungXuLy">
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
							<ul name="acqPosVtb_GDBatThuong"
								class="dropdown-menu checkbox-menu allow-focus"
								aria-labelledby="dropdownMenu1" style="width: 170%">

								<li><label> <input name="acqPosVtb_GDBatThuong1"
										type="checkbox" value="acqPosVtb_GDBatThuong1"> Giao
										dịch bất thường, thẻ từ
								</label></li>
								<li><label> <input name="acqPosVtb_GDBatThuong2"
										type="checkbox" value="acqPosVtb_GDBatThuong2"> Giao
										dịch bất thường, giá trị lớn, thẻ từ
								</label></li>
								<li><label> <input name="acqPosVtb_GDBatThuong3"
										type="checkbox" value="acqPosVtb_GDBatThuong3"> Giao
										dịch bất thường, MOTO
								</label></li>
								<li><label> <input name="acqPosVtb_GDBatThuong4"
										type="checkbox" value="acqPosVtb_GDBatThuong4"> Giao
										dịch bất thường, giá trị lớn, MOTO
								</label></li>
								<li><label> <input name="acqPosVtb_GDBatThuong5"
										type="checkbox" value="acqPosVtb_GDBatThuong5"> Giao
										dịch bất thường, giá trị lớn
								</label></li>
								<li><label> <input name="acqPosVtb_GDBatThuong6"
										type="checkbox" value="acqPosVtb_GDBatThuong6"> Khác
								</label></li>
							</ul>
						</div></td>
					<td><div class="dropdown" style="width: 85%">
							<button class="btn btn-default dropdown-toggle" type="button"
								id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="true">
								Y/c xuất trình chứng từ <span class="caret"></span>
							</button>
							<ul name="acqPosVtb_YCXuatTrinhChungTu"
								class="dropdown-menu checkbox-menu allow-focus"
								aria-labelledby="dropdownMenu1" style="width: 170%">

								<li><label> <input
										name="acqPosVtb_YCXuatTrinhChungTu1" type="checkbox"
										value="acqPosVtb_YCXuatTrinhChungTu1"> Chủ thẻ yêu cầu
										chứng từ có chữ ký
								</label></li>
								<li><label> <input
										name="acqPosVtb_YCXuatTrinhChungTu2" type="checkbox"
										value="acqPosVtb_YCXuatTrinhChungTu2"> Chủ thẻ không
										nhận ra giao dịch
								</label></li>
								<li><label> <input
										name="acqPosVtb_YCXuatTrinhChungTu3" type="checkbox"
										value="acqPosVtb_YCXuatTrinhChungTu3"> Chủ thẻ không
										đồng ý với số tiền trên hóa đơn
								</label></li>
								<li><label> <input
										name="acqPosVtb_YCXuatTrinhChungTu4" type="checkbox"
										value="acqPosVtb_YCXuatTrinhChungTu4"> Điều tra gian
										lận
								</label></li>
								<li><label> <input
										name="acqPosVtb_YCXuatTrinhChungTu5" type="checkbox"
										value="acqPosVtb_YCXuatTrinhChungTu5"> Khác
								</label></li>
							</ul>
						</div></td>
					<td><select style="width: 85%" class="form-control"
						id="loaiThe" name="acqPosVtb_noiDungXuLy_VS">
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
							<option value="VS5">10.5 - Visa Fraud Monitoring Program</option>
							<option value="VS6">11.1 - Card Recovery Bulletin</option>
							<option value="VS7">11.2 - Declined Authorization</option>
							<option value="VS8">11.3 - No Authorization</option>
							<option value="VS9">12.1 - Late Presentment</option>
							<option value="VS10">12.2 - Incorrect Transaction Code</option>
							<option value="VS11">12.3 - Incorrect Currency</option>
							<option value="VS12">12.4 - Incorrect Account Number</option>
							<option value="VS13">12.5 - Incorrect Amount</option>
							<option value="VS14">12.6 - Duplicate Processing/Paid by
								Other Means</option>
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
					<td><select style="width: 85%" class="form-control"
						id="loaiThe" name="acqPosVtb_noiDungXuLy_MC">
							<option value="">MC -Đòi bồi hoàn lần 1 -
								Chargeback/Dispute --------</option>
							<option value="MC1">4853 - Goods or Services Were Either
								Not as Described or Defective</option>
							<option value="MC2">4583 - Goods or Services Not
								Provided</option>
							<option value="MC3">4853 - Digital Goods Purchase of USD
								25 or Less</option>
							<option value="MC4">4853 - Credit Not Processed</option>
							<option value="MC5">4853 - Counterfeit Goods</option>
							<option value="MC6">4853 - Cardholder Dispute of a
								Recurring Transaction</option>
							<option value="MC7">4853 - Issuer Dispute of a Recuring
								Transaction</option>
							<option value="MC8">4853 - Addendum Dispute</option>
							<option value="MC9">4853 - "No Show" Hotel Charge</option>
							<option value="MC10">4853 - Transaction Dit Not Complete</option>
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
							<option value="MC19">4834 - Cardholder Debited More than
								Once for the Same Goods or Services</option>
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
				</tr>
				<tr>
					<td><input name="acqPosVtb_noiDungXuLy_Khac"
						placeholder="Nội dung xử lý khác" class="form-control"></input></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td colspan="3"><div class="form-group">
							<label style="color: #878180; font-weight: normal;">Tiến
								độ xử lý/ghi chú</label>
							<textarea name="acqPosVtb_tienDoXuLy"
								class="form-control rounded-0" id="exampleFormControlTextarea1"
								rows="10"></textarea>
						</div></td>
				</tr>
				<tr>
					<td><input type="submit" class="btn btn-success"
						style="width: 80%; height: 30px" value="LƯU THÔNG TIN" /></td>
					<td><a href="case_qua_han.html" class="btn btn-danger"
						style="width: 80%">HỦY</a></td>
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
				<tr>
					<td colspan="4"><marquee
							style="font-weight: bold; float: left; color: red; width: 30%; margin-left: 5px"
							behavior="alternate">${alert_success}</marquee></td>
				</tr>
			</table>
		</form>
	</div>
	</br>
	<div class="rightContent"
		style="margin-top: 360px; margin-left: 0px; height: 10px; position: fixed;">
		<div class="themThongTinTraSoatISS" style="height: 50px"></div>
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