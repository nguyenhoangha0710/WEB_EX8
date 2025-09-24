<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet" />

<div class="bg-white p-8 rounded shadow-md w-96 mx-auto my-20">
    <h2 class="text-2xl font-bold mb-6 text-center text-gray-700">Đặt lại mật khẩu</h2>

    <form action="${pageContext.request.contextPath}/resetPassword" method="post" class="space-y-4">
        <!-- giữ lại email để update -->
        <input type="hidden" name="email" value="${email}" />

        <div>
            <label for="newPass" class="block text-sm font-medium text-gray-700">Mật khẩu mới:</label>
            <input type="password" id="newPass" name="newPass" required
                   class="mt-1 w-full px-4 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-500 focus:outline-none" />
        </div>

        <div>
            <label for="confirmPass" class="block text-sm font-medium text-gray-700">Xác nhận mật khẩu:</label>
            <input type="password" id="confirmPass" name="confirmPass" required
                   class="mt-1 w-full px-4 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-500 focus:outline-none" />
        </div>

        <button type="submit"
                class="w-full bg-green-600 text-white py-2 rounded-lg hover:bg-green-700 transition">
            Đặt lại mật khẩu
        </button>
    </form>

    <c:if test="${not empty errorMsg}">
        <p class="mt-4 text-red-600 text-sm text-center">${errorMsg}</p>
    </c:if>
</div>