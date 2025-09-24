<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet" />

<div class="bg-white p-8 rounded shadow-md w-96 mx-auto my-20">
    <h2 class="text-2xl font-bold mb-6 text-center text-gray-700">Quên mật khẩu</h2>

    <form action="${pageContext.request.contextPath}/forgotPassword" method="post" class="space-y-4">
        <div>
            <label for="email" class="block text-sm font-medium text-gray-700">Nhập Email của bạn:</label>
            <input type="email" id="email" name="email" required
                   class="mt-1 w-full px-4 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-500 focus:outline-none" />
        </div>

        <button type="submit"
                class="w-full bg-blue-600 text-white py-2 rounded-lg hover:bg-blue-700 transition">
            Xác nhận
        </button>

        <a href="${pageContext.request.contextPath}/loginView.jsp"
           class="block w-full text-center bg-gray-400 text-white py-2 rounded-lg hover:bg-gray-500 transition mt-2">
            Quay lại
        </a>
    </form>

    <c:if test="${not empty errorMsg}">
        <p class="mt-4 text-red-600 text-sm text-center">${errorMsg}</p>
    </c:if>
</div>