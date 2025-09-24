<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet" />

<div class="bg-white shadow-lg rounded-lg p-8 w-full max-w-md mx-auto my-10">
    <h1 class="text-2xl font-bold mb-6 text-center">Thêm sản phẩm mới</h1>

    <form action="${pageContext.request.contextPath}/home" method="post" class="space-y-4">
        <input type="hidden" name="action" value="add" />

        <div>
            <label class="block mb-1 font-medium" for="code">Mã sản phẩm</label>
            <input type="text" id="code" name="code" required
                   class="w-full border border-gray-300 rounded px-3 py-2 focus:ring focus:ring-blue-200" />
        </div>

        <div>
            <label class="block mb-1 font-medium" for="name">Tên sản phẩm</label>
            <input type="text" id="name" name="name" required
                   class="w-full border border-gray-300 rounded px-3 py-2 focus:ring focus:ring-blue-200" />
        </div>

        <div>
            <label class="block mb-1 font-medium" for="price">Giá</label>
            <input type="number" id="price" name="price" required step="0.1"
                   class="w-full border border-gray-300 rounded px-3 py-2 focus:ring focus:ring-blue-200" />
        </div>

        <div class="flex justify-between mt-6">
            <a href="${pageContext.request.contextPath}/home"
               class="bg-gray-400 hover:bg-gray-500 text-white px-4 py-2 rounded">Quay lại</a>
            <button type="submit"
                    class="bg-blue-600 hover:bg-blue-700 text-white px-4 py-2 rounded">Thêm</button>
        </div>
    </form>
</div>