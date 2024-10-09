package com.example.aino.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "don_hang")
@Entity
public class DonHang {
    @Id
    /*trường id cứ là số thì tự động tăng hết kẻo lại gặp lỗi phải đặt id trước khi persist (ko cần biết trong db có đặt
    identity hay là ko, còn ko phải số thì hoặc là đặt thủ công hoặc gọi ra từ api*/
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "tong_tien", precision = 19, scale = 4)
    private BigDecimal tongTien;
    @Column(name = "thoi_gian_thanh_toan")
    private LocalDateTime thoiGianThanhToan;
    @Column(name = "hinh_thuc_thanh_toan")
    private String hinhThucThanhToan;
    @Column(name = "dia_chi_nhan_hang")
    private String diaChiNhanHang;
    @Column(name = "sdt")
    private String sdt;
    //chấp nhận null vì nhận biên lai từ đơn vị vận chuyển rồi mới có mã trong đó để cập nhật vào hóa đơn cho người dùng xem
    @Column(name = "ma_phieu_gui")
    private String maPhieuGui;
    @ManyToOne
    @JoinColumn(name = "id_nguoi_dung")
    private TaiKhoanNguoiDung taiKhoanNguoiDung;
    //jsonignore để tránh vòng lặp vô hạn khi mapping 2 chiều
    @JsonIgnore
    @OneToMany(mappedBy = "donHang")
    List<Voucher> voucher;
    @JsonIgnore
    @OneToMany(mappedBy = "donHang")
    List<GioHang> gioHang;
}
