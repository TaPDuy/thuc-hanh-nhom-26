# thuc-hanh-nhom-26
Bài tập thực hành của nhóm 26.

Thành viên:
- Tạ Phương Duy: làm phần backend về sửa và xóa sản phẩm
- Nguyễn Mạnh Cường: làm phần backend về thêm sản phẩm và kết nối cơ sở dữ liệu
- Phạm Văn Dũng: làm phần frontend và viết mô tả
- Mô tả cách làm:
+ Tạo 3 package: controller, model, repository trong đó controller để điều khiển các chức năng của ứng dụng, model là lớp thực thể và repository để liên kết với database
+ File Product.java chứa các thuộc tính là code, description, price
+ File index.html có câu chủ đề của project và 1 đường dẫn có tên View Product để hiện ra danh sách sản phẩm
+ File ProductController có phương thức showProducts gọi file product.html để hiển ra danh sách sản phẩm có trong cơ sở dữ liệu. showAddProduct gọi file add.html để hiện ra form cho người dùng thêm sản phẩm vào danh sách. AddProduct gọi products.html để hiện ra danh sách sản phẩm trong đó có sản phẩm đã được thêm mới. UpdateProduct sử dụng productRepository trong package ProductRepository trả về product tìm kiếm theo code, dùng phương thức save để lưu vào cơ sở dữ liệu và gọi product.html để hiện ra sản phẩm vừa được thêm. DeleteProduct dùng productRepository.deleteById để xóa sản phẩm theo code và gọi products.html để hiện ra danh sách sản phẩm
+ File products.html để hiển thị danh sách sản phẩm dưới dạng bảng
+ File add.html để hiển thị form cho người dùng thêm mới
+ File confirmDelete.html để hiển thị form xác nhận xóa sản phẩm
+ File update.html để hiển thị các thuộc tính để xóa
+ 
