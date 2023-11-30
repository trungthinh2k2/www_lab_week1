# www_lab_week1
## I. Yêu cầu bài tập
  - Tạo một csdl có tên mydb với các bảng dữ liệu account (account_id, full_name, password, email,
phone, status), bảng role (role_id, role_name, description, status). Một account thuộc về nhiều role,
mỗi role có thể có nhiều account. Trong đó status là trường để chỉ trạng thái mẫu tin (1-active, 0-
deactive, -1-xóa)
(Tip: tạo 1 bảng thứ ba có tên grant_access (account_id, role_id, is_grant, note) với trường is_grant
nhận giá trị 0-diasable, 1-enable.)
Một bảng có tên log để ghi vết lần đăng nhập. Thông tin bao gồm: account đăng nhập, ngày giờ
đăng nhập, ngày giờ đăng xuất, ghi chú.
Tạo một jakartaEE project có tên week01_lab_HotenSv_mssv (Có thể kết nối GitHub/GitLab để
push code). Thực hiện các công việc sau:
- Tạo một servlet có tên ControlServlet (partern cùng tên). Servlet này nhận một tham số
(parameter) có tên là action. Tham số này nhận các giá trị chuỗi để chỉ các hành động
tương ứng.
- Kết nối với csdl, thực hiện các chức năng:
o Thêm, cập nhật, xóa ở các bảng đã cho.
o Đăng nhập
o Hiển thị thông tin tài khoản (nếu đăng nhập thành công)
o Hiển thị các quyền của một account.
o Hiển thị các account của một role
o Cấp quyền cho một account
o Ghi log mỗi lần account đăng nhập, đăng xuất.
- Một trang html hiển thị cửa sổ đăng nhập. Nếu đăng nhập thành công và là quyền admin
thì hiển thị trang dashboard cho phép quản lý các account khác (bao gồm các quyền thêm,
xóa, sửa và cấp quyền). Còn không (không phải admin) thì hiển thị thông tin của người
đăng nhập cùng các quyền mà người đó có.
## II. Những yêu cầu đã làm được
  ### 1. Sơ đồ CSDL
  ![CSDL_AnhXa](https://github.com/trungthinh2k2/www_lab_week1/assets/89030667/1264156a-bbd5-4b90-9545-15a6da31d4e4)
  ### 2. Trang login
  ![login](https://github.com/trungthinh2k2/www_lab_week1/assets/89030667/83b6ceac-475c-4254-95bc-5dee8a6eaed2)
  ### 3. Quyền Admin
  Admin xem danh sách các user; thực hiện thêm, xóa, sửa, cấp quyền cho user
  #### 3.1. Hiển thị list danh sách các user
  ![list](https://github.com/trungthinh2k2/www_lab_week1/assets/89030667/0dbdcf4a-e0df-4397-b317-1a179a7b0625)
  #### 3.2. Thêm 1 user
  ![insert](https://github.com/trungthinh2k2/www_lab_week1/assets/89030667/88333975-59f4-43c1-a12c-5d3c04f62082)
  #### 3.3. Sửa thông tin user
  ![update](https://github.com/trungthinh2k2/www_lab_week1/assets/89030667/74cf7d3a-20ec-41a8-ab5c-07a037c847f2)
  #### 3.4. Cấp quyền cho user
  ![capquyen](https://github.com/trungthinh2k2/www_lab_week1/assets/89030667/03894683-fa44-4f27-9281-716e06677aa9)
  #### 3.5. Xóa user
  - Hình ảnh trước khi thực hiện xóa
    ![ListAfterInsert](https://github.com/trungthinh2k2/www_lab_week1/assets/89030667/e68f4833-d921-4da6-9a0e-a32c91d6c236)
  - Hình ảnh sau khi thực hiện xóa
    ![ListAfterDelete](https://github.com/trungthinh2k2/www_lab_week1/assets/89030667/3aa6951b-e1ff-4178-bfd5-deaf51168ac3)
  ### 4. Quyền User
  #### 4.1. Hiện thị thông tin của user
  ![infor](https://github.com/trungthinh2k2/www_lab_week1/assets/89030667/8eea8069-fe52-43d1-932a-34038585ab3b)
  #### 4.2. Xem được thời gian Login
  ![AccessHistory](https://github.com/trungthinh2k2/www_lab_week1/assets/89030667/6473ab1e-cc4b-4de7-afb5-e0d94652d62b)
## II. Những hạn chế chưa làm được
  ### 1. Quyền User
  - Chưa lưu được thời gian Log out
  ![AccessHistory](https://github.com/trungthinh2k2/www_lab_week1/assets/89030667/2206382a-f1ef-447b-903b-b6bc28d414ee)

## III. Các công cụ sử dụng
 * IDE: IntelliJ
 * Web server: Tomcat
 * Database server: MySQL
