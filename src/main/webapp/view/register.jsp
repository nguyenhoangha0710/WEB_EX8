<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
  .card {
    background: rgba(255, 255, 255, 0.95);
    backdrop-filter: blur(10px);
    border-radius: 1rem;
    box-shadow: 0 10px 15px rgba(0, 0, 0, 0.1);
    animation: fadeInUp 0.6s ease-out;
    max-width: 400px;
    padding: 2rem;
    margin: 3rem auto;
    font-family: 'Inter', sans-serif;
  }
  .input-field {
    transition: all 0.3s ease;
    width: 100%;
    margin-top: 0.25rem;
    padding: 0.5rem 1rem;
    border: 1px solid #d1d5db; /* gray-300 */
    border-radius: 0.5rem;
    outline: none;
  }
  .input-field:focus {
    border-color: #3b82f6; /* blue-500 */
    box-shadow: 0 0 0 3px rgba(59, 130, 246, 0.1);
    transform: scale(1.02);
  }
  .btn {
    width: 100%;
    background-color: #2563eb; /* blue-600 */
    color: white;
    padding: 0.5rem 0;
    border-radius: 0.5rem;
    font-weight: 700;
    cursor: pointer;
    transition: all 0.3s ease;
    border: none;
    margin-top: 1.5rem;
  }
  .btn:hover {
    background-color: #1d4ed8; /* blue-700 */
    transform: translateY(-2px) scale(1.05);
  }
  .error-message {
    margin-top: 1rem;
    text-align: center;
    color: #dc2626; /* red-600 */
    font-size: 0.875rem;
    font-weight: 600;
    animation: shake 0.3s ease-in-out;
  }
  .success-message {
    margin-top: 1rem;
    text-align: center;
    color: #16a34a; /* green-600 */
    font-size: 0.875rem;
    font-weight: 600;
    animation: bounce 0.5s ease-in-out;
  }
  p.login-link {
    margin-top: 1.5rem;
    text-align: center;
    font-size: 0.875rem;
    color: #4b5563; /* gray-600 */
  }
  p.login-link a {
    color: #2563eb; /* blue-600 */
    text-decoration: none;
    transition: color 0.3s;
  }
  p.login-link a:hover {
    color: #1e40af; /* blue-800 */
    text-decoration: underline;
  }
  @keyframes shake {
    0%, 100% { transform: translateX(0); }
    25%, 75% { transform: translateX(-5px); }
    50% { transform: translateX(5px); }
  }
  @keyframes bounce {
    0%, 100% { transform: translateY(0); }
    50% { transform: translateY(-5px); }
  }
</style>

<div class="card">
  <h2 class="text-2xl font-bold text-center text-gray-800 mb-6">Đăng ký tài khoản</h2>

  <form action="${pageContext.request.contextPath}/register" method="post" class="space-y-6">
    <div>
      <label for="gmail" class="block text-sm font-medium text-gray-700">Gmail:</label>
      <input type="email" id="gmail" name="gmail" required class="input-field" />
    </div>

    <div>
      <label for="password" class="block text-sm font-medium text-gray-700">Mật khẩu:</label>
      <input type="password" id="password" name="password" required class="input-field" />
    </div>

    <div>
      <label for="confirm" class="block text-sm font-medium text-gray-700">Xác nhận mật khẩu:</label>
      <input type="password" id="confirm" name="confirm" required class="input-field" />
    </div>

    <button type="submit" class="btn">Đăng ký</button>
  </form>

  <c:if test="${not empty errorMsg}">
    <p class="error-message">${errorMsg}</p>
  </c:if>
  <c:if test="${not empty successMsg}">
    <p class="success-message">${successMsg}</p>
  </c:if>

  <p class="login-link">
    Đã có tài khoản?
    <a href="${pageContext.request.contextPath}/login">Quay lại đăng nhập</a>
  </p>
</div>