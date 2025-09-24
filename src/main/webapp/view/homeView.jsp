
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" language="java"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<div class="d-flex justify-content-between align-items-center mb-3">
  <h1>Quản lý sản phẩm</h1>
  <div class="d-flex gap-2">
    <a href="${pageContext.request.contextPath}/profile" class="btn btn-primary">Xem thông tin cá nhân</a>
    <a href="${pageContext.request.contextPath}/view/addProduct.jsp" class="btn btn-success">Thêm sản phẩm</a>
  </div>
</div>

<!-- Dropdown chọn Category -->
<form action="${pageContext.request.contextPath}/home" method="get" class="mb-3">
  <div class="row g-2 align-items-center">
    <div class="col-auto">
      <label for="categoryId" class="col-form-label fw-bold">Chọn loại sản phẩm:</label>
    </div>
    <div class="col-auto">
      <select name="categoryId" id="categoryId" class="form-select" onchange="this.form.submit()">
        <option value="">-- Tất cả --</option>
        <c:forEach var="cat" items="${categories}">
          <option value="${cat.id}"
                  <c:if test="${cat.id == selectedCategory}">selected</c:if>>
              ${cat.name}
          </option>
        </c:forEach>
      </select>
    </div>
  </div>
</form>

<!-- Bảng sản phẩm -->
<table class="table table-striped table-hover shadow-sm">
  <thead class="table-dark">
  <tr>
    <th>ID</th>
    <th>Mã SP</th>
    <th>Tên SP</th>
    <th>Giá</th>
    <th>Hành động</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="product" items="${products}">
    <tr>
      <td>${product.id}</td>
      <td>${product.code}</td>
      <td>${product.name}</td>
      <td>${product.price}</td>
      <td>
        <div class="d-flex gap-2">
          <!-- Nút sửa -->
          <form action="${pageContext.request.contextPath}/home" method="get" style="margin:0;">
            <input type="hidden" name="action" value="editForm" />
            <input type="hidden" name="id" value="${product.id}" />
            <button type="submit" class="btn btn-warning btn-sm">Sửa</button>
          </form>

          <!-- Nút xóa -->
          <form action="${pageContext.request.contextPath}/home" method="post" style="margin:0;"
                onsubmit="return confirm('Bạn có chắc muốn xóa sản phẩm này?');">
            <input type="hidden" name="action" value="delete" />
            <input type="hidden" name="productId" value="${product.id}" />
            <button type="submit" class="btn btn-danger btn-sm">Xóa</button>
          </form>
        </div>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>
