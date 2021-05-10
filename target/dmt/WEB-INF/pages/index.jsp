<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TRANG CHỦ: CHƯƠNG TRÌNH LƯU TRỮ THÔNG TIN TRA SOÁT</title>
<link rel="SHORTCUT ICON"
	href="<%=request.getContextPath()%>/resources/img/logo/favicon.ico">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/style.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
.dropdown-submenu {
	position: relative;
}

.dropdown-submenu .dropdown-menu {
	top: 0;
	left: 100%;
	margin-top: -1px;
}
</style>
</head>
<body onload="startTime()">
	<header>
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

				<c:choose>
					<c:when test="${userRole == 'ADMIN'} ">
						<li class="dropdown-submenu"><a class="test" tabindex="-1"
							href="#">Người dùng<span class="caret"></span>
						</a>
							<ul class="dropdown-menu" style="background-color: #F9DF91;">
								<li><center>Người dùng</center></li>
								<li><a style="font-weight: bold;" tabindex="-1"
									href="usermanage.html"><span>DS người dùng</span></a></li>
							</ul></li>
					</c:when>
				</c:choose>

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
		<div class="dropdown" style="right: 0; left: auto;">
			<button class="btn btn-default dropdown-toggle" type="button"
				data-toggle="dropdown" aria-expanded="false">
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
	</div>

	<div class="content"></div>

	<footer></footer>
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
</body>
</html>