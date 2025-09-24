<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.hoangha.jpaservlet.DTO.UserDTO" %>
<%
    UserDTO user = (UserDTO) request.getAttribute("user");
    String errorMessage = (String) request.getAttribute("errorMessage");
    String successMessage = (String) request.getAttribute("successMessage");
%>

<div class='row justify-content-center'>
    <div class='col-md-8 col-lg-6'>
        <div class='card shadow-sm'>
            <div class='card-header bg-primary text-white'>
                <h4 class='card-title mb-0'><i class='bi bi-person-gear'></i> Thông tin tài khoản</h4>
            </div>
            <div class='card-body'>

                <!-- Thông báo lỗi -->
                <% if (errorMessage != null && !errorMessage.isEmpty()) { %>
                <div class='alert alert-danger' role='alert'>
                    <i class='bi bi-exclamation-triangle'></i> <%= errorMessage %>
                </div>
                <% } %>

                <!-- Thông báo thành công -->
                <% if (successMessage != null && !successMessage.isEmpty()) { %>
                <div class='alert alert-success' role='alert'>
                    <i class='bi bi-check-circle'></i> <%= successMessage %>
                </div>
                <% } %>

                <!-- Form cập nhật thông tin -->
                <form method='post' enctype='multipart/form-data' id='profileForm' action="${pageContext.request.contextPath}/profile">

                    <!-- Ảnh đại diện hiện tại -->
                    <div class='text-center mb-4'>
                        <div class='position-relative d-inline-block'>
                            <% if (user != null && user.getImageDataUri() != null && !user.getImageDataUri().isEmpty()) { %>
                            <img src='<%= user.getImageDataUri() %>' id='avatarPreview'
                                 class='rounded-circle border border-3 border-primary'
                                 width='120' height='120' style='object-fit: cover;'>
                            <% } else { %>
                            <div class='bg-secondary rounded-circle border border-3 border-primary d-flex align-items-center justify-content-center'
                                 id='avatarPreview' style='width: 120px; height: 120px;'>
                                <i class='bi bi-person-fill text-white' style='font-size: 3rem;'></i>
                            </div>
                            <% } %>
                        </div>
                        <h5 class='mt-2 mb-1'><%= user != null && user.getFull_name() != null ? user.getFull_name() : "" %></h5>
                        <small class='text-muted'>@<%= user != null ? user.getGmail() : "" %></small>
                    </div>

                    <!-- Upload ảnh đại diện -->
                    <div class='mb-3'>
                        <label for='image' class='form-label'><i class='bi bi-camera'></i> Ảnh đại diện</label>
                        <input type='file' class='form-control' id='image' name='image' accept='image/*' onchange='previewImage(this)'>
                        <div class='form-text'>Chỉ chấp nhận file ảnh (JPG, JPEG, PNG, GIF), tối đa 5MB</div>
                    </div>

                    <!-- Email (readonly) -->
                    <div class='mb-3'>
                        <label for='gmail' class='form-label'><i class='bi bi-envelope'></i> Email</label>
                        <input type='email' class='form-control' id='gmail' name='gmail'
                               value='<%= user != null ? user.getGmail() : "" %>' readonly>
                    </div>

                    <!-- Fullname -->
                    <div class='mb-3'>
                        <label for='fullname' class='form-label'><i class='bi bi-person-badge'></i> Họ và tên *</label>
                        <input type='text' class='form-control' id='fullname' name='fullname'
                               value='<%= user != null && user.getFull_name() != null ? user.getFull_name() : "" %>'
                               required maxlength='100'>
                    </div>

                    <!-- Phone -->
                    <div class='mb-4'>
                        <label for='phone' class='form-label'><i class='bi bi-telephone'></i> Số điện thoại</label>
                        <input type='tel' class='form-control' id='phone' name='phone'
                               value='<%= user != null && user.getPhone_number() != null ? user.getPhone_number() : "" %>'
                               maxlength='20' pattern="0[0-9]{9,10}"
                               title="Số điện thoại phải bắt đầu bằng 0 và có 10-11 chữ số">
                        <div class='form-text'>Định dạng: 0xxxxxxxxx (10-11 số)</div>
                    </div>

                    <!-- Address -->
                    <div class='mb-4'>
                        <label for='address' class='form-label'><i class='bi bi-geo-alt'></i> Địa chỉ</label>
                        <input type='text' class='form-control' id='address' name='address'
                               value='<%= user != null && user.getAddress() != null ? user.getAddress() : "" %>'
                               maxlength='255'>
                    </div>

                    <!-- Buttons -->
                    <div class='d-grid gap-2 d-md-flex justify-content-md-end'>
                        <a href='home' class='btn btn-outline-secondary me-md-2'>
                            <i class='bi bi-arrow-left'></i> Quay về
                        </a>
                        <button type='submit' class='btn btn-primary' id='submitBtn'>
                            <i class='bi bi-check-lg'></i> Cập nhật thông tin
                        </button>
                    </div>

                </form>
            </div>
        </div>
    </div>
</div>

<!-- JavaScript để preview ảnh và validation -->
<script>
    function previewImage(input) {
        if (input.files && input.files[0]) {
            const file = input.files[0];

            // Kiểm tra kích thước file (5MB)
            if (file.size > 30 * 1024 * 1024) {
                alert('Kích thước file không được vượt quá 5MB!');
                input.value = '';
                return;
            }

            // Kiểm tra định dạng file
            const allowedTypes = ['image/jpeg', 'image/jpg', 'image/png', 'image/gif'];
            if (!allowedTypes.includes(file.type)) {
                alert('Chỉ chấp nhận file ảnh định dạng JPG, JPEG, PNG, GIF!');
                input.value = '';
                return;
            }

            const reader = new FileReader();
            reader.onload = function(e) {
                const preview = document.getElementById('avatarPreview');

                // Nếu preview hiện tại là div (default avatar), thay thế bằng img
                if (preview.tagName === 'DIV') {
                    const img = document.createElement('img');
                    img.id = 'avatarPreview';
                    img.className = 'rounded-circle border border-3 border-primary';
                    img.style.cssText = 'width: 120px; height: 120px; object-fit: cover;';
                    img.src = e.target.result;
                    preview.parentNode.replaceChild(img, preview);
                } else {
                    // Nếu đã là img, chỉ cần thay đổi src
                    preview.src = e.target.result;
                }
            };
            reader.readAsDataURL(file);
        }
    }

    // Form validation
    document.getElementById('profileForm').addEventListener('submit', function(e) {
        const fullname = document.getElementById('fullname').value.trim();
        const phone = document.getElementById('phone').value.trim();
        const email = document.getElementById('gmail').value.trim();

        let isValid = true;
        let errorMessage = '';

        if (!email) {
            errorMessage = 'Email không được để trống!';
            isValid = false;
        } else if (!/^[A-Za-z0-9+_.-]+@([A-Za-z0-9.-]+\.[A-Za-z]{2,})$/.test(email)) {
            errorMessage = 'Email không hợp lệ!';
            isValid = false;
        }

        if (!fullname) {
            errorMessage = 'Họ và tên không được để trống!';
            isValid = false;
        }

        if (phone && !/^0[0-9]{9,10}$/.test(phone)) {
            errorMessage = 'Số điện thoại không hợp lệ! Phải bắt đầu bằng 0 và có 10-11 chữ số.';
            isValid = false;
        }

        if (!isValid) {
            e.preventDefault();
            alert(errorMessage);
        } else {
            // Disable nút submit để tránh gửi nhiều lần
            document.getElementById('submitBtn').disabled = true;
            document.getElementById('submitBtn').innerHTML = '<i class="bi bi-hourglass-split"></i> Đang xử lý...';
        }
    });
</script>